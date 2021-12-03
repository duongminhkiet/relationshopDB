package com.cpc.permission.pr.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cpc.permission.pr.object.PChucVu;
import com.cpc.permission.pr.object.PDonVi;
import com.cpc.permission.pr.object.PRole;
import com.cpc.permission.pr.object.PUser;
import com.cpc.permission.pr.object.PUser_PDonVi;
import com.cpc.permission.pr.object.PUser_PDonVi_Key;
import com.cpc.permission.pr.repo.PChucVuRepository;
import com.cpc.permission.pr.repo.PDonViRepository;
import com.cpc.permission.pr.repo.PRoleRepository;
import com.cpc.permission.pr.repo.PUserDonViRepository;
import com.cpc.permission.pr.repo.PUserRepository;

@Component
public class DataTest {
	
	@Autowired
	PUserRepository pUserRepository;
	@Autowired
	PDonViRepository pDonViRepository;
	@Autowired
	PChucVuRepository pChucVuRepository;
	@Autowired
	PRoleRepository pRoleRepository;
	@Autowired
	PUserDonViRepository pUserDonViRepository;
	public void createTest1() {
		
	}
	public void createUserDonViChucVuData() {
		PUser user1 = pUserRepository.findByUsername("user1");
		if(user1 == null) {
			user1 = pUserRepository.save(new PUser("user1","pass",true));//p1,p2
		}
		PUser user2 = pUserRepository.findByUsername("user2");
		if(user2 == null) {
			user2 = pUserRepository.save(new PUser("user2","pass",true));//p2
		}
		PUser user3 = pUserRepository.findByUsername("user3");
		if(user3 == null) {
			user3 = pUserRepository.save(new PUser("user3","pass",true));//p1,p2,p3
		}
		PUser user4 = pUserRepository.findByUsername("user4");
		if(user4 == null) {
			user4 = pUserRepository.save(new PUser("user4","pass",true));//p2
		}
		//
		PDonVi p1 = pDonViRepository.findByMadonvi("pc01");
		if(p1 == null) {
			p1 = pDonViRepository.save(new PDonVi("pc01","CTY DIEN LUC QUANG BINH"));
		}
		
		PDonVi p2 = pDonViRepository.findByMadonvi("pc02");
		if(p2 == null) {
			p2 = pDonViRepository.save(new PDonVi("pc02","CTY DIEN LUC QUANG TRI"));
		}
		
		PDonVi p3 = pDonViRepository.findByMadonvi("pc03");
		if(p3 == null) {
			p3 = pDonViRepository.save(new PDonVi("pc03","CTY DIEN LUC TTHUE"));
		}
		
//		Set<PDonVi> pdonvis12 = new HashSet<PDonVi>();pdonvis12.add(p1);pdonvis12.add(p2);
//		Set<PDonVi> pdonvis2 = new HashSet<PDonVi>();pdonvis2.add(p2);
//		Set<PDonVi> pdonvis123 = new HashSet<PDonVi>();pdonvis123.add(p1);pdonvis123.add(p2);pdonvis123.add(p3);
		
		List<PDonVi> pdonvis12 = new ArrayList<PDonVi>();pdonvis12.add(p1);pdonvis12.add(p2);
		List<PDonVi> pdonvis2 = new ArrayList<PDonVi>();pdonvis2.add(p2);
		List<PDonVi> pdonvis123 = new ArrayList<PDonVi>();pdonvis123.add(p1);pdonvis123.add(p2);pdonvis123.add(p3);
		
//		Set<PUser> pusers = new HashSet<PUser>();pusers.add(user1);
		
		user1.setPdonvis(pdonvis12);
//		user1.setPdonvis(pdonvis123);
		user2.setPdonvis(pdonvis2);
		user3.setPdonvis(pdonvis123);
		user4.setPdonvis(pdonvis2);
		
		user1 = pUserRepository.save(user1);
		user2 = pUserRepository.save(user2);
		user3 = pUserRepository.save(user3);
		user4 = pUserRepository.save(user4);
		
		
//		PUser user1 = pUserRepository.findByUsername("user1");
//		PDonVi p1 = pDonViRepository.findByMadonvi("pc01");
//		PUser_PDonVi ud = pUserDonViRepository.findByPuserAndPdonvi(user1, p1);
		
		
//		List<PUser_PDonVi> listUDonVis = new ArrayList<>();
//		PUser_PDonVi u1d1 = pUserDonViRepository.findByUserdonvikeyUserIdAndUserdonvikeyDonviId(1L, 1L);//TP

		
		PChucVu c1 = pChucVuRepository.findByName("CV");
		if(c1 == null) {
			c1 = pChucVuRepository.save(new PChucVu("CV"));//1,2
		}
		PChucVu c2 = pChucVuRepository.findByName("TP");
		if(c2 == null) {
			c2 = pChucVuRepository.save(new PChucVu("TP"));//1,2,3
		}
		PChucVu c3 = pChucVuRepository.findByName("CTCD");
		if(c3 == null) {
			c3 = pChucVuRepository.save(new PChucVu("CTCD"));//1,2
		}
		PChucVu c4 = pChucVuRepository.findByName("GD");
		if(c4 == null) {
			c4 = pChucVuRepository.save(new PChucVu("GD"));//1,2,3
		}
		PChucVu c5 = pChucVuRepository.findByName("SUPERADMIN");
		if(c5 == null) {
			c5 = pChucVuRepository.save(new PChucVu("SUPERADMIN"));//1,2,3,4
		}
		//
		PRole r1 = pRoleRepository.findByName("VIEW_DOTHI");
		if(r1 == null) {
			r1 = pRoleRepository.save(new PRole("VIEW_DOTHI"));//1,2,3,4,5
		}
		PRole r2 = pRoleRepository.findByName("VIEW_DIEMDO");
		if(r2 == null) {
			r2 = pRoleRepository.save(new PRole("VIEW_DIEMDO"));//1,2,3,4,5
		}
		PRole r3 = pRoleRepository.findByName("ADD_USER");
		if(r3 == null) {
			r3 = pRoleRepository.save(new PRole("ADD_USER"));//2,4,5
		}
		PRole r4 = pRoleRepository.findByName("ADMIN");
		if(r4 == null) {
			r4 = pRoleRepository.save(new PRole("ADMIN"));//5
		}
		
		Set<PRole> setRole12 = new HashSet<>();setRole12.add(r1);setRole12.add(r2);//CV
		Set<PRole> setRole123 = new HashSet<>();setRole123.add(r1);setRole123.add(r2);setRole123.add(r3);//TP
		Set<PRole> setRole1234 = new HashSet<>();setRole1234.add(r1);setRole1234.add(r2);setRole1234.add(r3);setRole1234.add(r4);//GD
		
		c1.setProles(setRole12);
		c2.setProles(setRole123);
		c3.setProles(setRole12);
		c4.setProles(setRole123);
		c5.setProles(setRole1234);
//		List<PChucVu> listChucvu = new ArrayList<>();
//		listChucvu.add(c1);
//		listChucvu.add(c2);
//		listChucvu.add(c3);
//		listChucvu.add(c4);
//		listChucvu.add(c5);
//		PChucVu xChucVu = new PChucVu();xChucVu.setName("GD");
		
//		Set<PChucVu> setCVs = new HashSet<>();setCVs.add(c1);setCVs.add(c2);setCVs.add(c3);setCVs.add(c4);setCVs.add(c5);setCVs.add(xChucVu);
		c1=pChucVuRepository.save(c1);//update all c1...5
		c2=pChucVuRepository.save(c2);
		c3=pChucVuRepository.save(c3);
		c4=pChucVuRepository.save(c4);
		c5=pChucVuRepository.save(c5);
//		pChucVuRepository.saveAll(setCVs);
		//
		
		Set<PChucVu> pchucvus_TP = new HashSet<PChucVu>();pchucvus_TP.add(c2);
		Set<PChucVu> pchucvus_CTCD_GD = new HashSet<PChucVu>();pchucvus_CTCD_GD.add(c3);pchucvus_CTCD_GD.add(c4);
		Set<PChucVu> pchucvus_CV = new HashSet<PChucVu>();pchucvus_CV.add(c1);
		Set<PChucVu> pchucvus_SUPERADMIN_TP = new HashSet<PChucVu>();pchucvus_SUPERADMIN_TP.add(c5);pchucvus_SUPERADMIN_TP.add(c2);
		Set<PChucVu> pchucvus_GD = new HashSet<PChucVu>();pchucvus_GD.add(c4);
		
		
		
		PUser_PDonVi u1d1 = pUserDonViRepository.findByPuserAndPdonvi(user1, p1);//TP
		if(u1d1 == null) {
			u1d1 = new PUser_PDonVi();
			u1d1.setUserdonvikey(new PUser_PDonVi_Key(user1.getId(),p1.getId()));
			u1d1.setPdonvi(p1);
			u1d1.setPuser(user1);
			u1d1 = pUserDonViRepository.save(u1d1);
		}
		PUser_PDonVi u1d2 = pUserDonViRepository.findByPuserAndPdonvi(user1, p2);//CTCD,GD
		if(u1d2 == null) {
			u1d2 = new PUser_PDonVi();
			u1d2.setUserdonvikey(new PUser_PDonVi_Key(user1.getId(),p2.getId()));
			u1d2.setPdonvi(p2);
			u1d2.setPuser(user1);
			u1d2 = pUserDonViRepository.save(u1d2);
		}
		PUser_PDonVi u2d2 = pUserDonViRepository.findByPuserAndPdonvi(user2, p2);//CV
		if(u2d2 == null) {
			u2d2 = new PUser_PDonVi();
			u2d2.setUserdonvikey(new PUser_PDonVi_Key(user2.getId(),p2.getId()));
			u2d2.setPdonvi(p2);
			u2d2.setPuser(user2);
			u2d2 =pUserDonViRepository.save(u2d2);
		}
		PUser_PDonVi u3d1 = pUserDonViRepository.findByPuserAndPdonvi(user3, p1);//SUPERADMIN,TP
		if(u3d1 == null) {
			u3d1 = new PUser_PDonVi();
			u3d1.setUserdonvikey(new PUser_PDonVi_Key(user3.getId(),p1.getId()));
			u3d1.setPdonvi(p1);
			u3d1.setPuser(user3);
			u3d1 =pUserDonViRepository.save(u3d1);
		}
		PUser_PDonVi u3d2 = pUserDonViRepository.findByPuserAndPdonvi(user3, p2);//CV
		if(u3d2 == null) {
			u3d2 = new PUser_PDonVi();
			u3d2.setUserdonvikey(new PUser_PDonVi_Key(user3.getId(),p2.getId()));
			u3d2.setPdonvi(p2);
			u3d2.setPuser(user3);
			u3d2 =pUserDonViRepository.save(u3d2);
		}
		PUser_PDonVi u3d3 = pUserDonViRepository.findByPuserAndPdonvi(user3, p3);//CV
		if(u3d3 == null) {
			u3d2 = new PUser_PDonVi();
			u3d2.setUserdonvikey(new PUser_PDonVi_Key(user3.getId(),p3.getId()));
			u3d2.setPdonvi(p3);
			u3d2.setPuser(user3);
			u3d2 =pUserDonViRepository.save(u3d3);
		}
		PUser_PDonVi u4d2 = pUserDonViRepository.findByPuserAndPdonvi(user4, p2);//GD
		if(u4d2 == null) {
			u4d2 = new PUser_PDonVi();
			u4d2.setUserdonvikey(new PUser_PDonVi_Key(user4.getId(),p2.getId()));
			u4d2.setPdonvi(p2);
			u4d2.setPuser(user4);
			u4d2 =pUserDonViRepository.save(u4d2);
		}

		
//		u1d1.setPchucvus(pchucvus_TP);
//		u1d2.setPchucvus(pchucvus_CTCD_GD);
//		u2d2.setPchucvus(pchucvus_CV);
//		u3d1.setPchucvus(pchucvus_SUPERADMIN_TP);
//		u3d2.setPchucvus(pchucvus_CV);
//		u3d3.setPchucvus(pchucvus_CV);
//		u4d2.setPchucvus(pchucvus_GD);
		
		u1d1.setPchucvus(pchucvus_TP);
		u1d2.setPchucvus(pchucvus_CTCD_GD);
		u2d2.setPchucvus(pchucvus_CV);
		u3d1.setPchucvus(pchucvus_SUPERADMIN_TP);
		u3d2.setPchucvus(pchucvus_CV);
		u3d3.setPchucvus(pchucvus_CV);
		u4d2.setPchucvus(pchucvus_GD);
		
		Set<PUser_PDonVi> setUDs = new HashSet<>();setUDs.add(u1d1);setUDs.add(u1d2);setUDs.add(u2d2);setUDs.add(u3d1);setUDs.add(u3d2);setUDs.add(u3d3);setUDs.add(u4d2);
		
//		Set<PChucVu> pchucvusX = new HashSet<PChucVu>();pchucvusX.add(new PChucVu("XX"));
//		PUser_PDonVi udX = new PUser_PDonVi();
//		udX.setUserdonvikey(new PUser_PDonVi_Key(user1.getId(),p2.getId()));
//		udX.setPdonvi(p2);
//		udX.setPuser(user1);
//		udX.setPchucvus(pchucvusX);
//		pUserDonViRepository.save(udX);
		
		
		try {
			u1d1 = pUserDonViRepository.save(u1d1);
		} catch (Exception e) {
			String e1 = e.getMessage();
			System.out.println(e1);
		}
		
		try {
			u3d1 = pUserDonViRepository.save(u3d1);
		} catch (Exception e) {
			String e1 = e.getMessage();
			System.out.println(e1);
		}
		try {
			u1d2 = pUserDonViRepository.save(u1d2);
		} catch (Exception e) {
			String e1 = e.getMessage();
			System.out.println(e1);
		}
		
		try {
			u2d2 = pUserDonViRepository.save(u2d2);
		} catch (Exception e) {
			String e1 = e.getMessage();
			System.out.println(e1);
		}
		
		try {
			u3d3 = pUserDonViRepository.save(u3d3);
		} catch (Exception e) {
			String e1 = e.getMessage();
			System.out.println(e1);
		}
		
		try {
			u3d2 = pUserDonViRepository.save(u3d2);
		} catch (Exception e) {
			String e1 = e.getMessage();
			System.out.println(e1);
		}
		
		try {
			u4d2 = pUserDonViRepository.save(u4d2);
		} catch (Exception e) {
			String e1 = e.getMessage();
			System.out.println(e1);
		}
//		listUDonVis.add(u1d1);
//		listUDonVis.add(u1d2);
//		listUDonVis.add(u2d2);
//		listUDonVis.add(u3d1);
//		listUDonVis.add(u3d2);
//		listUDonVis.add(u3d3);
//		listUDonVis.add(u4d2);
//		
//		pUserDonViRepository.saveAll(listUDonVis);

		
	}
}
