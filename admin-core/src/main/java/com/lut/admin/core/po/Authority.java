package com.lut.admin.core.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lut.admin.core.common.BaseField;
import lombok.Data;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/20 11:34
 */
@Data
@TableName("sys_authority")
public class Authority extends BaseField {
	private Long id;

	private String authorityCode;

	private String authorityName;
}
