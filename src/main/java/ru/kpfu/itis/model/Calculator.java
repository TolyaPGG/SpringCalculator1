package ru.kpfu.itis.model;

public class Calculator {
    private String inputNumber;
    private String inputOperation;
    private String previousNumber;
    private String previousOperation;
    private String result;

    public Calculator() {
    }

    public String getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    public String getInputOperation() {
        return inputOperation;
    }

    public void setInputOperation(String inputOperation) {
        this.inputOperation = inputOperation;
    }

    public String getPreviousNumber() {
        return previousNumber;
    }

    public void setPreviousNumber(String previousNumber) {
        this.previousNumber = previousNumber;
    }

    public String getPreviousOperation() {
        return previousOperation;
    }

    public void setPreviousOperation(String previousOperation) {
        this.previousOperation = previousOperation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Calculator{" + "Input Num='" + inputNumber + '\'' + ", input Op='" + inputOperation + '\'' + ", Last Num='" + previousNumber + '\'' + ", LastOp='" + previousOperation + '\'' + ", Answer='" + result + '\'' + '}';
    }
}
