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
 * 评奖评优
 *
 * @author 
 * @email
 */
@TableName("pingjiangpingyou")
public class PingjiangpingyouEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public PingjiangpingyouEntity() {

	}

	public PingjiangpingyouEntity(T t) {
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
     * 评奖评优编号
     */
    @TableField(value = "pingjiangpingyou_uuid_number")

    private String pingjiangpingyouUuidNumber;


    /**
     * 评奖评优名称
     */
    @TableField(value = "pingjiangpingyou_name")

    private String pingjiangpingyouName;


    /**
     * 相关证明文件
     */
    @TableField(value = "pingjiangpingyou_file")

    private String pingjiangpingyouFile;


    /**
     * 评奖评优类型
     */
    @TableField(value = "pingjiangpingyou_types")

    private Integer pingjiangpingyouTypes;


    /**
     * 优秀事迹
     */
    @TableField(value = "pingjiangpingyou_content")

    private String pingjiangpingyouContent;


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
    @TableField(value = "pingjiangpingyou_yesno_types")

    private Integer pingjiangpingyouYesnoTypes;


    /**
     * 审核意见
     */
    @TableField(value = "pingjiangpingyou_yesno_text")

    private String pingjiangpingyouYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "pingjiangpingyou_shenhe_time")

    private Date pingjiangpingyouShenheTime;


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
	 * 设置：评奖评优编号
	 */
    public String getPingjiangpingyouUuidNumber() {
        return pingjiangpingyouUuidNumber;
    }
    /**
	 * 获取：评奖评优编号
	 */

    public void setPingjiangpingyouUuidNumber(String pingjiangpingyouUuidNumber) {
        this.pingjiangpingyouUuidNumber = pingjiangpingyouUuidNumber;
    }
    /**
	 * 设置：评奖评优名称
	 */
    public String getPingjiangpingyouName() {
        return pingjiangpingyouName;
    }
    /**
	 * 获取：评奖评优名称
	 */

    public void setPingjiangpingyouName(String pingjiangpingyouName) {
        this.pingjiangpingyouName = pingjiangpingyouName;
    }
    /**
	 * 设置：相关证明文件
	 */
    public String getPingjiangpingyouFile() {
        return pingjiangpingyouFile;
    }
    /**
	 * 获取：相关证明文件
	 */

    public void setPingjiangpingyouFile(String pingjiangpingyouFile) {
        this.pingjiangpingyouFile = pingjiangpingyouFile;
    }
    /**
	 * 设置：评奖评优类型
	 */
    public Integer getPingjiangpingyouTypes() {
        return pingjiangpingyouTypes;
    }
    /**
	 * 获取：评奖评优类型
	 */

    public void setPingjiangpingyouTypes(Integer pingjiangpingyouTypes) {
        this.pingjiangpingyouTypes = pingjiangpingyouTypes;
    }
    /**
	 * 设置：优秀事迹
	 */
    public String getPingjiangpingyouContent() {
        return pingjiangpingyouContent;
    }
    /**
	 * 获取：优秀事迹
	 */

    public void setPingjiangpingyouContent(String pingjiangpingyouContent) {
        this.pingjiangpingyouContent = pingjiangpingyouContent;
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
    public Integer getPingjiangpingyouYesnoTypes() {
        return pingjiangpingyouYesnoTypes;
    }
    /**
	 * 获取：审核状态
	 */

    public void setPingjiangpingyouYesnoTypes(Integer pingjiangpingyouYesnoTypes) {
        this.pingjiangpingyouYesnoTypes = pingjiangpingyouYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getPingjiangpingyouYesnoText() {
        return pingjiangpingyouYesnoText;
    }
    /**
	 * 获取：审核意见
	 */

    public void setPingjiangpingyouYesnoText(String pingjiangpingyouYesnoText) {
        this.pingjiangpingyouYesnoText = pingjiangpingyouYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getPingjiangpingyouShenheTime() {
        return pingjiangpingyouShenheTime;
    }
    /**
	 * 获取：审核时间
	 */

    public void setPingjiangpingyouShenheTime(Date pingjiangpingyouShenheTime) {
        this.pingjiangpingyouShenheTime = pingjiangpingyouShenheTime;
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
        return "Pingjiangpingyou{" +
            "id=" + id +
            ", xueshengId=" + xueshengId +
            ", laoshiId=" + laoshiId +
            ", pingjiangpingyouUuidNumber=" + pingjiangpingyouUuidNumber +
            ", pingjiangpingyouName=" + pingjiangpingyouName +
            ", pingjiangpingyouFile=" + pingjiangpingyouFile +
            ", pingjiangpingyouTypes=" + pingjiangpingyouTypes +
            ", pingjiangpingyouContent=" + pingjiangpingyouContent +
            ", insertTime=" + insertTime +
            ", pingjiangpingyouYesnoTypes=" + pingjiangpingyouYesnoTypes +
            ", pingjiangpingyouYesnoText=" + pingjiangpingyouYesnoText +
            ", pingjiangpingyouShenheTime=" + pingjiangpingyouShenheTime +
            ", createTime=" + createTime +
        "}";
    }
}
