package July;
/*
��Աʾ����
���󣺹�˾�г���Ա�����������ţ�нˮ���������ݡ�
��Ŀ������������������ţ�нˮ�����н��𣬹������ݡ�
�Ը���������������ݽ�ģ��
 */
//��˾Ա���еĸ���
abstract class Company {
	private String name;
	private String number;
	private double money;

	Company(String name, String number, double money) {
		this.name = name;
		this.number = number;
		this.money = money;
	}

	public abstract void work();

}
//Ա������
class Worker extends Company {
	Worker(String name, String number, double money) {
		super(name, number, money);
	}

	public void work() {
		System.out.println("worker");
	}
}
//��Ŀ��������
class ProjectManager extends Company {
	private double pay;

	ProjectManager(String name, String number, double money, double pay) {
		super(name, number, money);
		this.pay = pay;
	}

	public void work() {
		System.out.println("ProjectManager");
	}
}
//������
public class AbstractDemo {
	public static void main(String[] args) {
		Worker w = new Worker("����","002",1003);
		w.work();
	}
}
