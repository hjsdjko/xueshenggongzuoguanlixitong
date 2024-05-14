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
 * 学生
 *
 * @author 
 * @email
 */
@TableName("xuesheng")
public class XueshengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XueshengEntity() {

	}

	public XueshengEntity(T t) {
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
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 学号
     */
    @TableField(value = "xuesheng_uuid_number")

    private String xueshengUuidNumber;


    /**
     * 学生姓名
     */
    @TableField(value = "xuesheng_name")

    private String xueshengName;


    /**
     * 学生手机号
     */
    @TableField(value = "xuesheng_phone")

    private String xueshengPhone;


    /**
     * 学生身份证号
     */
    @TableField(value = "xuesheng_id_number")

    private String xueshengIdNumber;


    /**
     * 电子邮箱
     */
    @TableField(value = "xuesheng_email")

    private String xueshengEmail;


    /**
     * 学生头像
     */
    @TableField(value = "xuesheng_photo")

    private String xueshengPhoto;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 学院
     */
    @TableField(value = "xueyuan_types")

    private Integer xueyuanTypes;


    /**
     * 专业
     */
    @TableField(value = "zhuanye_types")

    private Integer zhuanyeTypes;


    /**
     * 班级
     */
    @TableField(value = "banji_types")

    private Integer banjiTypes;


    /**
     * 生源地
     */
    @TableField(value = "xuesheng_shengyuandi")

    private String xueshengShengyuandi;


    /**
     * 家长信息
     */
    @TableField(value = "xuesheng_jiazhang_text")

    private String xueshengJiazhangText;


    /**
     * 家庭情况
     */
    @TableField(value = "xuesheng_jiating_content")

    private String xueshengJiatingContent;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：学号
	 */
    public String getXueshengUuidNumber() {
        return xueshengUuidNumber;
    }
    /**
	 * 获取：学号
	 */

    public void setXueshengUuidNumber(String xueshengUuidNumber) {
        this.xueshengUuidNumber = xueshengUuidNumber;
    }
    /**
	 * 设置：学生姓名
	 */
    public String getXueshengName() {
        return xueshengName;
    }
    /**
	 * 获取：学生姓名
	 */

    public void setXueshengName(String xueshengName) {
        this.xueshengName = xueshengName;
    }
    /**
	 * 设置：学生手机号
	 */
    public String getXueshengPhone() {
        return xueshengPhone;
    }
    /**
	 * 获取：学生手机号
	 */

    public void setXueshengPhone(String xueshengPhone) {
        this.xueshengPhone = xueshengPhone;
    }
    /**
	 * 设置：学生身份证号
	 */
    public String getXueshengIdNumber() {
        return xueshengIdNumber;
    }
    /**
	 * 获取：学生身份证号
	 */

    public void setXueshengIdNumber(String xueshengIdNumber) {
        this.xueshengIdNumber = xueshengIdNumber;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getXueshengEmail() {
        return xueshengEmail;
    }
    /**
	 * 获取：电子邮箱
	 */

    public void setXueshengEmail(String xueshengEmail) {
        this.xueshengEmail = xueshengEmail;
    }
    /**
	 * 设置：学生头像
	 */
    public String getXueshengPhoto() {
        return xueshengPhoto;
    }
    /**
	 * 获取：学生头像
	 */

    public void setXueshengPhoto(String xueshengPhoto) {
        this.xueshengPhoto = xueshengPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：学院
	 */
    public Integer getXueyuanTypes() {
        return xueyuanTypes;
    }
    /**
	 * 获取：学院
	 */

    public void setXueyuanTypes(Integer xueyuanTypes) {
        this.xueyuanTypes = xueyuanTypes;
    }
    /**
	 * 设置：专业
	 */
    public Integer getZhuanyeTypes() {
        return zhuanyeTypes;
    }
    /**
	 * 获取：专业
	 */

    public void setZhuanyeTypes(Integer zhuanyeTypes) {
        this.zhuanyeTypes = zhuanyeTypes;
    }
    /**
	 * 设置：班级
	 */
    public Integer getBanjiTypes() {
        return banjiTypes;
    }
    /**
	 * 获取：班级
	 */

    public void setBanjiTypes(Integer banjiTypes) {
        this.banjiTypes = banjiTypes;
    }
    /**
	 * 设置：生源地
	 */
    public String getXueshengShengyuandi() {
        return xueshengShengyuandi;
    }
    /**
	 * 获取：生源地
	 */

    public void setXueshengShengyuandi(String xueshengShengyuandi) {
        this.xueshengShengyuandi = xueshengShengyuandi;
    }
    /**
	 * 设置：家长信息
	 */
    public String getXueshengJiazhangText() {
        return xueshengJiazhangText;
    }
    /**
	 * 获取：家长信息
	 */

    public void setXueshengJiazhangText(String xueshengJiazhangText) {
        this.xueshengJiazhangText = xueshengJiazhangText;
    }
    /**
	 * 设置：家庭情况
	 */
    public String getXueshengJiatingContent() {
        return xueshengJiatingContent;
    }
    /**
	 * 获取：家庭情况
	 */

    public void setXueshengJiatingContent(String xueshengJiatingContent) {
        this.xueshengJiatingContent = xueshengJiatingContent;
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
        return "Xuesheng{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", xueshengUuidNumber=" + xueshengUuidNumber +
            ", xueshengName=" + xueshengName +
            ", xueshengPhone=" + xueshengPhone +
            ", xueshengIdNumber=" + xueshengIdNumber +
            ", xueshengEmail=" + xueshengEmail +
            ", xueshengPhoto=" + xueshengPhoto +
            ", sexTypes=" + sexTypes +
            ", xueyuanTypes=" + xueyuanTypes +
            ", zhuanyeTypes=" + zhuanyeTypes +
            ", banjiTypes=" + banjiTypes +
            ", xueshengShengyuandi=" + xueshengShengyuandi +
            ", xueshengJiazhangText=" + xueshengJiazhangText +
            ", xueshengJiatingContent=" + xueshengJiatingContent +
            ", createTime=" + createTime +
        "}";
    }
}