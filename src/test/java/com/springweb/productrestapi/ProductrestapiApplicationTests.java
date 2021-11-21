package com.springweb.productrestapi;

import com.springweb.productrestapi.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductrestapiApplicationTests {

    @Test
    void testGetProduct() {
        RestTemplate template = new RestTemplate();
        Product product = template.getForObject("http://localhost:8080/productapi/products/2",Product.class);
        assertNotNull(product);
        assertEquals("macbook",product.getName());
    }

    @Test
    public void testCreateProduct(){
        RestTemplate template = new RestTemplate();
        Product product = new Product();
        product.setName("Techno");
        product.setDescription("Spark 12");
        product.setPrice(1200);

        Product newProduct = template.postForObject("http://localhost:8080/productapi/products/",product,Product.class);
        assertNotNull(newProduct);
        assertNotNull(newProduct.getId());
        assertEquals("Techno",newProduct.getName());

    }

    @Test
    void testUpdateProduct() {
        RestTemplate template = new RestTemplate();
        Product product = template.getForObject("http://localhost:8080/productapi/products/2",Product.class);
        product.setPrice(3400);
        template.put("http://localhost:8080/productapi/products/",product);

        assertEquals(3400,product.getPrice());
    }

}
