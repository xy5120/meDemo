package July;

public class ToMaxInt {

	/**
	 * 比较四个数的大小
	 * @param args
	 */
	public static void main(String[] args) {

		int [] arr= {20,30,24,21};
		int max=getMax(arr);
		System.out.println("最大数为:"+max);
	}

	public static int getMax(int[] arr) {
		int index=0;
		for(int x=1;x<arr.length;x++){
			if(arr[x]>arr[index]){
				index=x;
			}
		}
		return arr[index];
	}

}
