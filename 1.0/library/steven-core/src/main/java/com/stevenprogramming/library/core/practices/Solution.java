class Solution {

    private static class NodeNumber {
        private NodeNumber next;
        private int value=0;
        public NodeNumber(int n){
			this.value = n;
		}
        public void setNext(NodeNumber n){
            this.next = n;
        }
        public NodeNumber getNext(){
			return next;
		}
		public int getValue(){
			return value;
		}

    }

    public boolean validate(int[] A, int value) {
		for(int cont=0; cont < A.length; cont++){
			//System.out.printf("Value to evaluete:%d A[%d]=%d %n", value, cont, A[cont] );
			if(value == A[cont]){
				//System.out.printf(" \t\t**** ---- FOUNDValue to evaluete:%d A[%d]=%d %n", value, cont, A[cont] );
				return true;
			}
		}
		return false;
    }

	public boolean allNegative(int[] A){
		for(int cont=0; cont < A.length; cont++){
			if(A[cont] > 0){
				return false;
			}
		}
		return true;
	}
    public int solution(int[] A) {
		if(allNegative(A)){
			return 1;
		}
		NodeNumber root = null;
		NodeNumber next = null;
        for(int cont=1; cont < A.length +1; cont++){
			if(!validate(A, cont)){
				if(root == null){
					root = new NodeNumber(cont);
					next = root;
				} else {
					NodeNumber temp = new NodeNumber(cont);
					next.setNext(temp);
					next = temp;
				}
			}
		}

		if(root == null){
			return A[A.length-1] + 1;
		}
		int minor = 1;
		boolean first = true;
		while(root.getNext() != null){

			if(first){
				minor = root.getValue();
				first = false;
				root = root.getNext();
			}else{
				int temp = root.getValue();
				if(temp < minor){
					minor = temp;
				}
				root = root.getNext();
			}
		}
		if( first ){
			minor = root.getValue();
		}
		return minor;
    }
    public static void main(String[] args){
		int[] v = {1,2,3,4,6};
		Solution s = new Solution();
		System.out.println("V1 {1,2,3,4,6} = " + s.solution(v));

		int[] v2 = {1,2,3};
		System.out.println("V2 {1,2,3} = " + s.solution(v2));

		int[] v3 = {-1,-3};
		System.out.println("V3 {-1,-3} = " + s.solution(v3));

		int[] v4 = {1,2,3,4,5,6,8,9,10,-1};
		System.out.println("V4 {1,2,3,4,5,6,8,9,10,-1} = " + s.solution(v4));

		int[] v5 = {1,2,3,4,5,-8,6,8,9,10,13,14,-1};
		System.out.println("V5 {1,2,3,4,5,-8,6,8,9,10,13,14,-1} = " + s.solution(v5));

	}
}
