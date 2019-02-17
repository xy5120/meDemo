package July;
/*
 * 负数角标这种异常在java中没有定义过。
 * 对java异常的创建思路，面对对象，将负数角标进行自定义描述。并封装成对象
 * 这种自定义的描述成为自定义异常
 * 注意：继承异常体系*/
public class ExceptionDemo2 {
	public static void main(String[] args)throws FuShuIndexException {
		int[] arr=new int[3];
		Demo02 d=new Demo02();
		d.method(arr,-3);
	}
}
class Demo02{
	public int method(int [] arr,int index) throws FuShuIndexException{
		if(index>=arr.length){
			throw new ArrayIndexOutOfBoundsException("数组角标越界"+index);
		}
		if(index<0){
			throw new FuShuIndexException("数组角标不能为负数!!"+index);
		}
		return arr[index];
	}
}
class FuShuIndexException extends Exception{
	/**
	 * 负数异常体系
	 */
	private static final long serialVersionUID = 2843496294210019613L;
	FuShuIndexException(){
		
	}
	FuShuIndexException(String s){
			super(s);
	}
}