package com.zm.provider.entity;

import java.io.Serializable;
import java.util.Date;

public class Book  implements Serializable{

	private String name;
	
	private Integer price;
	
	private Date createTime;

	public Book() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Book(String name, Integer price, Date createTime) {
		super();
		this.name = name;
		this.price = price;
		this.createTime = createTime;
	}
	
	
}
