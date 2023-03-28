package org.example;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class Document - has an id, a title, a location and a map of tags
 * has a function addTag - to be used for homework/bonus
 */
public class Document implements Serializable {
    private String id;
    private String title;
    private String location; //file name or Web page
    private Map<String, Object> tags = new HashMap<>();

    //constructors
    protected Document(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.tags = new HashMap<>();
    }

    public Document() {
    }

    // getters and setters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", tags=" + tags +
                '}';
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }
}
