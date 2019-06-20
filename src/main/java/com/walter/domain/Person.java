package com.walter.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document
@Data
public class Person implements Serializable {

    @Id
    private Long id;
    private String name;
    private String gender;
    @Field("lover_id")
    private Long loverId;
}
