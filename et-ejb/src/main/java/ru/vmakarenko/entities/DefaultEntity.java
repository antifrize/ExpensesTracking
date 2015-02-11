package ru.vmakarenko.entities;

import javax.persistence.*;

/**
 * Created by VMakarenko on 2/4/15.
 */
@MappedSuperclass
public class DefaultEntity {
    @Id
    @SequenceGenerator(name = "id_seq_gen", sequenceName = "default_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq_gen")
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
