package jobseekingbe.api.service.UserJobApplied;

import java.util.List;
import java.util.Optional;

import jobseekingbe.api.entity.UserJobApplied;

public interface UserJobAppliedService {
    public List<UserJobApplied> getUserJobApplieds(Long userID);
    public Optional<UserJobApplied> getUserJobApplied(Long id);
    public List<UserJobApplied> getListByJobId(Long id);
    public String addUserJobApplied(UserJobApplied userJobApplied);
    public String updateUserJobApplied(UserJobApplied userJobApplied);
    public String deleteUserJobApplied(Long id);
}
