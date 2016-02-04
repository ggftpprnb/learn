package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.interfaces.ITransactionService;

/**
 * Created by jian01.zhu on 2016/1/28.
 */
@Controller
@RequestMapping(value = "transaction")
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @RequestMapping(value = "select")
    @ResponseBody
    public String transactionSelect(Integer flag){
        transactionService.testTransaction(flag);
        return "success";
    }
}
