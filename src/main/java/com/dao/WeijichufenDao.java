package com.dao;

import com.entity.WeijichufenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WeijichufenView;

/**
 * 违纪处分 Dao 接口
 *
 * @author 
 */
public interface WeijichufenDao extends BaseMapper<WeijichufenEntity> {

   List<WeijichufenView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
