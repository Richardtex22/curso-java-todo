package com.softtek.todo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.todo.model.TodoItem;

@Repository
public class TodoDaoImpl implements TodoDao{

	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<TodoItem> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from TodoItem").getResultList();
	}

	@Override
	@Transactional
	public void save(TodoItem item) {
		// TODO Auto-generated method stub
		em.persist(item);
		
	}

	@Override
	@Transactional(readOnly = true)
	public TodoItem findOne(Long id) {
		// TODO Auto-generated method stub
		return em.find(TodoItem.class, id);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		em.remove(findOne(id));
	}

	
}
