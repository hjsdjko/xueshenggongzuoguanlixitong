package com.entity.model;

import com.entity.PingjiangpingyouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 评奖评优
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class PingjiangpingyouModel implements Serializable {
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
     * 评奖评优编号
     */
    private String pingjiangpingyouUuidNumber;


    /**
     * 评奖评优名称
     */
    private String pingjiangpingyouName;


    /**
     * 相关证明文件
     */
    private String pingjiangpingyouFile;


    /**
     * 评奖评优类型
     */
    private Integer pingjiangpingyouTypes;


    /**
     * 优秀事迹
     */
    private String pingjiangpingyouContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 审核状态
     */
    private Integer pingjiangpingyouYesnoTypes;


    /**
     * 审核意见
     */
    private String pingjiangpingyouYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date pingjiangpingyouShenheTime;


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
	 * 获取：评奖评优编号
	 */
    public String getPingjiangpingyouUuidNumber() {
        return pingjiangpingyouUuidNumber;
    }


    /**
	 * 设置：评奖评优编号
	 */
    public void setPingjiangpingyouUuidNumber(String pingjiangpingyouUuidNumber) {
        this.pingjiangpingyouUuidNumber = pingjiangpingyouUuidNumber;
    }
    /**
	 * 获取：评奖评优名称
	 */
    public String getPingjiangpingyouName() {
        return pingjiangpingyouName;
    }


    /**
	 * 设置：评奖评优名称
	 */
    public void setPingjiangpingyouName(String pingjiangpingyouName) {
        this.pingjiangpingyouName = pingjiangpingyouName;
    }
    /**
	 * 获取：相关证明文件
	 */
    public String getPingjiangpingyouFile() {
        return pingjiangpingyouFile;
    }


    /**
	 * 设置：相关证明文件
	 */
    public void setPingjiangpingyouFile(String pingjiangpingyouFile) {
        this.pingjiangpingyouFile = pingjiangpingyouFile;
    }
    /**
	 * 获取：评奖评优类型
	 */
    public Integer getPingjiangpingyouTypes() {
        return pingjiangpingyouTypes;
    }


    /**
	 * 设置：评奖评优类型
	 */
    public void setPingjiangpingyouTypes(Integer pingjiangpingyouTypes) {
        this.pingjiangpingyouTypes = pingjiangpingyouTypes;
    }
    /**
	 * 获取：优秀事迹
	 */
    public String getPingjiangpingyouContent() {
        return pingjiangpingyouContent;
    }


    /**
	 * 设置：优秀事迹
	 */
    public void setPingjiangpingyouContent(String pingjiangpingyouContent) {
        this.pingjiangpingyouContent = pingjiangpingyouContent;
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
    public Integer getPingjiangpingyouYesnoTypes() {
        return pingjiangpingyouYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setPingjiangpingyouYesnoTypes(Integer pingjiangpingyouYesnoTypes) {
        this.pingjiangpingyouYesnoTypes = pingjiangpingyouYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getPingjiangpingyouYesnoText() {
        return pingjiangpingyouYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setPingjiangpingyouYesnoText(String pingjiangpingyouYesnoText) {
        this.pingjiangpingyouYesnoText = pingjiangpingyouYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getPingjiangpingyouShenheTime() {
        return pingjiangpingyouShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setPingjiangpingyouShenheTime(Date pingjiangpingyouShenheTime) {
        this.pingjiangpingyouShenheTime = pingjiangpingyouShenheTime;
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
