package mp.function.menu;

import java.util.List;

/**
 * Created by zhujian on 2016/2/7.
 */
public class DefaultMenu extends Menu{
    public DefaultMenu(List<Button> buttons) {
        super.validateButton(buttons);
        super.setButton(buttons);
    }
}
