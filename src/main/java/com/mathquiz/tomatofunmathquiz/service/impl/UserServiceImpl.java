package com.mathquiz.tomatofunmathquiz.service.impl;

import com.mathquiz.tomatofunmathquiz.dto.UserDto;
import com.mathquiz.tomatofunmathquiz.entity.User;
import com.mathquiz.tomatofunmathquiz.exception.EntryDuplicationException;
import com.mathquiz.tomatofunmathquiz.exception.NotFoundException;
import com.mathquiz.tomatofunmathquiz.repo.UserRepo;
import com.mathquiz.tomatofunmathquiz.service.UserService;
import com.mathquiz.tomatofunmathquiz.util.mappers.UserMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDto getUserByEmail(String email) {
        Optional<User> user = userRepo.findByEmail(email);
        if(user.isPresent()){
            UserDto userDto = userMapper.entityToByUserDto(user.get());
            return userDto;
        }else {
            throw new NotFoundException("User not available inserted email ");
        }
    }

    @Override
    public String saveUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        if (!userRepo.existsById(user.getUserId())) {
            userRepo.save(user);
            return user.getUserName() + " saved successfully";
        } else {
            throw new EntryDuplicationException("Already Added");
        }

    }

}
