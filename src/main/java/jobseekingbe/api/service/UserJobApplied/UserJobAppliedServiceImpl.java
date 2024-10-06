package jobseekingbe.api.service.UserJobApplied;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jobseekingbe.api.entity.UserJobApplied;
import jobseekingbe.api.repository.UserJobAppliedRepository;

@Service
public class UserJobAppliedServiceImpl implements UserJobAppliedService{
    @Autowired
    private UserJobAppliedRepository userJobAppliedRepository;
    @Override
    public List<UserJobApplied> getUserJobApplieds(Long userID) {  
        List<UserJobApplied> userJobApplieds = userJobAppliedRepository.findAll();
        List<UserJobApplied> res = new ArrayList<UserJobApplied>();

        for (UserJobApplied userJobApplied : userJobApplieds) {
            if (userJobApplied.getUser().getId() == userID) {
                res.add(userJobApplied);
            }
        }
        return res;
    }

    @Override
    public Optional<UserJobApplied> getUserJobApplied(Long id) {
        
        return userJobAppliedRepository.findById(id);
    }

    @Override
    public String addUserJobApplied(UserJobApplied userJobApplied) {
        try {
            userJobAppliedRepository.save(userJobApplied);
            return "Added";
        } catch (Exception e) {
            return "Failed to add userJobApplied";
        }
    }

    @Override
    public String updateUserJobApplied(UserJobApplied userJobApplied) {
        try {
            userJobAppliedRepository.save(userJobApplied);
            return "Updated";
        } catch (Exception e) {
            return "Failed to update userJobApplied";
        }
    }

    @Override
    public String deleteUserJobApplied(Long id) {
        try {
            userJobAppliedRepository.deleteById(id);
            return "Deleted";
        } catch (Exception e) {
            return "Failed to delete userJobApplied";
        }
    }

    @Override
    public List<UserJobApplied> getListByJobId(Long id) { 
        List<UserJobApplied> userJobApplieds = userJobAppliedRepository.findAll();
        List<UserJobApplied> res = new ArrayList<UserJobApplied>();
        for (UserJobApplied userJobApplied : userJobApplieds) {
            if (userJobApplied.getJob().getId() == id) {
                res.add(userJobApplied);
            }
        }
        return res;
    }

}
