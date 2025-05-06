package tech.wenisch.extuserservice.service;

import org.springframework.stereotype.Service;

import tech.wenisch.extuserservice.pojo.User;

@Service
public class UserManagementService 
{

	public void createUser(User user) 
	{
		System.out.println("Creating user"+ user.getEmail());
	}
	public void deleteUser(User user) 
	{
		System.out.println("Deleting user"+ user.getEmail());
	}
	public void updateUser(User user) {
		System.out.println("Updating user"+ user.getEmail());
		
	}

}
