package org.example;

import java.util.HashMap;
import java.util.Map;

public class Document {
    private String id;
    private String name;
    private String location;
    private Map<String, Object> tags;
    public Document() {}

    public Document(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        tags = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", tags=" + tags +
                '}';
    }
}
