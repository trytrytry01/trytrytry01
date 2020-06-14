package com.emart.buyer.service.impl;

import java.util.List;
import java.util.Optional;

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
	public List<Item> searchItems(String keyWords) {
		keyWords = "%" + keyWords + "%";
		return itemDao.searchItems(keyWords);
	}


	@Override
	public Item viewItemDetail(Long itemId) {

		return itemDao.getOne(itemId);
	}

}
