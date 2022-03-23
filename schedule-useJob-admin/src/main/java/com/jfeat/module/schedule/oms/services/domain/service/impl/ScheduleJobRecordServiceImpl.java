package com.jfeat.module.schedule.oms.services.domain.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jfeat.module.schedule.oms.services.domain.dao.QueryScheduleJobRecordDao;
import com.jfeat.module.schedule.oms.services.domain.dao.QueryScheduleRecordDao;
import com.jfeat.module.schedule.oms.services.domain.model.ScheduleJobRecordRecord;
import com.jfeat.module.schedule.oms.services.domain.model.ScheduleRecordRecord;
import com.jfeat.module.schedule.oms.services.domain.service.ScheduleJobRecordService;
import com.jfeat.module.schedule.oms.services.gen.crud.model.ScheduleJobRecordModel;
import com.jfeat.module.schedule.oms.services.gen.crud.service.impl.CRUDScheduleJobRecordServiceImpl;
import com.jfeat.module.schedule.oms.services.gen.persistence.model.ScheduleRecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */

@Service("scheduleJobRecordService")
public class ScheduleJobRecordServiceImpl extends CRUDScheduleJobRecordServiceImpl implements ScheduleJobRecordService {

    @Resource
    private QueryScheduleJobRecordDao queryScheduleJobRecordDao;
    @Resource
    private QueryScheduleRecordDao queryScheduleRecordDao;

    @Override
    protected String entityName() {
        return "ScheduleJobRecord";

    }

    @Override
    public List<ScheduleJobRecordRecord> queryAllJobAndRecord() {
        var JobList = queryScheduleJobRecordDao.findScheduleJobRecordPage(null,new ScheduleJobRecordRecord(),null,null,null,null,null);
        List<ScheduleJobRecordRecord> scheduleJobRecordList = new ArrayList<>();
        JobList.forEach(
                jobRecord ->{
                    ScheduleJobRecordRecord scheduleJobRecordRecord = new ScheduleJobRecordRecord();
                    scheduleJobRecordRecord.setScheduleRecord(queryScheduleRecordDao.selectList(new LambdaQueryWrapper<ScheduleRecord>().eq(ScheduleRecord::getJobId,jobRecord.getId()).like(ScheduleRecord::getCreateTime, LocalDate.now())));
                    scheduleJobRecordRecord.setJobName(jobRecord.getJobName()).setJobClass(jobRecord.getJobClass()).setJobGroupName(jobRecord.getJobGroupName());
                    scheduleJobRecordList.add(scheduleJobRecordRecord);
                }
        );
        return scheduleJobRecordList;
    }
}
