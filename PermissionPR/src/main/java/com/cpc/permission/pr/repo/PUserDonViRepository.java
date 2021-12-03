package com.cpc.permission.pr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpc.permission.pr.helper.GlobalVariable;
import com.cpc.permission.pr.object.PDonVi;
import com.cpc.permission.pr.object.PUser;
import com.cpc.permission.pr.object.PUser_PDonVi;

@Repository
public interface PUserDonViRepository extends JpaRepository<PUser_PDonVi, Long>{
	@Query(
			value = "SELECT COUNT(*) FROM (SELECT TOP 1 * FROM "+GlobalVariable.TBL_P_USER_DONVI+") T;",
			nativeQuery = true
				)
		int checkEmptyTable();//0 is empty, 1 is not empty
	
	PUser_PDonVi findByPuserAndPdonvi(PUser user, PDonVi donvi);
	PUser_PDonVi findByUserdonvikeyUserIdAndUserdonvikeyDonviId(Long userId, Long donviId);
}
