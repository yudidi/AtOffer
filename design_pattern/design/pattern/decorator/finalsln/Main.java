package design.pattern.decorator.finalsln;

public class Main {

	public static void main(String[] args) {
		Person person = new Person("xiaoming");
		Tshirt tshirt = new Tshirt();
		Tights tights = new Tights();
		Underpants underpants = new Underpants();
	
		//裝扮一:紧身衣+内裤
		System.out.println("裝扮一");
		tights.decorate(person);
		underpants.decorate(tights);
		underpants.show();
		
		//装扮二:夏日装扮: 内裤+T恤
		System.out.println("夏日装扮");
		underpants.decorate(person);
		tshirt.decorate(underpants);
		tshirt.show();
	}
	
}
