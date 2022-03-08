package com.jfeat.use.admin.services.domain.dao;

import com.jfeat.use.admin.services.domain.model.ScheduleRecordRecord;
import com.jfeat.use.admin.services.gen.crud.model.ScheduleRecordModel;
import com.jfeat.use.admin.services.gen.persistence.model.ScheduleRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Code generator on 2022-03-01
 */

public interface QueryScheduleRecordDao extends QueryMasterDao<ScheduleRecord> {
   /*
    * Query entity list by page
    */
    List<ScheduleRecordRecord> findScheduleRecordPage(Page<ScheduleRecordRecord> page, @Param("record") ScheduleRecordRecord record,
                                                      @Param("tag") String tag,
                                                      @Param("search") String search, @Param("orderBy") String orderBy,
                                                      @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);

    /*
     * Query entity model for details
     */
    ScheduleRecordModel queryMasterModel(@Param("id") Long id);


    /*
     * Query entity model list for slave items
     */
    List<ScheduleRecordModel> queryMasterModelList(@Param("masterId") Object masterId);

    @Select("SELECT * from t_schedule_record where t_schedule_record.job_id = #{jobId} group by create_time DESC limit 1")
    ScheduleRecord queryLastRecord(@Param("jobId") Long jobId);
}