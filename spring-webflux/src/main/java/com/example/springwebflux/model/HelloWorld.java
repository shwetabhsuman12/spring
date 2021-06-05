package com.example.springwebflux.model;

import java.io.Serializable;


public class HelloWorld implements Serializable{

		
	    String name;
		String greetMsg;
		
		public HelloWorld(){}
		public HelloWorld(String name,String msg) {
			this.name=name;
			this.greetMsg=msg;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGreetMsg() {
			return greetMsg;
		}
		public void setGreetMsg(String greetMsg) {
			this.greetMsg = greetMsg;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((greetMsg == null) ? 0 : greetMsg.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
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
			HelloWorld other = (HelloWorld) obj;
			if (greetMsg == null) {
				if (other.greetMsg != null)
					return false;
			} else if (!greetMsg.equals(other.greetMsg))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "HelloWorld [name=" + name + ", greetMsg=" + greetMsg + ", getName()=" + getName()
					+ ", getGreetMsg()=" + getGreetMsg() + "]";
		}
		
		
        
		
}
