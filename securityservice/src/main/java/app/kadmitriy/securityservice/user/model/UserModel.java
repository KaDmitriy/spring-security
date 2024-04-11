package app.kadmitriy.securityservice.user.model;

import java.util.Objects;

public class UserModel {

	private Integer id;
	private String passord;
	private String name;
	private String descr;
	private Integer age;

	
	
	public UserModel(Integer id, String passord, String name, String descr, Integer age) {
		super();
		this.id = id;
		this.passord = passord;
		this.name = name;
		this.descr = descr;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, descr, id, name, passord);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserModel other = (UserModel) obj;
		return Objects.equals(age, other.age) && Objects.equals(descr, other.descr) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(passord, other.passord);
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", passord=" + passord + ", name=" + name + ", descr=" + descr + ", age=" + age
				+ "]";
	}

}
