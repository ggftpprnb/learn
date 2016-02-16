package mp;

import mp.function.token.AccessTokenInfo;
import mp.function.token.ITokenInfo;
import org.junit.Test;

/**
 * Created by jian01.zhu on 2016/2/4.
 */
public class TokenUtilsTest {

    @Test
    public void getAccessToken_test(){
        System.out.println("getAccessToken_test");
        final String accessToken = TokenUtils.getAccessToken();
        System.out.println(accessToken);
    }

    @Test
    public void getJsApiTicket_test(){
        final String jsApiTicket = TokenUtils.getJsApiTicket();
        System.out.println(jsApiTicket);
    }

    @Test
    public void accessToken_test(){
        ITokenInfo tokenInfo = new AccessTokenInfo();
        String token = tokenInfo.getToken();
        System.out.println(token);
    }
}
