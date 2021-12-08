package com.licon.domain.application.dto;

import java.math.BigDecimal;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.licon.domain.common.CurrencyValid;
import com.licon.domain.common.group.TransferGroup;
import com.licon.domain.common.group.UndoGroup;
import com.licon.domain.standard.CommandBase;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/11/5 16:26
 */
@Data
@ApiModel(value = "转账指令",description = "转账过程中用到的关键信息")
public class TransferCommand extends CommandBase {
	@ApiModelProperty(value = "用户id",example = "1",dataType = "Long",position = 0,required = true)
	@NotNull(message = "用户id不能为空",groups = TransferGroup.class)
	Long userId;

	@ApiModelProperty(value = "对方账户",example = "1234567",dataType = "String",position = 1,required = true)
	@NotEmpty(message = "对方账户不能为空",groups = TransferGroup.class)
	@NotNull(message = "对方账户不能为空",groups = UndoGroup.class)
	String accountNumber;

	@ApiModelProperty(value = "转账金额",example = "1000",dataType = "BigDecimal",position = 2,required = true)
	@Min(value = 0,message = "转账金额必须大于0",groups = TransferGroup.class)
	@Max(value = 1000,message = "单次转账金额必须小于1000",groups = UndoGroup.class)
	BigDecimal operateMoney;

	@ApiModelProperty(value = "币种",example = "CNY",dataType = "String",position = 3,required = true)
	@CurrencyValid(message = "请传入合法币种",groups = TransferGroup.class)
	String currency;
}
