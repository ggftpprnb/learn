package websocket;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import service.interfaces.IWebSocketService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jian01.zhu on 2016/2/25.
 */
public class SelfTextWebSocketHandler extends TextWebSocketHandler{

    @Autowired
    private IWebSocketService webSocketService;

    private List<WebSocketSession> sessions = Lists.newArrayList();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println(session);

        sessions.add(session);

        sessions.stream().sorted((a,b)->{
            System.out.println(a.equals(b));
            return a.getId().compareTo(b.getId());
        }).collect(Collectors.toList());

        webSocketService.sentTextMessage(session,message.getPayload());
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        webSocketService.openSession(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        webSocketService.closeSession(session);
    }
}
