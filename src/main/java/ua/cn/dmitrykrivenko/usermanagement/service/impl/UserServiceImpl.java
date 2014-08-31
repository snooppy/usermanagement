package ua.cn.dmitrykrivenko.usermanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ua.cn.dmitrykrivenko.usermanagement.dao.UserDAO;
import ua.cn.dmitrykrivenko.usermanagement.domain.User;
import ua.cn.dmitrykrivenko.usermanagement.service.UserService;

/**
 * 
 * @author Dmitry Krivenko <dmitrykrivenko at gmail.com>
 */
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Transactional
	@Override
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	@Transactional
	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	@Transactional
	@Override
	public List<User> listUsers(int start, int length) {
		return userDAO.listUsers(start, length);
	}

	@Transactional
	@Override
	public void removeUser(Integer id) {
		userDAO.removeUser(id);
	}

	@Transactional
	@Override
	public int getUsersCount() {
		return userDAO.getUsersCount();
	}

	@Transactional
	@Override
	public User getManagerOfLargestNumOfUsers() {
		return userDAO.getManagerOfLargestNumOfUsers();
	}

}
