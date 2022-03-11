package com.jfeat.module.schedule.oms.services.gen.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code generator
 * @since 2022-03-01
 */
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_schedule_record")
public class ScheduleRecord extends Model<ScheduleRecord> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 运行时间
     */
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
      private LocalDateTime createTime;

      /**
     * 结束时间
     */
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
      private LocalDateTime endTime;

      /**
     * 运行定时任务id
     */
      private Long jobId;

      /**
     * 运行时间(毫秒)
     */
      private Long useTime;

      /**
     * 运行人id
     */
      private Long usePlayerId;
      /**
      *场次id
       */
      private Long sessionId;

    
    public Long getId() {
        return id;
    }

      public ScheduleRecord setId(Long id) {
          this.id = id;
          return this;
      }
    
    public LocalDateTime getCreateTime() {
        return createTime;
    }

      public ScheduleRecord setCreateTime(LocalDateTime createTime) {
          this.createTime = createTime;
          return this;
      }
    
    public LocalDateTime getEndTime() {
        return endTime;
    }

      public ScheduleRecord setEndTime(LocalDateTime endTime) {
          this.endTime = endTime;
          return this;
      }
    
    public Long getJobId() {
        return jobId;
    }

      public ScheduleRecord setJobId(Long jobId) {
          this.jobId = jobId;
          return this;
      }
    
    public Long getUseTime() {
        return useTime;
    }

      public ScheduleRecord setUseTime(Long useTime) {
          this.useTime = useTime;
          return this;
      }
    
    public Long getUsePlayerId() {
        return usePlayerId;
    }

      public ScheduleRecord setUsePlayerId(Long usePlayerId) {
          this.usePlayerId = usePlayerId;
          return this;
      }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public static final String ID = "id";

      public static final String CREATE_TIME = "create_time";

      public static final String END_TIME = "end_time";

      public static final String JOB_ID = "job_id";

      public static final String USE_TIME = "use_time";

      public static final String USE_PLAYER_ID = "use_player_id";

      public static final String SESSION_ID = "session_id";

      @Override
    protected Serializable pkVal() {
          return this.id;
      }

    @Override
    public String toString() {
        return "SecheduleRecord{" +
              "id=" + id +
                  ", createTime=" + createTime +
                  ", endTime=" + endTime +
                  ", jobId=" + jobId +
                  ", useTime=" + useTime +
                  ", usePlayerId=" + usePlayerId +
                  ", sessionId=" + sessionId +
              "}";
    }
}
