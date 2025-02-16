class StringBufferProblem1 {
	public String concatenateStrings(String[] strings) {
        	StringBuffer sb = new StringBuffer();
        	for (String str : strings) {
            		sb.append(str);
        	}
        	return sb.toString();
    	}

    	public static void main(String[] args) {
        	String[] strings = {"Hello", " ", "World", " ", "from", " ", "StringBuffer"};
        	StringBufferProblem1 concatenator = new StringBufferProblem1();
        	String result = concatenator.concatenateStrings(strings);
        	System.out.println(result);
    }
}
