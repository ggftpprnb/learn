package mp;

import com.google.common.collect.Lists;
import gson.GSonUtils;
import mp.button.ButtonFactory;
import mp.button.Menu;
import mp.button.type.*;
import mp.result.ChannelUrlResult;
import mp.result.Long2ShortUrlResult;
import mp.result.MaterialListResult;
import mp.token.AccessTokenInfo;
import mp.token.ITokenInfo;
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
        String accessToken = "RhXs6G0gja8Fo7vUNI0OiD_ORiaWSQdvT_Em8xTWuuFdLCJH9ADVP07OYMnJ7dEZybmiEunO303g7IZKU65WBz1PJ4Fomv-XAnKDrXcfRkk_hpGNBA-KSyNGKCLKWhjdKXCgAGAGTY";

        final MaterialListResult materialListResult = WeChatApiUtils.getMaterialListResult(type, offset, count, accessToken);
        System.out.println(GSonUtils.toJsonString(materialListResult));
    }

    @Test
    public void createMenu_test(){

        String accessToken = "RhXs6G0gja8Fo7vUNI0OiD_ORiaWSQdvT_Em8xTWuuFdLCJH9ADVP07OYMnJ7dEZybmiEunO303g7IZKU65WBz1PJ4Fomv-XAnKDrXcfRkk_hpGNBA-KSyNGKCLKWhjdKXCgAGAGTY";


        SingleButton singleButton = ButtonFactory.createClickButton("点击推事件", "click");
        SingleButton viewButton = ButtonFactory.createViewButton("跳转URL","http://m.jd.com/");
        SingleButton scanCodeWaitMsgButton = ButtonFactory.createScanCodeWaitMsgButton("扫码且提示", "scanCodeWaitMsg");
        SingleButton scanCodePushButton = ButtonFactory.createScanCodePushButton("扫码推事件", "scanCodePush");
        SingleButton picSysPhotoButton = ButtonFactory.createPicSysPhotoButton("拍照发图","picSysPhoto");
        SingleButton picPhotoOrAlbumButton = ButtonFactory.createPicPhotoOrAlbumButton("拍照或相册","picPhotoOrAlbum");
        SingleButton picWeiXinButton = ButtonFactory.createPicWeiXinButton("相册","picWeiXin");
        SingleButton mediaIdButton = ButtonFactory.createMediaIdButton("下发消息","BJcD9VwSZJKydbWwTmiBDXUojg2kTuOKfad3xZEL47A");
        SingleButton viewLimitedButton = ButtonFactory.createViewLimitedButton("跳转图文","BJcD9VwSZJKydbWwTmiBDXUojg2kTuOKfad3xZEL47A");
        SingleButton locationSelectButton = ButtonFactory.createLocationSelectButton("位置","locationSelect");

        ComplexButton secondButton = new ComplexButton("混合一",Lists.newArrayList(viewButton,viewLimitedButton,mediaIdButton,scanCodePushButton,scanCodeWaitMsgButton));
        ComplexButton thirdButton = new ComplexButton("混合二",Lists.newArrayList(locationSelectButton,picPhotoOrAlbumButton,picSysPhotoButton,picWeiXinButton));

        Menu menu = new Menu(Lists.newArrayList(singleButton,secondButton,thirdButton));

        boolean success = WeChatApiUtils.createMenu(menu, accessToken);
        System.out.println(success);

    }

    @Test
    public void test(){
        System.out.println(System.lineSeparator());
    }
}
