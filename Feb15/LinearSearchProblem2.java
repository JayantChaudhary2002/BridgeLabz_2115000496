class LinearSearchProblem2 {
	public String searchWordInSentences(String[] sentences, String word) {
        	for (String sentence : sentences) {
            		if (sentence.contains(word)) {
                		return sentence;
            		}
        	}
        	return "Not Found";
    	}

    	public static void main(String[] args) {
        	String[] sentences = {
            		"This is a simple sentence.",
            		"Java programming is fun.",
            		"Linear search is useful.",
            		"Let's write some code.",
            		"Coding challenges are exciting!"
       		};

        	String word = "Linear";
        	LinearSearchProblem2 search = new LinearSearchProblem2();
        	String result = search.searchWordInSentences(sentences, word);
        	System.out.println(result);
    	}
}
