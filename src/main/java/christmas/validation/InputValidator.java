package christmas.validation;

import christmas.domain.ErrorMessage;
import christmas.domain.Food;
import christmas.domain.RegexPattern;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {

    private static Pattern inputFoodPatter = Pattern.compile("^[\\p{L} ]+-\\d+$");

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

    public static void validateInputFoodFormat(List<String> input){
        boolean isValidFormat = input.stream()
                .allMatch(str -> inputFoodPatter.matcher(str).matches());
        if(!isValidFormat){
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_FORMAT);
        }
    }

    public static void validateValidFood(String input){
        if(!Food.hasFood(input)){
            throw new IllegalArgumentException("[ERROR] 음식이 존재하지 않습니다.");
        }
    }

}
