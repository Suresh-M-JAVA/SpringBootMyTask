package com.backend.mytask.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.mytask.dto.UserDTO;
import com.backend.mytask.dto.UserSaveDTO;
import com.backend.mytask.dto.UserUpdateDTO;
import com.backend.mytask.entity.User;
import com.backend.mytask.userrepo.UserRepo;

@Service 
public class UserServiceIMPL implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public String addUser(UserSaveDTO userSaveDTO) {
		// TODO Auto-generated method stub
		User user = new User(
				
				userSaveDTO.getFirstname(),
				userSaveDTO.getLastname(),
				userSaveDTO.getGender(),
				userSaveDTO.getEmail(),
				userSaveDTO.getPassword()
				);
		userRepo.save(user);
		return user.getEmail();
	}

	@Override
	public List<UserDTO> getAllUser() {
		// TODO Auto-generated method stub
		List<User> getUsers = userRepo.findAll(); 
		List<UserDTO> userDTOList = new ArrayList<>();
		for(User u:getUsers) {
			UserDTO userDTO = new UserDTO(
				u.getId(),
				u.getFirstname(),
				u.getLastname(),
				u.getGender(),
				u.getEmail(),
				u.getPassword()
			); 
			userDTOList.add(userDTO);
		}
		return userDTOList;
	}

    @Override
    public String updateUsers(UserUpdateDTO userUpdateDTO)
    {
        if (userRepo.existsById(userUpdateDTO.getId())) {
        	
            User user = userRepo.getById(userUpdateDTO.getId());

            user.setFirstname(userUpdateDTO.getFirstname());
            user.setLastname(userUpdateDTO.getLastname());
            user.setGender(userUpdateDTO.getGender());
            user.setEmail(userUpdateDTO.getEmail());
            user.setPassword(userUpdateDTO.getPassword());
            userRepo.save(user);
        } else {
                System.out.println("Customer ID do not Exist");
            }
        	return null;
        }

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		if(userRepo.existsById(id))
        {
            userRepo.deleteById(id);
        }
        else
        {
            System.out.println("User ID not found");
        }

		return true;
	}

	
}
