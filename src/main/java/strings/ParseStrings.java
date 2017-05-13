package strings;

public class ParseStrings {

	// Using one or more delimiters. + is one more delimiters
	public static void parse(String s) {
		String[] tokens = s.split("[ .,?!]+");
		for (int i = 0; i < tokens.length; i++) {
			System.out.println(tokens[i] + "  " + i);
		}
	}

	// Parsing String with + - * / ^ space
	public static void parse2(String s) {
		String[] tokens = s.split("[+\\-*/\\^ ]+");
		for (int i = 0; i < tokens.length; i++) {
			System.out.println(tokens[i] + "  " + i);
		}
	}

	public static void main(String[] args) {
		parse("This is a sentence.  This is a question, right?  Yes!  It is.");
		parse2("2*x^3 - 4/5*y + z^2");
	}

}
