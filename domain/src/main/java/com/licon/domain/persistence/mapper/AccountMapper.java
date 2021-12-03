package com.licon.domain.persistence.mapper;

import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.licon.domain.domian.ceq.QueryAccount;
import com.licon.domain.persistence.po.AccountDO;
import org.apache.ibatis.annotations.Mapper;


/**
 * Describe:
 *
 * @author Licon
 * @date 2021/10/29 15:34
 */
@Mapper
@DS("read")
public interface AccountMapper extends BaseMapper<AccountDO> {

	/***
	 *分页查询账户
	 * @param queryAccount
	 * @return {@link List< AccountDO>}
	 * @throws
	 * @author Licon
	 * @date 2021/11/22 9:54
	 */
	List<AccountDO> queryPaged(QueryAccount queryAccount);

	/***
	 *根据UserId查询账户
	 * @param userId
	 * @return {@link AccountDO}
	 * @throws
	 * @author Licon
	 * @date 2021/11/15 16:10
	 */
	AccountDO queryByUserId(Long userId);

	/***
	 *根据accountId查询账户
	 * @param accountId
	 * @return {@link AccountDO}
	 * @throws
	 * @author Licon
	 * @date 2021/11/15 16:10
	 */
	AccountDO queryByAccountId(Long accountId);

	/***
	 *根据 accountNumber 查询账户
	 * @param accountNumber
	 * @return {@link AccountDO}
	 * @throws
	 * @author Licon
	 * @date 2021/11/15 16:10
	 */
	AccountDO queryByAccountNumber(String accountNumber);


	/***
	 * 删除账户
	 * @param accountDO
	 * @return
	 * @throws
	 * @author Licon
	 * @date 2021/11/22 9:48
	 */
	void delete(AccountDO accountDO);
}
