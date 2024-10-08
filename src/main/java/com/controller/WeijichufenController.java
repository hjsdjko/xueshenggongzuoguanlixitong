
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
 * 违纪处分
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/weijichufen")
public class WeijichufenController {
    private static final Logger logger = LoggerFactory.getLogger(WeijichufenController.class);

    @Autowired
    private WeijichufenService weijichufenService;


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
        PageUtils page = weijichufenService.queryPage(params);

        //字典表数据转换
        List<WeijichufenView> list =(List<WeijichufenView>)page.getList();
        for(WeijichufenView c:list){
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
        WeijichufenEntity weijichufen = weijichufenService.selectById(id);
        if(weijichufen !=null){
            //entity转view
            WeijichufenView view = new WeijichufenView();
            BeanUtils.copyProperties( weijichufen , view );//把实体数据重构到view中

                //级联表
                LaoshiEntity laoshi = laoshiService.selectById(weijichufen.getLaoshiId());
                if(laoshi != null){
                    BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLaoshiId(laoshi.getId());
                }
                //级联表
                XueshengEntity xuesheng = xueshengService.selectById(weijichufen.getXueshengId());
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
    public R save(@RequestBody WeijichufenEntity weijichufen, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,weijichufen:{}",this.getClass().getName(),weijichufen.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            weijichufen.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("老师".equals(role))
            weijichufen.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<WeijichufenEntity> queryWrapper = new EntityWrapper<WeijichufenEntity>()
            .eq("xuesheng_id", weijichufen.getXueshengId())
            .eq("laoshi_id", weijichufen.getLaoshiId())
            .eq("weijichufen_uuid_number", weijichufen.getWeijichufenUuidNumber())
            .eq("weijichufen_name", weijichufen.getWeijichufenName())
            .eq("weijichufen_types", weijichufen.getWeijichufenTypes())
            .eq("weijichufen_yesno_types", weijichufen.getWeijichufenYesnoTypes())
            .eq("weijichufen_yesno_text", weijichufen.getWeijichufenYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeijichufenEntity weijichufenEntity = weijichufenService.selectOne(queryWrapper);
        if(weijichufenEntity==null){
            weijichufen.setInsertTime(new Date());
            weijichufen.setWeijichufenYesnoTypes(1);
            weijichufen.setCreateTime(new Date());
            weijichufenService.insert(weijichufen);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WeijichufenEntity weijichufen, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,weijichufen:{}",this.getClass().getName(),weijichufen.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            weijichufen.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("老师".equals(role))
//            weijichufen.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<WeijichufenEntity> queryWrapper = new EntityWrapper<WeijichufenEntity>()
            .notIn("id",weijichufen.getId())
            .andNew()
            .eq("xuesheng_id", weijichufen.getXueshengId())
            .eq("laoshi_id", weijichufen.getLaoshiId())
            .eq("weijichufen_uuid_number", weijichufen.getWeijichufenUuidNumber())
            .eq("weijichufen_name", weijichufen.getWeijichufenName())
            .eq("weijichufen_types", weijichufen.getWeijichufenTypes())
            .eq("insert_time", weijichufen.getInsertTime())
            .eq("weijichufen_yesno_types", weijichufen.getWeijichufenYesnoTypes())
            .eq("weijichufen_yesno_text", weijichufen.getWeijichufenYesnoText())
            .eq("weijichufen_shenhe_time", weijichufen.getWeijichufenShenheTime())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeijichufenEntity weijichufenEntity = weijichufenService.selectOne(queryWrapper);
        if("".equals(weijichufen.getWeijichufenFile()) || "null".equals(weijichufen.getWeijichufenFile())){
                weijichufen.setWeijichufenFile(null);
        }
        if(weijichufenEntity==null){
            weijichufenService.updateById(weijichufen);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody WeijichufenEntity weijichufenEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,weijichufenEntity:{}",this.getClass().getName(),weijichufenEntity.toString());

//        if(weijichufenEntity.getWeijichufenYesnoTypes() == 2){//通过
//            weijichufenEntity.setWeijichufenTypes();
//        }else if(weijichufenEntity.getWeijichufenYesnoTypes() == 3){//拒绝
//            weijichufenEntity.setWeijichufenTypes();
//        }
        weijichufenEntity.setWeijichufenShenheTime(new Date());//审核时间
        weijichufenService.updateById(weijichufenEntity);//审核
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        weijichufenService.deleteBatchIds(Arrays.asList(ids));
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
            List<WeijichufenEntity> weijichufenList = new ArrayList<>();//上传的东西
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
                            WeijichufenEntity weijichufenEntity = new WeijichufenEntity();
//                            weijichufenEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            weijichufenEntity.setLaoshiId(Integer.valueOf(data.get(0)));   //老师 要改的
//                            weijichufenEntity.setWeijichufenUuidNumber(data.get(0));                    //违纪处分编号 要改的
//                            weijichufenEntity.setWeijichufenName(data.get(0));                    //违纪处分名称 要改的
//                            weijichufenEntity.setWeijichufenFile(data.get(0));                    //相关文件 要改的
//                            weijichufenEntity.setWeijichufenTypes(Integer.valueOf(data.get(0)));   //违纪处分类型 要改的
//                            weijichufenEntity.setWeijichufenContent("");//详情和图片
//                            weijichufenEntity.setInsertTime(date);//时间
//                            weijichufenEntity.setWeijichufenYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            weijichufenEntity.setWeijichufenYesnoText(data.get(0));                    //审核意见 要改的
//                            weijichufenEntity.setWeijichufenShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            weijichufenEntity.setCreateTime(date);//时间
                            weijichufenList.add(weijichufenEntity);


                            //把要查询是否重复的字段放入map中
                                //违纪处分编号
                                if(seachFields.containsKey("weijichufenUuidNumber")){
                                    List<String> weijichufenUuidNumber = seachFields.get("weijichufenUuidNumber");
                                    weijichufenUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> weijichufenUuidNumber = new ArrayList<>();
                                    weijichufenUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("weijichufenUuidNumber",weijichufenUuidNumber);
                                }
                        }

                        //查询是否重复
                         //违纪处分编号
                        List<WeijichufenEntity> weijichufenEntities_weijichufenUuidNumber = weijichufenService.selectList(new EntityWrapper<WeijichufenEntity>().in("weijichufen_uuid_number", seachFields.get("weijichufenUuidNumber")));
                        if(weijichufenEntities_weijichufenUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WeijichufenEntity s:weijichufenEntities_weijichufenUuidNumber){
                                repeatFields.add(s.getWeijichufenUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [违纪处分编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        weijichufenService.insertBatch(weijichufenList);
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
