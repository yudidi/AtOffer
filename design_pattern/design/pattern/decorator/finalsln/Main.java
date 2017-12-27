package design.pattern.decorator.finalsln;

public class Main {

	public static void main(String[] args) {
		Person person = new Person("xiaoming");
		Tshirt tshirt = new Tshirt();
		Tights tights = new Tights();
		Underpants underpants = new Underpants();
	
		//�b��һ:������+�ڿ�
		System.out.println("�b��һ");
		tights.decorate(person);
		underpants.decorate(tights);
		underpants.show();
		
		//װ���:����װ��: �ڿ�+T��
		System.out.println("����װ��");
		underpants.decorate(person);
		tshirt.decorate(underpants);
		tshirt.show();
	}
	
}
