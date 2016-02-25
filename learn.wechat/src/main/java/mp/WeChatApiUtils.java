package mp;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import gson.GSonUtils;
import httpclient.HttpClientUtils;
import mp.function.menu.Menu;
import mp.req.GetForeverChannelUrlBody;
import mp.req.GetMaterialListBody;
import mp.req.Long2ShortUrlBody;
import mp.result.ChannelUrlResult;
import mp.result.Long2ShortUrlResult;
import mp.result.MaterialListResult;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * Created by jian01.zhu on 2016/1/20.
 */
public class WeChatApiUtils {

    /**
     * 生成带参数的永久二维码
     *
     * @param channel     渠道参数
     * @param accessToken
     * @return
     */
    public static ChannelUrlResult getForeverChannelUrlResult(String channel, String accessToken) {
        ChannelUrlResult result = null;

        if (!StringUtils.isBlank(channel)) {
            String targetUrl = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + accessToken;

            GetForeverChannelUrlBody foreverChannelUrlBody = new GetForeverChannelUrlBody();
            foreverChannelUrlBody.setActionName("QR_LIMIT_STR_SCENE");

            GetForeverChannelUrlBody.ActionInfoEntity actionInfoEntity = new GetForeverChannelUrlBody.ActionInfoEntity();

            GetForeverChannelUrlBody.ActionInfoEntity.SceneEntity sceneEntity = new GetForeverChannelUrlBody.ActionInfoEntity.SceneEntity();
            sceneEntity.setSceneStr(channel);

            actionInfoEntity.setScene(sceneEntity);

            foreverChannelUrlBody.setActionInfo(actionInfoEntity);

            final String resp = HttpClientUtils.doPost(targetUrl, GSonUtils.toJsonString(foreverChannelUrlBody));
            if (isRightRequest(resp)) {
                result = GSonUtils.jsonString2Obj(resp, ChannelUrlResult.class);
            }
        }

        return result;
    }

    /**
     * 长链接转短链接
     *
     * @param longUrl     长地址
     * @param accessToken
     * @return
     */
    public static Long2ShortUrlResult getLong2ShortUrlResult(String longUrl, String accessToken) {
        Long2ShortUrlResult result = null;
        if (!StringUtils.isBlank(longUrl)) {

            String targetUrl = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=" + accessToken;

            Long2ShortUrlBody body = new Long2ShortUrlBody();
            body.setAction("long2short");
            body.setLongUrl(longUrl);

            String resp = HttpClientUtils.doPost(targetUrl, GSonUtils.toJsonString(body));
            if (isRightRequest(resp)) {
                result = GSonUtils.jsonString2Obj(resp, Long2ShortUrlResult.class);
            }
        }

        return result;
    }

    /**
     * 获取微信素材列表
     * @param type      素材类型
     * @param offset
     * @param count
     */
    public static MaterialListResult getMaterialListResult(Constants.MaterialType type, int offset, int count, String accessToken){

        MaterialListResult result = null;

        if(type!=null && offset >=0 && count >0){
            String targetUrl = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token="+accessToken;
            GetMaterialListBody body = new GetMaterialListBody();
            body.setCount(count);
            body.setOffset(offset);
            body.setType(type);

            String resp = HttpClientUtils.doPost(targetUrl, GSonUtils.toJsonString(body));
            if (isRightRequest(resp)) {
                result = GSonUtils.jsonString2Obj(resp, MaterialListResult.class);
            }
        }

        return result;
    }


    /**
     * 创建微信菜单
     *
     * @param menu       菜单对象
     * @param accessToken
     * @return
     */
    public static boolean createMenu(Menu menu,String accessToken){
        boolean success = false;

        if(menu!=null && menu.getButton()!=null &&!menu.getButton().isEmpty()){
            String targetUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+accessToken;

            String resp = HttpClientUtils.doPost(targetUrl,GSonUtils.toJsonString(menu));
            if(isRightRequest(resp)){
                success = true;
            }
        }

        return success;
    }


    /**
     * 根据微信返回的字符串，判断请求是否正确响应。（即errcode不存在，或errcode值为0）
     *
     * @param resp 微信返回的JSON字符串
     * @return
     */
    public static boolean isRightRequest(String resp) {
        boolean isRight = false;

        if (!StringUtils.isBlank(resp)) {

            JsonParser jsonParser = new JsonParser();
            final JsonElement jsonElement = jsonParser.parse(resp);
            if (jsonElement != null && jsonElement.isJsonObject()) {
                final JsonElement errEle = jsonElement.getAsJsonObject().get("errcode");
                if (errEle == null || Objects.equals(errEle.getAsString(), "0")) {
                    isRight = true;
                }
            }
        }

        if(!isRight) System.out.println(resp);

        return isRight;
    }
}
