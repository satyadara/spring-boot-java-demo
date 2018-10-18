package com.example.demospringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @Id
    @Column(name = "user_id",
            unique = true,
            length = 100)
    private String id;

    @Column(name = "user_name",
            length = 100)
    private String name;

    @Column(name = "user_address",
            length = 200)
    private String address;

    @JoinColumn(name = "user_role")
    @ManyToOne
    private Role role;
}
