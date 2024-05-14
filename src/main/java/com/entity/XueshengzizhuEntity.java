package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 学生资助
 *
 * @author 
 * @email
 */
@TableName("xueshengzizhu")
public class XueshengzizhuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XueshengzizhuEntity() {

	}

	public XueshengzizhuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 学生
     */
    @TableField(value = "xuesheng_id")

    private Integer xueshengId;


    /**
     * 老师
     */
    @TableField(value = "laoshi_id")

    private Integer laoshiId;


    /**
     * 资助编号
     */
    @TableField(value = "xueshengzizhu_uuid_number")

    private String xueshengzizhuUuidNumber;


    /**
     * 学生资助名称
     */
    @TableField(value = "xueshengzizhu_name")

    private String xueshengzizhuName;


    /**
     * 相关证明文件
     */
    @TableField(value = "xueshengzizhu_file")

    private String xueshengzizhuFile;


    /**
     * 学生资助类型
     */
    @TableField(value = "xueshengzizhu_types")

    private Integer xueshengzizhuTypes;


    /**
     * 资助金额
     */
    @TableField(value = "xueshengzizhu_jine")

    private Double xueshengzizhuJine;


    /**
     * 学生资助详情
     */
    @TableField(value = "xueshengzizhu_content")

    private String xueshengzizhuContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 审核状态
     */
    @TableField(value = "xueshengzizhu_yesno_types")

    private Integer xueshengzizhuYesnoTypes;


    /**
     * 审核意见
     */
    @TableField(value = "xueshengzizhu_yesno_text")

    private String xueshengzizhuYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "xueshengzizhu_shenhe_time")

    private Date xueshengzizhuShenheTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }
    /**
	 * 获取：学生
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 设置：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }
    /**
	 * 获取：老师
	 */

    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 设置：资助编号
	 */
    public String getXueshengzizhuUuidNumber() {
        return xueshengzizhuUuidNumber;
    }
    /**
	 * 获取：资助编号
	 */

    public void setXueshengzizhuUuidNumber(String xueshengzizhuUuidNumber) {
        this.xueshengzizhuUuidNumber = xueshengzizhuUuidNumber;
    }
    /**
	 * 设置：学生资助名称
	 */
    public String getXueshengzizhuName() {
        return xueshengzizhuName;
    }
    /**
	 * 获取：学生资助名称
	 */

    public void setXueshengzizhuName(String xueshengzizhuName) {
        this.xueshengzizhuName = xueshengzizhuName;
    }
    /**
	 * 设置：相关证明文件
	 */
    public String getXueshengzizhuFile() {
        return xueshengzizhuFile;
    }
    /**
	 * 获取：相关证明文件
	 */

    public void setXueshengzizhuFile(String xueshengzizhuFile) {
        this.xueshengzizhuFile = xueshengzizhuFile;
    }
    /**
	 * 设置：学生资助类型
	 */
    public Integer getXueshengzizhuTypes() {
        return xueshengzizhuTypes;
    }
    /**
	 * 获取：学生资助类型
	 */

    public void setXueshengzizhuTypes(Integer xueshengzizhuTypes) {
        this.xueshengzizhuTypes = xueshengzizhuTypes;
    }
    /**
	 * 设置：资助金额
	 */
    public Double getXueshengzizhuJine() {
        return xueshengzizhuJine;
    }
    /**
	 * 获取：资助金额
	 */

    public void setXueshengzizhuJine(Double xueshengzizhuJine) {
        this.xueshengzizhuJine = xueshengzizhuJine;
    }
    /**
	 * 设置：学生资助详情
	 */
    public String getXueshengzizhuContent() {
        return xueshengzizhuContent;
    }
    /**
	 * 获取：学生资助详情
	 */

    public void setXueshengzizhuContent(String xueshengzizhuContent) {
        this.xueshengzizhuContent = xueshengzizhuContent;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getXueshengzizhuYesnoTypes() {
        return xueshengzizhuYesnoTypes;
    }
    /**
	 * 获取：审核状态
	 */

    public void setXueshengzizhuYesnoTypes(Integer xueshengzizhuYesnoTypes) {
        this.xueshengzizhuYesnoTypes = xueshengzizhuYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getXueshengzizhuYesnoText() {
        return xueshengzizhuYesnoText;
    }
    /**
	 * 获取：审核意见
	 */

    public void setXueshengzizhuYesnoText(String xueshengzizhuYesnoText) {
        this.xueshengzizhuYesnoText = xueshengzizhuYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getXueshengzizhuShenheTime() {
        return xueshengzizhuShenheTime;
    }
    /**
	 * 获取：审核时间
	 */

    public void setXueshengzizhuShenheTime(Date xueshengzizhuShenheTime) {
        this.xueshengzizhuShenheTime = xueshengzizhuShenheTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Xueshengzizhu{" +
            "id=" + id +
            ", xueshengId=" + xueshengId +
            ", laoshiId=" + laoshiId +
            ", xueshengzizhuUuidNumber=" + xueshengzizhuUuidNumber +
            ", xueshengzizhuName=" + xueshengzizhuName +
            ", xueshengzizhuFile=" + xueshengzizhuFile +
            ", xueshengzizhuTypes=" + xueshengzizhuTypes +
            ", xueshengzizhuJine=" + xueshengzizhuJine +
            ", xueshengzizhuContent=" + xueshengzizhuContent +
            ", insertTime=" + insertTime +
            ", xueshengzizhuYesnoTypes=" + xueshengzizhuYesnoTypes +
            ", xueshengzizhuYesnoText=" + xueshengzizhuYesnoText +
            ", xueshengzizhuShenheTime=" + xueshengzizhuShenheTime +
            ", createTime=" + createTime +
        "}";
    }
}
