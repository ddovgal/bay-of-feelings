package ua.twoGuysGroup.bayOfFeelings.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Commentary {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(columnDefinition = "LONGTEXT")
    private String text;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;

    private int ratio;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Commentary parent;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "commentary_additions",
            joinColumns = @JoinColumn(name = "commentary_id"),
            inverseJoinColumns = @JoinColumn(name = "addition_id")
    )
    private Set<Addition> additions = new HashSet<>();

    private boolean isVisibleOnlyForAuthor;

    public Commentary() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public int getRatio() {
        return ratio;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Commentary getParent() {
        return parent;
    }

    public void setParent(Commentary parent) {
        this.parent = parent;
    }

    public Set<Addition> getAdditions() {
        return additions;
    }

    public void setAdditions(Set<Addition> additions) {
        this.additions = additions;
    }

    public boolean isVisibleOnlyForAuthor() {
        return isVisibleOnlyForAuthor;
    }

    public void setVisibleOnlyForAuthor(boolean visibleOnlyForAuthor) {
        isVisibleOnlyForAuthor = visibleOnlyForAuthor;
    }
}
