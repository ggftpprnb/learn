package mp.token;

/**
 * Created by jian01.zhu on 2016/2/3.
 */
public interface ITokenInfo {


    /**
     * ʹ��redis���н���������ȡ��������key
     * @return
     */
    String getRedisLockKey();


    /**
     * ��ȡ���Ƶ�redis key
     * @return
     */
    String getRedisKey();


    /**
     * ��ȡ���Ƶı���redis key
     * @return
     */
    String getRedisBackUpKey();

    /**
     * ��ȡ�µ�����
     * @return
     */
    String getToken();

}
