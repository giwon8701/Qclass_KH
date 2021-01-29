
public class test04 {

	public static void main(String[] args) {
		Object[] sarr = new String[4];
		
		sarr[0] = new String("123");
		sarr[1] = String.valueOf(new Integer(456));
		// String으로 캐스팅할거라면 객체를 String으로 선언해주는 수밖에 없다.
		sarr[2] = String.valueOf(new Object());
		sarr[3] = String.valueOf(789);
		
		for(Object obj : sarr) {
			System.out.println(obj);
		}
	}
}
