package ua.twoGuysGroup.bayOfFeelings.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String login;
    @NotNull
    private String password;
    @NotNull
    private String email;

    @JsonIgnore
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] avatar;

    @ManyToMany
    @JoinTable(
            name = "fav_posts",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id")
    )
    private Set<Post> favouritePosts = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "subscribers",
            joinColumns = @JoinColumn(name = "authority_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id")
    )
    private Set<User> subscribers = new HashSet<>();

    @ManyToMany(mappedBy = "subscribers")
    private Set<User> favouriteUsers = new HashSet<>();

    private int ratio;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  //todo check if correct format
    @NotNull
    private Date registrationDate;

    //---------------------------------------------------------------------------------

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public Set<Post> getFavouritePosts() {
        return favouritePosts;
    }

    public void setFavouritePosts(Set<Post> favouritePosts) {
        this.favouritePosts = favouritePosts;
    }

    public Set<User> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<User> subscribers) {
        this.subscribers = subscribers;
    }

    public Set<User> getFavouriteUsers() {
        return favouriteUsers;
    }

    public void setFavouriteUsers(Set<User> favouriteUsers) {
        this.favouriteUsers = favouriteUsers;
    }

    public int getRatio() {
        return ratio;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
