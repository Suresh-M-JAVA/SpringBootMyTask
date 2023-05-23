package com.backend.mytask.service;

import java.util.List;

import com.backend.mytask.dto.UserDTO;
import com.backend.mytask.dto.UserSaveDTO;
import com.backend.mytask.dto.UserUpdateDTO;

public interface UserService {

	String addUser(UserSaveDTO userSaveDTO);

	List<UserDTO> getAllUser();

	String updateUsers(UserUpdateDTO userUpdateDTO);

	boolean deleteUser(int id);

}
