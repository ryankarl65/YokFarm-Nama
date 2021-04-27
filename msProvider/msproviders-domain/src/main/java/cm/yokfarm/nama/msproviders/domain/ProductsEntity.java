package cm.yokfarm.nama.msproviders.domain;

import org.apache.commons.lang.Validate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Products Entity
 *
 * @author Meudje
 */
@Entity(name = "ProductsEntity")
@Table(name = "products")
public class ProductsEntity implements Serializable, Persistable<Long> {

    @Id
    @Column(nullable = false, name = "products_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productsId;

    @Column(name = "products_created_at", nullable = false, updatable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date productsCreatedAt;

    @Column(name = "products_updated_at", nullable = false)
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date producstUpdatedAt;

    @Column(name = "products_name", length = 30, nullable = false)
    private String producstName;

    @Column(name = "products_characteristic")
    private String productscharacteristic;

    @Column(name = "products_description")
    private String productsDescription;

    @Column(name = "products_picture_name", length = 20)
    private String productsPictureName;

    @OneToMany(mappedBy = "productsId", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final List<ProvidersHasProductsEntity> productsList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productsTypeId", nullable = false)
    private ProductsTypeEntity productsTypeId;

    public ProductsEntity() {
        this.productsList = new ArrayList<>();
    }

    @Override
    public Long getId() {
        return productsId;
    }

    @Override
    public boolean isNew() {
        return productsId == null;
    }

    @PrePersist
    @PreUpdate
    protected void prePersistAndPreUpdate() {
        Validate.notNull(productsTypeId, "productsTypeId into Entity must not be null");
    }
}