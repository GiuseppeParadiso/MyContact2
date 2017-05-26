package it.paradisogiuseppe.services;

import java.util.List;

import it.paradisogiuseppe.dao.UserDao;
import it.paradisogiuseppe.dao.UserDaoImpl;
import it.paradisogiuseppe.model.UserModel;

public class UserServiceImpl implements UserService{
	
	private UserDao dao=new UserDaoImpl();
	
	@Override
	public List<UserModel> getUsers() {
		return dao.getUsers();
	}

	@Override
	public UserModel getUserById(int id) {
		return dao.getUserById(id);
	}

	@Override
	public UserModel getUserByUsernameAndPassword(String username, String password) {
		return dao.getUserByUsernameAndPassword(username, password);
	}

	@Override
	public UserModel addUser(UserModel user) {
		return dao.addUser(user);
	}

}
