package com.pf.myelasticsearchone.dao;

import com.pf.myelasticsearchone.entity.PhoneModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PhoneRepository extends ElasticsearchRepository<PhoneModel, String> {
}
