package com.zhang.http.client.listener;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Listener {

    private final Runnable r;

    private final ExecutorService executorService;

    public Listener(Runnable r, ExecutorService executorService) {
        this.r = r;
        this.executorService = executorService;
    }

    public void done(){
       executorService.submit(r);
    }
}
