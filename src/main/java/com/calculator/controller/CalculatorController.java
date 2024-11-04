package com.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @GetMapping("/add")
    public double add(@RequestParam double a, @RequestParam double b) {
        return a + b;
    }

    @GetMapping("/subtract")
    public double subtract(@RequestParam double a, @RequestParam double b) {
        return a - b;
    }

    @GetMapping("/multiply")
    public double multiply(@RequestParam double a, @RequestParam double b) {
        return a * b;
    }

    @GetMapping("/divide")
    public double divide(@RequestParam double a, @RequestParam double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    @GetMapping("/modulus")
    public double modulus(@RequestParam double a, @RequestParam double b) {
        return a % b;
    }

    @GetMapping("/power")
    public double power(@RequestParam double a, @RequestParam double b) {
        return Math.pow(a, b);
    }

    @GetMapping("/sqrt")
    public double squareRoot(@RequestParam double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot compute the square root of a negative number");
        }
        return Math.sqrt(a);
    }

    @GetMapping("/factorial")
    public long factorial(@RequestParam int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    @GetMapping("/average")
    public double average(@RequestParam double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }
}

