package christmas.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Converter {

    public static int parseInteger(String str){
        return Integer.parseInt(str);
    }

    public static List<String> parseToStringListByDelimiter(final String str, final String delimiter){
        return Arrays.stream(str.split(delimiter))
                .collect(Collectors.toList());
    }


    //Map<T, K> 타입을 List<T> 타입으로 변환하는 메소드
    public static <K, V> List<K> parseToKeyTypeList(Map<K, V> map) {
        List<K> list = new ArrayList<>();
        for (K key : map.keySet()) {
            list.add(key);
        }
        return list;
    }

}
