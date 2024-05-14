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
 * 违纪处分
 *
 * @author 
 * @email
 */
@TableName("weijichufen")
public class WeijichufenEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WeijichufenEntity() {

	}

	public WeijichufenEntity(T t) {
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
     * 违纪处分编号
     */
    @TableField(value = "weijichufen_uuid_number")

    private String weijichufenUuidNumber;


    /**
     * 违纪处分名称
     */
    @TableField(value = "weijichufen_name")

    private String weijichufenName;


    /**
     * 相关文件
     */
    @TableField(value = "weijichufen_file")

    private String weijichufenFile;


    /**
     * 违纪处分类型
     */
    @TableField(value = "weijichufen_types")

    private Integer weijichufenTypes;


    /**
     * 违纪详情
     */
    @TableField(value = "weijichufen_content")

    private String weijichufenContent;


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
    @TableField(value = "weijichufen_yesno_types")

    private Integer weijichufenYesnoTypes;


    /**
     * 审核意见
     */
    @TableField(value = "weijichufen_yesno_text")

    private String weijichufenYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "weijichufen_shenhe_time")

    private Date weijichufenShenheTime;


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
	 * 设置：违纪处分编号
	 */
    public String getWeijichufenUuidNumber() {
        return weijichufenUuidNumber;
    }
    /**
	 * 获取：违纪处分编号
	 */

    public void setWeijichufenUuidNumber(String weijichufenUuidNumber) {
        this.weijichufenUuidNumber = weijichufenUuidNumber;
    }
    /**
	 * 设置：违纪处分名称
	 */
    public String getWeijichufenName() {
        return weijichufenName;
    }
    /**
	 * 获取：违纪处分名称
	 */

    public void setWeijichufenName(String weijichufenName) {
        this.weijichufenName = weijichufenName;
    }
    /**
	 * 设置：相关文件
	 */
    public String getWeijichufenFile() {
        return weijichufenFile;
    }
    /**
	 * 获取：相关文件
	 */

    public void setWeijichufenFile(String weijichufenFile) {
        this.weijichufenFile = weijichufenFile;
    }
    /**
	 * 设置：违纪处分类型
	 */
    public Integer getWeijichufenTypes() {
        return weijichufenTypes;
    }
    /**
	 * 获取：违纪处分类型
	 */

    public void setWeijichufenTypes(Integer weijichufenTypes) {
        this.weijichufenTypes = weijichufenTypes;
    }
    /**
	 * 设置：违纪详情
	 */
    public String getWeijichufenContent() {
        return weijichufenContent;
    }
    /**
	 * 获取：违纪详情
	 */

    public void setWeijichufenContent(String weijichufenContent) {
        this.weijichufenContent = weijichufenContent;
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
    public Integer getWeijichufenYesnoTypes() {
        return weijichufenYesnoTypes;
    }
    /**
	 * 获取：审核状态
	 */

    public void setWeijichufenYesnoTypes(Integer weijichufenYesnoTypes) {
        this.weijichufenYesnoTypes = weijichufenYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getWeijichufenYesnoText() {
        return weijichufenYesnoText;
    }
    /**
	 * 获取：审核意见
	 */

    public void setWeijichufenYesnoText(String weijichufenYesnoText) {
        this.weijichufenYesnoText = weijichufenYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getWeijichufenShenheTime() {
        return weijichufenShenheTime;
    }
    /**
	 * 获取：审核时间
	 */

    public void setWeijichufenShenheTime(Date weijichufenShenheTime) {
        this.weijichufenShenheTime = weijichufenShenheTime;
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
        return "Weijichufen{" +
            "id=" + id +
            ", xueshengId=" + xueshengId +
            ", laoshiId=" + laoshiId +
            ", weijichufenUuidNumber=" + weijichufenUuidNumber +
            ", weijichufenName=" + weijichufenName +
            ", weijichufenFile=" + weijichufenFile +
            ", weijichufenTypes=" + weijichufenTypes +
            ", weijichufenContent=" + weijichufenContent +
            ", insertTime=" + insertTime +
            ", weijichufenYesnoTypes=" + weijichufenYesnoTypes +
            ", weijichufenYesnoText=" + weijichufenYesnoText +
            ", weijichufenShenheTime=" + weijichufenShenheTime +
            ", createTime=" + createTime +
        "}";
    }
}
