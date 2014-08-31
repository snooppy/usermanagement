package ua.cn.dmitrykrivenko.usermanagement.dao;

import java.util.List;

import ua.cn.dmitrykrivenko.usermanagement.domain.User;

/**
 * 
 * @author Dmitry Krivenko <dmitrykrivenko at gmail.com>
 */
public interface UserDAO {

	void addUser(User user);

	void updateUser(User user);

	List<User> listUsers(int start, int length);

	void removeUser(Integer id);

	int getUsersCount();

	User getManagerOfLargestNumOfUsers();

}
