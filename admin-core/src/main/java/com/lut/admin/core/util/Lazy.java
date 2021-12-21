package com.lut.admin.core.util;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/21 10:32
 */
public class Lazy<T> implements Supplier<T> {
	private final Supplier<? extends T> supplier;
	private T data;

	private Lazy(Supplier<? extends T> supplier) {
		this.supplier = supplier;
	}

	public static <T> Lazy<T> of (Supplier<? extends T> supplier){
		return new Lazy<>(supplier);
	}
	@Override
	public T get() {
		System.out.println("获取数据");
		if (data == null){
			T newData = supplier.get();
			if (newData == null){
				throw new IllegalStateException("Lazy value not be null!");
			}
			data = newData;
		}
		return data;
	}

	public <S> Lazy<S> map(Function<? super T,? extends S> function){
		return Lazy.of(()->function.apply(get()));
	}

	public <S> Lazy<S> flatmap(Function<? super T,Supplier<? extends S>> function){
		return Lazy.of(()->function.apply(get()).get());
	}
}
