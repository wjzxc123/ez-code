package com.lut.admin.core.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lut.admin.core.common.BaseField;
import com.lut.admin.core.domain.repository.Aggregate;
import com.lut.admin.core.type.ID;
import lombok.Data;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/17 10:39
 */
@Data
@TableName("sys_resource")
public class Resource extends BaseField{
	private Long id;

	private String resourceId;

	private String resourcePath;

	private String resourceName;

	private String resourceVersion;
}
