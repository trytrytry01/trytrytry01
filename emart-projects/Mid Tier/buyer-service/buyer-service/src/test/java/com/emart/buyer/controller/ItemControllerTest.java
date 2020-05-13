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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ItemControllerTest {
	
	@Autowired
	private MockMvc mvc;

	@Test
	public void testSearchItems() throws Exception {
		
		this.mvc.perform(get("/api/items")).andExpect(status().isOk());
	}
	
	@Test
	public void testSearchItems2() throws Exception {
		
		this.mvc.perform(get("/api/items?keywords=test")).andExpect(status().isOk());
	}

}
