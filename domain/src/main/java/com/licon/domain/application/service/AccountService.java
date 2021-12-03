package com.licon.domain.application.service;


import java.util.List;

import com.licon.domain.domian.ceq.QueryAccount;
import com.licon.domain.domian.entity.Account;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/11/22 10:45
 */
public interface AccountService {
	List<Account> queryAllAccount(QueryAccount queryAccount)throws Exception;
}
