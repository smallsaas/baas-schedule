package com.jfeat.module.schedule.oms.api;


import com.jfeat.crud.base.annotation.BusinessLog;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.module.schedule.oms.services.domain.dao.QueryScheduleRecordDao;
import com.jfeat.module.schedule.oms.services.domain.model.ScheduleRecordRecord;
import com.jfeat.module.schedule.oms.services.domain.service.ScheduleRecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/crud/schedule")
public class ScheduleEndPoint {

    @Resource
    private ScheduleRecordService scheduleRecordService;
    @Resource
    private QueryScheduleRecordDao queryScheduleRecordDao;

    @BusinessLog(name = "ScheduleRecord", value = "查看今日定时任务记录")
    @GetMapping
    public Tip queryScheduleRecord() {
        return SuccessTip.create(queryScheduleRecordDao.queryTodayRecord());
    }

    @BusinessLog(name = "ScheduleRecord", value = "查看全部定时任务记录")
    @GetMapping("/allScheduleRecord")
    public Tip queryAllScheduleRecord() {
        return SuccessTip.create(queryScheduleRecordDao.findScheduleRecordPage(null,new ScheduleRecordRecord(),null,null,null,null,null));
    }

    @BusinessLog(name = "ScheduleRecord", value = "定时任务记录")
    @GetMapping("/recordScheduleRecord")
    public Tip recordScheduleRecord() {
        var s = scheduleRecordService.recordThisRecord("autoGet",null);
//        scheduleRecordService.recordThisEndTime(s);
        return SuccessTip.create();
    }

}
