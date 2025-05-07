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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import tech.wenisch.extuserservice.pojo.RegistrationLink;
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
	@Operation(summary = "Create a new user", description = "This endpoint creates a new user and returns a registration link.")
	@ApiResponse(responseCode = "200", description = "User created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RegistrationLink.class)))
	@ApiResponse(responseCode = "400", description = "Invalid user data provided")
	@ApiResponse(responseCode = "500", description = "Internal server error")
 ResponseEntity<Object> createUser(@RequestBody(required = true)  User user, HttpServletRequest request) 
	{
		try {
			RegistrationLink link = userservice.createPendingUser(user);
			return new ResponseEntity<>(link, HttpStatus.OK);
		}

		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}

}
