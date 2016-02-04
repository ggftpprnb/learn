package mp.token;

/**
 * Created by jian01.zhu on 2016/2/3.
 */
public interface ITokenInfo {


    /**
     * 使用redis进行进程锁，获取进程锁的key
     * @return
     */
    String getRedisLockKey();


    /**
     * 获取令牌的redis key
     * @return
     */
    String getRedisKey();


    /**
     * 获取令牌的备份redis key
     * @return
     */
    String getRedisBackUpKey();

    /**
     * 获取新的令牌
     * @return
     */
    String getToken();

}
