package ua.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.entity.Product;
import ua.com.entity.User;

public interface ProductDao  extends JpaRepository<Product, Integer> {
    Product findByNameProduct(String product);

    @Query(value = "select * from product join lot l on product.id_Product = l.product_id_Product where id_Lot=:idLot", nativeQuery = true)
    Product findProductByLot_Id(@Param("idLot") int lot);

    @Query(value = "select * from product join imagelink i on product.id_Product = i.product_id_Product where id_ImageLink=:idImg", nativeQuery = true)
    Product findProductByImageLinks_Id(@Param("idImg") int idImgLink);

    @Query(value = "select * from product join user p on product.id_Product = p.product_id_Product where userId=:idUser",nativeQuery = true)
    User findProductByUserOwnerId(@Param("idUser") int userId);

}
