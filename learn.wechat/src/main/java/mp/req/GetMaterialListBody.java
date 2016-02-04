package mp.req;

import mp.Constants;

/**
 * Created by jian01.zhu on 2016/1/21.
 */
public class GetMaterialListBody {

    private Constants.MaterialType type;        //素材类型
    private int offset;
    private int count;

    public Constants.MaterialType getType() {
        return type;
    }

    public void setType(Constants.MaterialType type) {
        this.type = type;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
