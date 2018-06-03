package com.zhang.http.client.message;

import io.netty.handler.codec.http.*;

import java.util.concurrent.CountDownLatch;

public class HttpRequestFuture {

    private  FullHttpResponse resopnse;

    private final CountDownLatch countDownLatch = new CountDownLatch(1);

    public void setResopnse(FullHttpResponse resopnse){
        this.resopnse=resopnse;

    }

    public FullHttpResponse get() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
            FullHttpResponse inresponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.REQUEST_TIMEOUT);
            return inresponse;
        }
        System.out.println("request done");
        return resopnse;
    }

    public void done(){
        countDownLatch.countDown();
    }
}
