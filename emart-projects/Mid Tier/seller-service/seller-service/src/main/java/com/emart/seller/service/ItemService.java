package com.emart.seller.service;

import java.util.List;

import com.emart.seller.entity.Item;

public interface ItemService {

	/**
	 * proceed to save item 
	 * @param ItemPojo item
	 */
    void addItem(Item item);
    
	/**
	 * update item stock and price
	 * @param List<Item> itemList
	 */
    void updateItem(List<Item> itemList);
    
	/**
	 * view items stock by sellerId
	 * @param Long sellerId
	 */
    List<Item> viewItems(Long sellerId);
    
	/**
	 * delete items
	 * @param List<Item> idList
	 */
    void deleteItems(List<Item> idList);
}
