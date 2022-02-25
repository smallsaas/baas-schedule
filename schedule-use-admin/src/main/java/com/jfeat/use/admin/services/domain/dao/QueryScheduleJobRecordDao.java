package com.jfeat.use.admin.services.domain.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import com.jfeat.use.admin.services.domain.model.ScheduleJobRecordRecord;
import com.jfeat.use.admin.services.gen.crud.model.ScheduleJobRecordModel;
import com.jfeat.use.admin.services.gen.persistence.model.ScheduleJobRecord;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Code generator on 2022-02-25
 */
public interface QueryScheduleJobRecordDao extends QueryMasterDao<ScheduleJobRecord> {
   /*
    * Query entity list by page
    */
    List<ScheduleJobRecordRecord> findScheduleJobRecordPage(Page<ScheduleJobRecordRecord> page, @Param("record") ScheduleJobRecordRecord record,
                                                            @Param("tag") String tag,
                                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /*
     * Query entity model for details
     */
    ScheduleJobRecordModel queryMasterModel(@Param("id") Long id);


    /*
     * Query entity model list for slave items
     */
    List<ScheduleJobRecordModel> queryMasterModelList(@Param("masterId") Object masterId);
}