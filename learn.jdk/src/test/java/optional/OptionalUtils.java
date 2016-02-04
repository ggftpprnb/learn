package optional;

import org.junit.Test;

import java.util.Optional;

/**
 * Created by jian01.zhu on 2016/1/15.
 */
public class OptionalUtils {

    @Test
    public void optionalString(){
        Optional<String> stringOptional = Optional.of("1");

        System.out.println(stringOptional.orElse("fsd"));

        stringOptional.map(Integer::parseInt).ifPresent(e-> System.out.println(e instanceof Integer));

        Optional<String> emptyOptional = Optional.empty();
        String abcd = emptyOptional.orElse("abcd");
        System.out.println(abcd);


    }
}
