package bg.softuni.mobile.model.entity;

import bg.softuni.mobile.model.enums.EngineEnum;
import bg.softuni.mobile.model.enums.TransmissionEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "offers")
public class OfferEntity{

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private UUID id;

    @Column
    private String text;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private EngineEnum engine;

    @Column
    private String imageUrl;

    @Column
    private int mileage;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TransmissionEnum transmission;

    @Column
    private int year;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    private ModelEntity model;

    @ManyToOne
    private UserEntity seller;

    public OfferEntity() {
    }

    public UUID getId() {
        return id;
    }

    public OfferEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferEntity setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;

    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferEntity setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferEntity setYear(int year) {
        this.year = year;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public ModelEntity getModel() {
        return model;
    }

    public void setModel(ModelEntity model) {
        this.model = model;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public void setSeller(UserEntity seller) {
        this.seller = seller;
    }

    public String getDescription() {
        return description;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "OfferEntity{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", engine=" + engine +
                ", imageUrl='" + imageUrl + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmission=" + transmission +
                ", year=" + year +
                ", created=" + created +
                ", modified=" + modified +
                ", description='" + description + '\'' +
                ", model=" + model +
                ", seller=" + seller +
                '}';
    }
}
