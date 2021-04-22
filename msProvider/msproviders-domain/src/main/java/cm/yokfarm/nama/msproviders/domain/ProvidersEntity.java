package cm.yokfarm.nama.msproviders.domain;

import com.vividsolutions.jts.geom.Point;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Providers Entity
 *
 * @author Meudje
 */
@Entity(name = "ProvidersEntity")
@Table(name = "providers")
@Data
public class ProvidersEntity implements Serializable, Persistable<Long> {

    @Id
    @Column(nullable = false, name = "providers_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long providersId;

    @Column(name = "providers_name", length = 30, nullable = false)
    private String providersName;

    @Column(name = "providers_created_at", nullable = false, updatable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date providersCreatedAt;

    @Column(name = "providers_updated_at", nullable = false)
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date providersUpdatedAt;

    @Column(name = "providers_email", length = 100)
    @Email
    private String providersEmail;

    @Column(name = "providers_phone", length = 20)
    private String providersPhone;

    //https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#spatial
    @Column(name = "providers_location", columnDefinition = "POINT")
    private Point providersLocation;

    @Column(name = "providers_pobox", length = 150)
    private String providersPobox;

    @Column(name = "providers_identification", length = 100)
    private String providersIdentification;

    @Column(name = "providers_description")
    private String providersDescription;

    @OneToMany(mappedBy = "providersId", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final List<ProvidersHasProductsEntity> providersList;

    public ProvidersEntity() {
        this.providersList = new ArrayList<>();
    }

    @Override
    public Long getId() {
        return providersId;
    }

    @Override
    public boolean isNew() {
        return providersId == null;
    }
}