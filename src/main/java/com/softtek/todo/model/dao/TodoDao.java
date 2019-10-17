package com.softtek.todo.model.dao;

import java.util.List;

import com.softtek.todo.model.TodoItem;

public interface TodoDao {

	public List<TodoItem> findAll();
	
	public void save(TodoItem item);
	
	public TodoItem findOne(Long id);
	
	public void delete(Long id);

}