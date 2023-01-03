package hello.core.common;

public class LoggingServiceImpl implements LoggingService {
	
	private final LoggingRepo loggingRepo;
	
	public LoggingServiceImpl(LoggingRepo loggingRepo) {
		// TODO Auto-generated constructor stub
		this.loggingRepo = loggingRepo;
	}

	@Override
	public void insertLog(String insertStr) {
		// TODO Auto-generated method stub
		loggingRepo.saveLog(insertStr);
	}

	@Override
	public String printLog() {
		// TODO Auto-generated method stub
		String printStr =  loggingRepo.findLog();
		return printStr;
	}
}
