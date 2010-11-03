public class Bsort{

	public static void main(String[] args){

		int[] x = {10, 8, 3, 30, 100, 34, 41, 92};



		for(int j = 0; j <x.length - 1; j++){

			for(int i = 0; i < x.length - 1 - j; i ++){

				if(x[i] > x[i + 1]){

					int temp = x[i];
					x[i] = x[i+1];
					x[i+1] = temp;
				}

			}
		}

		for(int a : x ){
			System.out.println(a);
		}
	}
}