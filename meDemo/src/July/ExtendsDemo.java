package July;

class Fu{
	public void show1() {
		System.out.println("fu");
	}
}
class Zi extends Fu{
	public void show2() {
		System.out.println("zi");
	}
}
public class ExtendsDemo {
	public static void main(String[] args) {
		Zi z = new Zi();
		z.show1();
		z.show2();
	}
}
