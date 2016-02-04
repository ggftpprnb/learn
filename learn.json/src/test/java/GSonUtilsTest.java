import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;
import gson.GSonUtils;
import model.CommonResult;
import model.DemoResult;
import model.Type;
import org.junit.Test;

import java.util.List;

/**
 * Created by jian01.zhu on 2016/1/26.
 */
public class GSonUtilsTest {

    @Test
    public void protectedConstructor_test() {
        new DemoResult() {
        };
    }

    @Test
    public void jsonString2List_test() {
        List<DemoResult> list = Lists.newArrayList();
        list.add(new DemoResult(Type.A));
        list.add(new DemoResult(Type.B));
        list.add(new DemoResult(Type.C));

        final String jsonString = GSonUtils.toJsonString(list);

        List<DemoResult> respList = GSonUtils.jsonString2Obj(jsonString, new TypeToken<List<DemoResult>>() {
        });

        respList.forEach(e -> System.out.println(e.getType()));
    }

    @Test
    public void gSonTest() {

        List<DemoResult> list = Lists.newArrayList();
        list.add(new DemoResult(Type.A));
        list.add(new DemoResult(Type.B));
        list.add(new DemoResult(Type.C));

        final String jsonString = GSonUtils.toJsonString(list);

        int n = 1000000;
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            GSonUtils.jsonString2Obj(jsonString, new TypeToken<List<DemoResult>>() {
            });
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("GSonUtils.toJsonString[" + n + "]次，时间:endTime-startTime:" + (endTime - startTime));
    }

    @Test
    public void jsonString2Generic_obj_test() {
        CommonResult<DemoResult> objResult = new CommonResult(1, "right", new DemoResult(Type.A));
        String jsonString = GSonUtils.toJsonString(objResult);
        System.out.println(jsonString);
        final CommonResult<DemoResult> respResult = GSonUtils.jsonString2Obj(jsonString, new TypeToken<CommonResult<DemoResult>>() {
        });
        System.out.println(respResult.getCode());
        System.out.println(respResult.getData().getType());
    }

    @Test
    public void jsonString2Generic_list_test() {
        CommonResult<List<DemoResult>> objResult = new CommonResult(1, "right", Lists.newArrayList(new DemoResult(Type.A)));
        String jsonString = GSonUtils.toJsonString(objResult);
        System.out.println(jsonString);
        final CommonResult<List<DemoResult>> respResult = GSonUtils.jsonString2Obj(jsonString, new TypeToken<CommonResult<List<DemoResult>>>() {
        });
        System.out.println(respResult.getCode());
        System.out.println(respResult.getData().get(0).getType());
    }
}
