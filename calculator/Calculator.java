package cn.calculator;

public class Calculator {
    private Double numberFirst;
    private Double numberTwo;
    private CalculatorOperator operator;
    private String currentNumberText;
    private boolean pressedDotInLast = false;

    public Calculator() {
        clear();
    }


    public String clickCode(CalculatorCode code) {
        Double number = null;
        if (this.operator == null)
            number = numberFirst;
        else
            number = numberTwo;

        String numberText = currentNumberText + code.getNumber();
        try {
            number = Double.parseDouble(numberText);
        }catch (NumberFormatException e) {
            numberText = currentNumberText;
        }
        // 根据操作符号(+-x÷)来判断当前数字是第一个数字还是第二个数字
        if (operator == null)
            numberFirst = number;
        else
            numberTwo = number;

        StringBuilder builder = new StringBuilder();

        if (operator == null) {
            builder.append(numberText);
        }
        // 如果当前存在操作符则添加操作符及第二个数字
        else  {
            builder.append(doubleWithInt(numberFirst));
            builder.append(operator.getOperator());
            builder.append(numberText);
        }
        currentNumberText = numberText;
        // 返回需要显示的字符串
        return builder.toString();
    }

    private void clear() {
        numberFirst = 0.0;
        numberTwo = 0.0;
        operator = null;
        currentNumberText = "";
    }

    public String clickOperator(CalculatorOperator operator, String numberText) {
        String result = "";
        switch (operator) {
            case CLEAR:
                clear();
                result = "";
                break;
            case NEGATE:
                result = negate();
                break;
            case POINTER:
                result = pointer();
                break;
            case DIVISION:
            case MULTIPLICATION:
            case SUBTRACTION:
            case ADDITION:
                char inputOperator = operator.getOperator();
                if (this.operator == null) {
                    result = numberText + inputOperator;
                } else {
                    char lastOperator = numberText.charAt(numberText
                            .length() - 1);
                    result = equals(numberText);
                    if (this.operator == null) {
                        result += inputOperator;

                    }else {
                        result = result.replace(lastOperator, inputOperator);
                    }

                }
                currentNumberText = "";
                this.operator = operator;
                break;
            case EQUAlS:
                result = equals(numberText);
                break;
        }

        return result;
    }

    private String negate() {
        numberFirst = -numberFirst;
        operator = null;
        return doubleWithInt(numberFirst);
    }


    private String pointer() {
        numberFirst /= 100;
        operator = null;
        return doubleWithInt(numberFirst);
    }

    private String equals(String numberText) {
        if (this.operator == null || numberTwo.equals(0.0)) {
            return numberText;
        }
        double result = 0.0;
        switch (operator) {
            case DIVISION:
                result = numberFirst / numberTwo;
                break;
            case MULTIPLICATION:
                result = numberFirst * numberTwo;
                break;
            case SUBTRACTION:
                result = numberFirst - numberTwo;
                break;
            case ADDITION:
                result = numberFirst + numberTwo;
                break;
        }

        numberFirst = result;
        operator = null;
        numberTwo = 0.0;
        currentNumberText = doubleWithInt(result);
        return doubleWithInt(numberFirst);
    }

    private String doubleWithInt(Double number) {
        boolean flag = number.longValue() == number;
        if (flag) {
            return String.valueOf(number.longValue());
        }
        return number.toString();
    }



}
