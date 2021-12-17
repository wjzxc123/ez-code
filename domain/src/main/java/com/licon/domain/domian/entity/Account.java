package com.licon.domain.domian.entity;

import java.util.Currency;

import com.licon.domain.exception.DailyLimitException;
import com.licon.domain.exception.InsufficientFundsException;
import com.licon.domain.exception.InvalidCurrencyException;
import com.licon.domain.exception.MoneyAmountNotNullException;
import com.licon.domain.types.AccountId;
import com.licon.domain.types.AccountNumber;
import com.licon.domain.types.Money;
import com.licon.domain.types.UserId;
import com.lut.admin.core.common.BaseField;
import com.lut.admin.core.domain.repository.Aggregate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/10/29 14:34
 */
@Setter
@Getter
@ToString
public class Account extends BaseField implements Aggregate<UserId> {
	private UserId userId;
	private AccountId accountId;
	private AccountNumber accountNumber;
	private Money available;
	private Money dailyLimit;
	private Currency currency;

	/***
	 * 存入
	 * @param money
	 * @return
	 * @throws
	 * @author Licon
	 * @date 2021/10/29 15:15
	 */
	public void deposit(Money money)throws InvalidCurrencyException, MoneyAmountNotNullException {
		if (!this.currency.equals(money.getCurrency())){
			throw new InvalidCurrencyException("币种不匹配");
		}
		this.available = this.available.add(money);
	}

	/***
	 * 取出
	 * @param money
	 * @return
	 * @throws
	 * @author Licon
	 * @date 2021/10/29 15:11
	 */
	public void fetch(Money money) throws DailyLimitException,InvalidCurrencyException, InsufficientFundsException {
		if (!this.currency.equals(money.getCurrency())){
			throw new InvalidCurrencyException("币种不匹配");
		}
		if (available.compareTo(money)<0){
			throw new InsufficientFundsException("账户金额不足");
		}
		if (dailyLimit.compareTo(money)<0){
			throw new DailyLimitException("账户已超过日限额");
		}
		this.available = this.available.subtract(money);
	}

	@Override
	public UserId getBId() {
		return this.userId;
	}
}
