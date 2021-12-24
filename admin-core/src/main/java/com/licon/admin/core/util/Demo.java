package com.licon.admin.core.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/21 13:11
 */
public class Demo {
	private Long id;

	private Lazy<String> testName = Lazy.of(()->"");

	private Lazy<Long> testNumber =  Lazy.of(()->0L);

	private Lazy<List<String>> testList =  Lazy.of(ArrayList::new);

	public void setId(Long id) {
		this.id = id;
	}

	public void setTestName(Lazy<String> testName) {
		this.testName = testName;
	}

	public void setTestNumber(Lazy<Long> testNumber) {
		this.testNumber = testNumber;
	}

	public void setTestList(Lazy<List<String>> testList) {
		this.testList = testList;
	}

	public Long getId() {
		return id;
	}

	public String getTestName() {
		return testName.get();
	}

	public Long getTestNumber() {
		return testNumber.get();
	}

	public List<String> getTestList() {
		return testList.get();
	}

	@Override
	public String toString() {
		return "Demo{" +
				"id=" + id +
				", testName=" + testName.get() +
				", testNumber=" + testNumber.get() +
				", testList=" + testList.get() +
				'}';
	}
}
