package ua.cn.dmitrykrivenko.usermanagement.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.cn.dmitrykrivenko.usermanagement.dao.UserDAO;
import ua.cn.dmitrykrivenko.usermanagement.domain.User;

/**
 * 
 * @author Dmitry Krivenko <dmitrykrivenko at gmail.com>
 */
@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers(int start, int length) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		if (start >= 0) {
			criteria.setFirstResult(start);
		}
		if (length >= 0) {
			criteria.setMaxResults(length);
		}
		return criteria.list();
	}

	@Override
	public void removeUser(Integer id) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class, id);
		if (null != user) {
			sessionFactory.getCurrentSession().delete(user);
		}
	}

	@Override
	public int getUsersCount() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.setProjection(Projections.rowCount());
		Object count = criteria.uniqueResult();
		if (count instanceof Integer) {
			return (Integer) count;
		} else {
			return convertToInt((Long) count);
		}
	}

	@Override
	public User getManagerOfLargestNumOfUsers() {
		String sqlQuery = "SELECT * FROM ("
				+ "SELECT manager_id"
				+ "FROM users"
				+ "WHERE manager_id IS NOT NULL"
				+ "GROUP BY manager_id"
				+ "ORDER BY COUNT( * ) DESC"
				+ "LIMIT 1) AS U1"
				+ "JOIN users AS U2"
				+ "ON U1.manager_id = U2.id";
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sqlQuery);
		return (User) query.uniqueResult();
	}

	private static int convertToInt(Long longValue) {
		if (longValue < Integer.MIN_VALUE || longValue > Integer.MAX_VALUE) {
			throw new IllegalArgumentException(longValue + " cannot be cast to int without changing its value.");
		}
		return longValue.intValue();
	}

}
