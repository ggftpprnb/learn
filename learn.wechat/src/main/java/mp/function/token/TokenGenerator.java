package mp.function.token;

import gson.GSonUtils;
import httpclient.HttpClientUtils;
import mp.Constants;
import mp.TokenUtils;
import mp.WeChatApiUtils;
import mp.result.AccessTokenResult;
import mp.result.JsApiTicketResult;

/**
 * Created by jian01.zhu on 2016/2/15.
 */
public class TokenGenerator {

    /**
     * 请求微信接口，获取accessToken
     *
     * @return
     */
    public static AccessTokenResult getAccessTokenResult() {
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

    /**
     * 请求微信接口，获取jsApiTicket
     *
     * @return
     */
    public static JsApiTicketResult getJsApiTicketResult(String accessToken) {
        JsApiTicketResult result = null;

        String targetUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + accessToken + "&type=jsapi";

        try {
            String resp = HttpClientUtils.doGet(targetUrl);
            if (WeChatApiUtils.isRightRequest(resp)) {
                result = GSonUtils.jsonString2Obj(resp, JsApiTicketResult.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
