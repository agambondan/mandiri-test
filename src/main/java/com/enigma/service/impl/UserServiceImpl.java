package com.enigma.service.impl;

import com.enigma.constant.GeneratorConstant;
import com.enigma.entity.User;
import com.enigma.exception.DataNotFound;
import com.enigma.repository.UserRepository;
import com.enigma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUserById(User user) {
        User getUser = getUserById(user.idUser);
        return saveUser(user);
    }

    @Override
    public User getUserById(String idUser) {
        if (!userRepository.findById(idUser).isPresent()){
            throw new DataNotFound(GeneratorConstant.ID_NOT_FOUND);
        }
        return userRepository.findById(idUser).get();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(String idUser) {
        userRepository.deleteById(idUser);
    }
}
