package com.licon.domain.external.service.impl;

import java.math.BigDecimal;
import java.util.Currency;

import com.licon.domain.common.CurrencyEnum;
import com.licon.domain.external.service.ExchangeRateService;
import com.licon.domain.types.ExchangeRate;

import org.springframework.stereotype.Service;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/10/29 17:01
 */
@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {
	@Override
	public ExchangeRate getRate(Currency from, Currency to) {
		if(from.equals(to)){
			return new ExchangeRate(new BigDecimal(1),from,to);
		}else if (CurrencyEnum.CNY.getCode().equalsIgnoreCase(from.getCurrencyCode())
				&& CurrencyEnum.USD.getCode().equalsIgnoreCase(to.getCurrencyCode())){
			return new ExchangeRate(new BigDecimal("0.1561"),from,to);
		}else if(CurrencyEnum.USD.getCode().equalsIgnoreCase(to.getCurrencyCode())
				&& CurrencyEnum.CNY.getCode().equalsIgnoreCase(from.getCurrencyCode())) {
			return new ExchangeRate(new BigDecimal("6.405"),from,to);
		}
		return null;
	}
}
