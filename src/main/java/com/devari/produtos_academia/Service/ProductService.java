package com.devari.produtos_academia.Service;

import com.devari.produtos_academia.Entity.ProductEntity;
import com.devari.produtos_academia.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductEntity> findAll(){
        return productRepository.findAll();
    }

    public ProductEntity save(ProductEntity productEntity){
        return productRepository.save(productEntity);
    }

    public void deleteById(Long id) {
        if (!productRepository.existsById(id)){
            throw new RuntimeException("id not found");
        }
        productRepository.deleteById(id);
    }

    public ProductEntity upload(Long id, ProductEntity productEntity){
        ProductEntity productDb = productRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));

        productDb.setName(productEntity.getName());
        productDb.setPrice(productEntity.getPrice());
        productDb.setWeight(productEntity.getWeight());

        return productRepository.save(productDb);

    }

}
