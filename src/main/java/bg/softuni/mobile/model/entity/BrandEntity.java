package bg.softuni.mobile.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String name;

    @Column()
    private LocalDate created;

    @Column
    private LocalDate modified;

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ModelEntity> models = new ArrayList<>();

    public BrandEntity() {
    }

    public String getName() {
        return name;
    }

    public BrandEntity setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public BrandEntity setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public LocalDate getModified() {
        return modified;
    }

    public BrandEntity setModified(LocalDate modified) {
        this.modified = modified;
        return this;
    }

    public List<ModelEntity> getModels() {
        return models;
    }

    public BrandEntity setModels(List<ModelEntity> models) {
        this.models = models;
        return this;
    }

    @Override
    public String toString() {
        return "BrandEntity{" +
                "name='" + name + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                ", models=" + models +
                '}';
    }
}
