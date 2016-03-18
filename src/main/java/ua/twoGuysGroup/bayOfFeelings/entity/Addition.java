package ua.twoGuysGroup.bayOfFeelings.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Addition {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] data;

    public Addition() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
