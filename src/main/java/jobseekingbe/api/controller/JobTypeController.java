package jobseekingbe.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jobseekingbe.api.entity.JobType;
import jobseekingbe.api.service.JobType.JobTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/jobtypes")
@CrossOrigin(origins = "http://localhost:3000")
public class JobTypeController {
    
    @Autowired
    private JobTypeService jobTypeService;

    @GetMapping
    public ResponseEntity<List<JobType>> getAllJobTypes() {
        List<JobType> jobTypes = jobTypeService.getAllJobTypes();
        return new ResponseEntity<>(jobTypes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<JobType> createJobType(@RequestBody JobType jobType) {
        JobType creaJobType = jobTypeService.saveJobType(jobType);
        return new ResponseEntity<>(creaJobType,HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<JobType> updateJobType(@PathVariable Long id, @RequestBody JobType jobType) {
        jobTypeService.updateJobType(id, jobType);
        return new ResponseEntity<>(jobType, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobType(@PathVariable Long id) {
        jobTypeService.deleteJobType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
