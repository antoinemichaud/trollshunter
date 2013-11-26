package com.xebia.trollshunter;

import org.vertx.java.platform.Verticle;

public class MainVerticle extends Verticle {

    public void start() {
        container.logger().info("MainVerticle started");
    }
}
