package com.mathquiz.tomatofunmathquiz.controller;

import com.mathquiz.tomatofunmathquiz.dto.UserDto;
import com.mathquiz.tomatofunmathquiz.service.UserService;
import com.mathquiz.tomatofunmathquiz.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"api/v1/user"})
@CrossOrigin(origins = "http://localhost:8890")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody UserDto userDto){
        String message = userService.saveUser(userDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "success", message),
                HttpStatus.CREATED
        );
    }

    @GetMapping(
            path = {"/get-by-email"},
            params = {"email"}
    )
    public ResponseEntity<StandardResponse> customerDto(@RequestParam(value = "email") String email){
        UserDto userDto = userService.getUserByEmail(email);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "success", userDto),
                HttpStatus.OK
        );
    }
}
