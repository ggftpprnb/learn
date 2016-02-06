package mp.button.type;

/**
 *
 * 弹出地理位置选择器
 *
 * 用户点击按钮后，微信客户端将调起地理位置选择工具，完成选择操作后，
 * 将选择的地理位置发送给开发者的服务器，同时收起位置选择工具，随后可能会收到开发者下发的消息。
 *
 * Created by zhujian on 2016/2/6.
 */
public class LocationSelectButton extends EventButton {

    public LocationSelectButton(String name,String key) {
        super.name = name;
        super.type = "location_select";
        super.key = key;
    }
}
