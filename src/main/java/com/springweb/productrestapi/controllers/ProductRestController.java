package com.springweb.productrestapi.controllers;

import com.springweb.productrestapi.entities.Product;
import com.springweb.productrestapi.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    ProductRepo productRepo;

    //fetch all pproducts
    @RequestMapping(value = "/products/",method = RequestMethod.GET)
    public List<Product> getProducts(){
        return productRepo.findAll();
    }

    //fetch a single product
    @RequestMapping(value = "/products/{id}",method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") int id){ //@PathVariable binds the id in the @RequestMapping to the id in the getProduct param
        return productRepo.findById(id).get();
    }

    //save product to the database
    @RequestMapping(value = "/products/",method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product){ //binds what ever comes in the request to the object
        return productRepo.save(product);
    }

    //update a  product in the database
    @RequestMapping(value = "/products/",method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product){ //binds what ever comes in the request to the object
        return productRepo.save(product);
    }

    //fetch a single product
    @RequestMapping(value = "/products/{id}",method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") int id){ //@PathVariable binds the id in the @RequestMapping to the id in the deleteProduct param
        productRepo.deleteById(id);
    }


}
