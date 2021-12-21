package com.lut.admin.core.util;

import java.util.Collections;
import java.util.List;

/**
 * Describe: Lazy 惰性加载使用案例
 *
 * @author Licon
 * @date 2021/12/21 13:15
 */
public class LazyExample {
	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.setId(1L);
		Lazy<String> nameLzy = Lazy.of(() -> "123" + "45" + "67");
		demo.setTestName(nameLzy);
		Lazy<Long> numberLazy = nameLzy.map(Long::parseLong);
		demo.setTestNumber(numberLazy);
		Lazy<List<String>> listLazy = nameLzy
				.flatmap(name -> numberLazy.map((number -> Collections.singletonList(name +"@"+number))));
		demo.setTestList(listLazy);
		System.out.println(demo);
	}
}
