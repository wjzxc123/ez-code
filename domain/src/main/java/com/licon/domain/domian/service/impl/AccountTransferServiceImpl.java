package com.licon.domain.domian.service.impl;

import com.licon.domain.domian.entity.Account;
import com.licon.domain.domian.service.AccountTransferService;
import com.licon.domain.exception.DailyLimitException;
import com.licon.domain.exception.InsufficientFundsException;
import com.licon.domain.types.ExchangeRate;
import com.licon.domain.types.Money;

import org.springframework.stereotype.Service;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/10/29 16:55
 */
@Service
public class AccountTransferServiceImpl implements AccountTransferService {
	@Override
	public void transfer(Account sourceAccount, Money targetMoney, Account targetAccount, ExchangeRate exchangeRate) throws DailyLimitException, InsufficientFundsException {
		Money sourceMoney = exchangeRate.changeTo(targetMoney);
		sourceAccount.fetch(sourceMoney);
		targetAccount.deposit(targetMoney);
	}
}
