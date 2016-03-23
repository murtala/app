package com.moortala.orders.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
/**
 * A DAO for the entity User is simply created by extending the CrudRepository
 * interface provided by spring. The following methods are some of the ones
 * available from such interface: save, delete, deleteAll, findOne and findAll.
 * The magic is that such methods must not be implemented, and moreover it is
 * possible create new query methods working only by defining their signature!
 */


@Transactional
public interface OrdersDao extends CrudRepository <Orders, Long> {

	//find new orders
	@Query(" SELECT  id FROM Orders o WHERE o.status=0")	
	List<Long> findNewOrders();
	//find current orders: new/edited/in progress
	@Query(" SELECT  id FROM Orders o WHERE o.status=0 OR o.status=5 OR o.status=2")	
	List<Long> findCurrentOrders();
	//find a name
	@Query("SELECT  id FROM Orders o WHERE o.waiter_name=:userName")	
	List<Long> findByWaiterByName(@Param("userName") String userName);
	//find name
	@Query("SELECT  id FROM Orders o WHERE o.chef_name=:userName")	
	List<Long> findByChefByName(@Param("userName") String userName);
	//find order given the status	
	@Query(" SELECT  id FROM Orders o WHERE o.status=:orderStatus")	
	List<Long> findOrderByStatus(@Param("orderStatus") Integer orderStatus);
	//find by status
	@Query(" SELECT  id FROM Orders o WHERE (o.status=:orderStatus OR o.status=2) AND o.user_id =:userId")	
	List<Long> findOrderByStatus(@Param("orderStatus") Integer orderStatus, @Param("userId") Long userId);
	//find completed orders by id and status
	@Query(" SELECT  id FROM Orders o WHERE o.status=:orderStatus AND o.user_id =:userId")	
	List<Long> findCompletedOrders(@Param("orderStatus") Integer orderStatus, @Param("userId") Long userId);
	//find current and completed 
	@Query(" SELECT  id FROM Orders o WHERE o.status=4 OR o.status=5")	
	List<Long> findCurrentAndCompleted();
	//find completed only 
	@Query(" SELECT  id FROM Orders o WHERE o.status=4")	
	List<Long> findCompletedOrders();
	//find orders in progress
	@Query(" SELECT  id FROM Orders o WHERE o.status=5")	
	List<Long> findInProgressOrders();
	//find new and updated
	@Query(" SELECT  id FROM Orders o WHERE o.status=2 OR o.status=0")	
	List<Long> findNewAndUpdatedOrders();
	
}
