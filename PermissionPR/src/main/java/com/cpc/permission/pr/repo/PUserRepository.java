package com.cpc.permission.pr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpc.permission.pr.helper.GlobalVariable;
import com.cpc.permission.pr.object.PUser;

@Repository
public interface PUserRepository extends JpaRepository<PUser, Long>{
	@Query(
			value = "SELECT COUNT(*) FROM (SELECT TOP 1 * FROM "+GlobalVariable.TBL_P_USER+") T;",
			nativeQuery = true
				)
		int checkEmptyTable();//0 is empty, 1 is not empty
	PUser findByUsername(String username);
}
