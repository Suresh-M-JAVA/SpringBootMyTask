package com.backend.mytask.usercontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.mytask.dto.UserDTO;
import com.backend.mytask.dto.UserSaveDTO;
import com.backend.mytask.dto.UserUpdateDTO;
import com.backend.mytask.entity.User;
import com.backend.mytask.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserController {

	@Autowired
	private UserService userService; 
	
	@PostMapping(path="/save")
	public String saveUser(@RequestBody UserSaveDTO userSaveDTO) {
		
		String id = userService.addUser(userSaveDTO);
		return id;
	}
	
	@GetMapping(path="/getAllUser")
	public List<UserDTO> getAllUser() {
		
		List<UserDTO> userslist = userService.getAllUser();
		return userslist;
	}
	
	@PutMapping(path = "/update")
    public String updateUser(@RequestBody UserUpdateDTO userUpdateDTO)
    {
        String id = userService.updateUsers(userUpdateDTO);
        return id;
    }
	
	@DeleteMapping(path = "/deleteuser/{id}")
    public String deleteUser(@PathVariable(value = "id") int id)
    {
        boolean deleteUser = userService.deleteUser(id);
        return "User Deleted";
    }
	
	@GetMapping(path="/login")
	public User getUserByEmail(@RequestParam String email) {
		
		User user = userService.getUserByEmail(email);
		return user;
	}
}
