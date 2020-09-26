package com.pf.myelasticsearchone.controller;

import com.fengwenyi.javalib.result.Result;
import com.fengwenyi.javalib.util.StringUtils;
import com.pf.myelasticsearchone.dao.BlogRepository;
import com.pf.myelasticsearchone.entity.BlogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    //添加
    @PostMapping("/add")
    public Result add(@RequestBody BlogModel blogModel) {
        blogRepository.save(blogModel);
        return Result.success();
    }

    //根据ID查询
    @GetMapping("/get/{id}")
    public Result getById(@PathVariable String id) {
        if (StringUtils.isEmpty(id))
            return Result.error();
        BlogModel blogModel = blogRepository.findOne(id);
        if (Objects.nonNull(blogModel)) {
            return Result.success(blogModel);
        }
        return Result.error();
    }

    //查询所有
    @GetMapping("/get")
    public Result getAll() {
        Iterable<BlogModel> iterable = blogRepository.findAll();
        List<BlogModel> list = new ArrayList<>();
        iterable.forEach(list::add);
        return Result.success(list);
    }


    //根据ID修改
    @PostMapping("/update")
    public Result updateById(@RequestBody BlogModel blogModel) {
        String id = blogModel.getId();
        if (StringUtils.isEmpty(id))
            return Result.error();
        blogRepository.save(blogModel);
        return Result.success();
    }

    //根据ID删除
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable String id) {
        if (StringUtils.isEmpty(id))
            return Result.error();
        blogRepository.delete(id);
        return Result.success();
    }

    //删除所有数据
    @DeleteMapping("/delete")
    public Result deleteById() {
        blogRepository.deleteAll();
        return Result.success();
    }

    //搜索标题中的关键字
    @GetMapping("/rep/search/title")
    public Result repSearchTitle(String keyword) {
        if (StringUtils.isEmpty(keyword))
            return Result.error();
        return Result.success(blogRepository.findByTitleLike(keyword));
    }


    @GetMapping("/rep/search/title/custom")
    public Result repSearchTitleCustom(String keyword) {
        if (StringUtils.isEmpty(keyword))
            return Result.error();
        return Result.success(blogRepository.findByTitleCustom(keyword));
    }


    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @GetMapping("/search/title")
    public Result searchTitle(String keyword) {
        if (StringUtils.isEmpty(keyword))
            return Result.error();
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryStringQuery(keyword))
                .build();
        List<BlogModel> list = elasticsearchTemplate.queryForList(searchQuery, BlogModel.class);
        return Result.success(list);
    }
}
