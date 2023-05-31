package com.nada.spring.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="student")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="first_name")
    String firstName;
    @Column(name="last_name")
    String lastName;
    @Column(name="email")
    String email;
}
