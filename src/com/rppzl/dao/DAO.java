package com.rppzl.dao;

import java.util.List;

public interface DAO<T> {
	List<T> getList();
	void save(T object);
	T get(int id);
	void delete(int id);
}
