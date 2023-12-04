package com.mathquiz.tomatofunmathquiz.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@Table(name = "signup1")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})

public class User {
    @Id
    @Column(name = "user_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name = "user_name", length = 255, nullable = false)
    private String userName;

    @Column(name = "user_email", length = 255, nullable = false)
    private String email;

    @Column(name = "user_game_name", length = 16, nullable = false)
    private String userGameName;

    @Column(name = "user_password", length = 45, nullable = false)
    private String userPassword;

    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserGameName() {
        return userGameName;
    }

    public void setUserGameName(String userGameName) {
        this.userGameName = userGameName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public User(String userName, String email, String userGameName, String userPassword) {
        this.userName = userName;
        this.email = email;
        this.userGameName = userGameName;
        this.userPassword = userPassword;
    }
}

