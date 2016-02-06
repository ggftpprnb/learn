package mp.button.type;

/**
 * 扫码推事件
 * <p>
 * 用户点击按钮后，微信客户端将调起扫一扫工具，完成扫码操作后显示扫描结果（如果是URL，将进入URL），
 * 且会将扫码的结果传给开发者，开发者可以下发消息
 * <p>
 * Created by zhujian on 2016/2/5.
 */
public class ScanCodePushButton extends EventButton {

    public ScanCodePushButton(String name, String key) {
        super.name = name;
        super.type = "scancode_push";
        super.key = key;
    }
}
