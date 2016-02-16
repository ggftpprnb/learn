package mp.function.menu;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 共六个字段，均可为空，但不能全部为空，至少要有一个匹配信息是不为空的。
 * country、province、city组成地区信息，将按照country、province、city的顺序进行验证，要符合地区信息表的内容。
 * 地区信息从大到小验证，小的可以不填，即若填写了省份信息，则国家信息也必填并且匹配，城市信息可以不填。
 * 例如 “中国 广东省 广州市”、“中国 广东省”都是合法的地域信息，而“中国 广州市”则不合法，因为填写了城市信息但没有填写省份信息。
 * Created by zhujian on 2016/2/7.
 */
public class MenuMatchRule {

    public MenuMatchRule(List<MenuCondition> menuConditions) {
        if(menuConditions==null || menuConditions.size()==0){
            throw new IllegalArgumentException("个性化菜单至少要有一个过滤条件");
        }

        for(int i=0;i<menuConditions.size();i++){
            MenuCondition condition = menuConditions.get(i);
            if(condition instanceof MenuCondition.GroupId){
                this.groupId = ((MenuCondition.GroupId) condition).getGroupId();
            }else if(condition instanceof MenuCondition.Sex){
                this.sex = ((MenuCondition.Sex) condition).getSex();
            }else if(condition instanceof MenuCondition.Country){
                this.country = ((MenuCondition.Country) condition).getCountry();
            }else if(condition instanceof MenuCondition.Province){
                this.province = ((MenuCondition.Province) condition).getProvince();
            }else if (condition instanceof MenuCondition.City){
                this.city = ((MenuCondition.City) condition).getCity();
            }else if(condition instanceof MenuCondition.ClientPlatformType){
                this.clientPlatformType = ((MenuCondition.ClientPlatformType) condition).getPlatform();
            }else if(condition instanceof MenuCondition.Language){
                this.language = ((MenuCondition.Language) condition).getLanguage();
            }
        }

        validate();
    }

    /**
     * 验证条件是否正确
     */
    private void validate(){
        if(StringUtils.isNoneBlank(city)){
            if(StringUtils.isBlank(province)){
                throw new IllegalArgumentException("设置了城市，必须要设置省份");
            }

            if (StringUtils.isBlank(country)){
                throw new IllegalArgumentException("设置了城市，必须要设置国家");
            }
        }

        if (StringUtils.isNoneBlank(province)){
            if (StringUtils.isBlank(country)){
                throw new IllegalArgumentException("设置了省份，必须要设置国家");
            }
        }
    }

    /**
     * group_id : 2
     * sex : 1
     * country : 中国
     * province : 广东
     * city : 广州
     * client_platform_type : 2
     * language : zh_CN
     */

    @SerializedName("group_id")
    private String groupId;
    private String sex;
    private String country;
    private String province;
    private String city;
    @SerializedName("client_platform_type")
    private String clientPlatformType;
    private String language;

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setClientPlatformType(String clientPlatformType) {
        this.clientPlatformType = clientPlatformType;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getSex() {
        return sex;
    }

    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getClientPlatformType() {
        return clientPlatformType;
    }

    public String getLanguage() {
        return language;
    }
}
