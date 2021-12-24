package com.licon.domain.exception;

import com.licon.admin.core.exception.BusinessException;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/10/29 14:41
 */
public class DailyLimitException extends BusinessException {
	public DailyLimitException(String message) {
		super(message);
	}
}
