
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 评奖评优
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/pingjiangpingyou")
public class PingjiangpingyouController {
    private static final Logger logger = LoggerFactory.getLogger(PingjiangpingyouController.class);

    @Autowired
    private PingjiangpingyouService pingjiangpingyouService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private LaoshiService laoshiService;
    @Autowired
    private XueshengService xueshengService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
//        else if("老师".equals(role))
//            params.put("laoshiId",request.getSession().getAttribute("userId"));
        else if("学生".equals(role))
            params.put("xueshengId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = pingjiangpingyouService.queryPage(params);

        //字典表数据转换
        List<PingjiangpingyouView> list =(List<PingjiangpingyouView>)page.getList();
        for(PingjiangpingyouView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        PingjiangpingyouEntity pingjiangpingyou = pingjiangpingyouService.selectById(id);
        if(pingjiangpingyou !=null){
            //entity转view
            PingjiangpingyouView view = new PingjiangpingyouView();
            BeanUtils.copyProperties( pingjiangpingyou , view );//把实体数据重构到view中

                //级联表
                LaoshiEntity laoshi = laoshiService.selectById(pingjiangpingyou.getLaoshiId());
                if(laoshi != null){
                    BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLaoshiId(laoshi.getId());
                }
                //级联表
                XueshengEntity xuesheng = xueshengService.selectById(pingjiangpingyou.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody PingjiangpingyouEntity pingjiangpingyou, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,pingjiangpingyou:{}",this.getClass().getName(),pingjiangpingyou.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            pingjiangpingyou.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("老师".equals(role))
            pingjiangpingyou.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<PingjiangpingyouEntity> queryWrapper = new EntityWrapper<PingjiangpingyouEntity>()
            .eq("xuesheng_id", pingjiangpingyou.getXueshengId())
            .eq("laoshi_id", pingjiangpingyou.getLaoshiId())
            .eq("pingjiangpingyou_uuid_number", pingjiangpingyou.getPingjiangpingyouUuidNumber())
            .eq("pingjiangpingyou_name", pingjiangpingyou.getPingjiangpingyouName())
            .eq("pingjiangpingyou_types", pingjiangpingyou.getPingjiangpingyouTypes())
            .eq("pingjiangpingyou_yesno_types", pingjiangpingyou.getPingjiangpingyouYesnoTypes())
            .eq("pingjiangpingyou_yesno_text", pingjiangpingyou.getPingjiangpingyouYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PingjiangpingyouEntity pingjiangpingyouEntity = pingjiangpingyouService.selectOne(queryWrapper);
        if(pingjiangpingyouEntity==null){
            pingjiangpingyou.setInsertTime(new Date());
            pingjiangpingyou.setPingjiangpingyouYesnoTypes(1);
            pingjiangpingyou.setCreateTime(new Date());
            pingjiangpingyouService.insert(pingjiangpingyou);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody PingjiangpingyouEntity pingjiangpingyou, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,pingjiangpingyou:{}",this.getClass().getName(),pingjiangpingyou.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            pingjiangpingyou.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("老师".equals(role))
//            pingjiangpingyou.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<PingjiangpingyouEntity> queryWrapper = new EntityWrapper<PingjiangpingyouEntity>()
            .notIn("id",pingjiangpingyou.getId())
            .andNew()
            .eq("xuesheng_id", pingjiangpingyou.getXueshengId())
            .eq("laoshi_id", pingjiangpingyou.getLaoshiId())
            .eq("pingjiangpingyou_uuid_number", pingjiangpingyou.getPingjiangpingyouUuidNumber())
            .eq("pingjiangpingyou_name", pingjiangpingyou.getPingjiangpingyouName())
            .eq("pingjiangpingyou_types", pingjiangpingyou.getPingjiangpingyouTypes())
            .eq("insert_time", pingjiangpingyou.getInsertTime())
            .eq("pingjiangpingyou_yesno_types", pingjiangpingyou.getPingjiangpingyouYesnoTypes())
            .eq("pingjiangpingyou_yesno_text", pingjiangpingyou.getPingjiangpingyouYesnoText())
            .eq("pingjiangpingyou_shenhe_time", pingjiangpingyou.getPingjiangpingyouShenheTime())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PingjiangpingyouEntity pingjiangpingyouEntity = pingjiangpingyouService.selectOne(queryWrapper);
        if("".equals(pingjiangpingyou.getPingjiangpingyouFile()) || "null".equals(pingjiangpingyou.getPingjiangpingyouFile())){
                pingjiangpingyou.setPingjiangpingyouFile(null);
        }
        if(pingjiangpingyouEntity==null){
            pingjiangpingyouService.updateById(pingjiangpingyou);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody PingjiangpingyouEntity pingjiangpingyouEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,pingjiangpingyouEntity:{}",this.getClass().getName(),pingjiangpingyouEntity.toString());

//        if(pingjiangpingyouEntity.getPingjiangpingyouYesnoTypes() == 2){//通过
//            pingjiangpingyouEntity.setPingjiangpingyouTypes();
//        }else if(pingjiangpingyouEntity.getPingjiangpingyouYesnoTypes() == 3){//拒绝
//            pingjiangpingyouEntity.setPingjiangpingyouTypes();
//        }
        pingjiangpingyouEntity.setPingjiangpingyouShenheTime(new Date());//审核时间
        pingjiangpingyouService.updateById(pingjiangpingyouEntity);//审核
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        pingjiangpingyouService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<PingjiangpingyouEntity> pingjiangpingyouList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            PingjiangpingyouEntity pingjiangpingyouEntity = new PingjiangpingyouEntity();
//                            pingjiangpingyouEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            pingjiangpingyouEntity.setLaoshiId(Integer.valueOf(data.get(0)));   //老师 要改的
//                            pingjiangpingyouEntity.setPingjiangpingyouUuidNumber(data.get(0));                    //评奖评优编号 要改的
//                            pingjiangpingyouEntity.setPingjiangpingyouName(data.get(0));                    //评奖评优名称 要改的
//                            pingjiangpingyouEntity.setPingjiangpingyouFile(data.get(0));                    //相关证明文件 要改的
//                            pingjiangpingyouEntity.setPingjiangpingyouTypes(Integer.valueOf(data.get(0)));   //评奖评优类型 要改的
//                            pingjiangpingyouEntity.setPingjiangpingyouContent("");//详情和图片
//                            pingjiangpingyouEntity.setInsertTime(date);//时间
//                            pingjiangpingyouEntity.setPingjiangpingyouYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            pingjiangpingyouEntity.setPingjiangpingyouYesnoText(data.get(0));                    //审核意见 要改的
//                            pingjiangpingyouEntity.setPingjiangpingyouShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            pingjiangpingyouEntity.setCreateTime(date);//时间
                            pingjiangpingyouList.add(pingjiangpingyouEntity);


                            //把要查询是否重复的字段放入map中
                                //评奖评优编号
                                if(seachFields.containsKey("pingjiangpingyouUuidNumber")){
                                    List<String> pingjiangpingyouUuidNumber = seachFields.get("pingjiangpingyouUuidNumber");
                                    pingjiangpingyouUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> pingjiangpingyouUuidNumber = new ArrayList<>();
                                    pingjiangpingyouUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("pingjiangpingyouUuidNumber",pingjiangpingyouUuidNumber);
                                }
                        }

                        //查询是否重复
                         //评奖评优编号
                        List<PingjiangpingyouEntity> pingjiangpingyouEntities_pingjiangpingyouUuidNumber = pingjiangpingyouService.selectList(new EntityWrapper<PingjiangpingyouEntity>().in("pingjiangpingyou_uuid_number", seachFields.get("pingjiangpingyouUuidNumber")));
                        if(pingjiangpingyouEntities_pingjiangpingyouUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(PingjiangpingyouEntity s:pingjiangpingyouEntities_pingjiangpingyouUuidNumber){
                                repeatFields.add(s.getPingjiangpingyouUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [评奖评优编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        pingjiangpingyouService.insertBatch(pingjiangpingyouList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
