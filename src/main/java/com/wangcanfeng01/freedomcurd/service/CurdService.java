package com.wangcanfeng01.freedomcurd.service;

import com.wangcanfeng01.freedomcurd.vo.resp.PageInfo;

/**
 * 功能说明：
 * Created in 2020/8/15-13:32
 *
 * @author wangcanfeng
 * @since 2.0.0
 */
public interface CurdService {

    PageInfo<Object> getList();
}
