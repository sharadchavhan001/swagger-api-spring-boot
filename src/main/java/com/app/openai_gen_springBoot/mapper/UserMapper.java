package com.app.openai_gen_springBoot.mapper;

import com.app.openai_gen_springBoot.model.User;
import java.util.List;

public interface UserMapper {
    com.app.openai_gen_springBoot.generated.model.User toGeneratedUser(User user);

    List<com.app.openai_gen_springBoot.generated.model.User> toGeneratedUserList(List<User> users);

    User generatedUserToUser(com.app.openai_gen_springBoot.generated.model.User user);
}
