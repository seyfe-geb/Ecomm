package com.ecomm.services;

import com.ecomm.dto.user.ApproveDto;
import com.ecomm.dto.user.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllSellers();

    List<UserDto> getAllBuyers();

    List<UserDto> getUnapprovedSellers();

    UserDto getUserById(Long id);

    void updateUser(ApproveDto approveDto);
}
