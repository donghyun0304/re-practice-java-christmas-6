package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.Delimiter;
import christmas.domain.EventDate;
import christmas.domain.Food;
import christmas.dto.FoodsDto;
import christmas.utils.Converter;
import christmas.utils.InputConverter;
import christmas.utils.RetryUtil;
import christmas.validation.InputValidator;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InputView {

    public EventDate inputDate(){
        return RetryUtil.getInput(() -> {
            System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
            String input = Console.readLine();
            InputValidator.validateOnlyNumber(input);
            return EventDate.from(Converter.parseInteger(input));
        });
    }

    public FoodsDto inputMenu(){
        return RetryUtil.getInput(() -> {
            System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
            String input = Console.readLine();
            InputValidator.validateIncludeComma(input);
            List<String> foods = Converter.parseToStringListByDelimiter(input, Delimiter.COMMA);
            InputValidator.validateInputFoodFormat(foods);
            Map<String, Integer> foodAndAmount = InputConverter.parseFoods(foods);
            validateValidFood(foodAndAmount.keySet());
            validateOverZeroNumber(foodAndAmount);
            return FoodsDto.from(foodAndAmount);
        });
    }

    private void validateValidFood(Set<String> keySet){
        for(String key : keySet){
            InputValidator.validateValidFood(key);
        }
    }

    private void validateOverZeroNumber(Map<String, Integer> foodAndAmount){
        Set<Map.Entry<String, Integer>> entries = foodAndAmount.entrySet();
        for (Map.Entry<String, Integer> entry : entries){
            InputValidator.validateOverZeroNumber(entry.getKey());
        }
    }

}
