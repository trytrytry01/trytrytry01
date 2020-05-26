package com.emart.buyer.service;

import java.util.List;

import com.emart.buyer.entity.Item;


public interface ItemService {

	/**
	 * search Items
	 * @param String keyWords
	 */
    List<Item> searchItems(String keyWords);

}
