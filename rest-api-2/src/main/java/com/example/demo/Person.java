package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {
	
	    @Id
	    @GeneratedValue
	    private Long id;
	    
	    public void setId(Long id) {
			this.id = id;
		}

		private String firstName;
	    
		public Person() {
			
		}
		
		
	    public Person(String firstName, String lastName) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
		}

		private String lastName;

		public Long getId() {
			return id;
		}


		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	    
}
