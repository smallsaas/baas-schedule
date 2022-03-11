package com.jfeat.module.schedule.oms.services.domain.service;

import com.jfeat.module.schedule.oms.services.gen.crud.service.CRUDScheduleRecordService;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ScheduleRecordService extends CRUDScheduleRecordService {

    public void recordThisRecord(String name,Long sessionId);


    public void recordThisEndTime(String name);

}