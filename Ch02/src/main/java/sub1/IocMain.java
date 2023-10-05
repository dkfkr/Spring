package sub1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 
 * IoC
 *  - Inversion of Control(제어의 역전)의 의미로 객체의 생성, 소멸 등 관리를 컨테이너에서 담당
 *  - 컨테이너는 일반적으로 IoC 컨데이너 즉 Spring Container를 말함
 *
 */
public class IocMain {
	public static void main(String[] args) {
		
		// 스프링 컨테이너
		ApplicationContext ctx = new GenericXmlApplicationContext("application.xml");
		
		LgTv lg = (LgTv) ctx.getBean("lg");
		
		lg.powerOn();
		lg.soundUp();
		lg.SoundDown();
		lg.powerDown();
		
		SamsungTv samsung = (SamsungTv) ctx.getBean("samsung");
		
		samsung.powerOn();
		samsung.soundUp();
		samsung.SoundDown();
		samsung.powerDown();

		
	}
}
