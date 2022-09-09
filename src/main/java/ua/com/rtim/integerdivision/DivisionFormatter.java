package ua.com.rtim.integerdivision;

import static java.lang.System.lineSeparator;

import java.util.List;

public class DivisionFormatter {

	public static final String SPACE_DELIMITER = " ";
	public static final String HYPHEN_DELIMITER = "-";
	public static final String LOW_LINE = "_";
	public static final String PIPE_LINE = "|";

	public String format(DivisionResult result) {
		StringBuilder format = new StringBuilder();
		List<DivisionStep> subtractionSteps = result.getSteps();
		if (subtractionSteps.isEmpty()) {
			format.append("Sorry. Is not have a sense to long division this");
		} else {
			int dividendLength = intToString(result.getDividend()).length();
			int quotientLength = intToString(result.getQuotient()).length();
			int positionOfElement = (dividendLength - quotientLength);
			DivisionStep step = subtractionSteps.get(positionOfElement);
			format.append(buildHeader(result, step));
			positionOfElement++;
			format.append(buildSteps(result, positionOfElement));
		}
		return format.toString();
	}

	private String buildHeader(DivisionResult result, DivisionStep step) {
		StringBuilder format = new StringBuilder();
		format.append(LOW_LINE);
		format.append(result.getDividend());
		format.append(PIPE_LINE);
		format.append(result.getDivisor());
		format.append(lineSeparator());
		format.append(SPACE_DELIMITER);
		int dividendLength = intToString(result.getDividend()).length();
		int quotientLength = intToString(result.getQuotient()).length();
		int minuendLength = intToString(step.getMinuend()).length();
		int subtrahendLength = intToString(step.getSubtrahend()).length();
		int spaceOfSubtrahend = minuendLength - subtrahendLength;
		format.append(addSymbols(SPACE_DELIMITER, spaceOfSubtrahend));
		format.append(step.getSubtrahend());
		int spaceOfQuotient = dividendLength - minuendLength;
		format.append(addSymbols(SPACE_DELIMITER, spaceOfQuotient));
		format.append(PIPE_LINE);
		format.append(addSymbols(HYPHEN_DELIMITER, quotientLength));
		format.append(lineSeparator());
		format.append(SPACE_DELIMITER);
		format.append(addSymbols(HYPHEN_DELIMITER, minuendLength));
		format.append(addSymbols(SPACE_DELIMITER, spaceOfQuotient));
		format.append(PIPE_LINE);
		format.append(result.getQuotient());
		format.append(lineSeparator());
		return format.toString();
	}

	private String buildSteps(DivisionResult result, int positionOfElement) {
		StringBuilder format = new StringBuilder();
		List<DivisionStep> subtractionSteps = result.getSteps();
		int space = 0;
		for (int i = positionOfElement; subtractionSteps.size() > i; i++) {
			DivisionStep step = subtractionSteps.get(i);
			int minuend = step.getMinuend();
			int divisor = result.getDivisor();
			if (minuend >= divisor) {
				int minuendLength = intToString(step.getMinuend()).length();
				int spaceOfMinuend = (i + 1) - minuendLength;
				format.append(addSymbols(SPACE_DELIMITER, spaceOfMinuend));
				format.append(LOW_LINE);
				format.append(minuend);
				format.append(lineSeparator());
				int subtrahendLength = intToString(step.getSubtrahend()).length();
				int subtrahend = step.getSubtrahend();
				spaceOfMinuend++;
				int spaceOfSubtrahend = spaceOfMinuend + (minuendLength - subtrahendLength);
				format.append(addSymbols(SPACE_DELIMITER, (spaceOfSubtrahend)));
				format.append(subtrahend);
				format.append(lineSeparator());
				format.append(addSymbols(SPACE_DELIMITER, (spaceOfMinuend)));
				format.append(addSymbols(HYPHEN_DELIMITER, minuendLength));
				format.append(lineSeparator());
				space = i;
			}
		}
		format.append(buildReminder(result, space));
		return format.toString();
	}

	private String buildReminder(DivisionResult result, int space) {
		StringBuilder format = new StringBuilder();
		int remainder = result.getRemainder();
		int remainderLength = intToString(remainder).length();
		int spaceOfRemainder = space + 1 - remainderLength;
		format.append(SPACE_DELIMITER);
		format.append(addSymbols(SPACE_DELIMITER, spaceOfRemainder));
		format.append(remainder);
		return format.toString();
	}

	private String intToString(int input) {
		StringBuilder intToString = new StringBuilder();
		intToString.append(input);
		return intToString.toString();
	}

	private String addSymbols(String symbol, int length) {
		StringBuilder spaces = new StringBuilder();
		for (int i = 0; i < length; i++) {
			spaces.append(symbol);
		}
		return spaces.toString();
	}
}
