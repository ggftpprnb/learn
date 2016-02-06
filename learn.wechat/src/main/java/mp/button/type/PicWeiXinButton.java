package mp.button.type;

/**
 * 弹出微信相册发图器
 * <p>
 * 用户点击按钮后，微信客户端将调起微信相册，完成选择操作后，将选择的相片发送给开发者的服务器，
 * 并推送事件给开发者，同时收起相册，随后可能会收到开发者下发的消息。
 * <p>
 * Created by zhujian on 2016/2/6.
 */
public class PicWeiXinButton extends EventButton {

    public PicWeiXinButton(String name, String key) {
        super.name = name;
        super.type = "pic_weixin";
        super.key = key;
    }
}
