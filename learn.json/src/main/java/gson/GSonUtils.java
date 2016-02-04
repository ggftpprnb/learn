package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by jian01.zhu on 2016/1/6.
 */
public class GSonUtils {

    private static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS = "yyyy-MM-dd HH:mm:ss";

    private static Gson defaultGSon = new GsonBuilder().setDateFormat(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS).disableHtmlEscaping().create();

    /**
     * 把对象转换成字json符串
     *
     * @param srcObj 需要转换成json字符串的对象
     * @return
     */
    public static String toJsonString(Object srcObj) {
        String jsonString = null;

        if (srcObj != null) {
            jsonString = defaultGSon.toJson(srcObj);
        }

        return jsonString;
    }

    /**
     * 把json字符串转换成对应的对象
     *
     * @param srcJson json字符串
     * @param clazz   需要转换的对象类型.class
     * @param <T>
     * @return
     */
    public static <T> T jsonString2Obj(String srcJson, Class<T> clazz) {
        T targetObj = null;

        if (!StringUtils.isBlank(srcJson) && clazz != null) {
            targetObj = defaultGSon.fromJson(srcJson, clazz);
        }

        return targetObj;
    }

    /**
     * 可以把json字符串转换成包含泛型的对象。T值，如:List<DemoResult>,CommonResult<DemoResult> </>
     * 也可以把json字符串转换成普通的对象。T值，如:DemoResult
     *
     * @param srcJson   json字符串
     * @param typeToken GSon用于把字符串转换成包含泛型的对象。TypeToken实例生成，如：new TypeToken<DemoResult>(){},new TypeToken<List<DemoResult>>(){},new TypeToken<CommonResult<DemoResult>>(){}
     * @param <T>
     * @return
     */
    public static <T> T jsonString2Obj(String srcJson, TypeToken<T> typeToken) {
        T targetObj = null;

        if (!StringUtils.isBlank(srcJson) && typeToken != null) {
            targetObj = defaultGSon.fromJson(srcJson, typeToken.getType());
        }

        return targetObj;
    }

}
