package extendandsuper;

import java.util.List;

/**
 * Created by jian01.zhu on 2016/2/24.
 */
public class Implement implements Interface {

    @Override
    public List<Children> getChildren() {
        return null;
    }

    @Override
    public List<Father> getFather() {
        return null;
    }

    @Override
    public List<Human> getHuman() {
        return null;
    }

    @Override
    public List<Human> getMan() {
        return null;
    }

    @Override
    public void getSomeBody2(Result<? extends Human> result) {
        final Human data = result.getData();
    }

    @Override
    public void getSomeBody(Result<? super Man> result) {

        final Object data = result.getData();

    }
}
