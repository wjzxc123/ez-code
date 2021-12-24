package com.licon.domain.api;


import java.util.List;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.licon.domain.application.dto.TransferCommand;
import com.licon.domain.application.service.AccountService;
import com.licon.domain.application.service.BankService;
import com.licon.domain.domian.ceq.QueryAccount;
import com.licon.domain.domian.entity.Account;
import com.licon.admin.core.common.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/11/5 16:17
 */
@RestController
@Slf4j
@Api("银行业务模块")
public class TransferController {
	final BankService bankService;
	final AccountService accountService;
	public TransferController(BankService bankService, AccountService accountService) {
		this.bankService = bankService;
		this.accountService = accountService;
	}

	@ApiOperation(value = "转账",notes = "A=>B",httpMethod = "POST",response = ResultData.class)
	@ApiOperationSupport(author = "Licon")
	@PostMapping("/bank/transfer")
	public ResultData<Boolean> transfer(@RequestBody TransferCommand transferCommand)throws Exception{
		ResultData<Boolean> resultData;
		resultData = bankService.bankTransferBusiness(transferCommand);
		return resultData;
	}

	@ApiOperation(value = "根据用户id和账号获取用户",notes = "get(usrId,accountNumber)",httpMethod = "GET",response = ResultData.class)
	@ApiOperationSupport(author = "Licon")
	@GetMapping("/account/all")
	public ResultData<Boolean>  getAccount(QueryAccount queryAccount)throws Exception{
		List<Account> accounts = accountService.queryAllAccount(queryAccount);
		System.out.println(accounts);
		return ResultData.success();
	}
}
