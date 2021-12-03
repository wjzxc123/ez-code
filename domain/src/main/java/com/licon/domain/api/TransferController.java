package com.licon.domain.api;


import java.util.List;

import com.licon.domain.application.dto.TransferCommand;
import com.licon.domain.application.service.AccountService;
import com.licon.domain.application.service.BankService;
import com.licon.domain.common.ResultData;
import com.licon.domain.domian.ceq.QueryAccount;
import com.licon.domain.domian.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/11/5 16:17
 */
@RestController
@Slf4j
public class TransferController {
	final BankService bankService;
	final AccountService accountService;
	public TransferController(BankService bankService, AccountService accountService) {
		this.bankService = bankService;
		this.accountService = accountService;
	}

	@PostMapping("/bank/transfer")
	public ResultData<Boolean> transfer(@RequestBody TransferCommand transferCommand)throws Exception{
		ResultData<Boolean> resultData;
		resultData = bankService.bankTransferBusiness(transferCommand);
		return resultData;
	}

	@GetMapping("/account/all")
	public ResultData<Boolean>  getAccount(@RequestBody QueryAccount queryAccount)throws Exception{
		List<Account> accounts = accountService.queryAllAccount(queryAccount);
		System.out.println(accounts);
		return ResultData.success();
	}
}
