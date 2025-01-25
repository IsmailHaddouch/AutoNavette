package com.monprojet.dao;

import com.monprojet.models.User;
import java.util.List;

public interface UserDAO {
	void supprimerUser(int id);
	List<User> listerUsers();
	User trouverUserParId(int id);
	void ajouterUser(User User);
}
