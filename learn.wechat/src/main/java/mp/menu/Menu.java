package mp.menu;

import java.util.List;

/**
 * Created by jian01.zhu on 2016/2/5.
 */
public abstract class Menu {


    /**
     * 创建菜单对象时，验证菜单按钮是否正确
     * @param buttons
     */
    protected void validateButton(List<Button> buttons){
        if(buttons==null || buttons.isEmpty()){
            throw new IllegalArgumentException("按钮为空");
        }

        if(buttons.size()>3){
            throw new IllegalArgumentException("最多设置三个一级菜单");
        }

        buttons.forEach(b->{
            if(b instanceof ComplexButton){
                ComplexButton complexButton = (ComplexButton) b;
                if(complexButton.getSubButton()==null || complexButton.getSubButton().isEmpty()){
                    throw new IllegalArgumentException("至少要有一个二级菜单");
                }

                if(complexButton.getSubButton().size()>5){
                    throw new IllegalArgumentException("最多有五个二级菜单");
                }
            }
        });
    }

    private List<Button> button;

    public List<Button> getButton() {
        return button;
    }

    public void setButton(List<Button> button) {
        this.button = button;
    }
}
