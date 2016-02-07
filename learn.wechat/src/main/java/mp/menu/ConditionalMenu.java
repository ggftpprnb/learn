package mp.menu;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 *
 * 个性化菜单，可面对不同的用户展示不同的菜单
 *
 * Created by zhujian on 2016/2/7.
 */
public class ConditionalMenu extends Menu {

    public ConditionalMenu(List<Button> buttons,MenuMatchRule menuMatchRule) {
        super.validateButton(buttons);
        if(menuMatchRule==null) throw new IllegalArgumentException("个性化菜单必须要有一个过滤条件");
        super.setButton(buttons);
        this.menuMatchRule = menuMatchRule;
    }

    @SerializedName("matchrule")
    private MenuMatchRule menuMatchRule;

    public MenuMatchRule getMenuMatchRule() {
        return menuMatchRule;
    }

    public void setMenuMatchRule(MenuMatchRule menuMatchRule) {
        this.menuMatchRule = menuMatchRule;
    }
}
