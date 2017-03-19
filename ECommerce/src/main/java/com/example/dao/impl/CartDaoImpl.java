package com.example.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.CartDao;
import com.example.model.Cart;

public class CartDaoImpl implements CartDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Cart> list() {
		// TODO Auto-generated method stub
		List<Cart> list = (List<Cart>) sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

	@Override
	public Cart get(String id) {
		// TODO Auto-generated method stub
		String hql = "from Cart where userID=" + "'" + id + "'  and status = " + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	@Override
	public void saveOrUpdate(Cart Cart) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(Cart);
		
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		cart.setId(id);
		try {
			sessionFactory.getCurrentSession().delete(cart);
		} catch (HibernateException e) {
			e.printStackTrace();
			//return e.getMessage();

		}
		return null;
	}

	@Override
	public int getTotalAmount(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
