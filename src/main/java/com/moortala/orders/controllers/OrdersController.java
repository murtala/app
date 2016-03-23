package com.moortala.orders.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.moortala.orders.model.Orders;
import com.moortala.orders.model.OrdersDao;

@RestController
@RequestMapping("capstone/orders")
public class OrdersController {

	private Orders order;

	public OrdersController() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * @RequestMapping("/") String home() { return "no content"; }
	 */

	// all orders
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Orders> getOrders() {
		Iterable<Orders> orders = orderDao.findAll();
		return orders;
	}
	//submit order by waiter
	@RequestMapping(value = "/waiter/submit")
	@ResponseBody
	public Orders newOrder(int tableNumber, Long breakfast, Long breakfastQty, Long lunch, Long lunchQty, Long dinner,
			Long dinnerQty, Long dessert, Long dessertQty, String notes, int status, String waiterName, String deviceId,
			Long userId) {
		order = null;
		order = new Orders();
		order.setTable_number(tableNumber);
		order.setBreakfast(breakfast);
		order.setBreakfast_qty(breakfastQty);
		order.setLunch(lunch);
		order.setLunch_qty(lunchQty);
		order.setDinner(dinner);
		order.setDinner_qty(dinnerQty);
		order.setDessert(dessert);
		order.setDessert_qty(dessertQty);
		order.setNotes(notes);
		order.setStatus(status);
		order.setWaiter_name(waiterName);
		order.setDevice_id(deviceId);
		order.setUser_id(userId);
		System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
		order.setStart_time(System.currentTimeMillis());
		orderDao.save(order);
		return order;
	}
	//chef completes an order
	@RequestMapping(value = "/chef/complete")
	@ResponseBody
	public Orders completeOrder(String notes, int status, String chefName, long orderNumber, Long userId) {
		Orders order = null;
		try {
			order = orderDao.findOne(orderNumber);
			order.setNotes(notes);
			order.setStatus(status);
			order.setChef_name(chefName);
			order.setEnd_time(System.currentTimeMillis());
			orderDao.save(order);
		} catch (Exception e) {
			// e.printStackTrace();
			return order;
		}
		return order;
	}
	//chef edits an order
	@RequestMapping(value = "/chef/edit")
	@ResponseBody
	public Orders editOrderChef(String notes, int status, String chefName, long orderNumber, Long userId) {
		order = null;
		order = new Orders();

		try {
			order = orderDao.findOne(orderNumber);
			order.setNotes(notes);
			order.setStatus(status);
			order.setChef_name(chefName);
			orderDao.save(order);
		} catch (Exception e) {
			// e.printStackTrace();
			return order;
		}
		return order;
	}
	//get a specific order data
	@RequestMapping(method = RequestMethod.GET, value = "getOrder/{orderNumber}")
	@ResponseBody
	public Orders getOrder(@PathVariable("orderNumber") long orderNumber) {
		Orders order = null;
		order = new Orders();
		try {
			order.getId();
			order = orderDao.findOne(orderNumber);
		} catch (Exception e) {
			// e.printStackTrace();
			return order;
		}
		return order;
	}
	//waiter edits an order
	@RequestMapping(value = "/waiter/edit")
	@ResponseBody
	public Orders editOrder(long orderNumber, int tableNumber, Long breakfast, Long breakfastQty, Long lunch,
			Long lunchQty, Long dinner, Long dinnerQty, Long dessert, Long dessertQty, String notes, int status,
			String chefName, String deviceId, Long userId) {

		Orders order = null;
		try {
			order = orderDao.findOne(orderNumber);
			order.setTable_number(tableNumber);
			order.setNotes(notes);
			order.setStatus(status);
			order.setChef_name(chefName);
			order.setDevice_id(deviceId);
			order.setBreakfast(breakfast);
			order.setBreakfast_qty(breakfastQty);
			order.setLunch(lunch);
			order.setLunch_qty(lunchQty);
			order.setDinner(dinner);
			order.setDinner_qty(dinnerQty);
			order.setDessert(dessert);
			order.setDessert_qty(dessertQty);
			order.setUser_id(userId);
			orderDao.save(order);
		} catch (Exception e) {
			// e.printStackTrace();
			return order;
		}
		return order;
	}
	//waiter edits an order
	@RequestMapping(value = "/waiter/update")
	@ResponseBody
	public Orders waiterUpdateOrder(long orderNumber, int tableNumber, Long breakfast, Long breakfastQty, Long lunch,
			Long lunchQty, Long dinner, Long dinnerQty, Long dessert, Long dessertQty, String notes, int status,
			String waiterName, String deviceId) {

		Orders order = null;
		try {
			order = orderDao.findOne(orderNumber);
			order.setTable_number(tableNumber);
			order.setNotes(notes);
			order.setStatus(status);
			order.setWaiter_name(waiterName);
			order.setDevice_id(deviceId);
			order.setBreakfast(breakfast);
			order.setBreakfast_qty(breakfastQty);
			order.setLunch(lunch);
			order.setLunch_qty(lunchQty);
			order.setDinner(dinner);
			order.setDinner_qty(dinnerQty);
			order.setDessert(dessert);
			order.setDessert_qty(dessertQty);
			orderDao.save(order);
		} catch (Exception e) {
			// e.printStackTrace();
			return order;
		}
		return order;
	}
	//waiter deletes an order
	@RequestMapping(value = "/delete")
	@ResponseBody
	public Orders deleteOrder(long orderNumber) {
		Orders order = null;
		order = orderDao.findOne(orderNumber);
		try {
			orderDao.delete(order.getId());
		} catch (Exception e) {

			return order;
			// e.printStackTrace();
		}
		return order;
	}
	//all new orders
	@RequestMapping(value = "/getNewOrders")
	@ResponseBody
	public Iterable<Orders> getNewOrders() {
		Iterable<Orders> order = null;
		try {
			Iterable<Long> ids;
			ids = orderDao.findNewOrders();
			order = orderDao.findAll(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return order;
		}
		return order;
	}
	//all current orders
	@RequestMapping(value = "/findCurrentOrders")
	@ResponseBody
	public Iterable<Orders> findCurrentOrders() {
		Iterable<Orders> order = null;
		try {
			Iterable<Long> ids;
			ids = orderDao.findCurrentOrders();
			order = orderDao.findAll(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return order;
		}
		return order;
	}
	//all current and completed
	@RequestMapping(value = "/findCurrentAndCompletedOrders")
	@ResponseBody
	public Iterable<Orders> findCurrentAndCompletedOrders() {
		Iterable<Orders> order = null;
		try {
			Iterable<Long> ids;
			ids = orderDao.findCurrentAndCompleted();
			order = orderDao.findAll(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return order;
		}
		return order;

	}
	//all new and updated
	@RequestMapping(value = "/findNewAndUpdatedOrders")
	@ResponseBody
	public Iterable<Orders> findNewAndUpdatedOrders() {
		Iterable<Orders> order = null;
		try {
			Iterable<Long> ids;
			ids = orderDao.findNewAndUpdatedOrders();
			order = orderDao.findAll(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return order;
		}
		return order;

	}
	//all completed orders
	@RequestMapping(value = "/findCompletedOrders")
	@ResponseBody
	public Iterable<Orders> findCompletedOrders() {
		Iterable<Orders> order = null;
		try {
			Iterable<Long> ids;
			ids = orderDao.findCompletedOrders();
			order = orderDao.findAll(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return order;
		}
		return order;
	}
	//all canceled orders
	@RequestMapping(value = "/findCanceledOrders")
	@ResponseBody
	public Iterable<Orders> findCanceledOrders() {
		Iterable<Orders> order = null;
		try {
			Iterable<Long> ids;
			ids = orderDao.findOrderByStatus(5);
			order = orderDao.findAll(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return order;
		}
		return order;
	}
	//all orders in progress
	@RequestMapping(value = "/findInProgressOrders")
	@ResponseBody
	public Iterable<Orders> findInProgressOrders() {
		Iterable<Orders> order = null;
		try {
			Iterable<Long> ids;
			ids = orderDao.findInProgressOrders();
			order = orderDao.findAll(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return order;
		}
		return order;
	}
	//find an order given the status
	@RequestMapping(value = "findByStatus/{orderStatus}")
	@ResponseBody
	public Iterable<Orders> findByStatus(@PathVariable("orderStatus") int orderStatus) {

		Iterable<Orders> order = null;
		try {
			Iterable<Long> ids;
			ids = orderDao.findOrderByStatus(orderStatus);
			order = orderDao.findAll(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return order;
		}
		return order;
	}
	//find an order given the status and the user id
	@RequestMapping(value = "findByStatus/{orderStatus}/{userId}")
	@ResponseBody
	public Iterable<Orders> findByStatus(@PathVariable("orderStatus") Integer orderStatus,
			@PathVariable("userId") Long userId) {

		Iterable<Orders> order = null;
		try {
			Iterable<Long> ids;
			ids = orderDao.findOrderByStatus(orderStatus, userId);
			order = orderDao.findAll(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return order;
		}
		return order;
	}
	//find completed orders by user id and status
	@RequestMapping(value = "findCompletedOrders/{orderStatus}/{userId}")
	@ResponseBody
	public Iterable<Orders> findCompletedOrders(@PathVariable("orderStatus") Integer orderStatus,
			@PathVariable("userId") Long userId) {

		Iterable<Orders> order = null;
		try {
			Iterable<Long> ids;
			ids = orderDao.findOrderByStatus(orderStatus, userId);
			order = orderDao.findAll(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return order;
		}
		return order;
	}
	//handle the exceptions
	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest req, Exception exception) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");
		return mav;
	}
	//wire the DAO
	@Autowired
	private OrdersDao orderDao;
}
