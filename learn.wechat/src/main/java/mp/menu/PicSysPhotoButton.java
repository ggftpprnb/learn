package mp.menu;

/**
 * 弹出系统拍照发图
 * <p>
 * 用户点击按钮后，微信客户端将调起系统相机，完成拍照操作后，会将拍摄的相片发送给开发者，
 * 并推送事件给开发者，同时收起系统相机，随后可能会收到开发者下发的消息。
 * <p>
 * Created by zhujian on 2016/2/6.
 */
public class PicSysPhotoButton extends EventButton {

    public PicSysPhotoButton(String name,String key) {
        super.name = name;
        super.type = "pic_sysphoto";
        super.key = key;
    }
}
