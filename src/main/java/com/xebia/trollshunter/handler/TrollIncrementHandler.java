package com.xebia.trollshunter.handler;

import com.xebia.trollshunter.counter.TrollCounter;
import org.vertx.java.core.Handler;
import org.vertx.java.core.http.HttpServerRequest;

public class TrollIncrementHandler implements Handler<HttpServerRequest> {

    private TrollCounter trollCounter;

    public TrollIncrementHandler(TrollCounter trollCounter) {
        this.trollCounter = trollCounter;
    }

    @Override
    public void handle(final HttpServerRequest request) {
        request.response().end(trollCounter.increment() + "");
    }

}
