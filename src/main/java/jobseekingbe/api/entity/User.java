package jobseekingbe.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Getter
    @Setter
    private String Name;
    @Getter
    @Setter
    private String Email;
    @Getter
    @Setter
    private String Phone;
    @Getter
    @Setter
    private String Password;
    @ManyToOne
    @JoinColumn(name = "RoleId")
    @Getter
    @Setter
    private UserRole userRole;
    @OneToOne(mappedBy = "userEmployee")
    @Getter
    @Setter
    private Employee employee;    
    @OneToOne(mappedBy = "userCompany")
    @Getter
    @Setter
    private Company company;  
}
