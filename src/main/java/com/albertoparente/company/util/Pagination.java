package com.albertoparente.company.util;

import java.util.List;

public class Pagination<T> {
	
	private int size;
	private int page;
	private long totalPages;
	private List<T> records;
	
	public Pagination(int size, int page, long totalPages, List<T> records) {
		super();
		this.size = size;
		this.page = page;
		this.totalPages = totalPages;
		this.records = records;
	}

	protected int getSize() {
		return size;
	}

	protected int getPage() {
		return page;
	}

	protected long getTotalPages() {
		return totalPages;
	}

	protected List<T> getRecords() {
		return records;
	}
}
