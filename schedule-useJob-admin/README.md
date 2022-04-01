使用方法

1、先新增你要记录的定时任务信息在t_schedule_job_record表里

2、在定时任务头部加上

var s = scheduleRecordService.recordThisRecord("此处填写定时任务job",sessionId);

定时任务末尾加入

scheduleRecordService.recordThisEndTime(s);