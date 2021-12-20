package com.lut.admin.core.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lut.admin.core.common.BaseField;
import lombok.Data;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/20 11:32
 */
@Data
@TableName("sys_resource_authority")
public class ResourceAuthority extends BaseField {
	private Long id;

	private String resourceId;

	private String authorityCode;
}
