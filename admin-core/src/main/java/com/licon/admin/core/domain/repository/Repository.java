package com.licon.admin.core.domain.repository;

import javax.validation.constraints.NotNull;

import com.licon.admin.core.exception.AttachException;
import com.licon.admin.core.exception.DetachException;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/11/19 10:14
 */
public interface Repository<T extends Aggregate<ID>,ID extends Identifier>{
	void attach(@NotNull T aggregate) throws AttachException;

	void detach(@NotNull T aggregate) throws DetachException;

	T find(@NotNull ID id) throws Exception;

	void remove(@NotNull T aggregate)throws Exception;

	Aggregate<ID> save(@NotNull T aggregate)throws Exception;
}
