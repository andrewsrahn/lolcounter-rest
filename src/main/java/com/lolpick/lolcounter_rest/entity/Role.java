package com.lolpick.lolcounter_rest.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
@Entity
@Table(name="role")
public class Role implements Serializable {
	private static final long serialVersionUID = -3838929298301399348L;

	@Id
	@Column(name="role_id")
	private Integer id;
	
	@Column(name="champion_role")
	private String role;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@Cascade({CascadeType.SAVE_UPDATE})
	@JoinTable(name="champion_role", 
			joinColumns= {@JoinColumn(name="role_id")},
			inverseJoinColumns= {@JoinColumn(name="champion_id")})
	@SequenceGenerator(
			name="champion_role_sequence",
			initialValue=1,
			allocationSize=500)
	@CollectionId(
			columns = @Column(name="champion_role_id"),
			type = @Type(type="long"),
			generator = "champion_role_sequence")
	List<Champion> champions;
	
	public Role() {
		super();
	}
	
	public Role(Integer id, String role) {
		super();
		this.id = id;
		this.role = role;
		this.champions = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Champion> getChampions() {
		return champions;
	}

	public void setChampions(List<Champion> champions) {
		this.champions = champions;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

}
