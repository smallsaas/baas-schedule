package com.jfeat.use.admin.services.domain.service;

import com.jfeat.use.admin.services.gen.crud.service.CRUDScheduleRecordService;

/**
 * Created by vincent on 2017/10/19.
 */
public interface ScheduleRecordService extends CRUDScheduleRecordService {

    public void recordThisRecord(String name);


    public void recordThisEndTime(String name);

}