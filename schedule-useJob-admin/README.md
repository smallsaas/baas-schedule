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
INSERT INTO `t_schedule_job_record`(`job_name`, `job_group_name`, `duplicate_task`, `seq`, `allow_repeat`) VALUES ('test_name', 'notes',  0, '描述', 1, 1);
```
| 参数名            | 参数描述            |例子|
|----------------|-----------------|-----|
| job_name       | 定时任务名(英文)       |match|
| job_group_name | 定时任务中文描述        |匹配任务|
| duplicate_task | 定时任务执行场景 （选填）   |场次|
| seq            | 定时任务一天执行次数 （选填） |8|
| allow_repeat   |定时任务是否可重复执行 默认0|1|



#### 业务层中定时任务代码

> 
> 此`#{jobName}`处填写定时任务jobName
> 
> 其中`#{sessionId}`为 `t_schedule_job_record`里的seq，如默认1的可以填null，不为1则填入记录号 如运行场次7 则是填写 7


```java 
var taskNumber = scheduleRecordService.recordThisRecord("#{jobName}", #{sessionId)});


// 业务层定时任务代码

// end 业务层定时任务代码
```

>
>  定时任务末尾加入
```
// 任务完成后记录时间
scheduleRecordService.recordThisEndTime(taskNumber);
```
###例子
```
public void automaticReceipt(Long sessionId) {
        //定时任务开始前加入记录
        var taskNumber = scheduleRecordService.recordThisRecord("autoGet",sessionId);
        new LambdaQueryChainWrapper<>(wispOrderMapper)
                .eq(WispOrder::getMarketingSessionId, sessionId)
                .eq(WispOrder::getStatus, WispOrderStatus.PAID)
                .list()
                .forEach(wispOrder -> orderReceived(wispOrder.getId(), wispOrder.getSellerPlayId()));
        //定时任务结束时加入结束记录
        scheduleRecordService.recordThisEndTime(taskNumber);
    }
```


#前端对接接口用例

```
@endpoint=http://localhost:8080

@admin = Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJvcmdJZCI6IjEiLCJ1c2VySWQiOiIxIiwidGVuYW50T3JnSWQiOjEsImFjY291bnQiOiJhZG1pbiIsInVzZXJUeXBlIjoxMDAsImRldlVzZXJUeXBlIjowLCJiVXNlclR5cGUiOiJTWVNURU0iLCJpYXQiOjE2NDg0MzE4OTQsImp0aSI6IjEiLCJzdWIiOiJhZG1pbiIsImV4cCI6MTY0ODY5MTA5NH0.e6iAmvMy_PX43pRCpczxrFiCCg-TGGCNG26qYoTQmEQESMJlNqq9q0zuO4SryGGkg2q7bc5ig9DwlGpjuDwbHQ

### 开启定时任务记录name和session必须传入
GET {{endpoint}}/api/crud/schedule/recordScheduleRecord?name= &sessionId=

###获取定时任务当天记录
GET {{endpoint}}/api/crud/schedule

###获取所有定时任务记录
GET {{endpoint}}/api/crud/schedule/allScheduleRecord

###获取所有定时任务且返回当天最新记录内容
GEt {{endpoint}}/api/crud/schedule/allJobAndRecord
Authorization: {{admin}}
```


