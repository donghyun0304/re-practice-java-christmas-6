package christmas.validation;

import christmas.domain.ErrorMessage;
import christmas.domain.RegexPattern;

public class InputValidator {

    public static void validateOnlyNumber(String input){
        if(!RegexPattern.ONLY_NUMBER.matches(input)){
            throw new IllegalArgumentException(ErrorMessage.NOT_ALL_NUMERIC);
        }
    }

    public static void validateIncludeComma(String input){
        if(RegexPattern.NOT_INCLUDE_COMMA.matches(input)){
            throw new IllegalArgumentException(ErrorMessage.NOT_INCLUDE_COMMA);
        }
    }

}
