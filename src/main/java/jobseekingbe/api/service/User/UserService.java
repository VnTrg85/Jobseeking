package jobseekingbe.api.service.User;

import java.util.List;

import jobseekingbe.api.entity.User;

public interface UserService {
    public List<User> getUsers();
    public User getUser(Long id);
    public String addUser(User user);
    public String updateUser(User user);
    public String deleteUser(Long id);
}
