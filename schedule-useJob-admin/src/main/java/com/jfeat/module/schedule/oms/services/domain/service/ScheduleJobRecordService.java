package com.jfeat.module.schedule.oms.services.domain.service;

import com.jfeat.module.schedule.oms.services.domain.model.ScheduleJobRecordRecord;
import com.jfeat.module.schedule.oms.services.domain.model.ScheduleRecordRecord;
import com.jfeat.module.schedule.oms.services.gen.crud.model.ScheduleJobRecordModel;
import com.jfeat.module.schedule.oms.services.gen.crud.service.CRUDScheduleJobRecordService;

import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ScheduleJobRecordService extends CRUDScheduleJobRecordService {

    List<ScheduleJobRecordRecord> queryAllJobAndRecord();
    }