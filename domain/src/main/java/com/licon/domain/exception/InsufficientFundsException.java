package com.licon.domain.exception;

import com.lut.admin.core.exception.BusinessException;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/10/29 15:13
 */
public class InsufficientFundsException extends BusinessException {
	public InsufficientFundsException(String message) {
		super(message);
	}
}
