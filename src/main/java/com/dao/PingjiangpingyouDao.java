package com.dao;

import com.entity.PingjiangpingyouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.PingjiangpingyouView;

/**
 * 评奖评优 Dao 接口
 *
 * @author 
 */
public interface PingjiangpingyouDao extends BaseMapper<PingjiangpingyouEntity> {

   List<PingjiangpingyouView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
