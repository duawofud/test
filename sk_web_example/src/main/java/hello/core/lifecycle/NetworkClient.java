package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient  {

		private String url;

		public NetworkClient() {
			System.out.println("---- 생성자호출 url : "+url);
		}

		public void setUrl(String url) {
			this.url = url;
		}
		
		//서비스 시작 시 호출 
		public void connect() {
			System.out.println("connect -----"+url);
		}
		
		public void call(String message) {
			System.out.println("call url:"+url+ "message:"+message);
		}
		
		//서비스 종료 시
		public void disconnect() {
			System.out.println("disconnect url:"+ url);
		}

		@PostConstruct
		public void init() throws Exception {
			// TODO Auto-generated method stub
			connect();
			call("초기화 연결 메시지");
			
		}

		@PreDestroy
		public void close() throws Exception {
			// TODO Auto-generated method stub
			disconnect();
		}
		
		
}
