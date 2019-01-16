/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package tk.mybatis.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tk.mybatis.springboot.jobenum.SelectStatusEnum;
import tk.mybatis.springboot.model.GroupEntry;
import tk.mybatis.springboot.model.JobClass;
import tk.mybatis.springboot.model.JobDetailPojo;
import tk.mybatis.springboot.model.JobWatcher;
import tk.mybatis.springboot.model.RJob;
import tk.mybatis.springboot.model.RJobMessageentry;
import tk.mybatis.springboot.model.RJobMsghistory;
import tk.mybatis.springboot.model.RServerNode;

/**
 * @author hujunfeng
 * @since 2015-12-19 11:10
 */

@CrossOrigin
@Api(value="/v1/frontend", tags="Job 功能列表")
@RestController
@RequestMapping("/v1/frontend")
public class FrontendJobController {

    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(value="获取job的列表", notes = "=== === ===")
    @RequestMapping(value = "/page/{page}",method={RequestMethod.GET})
    public PageInfo<RJob> getAllJobs(@PathVariable Integer page) {
        PageInfo<RJob> pojo = null;
        pojo = this.restTemplate.getForObject("http://microservice-spring-job/v1/job/page/"+page,PageInfo.class);
        return pojo;
    }

    @ApiOperation(value="设置修改job", notes = "根据前端传来的参数,更新修改job在数据库中的信息")
    @RequestMapping(value="/modify/jobdetail", method={RequestMethod.POST})
    public JobDetailPojo modifyJobDetail(JobDetailPojo jobDetailPojo) {
        ResponseEntity<JobDetailPojo> responseEntity = restTemplate.postForEntity("http://microservice-spring-job/v1/job/modify/jobdetail", jobDetailPojo, JobDetailPojo.class);
        return responseEntity.getBody();
    }




    @ApiOperation(value="设置修改watcher", notes = "根据前端传来的参数,更新修改警报器在数据库中的信息")
    @RequestMapping(value="/modify/watcher/detail", method={RequestMethod.POST})
    public JobDetailPojo modifyWatchDetail(JobDetailPojo jobDetailPojo) {
        ResponseEntity<JobDetailPojo> responseEntity =
                restTemplate.postForEntity("http://microservice-spring-job/v1/job/modify/watcher/detail", jobDetailPojo, JobDetailPojo.class);
        return responseEntity.getBody();
    }





    @ApiOperation(value="修改job的状态", notes = "根据job id修改job的状态, 为了设置job的生命周期的各种状态")
    @GetMapping(value="/setting/jobstatus/{id}/{status}")
    public JobDetailPojo settingJobStatus(@PathVariable Long id, @PathVariable Integer status){
        JobDetailPojo pojo = null;
        pojo = this.restTemplate.getForObject("http://microservice-spring-job/v1/job/setting/jobstatus/"+id+"/" + status, JobDetailPojo.class);
        return pojo;
    }

    @ApiOperation(value="job 详情", notes = "根据job id获取job的详细信息")
    @RequestMapping(value = "/detail/id/{id}",method={RequestMethod.GET})
    public JobDetailPojo jobDetailById(@PathVariable Integer id) {
        JobDetailPojo pojo = null;
        pojo = this.restTemplate.getForObject("http://microservice-spring-job/v1/job/detail/id/" + id, JobDetailPojo.class);
        return pojo;
    }

    @ApiOperation(value="执行job", notes = "根据job id执行job任务")
    @RequestMapping(value = "/executeid/id/{id}",method={RequestMethod.GET})
    public JobDetailPojo jobExecuteById(@PathVariable Integer id) {
        JobDetailPojo pojo = null;
        pojo = this.restTemplate.getForObject("http://spring-boot-mq/v1/mq/executeid/id/" + id, JobDetailPojo.class);
        return pojo;
    }

    @ApiOperation(value="重启job", notes = "根据job id重启job任务")
    @RequestMapping(value = "/restart/job/id/{id}",method={RequestMethod.GET})
    public JobDetailPojo restartExecuteById(@PathVariable Integer id) throws Exception{
        JobDetailPojo pojo = null;
        pojo = this.restTemplate.getForObject("http://microservice-spring-job/v1/job/restart/job/id/"+id, JobDetailPojo.class);
        return pojo;
    }



    @ApiOperation(value="job 简要信息", notes = "根据job id获取job的简要信息")
    @RequestMapping(value = "/simplejobinfo/id/{id}",method={RequestMethod.GET})
    public JobDetailPojo jobSimpleInfoById(@PathVariable Integer id) {
        JobDetailPojo pojo = null;
        pojo = this.restTemplate.getForObject("http://microservice-spring-job/v1/job/simplejobinfo/id/"+id, JobDetailPojo.class);
        return pojo;
    }

    @ApiOperation(value="job 图表信息", notes = "根据job name获取job 6分钟数据的简要图表")
    @RequestMapping(value = "/simplejobinfo/stat/jobname/{name}",method={RequestMethod.GET})
    public List<Integer> jobSimpleInfoStat(@PathVariable String name) {
        List<Integer> listPojo = null;
        listPojo = this.restTemplate.getForObject("http://microservice-spring-job/v1/job/simplejobinfo/stat/jobname/" + name, ArrayList.class);
        return  listPojo;
    }




    @ApiOperation(value="根据3级分类ID查询所有的job", notes = "=== === ===")
    @RequestMapping(value = "/query/condition/list",method={RequestMethod.GET})
    public  PageInfo<JobDetailPojo>  queryConditionList(@RequestParam(value="nodeVal",required=false) Integer nodeVal,
                                                        @RequestParam(value="status",required=false) Integer status,
                                                        @RequestParam(value="redpoint",required=false) Integer redpoint,
                                                        @RequestParam(value="page",required=false) Integer page) {
        System.out.println("nodeVal = " + nodeVal);
        System.out.println("status = " + status);
        System.out.println("redpoint = " + redpoint);
        System.out.println("page = " + page);
        if(status == null) status = SelectStatusEnum.getName("默认");
        if(nodeVal == null) nodeVal =  SelectStatusEnum.getName("默认");
        if(redpoint == null) redpoint = SelectStatusEnum.getName("默认");
        if(page == null) page = SelectStatusEnum.getName("默认");
        //页面传输对象
        PageInfo<JobDetailPojo> responseEntity = restTemplate.getForObject("http://microservice-spring-job/v1/job/query/by/condition?nodeVal="+nodeVal+"&status="+status+"&redpoint="+redpoint+"&page="+page, PageInfo.class);
        return responseEntity;

    }


    @ApiOperation(value="job状态统计功能", notes = "查所有的job信息, 并按照状态分组")
    @RequestMapping(value = "/query/all/status/group",method={RequestMethod.GET})
    public JobDetailPojo getAllStatus() {
        JobDetailPojo pojo = new JobDetailPojo(200,"请求成功");
        Map<Object,Object> allStatusMap = this.restTemplate.getForObject("http://microservice-spring-job/v1/job/query/all/status/group", Map.class);
        pojo.setCacheMap(allStatusMap);
        return  pojo;
    }

    @ApiOperation(value="拉取job 的日志", notes = " ")
    @RequestMapping(value = "/fetch/log/jobid/{jobId}",method={RequestMethod.GET})
    public JobDetailPojo fetchLogById(@PathVariable Integer jobId) {
        JobDetailPojo pojo = null;
        //按ID获取日志
        pojo = this.restTemplate.getForObject("http://microservice-spring-job/v1/job/fetch/log/jobid/"+jobId, JobDetailPojo.class);
        return  pojo;
    }

    @ApiOperation(value="开始watcher", notes = "jobId : 任务ID")
    @RequestMapping(value = "/watcher/start/jobid/{jobId}",method={RequestMethod.GET})
    public JobDetailPojo startWatcherById(@PathVariable Integer jobId){
        return this.restTemplate.getForObject("http://microservice-spring-job/v1/job/watcher/start/jobid/" + jobId , JobDetailPojo.class);
    }
    @ApiOperation(value="停止watcher", notes = "jobId : 任务ID")
    @RequestMapping(value = "/watcher/stop/jobid/{jobId}",method={RequestMethod.GET})
    public JobDetailPojo InterruptWatcherEntry(@PathVariable Integer jobId){
        //结果返回
        return this.restTemplate.getForObject("http://microservice-spring-job/v1/job/watcher/stop/jobid/" + jobId , JobDetailPojo.class);
    }
    @ApiOperation(value="删除watcher", notes = "jobId : 任务ID")
    @RequestMapping(value = "/watcher/destory/jobid/{jobId}",method={RequestMethod.GET})
    public JobDetailPojo destoryWatcherEntry(@PathVariable Integer jobId){
        //结果返回
        return this.restTemplate.getForObject("http://microservice-spring-job/v1/job/watcher/destory/jobid/" + jobId , JobDetailPojo.class);
    }

    @ApiOperation(value="获取所有服务器的列表", notes = "=== === ===")
    @RequestMapping(value = "/server/nodes/{page}",method={RequestMethod.GET})
    public PageInfo<JobDetailPojo> getAllServer(@PathVariable Integer page) {
        //结果返回
        List<JobDetailPojo> list = this.restTemplate.getForObject("http://microservice-spring-job/v1/job/server/nodes/" + page , List.class);

        return new PageInfo<JobDetailPojo>(list);
    }

    @ApiOperation(value="获取服务器组的资源信息", notes = "=== === ===")
    @RequestMapping(value = "/get/cluster/monitoring",method={RequestMethod.GET})
    public String getClustersMonitoring() {
        return this.restTemplate.getForObject("http://microservice-spring-job/v1/job/get/cluster/monitoring"  , String.class);
    }

    @ApiOperation(value="按照ID获取watcher", notes = "=== === ===")
    @RequestMapping(value = "/watcher/detail/{jobId}",method={RequestMethod.GET})
    public  JobDetailPojo  getWatcherById(@PathVariable Integer jobId) {
        JobDetailPojo pojo = null;
        pojo = this.restTemplate.getForObject("http://microservice-spring-job/v1/job/detail/id/" + jobId, JobDetailPojo.class);
        JobWatcher jobWatcher = this.restTemplate.getForObject("http://microservice-spring-job/v1/job/watcher/detail/" + jobId , JobWatcher.class);
        pojo.setDataAmount(jobWatcher.getDataAmount());
        pojo.setPercentage(jobWatcher.getPercentage()*100);
        pojo.setTimeSecond(jobWatcher.getTimeSecond());
        pojo.setStatus(jobWatcher.getStatus());
        return pojo;
    }


    @ApiOperation(value="按照分类ID获取watcher的列表", notes = "=== === ===")
    @RequestMapping(value = "/watcher/category/cateid/{page}/{cid}",method={RequestMethod.GET})
    public PageInfo<JobDetailPojo> getAllWatcherByCategoryId( @PathVariable Integer cid, @PathVariable Integer page) {
        PageInfo<JobDetailPojo> list = this.restTemplate.getForObject("http://microservice-spring-job/v1/job/watcher/category/cateid/"+page+"/"+cid , PageInfo.class);
        //页面传输对象
        return list;
    }

    @ApiOperation(value="watch信息创建接口", notes = "")
    @RequestMapping(value="/watcher/modify", method={RequestMethod.POST})
    public JobDetailPojo addWatcherEntry(JobDetailPojo record){
        System.out.println("record = " + record);
        //结果返回
        ResponseEntity<JobDetailPojo> responseEntity = restTemplate.postForEntity("http://microservice-spring-job/v1/job/watcher/modify", record, JobDetailPojo.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="删除job", notes = "根据job id把job的状态设置为 [删除]")
    @GetMapping(value="/delete/job/jobstatus/{id}")
    public JobDetailPojo deleteJobByID(@PathVariable Long id){
        JobDetailPojo pojo = null;
        pojo = this.restTemplate.getForObject("http://microservice-spring-job/v1/job/delete/job/jobid/"+id , JobDetailPojo.class);
        return pojo;
    }


    @ApiOperation(value="job终止功能", notes = "按照job name从线程池中查出此线程并进行终止,优雅退出.")
    @RequestMapping(value = "/interrupt/job/id/{jobId}",method={RequestMethod.GET})
    public JobDetailPojo invokeThreadInterruptByJobName(@PathVariable Integer jobId) {
        JobDetailPojo pojo = null;
        pojo = this.restTemplate.getForObject("http://spring-boot-mq/v1/mq/stopcmd/id/" + jobId, JobDetailPojo.class);
        return pojo;
    }

    @ApiOperation(value="重置watcher", notes = "重置watcher是指将报警状态设置为初始化状态, 以供二次修改")
    @RequestMapping(value = "/watcher/restart/jobid/{jobId}",method={RequestMethod.GET})
    public JobDetailPojo restartWatcherById(@PathVariable Integer jobId){
        return this.restTemplate.getForObject("http://microservice-spring-job/v1/job/watcher/reset/jobid/" + jobId , JobDetailPojo.class);
    }

    @ApiOperation(value="获取分组计算", notes = "=== === ===")
    @RequestMapping(value = "/analysis/groupby",method={RequestMethod.GET})
    public  PageInfo<GroupEntry> analysisGroupByCondition() {
        return this.restTemplate.getForObject("http://microservice-spring-job/v1/job/analysis/groupby"  , PageInfo.class);

    }

    @ApiOperation(value="获取所有job的日志图表", notes = "=== === ===")
    @RequestMapping(value = "/analysis/chars",method={RequestMethod.GET})
    public JobDetailPojo analysis() {
        return this.restTemplate.getForObject("http://microservice-spring-job/v1/job/analysis/chars"  , JobDetailPojo.class);
    }

    @ApiOperation(value="按照ID获取job的日志量图表", notes = "=== === ===")
    @RequestMapping(value = "/analysis/chars/{jobid}",method={RequestMethod.GET})
    public JobDetailPojo analysisByConditionId(@PathVariable Integer jobid) {
        return this.restTemplate.getForObject("http://microservice-spring-job/v1/job/analysis/chars/" + jobid , JobDetailPojo.class);
    }



    @ApiOperation(value="获取本系统所有的消息通道", notes = "取本系统所有的消息通道")
    @RequestMapping(value = "/all/message/channels",method={RequestMethod.GET})
    public PageInfo<RJobMessageentry>  allMessageChannels() throws Exception{
        PageInfo<RJobMessageentry> pojo = null;
        pojo = this.restTemplate.getForObject("http://microservice-spring-job/v1/job/all/message/channels",PageInfo.class);
        return pojo;
    }


    @ApiOperation(value="新增通道", notes = "在数据库增加一条信息下发通道")
    @RequestMapping(value = "/add/message/channels",method={RequestMethod.POST})
    public JobDetailPojo  addMessageChannels(@RequestBody RJobMessageentry pojo) throws Exception{
        //结果返回
        ResponseEntity<JobDetailPojo> responseEntity =
                restTemplate.postForEntity("http://microservice-spring-job/v1/job/add/message/channels", pojo, JobDetailPojo.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="修改通道", notes = "修改通道基本信息")
    @RequestMapping(value = "/update/message/channels",method={RequestMethod.POST})
    public JobDetailPojo  updateMessageChannels(@RequestBody RJobMessageentry pojo) throws Exception{
        //结果返回
        ResponseEntity<JobDetailPojo> responseEntity =
                restTemplate.postForEntity("http://microservice-spring-job/v1/job/update/message/channels", pojo, JobDetailPojo.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="查询通道", notes = "根据id查询通道")
    @RequestMapping(value = "/restart/query/channel/id/{id}",method={RequestMethod.GET})
    public RJobMessageentry queryByPrimaryKey(@PathVariable Integer id) throws Exception{
        //结果返回
        return this.restTemplate.getForObject("http://microservice-spring-job/v1/job/restart/query/channel/id/" + id , RJobMessageentry.class);
    }

    @ApiOperation(value="分类查询", notes = "根据分类父id查询出所有的子分类")
    @RequestMapping(value = "/query/list/classes/id/{id}",method={RequestMethod.GET})
    public PageInfo<JobClass>  queryListClassesId(@PathVariable Integer id) throws Exception{
        //结果返回
        return this.restTemplate.getForObject("http://microservice-spring-job/v1/job/query/list/classes/id/" + id , PageInfo.class);
    }

    @ApiOperation(value="获取警报的警报发送历史", notes = "根据job id, 获取警报的警报发送历史")
    @RequestMapping(value = "/query/history/watcher/{id}/{page}",method={RequestMethod.GET})
    public PageInfo<RJobMsghistory>  queryListWatcherHistoryId(@PathVariable Integer id, @PathVariable Integer page) throws Exception{
        //结果返回
        return this.restTemplate.getForObject("http://microservice-spring-job/v1/job/query/history/watcher/" + id +"/" + page, PageInfo.class);
    }

    @ApiOperation(value="获取所有的警报发送通道", notes = "获取所有的警报发送通道")
    @RequestMapping(value = "/query/messagechannel/list",method={RequestMethod.GET})
    public PageInfo<RJobMessageentry>  queryMessageChannelList() throws Exception{
        return this.restTemplate.getForObject("http://microservice-spring-job/v1/job/query/messagechannel/list" , PageInfo.class);
    }

    @ApiOperation(value="获取所有的警报发送通道", notes = "获取所有的警报发送通道")
    @RequestMapping(value = "/query/servernode/list",method={RequestMethod.GET})
    public PageInfo<RServerNode>  queryServerNodeList() throws Exception{
        //结果返回
        return this.restTemplate.getForObject("http://microservice-spring-job/v1/job/query/servernode/list" , PageInfo.class);
    }




    @ApiOperation(value="服务器修改接口", notes = "服务器修改接口 , 包括了新增和修改")
    @RequestMapping(value="/modify/server/node", method={RequestMethod.POST})
    public JobDetailPojo createOrCreaterServerNode(RServerNode  rServerNode){
        ResponseEntity<JobDetailPojo> responseEntity = restTemplate.postForEntity("http://microservice-spring-job/v1/job/modify/server/node", rServerNode, JobDetailPojo.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="下发通道修改接口", notes = "根据前端传来的参数,更新修改job在数据库中的信息")
    @RequestMapping(value="/modify/message/channel/entity", method={RequestMethod.POST})
    public JobDetailPojo createOrCreaterMessageChannel(RJobMessageentry  entry){
        ResponseEntity<JobDetailPojo> responseEntity = restTemplate.postForEntity("http://microservice-spring-job/v1/job/modify/message/channel/entity", entry, JobDetailPojo.class);
        return responseEntity.getBody();
    }

}

