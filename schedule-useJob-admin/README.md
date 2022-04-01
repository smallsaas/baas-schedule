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
INSERT 
```


#### 业务层中定时任务代码
> 定时任务末尾加入
> 
> 此处填写定时任务job

```java 
var taskNumber = scheduleRecordService.recordThisRecord("", sessionId));


// 业务层定时任务代码
// end 业务层定时任务代码


// 任务完成后记录时间
scheduleRecordService.recordThisEndTime(taskNumber);
```



