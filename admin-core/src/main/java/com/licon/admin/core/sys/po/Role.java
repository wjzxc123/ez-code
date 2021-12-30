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
 * @date 2021/12/29 15:56
 */
@Setter
@Getter
@ToString(callSuper = true)
public class Role extends BaseField {
	private String roleCode;

	private String roleName;

	private String pCode;

	private EnableEnum enable;

	private List<Authority> authorityList;
}
