package mp;

import com.google.common.collect.Lists;
import gson.GSonUtils;
import mp.result.ChannelUrlResult;
import mp.result.Long2ShortUrlResult;
import mp.result.MaterialListResult;
import org.junit.Test;

import java.util.List;

/**
 * Created by jian01.zhu on 2016/1/20.
 */
public class WeChatApiUtilsTest {

    @Test
    public void getForeverChannelUrlResult_test(){

        String channel = "外网";
        String accessToken = "AoIS7HSqKJLr78Ec6I5ihmRceOW6zerN4XctMFkj_Li_H4t8BKGbwE7z1QkrsoX3ot2Z6D2E3BGQmzPO3MA5ns5tBslXBp15kq8_LbQbpMAQIVfAIAYQD";

        final ChannelUrlResult foreverChannelUrlResult = WeChatApiUtils.getForeverChannelUrlResult(channel, accessToken);
        System.out.println(GSonUtils.toJsonString(foreverChannelUrlResult));
    }

    @Test
    public void getLong2ShortUrlResult_test(){

        String longUrl = "http://weixin.qq.com/q/jkx9p63mekkDS34lRGTJ";
        String accessToken = "WFXQU4ZMelJCS8yZ2kB-lpsgqKVg7rMwDhtHmRnM5pmQiXg6TDUQpRKNaj0zHOgxL4k0mjErtK2yEwR7pclvR81ZH4woal0VVbGVrbdKBCoIFQjAAAROZ";

        final Long2ShortUrlResult long2ShortUrlResult = WeChatApiUtils.getLong2ShortUrlResult(longUrl, accessToken);
        System.out.println(GSonUtils.toJsonString(long2ShortUrlResult));

    }

    @Test
    public void getForeverChannelUrlAndToShortUrl_test(){
        //List<String> channels = Lists.newArrayList("网易","UC","恒大","YY","4399","汇丰","唯品会");
        //List<String> channels = Lists.newArrayList("gzbaoliao","gzshenghuo","gzbendi","gzgonglue","gzmeishi","ingz1","ingz2");
        //List<String> channels = Lists.newArrayList("保利","太平洋","37玩");
        //List<String> channels = Lists.newArrayList("广汽","宝洁","猎聘");
        //List<String> channels = Lists.newArrayList("gzshenghuo1","gzshenghuo2");
        //List<String> channels = Lists.newArrayList("合生元","德勤");
        //List<String> channels = Lists.newArrayList("高德置地");
        //List<String> channels = Lists.newArrayList("海运集团","南湖国旅","无限极","立白","丰田","索尼");
        //List<String> channels = Lists.newArrayList("酷狗","统泰","泰奇");
        //List<String> channels = Lists.newArrayList("本来生活");
        List<String> channels = Lists.newArrayList("广发互推","会员特刊");
        String accessToken = "SmLU__lum31POpGLeL30fntR0F9XXxKb-M1E8fpByLeYI2wZQAi7ZcEha-4_FUnm-iAOQ64sWN1yOIHxoHu5_iaugf1leCZEa3l4Jh98M4sSTGjAIANOB";

        channels.forEach(e->{
            ChannelUrlResult channelUrlResult = WeChatApiUtils.getForeverChannelUrlResult(e,accessToken);
            if(channelUrlResult!=null){
                //System.out.println("渠道【"+e+"】,关注URL："+channelUrlResult.getUrl());
                Long2ShortUrlResult long2ShortUrlResult = WeChatApiUtils.getLong2ShortUrlResult(channelUrlResult.getUrl(),accessToken);
                if(long2ShortUrlResult!=null){
                    System.out.println("渠道【"+e+"】,关注URL："+long2ShortUrlResult.getShortUrl());
                }
            }
        });

    }

    @Test
    public void getMaterialListResult_test(){

        Constants.MaterialType type = Constants.MaterialType.news;
        int offset = 0;
        int count = 1;
        String accessToken = "VUp2u46L721HwW4_1eA7a0zCzVqpF7Y9SVb1hQx8RgH4KmWL9s-9kOSDDoMJE-MX89DsYRZ07T9s1c3Ej4IG35uR7jDAotLHa20WLsIrUa8JIEbAEAFEA";

        final MaterialListResult materialListResult = WeChatApiUtils.getMaterialListResult(type, offset, count, accessToken);
        System.out.println(GSonUtils.toJsonString(materialListResult));
    }

    @Test
    public void test(){
        System.out.println(System.lineSeparator());
    }
}
