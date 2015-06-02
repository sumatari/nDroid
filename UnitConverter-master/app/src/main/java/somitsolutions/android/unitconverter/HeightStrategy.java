
package somitsolutions.android.unitconverter;

public class HeightStrategy implements Strategy {


	public double Convert(String from, String to, double input, double input2) {
		// TODO Auto-generated method stub


		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.heightunitfeet)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.heightunitcm)))){
		//if((from.equals("feet")) && (to.equals("cm"))){

            double ret =  input * 30.48;
            double ret2 = input2 * 2.54;
            double result = ret+ ret2;


			return result ;
		}
		
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.heightunitcm)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.heightunitfeet)))){
		//if((from.equals("cm")) && (to.equals("feet"))){
			double ret = input/30.48;
			double ret2 = input2/2.54;
            double result = ret+ret2;

            return result;
		}
		

		if(from.equals(to)){
			return input;	
		}
        return 0.0;
	}


}
