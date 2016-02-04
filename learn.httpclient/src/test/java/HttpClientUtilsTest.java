import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import httpclient.HttpClientUtils;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * Created by jian01.zhu on 2016/1/27.
 */
public class HttpClientUtilsTest {

    @Test
    public void doGet_test(){
        String resp = HttpClientUtils.doGet("http://localhost:8080/vplus-internal/channel/channelSubscribeMsg");
        System.out.println(resp);
    }

    @Test
    public void doGet_test2(){
        Long beginTime = System.currentTimeMillis();
        String resp = HttpClientUtils.doGet("https://www.google.com",5);
        System.out.println(resp);
        Long endTime = System.currentTimeMillis();
        System.out.println("[endTime-beginTime:]"+(endTime-beginTime));
    }

    @Test
    public void doFormPost(){
        String url = "http://localhost:8080/vplus-internal/commonsUpload";
        Map<String,List<String>> formData = Maps.newHashMap();
        formData.put("repo", Lists.newArrayList("中文"));

        Map<String,File> fileData = Maps.newHashMap();
        File file = new File("D:\\Users\\jian01.zhu\\Desktop\\vplus\\deploy\\组合券活动封面图\\关注图文.jpg");
        fileData.put("file",file);

        final String resp = HttpClientUtils.doPost(url, formData, fileData);
        System.out.println(resp);
    }
}
