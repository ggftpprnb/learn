/**
 * Created by jian01.zhu on 2015/12/23.
 */
public class GeoUtils {

    /**
     * 地理坐标
     */
    public enum GeographicCoordinates{
        GUANGZHOU(23.20d,113.30d),
        ;

        GeographicCoordinates(double lng, double lat) {
            this.lng = lng;
            this.lat = lat;
            lngPerMeter = 0.001/111;
            latPerMeter = 0.001/(111 * Math.cos(lng * Math.PI /180));
        }

        private double lng;             //经度
        private double lat;             //纬度
        private double lngPerMeter;     //每米多少经度
        private double latPerMeter;     //每米多少纬度

        public double getLng() {
            return lng;
        }

        public double getLat() {
            return lat;
        }

        public double getLngPerMeter() {
            return lngPerMeter;
        }

        public double getLatPerMeter() {
            return latPerMeter;
        }
    }

}
