package concurrent;

import org.junit.Test;

import java.util.Hashtable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jian01.zhu on 2016/2/4.
 */
public class ConcurrentHashMapTest {

    @Test
    public void hashTable_test(){
        Hashtable<String,String> hashTable = new Hashtable<>();
        hashTable.put("key","value");
        hashTable.put("key1","value1");

        CompletableFuture.runAsync(()->{
            System.out.println(hashTable.get("key"));
        });
    }

    @Test
    public void concurrentHashMap_test() {
        ConcurrentHashMap hashMap = new ConcurrentHashMap();
        //hashMap.put()
    }
}
