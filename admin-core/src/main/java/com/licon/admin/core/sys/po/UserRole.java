package com.licon.admin.core.sys.po;

import com.licon.admin.core.common.BaseField;
import lombok.Getter;
import lombok.Setter;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/29 15:53
 */
@Getter
@Setter
public class UserRole extends BaseField {
	private String userId;

	private String roleCode;
}
