package dao;

import model.Test1;
import org.apache.ibatis.annotations.Param;

/**
 * Created by jian01.zhu on 2016/1/28.
 */
public interface Test1Mapper {

    Test1 selectByPrimaryKey(@Param("id")Long id);

    int updateByPrimaryKey(@Param("id")Long id,@Param("name")String name);
}
