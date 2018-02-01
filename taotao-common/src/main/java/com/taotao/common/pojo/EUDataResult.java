package com.taotao.common.pojo;

import java.util.List;

public class EUDataResult {
	private long total;
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	private List<?> rows;
}
