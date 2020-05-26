package com.emart.buyer.entity;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemTest {


	@Test
	public void test() {
		Item item = new Item();
		item.setCategoryId(1L);
		item.setDescription("test");
		item.setItemName("1233");
		item.setPrice("121");
		item.setSubcategoryId(2L);
		item.setRemarks("remarks");
		item.setStockNumber(100L);
		item.setId(5L);
		item.getCategoryId();
		item.getItemName();
		item.getDescription();
		item.getRemarks();
		item.getPrice();
		item.getSellerId();
		item.getStockNumber();
		item.getSubcategoryId();
		item.getCategoryId();
		
		assertThat( item.getId().toString(), is("5") );
		assertThat( item.getItemName().toString(), is("1233") );
	
	}

}
