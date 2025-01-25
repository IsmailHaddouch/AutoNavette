package com.monprojet.dao;

import java.util.ArrayList;
import java.util.List;

import com.monprojet.models.User;

public class UserDAOImpl implements UserDAO {
    private List<User> Users = new ArrayList<>();

    @Override
    public void ajouterUser(User User) {
        Users.add(User);
    }

    @Override
    public User trouverUserParId(int id) {
        return Users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> listerUsers() {
        return Users;
    }

    @Override
    public void supprimerUser(int id) {
        Users.removeIf(u -> u.getId() == id);
    }

}
