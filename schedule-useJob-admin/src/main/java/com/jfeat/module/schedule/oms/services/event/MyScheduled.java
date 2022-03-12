package com.jfeat.module.schedule.oms.services.event;

import com.jfeat.module.schedule.oms.services.domain.service.ScheduleRecordService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MyScheduled {
    @Resource
    ScheduleRecordService scheduleRecordService;
//    @Value("${toggle.task-enable}")
//    private Boolean taskEnable;
//    @Resource
//    private TaskEnableConfig taskEnableConfig;

//    @Scheduled(cron = "*/10 * * * * ?")
//    public void updateAllPlayerLevel() {
//        for (int i=0;i<10000;i++) {
//            var s = scheduleRecordService.recordThisRecord(Thread.currentThread().getStackTrace()[1].getMethodName(), null);
//            System.out.println(i+"------------");
//            scheduleRecordService.recordThisEndTime(s);
//        }
//    }

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
