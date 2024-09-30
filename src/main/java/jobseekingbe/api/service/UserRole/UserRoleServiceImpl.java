package jobseekingbe.api.service.UserRole;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jobseekingbe.api.entity.UserRole;
import jobseekingbe.api.repository.UserRoleRepository;

@Service
public class UserRoleServiceImpl implements UserRoleService{
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> getUserRoles() {
        return  userRoleRepository.findAll();
    }

    @Override
    public void setUserRole(UserRole userRole) {
        userRoleRepository.save(userRole);
    }

    @Override
    public void updateUserRole(UserRole userRole) {
        userRoleRepository.save(userRole);
        }

    @Override
    public void deleteUserRole(Long userRoleId) {
        userRoleRepository.deleteById(userRoleId);
    }

}
