package jobseekingbe.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jobseekingbe.api.entity.UserJobApplied;
import jobseekingbe.api.service.UserJobApplied.UserJobAppliedService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/userJobApplied")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)

public class UserJobAppliedController {
    @Autowired
    private UserJobAppliedService userJobAppliedService;

    @GetMapping("/getListByUserId/{id}")
    public ResponseEntity<List<UserJobApplied>> getListAppliedJobs(@PathVariable Long id) {
        return ResponseEntity.ok(userJobAppliedService.getUserJobApplieds(id));
    }
    @GetMapping("/getListByJobId/{id}")
    public ResponseEntity<List<UserJobApplied>> getListByJobId(@PathVariable Long id) {
        return ResponseEntity.ok(userJobAppliedService.getListByJobId(id));
    }
    
    @PostMapping("/add")
    public ResponseEntity<String> postMethodName(@RequestBody UserJobApplied entity) {
        return ResponseEntity.ok(userJobAppliedService.addUserJobApplied(entity));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> postMethodName(@PathVariable Long id) {
        return ResponseEntity.ok(userJobAppliedService.deleteUserJobApplied(id));
    }
    
    
}
