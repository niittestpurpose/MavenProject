package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.MyCategory;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO 
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCategory(MyCategory category) 
	{
		try{
			Session session=sessionFactory.getCurrentSession();
			session.save(category);
			return true;
		}
		catch(Exception e){
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	@Override
	public boolean deleteCategory(MyCategory category) {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.delete(category);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateCategory(MyCategory category) {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.update(category);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<MyCategory> getCategoryDetails() 
	{
		Session session=sessionFactory.getCurrentSession();
		List<MyCategory> categoryList=session.createQuery("from MyCategory").list();
		return categoryList;
	}

	@Override
	public MyCategory getCategory(int categoryId) 
	{
		Session session=sessionFactory.getCurrentSession();
		MyCategory category=(MyCategory)session.get(MyCategory.class, categoryId);
		return category;
	}

}
