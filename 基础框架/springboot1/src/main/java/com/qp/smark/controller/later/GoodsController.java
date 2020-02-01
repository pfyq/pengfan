package com.qp.smark.controller.later;

import com.qp.smark.dao.GoodsMapper;
import com.qp.smark.entity.Goods;
import com.qp.smark.service.GoodsService;
import com.qp.smark.util.Result;
import com.qp.smark.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/goods")
@Api(description = "商家类")
@CrossOrigin
public class GoodsController {

    private static final Logger log = Logger.getLogger(GoodsController.class);
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/all",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "获取所有商品信息")
    public Result<Object> all(Long curPage, Integer rows, Integer gid){
        Long startRow = (curPage - 1)*rows;
        Map<String,Object> mapParam = new HashMap<String,Object>();
        mapParam.put("startRow",startRow);
        mapParam.put("rows",rows);
        if(gid != null && gid != 0){
            mapParam.put("gid",gid);
        }


        Map<String,Object> map = new HashMap<String,Object>();
        map.put("0",goodsMapper.count(mapParam));
        map.put("1",goodsMapper.all(mapParam));

        return new ResultUtil<Object>().setData(map);
    }

    @RequestMapping(value = "/del",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除某个商品信息")
    public String del(Integer id){
        try{
            goodsService.deleteByPrimaryKey(id);
            return "success";
        }catch(Exception e){
            log.error(e.getMessage(), e);
        }
        return "error";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加某个商品信息")
    public String add(Goods goods){
        try{
            goodsService.insert(goods);
            return "success";
        }catch(Exception e){
            log.error(e.getMessage(), e);
        }
        return "error";
    }

}
