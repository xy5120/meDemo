package July;
/*
 * �����Ǳ������쳣��java��û�ж������
 * ��java�쳣�Ĵ���˼·����Զ��󣬽������Ǳ�����Զ�������������װ�ɶ���
 * �����Զ����������Ϊ�Զ����쳣
 * ע�⣺�̳��쳣��ϵ*/
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
			throw new ArrayIndexOutOfBoundsException("����Ǳ�Խ��"+index);
		}
		if(index<0){
			throw new FuShuIndexException("����Ǳ겻��Ϊ����!!"+index);
		}
		return arr[index];
	}
}
class FuShuIndexException extends Exception{
	/**
	 * �����쳣��ϵ
	 */
	private static final long serialVersionUID = 2843496294210019613L;
	FuShuIndexException(){
		
	}
	FuShuIndexException(String s){
			super(s);
	}
}