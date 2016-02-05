package xstream;

import com.thoughtworks.xstream.XStream;

/**
 * Created by jian01.zhu on 2016/2/5.
 */
public class XStreamUtilss {

    /**
     * 把对象转换成xml
     * @param obj  需要转换成xml字符串的对象
     * @return
     */
    public static String obj2xml(Object obj){
        String xml = null;

        if(obj!=null){
            XStream xStream = new XStream();
            xStream.aliasPackage("",obj.getClass().getPackage().getName());
            xml = xStream.toXML(obj);
        }

        return xml;
    }
}
