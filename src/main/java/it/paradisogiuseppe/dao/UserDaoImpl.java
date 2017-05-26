package it.paradisogiuseppe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import it.paradisogiuseppe.model.UserModel;

public class UserDaoImpl extends HibernateDao implements UserDao {
	
	public UserDaoImpl(){}
	
	@Override
	public UserModel getUserById(int id) {
		Criteria criteria = getSession().createCriteria(UserModel.class);
		criteria.add(Restrictions.eq("id", id));
		return (UserModel) criteria.uniqueResult();
	}

	@Override
	public UserModel getUserByUsernameAndPassword(String username, String password) {
		Query namedQuery = getSession().getNamedQuery("findByUsernameAndPassword");
		namedQuery.setParameter("username", username);
		namedQuery.setParameter("password", password);
		UserModel uniqueResult = (UserModel) namedQuery.uniqueResult();
		return uniqueResult;
	}

	@Override
	public UserModel addUser(UserModel user) {
		return (UserModel)persist(user);
	}

	@Override
	public List<UserModel> getUsers() {
		Query namedQuery = getSession().getNamedQuery("findAllUser");
		@SuppressWarnings("unchecked")
		List<UserModel> results = (List<UserModel>)namedQuery.list();
		return results;
	}

}
