package com.app.elasticsearchsample3.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "sample3")
public class Sample3 {
    @Id
    @Field(type = FieldType.Text, name = "value")
    private String value;
    @Field(type = FieldType.Text, name = "color")
    private String color;

}
