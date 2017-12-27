package design.pattern.decorator.finalsln;

public class Person {

	private String name;
	
	public Person() {
	}
	
	public Person(String name) {
		super();
		this.name = name;
	}

	public void  show() {
		System.out.println("name is "+ this.name);
	}
}
