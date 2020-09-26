package com.pf.excel.readExcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.pf.excel.readExcel.dao.SolidBusinessDao;
import com.pf.excel.readExcel.entity.ExcelTemplate;
import com.pf.excel.readExcel.entity.SolidBusiness;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class ExcelTemplateListener extends AnalysisEventListener<ExcelTemplate> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelTemplateListener.class);

    @Autowired
    private SolidBusinessDao solidBusinessDao;

    List<ExcelTemplate> list = new ArrayList<ExcelTemplate>();

    @Override
    public void invoke(ExcelTemplate excelTemplate, AnalysisContext analysisContext) {
        if(StringUtils.isNotEmpty(excelTemplate.getListA())
                ||StringUtils.isNotEmpty(excelTemplate.getListB())
                ||StringUtils.isNotEmpty(excelTemplate.getListC())
                ||StringUtils.isNotEmpty(excelTemplate.getListD())
                ||StringUtils.isNotEmpty(excelTemplate.getListE())){
            list.add(excelTemplate);
        }else{
            LOGGER.info("解析到一条数据:{}", JSON.toJSONString(excelTemplate));
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        AtomicReference<SolidBusiness> tempA = new AtomicReference<>(new SolidBusiness());
        AtomicReference<SolidBusiness> tempB = new AtomicReference<>(new SolidBusiness());
        AtomicReference<SolidBusiness> tempC = new AtomicReference<>(new SolidBusiness());
        list.stream().forEach(excelTemplate->{
            if(StringUtils.isNotEmpty(excelTemplate.getListA())){
                SolidBusiness solidBusiness = new SolidBusiness();
                solidBusiness.setBusinessName(excelTemplate.getListE());
                solidBusiness.setBusinessCode(excelTemplate.getListA());
                solidBusiness.setPid(0);
                solidBusinessDao.insertSelective(solidBusiness);
                tempA.set(solidBusiness);
            }else if(StringUtils.isNotEmpty(excelTemplate.getListB())){
                SolidBusiness solidBusiness = new SolidBusiness();
                solidBusiness.setBusinessName(excelTemplate.getListE());
                solidBusiness.setBusinessCode(excelTemplate.getListB());
                solidBusiness.setPid(tempA.get().getId());
                solidBusinessDao.insertSelective(solidBusiness);
                tempB.set(solidBusiness);
            }else if(StringUtils.isNotEmpty(excelTemplate.getListC())){
                SolidBusiness solidBusiness = new SolidBusiness();
                solidBusiness.setBusinessName(excelTemplate.getListE());
                solidBusiness.setBusinessCode(excelTemplate.getListC());
                solidBusiness.setPid(tempB.get().getId());
                solidBusinessDao.insertSelective(solidBusiness);
                tempC.set(solidBusiness);

                if(StringUtils.isNotEmpty(excelTemplate.getListD())){
                    SolidBusiness solidBusinessTemp = new SolidBusiness();
                    solidBusiness.setBusinessName(excelTemplate.getListE());
                    solidBusiness.setBusinessCode(excelTemplate.getListD());
                    solidBusiness.setPid(tempC.get().getId());
                    solidBusinessDao.insertSelective(solidBusiness);
                }
            }else if(StringUtils.isNotEmpty(excelTemplate.getListD())){
                SolidBusiness solidBusiness = new SolidBusiness();
                solidBusiness.setBusinessName(excelTemplate.getListE());
                solidBusiness.setBusinessCode(excelTemplate.getListD());
                solidBusiness.setPid(tempC.get().getId());
                solidBusinessDao.insertSelective(solidBusiness);
            }
//            System.out.println(convertToMap(excelTemplate));
        });
    }


    public static Map<String, String> convertToMap(Object obj) {
        try {
            if (obj instanceof Map) {
                return (Map)obj;
            }
            Map<String, String> returnMap = BeanUtils.describe(obj);
            returnMap.remove("class");
            return returnMap;
        } catch (IllegalAccessException e1) {
            e1.getMessage();
        } catch (InvocationTargetException e2) {
            e2.getMessage();
        } catch (NoSuchMethodException e3) {
            e3.getMessage();
        }
        return new HashMap();
    }
}
