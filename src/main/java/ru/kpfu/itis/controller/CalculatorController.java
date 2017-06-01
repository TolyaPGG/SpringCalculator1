package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.model.Calculator;
import ru.kpfu.itis.service.CalculatorService;
import ru.kpfu.itis.validator.OperationValidator;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@SessionAttributes(types = Calculator.class)
@RequestMapping("/")
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;

    @Autowired
    OperationValidator validator;

    @RequestMapping(method = RequestMethod.GET)
    public String calculator(Model model) {
        model.addAttribute(new Calculator());
        return "calculator";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String calculate(@ModelAttribute Calculator calculator,Model model, BindingResult result) {
        validator.validate(calculator, result);
        if (result.hasErrors()) {
            return "calculator";
        }
        calculatorService.calculate(calculator);
        return "calculator";
    }
}
