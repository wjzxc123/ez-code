package com.licon.admin.core.mybatis.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/27 14:03
 */
@Getter
public enum EnableEnum {
	/**
	 * 激活
	 */
	ON(1,"激活"),
	/**
	 * 失效
	 */
	OFF(0,"失效");

	/**
	 * 编码
	 */
	@EnumValue
	@JsonValue
	private final int code;

	/**
	 * 描述
	 */
	private final String msg;

	EnableEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
