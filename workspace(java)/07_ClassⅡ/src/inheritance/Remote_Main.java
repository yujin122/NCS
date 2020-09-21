package inheritance;

import java.util.Scanner;

class Volume{
	
	int vol = 1;
	
	public void setVolume(int vol) {
		this.vol = vol;
	}
	
	public int getVol() {
		return vol;
	}
	
	void volume_up() {
		vol++;
		
		if(vol > 15) {
			vol = 15;
		}
	}

	void volume_down() {
		vol--;
		
		if(vol < 1) {
			vol = 1;
		}
	}
}

class TV extends Volume{ }

class Computer extends Volume {  }

class Radio extends Volume {  }
public class Remote_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		TV tv = new TV();
		Radio radio = new Radio();
		Computer computer = new Computer();
		
		int menu,volume;
		
		while(true) {
			System.out.print("1. TV / 2. Radio / 3. Computer / 4. 종료 >>> ");
			menu = sc.nextInt();
			
			if(menu == 4) {
				break;
			}
			
			System.out.print("1. 볼륨 Up / 2. 볼륨 Down >>> ");
			
			volume = sc.nextInt();
			
			switch(menu) {
			case 1:
				if(volume == 1)
					tv.volume_up();
				else if(volume ==2)
					tv.volume_down();
				break;
				
			case 2:
				if(volume == 1)
					radio.volume_up();
				else if(volume ==2)
					radio.volume_down();
				break;
			case 3:
				if(volume == 1)
					computer.volume_up();
				else if(volume ==2)
					computer.volume_down();
				break;
			}
			System.out.println();
			System.out.println("===========================================");
			System.out.println("TV : " + tv.getVol()+" / Radio : " + radio.getVol() + "/ Computer : " + computer.getVol());

		}
		
		System.out.println();
		System.out.println("수고하셨습니다.");
		
		sc.close();
	}
}
