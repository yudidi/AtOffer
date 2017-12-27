package design.pattern.decorator.finalsln;

public abstract class Finery extends Person {

	private Person person;
	
	public void decorate(Person person) {
		this.person = person;
	}
	
	@Override
	public void show() {
		if (this.person != null) {
			this.person.show();
		}
	}
	
}
