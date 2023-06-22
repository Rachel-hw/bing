package cn.calculator;

public enum CalculatorOperator {
    CLEAR,
    NEGATE ,
    POINTER ,
    DIVISION {
        @Override
        public char getOperator() {
            return '÷';
        }
    },
    MULTIPLICATION {
        @Override
        public char getOperator() {
            return '×';
        }
    },
    SUBTRACTION {
        @Override
        public char getOperator() {
            return '-';
        }
    },
    ADDITION {
        @Override
        public char getOperator() {
            return '+';
        }
    },
    EQUAlS;


    public char getOperator() {
        return 0;
    }
}
