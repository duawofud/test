package hello.core.singletonTest;

public class StatefulService {

	//private int price; //상태유지 필드
	
	public int order (String name, int price ) {
		
		System.out.println("name:"+ name + "price: "+price);
		return price;
	}
}
