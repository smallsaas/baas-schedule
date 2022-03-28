package com.jfeat.module.schedule.oms.services.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfeat.module.schedule.oms.services.gen.persistence.model.ScheduleJobRecord;
import com.jfeat.module.schedule.oms.services.gen.persistence.model.ScheduleRecord;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Code generator on 2022-02-25
 */
@Data
public class ScheduleJobRecordRecord extends ScheduleJobRecord {

    private ScheduleRecord scheduleRecord;
    private String status;
    }
