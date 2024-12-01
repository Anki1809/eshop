package com.eshop.productservice.dao;

import com.eshop.productservice.entity.ProductCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;

public interface ProductCategoriesRepository extends JpaRepository<ProductCategories, Long> {
  //  Optional<ProductCategories> findByCategoryNameIgnoreCase(String CategoryName);
/*

    List<ProductCategories> findByCategoryNameAndSubCategoryNameAllIgnoreCase(@Nullable java.lang.String CategoryName, @Nullable java.lang.String subCategoryName);
*/

    boolean existsByName(String name);

    List<ProductCategories> findByNameIgnoreCaseAndSubNameIgnoreCase(String name, String subName);

    boolean existsByProductCategoryId(Long productCategoryId);
}