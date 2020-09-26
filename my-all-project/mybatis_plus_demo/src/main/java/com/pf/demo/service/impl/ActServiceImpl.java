package com.pf.demo.service.impl;

import com.pf.demo.entity.Act;
import com.pf.demo.dao.ActMapper;
import com.pf.demo.service.ActService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author pengfan
 * @since 2019-12-18
 */
@Service
public class ActServiceImpl extends ServiceImpl<ActMapper, Act> implements ActService {

}
