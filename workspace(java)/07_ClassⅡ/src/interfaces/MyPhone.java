package interfaces;

interface Camera{
	
	// 사진찍는기능
	void photo();	
}

interface DMB{
	
	// TV를 보는 기능
	void viewTv();
}

interface MP3{
	
	// 음악을 듣는 기능
	void playMP3();
}


public class MyPhone implements Camera, DMB, MP3{

	@Override
	public void playMP3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewTv() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void photo() {
		// TODO Auto-generated method stub
		
	}

}
