package mp.result;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jian01.zhu on 2016/2/2.
 */
public class AccessTokenResult {

    /**
     * access_token : ACCESS_TOKEN
     * expires_in : 7200
     */

    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("expires_in")
    private int expiresIn;

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }
}
