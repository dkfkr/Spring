package sub1;

import org.springframework.beans.factory.annotation.Autowired;

public class SamsungTv {
	
	@Autowired
	private Speaker spk;
	
	public void powerOn() {
		System.out.println("SamsungTv on");
	}
	public void powerDown() {
		System.out.println("SamsungTv off");
	}
	public void soundUp() {
		spk.soundUp();
	}
	public void SoundDown() {
		spk.soundDown();
	}
}
