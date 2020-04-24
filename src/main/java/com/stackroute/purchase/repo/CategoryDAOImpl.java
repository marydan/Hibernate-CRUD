package com.stackroute.purchase.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.purchase.model.Category;

@Transactional
@Repository

public class CategoryDAOImpl  implements CategoryDAO{

	@Autowired
	SessionFactory session;
	
	
	public void addCategory(Category obj) {
	
		session.getCurrentSession().save(obj);
		
	}

	public void deleteCategory(int catid) {

		Category catobj=findByCategoryId(catid);
		session.getCurrentSession().delete(catobj);
	}

	public void updCategory(Category obj) {
	
		System.out.println("Inside updte" + obj.getCid() + obj.getCname()) ;
		
Category catobj=findByCategoryId(obj.getCid());
		catobj.setCname(obj.getCname());
session.getCurrentSession().update(catobj);
		
	}

	public Category findByCategoryId(int catid) {
	Category category=(Category)session.getCurrentSession().createQuery("from Category where cid="+ catid).uniqueResult();
		return category;
	}

	public List<Category> findallCategory() {

	List<Category> categories=session.getCurrentSession().createQuery("from Category").list();
		
		return categories;
	}

}
