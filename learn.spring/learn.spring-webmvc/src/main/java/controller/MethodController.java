package controller;

import model.Params;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by jian01.zhu on 2016/2/16.
 */
@Controller
@RequestMapping(value = "method")
public class MethodController {

    @ResponseBody
    @RequestMapping(value = "put",method = RequestMethod.PUT)
    public String put(String param){
        System.out.println(param);
        return param;
    }

    @ResponseBody
    @RequestMapping(value = "put2",method = RequestMethod.PUT)
    public String put2(@RequestBody String param){
        System.out.println(param);
        return param;
    }

    @ResponseBody
    @RequestMapping(value = "post",method = RequestMethod.POST)
    public String post(Params params){
        System.out.println(params.getImgList());
        System.out.println(params.getImgList().size());
        System.out.println(params.getNow());
        return "success";
    }

    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
