package hello.core.common;

public interface LoggingRepo {

	void saveLog(String logData);

	String findLog();
}
