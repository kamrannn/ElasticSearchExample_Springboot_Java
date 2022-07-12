package com.app.elasticsearchsample3.service;

import com.app.elasticsearchsample3.model.Sample3;
import com.app.elasticsearchsample3.repository.Sample3Repository;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ElasticSearchService {

    private final Sample3Repository sample3Repository;

    @Autowired
    public ElasticSearchService(Sample3Repository sample3Repository) {
        this.sample3Repository = sample3Repository;
    }

    /**
     * You can call this method when you want to save the data from the json file in the elastic search.
     * @throws IOException
     * @throws ParseException
     */
    public void test() throws IOException, ParseException {
        File file = ResourceUtils.getFile("classpath:sample3.json");
        //Read File Content
        String content = new String(Files.readAllBytes(file.toPath()));
        System.out.println(content);

        JSONParser parser = new JSONParser();
        JSONArray a = (JSONArray) parser.parse(new FileReader(file));

        for (Object o : a) {
            JSONObject object = (JSONObject) o;

            String color = (String) object.get("color");
            String value = (String) object.get("value");

            Sample3 sample3 = Sample3.builder()
                    .value(value)
                    .color(color)
                    .build();
            log.info("Saving the object in the repository: {}", sample3.toString());
            sample3Repository.save(sample3);
        }
    }

    public List<Sample3> getAllData() {
        List<Sample3> result = new ArrayList<>();
        Iterable<Sample3> sample3List = sample3Repository.findAll();
        for (Sample3 sample3 : sample3List) {
            System.out.println("Color: " + sample3.getColor() + ", Value: " + sample3.getValue());
            result.add(sample3);
        }
        return result;
    }
}
