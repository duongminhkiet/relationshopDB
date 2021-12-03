package com.cpc.permission.pr.object;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.cpc.permission.pr.helper.GlobalVariable;

@Entity
@Table(name = GlobalVariable.TBL_P_CHUCVU)
public class PChucVu extends PParent{
	private static final long serialVersionUID = 1L;
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@Column(name = "status", nullable = true)
	private Boolean status;
	
    @ManyToMany(mappedBy = "pchucvus")
    private Set<PUser_PDonVi> puserdonvis;

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = GlobalVariable.TBL_P_CHUCVU_ROLE,
            joinColumns = @JoinColumn(name = "chucvu_id",referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName="id")
    )
	private Set<PRole> proles = new HashSet<PRole>();
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
		PChucVu x = (PChucVu)obj;
		return Objects.equals(name, x.name);
	}
	public PChucVu() {
	}
	public PChucVu(String tenchucvu) {
		this.name = tenchucvu;
	}
	
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

	public Set<PUser_PDonVi> getPuserdonvis() {
		return puserdonvis;
	}

	public void setPuserdonvis(Set<PUser_PDonVi> puserdonvis) {
		this.puserdonvis = puserdonvis;
	}

	public Set<PRole> getProles() {
		return proles;
	}

	public void setProles(Set<PRole> proles) {
		this.proles = proles;
	}
}
