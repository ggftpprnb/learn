package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.interfaces.IWebSocketService;

/**
 * Created by jian01.zhu on 2016/2/25.
 */
@Controller
public class WebSocketController {

    @Autowired
    private IWebSocketService webSocketService;

    @RequestMapping(value = "advert")
    @ResponseBody
    public String systemAdvert(){
        webSocketService.sentAdvert("system advert");

        return "success";
    }
}
