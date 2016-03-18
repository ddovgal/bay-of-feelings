package ua.twoGuysGroup.bayOfFeelings.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class NotificationType {

    @Id
    @NotNull
    private String type;

    public NotificationType() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
