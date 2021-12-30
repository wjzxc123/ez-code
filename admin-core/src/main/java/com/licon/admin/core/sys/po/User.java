package com.licon.admin.core.sys.po;

import java.util.List;

import com.licon.admin.core.common.BaseField;
import com.licon.admin.core.mybatis.enums.EnableEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/29 14:36
 */
@Getter
@Setter
@ToString(callSuper = true)
public class User extends BaseField {
	private String userId;

	private String account;

	private String password;

	private String name;

	private String email;

	private String phone;

	private String gender;

	private Integer age;

	private EnableEnum disable;

	private List<Role> roleList;
}
