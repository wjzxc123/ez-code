package com.lut.admin.core.sys.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lut.admin.core.common.BaseField;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/20 11:32
 */
@Data
@TableName("sys_resource_authority")
@Accessors(chain = true)
public class ResourceAuthority extends BaseField {

	private String resourceId;

	private String authorityCode;
}
