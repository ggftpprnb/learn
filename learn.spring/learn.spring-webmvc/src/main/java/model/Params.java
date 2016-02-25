package model;

import java.util.Date;
import java.util.List;

/**
 * Created by jian01.zhu on 2016/2/16.
 */
public class Params {

    private List<String> imgList;

    private Date now;

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }
}
