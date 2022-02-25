package com.jfeat.use.admin.services.gen.crud.service.impl;
// ServiceImpl start

            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;
import com.jfeat.use.admin.services.gen.crud.service.CRUDScheduleJobRecordService;
import com.jfeat.use.admin.services.gen.persistence.dao.ScheduleJobRecordMapper;
import com.jfeat.use.admin.services.gen.persistence.model.ScheduleJobRecord;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDScheduleJobRecordService
 * @author Code generator
 * @since 2022-02-25
 */

@Service
public class CRUDScheduleJobRecordServiceImpl  extends CRUDServiceOnlyImpl<ScheduleJobRecord> implements CRUDScheduleJobRecordService {





        @Resource
        protected ScheduleJobRecordMapper scheduleJobRecordMapper;

        @Override
        protected BaseMapper<ScheduleJobRecord> getMasterMapper() {
                return scheduleJobRecordMapper;
        }







}


