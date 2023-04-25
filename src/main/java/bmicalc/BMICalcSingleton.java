package bmicalc;

public class BMICalcSingleton {
	private static BMICalcImpl instance;
	
	private BMICalcSingleton() {}
	
	public static synchronized BMICalcImpl getInstance() {
		if (instance == null) {
			instance=new BMICalcImpl();
			}
		return instance;
	}
}
