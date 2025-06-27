public class AreaOfTwoOverlappingRect {
	
	public static int solution(int K, int L, int M, int N, int P, int Q, int R,
	        int S) {
	    int left = Math.max(K, P);
	    int right = Math.min(M, R);
	    int bottom = Math.max(L, Q);
	    int top = Math.min(N, S);

	    if (left < right && bottom < top) {
	        int interSection = (right - left) * (top - bottom);
	        int unionArea = ((M - K) * (N - L)) + ((R - P) * (S - Q))
	                - interSection;
	        return unionArea;
	    }
	    return 0;
	}
	
	public static float solution2(float xa1, float ya1, float xa2, float ya2, float xb1, float yb1, float xb2, float yb2) {
	    float iLeft = Math.max(xa1, xb1);
	    float iRight = Math.min(xa2, xb2);
	    float iTop = Math.max(ya1, yb1);
	    float iBottom = Math.min(ya2, yb2);

	    float si = Math.max(0, iRight - iLeft) * Math.max(0, iBottom - iTop);
	    float sa = (xa2 - xa1) * (ya2 - ya1);
	    float sb = (xb2 - xb1) * (yb2 - yb1);

	    return sa + sb - si;
	}


	public static void main(String[] args) {
		// See solutions above

	}

}
