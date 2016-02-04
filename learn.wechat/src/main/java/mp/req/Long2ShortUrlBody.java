package mp.req;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jian01.zhu on 2016/1/20.
 */
public class Long2ShortUrlBody {

    /**
     * action : long2short
     * long_url : http://wap.koudaitong.com/v2/showcase/goods?alias=128wi9shh&spm=h56083&redirect_count=1
     */

    private String action;
    @SerializedName("long_url")
    private String longUrl;

    public void setAction(String action) {
        this.action = action;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getAction() {
        return action;
    }

    public String getLongUrl() {
        return longUrl;
    }
}
