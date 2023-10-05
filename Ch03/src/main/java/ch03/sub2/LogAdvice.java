package ch03.sub2;

import org.springframework.stereotype.Component;

@Component
public class LogAdvice {
	
	public void beforeLog() {
		System.out.println("----------------------------");
		System.out.println("cross-cutting - beforelog...");
	}
	
	public void afterLog() {
		System.out.println("cross-cutting - afterLog...");
		System.out.println("----------------------------");
	}
	
}
