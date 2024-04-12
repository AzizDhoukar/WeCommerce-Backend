package org.example.wecommerce.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    private String eMail;

    @Column(nullable = false)
    private Date userCreateDate;

    @OneToOne
    private Cart cart;

    public User(String userName, String password, String eMail, Date userCreateDate) {
        this.userName = userName;
        this.password = password;
        this.eMail = eMail;
        this.userCreateDate = userCreateDate;
    }
}