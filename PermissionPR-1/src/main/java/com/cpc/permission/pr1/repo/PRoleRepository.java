package com.cpc.permission.pr1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpc.permission.pr1.helper.GlobalVariable;
import com.cpc.permission.pr1.object.PRole;

@Repository
public interface PRoleRepository extends JpaRepository<PRole, Long>{
	@Query(
			value = "SELECT COUNT(*) FROM (SELECT TOP 1 * FROM "+GlobalVariable.TBL_P_ROLE+") T;",
			nativeQuery = true
				)
		int checkEmptyTable();//0 is empty, 1 is not empty
	
	PRole findByName(String name);
}
