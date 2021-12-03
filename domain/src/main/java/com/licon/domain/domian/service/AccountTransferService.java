package com.licon.domain.domian.service;

import com.licon.domain.domian.entity.Account;
import com.licon.domain.exception.DailyLimitException;
import com.licon.domain.exception.InsufficientFundsException;
import com.licon.domain.types.ExchangeRate;
import com.licon.domain.types.Money;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/10/29 16:54
 */
public interface AccountTransferService {
	/***
	 *转账操作
	 * @param sourceAccount
	 * @param targetMoney
	 * @param targetAccount
	 * @param exchangeRate
	 * @return
	 * @throws DailyLimitException
	 * @throws InsufficientFundsException
	 * @author Licon
	 * @date 2021/11/15 16:12
	 */
	void transfer(Account sourceAccount, Money targetMoney,Account targetAccount, ExchangeRate exchangeRate) throws DailyLimitException, InsufficientFundsException;
}
