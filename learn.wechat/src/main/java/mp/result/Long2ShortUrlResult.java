package mp.result;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jian01.zhu on 2016/1/19.
 */
public class Long2ShortUrlResult {


    /**
     * errcode : 0
     * errmsg : ok
     * short_url : http://w.url.cn/s/AvCo6Ih
     */

    private int errcode;
    private String errmsg;
    @SerializedName("short_url")
    private String shortUrl;

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public int getErrcode() {
        return errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public String getShortUrl() {
        return shortUrl;
    }
}
