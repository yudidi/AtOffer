package design.pattern.decorator;

public class Main {
	public static void main(String[] args) {
		Person person = new Person();
		System.out.println("³¬ÈË×°°ç");
		new Tights().show();
		new Underpants().show();
	}
}
