package com.jfeat.use.admin.services.gen.persistence.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code generator
 * @since 2022-02-25
 */
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

      public static final String ID = "id";

      public static final String JOB_NAME = "job_name";

      public static final String JOB_GROUP_NAME = "job_group_name";

      public static final String JOB_CLASS = "job_class";

      public static final String CRON = "cron";

      @Override
    protected Serializable pkVal() {
          return this.id;
      }

    @Override
    public String toString() {
        return "ScheduleJobRecord{" +
              "id=" + id +
                  ", jobName=" + jobName +
                  ", jobGroupName=" + jobGroupName +
                  ", jobClass=" + jobClass +
                  ", cron=" + cron +
              "}";
    }
}
