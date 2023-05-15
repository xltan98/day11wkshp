package sg.nus.iss.visa.issf.day11wkshp;


import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day11wkshpApplication {
	private static final Logger logger = LoggerFactory.getLogger(Day11wkshpApplication.class);
private static final String DEFAULT_PORT="3000";
	public static void main(String[] args) {

		logger.info("main method started.....");
		//initialize the sprng app
		SpringApplication app = new SpringApplication(Day11wkshpApplication.class);

		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
		
		//get key value from commandline and get anything with port
		List opsValues =appArgs.getOptionValues("port");

		String portNumber = null;
		//if the portnumber is not passed from the command line (if port number is not in argument)
		if (opsValues == null || opsValues.get(0)==null){
			//read port number from env variable 
			portNumber = System.getenv("PORT");

			if(portNumber ==null){
				portNumber=DEFAULT_PORT;
			}
		}else{
			//passing port number from commandline interface (CLI)
			portNumber=(String) opsValues.get(0);
		}
		if (portNumber!=null){
			//setting port number in the spring-boot config
			app.setDefaultProperties(Collections.singletonMap("server.port",portNumber));
		}

logger.info("Port number is: %d",portNumber);
//launch spring boot App

	
app.run(args);
	}

}
