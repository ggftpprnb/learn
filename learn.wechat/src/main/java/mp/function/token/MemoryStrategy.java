package mp.function.token;

import mp.result.AccessTokenResult;
import mp.result.JsApiTicketResult;
import org.apache.commons.lang3.StringUtils;

/**
 * 把token缓存于内存中，此方法推荐使用在单服务器的情况下。
 * 多服务器情况下使用此方法，可能导致token无效
 * Created by jian01.zhu on 2016/2/15.
 */
public class MemoryStrategy implements ICacheStrategy {

    private String accessToken;

    private String jsApiTicket;

    @Override
    public String getToken(Token token) {

        String tokenStr = null;

        switch (token) {
            case ACCESS_TOKEN:
                tokenStr = getAccessToken();
                break;
            case JS_API_TICKET:
                tokenStr = getJsApiTicket();
                break;
            default:
                break;
        }

        return tokenStr;
    }

    @Override
    public String updateToken(Token token) {
        return null;
    }

    private String getAccessToken() {

        if(StringUtils.isBlank(accessToken)) {
            synchronized (this) {
                if (StringUtils.isBlank(accessToken)) {
                    final AccessTokenResult accessTokenResult = TokenGenerator.getAccessTokenResult();
                    if (accessTokenResult != null) {
                        accessToken = accessTokenResult.getAccessToken();
                    }
                }
            }
        }

        return accessToken;
    }

    private String getJsApiTicket() {

        if(StringUtils.isBlank(jsApiTicket)){
            synchronized (this){
                if(StringUtils.isBlank(jsApiTicket)){
                    final JsApiTicketResult jsApiTicketResult = TokenGenerator.getJsApiTicketResult(getAccessToken());
                    if(jsApiTicketResult!=null){
                        jsApiTicket = jsApiTicketResult.getTicket();
                    }
                }
            }
        }

        return jsApiTicket;
    }
}
