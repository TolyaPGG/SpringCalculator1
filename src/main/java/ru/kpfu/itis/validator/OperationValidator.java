package ru.kpfu.itis.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kpfu.itis.model.Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class OperationValidator implements Validator {
    private static Pattern pattern = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?");

    @Override
    public boolean supports(Class<?> clazz) {
        return Calculator.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Calculator calculator = (Calculator) target;
        Matcher matcher = pattern.matcher(calculator.getInputNumber());
        if (!matcher.matches()) {
            errors.rejectValue("inputNumber", "", "Enter number");
        } else if ("divide".equals(calculator.getPreviousOperation()) && Double.valueOf(calculator.getInputNumber()) == 0) {
            errors.rejectValue("inputNumber", "", "Dividing by null");
        }
    }
}
