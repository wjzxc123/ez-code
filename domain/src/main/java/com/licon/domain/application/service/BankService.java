package com.licon.domain.application.service;


import javax.validation.Valid;

import com.licon.domain.application.dto.TransferCommand;
import com.lut.admin.core.common.ResultData;


/**
 * Describe:
 *
 * @author Licon
 * @date 2021/11/1 9:56
 */
public interface BankService {
	/***
	 *银行转账业务
	 * @param transferCommand
	 * @return {@link ResultData< Boolean>}
	 * @throws Exception
	 * @author Licon
	 * @date 2021/11/15 16:13
	 */
	ResultData<Boolean> bankTransferBusiness(@Valid TransferCommand transferCommand)throws Exception;
}
