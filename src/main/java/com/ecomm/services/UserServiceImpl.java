package com.ecomm.services;

import com.ecomm.dto.user.UserDto;
import com.ecomm.models.ERole;
import com.ecomm.models.Role;
import com.ecomm.models.User;
import com.ecomm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getAllSellers() {
        List<User> sellers = userRepository.findByRolesContains(new Role(ERole.ROLE_SELLER));
        System.out.println(sellers);
        return null;
    }
}
