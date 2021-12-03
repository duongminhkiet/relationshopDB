package com.cpc.permission.pr1.object;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.cpc.permission.pr1.helper.GlobalVariable;

@Entity
@Table(name = GlobalVariable.TBL_P_ROLE)
public class PRole extends PParent{
	private static final long serialVersionUID = 1L;
	public PRole() {
		
	}
	public PRole(String namex) {
		this.name = namex;
	}
	
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	
	@Column(name = "status", nullable = true)
	private Boolean status;

    @ManyToMany(mappedBy = "proles")
    private Set<PChucVu> pchucvus;
    
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}


	public Set<PChucVu> getPchucvus() {
		return pchucvus;
	}


	public void setPchucvus(Set<PChucVu> pchucvus) {
		this.pchucvus = pchucvus;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || getClass() != obj.getClass()) {
			return false;
		}
		PRole x = (PRole)obj;
		return Objects.equals(name, x.name);
	}
}
