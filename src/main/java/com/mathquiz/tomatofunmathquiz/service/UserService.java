package com.mathquiz.tomatofunmathquiz.service;

import com.mathquiz.tomatofunmathquiz.dto.UserDto;

public interface UserService {

    UserDto getUserByEmail(String email);

    String saveUser(UserDto userDto);

}
