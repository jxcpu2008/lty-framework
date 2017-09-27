package com.lty.app.facade.auth.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.lty.framework.common.model.Model;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月8日
 * @版本: 1.0
 */
@XStreamAlias("User")
// @ApiModel注解一般搭配@ApiModelProperty注解使用，在springmvc的controller方法中，相应的模型参数需要使用@RequstBody注解，前端传递的参数才能被转换为model对象
@ApiModel(value = "用户实体类")
public class User extends Model {
	private static final long serialVersionUID = 1L;

	private List<Role> roles;

	private String roleIds;

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	@XStreamAsAttribute
	@ApiModelProperty(value = "用户id")
	private String id;

	@XStreamAsAttribute
	@ApiModelProperty(value = "用户登陆名称", required=true)
	private String loginName;

	@ApiModelProperty(value = "用户登陆密码")
	private String password;

//	@XStreamAsAttribute
//	private String status;
//
//	@XStreamAsAttribute
//	private String type;
	
	@XStreamAsAttribute
	@ApiModelProperty(value = "用户状态")
	private int status;

	@XStreamAsAttribute
	@ApiModelProperty(value = "用户类型")
	private int type;

	@XStreamAsAttribute
	@ApiModelProperty(value = "支付方式")
	private String paymentCode;

	@XStreamAsAttribute
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@ApiModelProperty(value = "用户创建时间")
	private Date createTime;

	@XStreamAsAttribute
	@ApiModelProperty(value = "用户序号")
	private int userNo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName == null ? null : loginName.trim();
	}

	public String getPassword() {
		return password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode == null ? null : paymentCode.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
}