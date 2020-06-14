package com.emart.seller.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import com.emart.seller.entity.Item;
import com.emart.seller.pojo.Result;
import com.emart.seller.service.ItemService;
import com.emart.seller.utils.JwtTokenUtil;

@RestController
@RequestMapping(value="/items")
public class ItemController {

	@Autowired
	private ItemService itemService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
//    
//    private RestTemplate restTemplate = new RestTemplate();

    /**
     * seller add items
     */
    @PostMapping
    public Result addItem(HttpServletRequest request, @RequestBody Item item) {

    	Result result = new Result();
    	
    	this.checkItem(item, result);
    	if(result.getMessages().size() > 0) {
    		result.setStatusCode(HttpStatus.BAD_REQUEST.value());
    		return result;
    	}

    	//get sellerId form JWT
    	String token = request.getHeader("Authorization");
    	Long sellerId = jwtTokenUtil.getUserIdFromToken(token);
    	
    	item.setSellerId(sellerId);

        itemService.addItem(item);

        result.setStatusCode(HttpStatus.OK.value());

        return result;
    }
    
    /**
     * seller update items(update stock and price)
     */
    @PutMapping
    public Result updateItem(@RequestBody List<Item> itemList) {
    	
    	Result result = new Result();

        itemService.updateItem(itemList);
        
        result.setStatusCode(HttpStatus.OK.value());
        
        return result;
    }
    
    /**
     * seller view stock 
     */
    @GetMapping
    public Result getItems(HttpServletRequest request) {
    	
    	Result result = new Result();
    	
    	//get sellerId form JWT
    	String token = request.getHeader("Authorization");
    	Long sellerId = jwtTokenUtil.getUserIdFromToken(token);
        
        List<Item> itemList = itemService.viewItems(sellerId);
        
        result.setCount(itemList.size());
        result.setData(itemList);
        result.setStatusCode(HttpStatus.OK.value());
        
        return result;
    }
    
    /**
     * seller delete items 
     */
    @DeleteMapping
    public Result deleteItems(@RequestBody List<Item> itemList) {
    	
    	Result result = new Result();
        itemService.deleteItems(itemList);
        result.setStatusCode(HttpStatus.OK.value());
        
        return result;
    }
    
	private void checkItem(Item item, Result result) {
		ArrayList<String> messages = result.getMessages();
		if(item.getItemName() == null) {
			messages.add("itemName is required!");
		}
		
		if(item.getCategoryId() == null) {
			messages.add("categoryId is required!");
		}
		
		if(item.getSubcategoryId() == null) {
			messages.add("subcategoryId is required!");
		}
		
		if(item.getPrice() == null) {
			messages.add("proce is required!");
		}
		
		result.setMessages(messages);
		
	}


}
