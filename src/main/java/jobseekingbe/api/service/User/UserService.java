package jobseekingbe.api.service.User;

import jobseekingbe.api.entity.User;
import jobseekingbe.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void setUser(User user) {
        userRepository.save(user);
    }
}
