package com.jfeat.module.schedule.oms.services.gen.crud.service.impl;
// ServiceImpl start


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;
import com.jfeat.module.schedule.oms.services.gen.crud.service.CRUDScheduleRecordService;
import com.jfeat.module.schedule.oms.services.gen.persistence.dao.ScheduleRecordMapper;
import com.jfeat.module.schedule.oms.services.gen.persistence.model.ScheduleRecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDSecheduleRecordService
 * @author Code generator
 * @since 2022-03-01
 */

@Service
public class CRUDScheduleRecordServiceImpl extends CRUDServiceOnlyImpl<ScheduleRecord> implements CRUDScheduleRecordService {





        @Resource
        protected ScheduleRecordMapper scheduleRecordMapper;

        @Override
        protected BaseMapper<ScheduleRecord> getMasterMapper() {
                return scheduleRecordMapper;
        }







}


