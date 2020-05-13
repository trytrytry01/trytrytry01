package com.emart.buyer.service;

import java.util.List;

import com.emart.buyer.entity.Item;


public interface ItemService {

	/**
	 * proceed to save item 
	 * @param Item item
	 */
    void addItem(Item item);
    
	/**
	 * update item stock and price
	 * @param List<Item> itemList
	 */
    void updateItem(List<Item> itemList);
    
	/**
	 * search Items
	 * @param String keyWords
	 */
    List<Item> searchItems(String keyWords);
    
	/**
	 * delete items
	 * @param List<Item> idList
	 */
    void deleteItems(List<Item> idList);
}
