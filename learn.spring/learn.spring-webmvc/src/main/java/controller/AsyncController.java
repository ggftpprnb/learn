package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * Created by jian01.zhu on 2015/12/30.
 */
@Controller
@RequestMapping(value = "async")
public class AsyncController {

    @RequestMapping("/callable")
    @ResponseBody
    public Callable<String> callable() {

        soutThreadName();

        return () -> {
            soutThreadName();
            Thread.sleep(2000);
            return "Callable result";
        };
    }

    @RequestMapping("/deferredResult")
    @ResponseBody
    public DeferredResult<String> deferredResult(){
        soutThreadName();

        DeferredResult<String> result = new DeferredResult<>(20000l,null);
        anotherThread(result);

        return result;
    }

    private void soutThreadName(){
        System.out.println(Thread.currentThread().getName());
    }

    private void anotherThread(DeferredResult<String> result){
        new Thread(()->{
            try {
                Thread.sleep(2000);
                soutThreadName();
                result.setResult("Deferred Result");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


    private void anotherThread(ResponseBodyEmitter emitter){
        new Thread(()->{
            try {
                Thread.sleep(2000);
                soutThreadName();
                emitter.send("Deferred Result");
                anotherThread2(emitter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void anotherThread2(ResponseBodyEmitter emitter){
        new Thread(()->{
            try {
                Thread.sleep(2000);
                soutThreadName();
                emitter.send("Deferred Result");
                emitter.complete();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @RequestMapping("/events")
    public ResponseBodyEmitter events() {
        ResponseBodyEmitter emitter = new ResponseBodyEmitter();
        soutThreadName();
        anotherThread(emitter);
        return emitter;
    }

}
