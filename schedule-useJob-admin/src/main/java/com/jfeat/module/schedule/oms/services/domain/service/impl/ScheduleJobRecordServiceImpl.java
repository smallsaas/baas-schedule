package com.jfeat.module.schedule.oms.services.domain.service.impl;
import com.jfeat.module.schedule.oms.services.domain.service.ScheduleJobRecordService;
import com.jfeat.module.schedule.oms.services.gen.crud.service.impl.CRUDScheduleJobRecordServiceImpl;
import org.springframework.stereotype.Service;

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

    @Override
    protected String entityName() {
        return "ScheduleJobRecord";
    }


                            }
