package com.moortala.orders.model;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
/**
 * A DAO for the entity User is simply created by extending the CrudRepository
 * interface provided by spring. The following methods are some of the ones
 * available from such interface: save, delete, deleteAll, findOne and findAll.
 * The magic is that such methods must not be implemented, and moreover it is
 * possible create new query methods working only by defining their signature!
 */


@Transactional
public interface OrdersDao extends CrudRepository <Orders, Long> {

	 /**
	   * This method will find an User instance in the database by its email.
	   * Note that this method is not implemented and its working code will be
	   * automagically generated from its signature by Spring Data JPA.
	   */
	  public Orders findById(int id);
}
