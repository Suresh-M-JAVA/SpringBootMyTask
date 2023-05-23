package com.backend.mytask.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.backend.mytask.dto.UserDTO;
import com.backend.mytask.dto.UserSaveDTO;
import com.backend.mytask.dto.UserUpdateDTO;
import com.backend.mytask.entity.User;

public interface UserService {

	String addUser(UserSaveDTO userSaveDTO);

	List<UserDTO> getAllUser();

	String updateUsers(UserUpdateDTO userUpdateDTO);

	boolean deleteUser(int id);

	User getUserByEmail(String email);

}
