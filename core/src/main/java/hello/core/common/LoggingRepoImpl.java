package hello.core.common;

import java.util.concurrent.ConcurrentHashMap;

public class LoggingRepoImpl implements LoggingRepo {


	ConcurrentHashMap<String, String> cMap = new ConcurrentHashMap<>();
	
	@Override
	public void saveLog(String logData) {
		// TODO Auto-generated method stub
		cMap.put("logData", "입력하신 Logging Data 는 "+logData+" 입니다.");
	}

	@Override
	public String findLog() {
		// TODO Auto-generated method stub
		String findLog = cMap.get("logData");
		return findLog;
	}

}
