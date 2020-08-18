package com.wangcanfeng01.freedomcurd.service.impl;

import com.wangcanfeng01.freedomcurd.mapper.CurdMapper;
import com.wangcanfeng01.freedomcurd.service.CurdService;
import com.wangcanfeng01.freedomcurd.vo.req.Condition;
import com.wangcanfeng01.freedomcurd.vo.req.QueryReq;
import com.wangcanfeng01.freedomcurd.vo.resp.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 功能说明：
 * Created in 2020/8/15-13:41
 *
 * @author wangcanfeng
 * @since 2.0.0
 */
@Service
public class CurdServiceImpl implements CurdService {

    @Autowired
    private CurdMapper curdMapper;

    @Override
    public PageInfo<Object> getList() {
        QueryReq req = new QueryReq();
        req.setTableName("info_article");
//        List<String> cols = new ArrayList<>();
//        cols.add("hits");
//        req.setResultColumns(cols);
        List<Condition> list = new ArrayList<>();

        Condition con = new Condition();
        con.setColumnName("title");
        con.setConditionType("equal");
        con.setConditionValue("做个程序员");

//        Condition con2 = new Condition();
//        con2.setColumnName("aaaa");
//        con2.setConditionType("like");
//        con2.setConditionValue("dsda");
//
//        Condition con3 = new Condition();
//        con3.setColumnName("aaaa");
//        con3.setConditionType("equal");
//        con3.setConditionValue("dsda");
        list.add(con);
//        list.add(con2);
//        list.add(con3);
        req.setConditions(list);
        List<Map> te = curdMapper.getList(req);
        return null;
    }
}
