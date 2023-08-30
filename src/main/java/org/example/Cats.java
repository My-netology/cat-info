package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cats {
    private final String id;
    private final String text;
    private final String type;
    private final String user;
    private final Integer upvotes;

    public Cats(
            @JsonProperty("id") String id,
            @JsonProperty("text") String text,
            @JsonProperty("type") String type,
            @JsonProperty("user") String user,
            @JsonProperty("upvotes") Integer upvotes
    ) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    @Override
    public String toString() {
        return String.format("Cat{id='%s', text='%s', type='%s', user='%s', upvotes=%d}", id, text, type, user, upvotes);
    }
}
