package com.entity.model;

import com.entity.WeijichufenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 违纪处分
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WeijichufenModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 学生
     */
    private Integer xueshengId;


    /**
     * 老师
     */
    private Integer laoshiId;


    /**
     * 违纪处分编号
     */
    private String weijichufenUuidNumber;


    /**
     * 违纪处分名称
     */
    private String weijichufenName;


    /**
     * 相关文件
     */
    private String weijichufenFile;


    /**
     * 违纪处分类型
     */
    private Integer weijichufenTypes;


    /**
     * 违纪详情
     */
    private String weijichufenContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 审核状态
     */
    private Integer weijichufenYesnoTypes;


    /**
     * 审核意见
     */
    private String weijichufenYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date weijichufenShenheTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 设置：学生
	 */
    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 获取：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 设置：老师
	 */
    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 获取：违纪处分编号
	 */
    public String getWeijichufenUuidNumber() {
        return weijichufenUuidNumber;
    }


    /**
	 * 设置：违纪处分编号
	 */
    public void setWeijichufenUuidNumber(String weijichufenUuidNumber) {
        this.weijichufenUuidNumber = weijichufenUuidNumber;
    }
    /**
	 * 获取：违纪处分名称
	 */
    public String getWeijichufenName() {
        return weijichufenName;
    }


    /**
	 * 设置：违纪处分名称
	 */
    public void setWeijichufenName(String weijichufenName) {
        this.weijichufenName = weijichufenName;
    }
    /**
	 * 获取：相关文件
	 */
    public String getWeijichufenFile() {
        return weijichufenFile;
    }


    /**
	 * 设置：相关文件
	 */
    public void setWeijichufenFile(String weijichufenFile) {
        this.weijichufenFile = weijichufenFile;
    }
    /**
	 * 获取：违纪处分类型
	 */
    public Integer getWeijichufenTypes() {
        return weijichufenTypes;
    }


    /**
	 * 设置：违纪处分类型
	 */
    public void setWeijichufenTypes(Integer weijichufenTypes) {
        this.weijichufenTypes = weijichufenTypes;
    }
    /**
	 * 获取：违纪详情
	 */
    public String getWeijichufenContent() {
        return weijichufenContent;
    }


    /**
	 * 设置：违纪详情
	 */
    public void setWeijichufenContent(String weijichufenContent) {
        this.weijichufenContent = weijichufenContent;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getWeijichufenYesnoTypes() {
        return weijichufenYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setWeijichufenYesnoTypes(Integer weijichufenYesnoTypes) {
        this.weijichufenYesnoTypes = weijichufenYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getWeijichufenYesnoText() {
        return weijichufenYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setWeijichufenYesnoText(String weijichufenYesnoText) {
        this.weijichufenYesnoText = weijichufenYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getWeijichufenShenheTime() {
        return weijichufenShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setWeijichufenShenheTime(Date weijichufenShenheTime) {
        this.weijichufenShenheTime = weijichufenShenheTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
