package com.licon.domain.application.service.impl;

import java.util.Currency;
import javax.validation.Valid;

import com.licon.domain.application.dto.TransferCommand;
import com.licon.domain.application.service.BankService;
import com.licon.domain.common.group.TransferGroup;
import com.licon.domain.domian.entity.Account;
import com.licon.domain.domian.repository.AccountRepository;
import com.licon.domain.domian.service.AccountTransferService;
import com.licon.domain.external.service.ExchangeRateService;
import com.licon.domain.types.AccountNumber;
import com.licon.domain.types.ExchangeRate;
import com.licon.domain.types.Money;
import com.licon.domain.types.UserId;
import com.lut.admin.core.common.ResultData;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/11/1 10:21
 */
@Service
@Validated
public class BankServiceImpl implements BankService {
	private final ExchangeRateService exchangeRateService;

	private final AccountRepository accountRepository;

	private final AccountTransferService accountTransferService;

	public BankServiceImpl(ExchangeRateService exchangeRateService, AccountRepository accountRepository, AccountTransferService accountTransferService) {
		this.exchangeRateService = exchangeRateService;
		this.accountRepository = accountRepository;
		this.accountTransferService = accountTransferService;
	}

	@Override
	@Transactional(rollbackFor = RuntimeException.class)
	@Validated(TransferGroup.class)
	public ResultData<Boolean> bankTransferBusiness(@Valid TransferCommand transferCommand) throws Exception {
		//查找源账户
		Account sourceAccount = accountRepository.find(new UserId(transferCommand.getUserId()));
		//查找目标账户
		Account targetAccount = accountRepository.findInAccountNumber(new AccountNumber(transferCommand.getAccountNumber()));
		//获取汇率
		ExchangeRate rate = exchangeRateService.getRate(sourceAccount.getCurrency(), targetAccount.getCurrency());
		//转账操作
		accountTransferService.transfer(sourceAccount,new Money(transferCommand.getOperateMoney(), Currency.getInstance(transferCommand.getCurrency())),targetAccount,rate);

		//金额持久
		accountRepository.save(sourceAccount);
		accountRepository.save(targetAccount);

		//添加审计信息-略
		return ResultData.success();
	}
}
