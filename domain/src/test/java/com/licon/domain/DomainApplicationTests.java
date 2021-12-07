package com.licon.domain;

import com.licon.domain.domian.entity.Account;
import com.licon.domain.persistence.mapper.AccountMapper;
import com.licon.domain.persistence.po.AccountDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class DomainApplicationTests {

	@Autowired
	AccountMapper accountMapper;

	@Test
	void contextLoads() {
		AccountDO accountDO = new AccountDO();
		Account account = new Account();
		account.setCreateTime(accountDO.getCreateTime());
		System.out.println(account);
	}

	@Test
	public void insertUser(){
		AccountDO accountDO = new AccountDO();
		accountDO.setAccountId(1L);
		accountDO.setUserId(1L);
		accountDO.setAccountNumber("123456");
		accountDO.setAvailable(new BigDecimal(10000));
		accountDO.setDailyLimit(new BigDecimal(1000));
		accountDO.setCurrency("CNY");
		accountMapper.insert(accountDO);
	}
}
