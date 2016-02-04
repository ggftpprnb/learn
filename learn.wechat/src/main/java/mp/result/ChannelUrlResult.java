package mp.result;

/**
 * Created by jian01.zhu on 2016/1/19.
 */
public class ChannelUrlResult {
    /**
     * ticket : gQFC8ToAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL2preDlwNjNtZWtrRFMzNGxSR1RKAAIErAKfVgMEAAAAAA==
     * url : http://weixin.qq.com/q/jkx9p63mekkDS34lRGTJ
     */

    private String ticket;
    private String url;

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTicket() {
        return ticket;
    }

    public String getUrl() {
        return url;
    }
}
