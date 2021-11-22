package io.dapr.client.domain;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationItem {
    public String key;
    public String version;
    public String value;
    public Map<String, String > metadata;

    public ConfigurationItem(String key, String version, String value, Map<String, String> metadata) {
        this.key = key;
        this.version = version;
        this.value = value;
        this.metadata = metadata;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(HashMap<String, String> metadata) {
        this.metadata = metadata;
    }
}
