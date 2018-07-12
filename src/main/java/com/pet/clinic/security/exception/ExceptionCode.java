package com.pet.clinic.security.exception;

public enum ExceptionCode {
	
	ADMIN_SECURITY_PLAIN_PASSWORD("密码为空","1000001"),
	ADMIN_SECURITY_PASSWORD_ERROR("修改之前原密码不正确","1000002"),
	ADMIN_SECURITY_NOT_EXISTS("用户不存在","1000003"),
	ADMIN_SECURITY_DELETED("用户已经被删除","1000004"),
	ADMIN_SECURITY_NOT_NEED_LOGIN(" 用户已经登录，不需要再登录","1000005"),
	ADMIN_SECURITY_VERIFYCODE_INVALID("验证码错误","1000006"),
	ADMIN_SECURITY_PASSWORD_WRONG("用户错误密码","1000007");
	
	private String name;
	private String code;
	
	 public static String getName(String code) {  
		 for (ExceptionCode exCode : ExceptionCode.values()) {
			if(exCode.getCode() == code){
				return exCode.name;
			}
		}
		 return null;
	 }
	
	private ExceptionCode(String name,String code){
		this.name = name;
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
