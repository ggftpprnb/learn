package mp.menu;

import java.util.List;

/**
 * Created by zhujian on 2016/2/7.
 */
public class MenuFactory {

    public static DefaultMenu createDefaultMenu(List<Button> buttons){
        return new DefaultMenu(buttons);
    }

    public static ConditionalMenu createConditionalMenu(List<MenuCondition> menuConditions,List<Button> buttons){
        return new ConditionalMenu(buttons,new MenuMatchRule(menuConditions));
    }
}
