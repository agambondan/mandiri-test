package com.enigma.service;

import com.enigma.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User updateUserById(User user);

    User getUserById(String idUser);

    List<User> getAllUser();

    void deleteUserById(String idUser);

}
