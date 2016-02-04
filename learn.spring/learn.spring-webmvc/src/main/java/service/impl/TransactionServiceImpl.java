package service.impl;

import dao.Test1Mapper;
import dao.Test2Mapper;
import model.Test1;
import model.Test2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.interfaces.ITransactionService;

/**
 * Created by jian01.zhu on 2016/1/28.
 */
@Service
public class TransactionServiceImpl implements ITransactionService {

    @Autowired
    private Test1Mapper test1Mapper;

    @Autowired
    private Test2Mapper test2Mapper;

    @Override
    //@Transactional
    public void testTransaction(Integer flag) {

        long id = 1l;

        Test1 test1 = test1Mapper.selectByPrimaryKey(id);

        System.out.println(test1.getName());


        switch (flag) {
            case 1:
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }

        Test2 test2 = test2Mapper.selectByPrimaryKey(id);

        System.out.println(test2.getName());

    }
}
