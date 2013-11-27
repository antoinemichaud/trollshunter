package com.xebia.trollshunter;

import com.xebia.trollshunter.counter.TrollCounter;
import com.xebia.trollshunter.handler.StaticWebHandler;
import com.xebia.trollshunter.handler.TrollCounterHandler;
import com.xebia.trollshunter.handler.TrollIncrementHandler;
import org.vertx.java.core.http.RouteMatcher;
import org.vertx.java.platform.Verticle;

public class MainVerticle extends Verticle {

    private static final Integer PORT_NUMBER = 8280;

    public void start() {
        TrollCounter counter = new TrollCounter();

        final StaticWebHandler staticWebHandler = new StaticWebHandler();
        final TrollIncrementHandler trollIncrementHandler = new TrollIncrementHandler(counter);
        final TrollCounterHandler trollCounterHandler = new TrollCounterHandler(counter);
        final RouteMatcher routeMatcher = new RouteMatcher();

        routeMatcher.get("/counter", trollCounterHandler);
        routeMatcher.post("/increaseCounter", trollIncrementHandler);
        routeMatcher.getWithRegEx(".*", staticWebHandler);

        vertx.createHttpServer().requestHandler(routeMatcher).listen(PORT_NUMBER);

        container.logger().info("MainVerticle started");
    }
}
