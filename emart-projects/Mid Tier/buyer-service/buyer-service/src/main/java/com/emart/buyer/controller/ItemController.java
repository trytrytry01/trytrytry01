package com.emart.buyer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emart.buyer.entity.Item;
import com.emart.buyer.pojo.Result;
import com.emart.buyer.service.ItemService;

@RestController
@RequestMapping(value="/api/items")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
     
    /**
     * seller view stock 
     */
    @GetMapping
    public Result searchItems(String keywords) {
    	
    	Result result = new Result();

    	keywords = keywords==null ? "":keywords;
        List<Item> itemList = itemService.searchItems(keywords);
                
        result.setCount(itemList.size());
        result.setData(itemList);
        result.setStatusCode(HttpStatus.OK.value());
        
        return result;
    }


}
