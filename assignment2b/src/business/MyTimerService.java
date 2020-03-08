package business;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

import org.jboss.logging.Logger;

@Stateless
public class MyTimerService {

	@Resource
	TimerService timerService;

	private static final Logger logger = Logger.getLogger("business.MyTimerService");

	public MyTimerService() {

	}

	public void setTimer(long interval) {
		timerService.createTimer(interval, "My Timer");
	}

	@Timeout
	public void programmaticTimeout(Timer timer) {
		logger.info("@Timeout in programmitic timer at " + new java.util.Date());

	}
}
