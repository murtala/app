package com.moortala.orders.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
//@NamedQuery(name="Orders.findByName",query="SELECT id FROM Orders o  WHERE o.name= ?1")

@Table(name="orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	@NotNull
	public int table_number;
	@NotNull
	public int status;
	public String notes;
	public Long breakfast;
	public Long lunch;
	public Long dinner;
	public Long dessert;
	public Long breakfast_qty;
	public Long lunch_qty;
	public Long dinner_qty;
	public Long dessert_qty;
	public Long user_id;
	public String waiter_name;
	public String chef_name;
	public String device_id;
	public long start_time;
	public long end_time;
	
	//get End_time
	public long getEnd_time() {
		return end_time;
	}
	//set End_time
	public void setEnd_time(long end_time) {
		this.end_time = end_time;
	}
	//get start_time
	public long getStart_time() {
		return start_time;
	}
	//set start_time
	public void setStart_time(long start_time) {
		this.start_time = start_time;
	}
	//get id
	public long getId() {
		return id;
	}
	//set id
	public void setId(long id) {
		this.id = id;
	}
	//get table number
	public int getTable_number() {
		return table_number;
	}
	//set table number
	public void setTable_number(int table_number) {
		this.table_number = table_number;
	}
	//get status
	public int getStatus() {
		return status;
	}
	/** The status for the order. 0= initial, 1= sent to chef, 2= chef receive, 3=chef complete
	 * 
	 * @param status
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	//get the notes
	public String getNotes() {
		return notes;
	}
	//set the notes
	public void setNotes(String notes) {
		this.notes = notes;
	}
	//get the device id
	public String getDevice_id() {
		return device_id;
	}
	//set the device id
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	//get the breakfast
	public Long getBreakfast() {
		return breakfast;
	}
	//set breakfast
	public void setBreakfast(Long breakfast) {
		this.breakfast = breakfast;
	}
	//get lunch
	public Long getLunch() {
		return lunch;
	}
	//set lunch
	public void setLunch(Long lunch) {
		this.lunch = lunch;
	}
	//get dinner
	public Long getDinner() {
		return dinner;
	}
	//set dinner
	public void setDinner(Long dinner) {
		this.dinner = dinner;
	}
	//get the dessert
	public Long getDessert() {
		return dessert;
	}
	//set the dessert
	public void setDessert(Long dessert) {
		this.dessert = dessert;
	}
	//get breakfast
	public Long getBreakfast_qty() {
		return breakfast_qty;
	}
	//set breakfast
	public void setBreakfast_qty(Long breakfast_qty) {
		this.breakfast_qty = breakfast_qty;
	}
	//get lunch quantity
	public Long getLunch_qty() {
		return lunch_qty;
	}
	//set lunch quantity
	public void setLunch_qty(Long lunch_qty) {
		this.lunch_qty = lunch_qty;
	}
	//get dinner quantity
	public Long getDinner_qty() {
		return dinner_qty;
	}
	//set dinner quantity
	public void setDinner_qty(Long dinner_qty) {
		this.dinner_qty = dinner_qty;
	}
	//get dessert quantity
	public Long getDessert_qty() {
		return dessert_qty;
	}
	//set dessert quantity
	public void setDessert_qty(Long dessert_qty) {
		this.dessert_qty = dessert_qty;
	}
	//get the name of the waiter
	public String getWaiter_name() {
		return waiter_name;
	}
	//set the name of the waiter
	public void setWaiter_name(String waiter_name) {
		this.waiter_name = waiter_name;
	}
	//get the chef's name
	public String getChef_name() {
		return chef_name;
	}
	//set the chefs name
	public void setChef_name(String chef_name) {
		this.chef_name = chef_name;
	}
	//get the user id
	public Long getUser_id() {
		return user_id;
	}
	//set the user id
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}	
	
 
}
