package dao;

import model.Test2;
import org.apache.ibatis.annotations.Param;

/**
 * Created by jian01.zhu on 2016/1/28.
 */
public interface Test2Mapper {

    Test2 selectByPrimaryKey(@Param("id") Long id);

    int updateByPrimaryKey(@Param("id") Long id, @Param("name") String name);
}
