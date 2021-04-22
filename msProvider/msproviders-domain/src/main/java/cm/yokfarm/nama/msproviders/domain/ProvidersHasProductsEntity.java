package cm.yokfarm.nama.msproviders.domain;

import cm.yokfarm.nama.msproviders.domain.beans.HistoricalJson;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.apache.commons.lang.Validate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Providers has products Entity
 *
 * @author Meudje
 */
@Entity(name = "ProvidersHasProductsEntity")
@Table(name = "providers_has_products")
@Data
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class ProvidersHasProductsEntity implements Serializable, Persistable<Long> {

    @Id
    @Column(nullable = false, name = "providersHasProductsId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long providersHasProductsId;

    @Column(name = "verification_date", nullable = false)
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @PastOrPresent
    private Date verificationDate;

    @Column(name = "in_stock", nullable = false)
    private Boolean inStock;

    @Column(name = "price", nullable = false)
    @Min(1)
    private Long price;

    @Type(type = "jsonb")
    @Column(name = "historical", columnDefinition = "jsonb")
    private List<HistoricalJson> historical;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "providersId", nullable = false)
    private ProvidersEntity providersId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productsId", nullable = false)
    private ProductsEntity productsId;

    @Override
    public Long getId() {
        return providersHasProductsId;
    }

    @Override
    public boolean isNew() {
        return providersHasProductsId == null;
    }

    @PrePersist
    @PreUpdate
    protected void prePersistAndPreUpdate() {
        Validate.notNull(providersId, "providersId into Entity must not be null");
        Validate.notNull(productsId, "productsId into Entity must not be null");
        HistoricalJson hist = new HistoricalJson(inStock, price, verificationDate);
        historical.add(hist);
    }
}