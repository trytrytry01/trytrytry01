package com.emart.buyer.entity;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CartItemTest {


	@Test
	public void test() {
		CartItem cartItem = new CartItem();
		cartItem.setBuyerId(1L);
		cartItem.setId(1L);
		cartItem.setItemId(5L);
		cartItem.setNumberOfItems(500);
		cartItem.setItemName("test1");
		cartItem.setCreatedDateTime(new Date());
		
		assertThat( cartItem.getId().toString(), is("1") );
		assertThat( cartItem.getBuyerId().toString(), is("1") );
		assertThat( cartItem.getItemName().toString(), is("test1") );

	}

}
