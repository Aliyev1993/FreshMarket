package com.matrix.freshmarket.controller.Filter;

import com.matrix.freshmarket.entity.ProductEntity;
import com.matrix.freshmarket.entity.RangeSlider;
import com.matrix.freshmarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Controller
public class ShopProductController {


    private ProductService productService;

    @Autowired
    public ShopProductController(ProductService productService) {
        this.productService = productService;
    }

    List<ProductEntity> range;

    @RequestMapping(value = "/shop")
    public String shopPage(@RequestParam(name = "direction", defaultValue = "DESC") String direction,
                           @RequestParam(name = "property", defaultValue = "all") String property,
                           @RequestParam(name = "from_num", defaultValue = "0") String min,
                           @RequestParam(name = "to_num", defaultValue = "100") String max,

                           @RequestParam(value = "page",
                                   required = false,
                                   defaultValue = "0")
                                   Integer page,

                           Model model) {

        System.out.println(min);
        Page<ProductEntity> productPage =
                productService.getProduct(PageRequest.of(page, 8), direction, property, min, max);



        model.addAttribute("property", property);
        model.addAttribute("products", productPage);
        model.addAttribute("numbers", IntStream.range(0, productPage.getTotalPages()).toArray());


        return "FreshMarketShop-1";
    }





    @RequestMapping("/shop/filter")
    public List<ProductEntity> range(@RequestParam(name = "from_num") String min,
                        @RequestParam(name = "to_num") String max){

        List<ProductEntity> productSlider = productService.
        return productSlider;
    }


}
