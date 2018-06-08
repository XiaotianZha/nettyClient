package com.zhang.http.client.message;

import com.zhang.http.client.listener.Listener;
import io.netty.handler.codec.http.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

public class HttpRequestFuture {

    private FullHttpResponse response;

    private List<Listener> listeners = new ArrayList<>();

    private final CountDownLatch countDownLatch = new CountDownLatch(1);


    public void setResponse(FullHttpResponse response) {
        this.response = response;

    }

    public FullHttpResponse get() {

        return response;
    }

    public void addListener(Runnable r, ExecutorService exec) {
        listeners.add(new Listener(r, exec));
        countDownLatch.countDown();

    }

    public void done() {
        //do not block the netty threads
        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                listeners.forEach(r -> r.done());
            }
        };
        t.start();


    }
}
