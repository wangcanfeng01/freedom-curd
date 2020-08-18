package com.wangcanfeng01.freedomcurd.mapper;

import com.wangcanfeng01.freedomcurd.utils.PrepareSqlUtils;
import com.wangcanfeng01.freedomcurd.vo.req.DeleteReq;
import com.wangcanfeng01.freedomcurd.vo.req.InsertReq;
import com.wangcanfeng01.freedomcurd.vo.req.QueryReq;
import com.wangcanfeng01.freedomcurd.vo.req.UpdateReq;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 功能说明：
 * Created in 2020/8/15-13:12
 *
 * @author wangcanfeng
 * @since 2.0.0
 */
@Mapper
public interface CurdMapper {

    @InsertProvider(type = PrepareSqlUtils.class, method = "insertSql")
    void createData(InsertReq req);

    @DeleteProvider(type = PrepareSqlUtils.class, method = "deleteSql")
    void deleteData(DeleteReq req);

    @UpdateProvider(type = PrepareSqlUtils.class, method = "updateSql")
    void updateData(UpdateReq req);

    @SelectProvider(type = PrepareSqlUtils.class, method = "selectSql")
    List<Map> getList(QueryReq req);
}
