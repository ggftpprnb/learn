package mp.function.token;

import com.sun.istack.internal.NotNull;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by jian01.zhu on 2016/2/15.
 */
public class TokenTimer {

    public class TokenTimerTask extends TimerTask{

        private Token token;

        public TokenTimerTask(@NotNull Token token) {
            this.token = token;
        }

        @Override
        public void run() {

        }
    }

    public static void clearToken(Token token,int delay){
        Timer timer = new Timer();
    }
}
