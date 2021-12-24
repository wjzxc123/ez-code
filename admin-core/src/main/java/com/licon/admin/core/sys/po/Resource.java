package com.licon.admin.core.sys.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.licon.admin.core.common.BaseField;
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

	private String resourceId;

	private String resourcePath;

	private String resourceName;

	private String resourceVersion;
}
