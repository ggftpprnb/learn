package mp.result;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jian01.zhu on 2016/2/3.
 */
public class JsApiTicketResult {


    /**
     * errcode : 0
     * errmsg : ok
     * ticket : bxLdikRXVbTPdHSM05e5u5sUoXNKd8-41ZO3MhKoyN5OfkWITDGgnr2fwJ0m9E8NYzWKVZvdVtaUgWvsdshFKA
     * expires_in : 7200
     */

    private int errcode;
    private String errmsg;
    private String ticket;
    @SerializedName("expires_in")
    private int expiresIn;

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public int getErrcode() {
        return errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public String getTicket() {
        return ticket;
    }

    public int getExpiresIn() {
        return expiresIn;
    }
}
