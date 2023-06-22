package cn.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int[] btnIds = {
            R.id.btn_clear,
            R.id.btn_negate,
            R.id.btn_pointer,
            R.id.btn_division,
            R.id.btn_one,
            R.id.btn_two,
            R.id.btn_three,
            R.id.btn_multiplication,
            R.id.btn_four,
            R.id.btn_five,
            R.id.btn_six,
            R.id.btn_subtraction,
            R.id.btn_seven,
            R.id.btn_eight,
            R.id.btn_nine,
            R.id.btn_addition,
            R.id.btn_zero,
            R.id.btn_dot,
            R.id.btn_equals,
    };
    private Button[] btns;
    private TextView calContentTextView;
    private Calculator calculator;
    private ScaleTouchListener touchListener;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_calculator);
        init();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void init() {
        touchListener = new ScaleTouchListener();
        calculator = new Calculator();
        calContentTextView = (TextView) findViewById(R.id.tv_cal_content);
        Button btn;
        for (int btnId : btnIds) {
            btn = (Button) findViewById(btnId);
            btn.setOnClickListener(this);
            btn.setOnTouchListener(touchListener);
        }
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        String numberText = calContentTextView.getText().toString();
        switch (view.getId()) {
            case R.id.btn_clear:
                numberText = calculator.clickOperator(CalculatorOperator.CLEAR,  numberText);
                break;
            case R.id.btn_negate:
                numberText = calculator.clickOperator(CalculatorOperator.NEGATE, numberText);
                break;
            case R.id.btn_pointer:
                numberText = calculator.clickOperator(CalculatorOperator.POINTER, numberText);
                break;
            case R.id.btn_division:
                numberText = calculator.clickOperator(CalculatorOperator.DIVISION, numberText);
                break;
            case R.id.btn_one:
                numberText = calculator.clickCode(CalculatorCode.ONE);
                break;
            case R.id.btn_two:
                numberText = calculator.clickCode(CalculatorCode.TWO);
                break;
            case R.id.btn_three:
                numberText = calculator.clickCode(CalculatorCode.THREE);
                break;
            case R.id.btn_multiplication:
                numberText = calculator.clickOperator(CalculatorOperator.MULTIPLICATION, numberText);
                break;
            case R.id.btn_four:
                numberText = calculator.clickCode(CalculatorCode.FOUR);
                break;
            case R.id.btn_five:
                numberText = calculator.clickCode(CalculatorCode.FIVE);
                break;
            case R.id.btn_six:
                numberText = calculator.clickCode(CalculatorCode.SIX);
                break;
            case R.id.btn_subtraction:
                numberText = calculator.clickOperator(CalculatorOperator.SUBTRACTION, numberText);
                break;
            case R.id.btn_seven:
                numberText = calculator.clickCode(CalculatorCode.SEVEN);
                break;
            case R.id.btn_eight:
                numberText = calculator.clickCode(CalculatorCode.EIGHT);
                break;
            case R.id.btn_nine:
                numberText = calculator.clickCode(CalculatorCode.NINE);
                break;
            case R.id.btn_addition:
                numberText = calculator.clickOperator(CalculatorOperator.ADDITION, numberText);
                break;
            case R.id.btn_zero:
                numberText = calculator.clickCode(CalculatorCode.ZERO);
                break;
            case R.id.btn_dot:
                numberText = calculator.clickCode(CalculatorCode.DOT);
                break;
            case R.id.btn_equals:
                numberText = calculator.clickOperator(CalculatorOperator.EQUAlS, numberText);
                break;
        }
        calContentTextView.setText(numberText);
    }
}
