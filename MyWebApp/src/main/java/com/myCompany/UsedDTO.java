package com.myCompany;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "EmpDetails")
public class UsedDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length =45)
    private String email;

    @Column(nullable = false, length = 15)
    private String password;

    @Column(nullable = false, length = 45, name = "first_name")
    private String firstName;

    @Column(nullable = false, length = 45, name = "last_name")
    private String lastName;

    private boolean enabled;
}
