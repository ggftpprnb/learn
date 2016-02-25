package extendandsuper;

import java.util.List;

/**
 * Created by jian01.zhu on 2016/2/24.
 */
public interface Interface {

    List<? extends Father> getChildren();

    List<? extends Father> getFather();

    List<? super Human> getHuman();

    List<? super Man> getMan();


    void getSomeBody(Result<? super Man> result);

    void getSomeBody2(Result<? extends Human> result);

}
