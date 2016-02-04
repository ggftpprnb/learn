package model;

/**
 * Created by jian01.zhu on 2016/1/11.
 */
public class DemoResult {

    protected DemoResult(){
        //System.out.println("不同包，非继承的类，居然可以调用protected构造方法");
    }

    public DemoResult(Type type) {
        this.type = type;
    }

    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
