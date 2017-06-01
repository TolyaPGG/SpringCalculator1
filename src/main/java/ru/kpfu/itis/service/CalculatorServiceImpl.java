package ru.kpfu.itis.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Calculator;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public void calculate(Calculator calculator) {
        String inputNumber = calculator.getInputNumber();
        String inputOperation = calculator.getInputOperation();
        String previousNumber = calculator.getPreviousNumber();
        String previousOperation = calculator.getPreviousOperation();
        double inputNum = Double.parseDouble(inputNumber);

        if (previousNumber != null && !previousNumber.trim().equals("")) {
            double previousNum = Double.parseDouble(previousNumber);
            if (previousOperation.equals("add")) {
                inputNum = previousNum + inputNum;
            } else if (previousOperation.equals("subtract")) {
                inputNum = previousNum - inputNum;
            } else if (previousOperation.equals("multiply")) {
                inputNum = previousNum * inputNum;
            } else if (previousOperation.equals("divide")) {
                inputNum = previousNum / inputNum;
            }
            calculator.setPreviousNumber(String.valueOf(inputNum));
            calculator.setResult(String.valueOf(inputNum));
        } else {
            calculator.setPreviousNumber(inputNumber);
        }
        calculator.setPreviousOperation(inputOperation);
        calculator.setInputOperation(null);
        calculator.setInputNumber(null);
    }
}
