package com.xebia.trollshunter.handler;

import com.xebia.trollshunter.counter.TrollCounter;
import org.vertx.java.core.Handler;
import org.vertx.java.core.http.HttpServerRequest;

public class TrollCounterHandler implements Handler<HttpServerRequest> {

    private TrollCounter trollCounter;

    public TrollCounterHandler(TrollCounter trollCounter) {

        this.trollCounter = trollCounter;
    }

    @Override
    public void handle(final HttpServerRequest request) {
        request.response().end(trollCounter.counter() + "");
    }

}
