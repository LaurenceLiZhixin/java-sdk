package io.dapr.client.domain;

public interface ConfigSubscribeHandler {
    public void handle(ConfigurationItem[] items);
}
