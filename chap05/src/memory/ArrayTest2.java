package memory;

public class ArrayTest2 {

	public static void main(String[] args) {

		String[] arr = {"hello", "hi", "good"};
		//배열의 값을 모두 출록
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			System.out.println(arr[i].length());
		}
	}

}