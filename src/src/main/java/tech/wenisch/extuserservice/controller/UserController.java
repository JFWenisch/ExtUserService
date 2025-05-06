package tech.wenisch.extuserservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import tech.wenisch.extuserservice.pojo.User;
import tech.wenisch.extuserservice.service.UserManagementService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired private UserManagementService userservice;

	@PutMapping("/{email}/")
	public  ResponseEntity <String> updateUser(@PathVariable("email") String email,  @RequestBody User user, HttpServletRequest request)
	{ 
		try {
			userservice.updateUser(user);
			return new ResponseEntity<>("true", HttpStatus.OK);
		}

		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@DeleteMapping("/{email}/")
	public  ResponseEntity <String> deleteUser(@PathVariable("email") String email,  @RequestBody User user, HttpServletRequest request)
	{ 
		try {
			userservice.deleteUser(user);
			return new ResponseEntity<>("true", HttpStatus.OK);
		}

		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@PostMapping
	public ResponseEntity<String> install(@RequestBody(required = true)  User user, HttpServletRequest request) 
	{
		try {
			userservice.createUser(user);
			return new ResponseEntity<>("true", HttpStatus.OK);
		}

		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}

}
