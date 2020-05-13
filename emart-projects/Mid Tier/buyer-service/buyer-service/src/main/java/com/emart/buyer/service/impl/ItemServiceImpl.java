package com.emart.buyer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.buyer.dao.ItemDao;
import com.emart.buyer.entity.Item;
import com.emart.buyer.service.ItemService;

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
		itemDao.saveAll(itemList);
	}

	@Override
	public List<Item> searchItems(String keyWords) {
		keyWords = "%" + keyWords + "%";
		return itemDao.searchItems(keyWords);
	}

	@Override
	public void deleteItems(List<Item> idList) {
		itemDao.deleteAll(idList);;
	}

}
