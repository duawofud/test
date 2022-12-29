package hello.core.singleton;

public class SingletonService {
	
	// 1. staitc 영역에 객체를 딱 1개만 생성 해 둔다.
	private static final SingletonService instance = new SingletonService();
	
	
	// 2, public 으로 열어서 객체 인스턴스가 필요하면 이 static 메서드 (getInstacne) 를 통해서만 조회하도록 허용한다.
	public static SingletonService getInstance() {
		return instance;
	}
	
	// 3. 생성자를 private 로 선언해서 외부에서 new 키워드로 class 객체 생성하는 걸 막는다.
	private SingletonService() {
		
	}
	
	public void login() {
		System.out.println("싱글톤 객체 로직 호출");
	}
	
	

}
