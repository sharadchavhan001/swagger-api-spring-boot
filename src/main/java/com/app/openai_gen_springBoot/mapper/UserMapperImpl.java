package com.app.openai_gen_springBoot.mapper;
// src/main/java/com/app/openai_gen_springBoot/mapper/UserMapperImpl.java

import com.app.openai_gen_springBoot.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public com.app.openai_gen_springBoot.generated.model.User toGeneratedUser(User user) {
        if (user == null) {
            return null;
        }
        return new com.app.openai_gen_springBoot.generated.model.User()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .mobile(user.getMobile());

    }

    @Override
    public List<com.app.openai_gen_springBoot.generated.model.User> toGeneratedUserList(List<User> users) {
        if (users == null) {
            return null;
        }
        return users.stream()
                .map(this::toGeneratedUser)
                .collect(Collectors.toList());
    }

    @Override
    public User generatedUserToUser(com.app.openai_gen_springBoot.generated.model.User user) {
        if (user == null) {
            return null;
        }
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setMobile(user.getMobile());
        return newUser;
    }
}