import java.util.*;

public class p41 {
	public static void main(String[] args) {
		int largest = 0;
		boolean [] pandigital = new boolean[7];
		for (int i = 0; i < pandigital.length; i++) {
			pandigital[i] = false;
		}
		for(int i = 7000000; i < 7654321; i++)
		{
			Check_Single_section(i,pandigital,7);
			if(all_array_unanimous(pandigital,7) && is_prime(i))
				largest = i;
		}
		System.out.println(largest);
	}

	public static boolean is_prime(int num)
	{
		boolean prime = true;
		for(int i = 2 ; i< Math.sqrt(num);i++) {
			if(num % i == 0)
			{
				prime = false;
				break;
			}
		}
		if(prime)
			return true;
		return false;
		
	}
	public static boolean Check_Single_section(long temp_multiplier,boolean pandigital[],int BOUND)
	{
		while((double)temp_multiplier / 10 >= 1)
		{
			long num = (int)temp_multiplier % 10;
			temp_multiplier /= 10;
			if(num-1 < 0 || num-1 >= BOUND) {
				return false;
			}
			if(!pandigital[(int) (num-1)])
				pandigital[(int) (num-1)] = true;
			else
				return false;
		}
		if(temp_multiplier-1 >= 0 && temp_multiplier-1 < BOUND)
		{
			if(!pandigital[(int) (temp_multiplier-1)])
				pandigital[(int) (temp_multiplier-1)] = true;
			else
				return false;
			return true;
		}
		return false;
	}

	public static boolean all_array_unanimous(boolean array[],int BOUND)
	{
		boolean return_value = true;
		for (int c = 0; c < BOUND ; c++) {
			if(array[c] == true)
				continue;
			return_value = false;
		}

		for (int i = 0; i < array.length; i++) {
			array[i] = false;
		}

		return return_value;

	}
}