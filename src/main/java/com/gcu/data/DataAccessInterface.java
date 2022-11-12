package com.gcu.data;

import java.util.*;

public interface DataAccessInterface<T> {
	public List<T> findAll();
	public T findByID(int id);
	public void create(T t);
	public void update(T t);
	public void delete(T t);
}