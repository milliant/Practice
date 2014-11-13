package com.milliant.basic.java.enum_knowledge;

public enum IOEnum {
	FILENOTFINDERROR("1101","找不到对应的文件"),
	FILEREADERROR("1102","文件读取错误");
	
	private final String code;
	private final String msg;
	private IOEnum(String code ,String msg){
		this.code = code;
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
}
