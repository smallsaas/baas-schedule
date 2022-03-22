package com.jfeat.module.schedule.oms.services.domain.dao;

import com.jfeat.module.schedule.oms.services.domain.model.ScheduleRecordRecord;
import com.jfeat.module.schedule.oms.services.gen.crud.model.ScheduleRecordModel;
import com.jfeat.module.schedule.oms.services.gen.persistence.model.ScheduleRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Code generator on 2022-03-01
 */
@Mapper
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

    @Select("SELECT * from t_schedule_record where t_schedule_record.job_id = #{jobId} order by create_time DESC limit 1")
    ScheduleRecord queryLastRecord(@Param("jobId") Long jobId);

    @Select("SELECT  t_schedule_record.id, t_schedule_record.create_time AS createTime, t_schedule_record.end_time AS endTime, t_schedule_record.job_id AS jobId, IF(t_schedule_record.end_time,t_schedule_record.use_time,0) AS useTime, t_schedule_record.use_player_id AS usePlayerId, t_schedule_record.job_name AS jobName,t_schedule_record.session_id AS sessionId,t_schedule_record.schedule_number AS scheduleNumber FROM t_schedule_record  \n" +
            "            where DATE(create_time) = Date(NOW()) order BY create_time DESC")
    List<ScheduleRecordRecord> queryTodayRecord();
}