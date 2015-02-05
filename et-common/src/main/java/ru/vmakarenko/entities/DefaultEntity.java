package ru.vmakarenko.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Created by VMakarenko on 2/4/15.
 */
public class DefaultEntity {
    @Id
    @Column(name="id")
    private Long id;
    @Version
    @Column(name="version")
    private Long version;


    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
