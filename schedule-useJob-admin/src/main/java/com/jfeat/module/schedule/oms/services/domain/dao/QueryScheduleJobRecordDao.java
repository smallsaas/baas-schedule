package com.jfeat.module.schedule.oms.services.domain.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import com.jfeat.module.schedule.oms.services.domain.model.ScheduleJobRecordRecord;
import com.jfeat.module.schedule.oms.services.gen.crud.model.ScheduleJobRecordModel;
import com.jfeat.module.schedule.oms.services.gen.persistence.model.ScheduleJobRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Code generator on 2022-02-25
 */


@Mapper
public interface QueryScheduleJobRecordDao extends QueryMasterDao<ScheduleJobRecord> {
   /*
    * Query entity list by page
    */
    List<ScheduleJobRecordRecord> findScheduleJobRecordPage(Page<ScheduleJobRecordRecord> page, @Param("record") ScheduleJobRecordRecord record,
                                                            @Param("tag") String tag,
                                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                                            @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);

    /*
     * Query entity model for details
     */
    ScheduleJobRecordModel queryMasterModel(@Param("id") Long id);


    /*
     * Query entity model list for slave items
     */
    List<ScheduleJobRecordModel> queryMasterModelList(@Param("masterId") Object masterId);
}