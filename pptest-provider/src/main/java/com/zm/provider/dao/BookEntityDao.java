package com.zm.provider.dao;

import com.zm.provider.entity.Book;

public interface BookEntityDao {

	/**
	 * 根据主键查找Book信息
	 * @param id
	 * @return
	 */
	Book getBook(String id);
}
