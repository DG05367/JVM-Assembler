public class L2Norm {

	public static int l2norm(short[] X, short[] Y) {
		
		// Number of array elements N
		int N=4;

		int L2NORM = 0;

		for(int i=0; i<N;i++) {
			//short Aux = (short)(X[i] - Y[i]);
			short Aux = X[i] - Y[i];
			L2NORM += Aux*Aux;  
		}
		return L2NORM;
	}

}
