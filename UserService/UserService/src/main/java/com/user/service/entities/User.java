package com.user.service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "micro_users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @Column(name ="ID")
    private String userId;

    @Column(name = "NAME", length = 30)
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ABOUT")
    private String about;

    @Column(name = "DOB")
    private LocalDate dob;

    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
