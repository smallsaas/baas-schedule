package com.jfeat.module.schedule.oms.services.domain.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jfeat.module.oms.util.number.SnowFlake;
import com.jfeat.module.schedule.oms.services.domain.dao.QueryScheduleJobRecordDao;
import com.jfeat.module.schedule.oms.services.domain.dao.QueryScheduleRecordDao;
import com.jfeat.module.schedule.oms.services.domain.service.ScheduleRecordService;
import com.jfeat.module.schedule.oms.services.gen.crud.service.impl.CRUDScheduleRecordServiceImpl;
import com.jfeat.module.schedule.oms.services.gen.persistence.model.ScheduleJobRecord;
import com.jfeat.module.schedule.oms.services.gen.persistence.model.ScheduleRecord;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */

@Component
@Service("scheduleRecordService")
public class ScheduleRecordServiceImpl extends CRUDScheduleRecordServiceImpl implements ScheduleRecordService {

    @Resource
    private QueryScheduleJobRecordDao queryScheduleJobRecordDao;
    @Resource
    private QueryScheduleRecordDao queryScheduleRecordDao;

    @Override
    protected String entityName() {
        return "ScheduleRecord";
    }

    @Override
    public String recordThisRecord(String name,Long sessionId) {
        var scheduleJob = queryScheduleJobRecordDao.selectOne(new LambdaQueryWrapper<ScheduleJobRecord>().eq(ScheduleJobRecord::getJobName,name));
        ScheduleRecord scheduleRecord = new ScheduleRecord();
        scheduleRecord.setCreateTime(LocalDateTime.now()).setJobId(scheduleJob.getId());
        if(sessionId!=null){
            scheduleRecord.setSessionId(sessionId);
        }
        var snowFlake = new SnowFlake(0,0);
        scheduleRecord.setScheduleNumber(snowFlake.generateIdNumber("",4));
        scheduleRecord.setUseTime(System.currentTimeMillis());
        scheduleRecord.setJobName(name);
        this.createMaster(scheduleRecord);
        //返回唯一标识
        return scheduleRecord.getScheduleNumber();
    }

    @Override
    public void recordThisEndTime(String number) {
//        var scheduleJob = queryScheduleJobRecordDao.selectOne(new LambdaQueryWrapper<ScheduleJobRecord>().eq(ScheduleJobRecord::getJobName,name));
        var schedule = queryScheduleRecordDao.selectOne(new LambdaQueryWrapper<ScheduleRecord>().eq(ScheduleRecord::getScheduleNumber,number));
        schedule.setEndTime(LocalDateTime.now());
        var time = java.time.Duration.between(schedule.getCreateTime() , schedule.getEndTime()).toMinutes();
        System.out.println(schedule.getUseTime() +"      "+ time);
        var ms = System.currentTimeMillis() - schedule.getUseTime();
        schedule.setUseTime(time*1000 +ms);
        this.updateMaster(schedule,false);
    }
}
