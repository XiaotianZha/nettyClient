package com.zhang.http.client.message;

import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

import java.util.concurrent.CountDownLatch;

public class HttpRequestFuture {

    private  FullHttpResponse resopnse;

    private final CountDownLatch countDownLatch = new CountDownLatch(1);

    public void setResponse(FullHttpResponse response){
        this.resopnse=response;

    }

    public String get() {
        try {
            countDownLatch.await();
            System.out.println("request done");
            String contentType =resopnse.headers().get(HttpHeaders.Names.CONTENT_TYPE);
            if (contentType.equalsIgnoreCase("application/json;charset=UTF-8")){
                return resopnse.content().toString(CharsetUtil.UTF_8);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }finally {
            ReferenceCountUtil.release(resopnse);
        }

        return null;
    }

    public void done(){
        countDownLatch.countDown();
    }
}
