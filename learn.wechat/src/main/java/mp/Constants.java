package mp;

/**
 * Created by jian01.zhu on 2016/1/21.
 */
public class Constants {

    /**
     * 微信公众号的一些常量，如appId，appSecret等
     */
    public static class WxConstants {
        public static final String APP_ID = "";
        public static final String APP_SECRET = "";
    }

    /**
     * 微信素材类型
     */
    public enum MaterialType {
        image,
        video,
        voice,
        news,;
    }

    /**
     * redis相关的常量
     */
    public static class RedisConstants {

        /**
         * 默认的无效值，多数情况下，结合ICache 的 setnx,getUsefulValue,delAndSetUselessValue三个方法使用
         */
        public static final String DEFAULT_USELESS_VALUE = "default_useless_value";


        /**
         * 1分钟缓存时间
         */
        public static final int ONE_MINUTES = 60;

        /**
         * 1小时缓存时间
         */
        public static final int ONE_HOUR = 60 * 60;

        /**
         * 半小时缓存时间
         */
        public static final int HALF_AN_HOUR = 30 * 60;

        /**
         * access_token 的 key
         */
        public static final String WX_ACCESS_TOKEN_PRE = "wx_access_token_pre_";

        /**
         * access_token 的key，作备份用，当更新WX_ACCESS_TOKEN_PRE时，此WX_ACCESS_TOKEN_BACK_UP_PRE值才会派上用场
         */
        public static final String WX_ACCESS_TOKEN_BACK_UP_PRE = "wx_access_token_back_up_pre_";

        /**
         * 调用微信API，获取accessToken时，通过redis来锁定，若redis中存在此值，则表示已经有另一台机器进行请求，此机器进行等待
         */
        public static final String GET_ACCESS_TOKEN_LOCK = "get_access_token_lock";

        /**
         * jsapi_ticket 的key
         */
        public static final String WX_JS_API_TICKET_PRE = "wx_js_api_ticket_pre_";

        /**
         * jsapi_ticket 的key，作备份用，WX_JS_API_TICKET_PRE，此WX_JS_API_TICKET_BACK_UP_PRE值才会派上用场
         */
        public static final String WX_JS_API_TICKET_BACK_UP_PRE = "wx_js_api_ticket_back_up_pre_";

        /**
         * 调用微信API，获取jsApiTicket时，通过redis来锁定，若redis中存在此值，则表示已经有另一台机器进行请求，此机器进行等待
         */
        public static final String GET_JS_API_TICKET_LOCK = "get_js_api_ticket_lock";

    }
}
