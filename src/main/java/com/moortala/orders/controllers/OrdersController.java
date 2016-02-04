package com.moortala.orders.controllers;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.moortala.orders.model.Orders;
import com.moortala.orders.model.OrdersDao;

@RestController
@RequestMapping("capstone/orders")
public class OrdersController {
	
	public OrdersController() {
		// TODO Auto-generated constructor stub
	}
	
	
	/* @RequestMapping("/")
	    String home() {
	        return "no content";
	    }*/
	  
	//all orders
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public Iterable<Orders> getOrders(){
		    Iterable<Orders> orders = orderDao.findAll();
		      return orders;
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/send",  produces = "application/json", consumes="application/json")
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED) 
	public Orders sendOrder(@RequestBody(required = false)  Orders order){
		order = new Orders();
		order.setId(01);
		order.setTable_number(01);
		order.setStatus("SENT TO CHEF");
		 order.setNotes("fassst");
		 order.setMeal("foooood");
		     
		      orderDao.save(order);
		   //  return  new Orders ();
		      return order;
	}
	
	
	
	@RequestMapping(value="/submit")
	@ResponseBody
	public Orders currentOrder(int tableNumber, String meal, String notes){
		Orders order = null;  
		      order = new Orders();
		      order.setTable_number(tableNumber);
		      order.setMeal(meal);
		      order.setNotes(notes);
		      order.setStatus("SENT");
		      orderDao.save(order);
		      return order;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="getOrder/{orderNumber}")
	@ResponseBody
	public Orders getOrder(@PathVariable("orderNumber") long orderNumber){
		Orders order = null;  
	      order = new Orders();
	      try {
			order.getId();
			order = orderDao.findOne(orderNumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return order;
		}
		return order;
		
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	public Orders updateOrder(long orderNumber, int tableNumber, String meal, String notes){
		
		Orders order = null;
		try {
			order =orderDao.findOne(orderNumber); 
			  order.setTable_number(tableNumber);
			  order.setMeal(meal);
			  order.setNotes(notes);
			 order.setStatus("UPDATED?");
			  orderDao.save(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			 return order;
		}
	      return order;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public Orders deleteOrder(long orderNumber){
		Orders order = null;
		order =orderDao.findOne(orderNumber); 
	      try {
			orderDao.delete(order.getId());
		} catch (Exception e) {
		
			return order;
			//e.printStackTrace();
		}
	      return order;
	}

	@Autowired
	  private OrdersDao orderDao;
}
