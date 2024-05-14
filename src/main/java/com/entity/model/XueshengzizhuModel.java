package com.entity.model;

import com.entity.XueshengzizhuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 学生资助
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XueshengzizhuModel implements Serializable {
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
     * 资助编号
     */
    private String xueshengzizhuUuidNumber;


    /**
     * 学生资助名称
     */
    private String xueshengzizhuName;


    /**
     * 相关证明文件
     */
    private String xueshengzizhuFile;


    /**
     * 学生资助类型
     */
    private Integer xueshengzizhuTypes;


    /**
     * 资助金额
     */
    private Double xueshengzizhuJine;


    /**
     * 学生资助详情
     */
    private String xueshengzizhuContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 审核状态
     */
    private Integer xueshengzizhuYesnoTypes;


    /**
     * 审核意见
     */
    private String xueshengzizhuYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date xueshengzizhuShenheTime;


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
	 * 获取：资助编号
	 */
    public String getXueshengzizhuUuidNumber() {
        return xueshengzizhuUuidNumber;
    }


    /**
	 * 设置：资助编号
	 */
    public void setXueshengzizhuUuidNumber(String xueshengzizhuUuidNumber) {
        this.xueshengzizhuUuidNumber = xueshengzizhuUuidNumber;
    }
    /**
	 * 获取：学生资助名称
	 */
    public String getXueshengzizhuName() {
        return xueshengzizhuName;
    }


    /**
	 * 设置：学生资助名称
	 */
    public void setXueshengzizhuName(String xueshengzizhuName) {
        this.xueshengzizhuName = xueshengzizhuName;
    }
    /**
	 * 获取：相关证明文件
	 */
    public String getXueshengzizhuFile() {
        return xueshengzizhuFile;
    }


    /**
	 * 设置：相关证明文件
	 */
    public void setXueshengzizhuFile(String xueshengzizhuFile) {
        this.xueshengzizhuFile = xueshengzizhuFile;
    }
    /**
	 * 获取：学生资助类型
	 */
    public Integer getXueshengzizhuTypes() {
        return xueshengzizhuTypes;
    }


    /**
	 * 设置：学生资助类型
	 */
    public void setXueshengzizhuTypes(Integer xueshengzizhuTypes) {
        this.xueshengzizhuTypes = xueshengzizhuTypes;
    }
    /**
	 * 获取：资助金额
	 */
    public Double getXueshengzizhuJine() {
        return xueshengzizhuJine;
    }


    /**
	 * 设置：资助金额
	 */
    public void setXueshengzizhuJine(Double xueshengzizhuJine) {
        this.xueshengzizhuJine = xueshengzizhuJine;
    }
    /**
	 * 获取：学生资助详情
	 */
    public String getXueshengzizhuContent() {
        return xueshengzizhuContent;
    }


    /**
	 * 设置：学生资助详情
	 */
    public void setXueshengzizhuContent(String xueshengzizhuContent) {
        this.xueshengzizhuContent = xueshengzizhuContent;
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
    public Integer getXueshengzizhuYesnoTypes() {
        return xueshengzizhuYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setXueshengzizhuYesnoTypes(Integer xueshengzizhuYesnoTypes) {
        this.xueshengzizhuYesnoTypes = xueshengzizhuYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getXueshengzizhuYesnoText() {
        return xueshengzizhuYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setXueshengzizhuYesnoText(String xueshengzizhuYesnoText) {
        this.xueshengzizhuYesnoText = xueshengzizhuYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getXueshengzizhuShenheTime() {
        return xueshengzizhuShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setXueshengzizhuShenheTime(Date xueshengzizhuShenheTime) {
        this.xueshengzizhuShenheTime = xueshengzizhuShenheTime;
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
