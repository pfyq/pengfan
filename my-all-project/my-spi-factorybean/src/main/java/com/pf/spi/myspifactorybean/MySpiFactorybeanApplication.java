package com.pf.spi.myspifactorybean;

import com.pf.spi.myspifactorybean.dao.IPrint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpiFactorybeanApplication {

	public MySpiFactorybeanApplication(IPrint printProxy) {
		printProxy.execute(10, " log print ");
		printProxy.execute(0, " console print ");
	}

	public static void main(String[] args) {
		SpringApplication.run(MySpiFactorybeanApplication.class, args);
	}

}
