package controller;

import controller.req.Type;
import controller.resp.DemoResult;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.IOUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by jian01.zhu on 2015/12/8.
 */
@Controller
@RequestMapping(value = "demo")
public class DemoController {

    @RequestMapping(value = "/test/{path}")
    @ResponseBody
    public String test(String paramNeed, @PathVariable("path") String path){




        return "path:"+path+"----------------"+"paramNeed:"+paramNeed;
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public DemoResult jsonTest(HttpServletRequest request) throws IOException {

        ServletInputStream inputStream = request.getInputStream();

        byte[] b = new byte[1024];

        int length;

        StringBuilder sb = new StringBuilder();

        while ((length=inputStream.read(b))!=-1){
            sb.append(new String(b,0,length));
        }

        System.out.println(sb.toString());


        DemoResult demoResult = new DemoResult();
        demoResult.setId(UUID.randomUUID().toString());
        demoResult.setName(demoResult.getName());
        demoResult.setIsRight(true);
        demoResult.setIsUse(true);

        return demoResult;
    }

    @RequestMapping(value = "/test2")
    @ResponseBody
    public DemoResult receive(HttpServletRequest request,Boolean isRight,String meme) throws IOException {

        System.out.println(request.getParameter("isRight"));
        System.out.println(request.getParameter("meme"));
        //System.out.println(demoResult.getIsRight());
        //System.out.println(demoResult.getIsUse());
        System.out.println(isRight);
        System.out.println(meme);

        return new DemoResult();
    }

    @RequestMapping(value = "/enumParam")
    public void enumParam(Type type){
        System.out.println(type);
    }
}
