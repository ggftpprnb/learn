package mp.menu;

import com.google.gson.annotations.SerializedName;

/**
 * 下发消息（除文本消息）
 * <p>
 * 用户点击media_id类型按钮后，微信服务器会将开发者填写的永久素材id对应的素材下发给用户，
 * 永久素材类型可以是图片、音频、视频、图文消息。
 * 请注意：永久素材id必须是在“素材管理/新增永久素材”接口上传后获得的合法id。
 * <p>
 * Created by zhujian on 2016/2/6.
 */
public class MediaIdButton extends SingleButton {

    @SerializedName("media_id")
    private String mediaId;

    public MediaIdButton(String name,String mediaId) {
        super.name = name;
        super.type = "media_id";
        this.mediaId = mediaId;
    }
}
