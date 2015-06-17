package org.agecraft;

public abstract class Age extends ACComponent {
	
	public static Age[] ages = new Age[16];
	
	public int id;
	
	public Age(int id, String name) {
		super(name);
		this.id = id;
		
		ages[id] = this;
	}
}
