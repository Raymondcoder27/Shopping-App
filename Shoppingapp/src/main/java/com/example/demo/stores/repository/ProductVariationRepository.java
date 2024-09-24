package com.example.demo.stores.repository;

import com.example.demo.stores.entity.ProductVariation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductVariationRepository extends JpaRepository<ProductVariation, UUID> {
//    List<ProductVariation> findByProductId(UUID id);
}
