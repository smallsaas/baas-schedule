package com.jfeat.module.schedule.oms.services.event;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jfeat.module.schedule.oms.services.domain.dao.QueryScheduleRecordDao;
import com.jfeat.module.schedule.oms.services.domain.service.ScheduleRecordService;
import com.jfeat.module.schedule.oms.services.gen.persistence.model.ScheduleRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;

@Component
public class MyScheduled {
    @Resource
    ScheduleRecordService scheduleRecordService;
    @Resource
    QueryScheduleRecordDao queryScheduleRecordDao;

    @Scheduled(cron = "0 0 0 ? * 5")
    public void deleteScheduleRecord() {
        var list = queryScheduleRecordDao.selectList(new LambdaQueryWrapper<ScheduleRecord>().lt(ScheduleRecord::getCreateTime, LocalDate.now().minusDays(7)));
        for (ScheduleRecord scheduleRecord:list) {
            scheduleRecordService.deleteMaster(scheduleRecord.getId());
        }
    }

//    @Scheduled(cron = "0 0 0 * * ?")
//    public void batchUpdateTuplesGroupSize() {
//        if (Boolean.TRUE.equals(taskEnableConfig.getTaskEnable())) {
//            scheduleRecordService.recordThisRecord(Thread.currentThread() .getStackTrace()[1].getMethodName(),null);
//            userTeamService.batchUpdateTuplesGroupSize(UserAccount.class);
//            scheduleRecordService.recordThisEndTime(Thread.currentThread() .getStackTrace()[1].getMethodName());
//        }
//    }
//
//
//    @Scheduled(cron = "0 55 23 * * ?")
//    public void getPlayerTeamRecord() {
//        if (Boolean.TRUE.equals(taskEnableConfig.getTaskEnable())) {
//            scheduleRecordService.recordThisRecord(Thread.currentThread() .getStackTrace()[1].getMethodName(),null);
//            playerTeamRecordService.getPlayerTeamRecord();
//            scheduleRecordService.recordThisEndTime(Thread.currentThread() .getStackTrace()[1].getMethodName());
//        }
//    }
//
//    @Scheduled(cron = "0 55 23 * * ?")
//    public void keepTodayWispMarket() {
//        if (Boolean.TRUE.equals(taskEnableConfig.getTaskEnable())) {
//            scheduleRecordService.recordThisRecord(Thread.currentThread() .getStackTrace()[1].getMethodName(),null);
//            wispMarketRecordService.keepTodayWispMarket();
//            scheduleRecordService.recordThisEndTime(Thread.currentThread() .getStackTrace()[1].getMethodName());
//        }
//    }

//    @Scheduled(cron = "*/5 * * * * ?")
//    public void autoGet() {
//        if (Boolean.TRUE.equals(taskEnableConfig.getTaskEnable())) {
//            scheduleRecordService.recordThisRecord(Thread.currentThread() .getStackTrace()[1].getMethodName(),null);
//            System.out.println("你好");
//            scheduleRecordService.recordThisEndTime(Thread.currentThread() .getStackTrace()[1].getMethodName());
//        }
//    }
}
