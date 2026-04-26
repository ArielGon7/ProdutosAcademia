package com.devari.produtos_academia.Service;

import com.devari.produtos_academia.Entity.ProductEntity;
import com.devari.produtos_academia.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductEntity> findAll(){
        return productRepository.findAll();
    }

    public Optional<ProductEntity> findById(Long id){
        return productRepository.findById(id);
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
