package mp.menu;

/**
 * Created by zhujian on 2016/2/5.
 */
public final class ButtonFactory {

    /**
     * 创建【点击推事件】按钮
     *
     * @param name
     * @param key
     * @return
     */
    public static ClickButton createClickButton(String name, String key) {
        return new ClickButton(name, key);
    }

    /**
     * 创建【跳转URL】按钮
     *
     * @param name
     * @param url
     * @return
     */
    public static ViewButton createViewButton(String name, String url) {
        return new ViewButton(name, url);
    }

    /**
     * 创建【扫码推事件且弹出“消息接收中”提示框】按钮
     *
     * @param name
     * @param key
     * @return
     */
    public static ScanCodeWaitMsgButton createScanCodeWaitMsgButton(String name, String key) {
        return new ScanCodeWaitMsgButton(name, key);
    }

    /**
     * 创建【扫码推事件】按钮
     *
     * @param name
     * @param key
     * @return
     */
    public static ScanCodePushButton createScanCodePushButton(String name, String key) {
        return new ScanCodePushButton(name, key);
    }

    /**
     * 创建【弹出系统拍照发图】按钮
     *
     * @param name
     * @param key
     * @return
     */
    public static PicSysPhotoButton createPicSysPhotoButton(String name, String key) {
        return new PicSysPhotoButton(name, key);
    }

    /**
     * 创建【弹出拍照或者相册发图】按钮
     *
     * @param name
     * @param key
     * @return
     */
    public static PicPhotoOrAlbumButton createPicPhotoOrAlbumButton(String name, String key) {
        return new PicPhotoOrAlbumButton(name, key);
    }

    /**
     * 创建【弹出微信相册发图器】按钮
     *
     * @param name
     * @param key
     * @return
     */
    public static PicWeiXinButton createPicWeiXinButton(String name, String key) {
        return new PicWeiXinButton(name, key);
    }

    /**
     * 创建【弹出地理位置选择器】按钮
     *
     * @param name
     * @param key
     * @return
     */
    public static LocationSelectButton createLocationSelectButton(String name, String key) {
        return new LocationSelectButton(name, key);
    }

    /**
     * 创建【下发消息（除文本消息）】按钮
     *
     * @param name
     * @param mediaId
     * @return
     */
    public static MediaIdButton createMediaIdButton(String name, String mediaId) {
        return new MediaIdButton(name, mediaId);
    }

    /**
     * 创建【跳转图文消息URL】按钮
     *
     * @param name
     * @param mediaId
     * @return
     */
    public static ViewLimitedButton createViewLimitedButton(String name, String mediaId) {
        return new ViewLimitedButton(name, mediaId);
    }
}
