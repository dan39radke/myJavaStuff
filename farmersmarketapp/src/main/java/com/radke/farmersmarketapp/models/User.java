package com.radke.farmersmarketapp.models;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Column
    @Id
    @Type(type = "pg-uuid")
    private UUID user_id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToMany(cascade =  CascadeType.ALL , fetch = FetchType.EAGER )
    @JoinTable(
            name = "users_farmersmarkets",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "fmid") }
    )
    private Set<FarmersMarket> favorites = new HashSet<>();

    public User(){
        this.user_id = UUID.randomUUID();
    }

    public String getUsername() {
        return username;
    }

    public Set<FarmersMarket> getFavorites() {
        return favorites;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
