package com.devari.produtos_academia.Controller;

import com.devari.produtos_academia.Entity.ProductEntity;
import com.devari.produtos_academia.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class ProductController {
    public final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductEntity>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping
    public ResponseEntity<ProductEntity> save(@RequestBody ProductEntity productEntity){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> upload(@PathVariable Long id, @RequestBody ProductEntity productEntity){
        return ResponseEntity.ok(productService.upload(id, productEntity));
    }

}
