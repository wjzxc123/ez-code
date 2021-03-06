package com.licon.admin.core.sys.po;

import com.licon.admin.core.common.BaseField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/20 11:34
 */
@Getter
@Setter
@ToString(callSuper = true)
public class Authority extends BaseField {

	private String authorityCode;

	private String authorityName;
}
