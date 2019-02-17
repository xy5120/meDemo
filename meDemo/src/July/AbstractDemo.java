package July;
/*
雇员示例：
需求：公司中程序员有姓名，工号，薪水，工作内容。
项目经理除了有姓名，工号，薪水，还有奖金，工作内容。
对给出的需求进行数据建模。
 */
//公司员工中的父类
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
//员工子类
class Worker extends Company {
	Worker(String name, String number, double money) {
		super(name, number, money);
	}

	public void work() {
		System.out.println("worker");
	}
}
//项目经理子类
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
//主函数
public class AbstractDemo {
	public static void main(String[] args) {
		Worker w = new Worker("张三","002",1003);
		w.work();
	}
}
