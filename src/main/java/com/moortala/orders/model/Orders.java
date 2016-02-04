package com.moortala.orders.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	@NotNull
	public int table_number;
	@NotNull
	public String status;
	public String notes;
	public String meal;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getTable_number() {
		return table_number;
	}
	public void setTable_number(int table_number) {
		this.table_number = table_number;
	}
	public String getStatus() {
		return status;
	}
	
	/** The status for the order. 0= initial, 1= sent to chef, 2= chef receive, 3=chef complete
	 * 
	 * @param statusNumber
	 */
	public void setStatus(String statusNumber) {
		this.status = statusNumber;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
 
}
