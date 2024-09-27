package jobseekingbe.api.entity;

import jakarta.persistence.Column;
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
    @Column(nullable = false,unique = true)
    private String Name;

    @Getter
    @Setter
    @Column(name = "Email", unique = true)
    private String Email;

    @Getter
    @Setter
    private String Phone;

    @Getter
    @Setter
    @Column(nullable = false)
    private String Password;

    @ManyToOne
    @JoinColumn(name = "RoleId")
    @Getter
    @Setter
    private UserRole userRole;
    
    @OneToOne(mappedBy = "userEmployee")
    @Getter
    @Setter
    @JsonIgnore
    private Employee employee;    
    
    @OneToOne(mappedBy = "userCompany")
    @Getter
    @Setter
    @JsonIgnore
    private Company company;  
    
}
