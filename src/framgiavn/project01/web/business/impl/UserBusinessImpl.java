package framgiavn.project01.web.business.impl;

import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.dao.UserDAO;
import framgiavn.project01.web.info.UserInfo;
import framgiavn.project01.web.model.User;

public class UserBusinessImpl implements UserBusiness {

	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserInfo findByUserId(Integer user_id) {
		try {
			User u = getUserDAO().findByUserId(user_id);
			return new UserInfo(u);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public UserInfo findByUsername(String username) {
		try {
			User u = getUserDAO().findByUsername(username);
			return new UserInfo(u);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public UserInfo addUser(UserInfo user) {
		// TODO Auto-generated method stub
		try {
			getUserDAO().addUser(user.toUser());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}