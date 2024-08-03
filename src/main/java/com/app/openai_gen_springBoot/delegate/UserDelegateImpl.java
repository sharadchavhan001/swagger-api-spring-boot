package com.app.openai_gen_springBoot.delegate;

import com.app.openai_gen_springBoot.generated.api.UsersApiDelegate;
import com.app.openai_gen_springBoot.generated.model.User;
import com.app.openai_gen_springBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Service
public class UserDelegateImpl implements UsersApiDelegate {
    @Autowired
    UserService userService;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        System.out.println("UserDelegateImpl.getRequest() called");
        return UsersApiDelegate.super.getRequest();
    }

    @Override
    public ResponseEntity<Void> deleteUserById(String userId) {
        System.out.println("UserDelegateImpl.deleteUserById() called");
        return new ResponseEntity<>(userService.deleteUser(userId), null, HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<User> getUserById(String userId) {
        System.out.println("UserDelegateImpl.getUserById() called");
        return new ResponseEntity<>(userService.getUserById(userId), null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<User>> getUsers() {
        System.out.println("UserDelegateImpl.getUsers() called");
        return new ResponseEntity<>(userService.getAllUsers(), null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> updateUserById(String userId, User user) {
        System.out.println("UserDelegateImpl.updateUserById() called");
        return new ResponseEntity<>(userService.updateUser(userId, user), null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> usersPost(User user) {
        System.out.println("UserDelegateImpl.usersPost() called");
        return new ResponseEntity<>(userService.addUser(user), null, HttpStatus.CREATED);
    }
}
