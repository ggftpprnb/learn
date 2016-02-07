package mp.menu;

/**
 * 弹出拍照或者相册发图
 * <p>
 * 用户点击按钮后，微信客户端将弹出选择器供用户选择“拍照”或者“从手机相册选择”。用户选择后即走其他两种流程。
 * <p>
 * Created by zhujian on 2016/2/6.
 */
public class PicPhotoOrAlbumButton extends EventButton {

    public PicPhotoOrAlbumButton(String name, String key) {
        super.name = name;
        super.type = "pic_photo_or_album";
        super.key = key;
    }
}
