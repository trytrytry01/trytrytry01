package com.emart.seller.controller;

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
public class ItemControllerTest {
	
	@Autowired
	private MockMvc mvc;

	@Test
	public void testAddItem_fail() throws Exception {

        Map<String, Object> map = new HashMap<>();
        String content = JSONObject.toJSONString(map);

//        mvc.perform(post("/items")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.statusCode").value("400"));

	}
	
	@Test
	public void testAddItem_success() throws Exception {

		Map<String, Object> map = new HashMap<>();
        map.put("itemName", "Oppo A 5S");
        map.put("sellerId",5);
        map.put("categoryId", 1);
        map.put("subcategoryId", 1);
        map.put("price", 1300);
        map.put("stockNumber", 200);
        map.put("description", "test");
        String content = JSONObject.toJSONString(map);

//        mvc.perform(post("/items")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.statusCode").value("200"));
	}	
	
	@Test
	public void testUpdateItems() throws Exception {

        Map<String, Object> map = new HashMap<>();
        List list = new ArrayList();
        
        map.put("id", 1);
        map.put("price", 1500);
        
        list.add(map);
        
        map = new HashMap<>();        
        map.put("id", 2);
        map.put("stockNumber", 280);
        list.add(map);
        
        String content = JSONArray.toJSONString(list);
//
//        mvc.perform(put("/items")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.statusCode").value("200"));

	}
	
	@Test
	public void testViewItems() throws Exception {
		
//		this.mvc.perform(get("/items?sellerId=5"))
//						.andExpect(status().isOk())
//		                .andReturn().getResponse().getContentAsString();;
	}
	
	@Test
	public void testDeletecartItems() throws Exception {
		
        Map<String, Object> map = new HashMap<>();
        List list = new ArrayList();
        
        map.put("id", 3);
        
        list.add(map);        
        map = new HashMap<>();        
        map.put("id", 4);
        list.add(map);
        
        String content = JSONArray.toJSONString(list);
		
//		this.mvc.perform(delete("/items")
//			        .contentType(MediaType.APPLICATION_JSON)
//			        .content(content))
//			        .andDo(print())
//					.andExpect(status().isOk())
//			        .andExpect(jsonPath("$.statusCode").value("200"));
	}

}
