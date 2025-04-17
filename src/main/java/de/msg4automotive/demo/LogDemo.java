package de.msg4automotive.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * How to log in application.
 */
public class LogDemo {

	private static final Logger LOG = LogManager.getLogger(LogDemo.class);

	public static void main(String[] args) {
		System.out.println("Hello World!");

		LOG.trace("This Will Be Printed On Debug");
		LOG.debug("This Will Be Printed On Debug");
		LOG.info("This Will Be Printed On Info");
		LOG.warn("This Will Be Printed On Warn");
		LOG.error("This Will Be Printed On Error");
		LOG.fatal("This Will Be Printed On Fatal");

		doSomething(5);
	}

	private static void doSomething(int val) {
		LOG.debug("enter method doSomething()");
		LOG.info("val=" + val);
		LOG.warn("something happend ...");
	}
}
