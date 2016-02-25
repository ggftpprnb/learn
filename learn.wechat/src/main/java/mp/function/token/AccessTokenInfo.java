package mp.function.token;


import gson.GSonUtils;
import httpclient.HttpClientUtils;
import mp.Constants;
import mp.WeChatApiUtils;
import mp.result.AccessTokenResult;

/**
 * Created by jian01.zhu on 2016/2/3.
 */
public class AccessTokenInfo implements ITokenInfo {

    @Override
    public String getRedisKey() {
        return Constants.RedisConstants.WX_ACCESS_TOKEN_PRE + Constants.WxConstants.APP_ID;
    }

    @Override
    public String getRedisBackUpKey() {
        return Constants.RedisConstants.WX_ACCESS_TOKEN_BACK_UP_PRE + Constants.WxConstants.APP_ID;
    }

    @Override
    public String getRedisLockKey() {
        return Constants.RedisConstants.GET_ACCESS_TOKEN_LOCK;
    }

    @Override
    public String getToken() {

        String accessToken = null;

        AccessTokenResult accessTokenResult = getAccessTokenResult();
        if (accessTokenResult != null) {
            accessToken = accessTokenResult.getAccessToken();
        }

        return accessToken;
    }

    /**
     * 请求微信接口，获取accessToken
     *
     * @return
     */
    private AccessTokenResult getAccessTokenResult() {
        AccessTokenResult result = null;

        String targetUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + Constants.WxConstants.APP_ID + "&secret=" + Constants.WxConstants.APP_SECRET;

        try {
            String resp = HttpClientUtils.doGet(targetUrl);
            if (WeChatApiUtils.isRightRequest(resp)) {
                result = GSonUtils.jsonString2Obj(resp, AccessTokenResult.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
