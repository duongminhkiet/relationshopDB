package com.cpc.permission.pr.object;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cpc.permission.pr.helper.GlobalVariable;

@Entity
@Table(name = GlobalVariable.TBL_P_USER)
public class PUser extends PParent{
	private static final long serialVersionUID = 1L;
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "status", nullable = true)
	private Boolean status;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER )
    @JoinTable(
            name = GlobalVariable.TBL_P_USER_DONVI,
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "donvi_id",referencedColumnName="id")
    )
	private List<PDonVi> pdonvis = new ArrayList<PDonVi>();
	
	@OneToMany(mappedBy = "puser",fetch = FetchType.EAGER)
    Set<PUser_PDonVi> puserdonvis;
    
	@Override
	public int hashCode() {
		return Objects.hash(username);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || getClass() != obj.getClass()) {
			return false;
		}
		PUser x = (PUser)obj;
		return Objects.equals(username, x.username);
	}
	public List<PDonVi> getPdonvis() {
		return pdonvis;
	}
	public void setPdonvis(List<PDonVi> pdonvis) {
		this.pdonvis = pdonvis;
	}
	
	public PUser() {
		
	}
	public PUser(String username,String password, Boolean status) {
		this.username = username;
		this.password = password;
		this.status = status;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		String pdonvisStr = "";
		if(pdonvis!= null && pdonvis.size() >0) {
			for(PDonVi dv : pdonvis) {
				pdonvisStr+=" info: "+dv.toString()+ " - ";
			}
		}
		
		String str2 ="";
		if(puserdonvis !=null && puserdonvis.size() >0) {
			str2="size_puserdonvis: "+puserdonvis.size()+" ----> ";
			for(PUser_PDonVi ud : puserdonvis) {
				str2+=ud.toString()+" | ";
			}
		}
		
		return "user: "+username +" size_dv: "+pdonvis.size()+pdonvisStr+"\n puserdonvis: "+str2;
	}
}
