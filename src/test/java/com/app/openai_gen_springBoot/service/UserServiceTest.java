package com.app.openai_gen_springBoot.service;

import com.app.openai_gen_springBoot.exception.UserNotFoundException;
import com.app.openai_gen_springBoot.mapper.UserMapper;
import com.app.openai_gen_springBoot.model.User;
import com.app.openai_gen_springBoot.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Mock
    private UserMapper userMapper;

    private com.app.openai_gen_springBoot.generated.model.User user;
    private com.app.openai_gen_springBoot.model.User internalUser;


    @BeforeEach
    public void setUp() {
        user = new com.app.openai_gen_springBoot.generated.model.User();
        user.setId("1");
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setMobile("1234567890");
        internalUser = new com.app.openai_gen_springBoot.model.User("1", "John Doe", "john.doe@example.com", "1234567890");

    }

    @Test
    public void testSaveUser() {
        when(userMapper.generatedUserToUser(user)).thenReturn(internalUser);
        when(userRepository.save(internalUser)).thenReturn(internalUser);
        when(userMapper.toGeneratedUser(internalUser)).thenReturn(user);

        com.app.openai_gen_springBoot.generated.model.User savedUser = userService.addUser(user);

        assertNotNull(savedUser);
        assertEquals(user.getId(), savedUser.getId());
        assertEquals(user.getName(), savedUser.getName());
        assertEquals(user.getEmail(), savedUser.getEmail());
    }

    @Test
    public void testGetUserById() {
        when(userRepository.findById(any(String.class))).thenReturn(Optional.of(internalUser));
        when(userMapper.toGeneratedUser(internalUser)).thenReturn(user);

        com.app.openai_gen_springBoot.generated.model.User foundUser = userService.getUserById("1");

        assertNotNull(foundUser);
        assertEquals(user.getId(), foundUser.getId());
        assertEquals(user.getName(), foundUser.getName());
        assertEquals(user.getEmail(), foundUser.getEmail());
    }

    @Test
    public void testGetUserById_NotFound() {
        when(userRepository.findById(any(String.class))).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> {
            userService.getUserById("1");
        });
    }
}