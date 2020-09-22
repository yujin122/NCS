package interfaces;

interface RemoteControl{
	
	int max_volume = 10;
	int min_volume = 1;
	
	void turnOn();
	void turnOff();
	void setVolume(int volume);
}

class Audio implements RemoteControl{
	int volume;
	
	@Override
	public void turnOn() {
		System.out.println("Audio 전원을 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("Audio 전원을 끕니다.");	
	}

	@Override
	public void setVolume(int volume) {
		
		this.volume = volume;
		
		if(this.volume > max_volume) {
			this.volume = max_volume;
		}else if(this.volume < min_volume) {
			this.volume = min_volume;
		}
		
		System.out.println("현재 Audio 볼륨 >>> " + this.volume);
	}
	
}

class Computer implements RemoteControl{
	
	int volume;
	
	@Override
	public void turnOn() {
		System.out.println("Computer 전원을 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("Computer 전원을 끕니다.");	
	}

	@Override
	public void setVolume(int volume) {
		
		this.volume = volume;
		
		if(this.volume > max_volume) {
			this.volume = max_volume;
		}else if(this.volume < min_volume) {
			this.volume = min_volume;
		}
		
		System.out.println("현재 Computer 볼륨 >>> " + this.volume);
	}
}

class TV implements RemoteControl{
	
	int volume;
	
	@Override
	public void turnOn() {
		System.out.println("TV 전원을 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV 전원을 끕니다.");	
	}

	@Override
	public void setVolume(int volume) {
		
		this.volume = volume;
		
		if(this.volume > max_volume) {
			this.volume = max_volume;
		}else if(this.volume < min_volume) {
			this.volume = min_volume;
		}
		
		System.out.println("현재 TV 볼륨 >>> " + this.volume);
	}
}

public class Remote_Main {

	public static void main(String[] args) {
		Computer com = new Computer();
		TV tv = new TV();
		
		com.turnOn();
		com.setVolume(8);
		com.setVolume(12);
		com.setVolume(0);
		com.turnOff();
		
		System.out.println();
		tv.turnOn();
		tv.setVolume(6);
		tv.setVolume(17);
		tv.setVolume(2);
		tv.setVolume(0);
		tv.turnOff();
	}

}
