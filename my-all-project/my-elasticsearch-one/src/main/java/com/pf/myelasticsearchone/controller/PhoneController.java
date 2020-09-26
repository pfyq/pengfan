package com.pf.myelasticsearchone.controller;

import com.fengwenyi.javalib.constant.DateTimeFormat;
import com.fengwenyi.javalib.result.Result;
import com.fengwenyi.javalib.util.DateTimeUtil;
import com.pf.myelasticsearchone.entity.PhoneModel;
import com.pf.myelasticsearchone.util.DataGrabUtil;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@RestController
@RequestMapping(value = "/phone")
@CrossOrigin
public class PhoneController {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * 全文搜索
     * @param keyword 关键字
     * @param page 当前页，从0开始
     * @param size 每页大小
     * @return {@link Result} 接收到的数据格式为json
     */
    @GetMapping("/full")
    public Mono<Result> full(String keyword, int page, int size) {
        // System.out.println(new Date() + " => " + keyword);

        // 校验参数
        if (StringUtils.isEmpty(page))
            page = 0; // if page is null, page = 0

        if (StringUtils.isEmpty(size))
            size = 10; // if size is null, size default 10

        // 构造分页类
        Pageable pageable = new PageRequest(page, size);

        // 构造查询 NativeSearchQueryBuilder
        NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder()
                .withPageable(pageable)
                ;
        if (!StringUtils.isEmpty(keyword)) {
            // keyword must not null
            searchQueryBuilder.withQuery(QueryBuilders.queryStringQuery(keyword));
        }

    /*
    SearchQuery
    这个很关键，这是搜索条件的入口，
    elasticsearchTemplate 会 使用它 进行搜索
     */
        SearchQuery searchQuery = searchQueryBuilder.build();

        // page search
        Page<PhoneModel> phoneModelPage = elasticsearchTemplate.queryForPage(searchQuery, PhoneModel.class);

        // return
        return Mono.just(Result.success(phoneModelPage));
    }



    /**
     * 高级搜索，根据字段进行搜索
     * @param name 名称
     * @param color 颜色
     * @param sellingPoint 卖点
     * @param price 价格
     * @param start 开始时间(格式：yyyy-MM-dd HH:mm:ss)
     * @param end 结束时间(格式：yyyy-MM-dd HH:mm:ss)
     * @param page 当前页，从0开始
     * @param size 每页大小
     * @return {@link Result}
     */
    @GetMapping("/_search")
    public Mono<Result> search(String name, String color, String sellingPoint, String price, String start, String end, int page, int size) {

        // 校验参数
        if (StringUtils.isEmpty(page) || page < 0)
            page = 0; // if page is null, page = 0

        if (StringUtils.isEmpty(size) || size < 0)
            size = 10; // if size is null, size default 10

        // 构造分页对象
        Pageable pageable = new PageRequest(page, size);

        // BoolQueryBuilder (Elasticsearch Query)
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        if (!StringUtils.isEmpty(name)) {
            boolQueryBuilder.must(QueryBuilders.matchQuery("name", name));
        }

        if (!StringUtils.isEmpty(color)) {
            boolQueryBuilder.must(QueryBuilders.matchQuery("colors", color));
        }

        if (!StringUtils.isEmpty(color)) {
            boolQueryBuilder.must(QueryBuilders.matchQuery("sellingPoints", sellingPoint));
        }

        if (!StringUtils.isEmpty(price)) {
            boolQueryBuilder.must(QueryBuilders.matchQuery("price", price));
        }

        if (!StringUtils.isEmpty(start)) {
            Date startTime = null;
            try {
                startTime = DateTimeUtil.stringToDate(start, DateTimeFormat.yyyy_MM_dd_HH_mm_ss);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            boolQueryBuilder.must(QueryBuilders.rangeQuery("createTime").gt(startTime.getTime()));
        }

        if (!StringUtils.isEmpty(end)) {
            Date endTime = null;
            try {
                endTime = DateTimeUtil.stringToDate(end, DateTimeFormat.yyyy_MM_dd_HH_mm_ss);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            boolQueryBuilder.must(QueryBuilders.rangeQuery("createTime").lt(endTime.getTime()));
        }

        // BoolQueryBuilder (Spring Query)
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(boolQueryBuilder)
                .build()
                ;

        // page search
        Page<PhoneModel> phoneModelPage = elasticsearchTemplate.queryForPage(searchQuery, PhoneModel.class);

        // return
        return Mono.just(Result.success(phoneModelPage));
    }

    @Autowired
    private DataGrabUtil dataGrabUtil;

    @GetMapping("/gradData")
    public void gradData(){
        try {
            dataGrabUtil.huawei();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
