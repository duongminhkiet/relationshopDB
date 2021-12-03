package com.cpc.permission.pr1.object;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cpc.permission.pr1.helper.GlobalVariable;

@Entity
@Table(name = GlobalVariable.TBL_P_DONVI)
public class PDonVi extends PParent{

	private static final long serialVersionUID = 1L;
	@Column(name = "madonvi", nullable = false, unique = true)
	private String madonvi;
	
	@Column(name = "tendonvi", nullable = false)
	private String tendonvi;
	
	@Column(name = "madonvi_parent", nullable = true)
	private String madonvi_parent;
	
	@Column(name = "status", nullable = true)
	private Boolean status;
	
//    @ManyToMany(mappedBy = "pdonvis",fetch = FetchType.EAGER)
//    private Set<PUser> pusers;
	
    @ManyToMany(mappedBy = "pdonvis",fetch = FetchType.EAGER)
    private List<PUser> pusers;
    
    public PDonVi() {
    	
    }
    public PDonVi(String madonvi, String tendonvi) {
    	this.madonvi = madonvi;
    	this.tendonvi = tendonvi;
    }
    
	public String getMadonvi() {
		return madonvi;
	}

	public void setMadonvi(String madonvi) {
		this.madonvi = madonvi;
	}

	public String getTendonvi() {
		return tendonvi;
	}

	public void setTendonvi(String tendonvi) {
		this.tendonvi = tendonvi;
	}

	public String getMadonvi_parent() {
		return madonvi_parent;
	}

	public void setMadonvi_parent(String madonvi_parent) {
		this.madonvi_parent = madonvi_parent;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

//	public Set<PUser> getPusers() {
//		return pusers;
//	}
//
//	public void setPusers(Set<PUser> pusers) {
//		this.pusers = pusers;
//	}
	
	
	
	@OneToMany(mappedBy = "pdonvi",fetch = FetchType.EAGER)
    Set<PUser_PDonVi> puserdonvis;

	public List<PUser> getPusers() {
		return pusers;
	}
	public void setPusers(List<PUser> pusers) {
		this.pusers = pusers;
	}
	public Set<PUser_PDonVi> getPuserdonvis() {
		return puserdonvis;
	}

	public void setPuserdonvis(Set<PUser_PDonVi> puserdonvis) {
		this.puserdonvis = puserdonvis;
	}
	@Override
	public String toString() {
		return madonvi;
	}
    
	@Override
	public int hashCode() {
		return Objects.hash(madonvi);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || getClass() != obj.getClass()) {
			return false;
		}
		PDonVi x = (PDonVi)obj;
		return Objects.equals(madonvi, x.madonvi);
	}
}
