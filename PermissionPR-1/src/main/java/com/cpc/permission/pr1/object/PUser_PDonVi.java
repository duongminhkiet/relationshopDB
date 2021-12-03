package com.cpc.permission.pr1.object;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cpc.permission.pr1.helper.GlobalVariable;

@Entity
@Table(name =GlobalVariable.TBL_P_USER_DONVI,uniqueConstraints={ @UniqueConstraint(columnNames={"user_id", "donvi_id"})})//,uniqueConstraints={ @UniqueConstraint(columnNames={"user_id", "donvi_id"})}
public class PUser_PDonVi implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
//	public PUser_PDonVi() {
//		
//	}
//	public PUser_PDonVi(PUser_PDonVi_Key userdonvikey) {
//		this.userdonvikey = userdonvikey;
//	}
//	@EmbeddedId
//	PUser_PDonVi_Key userdonvikey;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = PUser.class)
    @MapsId("userId")//in EmbeddedId
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
	PUser puser;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PDonVi.class)
    @MapsId("donviId")//in EmbeddedId
    @JoinColumn(name = "donvi_id", insertable = false, updatable = false)
    PDonVi pdonvi;
    
    
//	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinTable(
//            name = GlobalVariable.TBL_P_USER_DONVI_CHUCVU,
//            joinColumns = {
//            @JoinColumn(name = "user_id",referencedColumnName="user_id", insertable = false, updatable = false),
//            @JoinColumn(name = "donvi_id",referencedColumnName="donvi_id", insertable = false, updatable = false)
//            },
//            inverseJoinColumns = @JoinColumn(name = "chucvu_id",referencedColumnName="id", insertable = false, updatable = false)
//    )
//	private Set<PChucVu> pchucvus = new HashSet<PChucVu>();
    
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.EAGER)
    @JoinTable(
            name = GlobalVariable.TBL_P_USER_DONVI_CHUCVU,
            joinColumns = @JoinColumn(name = "user_donvi_id",referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "chucvu_id",referencedColumnName="id", insertable = false, updatable = false)
    )
	private Set<PChucVu> pchucvus = new HashSet<PChucVu>();
    
//	@ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = GlobalVariable.TBL_P_USER_DONVI_CHUCVU,
//            joinColumns = @JoinColumn(name = "user_donvi_id",referencedColumnName="id"),
//            inverseJoinColumns = @JoinColumn(name = "chucvu_id",referencedColumnName="id")
//    )
//	private Set<PChucVu> pchucvus = new HashSet<PChucVu>();

//	public PUser_PDonVi_Key getUserdonvikey() {
//		return userdonvikey;
//	}
//
//
//	public void setUserdonvikey(PUser_PDonVi_Key userdonvikey) {
//		this.userdonvikey = userdonvikey;
//	}



//	public Long getId() {
//		return id;
//	}
//
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public PUser getPuser() {
		return puser;
	}


	public void setPuser(PUser puser) {
		this.puser = puser;
	}


	public PDonVi getPdonvi() {
		return pdonvi;
	}


	public void setPdonvi(PDonVi pdonvi) {
		this.pdonvi = pdonvi;
	}


	public Set<PChucVu> getPchucvus() {
		return pchucvus;
	}


	public void setPchucvus(Set<PChucVu> pchucvus) {
		this.pchucvus = pchucvus;
	}


	@Override
	public String toString() {
//		return "USER_DONVI: USER => "+userdonvikey.userId +" DONVI => "+userdonvikey.donviId;
		return "USER_DONVI:_ID "+id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(puser, pdonvi);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || getClass() != obj.getClass()) {
			return false;
		}
		PUser_PDonVi x = (PUser_PDonVi)obj;
		return Objects.equals(puser, x.puser)&&
				Objects.equals(pdonvi, x.pdonvi);//((userId==x.userId) && (donviId==x.donviId));
	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(userdonvikey);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if(this == obj) {
//			return true;
//		}
//		if(obj == null || getClass() != obj.getClass()) {
//			return false;
//		}
//		PUser_PDonVi x = (PUser_PDonVi)obj;
//		return Objects.equals(userdonvikey, x.userdonvikey);
//	}
	
}
