package bmicalc;

import java.util.HashMap;
import java.util.Map;

public class BMICalcAdapter implements IMCHospital{
	private BMICalcImpl bmiCalc;
	
	public BMICalcAdapter() {
		bmiCalc = new BMICalcImpl();
	}
	
	public Map<Double, String> imc(double altura, double peso){
		double bmi=bmiCalc.bmi(peso, altura);
		String category = bmiCalc.category(bmi);
		Map<Double, String> result = new HashMap<Double, String>();
		result.put(bmi, category);
		return result;
	}
	
	public boolean tieneObesidadAbdominal(char genero, double circunferencia) {
		return bmiCalc.abdominalObesity(circunferencia, genero);
	}
}
