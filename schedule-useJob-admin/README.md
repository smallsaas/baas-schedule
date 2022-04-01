## 使用方法


#### pom.xml 
```xml
<dependencies>
  <dependency>
      <groupId>com.jfeat</groupId>
      <artifactId>schedule-useJob-admin</artifactId>
      <version>1.0.0</version>
  </dependency>
</ependencies>
```

#### 在业务层初始化定时任务信息 `t_schedule_job_record`
> 业务层任务定义例子
```
INSERT INTO `t_schedule_job_record`(`job_name`, `job_group_name`, `duplicate_task`, `seq`) VALUES ('test_name', 'notes',  0, '描述', 1);
```
>参数描述
>
>>job_name 定时任务名   如 match
>>
>>job_group_name 定时任务中文描述   如 匹配任务
> >
>>duplicate_task 定时任务执行场景   如 场次
> >
>>seq 定时任务一天执行次数 默认1 如 8 


#### 业务层中定时任务代码

> 
> 此`#{jobName}`处填写定时任务jobName
> 
> 其中`#{sessionId}`为 `t_schedule_job_record`里的seq，如默认1的可以填null，不为1则填入记录号 如运行场次7 则是填写 7
>
>  定时任务末尾加入

```java 
var taskNumber = scheduleRecordService.recordThisRecord("#{jobName}", #{sessionId)});


// 业务层定时任务代码

// end 业务层定时任务代码


// 任务完成后记录时间
scheduleRecordService.recordThisEndTime(taskNumber);
```



