package com.emart.buyer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emart.buyer.entity.Item;
import com.emart.buyer.pojo.Result;
import com.emart.buyer.service.ItemService;

@RestController
@RequestMapping(value="/items")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
     
    /**
     * buyer seach items 
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
    
    /**
     * buyer view item Detail 
     */
    @GetMapping(value= "/{itemId}")
    public Result viewItemDetail(@PathVariable Long itemId) {
    	
    	Result result = new Result();

        Item item = itemService.viewItemDetail(itemId);

        result.setCount(1);
        result.setData(item);
        result.setStatusCode(HttpStatus.OK.value());
        
        return result;
    }


}
