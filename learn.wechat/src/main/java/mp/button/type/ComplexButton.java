package mp.button.type;

import com.google.gson.annotations.SerializedName;
import mp.button.Button;

import java.util.List;

/**
 * Created by jian01.zhu on 2016/2/5.
 */
public class ComplexButton extends Button {

    public ComplexButton(String name,List<SingleButton> subButton) {
        super.name = name;
        this.subButton = subButton;
    }

    @SerializedName("sub_button")
    private List<SingleButton> subButton;

    public List<SingleButton> getSubButton() {
        return subButton;
    }

    public void setSubButton(List<SingleButton> subButton) {
        this.subButton = subButton;
    }
}
