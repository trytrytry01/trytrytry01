package com.emart.seller.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.seller.dao.ItemDao;
import com.emart.seller.entity.Item;
import com.emart.seller.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;
    
	@Override
	public void addItem(Item item) {
		itemDao.save(item);
	}

	@Override
	public void updateItem(List<Item> itemList) {
		
		for(Item item : itemList) {
			Item itemTemp = itemDao.getOne(item.getId());
			//reset the update object itemList,so that no column can be updated except the price and stock
			item.setItemName(itemTemp.getItemName());
			item.setCategoryId(itemTemp.getCategoryId());
			item.setSubcategoryId(itemTemp.getSubcategoryId());
			item.setSellerId(itemTemp.getSellerId());
			item.setRemarks(itemTemp.getRemarks());
			if(item.getPrice() == null) {
				item.setPrice(itemTemp.getPrice());
			}
			if(item.getStockNumber() == null) {
				item.setStockNumber(itemTemp.getStockNumber());
			}
		}
		
		itemDao.saveAll(itemList);
	}

	@Override
	public List<Item> viewItems(Long sellerId) {
		return itemDao.findBySellerId(sellerId);
	}

	@Override
	public void deleteItems(List<Item> idList) {
		itemDao.deleteAll(idList);;
	}

}
