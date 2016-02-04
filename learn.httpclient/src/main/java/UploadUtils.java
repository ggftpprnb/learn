import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * Created by jian01.zhu on 2016/1/19.
 */
public final class UploadUtils {

    /**
     * 上传接口
     *
     * @param file
     * @return
     */
    public static String upload(File file, String uploadUrl) {
        String url = null;
        HttpPost httpPost = new HttpPost(uploadUrl);

        final HttpEntity reqEntity = MultipartEntityBuilder.create().addBinaryBody("media", file, ContentType.MULTIPART_FORM_DATA, file.getName()).build();
        httpPost.setEntity(reqEntity);

        HttpClient httpClient = HttpClients.createDefault();
        try {
            final HttpResponse httpResponse = httpClient.execute(httpPost);
            if (Objects.equals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK)) {
                HttpEntity respEntity = httpResponse.getEntity();
                String resp = EntityUtils.toString(respEntity);
                System.out.println(resp);
            } else {
                System.out.println("code:" + httpResponse.getStatusLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return url;
    }

    public static void main(String[] args) {
        File file = new File("D:\\Users\\jian01.zhu\\Desktop\\vplus\\deploy\\组合券活动封面图\\关注图文.jpg");
        String accessToken = "lxOwpP6h2vn1VXExebTyIHUVfIrjwHVEksB4SpBOxIHLbvL8EL6r1kDRxaxTnBrYPY63AYOngeIwAcE1MqJwd0rqEHc8XcDQvr4EE7Ts7msNJIeAHAAWV";
        String type = "image";
        String uploadUrl = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=" + accessToken + "&type=" + type;

        upload(file, uploadUrl);
    }
}
