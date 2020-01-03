package com.stevenprogramming.liquibase.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 */
@Entity
@Table(name = "person")
public class Person extends BasicEntity {

	private String firstName;
    private String lastName;
    private char state;
    
    @Override
	public int onHashCode(int result){
		final int prime = 31;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
 
	@Override
	public boolean onEquals(Object obj){
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} if (!lastName.equals(other.lastName))
			return false;
		
		return true;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName( String firstName )
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName( String lastName )
	{
		this.lastName = lastName;
	}

	public char getState()
	{
		return state;
	}

	public void setState( char state )
	{
		this.state = state;
	}

}
