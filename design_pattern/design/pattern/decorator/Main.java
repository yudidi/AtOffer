package design.pattern.decorator;

public class Main {
	public static void main(String[] args) {
		Person person = new Person();
		System.out.println("����װ��");
		new Tights().show();
		new Underpants().show();
	}
}
