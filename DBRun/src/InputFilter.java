
public class InputFilter {
	public String Filter(String input) {

		String filter3=input.replaceAll("/", "");
		String filter4=filter3.replaceAll("'", "");
		String filter5=filter4.replaceAll("=", "");
		String filter6=filter5.replaceAll("or", "");
		String output=filter6.replaceAll("true", "");
		return output;
	}
}
