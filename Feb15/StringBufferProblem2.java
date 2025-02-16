public class StringBufferProblem2{
    	public static void main(String[] args) {
        	int numberOfConcatenations = 1000000;

        	long startTime = System.nanoTime();
        	StringBuffer stringBuffer = new StringBuffer();
        	for (int i = 0; i < numberOfConcatenations; i++) {
            		stringBuffer.append("hello");
        	}
        	long endTime = System.nanoTime();
        	long stringBufferTime = endTime - startTime;

        	startTime = System.nanoTime();
        	StringBuilder stringBuilder = new StringBuilder();
        	for (int i = 0; i < numberOfConcatenations; i++) {
            		stringBuilder.append("hello");
        	}
        	endTime = System.nanoTime();
        	long stringBuilderTime = endTime - startTime;

        	System.out.println("Time taken by StringBuffer: " + stringBufferTime + " nanoseconds");
        	System.out.println("Time taken by StringBuilder: " + stringBuilderTime + " nanoseconds");
    	}
}
