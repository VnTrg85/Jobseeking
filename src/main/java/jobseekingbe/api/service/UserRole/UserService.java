package jobseekingbe.api.service.UserRole;

import jobseekingbe.api.entity.User;

public interface UserService {
	 void registerUser(User user);
	 User findByUsername(String username);
}
