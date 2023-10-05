package sub2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 
 * DI
 *  - DI:Dependency Injection은 의존성 주입을 의미하며 객체를 생성하지 않고 컨테이너로 부터 주입 받는 방식  
 *  - 생성자, 세터, 필드 3가지 방식을 가지고 있음
 *  - @Component 선언으로 객체를 컨테이너에 관리 및 등록함
 *  - @Component는 @Controller, @Service, @Repository로 세분화
 * 
 */

public class SpringContainerTest {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("application.xml");
		
		Computer com = (Computer) ctx.getBean("com");
		com.show();
		
	}
}
