package mp.button.type;

/**
 * 跳转URL
 * <p>
 * 用户点击view类型按钮后，微信客户端将会打开开发者在按钮中填写的网页URL，
 * 可与网页授权获取用户基本信息接口结合，获得用户基本信息
 * <p>
 * Created by zhujian on 2016/2/5.
 */
public class ViewButton extends SingleButton {

    private String url;

    public ViewButton(String name, String url) {
        super.name = name;
        super.type = "view";
        this.url = url;
    }
}
