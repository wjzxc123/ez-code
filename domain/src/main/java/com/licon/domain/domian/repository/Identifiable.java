package com.licon.domain.domian.repository;


/**
 * Describe:
 *
 * @author Licon
 * @date 2021/11/19 10:10
 */
public interface Identifiable<ID extends Identifier> {
	ID getBId();
}
