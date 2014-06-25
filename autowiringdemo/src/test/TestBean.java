package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Required;

public class TestBean implements ITestBean {

	protected static final Log log = LogFactory.getLog(TestBean.class);

	private HelloWorld hw1;

	private HelloWorld hw2;

	private String str;

	public HelloWorld getHw1() {
		return hw1;
	}

	public HelloWorld getHw2() {
		return hw2;
	}

	public String getStr() {
		return str;
	}

	@Required
	public void setHw1(HelloWorld hw1) {
		this.hw1 = hw1;
	}

	@Required
	public void setHw2(HelloWorld hw2) {
		this.hw2 = hw2;
	}

	@Required
	public void setStr(String str) {
		this.str = str;
	}

	public void testBean() {
		if (this.hw1 != null) {
			log.info("hw1����Ϊnull!");
		}
		if (this.hw2 != null) {
			log.info("hw2����Ϊnull!");
		}
		if (this.str != null) {
			log.info("str��Ϊnull!");
		}
	}

}
