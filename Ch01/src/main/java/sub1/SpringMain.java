package sub1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("application.xml");
		
		if(ctx != null) {
			
			Hello hello = (Hello) ctx.getBean("hello");
			Welcome welcome = (Welcome) ctx.getBean("welcome");
			Greeting greething = (Greeting) ctx.getBean("greeting");

			hello.show();
			welcome.show();
			greething.show();
		}
		
		
	}
}
