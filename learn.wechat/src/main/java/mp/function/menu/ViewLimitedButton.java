package mp.function.menu;

import com.google.gson.annotations.SerializedName;

/**
 *
 * 跳转图文消息URL
 *
 * 用户点击view_limited类型按钮后，微信客户端将打开开发者在按钮中填写的永久素材id对应的图文消息URL，
 * 永久素材类型只支持图文消息。
 * 请注意：永久素材id必须是在“素材管理/新增永久素材”接口上传后获得的合法id。
 *
 * Created by zhujian on 2016/2/6.
 */
public class ViewLimitedButton extends SingleButton{
    @SerializedName("media_id")
    private String mediaId;

    public ViewLimitedButton(String name, String mediaId) {
        super.name = name;
        super.type = "view_limited";
        this.mediaId = mediaId;
    }
}
