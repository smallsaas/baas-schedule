# baas-schedule
定时任务管理（未执行任务）

## 需求

定时任务管理需求表
|  序号  | 需求                       | 描述                       |
|------- |---------------------------|----------------------------|
| `#1`   | 配置定时任务               | 配置项目的所有定时任务, 提拱CRUD 管理接口 |
| `#2`   | 创建定时任务执行记录        | 定时任务执行前调用一次服务   |
| `#3`   | 记录定时任务执行时长        | 定时任务执行完成（最后代码段）调用一次服务，更新记录用时字段 `#1` |
| `#4`   | 联合查询当天任务            | 包括未执行任务，已执行任务，超时未执行任务 |
| `#5`   | 手动执行超时未执行任务      |  手工执行定时任务  |


## 后端使用方法


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
INSERT INTO `t_schedule_job_record`(`job_name`, `job_group_name`, `duplicate_task`, `seq`) VALUES ('wispUp', '精灵升级',  0, '场次', 1);
```
| 参数名           | 参数描述            |例子|
|---------------|-----------------|-----|
| job_name      | 定时任务名(英文)       |match|
| job_group_name | 定时任务中文描述        |匹配任务|
| duplicate_task | 定时任务执行场景 （选填）   |场次|
| seq           | 定时任务一天执行次数 （选填） |8|


#### 业务层中定时任务代码

>
> 此`#{jobName}`处填写定时任务jobName
>
> 其中`#{sessionId}`为 `t_schedule_job_record`里的seq，如默认1的可以填null，不为1则填入记录号 如运行场次7 则是填写 7
>
> `#{allowReset}` 值为boolean 类型，为true时定义此定时任务可重复执行，为false时不可重复执行（一天一次）
>  定时任务末尾加入

```java 
var taskNumber = scheduleRecordService.recordThisRecord("#{jobName}", #{sessionId)}, #{allowReset});


// 业务层定时任务代码

// end 业务层定时任务代码


// 任务完成后记录时间
scheduleRecordService.recordThisEndTime(taskNumber);
```

>例子
```
public void automaticReceipt(Long sessionId) {
        //定时任务开始前加入记录
        var taskNumber = scheduleRecordService.recordThisRecord("autoGet",sessionId,false);
        new LambdaQueryChainWrapper<>(wispOrderMapper)
                .eq(WispOrder::getMarketingSessionId, sessionId)
                .eq(WispOrder::getStatus, WispOrderStatus.PAID)
                .list()
                .forEach(wispOrder -> orderReceived(wispOrder.getId(), wispOrder.getSellerPlayId()));
        //定时任务结束时加入结束记录
        scheduleRecordService.recordThisEndTime(taskNumber);
    }
```

#前端对接使用方法
####获取所有定时任务且返回当天最新记录内容
GEt   /api/crud/schedule/allJobAndRecord

| 前端对接字段        | 描述     |
|---------------|--------|
| duplicateTask | 定时任务描述 |
| jobName  | 任务名    |
 |createTime| 创建时间   |
|endTime | 结束时间   |
|useTime | 运行时间   |

###获取定时任务当天记录
GET {{endpoint}}/api/crud/schedule

###获取所有定时任务记录
GET {{endpoint}}/api/crud/schedule/allScheduleRecord

| 前端对接字段     | 描述    |
|------------|-------|
| createTime | 创建时间  |
| endTime    | 结束时间  |
| useTime    | 运行时间  |
| sessionId  | 子任务序号 |
| jobName    | 任务名   |


#前端对接测试用例

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
