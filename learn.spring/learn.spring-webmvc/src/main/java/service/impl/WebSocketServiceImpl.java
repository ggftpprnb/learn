package service.impl;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import service.interfaces.IWebSocketService;

import java.io.IOException;
import java.util.Map;

/**
 * Created by jian01.zhu on 2016/2/25.
 */
@Service
public class WebSocketServiceImpl implements IWebSocketService {

    private Map<String, WebSocketSession> sessionMap = Maps.newConcurrentMap();

    @Override
    public void sentTextMessage(WebSocketSession session, String text) {
        sendToEveryOne("用户[" + session.getId() + "]发言:" + text);
    }

    private void sendToEveryOne(String text) {
        sessionMap.forEach((a, b) -> {
            try {
                b.sendMessage(new TextMessage(text));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void sentAdvert(String text) {
        sendToEveryOne(text);
    }

    @Override
    public void openSession(WebSocketSession session) {
        sessionMap.putIfAbsent(session.getId(), session);
    }

    @Override
    public void closeSession(WebSocketSession session) {
        sessionMap.remove(session.getId());
    }
}
