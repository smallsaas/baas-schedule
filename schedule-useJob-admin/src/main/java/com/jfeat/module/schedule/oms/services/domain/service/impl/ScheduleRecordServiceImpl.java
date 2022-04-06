package com.jfeat.module.schedule.oms.services.domain.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.module.oms.util.number.SnowFlake;
import com.jfeat.module.schedule.oms.services.domain.dao.QueryScheduleJobRecordDao;
import com.jfeat.module.schedule.oms.services.domain.dao.QueryScheduleRecordDao;
import com.jfeat.module.schedule.oms.services.domain.service.ScheduleRecordService;
import com.jfeat.module.schedule.oms.services.gen.crud.service.impl.CRUDScheduleRecordServiceImpl;
import com.jfeat.module.schedule.oms.services.gen.persistence.model.ScheduleJobRecord;
import com.jfeat.module.schedule.oms.services.gen.persistence.model.ScheduleRecord;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

import static cn.hutool.core.lang.Console.log;

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
    public String recordThisRecord(String name,Long sessionId,boolean allowReset) {
        var scheduleJob = queryScheduleJobRecordDao.selectOne(new LambdaQueryWrapper<ScheduleJobRecord>().eq(ScheduleJobRecord::getJobName,name));
        if(!allowReset) {
            if (sessionId != null) {
                var record = queryScheduleRecordDao.selectList(new LambdaQueryWrapper<ScheduleRecord>().eq(ScheduleRecord::getJobName, name).like(ScheduleRecord::getEndTime, LocalDateTime.now().toLocalDate())
                        .eq(ScheduleRecord::getSessionId, sessionId));
                if (record.size() != 0) {
                    throw new BusinessException(BusinessCode.BadRequest, "今日运行此任务，无需再运行");
                }
            } else {
                var record = queryScheduleRecordDao.selectOne(new LambdaQueryWrapper<ScheduleRecord>().eq(ScheduleRecord::getJobName, name).like(ScheduleRecord::getEndTime, LocalDateTime.now()));
                if (record != null) {
                    throw new BusinessException(BusinessCode.BadRequest, "今日运行此任务，无需再运行");
                }
            }
        }
        if(sessionId!=null) {
            log("定时任务[" + scheduleJob.getJobGroupName() + sessionId+ "]      ： ============定时任务 开始===================");
        }else{
            log("定时任务[" + scheduleJob.getJobGroupName() + "]      ： ============定时任务 开始===================");
        }
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
        var jobRecord = queryScheduleJobRecordDao.selectOne(new LambdaQueryWrapper<ScheduleJobRecord>().eq(ScheduleJobRecord::getId,schedule.getJobId()));
        if(schedule.getSessionId()!=null) {
            log("定时任务[" + jobRecord.getJobGroupName() + schedule.getSessionId()+ "]      ： ============定时任务 结束===================");
        }else{
            log("定时任务[" + jobRecord.getJobGroupName() + "]      ： ============定时任务 结束===================");
        }
    }
}
