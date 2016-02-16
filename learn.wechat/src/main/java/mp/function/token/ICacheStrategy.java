package mp.function.token;

/**
 * Created by jian01.zhu on 2016/2/15.
 */
public interface ICacheStrategy {

    String getToken(Token token);

    String updateToken(Token token);
}
