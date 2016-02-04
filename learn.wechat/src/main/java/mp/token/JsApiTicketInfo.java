package mp.token;


import gson.GSonUtils;
import httpclient.HttpClientUtils;
import mp.Constants;
import mp.TokenUtils;
import mp.WeChatApiUtils;
import mp.result.JsApiTicketResult;

/**
 * Created by jian01.zhu on 2016/2/3.
 */
public class JsApiTicketInfo implements ITokenInfo {

    @Override
    public String getRedisKey() {
        return Constants.RedisConstants.WX_ACCESS_TOKEN_PRE+ Constants.WxConstants.APP_ID;
    }

    @Override
    public String getRedisBackUpKey() {
        return Constants.RedisConstants.WX_JS_API_TICKET_BACK_UP_PRE + Constants.WxConstants.APP_ID;
    }

    @Override
    public String getRedisLockKey() {
        return Constants.RedisConstants.GET_JS_API_TICKET_LOCK;
    }

    @Override
    public String getToken() {

        String jsApiTicket = null;

        JsApiTicketResult jsApiTicketResult = getJsApiTicketResult();
        if(jsApiTicketResult!=null){
            jsApiTicket = jsApiTicketResult.getTicket();
        }

        return jsApiTicket;
    }

    private JsApiTicketResult getJsApiTicketResult(){
        JsApiTicketResult result = null;

        String targetUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+ TokenUtils.getAccessToken()+"&type=jsapi";

        try {
            String resp = HttpClientUtils.doGet(targetUrl);
            if(WeChatApiUtils.isRightRequest(resp)){
                result = GSonUtils.jsonString2Obj(resp, JsApiTicketResult.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
