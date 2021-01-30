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

	public int getSize() {
		return size;
	}

	public int getPage() {
		return page;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public List<T> getRecords() {
		return records;
	}
}
