package com.pf.myelasticsearchone.dao;

import com.pf.myelasticsearchone.entity.BlogModel;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BlogRepository extends ElasticsearchRepository<BlogModel, String> {

    List<BlogModel> findByTitleLike(String keyword);

    //?0 代指变量的意思
    @Query("{\"match_phrase\":{\"title\":\"?0\"}}")
    List<BlogModel> findByTitleCustom(String keyword);
}
