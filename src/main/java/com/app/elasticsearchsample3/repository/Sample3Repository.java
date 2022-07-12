package com.app.elasticsearchsample3.repository;

import com.app.elasticsearchsample3.model.Sample3;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Sample3Repository extends ElasticsearchRepository<Sample3, String> {
    Page<Sample3> findByValue(String name, Pageable pageable);

}
