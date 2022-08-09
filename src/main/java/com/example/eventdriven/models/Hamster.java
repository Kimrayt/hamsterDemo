package com.example.eventdriven.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "hamsters")
public class Hamster {
    @Id
    @Indexed
    private String id;

    @Field("Name")
    @Indexed(name = "name", direction = IndexDirection.DESCENDING)
    private String name;

    public String getId() {
        return id;
    }

    public void setHamsterId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}