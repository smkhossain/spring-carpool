package com.example.carpool.reservation.querymodel;

import lombok.*;

import javax.validation.constraints.AssertTrue;


@NoArgsConstructor
public class PageParam {
    protected Integer offset = 0;
    protected Integer limit = 20;

    @AssertTrue
    protected boolean getValidPage() {
        return (offset != null && limit != null) || (offset == null && limit == null);
    }

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
    
    
}
