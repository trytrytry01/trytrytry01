package com.emart.buyer.controller;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testAddCartItem_fail() throws Exception {

        Map<String, Object> map = new HashMap<>();
        String content = JSONObject.toJSONString(map);

        mvc.perform(post("/api/cart")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusCode").value("400"));


	}
	
	@Test
	public void testAddCartItem_success() throws Exception {

        Map<String, Object> map = new HashMap<>();
        map.put("buyerId", 1);
        map.put("itemId", 1);
        map.put("categoryId", 1);
        map.put("numberOfItems", 2);
        String content = JSONObject.toJSONString(map);

        mvc.perform(post("/api/cart")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andDo(print())
                .andExpect(status().isOk());
	}	
	
	@Test
	public void testCheckoutItems() throws Exception {

        Map<String, Object> map = new HashMap<>();
        List list = new ArrayList();
        
        map.put("id", 1);
        map.put("buyerId", 3);
        map.put("itemId", 1);
        map.put("numberOfItems", 5);
        
        list.add(map);
        
        map = new HashMap<>();        
        map.put("id", 4);
        map.put("buyerId", 3);
        map.put("itemId", 1);
        map.put("numberOfItems", 5);
        list.add(map);
        
        String content = JSONArray.toJSONString(list);

        mvc.perform(put("/api/cart/checkout/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andDo(print())
                .andExpect(status().isOk());

	}
	
	@Test
	public void testViewcartItems() throws Exception {
		
		this.mvc.perform(get("/api/cart/1")).andExpect(status().isOk())
		                .andReturn().getResponse().getContentAsString();;
	}
	
	@Test
	public void testDeletecartItems() throws Exception {
		
		this.mvc.perform(delete("/api/cart/6")).andExpect(status().isOk())
		                .andReturn().getResponse().getContentAsString();;
	}
	

}
