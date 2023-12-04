package com.mathquiz.tomatofunmathquiz.util.mappers;

import com.mathquiz.tomatofunmathquiz.dto.UserDto;
import com.mathquiz.tomatofunmathquiz.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto entityToByUserDto(User user);
}
