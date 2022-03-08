package com.jfeat.use.admin.services.domain.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jfeat.use.admin.services.domain.dao.QueryScheduleJobRecordDao;
import com.jfeat.use.admin.services.domain.dao.QueryScheduleRecordDao;
import com.jfeat.use.admin.services.domain.service.ScheduleRecordService;
import com.jfeat.use.admin.services.gen.crud.service.impl.CRUDScheduleRecordServiceImpl;
import com.jfeat.use.admin.services.gen.persistence.model.ScheduleJobRecord;
import com.jfeat.use.admin.services.gen.persistence.model.ScheduleRecord;
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
    public void recordThisRecord(String name) {
        var scheduleJob = queryScheduleJobRecordDao.selectOne(new LambdaQueryWrapper<ScheduleJobRecord>().eq(ScheduleJobRecord::getJobName,name));
        ScheduleRecord scheduleRecord = new ScheduleRecord();
        scheduleRecord.setCreateTime(LocalDateTime.now()).setJobId(scheduleJob.getId());
        this.createMaster(scheduleRecord);
    }

    @Override
    public void recordThisEndTime(String name) {
        var scheduleJob = queryScheduleJobRecordDao.selectOne(new LambdaQueryWrapper<ScheduleJobRecord>().eq(ScheduleJobRecord::getJobName,name));
        var schedule = queryScheduleRecordDao.queryLastRecord(scheduleJob.getId());
        schedule.setEndTime(LocalDateTime.now());
        this.updateMaster(schedule,false);
    }
}
