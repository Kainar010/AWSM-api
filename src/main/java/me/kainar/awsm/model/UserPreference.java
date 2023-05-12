package me.kainar.awsm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users_preference")
public class UserPreference {
    @Id
    @Column(name = "user_id")
    private Long id;

    @Column(name = "is_private")
    private Boolean is_private;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    public UserPreference(){

    }

    public UserPreference(User user){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIs_private() {
        return is_private;
    }

    public void setIs_private(Boolean is_private) {
        this.is_private = is_private;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
