/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.yokfarm.nama.msproviders.repositories;

import cm.yokfarm.nama.msproviders.domain.ProductsTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("IProductsTypeRepository")
public interface IProductsTypeRepository extends JpaRepository<ProductsTypeEntity, Long>{
}