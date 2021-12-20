package com.licon.domain.persistence.po;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lut.admin.core.common.BaseField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/10/29 15:30
 */
@Getter
@Setter
@ToString
@TableName("account")
@Accessors(chain = true)
public class AccountDO extends BaseField {
	private Long userId;
	private Long accountId;
	private String accountNumber;
	private BigDecimal available;
	private BigDecimal dailyLimit;
	private String currency;
	@TableLogic
	private Integer deleted;
}
