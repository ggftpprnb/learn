package mp.button.type;

import gson.GSonUtils;

/**
 * Created by jian01.zhu on 2016/2/5.
 */
public class ClickButton extends SingleButton {

    private String key;

    public ClickButton(String name,String key) {
        super.name = name;
        super.type = "click";
        this.key = key;
    }

    public static void main(String[] args) {
        ClickButton clickButton = new ClickButton("点击菜单","kekeke");

        System.out.println(GSonUtils.toJsonString(clickButton));
    }
}
