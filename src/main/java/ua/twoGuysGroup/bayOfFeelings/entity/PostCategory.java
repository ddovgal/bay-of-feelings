package ua.twoGuysGroup.bayOfFeelings.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class PostCategory {

    @Id
    @NotNull
    private String category;

    public PostCategory() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
