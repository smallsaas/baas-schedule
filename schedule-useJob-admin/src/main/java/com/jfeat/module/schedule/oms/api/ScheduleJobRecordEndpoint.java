
package com.jfeat.module.schedule.oms.api;


import com.jfeat.crud.plus.META;
import com.jfeat.module.schedule.oms.api.permission.permission.ScheduleJobRecordPermission;
import com.jfeat.module.schedule.oms.services.domain.dao.QueryScheduleJobRecordDao;
import com.jfeat.module.schedule.oms.services.domain.model.ScheduleJobRecordRecord;
import com.jfeat.module.schedule.oms.services.domain.service.ScheduleJobRecordService;
import com.jfeat.module.schedule.oms.services.gen.persistence.model.ScheduleJobRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.dao.DuplicateKeyException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.request.Ids;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.crud.base.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.plus.CRUDObject;
import com.jfeat.crud.plus.DefaultFilterResult;
import java.math.BigDecimal;


    import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import com.alibaba.fastjson.JSONArray;
/**
 * <p>
 *  api
 * </p>
 *
 * @author Code generator
 * @since 2022-02-25
 */
    @RestController
    @Api("ScheduleJobRecord")
            @RequestMapping("/api/crud/admin/scheduleJobRecord/scheduleJobRecords")
    public class ScheduleJobRecordEndpoint {

    @Resource
    ScheduleJobRecordService scheduleJobRecordService;

    @Resource
    QueryScheduleJobRecordDao queryScheduleJobRecordDao;



    @BusinessLog(name = "ScheduleJobRecord", value = "create ScheduleJobRecord")
    @PostMapping
    @ApiOperation(value = "新建 ScheduleJobRecord",response = ScheduleJobRecord.class)
    public Tip createScheduleJobRecord(@RequestBody ScheduleJobRecord entity){
        Integer affected=0;
        try{
                affected= scheduleJobRecordService.createMaster(entity);
            }catch(DuplicateKeyException e){
             throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
}

    @GetMapping("/{id}")
    @ApiOperation(value = "查看 ScheduleJobRecord",response = ScheduleJobRecord.class)
    public Tip getScheduleJobRecord(@PathVariable Long id){
                        return SuccessTip.create(scheduleJobRecordService.queryMasterModel(queryScheduleJobRecordDao, id));
            }

    @BusinessLog(name = "ScheduleJobRecord", value = "update ScheduleJobRecord")
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 ScheduleJobRecord",response = ScheduleJobRecord.class)
    public Tip updateScheduleJobRecord(@PathVariable Long id,@RequestBody ScheduleJobRecord entity){
        entity.setId(id);
                return SuccessTip.create(scheduleJobRecordService.updateMaster(entity));
            }

    @BusinessLog(name = "ScheduleJobRecord", value = "delete ScheduleJobRecord")
    @DeleteMapping("/{id}")
    @ApiOperation("删除 ScheduleJobRecord")
    public Tip deleteScheduleJobRecord(@PathVariable Long id){
            return SuccessTip.create(scheduleJobRecordService.deleteMaster(id));
        }

    @ApiOperation(value = "ScheduleJobRecord 列表信息",response = ScheduleJobRecordRecord.class)
    @GetMapping
    @ApiImplicitParams({
        @ApiImplicitParam(name= "pageNum", dataType = "Integer"),
        @ApiImplicitParam(name= "pageSize", dataType = "Integer"),
        @ApiImplicitParam(name= "search", dataType = "String"),
                                                                                        @ApiImplicitParam(name = "id", dataType = "Long"),
                                                                                            @ApiImplicitParam(name = "jobName", dataType = "String"),
                                                                                                    @ApiImplicitParam(name = "jobGroupName", dataType = "String"),
                                                                                            @ApiImplicitParam(name = "jobClass", dataType = "String"),
                                                                                    @ApiImplicitParam(name = "cron", dataType = "String") ,
                @ApiImplicitParam(name = "orderBy", dataType = "String"),
                @ApiImplicitParam(name = "sort", dataType = "String")
            })
    public Tip queryScheduleJobRecordPage(Page<ScheduleJobRecordRecord> page,
    @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
    @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
    // for tag feature query
    @RequestParam(name = "tag" , required = false)String tag,
    // end tag
    @RequestParam(name = "search", required = false) String search,
                                                                                                                                        
                                                                                                                                    @RequestParam(name = "jobName", required = false) String jobName,
                    
                                                                                                                                            @RequestParam(name = "jobGroupName", required = false) String jobGroupName,
                    
                                                                                                                                    @RequestParam(name = "jobClass", required = false) String jobClass,
                    
                                                                                                                            @RequestParam(name = "cron", required = false) String cron,
        @RequestParam(name = "orderBy", required = false) String orderBy,
        @RequestParam(name = "sort", required = false)  String sort) {
                    
            if(orderBy!=null&&orderBy.length()>0){
        if(sort!=null&&sort.length()>0){
        String pattern = "(ASC|DESC|asc|desc)";
        if(!sort.matches(pattern)){
        throw new BusinessException(BusinessCode.BadRequest.getCode(), "sort must be ASC or DESC");//此处异常类型根据实际情况而定
        }
        }else{
        sort = "ASC";
        }
        orderBy = "`"+orderBy+"`" +" "+sort;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);

    ScheduleJobRecordRecord record = new ScheduleJobRecordRecord();
                                                                                                                                                                                                record.setJobName(jobName);
                                                                                                                                record.setJobGroupName(jobGroupName);
                                                                                                                        record.setJobClass(jobClass);
                                                                                                                record.setCron(cron);
                        
                                

    List<ScheduleJobRecordRecord> scheduleJobRecordPage = queryScheduleJobRecordDao.findScheduleJobRecordPage(page, record, tag, search, orderBy, null, null);

        
        page.setRecords(scheduleJobRecordPage);

        return SuccessTip.create(page);
    }
}

