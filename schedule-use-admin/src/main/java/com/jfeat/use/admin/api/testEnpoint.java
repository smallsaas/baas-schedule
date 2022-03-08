package com.jfeat.use.admin.api;

import com.jfeat.use.admin.services.domain.service.ScheduleRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/hello")
@RestController
public class testEnpoint {

    @Resource
    private ScheduleRecordService scheduleRecordService;

    @GetMapping
    public void transferCoins() {
        scheduleRecordService.recordThisRecord("test1");
        System.out.println("你好");
        scheduleRecordService.recordThisEndTime("test1");
    }
}
