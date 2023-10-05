package ch03.sub1;

/*
 *  내용 : Proxy기반 AOP 실습
 */

public class ProxyTest {
	public static void main(String[] args) {
		
		Target target = new TargetImpl();
		Target proxy = new TargetProxy(target);
		proxy.doBisiness();
		
	}
}
