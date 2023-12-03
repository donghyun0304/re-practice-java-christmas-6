package christmas.utils;

import christmas.domain.ErrorMessage;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ErrorMessageConverter {

    public static <T> T convertToInValidOrder(Supplier<T> inputSupplier){
            try{
                inputSupplier.get();
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            } catch (IllegalStateException e){
                System.out.println(e.getMessage());
            }
            return inputSupplier.get();
    }
}
