package mp.function.menu;

/**
 * Created by zhujian on 2016/2/7.
 */
public abstract class MenuCondition {


    /**
     * 用户分组
     */
    public static class GroupId extends MenuCondition {
        private String groupId;     //用户分组ID

        public GroupId(String groupId) {
            this.groupId = groupId;
        }

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }
    }

    /**
     * 性别
     */
    public static class Sex extends MenuCondition {

        private String sex;         //性别对应的值

        public Sex(String sex) {
            this.sex = sex;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }

    /**
     * 用户在微信中设置的国家
     */
    public static class Country extends MenuCondition {
        private String country;     //国家

        public Country(String country) {
            this.country = country;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }

    /**
     * 用户在微信中设置的省份
     */
    public static class Province extends MenuCondition {
        private String province;    //省份

        public Province(String province) {
            this.province = province;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }
    }

    /**
     * 用户在微信中设置的城市
     */
    public static class City extends MenuCondition {
        private String city;

        public City(String city) {
            this.city = city;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }

    /**
     * 用户手机的操作系统
     */
    public static class ClientPlatformType extends MenuCondition {

        private String platform;

        public ClientPlatformType(String platform) {
            this.platform = platform;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }


    }

    /**
     * 用户在微信中设置的语言
     */
    public static class Language extends MenuCondition {
        private String language;

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public Language(String language) {

            this.language = language;
        }
    }
}
