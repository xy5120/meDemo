package July;


import java.util.Scanner;

public class GetDays {

	/**编写程序，对输入的年、月、日，给出该天是该年的第多少天？
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入年");
		int year=sc.nextInt();
		System.out.println("请输入月");
		int mon=sc.nextInt();
		if(mon<=0||mon>12){
			throw new Exception("输入的月份不对");
		}
		System.out.println("请输入日");
		int day=sc.nextInt();
		if(day<=0||day>29){
			throw new Exception("输入的日不对");
		}
		int sum=0;
		
		for (int i = 1; i < mon; i++) {
			if(mon%2==1){
				sum+= 31;
			}else if(mon==2){
				if((year%4==0 && year%100!=0)||(year%400==0)){
					sum+= 29;
				}else{
					sum+= 28;
				}
			}else{
				sum+= 30;
			}
		}
		sum=sum+day;
		System.out.println("今天是今年的第"+sum+"天");
	}

}
