package July;


import java.io.IOException;
import java.io.InputStreamReader;




public class ToEquation {

	/**编写程序，输入一个字符，判断它是否为小写字母，如果是，将它转换成大写
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		//1.输入一个字符，并判断是否为小写
		InputStreamReader isr=new InputStreamReader(System.in);
		/*try {
			isr.read();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		int ch=0;
		if((ch=isr.read())!=-1){
			if(ch>=97&&ch<=122){
				char daxie=(char)(ch-32);
				System.out.println(daxie);
			}else{
				System.out.println("输入的不是一个小写字母");
			}
		}
		isr.close();
		
	}

}
