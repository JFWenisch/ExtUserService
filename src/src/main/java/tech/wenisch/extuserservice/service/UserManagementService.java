package tech.wenisch.extuserservice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import tech.wenisch.extuserservice.Utils;
import tech.wenisch.extuserservice.pojo.RegistrationLink;
import tech.wenisch.extuserservice.pojo.User;

@Service
public class UserManagementService 
{

	public static Map<String, User> pendingRegistrations = new HashMap<String,User>();
	public RegistrationLink createPendingUser(User user) 
	{
		String hash = Utils.generateShortHash(user.getEmail());
		pendingRegistrations.put(hash, user);
		RegistrationLink link = new RegistrationLink();
		link.setLink("https://users.extranet.wenisch.tech/register/"+hash);
		return link;
	}
	public void deleteUser(User user) 
	{
		System.out.println("Deleting user"+ user.getEmail());
	}
	public void updateUser(User user) {
		System.out.println("Updating user"+ user.getEmail());

	}

}
