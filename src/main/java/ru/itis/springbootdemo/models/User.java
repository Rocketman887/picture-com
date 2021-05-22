package ru.itis.springbootdemo.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password", nullable = false)
    private String hashPassword;

    @Column(name = "profileImage")
    private String profileImagePath;

    @Column(columnDefinition = "boolean default false")
    private boolean mailProved;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    private String currentConfirmationCode;

    public enum State {
        ACTIVE,
        BANNED
    }

    public enum Role {
        USER,
        ADMIN,
        JOURNALIST
    }

    public boolean isMailProved(){
        return this.mailProved;
    }

    public boolean isActive() {
        return this.state == State.ACTIVE;
    }

    public boolean isBanned() {
        return this.state == State.BANNED;
    }

    public boolean isAdmin() {
        return this.role == Role.ADMIN;
    }

    public Role isUser() {
        return this.role = Role.USER;
    }
}
