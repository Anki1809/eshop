package com.eshop.shopservice.dao;

import com.eshop.shopservice.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface ShopRepository extends JpaRepository<Shop, Long> {

    List<Shop> findByOwnerId(@NonNull String ownerId);

    @Transactional
    @Modifying
    @Query("update Shop s set s.active = ?1 where s.shopId = ?2")
    int updateActiveByShopId(boolean active, Long shopId);

    List<Shop> findByActive(boolean active);

    Boolean existsByOwnerId(String ownerId);

    @Query("select s.ownerId from Shop s where s.shopId = ?1")
    Optional<String> getOwnerIdByShopId(Long shopId);

    boolean existsByOwnerIdAndShopId(String ownerId, Long shopId);
}