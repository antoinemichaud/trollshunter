package com.xebia.trollshunter.handler;

import org.vertx.java.core.Handler;
import org.vertx.java.core.http.HttpServerRequest;

public class StaticWebHandler implements Handler<HttpServerRequest> {

    public void handle(final HttpServerRequest req) {

        final String file = "/".equals(req.path()) ? "index.html" : req.path();
        final String fileRequiredPath = "web/" + file;

        req.response().sendFile(fileRequiredPath, "web/404.html");
        req.response().close();
    }

}
