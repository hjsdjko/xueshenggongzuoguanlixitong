package com.entity.view;

import com.entity.XueshengzizhuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 学生资助
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xueshengzizhu")
public class XueshengzizhuView extends XueshengzizhuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 学生资助类型的值
		*/
		private String xueshengzizhuValue;
		/**
		* 审核状态的值
		*/
		private String xueshengzizhuYesnoValue;



		//级联表 laoshi
			/**
			* 工号
			*/
			private String laoshiUuidNumber;
			/**
			* 老师姓名
			*/
			private String laoshiName;
			/**
			* 老师手机号
			*/
			private String laoshiPhone;
			/**
			* 老师身份证号
			*/
			private String laoshiIdNumber;
			/**
			* 电子邮箱
			*/
			private String laoshiEmail;
			/**
			* 老师头像
			*/
			private String laoshiPhoto;

		//级联表 xuesheng
			/**
			* 学号
			*/
			private String xueshengUuidNumber;
			/**
			* 学生姓名
			*/
			private String xueshengName;
			/**
			* 学生手机号
			*/
			private String xueshengPhone;
			/**
			* 学生身份证号
			*/
			private String xueshengIdNumber;
			/**
			* 电子邮箱
			*/
			private String xueshengEmail;
			/**
			* 学生头像
			*/
			private String xueshengPhoto;
			/**
			* 学院
			*/
			private Integer xueyuanTypes;
				/**
				* 学院的值
				*/
				private String xueyuanValue;
			/**
			* 专业
			*/
			private Integer zhuanyeTypes;
				/**
				* 专业的值
				*/
				private String zhuanyeValue;
			/**
			* 班级
			*/
			private Integer banjiTypes;
				/**
				* 班级的值
				*/
				private String banjiValue;
			/**
			* 生源地
			*/
			private String xueshengShengyuandi;
			/**
			* 家长信息
			*/
			private String xueshengJiazhangText;
			/**
			* 家庭情况
			*/
			private String xueshengJiatingContent;

	public XueshengzizhuView() {

	}

	public XueshengzizhuView(XueshengzizhuEntity xueshengzizhuEntity) {
		try {
			BeanUtils.copyProperties(this, xueshengzizhuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 学生资助类型的值
			*/
			public String getXueshengzizhuValue() {
				return xueshengzizhuValue;
			}
			/**
			* 设置： 学生资助类型的值
			*/
			public void setXueshengzizhuValue(String xueshengzizhuValue) {
				this.xueshengzizhuValue = xueshengzizhuValue;
			}
			/**
			* 获取： 审核状态的值
			*/
			public String getXueshengzizhuYesnoValue() {
				return xueshengzizhuYesnoValue;
			}
			/**
			* 设置： 审核状态的值
			*/
			public void setXueshengzizhuYesnoValue(String xueshengzizhuYesnoValue) {
				this.xueshengzizhuYesnoValue = xueshengzizhuYesnoValue;
			}











				//级联表的get和set laoshi

					/**
					* 获取： 工号
					*/
					public String getLaoshiUuidNumber() {
						return laoshiUuidNumber;
					}
					/**
					* 设置： 工号
					*/
					public void setLaoshiUuidNumber(String laoshiUuidNumber) {
						this.laoshiUuidNumber = laoshiUuidNumber;
					}

					/**
					* 获取： 老师姓名
					*/
					public String getLaoshiName() {
						return laoshiName;
					}
					/**
					* 设置： 老师姓名
					*/
					public void setLaoshiName(String laoshiName) {
						this.laoshiName = laoshiName;
					}

					/**
					* 获取： 老师手机号
					*/
					public String getLaoshiPhone() {
						return laoshiPhone;
					}
					/**
					* 设置： 老师手机号
					*/
					public void setLaoshiPhone(String laoshiPhone) {
						this.laoshiPhone = laoshiPhone;
					}

					/**
					* 获取： 老师身份证号
					*/
					public String getLaoshiIdNumber() {
						return laoshiIdNumber;
					}
					/**
					* 设置： 老师身份证号
					*/
					public void setLaoshiIdNumber(String laoshiIdNumber) {
						this.laoshiIdNumber = laoshiIdNumber;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getLaoshiEmail() {
						return laoshiEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setLaoshiEmail(String laoshiEmail) {
						this.laoshiEmail = laoshiEmail;
					}

					/**
					* 获取： 老师头像
					*/
					public String getLaoshiPhoto() {
						return laoshiPhoto;
					}
					/**
					* 设置： 老师头像
					*/
					public void setLaoshiPhoto(String laoshiPhoto) {
						this.laoshiPhoto = laoshiPhoto;
					}








				//级联表的get和set xuesheng

					/**
					* 获取： 学号
					*/
					public String getXueshengUuidNumber() {
						return xueshengUuidNumber;
					}
					/**
					* 设置： 学号
					*/
					public void setXueshengUuidNumber(String xueshengUuidNumber) {
						this.xueshengUuidNumber = xueshengUuidNumber;
					}

					/**
					* 获取： 学生姓名
					*/
					public String getXueshengName() {
						return xueshengName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setXueshengName(String xueshengName) {
						this.xueshengName = xueshengName;
					}

					/**
					* 获取： 学生手机号
					*/
					public String getXueshengPhone() {
						return xueshengPhone;
					}
					/**
					* 设置： 学生手机号
					*/
					public void setXueshengPhone(String xueshengPhone) {
						this.xueshengPhone = xueshengPhone;
					}

					/**
					* 获取： 学生身份证号
					*/
					public String getXueshengIdNumber() {
						return xueshengIdNumber;
					}
					/**
					* 设置： 学生身份证号
					*/
					public void setXueshengIdNumber(String xueshengIdNumber) {
						this.xueshengIdNumber = xueshengIdNumber;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getXueshengEmail() {
						return xueshengEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setXueshengEmail(String xueshengEmail) {
						this.xueshengEmail = xueshengEmail;
					}

					/**
					* 获取： 学生头像
					*/
					public String getXueshengPhoto() {
						return xueshengPhoto;
					}
					/**
					* 设置： 学生头像
					*/
					public void setXueshengPhoto(String xueshengPhoto) {
						this.xueshengPhoto = xueshengPhoto;
					}

					/**
					* 获取： 学院
					*/
					public Integer getXueyuanTypes() {
						return xueyuanTypes;
					}
					/**
					* 设置： 学院
					*/
					public void setXueyuanTypes(Integer xueyuanTypes) {
						this.xueyuanTypes = xueyuanTypes;
					}


						/**
						* 获取： 学院的值
						*/
						public String getXueyuanValue() {
							return xueyuanValue;
						}
						/**
						* 设置： 学院的值
						*/
						public void setXueyuanValue(String xueyuanValue) {
							this.xueyuanValue = xueyuanValue;
						}

					/**
					* 获取： 专业
					*/
					public Integer getZhuanyeTypes() {
						return zhuanyeTypes;
					}
					/**
					* 设置： 专业
					*/
					public void setZhuanyeTypes(Integer zhuanyeTypes) {
						this.zhuanyeTypes = zhuanyeTypes;
					}


						/**
						* 获取： 专业的值
						*/
						public String getZhuanyeValue() {
							return zhuanyeValue;
						}
						/**
						* 设置： 专业的值
						*/
						public void setZhuanyeValue(String zhuanyeValue) {
							this.zhuanyeValue = zhuanyeValue;
						}

					/**
					* 获取： 班级
					*/
					public Integer getBanjiTypes() {
						return banjiTypes;
					}
					/**
					* 设置： 班级
					*/
					public void setBanjiTypes(Integer banjiTypes) {
						this.banjiTypes = banjiTypes;
					}


						/**
						* 获取： 班级的值
						*/
						public String getBanjiValue() {
							return banjiValue;
						}
						/**
						* 设置： 班级的值
						*/
						public void setBanjiValue(String banjiValue) {
							this.banjiValue = banjiValue;
						}

					/**
					* 获取： 生源地
					*/
					public String getXueshengShengyuandi() {
						return xueshengShengyuandi;
					}
					/**
					* 设置： 生源地
					*/
					public void setXueshengShengyuandi(String xueshengShengyuandi) {
						this.xueshengShengyuandi = xueshengShengyuandi;
					}

					/**
					* 获取： 家长信息
					*/
					public String getXueshengJiazhangText() {
						return xueshengJiazhangText;
					}
					/**
					* 设置： 家长信息
					*/
					public void setXueshengJiazhangText(String xueshengJiazhangText) {
						this.xueshengJiazhangText = xueshengJiazhangText;
					}

					/**
					* 获取： 家庭情况
					*/
					public String getXueshengJiatingContent() {
						return xueshengJiatingContent;
					}
					/**
					* 设置： 家庭情况
					*/
					public void setXueshengJiatingContent(String xueshengJiatingContent) {
						this.xueshengJiatingContent = xueshengJiatingContent;
					}







}
