package com.zhang.http.client.message;

import io.netty.handler.codec.http.*;

import java.util.concurrent.CountDownLatch;

public class HttpRequestFuture {

    private  FullHttpResponse resopnse;

    private final CountDownLatch countDownLatch = new CountDownLatch(1);

    public void setResponse(FullHttpResponse response){
        this.resopnse=response;

    }

    public FullHttpResponse get() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        System.out.println("request done");
        return resopnse;
    }

    public void done(){
        countDownLatch.countDown();
    }
}
