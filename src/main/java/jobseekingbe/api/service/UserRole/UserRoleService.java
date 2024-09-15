package jobseekingbe.api.service.UserRole;

import java.util.List;

import jobseekingbe.api.entity.UserRole;

public interface UserRoleService {
    public List<UserRole> getUserRoles();
    public void setUserRole(UserRole userRole);
    public void updateUserRole(UserRole userRole);
    public void deleteUserRole(Long userRoleId);
}
