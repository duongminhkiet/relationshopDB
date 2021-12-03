package com.cpc.permission.pr.object;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PUser_PDonVi_Key implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
    Long userId;

    @Column(name = "donvi_id")
    Long donviId;
    public PUser_PDonVi_Key() {
    	
    }
    public PUser_PDonVi_Key(Long userId, Long donviId) {
    	this.userId = userId;
    	this.donviId = donviId;
    }
	@Override
	public int hashCode() {
		return Objects.hash(userId, donviId);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || getClass() != obj.getClass()) {
			return false;
		}
		PUser_PDonVi_Key x = (PUser_PDonVi_Key)obj;
		return Objects.equals(userId, x.userId)&&
				Objects.equals(donviId, x.donviId);
	}
}
