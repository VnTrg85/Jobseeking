package jobseekingbe.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jobseekingbe.api.entity.JobStatus;
import jobseekingbe.api.entity.UserRole;
import jobseekingbe.api.service.JobStatus.JobStatusService;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/jobStatus")
public class JobStatusController {
    @Autowired
    private JobStatusService jobStatusService;

    @PostMapping("/add")
    public ResponseEntity<String> addJobStatus(@RequestBody JobStatus jobStatus) {
        return ResponseEntity.ok(jobStatusService.addJobStatus(jobStatus));
    }
    
    @GetMapping("/getAll")
    @JsonManagedReference
     public ResponseEntity<List<JobStatus>> getJobStatuss() {
        return ResponseEntity.ok(jobStatusService.getJobStatus());
    }
}
