package jobseekingbe.api.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Name;
    public Long getId() {
        return this.Id;
    }
    public void setId(Long id) {
        this.Id = id;
    }
    public String getName() {
        return this.Name;
    }
    public void setName(String name) {
        this.Name = name;
    }
    @OneToMany(mappedBy = "userRole")
    @JsonIgnore
    private List<User> users = new ArrayList<User>();
    
}
