package service.interfaces;

import org.springframework.web.socket.WebSocketSession;

/**
 * Created by jian01.zhu on 2016/2/25.
 */
public interface IWebSocketService {

    void sentTextMessage(WebSocketSession session,String text);
    void sentAdvert(String text);

    void openSession(WebSocketSession session);

    void closeSession(WebSocketSession session);

}
