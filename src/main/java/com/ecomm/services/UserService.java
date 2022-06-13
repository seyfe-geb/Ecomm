package com.ecomm.services;

import com.ecomm.dto.user.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllSellers();

    List<UserDto> getAllBuyers();
}
