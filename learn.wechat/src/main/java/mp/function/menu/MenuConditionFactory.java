package mp.function.menu;

/**
 * Created by zhujian on 2016/2/7.
 */
public class MenuConditionFactory {

    public enum Gender {
        MALE("1"),              //男性
        FEMALE("2");            //女性

        Gender(String value) {
            this.value = value;
        }

        private String value;

        public String getValue() {
            return value;
        }

    }

    public enum Platform {
        IOS("1"),              //IOS
        ANDROID("2"),          //android
        OTHERS("3"),           //其它
        ;

        Platform(String value) {
            this.value = value;
        }

        private String value;

        public String getValue() {
            return value;
        }

    }

    public static MenuCondition.GroupId createGroupIdCondition(String groupId) {
        return new MenuCondition.GroupId(groupId);
    }

    public static MenuCondition.Sex createSexCondition(Gender gender) {
        return new MenuCondition.Sex(gender.getValue());
    }

    public static MenuCondition.Country createCountryCondition(String country) {
        return new MenuCondition.Country(country);
    }

    public static MenuCondition.Province createProvinceCondition(String province) {
        return new MenuCondition.Province(province);
    }

    public static MenuCondition.City createCityCondition(String city) {
        return new MenuCondition.City(city);
    }

    public static MenuCondition.Language createLanguageCondition(String language) {
        return new MenuCondition.Language(language);
    }

    public static MenuCondition.ClientPlatformType createPlatformCondition(Platform platform) {
        return new MenuCondition.ClientPlatformType(platform.getValue());
    }
}
