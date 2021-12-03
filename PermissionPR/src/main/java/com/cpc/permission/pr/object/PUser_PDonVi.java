package com.cpc.permission.pr.object;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.cpc.permission.pr.helper.GlobalVariable;

@Entity
@Table(name =GlobalVariable.TBL_P_USER_DONVI)
public class PUser_PDonVi implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	PUser_PDonVi_Key userdonvikey;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = PUser.class)
    @MapsId("userId")//in EmbeddedId
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
	PUser puser;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PDonVi.class)
    @MapsId("donviId")//in EmbeddedId
    @JoinColumn(name = "donvi_id", insertable = false, updatable = false)
    PDonVi pdonvi;
    
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.EAGER)
    @JoinTable(
            name = GlobalVariable.TBL_P_USER_DONVI_CHUCVU,
            joinColumns = {
            @JoinColumn(name = "user_id",referencedColumnName="user_id", insertable = false, updatable = false),
            @JoinColumn(name = "donvi_id",referencedColumnName="donvi_id", insertable = false, updatable = false)
            },
            inverseJoinColumns = @JoinColumn(name = "chucvu_id",referencedColumnName="id", insertable = false, updatable = false)
    )
	private Set<PChucVu> pchucvus = new HashSet<PChucVu>();
	@Override
	public int hashCode() {
		return Objects.hash(userdonvikey);
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
		return Objects.equals(userdonvikey, x.userdonvikey);
	}
	public PUser_PDonVi() {
	}
	public PUser_PDonVi_Key getUserdonvikey() {
		return userdonvikey;
	}

	public void setUserdonvikey(PUser_PDonVi_Key userdonvikey) {
		this.userdonvikey = userdonvikey;
	}

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
		return "USER_DONVI: USER => "+userdonvikey.userId +" DONVI => "+userdonvikey.donviId;
	}
}
