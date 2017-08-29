package exam;

public class Test implements TestInterface{
	
	@Override
	public void printStr1() {
		
	}
	
	@Override
	public void printStr2() {
		
	}
	
	
	public void printStr3() {
		
	}
	
	public static void main(String args) {
		TestInterface ti = new Test();
		// testinterface에 선언이 되어있는 함수가 2개 이기에 2개의 함수만 불러 올 수 있다
		
	}
}
