package com.licon.domain.repository.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.licon.domain.domian.ceq.QueryAccount;
import com.licon.domain.domian.entity.Account;
import com.licon.domain.domian.repository.AccountRepository;
import com.licon.domain.persistence.mapper.AccountMapper;
import com.licon.domain.persistence.po.AccountDO;
import com.licon.domain.repository.converter.service.AccountBuilder;
import com.licon.domain.types.AccountId;
import com.licon.domain.types.AccountNumber;
import com.licon.domain.types.UserId;
import com.lut.admin.core.domain.repository.Aggregate;
import com.lut.admin.core.exception.AttachException;
import com.lut.admin.core.exception.DetachException;

import org.springframework.stereotype.Repository;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/11/19 10:50
 */
@Repository
public class AccountRepositoryImpl implements AccountRepository {

	private final AccountMapper accountMapper;

	private final AccountBuilder accountBuilder = AccountBuilder.INSTANCE;

	public AccountRepositoryImpl(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}

	@Override
	public Long countAccount(QueryAccount queryAccount) throws Exception {
		return null;
	}

	@Override
	public List<Account> query(QueryAccount queryAccount) throws Exception {
		return accountMapper.queryPaged(queryAccount)
				.stream().map(accountBuilder::toAccount).collect(Collectors.toList());
	}

	@Override
	public Account findInAccountNumber(AccountNumber accountNumber) throws Exception {
		AccountDO accountDo = accountMapper.queryByAccountNumber(accountNumber.getAccountNumber());
		return accountBuilder.toAccount(accountDo);
	}

	@Override
	public Account findInAccountId(AccountId accountId) throws Exception {
		AccountDO accountDo = accountMapper.queryByAccountId(accountId.getAccountId());
		return accountBuilder.toAccount(accountDo);
	}

	@Override
	public void attach(@NotNull Account aggregate) throws AttachException {

	}

	@Override
	public void detach(@NotNull Account aggregate) throws DetachException {

	}

	@Override
	public Account find(@NotNull UserId userId) throws Exception {
		AccountDO accountDo = accountMapper.queryByUserId(userId.getUserId());
		return accountBuilder.toAccount(accountDo);
	}

	@Override
	public void remove(@NotNull Account aggregate) throws Exception {
		accountMapper.delete(accountBuilder.fromAccount(aggregate));
	}

	@Override
	public Aggregate<UserId> save(@NotNull Account aggregate) throws Exception {
		int result = 0;
		if (aggregate.getAccountId() == null){
			result = accountMapper.insert(accountBuilder.fromAccount(aggregate));
		}else {
			result = accountMapper.updateById(accountBuilder.fromAccount(aggregate));
		}

		if (result == 0){
			throw new RuntimeException("保存异常");
		}
		return aggregate;
	}

}
