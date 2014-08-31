package ua.cn.dmitrykrivenko.usermanagement.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ua.cn.dmitrykrivenko.usermanagement.dao.RoleDAO;
import ua.cn.dmitrykrivenko.usermanagement.domain.Role;

/**
 * 
 * @author Dmitry Krivenko <dmitrykrivenko at gmail.com>
 */
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Role getRole(int id) {
		Role role = (Role) getCurrentSession().load(Role.class, id);
		return role;
	}

}
