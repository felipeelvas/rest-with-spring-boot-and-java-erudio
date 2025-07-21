package br.com.felipeelvas.controlers;

import br.com.felipeelvas.math.SimpleMath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.felipeelvas.request.converters.NumberConverter.convertToDouble;
import static br.com.felipeelvas.request.converters.NumberConverter.isNumeric;

@RestController
@RequestMapping("/math")
public class MathController {

    private final SimpleMath math = new SimpleMath(); 

    //http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedOperationException("Please set a numeric value!");
        return math.sum( convertToDouble(numberOne) , convertToDouble(numberTwo));
    }

    //http://localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedOperationException("Please set a numeric value!");
        return math.subtraction( convertToDouble(numberOne) , convertToDouble(numberTwo));
    }

    //http://localhost:8080/math/multiply/3/5
    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedOperationException("Please set a numeric value!");
        return math.multiplication( convertToDouble(numberOne) , convertToDouble(numberTwo));
    }

    //http://localhost:8080/math/division/3/5
    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedOperationException("Please set a numeric value!");
        if (convertToDouble(numberTwo) == 0)
            throw new UnsupportedOperationException("It is not possible to divide by zero!");
        return math.division( convertToDouble(numberOne) , convertToDouble(numberTwo));
    }

    //http://localhost:8080/math/mean/3/5
    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedOperationException("Please set a numeric value!");
        return math.mean( convertToDouble(numberOne) , convertToDouble(numberTwo));
    }

    //http://localhost:8080/math/squareRoot/81
    @RequestMapping("/squareRoot/{number}")
    public Double squareRoot(
            @PathVariable("number") String number
    ) throws Exception {
        if (!isNumeric(number)) throw new UnsupportedOperationException("Please set a numeric value!");
        Double numberDouble = convertToDouble(number);
        if (numberDouble < 0)
            throw new UnsupportedOperationException("It is not possible to calculate the square root of a negative number!");
        return math.squareRoot(numberDouble);
    }

}