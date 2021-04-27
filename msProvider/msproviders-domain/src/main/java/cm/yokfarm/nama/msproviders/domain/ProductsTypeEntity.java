package cm.yokfarm.nama.msproviders.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Products Type
 *
 * @author Meudje
 */
@Entity(name = "ProdutcsTypeEntity")
@Table(name = "products_type")
public class ProductsTypeEntity implements Serializable, Persistable<Long> {

    @Id
    @Column(nullable = false, name = "products_type_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productsTypeId;

    @Column(name = "providers_name", length = 30, nullable = false)
    private String providersName;

    @OneToMany(mappedBy = "productsTypeId", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final List<ProductsEntity> productTypeList;

    public ProductsTypeEntity() {
        this.productTypeList = new ArrayList<>();
    }

    @Override
    public Long getId() {
        return productsTypeId;
    }

    @Override
    public boolean isNew() {
        return productsTypeId == null;
    }
}