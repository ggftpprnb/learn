package forkjoin.noreturn;

import java.util.concurrent.TimeUnit;

/**
 * Created by jian01.zhu on 2016/2/1.
 */
public class Product {

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    private String name;
    private Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.price = price;
    }
}
