package com.matrix.freshmarket.service;

import com.matrix.freshmarket.entity.ProductEntity;
import com.matrix.freshmarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService{
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntity> findNotNulltop4(){
        List<ProductEntity> products=
                productRepository.findNotNulltop4();
        return products;
    }




    public List<ProductEntity> findtop8(){
        List<ProductEntity> products=
                productRepository.findbytop8();
        return products;
    }





    public Page<ProductEntity> getProduct(Integer page,String direction,String property,String sort){


        if(property.equals("food")){
       if (sort.equals("Name A-Z")){
           return productRepository.findFood(PageRequest.of(page, 8, Sort.by("product_name").descending()));
       }else if (sort.equals("Name Z-A")){
                return productRepository.findFood(PageRequest.of(page, 8,Sort.by("product_name").descending()));
            }
            return productRepository.findFood(PageRequest.of(page, 8,Sort.by("product_name").descending()));
       } else  if(property.equals("drink")){
            if (sort.equals("Name A-Z")){
                return productRepository.findDrink(PageRequest.of(page, 8, Sort.by("product_name").descending()));
            }else if (sort.equals("Name Z-A")){
                return productRepository.findDrink(PageRequest.of(page, 8,Sort.by("product_name").descending()));
            }
            return productRepository.findDrink(PageRequest.of(page, 8,Sort.by("product_name").descending()));
        }else  if(property.equals("personalCare")){
            if (sort.equals("Name A-Z")){
                return productRepository.findPersonalCare(PageRequest.of(page, 8, Sort.by("product_name").descending()));
            }else if (sort.equals("Name Z-A")){
                return productRepository.findPersonalCare(PageRequest.of(page, 8,Sort.by("product_name").descending()));
            }
            return productRepository.findPersonalCare(PageRequest.of(page, 8,Sort.by("product_name").descending()));
        }else  if(property.equals("cleaningSupplies")){
            if (sort.equals("Name A-Z")){
                return productRepository.findCleaningSupplies(PageRequest.of(page, 8, Sort.by("product_name").descending()));
            }else if (sort.equals("Name Z-A")){
                return productRepository.findCleaningSupplies(PageRequest.of(page, 8,Sort.by("product_name").descending()));
            }
            return productRepository.findCleaningSupplies(PageRequest.of(page, 8,Sort.by("product_name").descending()));
        }


        return productRepository.findAll(PageRequest.of(page, 8));

    }


   public Page<ProductEntity> getProducts(Integer page,String min,String max){

       String first=min.substring(1);
       String second=max.substring(1);
       return  productRepository.findPrice(PageRequest.of(page, 8),first,second);
   }



    public Page<ProductEntity> getFood(Pageable pageable){

        return productRepository.findFood(pageable);
    }



    public void saveProduct (ProductEntity productEntity) {
        productRepository.save(productEntity);
    }


}
