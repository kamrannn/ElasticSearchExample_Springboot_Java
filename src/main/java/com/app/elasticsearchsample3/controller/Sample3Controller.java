package com.app.elasticsearchsample3.controller;

import com.app.elasticsearchsample3.model.Sample3;
import com.app.elasticsearchsample3.service.ElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sample3")
public class Sample3Controller {

    @Autowired
    private ElasticSearchService elasticSearchService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllValuesFromElasticSearch() {
        List<Sample3> result = elasticSearchService.getAllData();
        if (result.isEmpty()) {
            return new ResponseEntity<>("There is no data in sample3 document", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
}
