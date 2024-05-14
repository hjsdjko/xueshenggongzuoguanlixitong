
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
 * 学生资助
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xueshengzizhu")
public class XueshengzizhuController {
    private static final Logger logger = LoggerFactory.getLogger(XueshengzizhuController.class);

    @Autowired
    private XueshengzizhuService xueshengzizhuService;


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
        PageUtils page = xueshengzizhuService.queryPage(params);

        //字典表数据转换
        List<XueshengzizhuView> list =(List<XueshengzizhuView>)page.getList();
        for(XueshengzizhuView c:list){
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
        XueshengzizhuEntity xueshengzizhu = xueshengzizhuService.selectById(id);
        if(xueshengzizhu !=null){
            //entity转view
            XueshengzizhuView view = new XueshengzizhuView();
            BeanUtils.copyProperties( xueshengzizhu , view );//把实体数据重构到view中

                //级联表
                LaoshiEntity laoshi = laoshiService.selectById(xueshengzizhu.getLaoshiId());
                if(laoshi != null){
                    BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLaoshiId(laoshi.getId());
                }
                //级联表
                XueshengEntity xuesheng = xueshengService.selectById(xueshengzizhu.getXueshengId());
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
    public R save(@RequestBody XueshengzizhuEntity xueshengzizhu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xueshengzizhu:{}",this.getClass().getName(),xueshengzizhu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            xueshengzizhu.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("老师".equals(role))
            xueshengzizhu.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XueshengzizhuEntity> queryWrapper = new EntityWrapper<XueshengzizhuEntity>()
            .eq("xuesheng_id", xueshengzizhu.getXueshengId())
            .eq("laoshi_id", xueshengzizhu.getLaoshiId())
            .eq("xueshengzizhu_uuid_number", xueshengzizhu.getXueshengzizhuUuidNumber())
            .eq("xueshengzizhu_name", xueshengzizhu.getXueshengzizhuName())
            .eq("xueshengzizhu_types", xueshengzizhu.getXueshengzizhuTypes())
            .eq("xueshengzizhu_yesno_types", xueshengzizhu.getXueshengzizhuYesnoTypes())
            .eq("xueshengzizhu_yesno_text", xueshengzizhu.getXueshengzizhuYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XueshengzizhuEntity xueshengzizhuEntity = xueshengzizhuService.selectOne(queryWrapper);
        if(xueshengzizhuEntity==null){
            xueshengzizhu.setInsertTime(new Date());
            xueshengzizhu.setXueshengzizhuYesnoTypes(1);
            xueshengzizhu.setCreateTime(new Date());
            xueshengzizhuService.insert(xueshengzizhu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XueshengzizhuEntity xueshengzizhu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xueshengzizhu:{}",this.getClass().getName(),xueshengzizhu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            xueshengzizhu.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("老师".equals(role))
//            xueshengzizhu.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<XueshengzizhuEntity> queryWrapper = new EntityWrapper<XueshengzizhuEntity>()
            .notIn("id",xueshengzizhu.getId())
            .andNew()
            .eq("xuesheng_id", xueshengzizhu.getXueshengId())
            .eq("laoshi_id", xueshengzizhu.getLaoshiId())
            .eq("xueshengzizhu_uuid_number", xueshengzizhu.getXueshengzizhuUuidNumber())
            .eq("xueshengzizhu_name", xueshengzizhu.getXueshengzizhuName())
            .eq("xueshengzizhu_types", xueshengzizhu.getXueshengzizhuTypes())
            .eq("insert_time", xueshengzizhu.getInsertTime())
            .eq("xueshengzizhu_yesno_types", xueshengzizhu.getXueshengzizhuYesnoTypes())
            .eq("xueshengzizhu_yesno_text", xueshengzizhu.getXueshengzizhuYesnoText())
            .eq("xueshengzizhu_shenhe_time", xueshengzizhu.getXueshengzizhuShenheTime())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XueshengzizhuEntity xueshengzizhuEntity = xueshengzizhuService.selectOne(queryWrapper);
        if("".equals(xueshengzizhu.getXueshengzizhuFile()) || "null".equals(xueshengzizhu.getXueshengzizhuFile())){
                xueshengzizhu.setXueshengzizhuFile(null);
        }
        if(xueshengzizhuEntity==null){
            xueshengzizhuService.updateById(xueshengzizhu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody XueshengzizhuEntity xueshengzizhuEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,xueshengzizhuEntity:{}",this.getClass().getName(),xueshengzizhuEntity.toString());

//        if(xueshengzizhuEntity.getXueshengzizhuYesnoTypes() == 2){//通过
//            xueshengzizhuEntity.setXueshengzizhuTypes();
//        }else if(xueshengzizhuEntity.getXueshengzizhuYesnoTypes() == 3){//拒绝
//            xueshengzizhuEntity.setXueshengzizhuTypes();
//        }
        xueshengzizhuEntity.setXueshengzizhuShenheTime(new Date());//审核时间
        xueshengzizhuService.updateById(xueshengzizhuEntity);//审核
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xueshengzizhuService.deleteBatchIds(Arrays.asList(ids));
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
            List<XueshengzizhuEntity> xueshengzizhuList = new ArrayList<>();//上传的东西
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
                            XueshengzizhuEntity xueshengzizhuEntity = new XueshengzizhuEntity();
//                            xueshengzizhuEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            xueshengzizhuEntity.setLaoshiId(Integer.valueOf(data.get(0)));   //老师 要改的
//                            xueshengzizhuEntity.setXueshengzizhuUuidNumber(data.get(0));                    //资助编号 要改的
//                            xueshengzizhuEntity.setXueshengzizhuName(data.get(0));                    //学生资助名称 要改的
//                            xueshengzizhuEntity.setXueshengzizhuFile(data.get(0));                    //相关证明文件 要改的
//                            xueshengzizhuEntity.setXueshengzizhuTypes(Integer.valueOf(data.get(0)));   //学生资助类型 要改的
//                            xueshengzizhuEntity.setXueshengzizhuJine(data.get(0));                    //资助金额 要改的
//                            xueshengzizhuEntity.setXueshengzizhuContent("");//详情和图片
//                            xueshengzizhuEntity.setInsertTime(date);//时间
//                            xueshengzizhuEntity.setXueshengzizhuYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            xueshengzizhuEntity.setXueshengzizhuYesnoText(data.get(0));                    //审核意见 要改的
//                            xueshengzizhuEntity.setXueshengzizhuShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            xueshengzizhuEntity.setCreateTime(date);//时间
                            xueshengzizhuList.add(xueshengzizhuEntity);


                            //把要查询是否重复的字段放入map中
                                //资助编号
                                if(seachFields.containsKey("xueshengzizhuUuidNumber")){
                                    List<String> xueshengzizhuUuidNumber = seachFields.get("xueshengzizhuUuidNumber");
                                    xueshengzizhuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xueshengzizhuUuidNumber = new ArrayList<>();
                                    xueshengzizhuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xueshengzizhuUuidNumber",xueshengzizhuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //资助编号
                        List<XueshengzizhuEntity> xueshengzizhuEntities_xueshengzizhuUuidNumber = xueshengzizhuService.selectList(new EntityWrapper<XueshengzizhuEntity>().in("xueshengzizhu_uuid_number", seachFields.get("xueshengzizhuUuidNumber")));
                        if(xueshengzizhuEntities_xueshengzizhuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XueshengzizhuEntity s:xueshengzizhuEntities_xueshengzizhuUuidNumber){
                                repeatFields.add(s.getXueshengzizhuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [资助编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xueshengzizhuService.insertBatch(xueshengzizhuList);
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
