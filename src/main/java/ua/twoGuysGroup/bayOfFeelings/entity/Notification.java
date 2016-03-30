package ua.twoGuysGroup.bayOfFeelings.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Notification {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "type_id")
    private NotificationType type;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    @NotNull
    @Column(columnDefinition = "MEDIUMTEXT")
    private String message;

    @ManyToOne
    @JoinColumn(name = "causePost_id")
    private Post causePost;

    @ManyToOne
    @JoinColumn(name = "causeCommentary_id")
    private Commentary causeCommentary;

    @ManyToOne
    @JoinColumn(name = "causeUser_id")
    private User causeUser;

    private boolean isRead;

    public Notification() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Post getCausePost() {
        return causePost;
    }

    public void setCausePost(Post causePost) {
        this.causePost = causePost;
    }

    public Commentary getCauseCommentary() {
        return causeCommentary;
    }

    public void setCauseCommentary(Commentary causeCommentary) {
        this.causeCommentary = causeCommentary;
    }

    public User getCauseUser() {
        return causeUser;
    }

    public void setCauseUser(User causeUser) {
        this.causeUser = causeUser;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
