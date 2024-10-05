package jobseekingbe.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jobseekingbe.api.entity.UserRole;
import jobseekingbe.api.service.UserRole.UserRoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "http://localhost:3000")
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    @GetMapping
    public ResponseEntity<List<UserRole>> getUserRole() {
        return new ResponseEntity<>(userRoleService.getUserRoles(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserRole> createUserRole(@RequestBody UserRole userRole) {
        userRoleService.setUserRole(userRole);
        return new ResponseEntity<>(userRole, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UserRole> updateUserRole(@PathVariable Long id, @RequestBody UserRole userRole) {
        userRole.setId(id);
        userRoleService.updateUserRole(userRole);;
        return new ResponseEntity<>(userRole,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserRole(@PathVariable Long id){
        userRoleService.deleteUserRole(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } 
}
