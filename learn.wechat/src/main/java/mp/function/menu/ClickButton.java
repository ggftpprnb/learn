package mp.function.menu;

/**
 * 点击推事件。
 * <p>
 * 用户点击click类型按钮后，微信服务器会通过消息接口推送消息类型为event	的结构给开发者（参考消息接口指南），
 * 并且带上按钮中开发者填写的key值，开发者可以通过自定义的key值与用户进行交互；
 * <p>
 * Created by jian01.zhu on 2016/2/5.
 */
public class ClickButton extends EventButton {

    public ClickButton(String name, String key) {
        super.name = name;
        super.type = "click";
        super.key = key;
    }

}
