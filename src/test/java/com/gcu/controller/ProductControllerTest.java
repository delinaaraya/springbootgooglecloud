package com.gcu.controller;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.support.BindingAwareModelMap;

import com.gcu.Cst339MilestoneApplication;
import com.gcu.model.*;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.gcu.controller.*;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.*;
*/

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Cst339MilestoneApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {
    Model m = new BindingAwareModelMap();
    ProductController c = new ProductController();
    //ProductModel pm = new ProductModel();
    //String returnedString;
    //BeanPropertyBindingResult br = new BeanPropertyBindingResult(pm, "productModel");

    //Test case for display
    @Test
    public void testdisplay() throws Exception {
    	//m.addAttribute("title", "Test Case New Product");
    	//m.addAttribute("productModel", pm);
    	String returnedString = "newproduct";
    	assertEquals(c.display(m), "newproduct");
    	assertEquals(c.display(m), returnedString);
    }
    
    //Attempted test cases that are commented out due to no solution to be found.
    /*
	private RestTemplateBuilder rstBuild = new RestTemplateBuilder();
	
    @Autowired
    private TestRestTemplate testrestTemplate = new TestRestTemplate(rstBuild.messageConverters(convertToJson()));

    private HttpHeaders headers = new HttpHeaders();
    private String siteuri;
    
    private List<HttpMessageConverter<?>> convertToJson() {
    	List<HttpMessageConverter<?>> converters = new ArrayList<>();
    	converters.add(new MappingJackson2HttpMessageConverter());
    	return converters;
    }
    */
    /*
    //Test case for doCreateProduct
    @Test
    public void testcreate() throws Exception {
    	siteuri = "/product/doCreateProduct";
    	ProductModel newResource = new ProductModel(105, "Test Case Product", 175, "Test Case Description");
    	headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    	HttpEntity<ProductModel> entity = new HttpEntity<>(newResource, headers);
    	ResponseEntity<ProductModel> productResponse = testrestTemplate.exchange(siteuri,
    			HttpMethod.POST, entity, ProductModel.class);
    	//
        ResponseEntity<ProductModel> productResponse = testrestTemplate.withBasicAuth("root", "root").
        		postForEntity("/product/doCreateProduct", 
                new ProductModel(105, "Test Case Product", 175, "Test Case Description"), 
                ProductModel.class);
        //
    	ProductModel assertedResponse = productResponse.getBody();
    	assertEquals(newResource.getId(), assertedResponse.getId());
    	//assertThat(productResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }
    */
    /*
    //Unit test for showProducts
    @Test
    public void testreadall() throws Exception {
    	//
    	siteuri = "/product/products";
    	headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    	HttpEntity<String> entity = new HttpEntity<String>(headers);
    	//
    	ResponseEntity<ProductModel> productResponse = testrestTemplate.withBasicAuth("root", "root").
        		getForEntity("/product/products", ProductModel.class);
    	//
    	ResponseEntity<ProductModel> productResponse = testrestTemplate.exchange(siteuri,
    			HttpMethod.GET, entity, ProductModel.class);
    	ProductModel productResource = productResponse.getBody();
        //assertThat(productResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
    	assertThat(productResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    */
}