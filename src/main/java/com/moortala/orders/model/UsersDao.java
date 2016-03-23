package com.moortala.orders.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UsersDao extends CrudRepository<Users, Long> {
	
	//find id from username
	@Query("SELECT  id FROM Users u WHERE u.user=:userName")	
	List<Long> findUserByName(@Param("userName") String userName);

}
