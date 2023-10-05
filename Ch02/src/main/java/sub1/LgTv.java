package sub1;

import org.springframework.beans.factory.annotation.Autowired;

public class LgTv {
	
	@Autowired
	private Speaker spk;
	
	public void powerOn() {
		System.out.println("LG Tv on");
	}
	public void powerDown() {
		System.out.println("LG Tv off");
	}
	public void soundUp() {
		spk.soundUp();
	}
	public void SoundDown() {
		spk.soundDown();
	}
}
