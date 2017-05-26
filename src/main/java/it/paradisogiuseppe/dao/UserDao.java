package it.paradisogiuseppe.dao;

import java.util.List;
import it.paradisogiuseppe.model.UserModel;

public interface UserDao {
	public List<UserModel> getUsers();
	public UserModel getUserById(int id);
	public UserModel getUserByUsernameAndPassword(String username, String password);
	public UserModel addUser(UserModel user);
}
