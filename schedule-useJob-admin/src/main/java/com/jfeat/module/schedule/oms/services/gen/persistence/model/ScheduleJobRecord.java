package com.jfeat.module.schedule.oms.services.gen.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code generator
 * @since 2022-02-25
 */
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_schedule_job_record")
public class ScheduleJobRecord extends Model<ScheduleJobRecord> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 定时任务名字(英文大写)
     */
      private String jobName;

      /**
     * 定时任务组名
     */
      private String jobGroupName;

      /**
     * 任务
     */
      private String jobClass;

      /**
     * 时间设置
     */
      private String cron;
      private Integer deleteFlag;
      private String duplicateTask;
      private Integer seq;

    
    public Long getId() {
        return id;
    }

      public ScheduleJobRecord setId(Long id) {
          this.id = id;
          return this;
      }
    
    public String getJobName() {
        return jobName;
    }

      public ScheduleJobRecord setJobName(String jobName) {
          this.jobName = jobName;
          return this;
      }
    
    public String getJobGroupName() {
        return jobGroupName;
    }

      public ScheduleJobRecord setJobGroupName(String jobGroupName) {
          this.jobGroupName = jobGroupName;
          return this;
      }
    
    public String getJobClass() {
        return jobClass;
    }

      public ScheduleJobRecord setJobClass(String jobClass) {
          this.jobClass = jobClass;
          return this;
      }
    
    public String getCron() {
        return cron;
    }

      public ScheduleJobRecord setCron(String cron) {
          this.cron = cron;
          return this;
      }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public ScheduleJobRecord setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
        return this;
    }

    public String getDuplicateTask() {
        return duplicateTask;
    }

    public void setDuplicateTask(String duplicateTask) {
        this.duplicateTask = duplicateTask;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public static final String ID = "id";

      public static final String JOB_NAME = "job_name";

      public static final String JOB_GROUP_NAME = "job_group_name";

      public static final String JOB_CLASS = "job_class";

      public static final String CRON = "cron";

      public static final String DELETE_FLAG = "delete_flag";

      public static final String DUPLICATE_TASK = "duplicate_task";

      public static final String SEQ = "seq";

      @Override
    protected Serializable pkVal() {
          return this.id;
      }

    @Override
    public String toString() {
        return "ScheduleJobRecord{" +
                "id=" + id +
                ", jobName='" + jobName + '\'' +
                ", jobGroupName='" + jobGroupName + '\'' +
                ", jobClass='" + jobClass + '\'' +
                ", cron='" + cron + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", duplicateTask='" + duplicateTask + '\'' +
                ", seq=" + seq +
                '}';
    }
}
