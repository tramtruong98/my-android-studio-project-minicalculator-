package com.example.tram.minicasio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNumber;
    private TextView tvResult;
    private Button btnNumber1;
    private Button btnNumber2;
    private Button btnNumber3;
    private Button btnNumber4;
    private Button btnNumber5;
    private Button btnNumber6;
    private Button btnNumber7;
    private Button btnNumber8;
    private Button btnNumber9;
    private Button btnNumber0;
    private Button btnCong;
    private Button btnTru;
    private Button btnNhan;
    private Button btnChia;
    private Button btnPoint;
    private Button btnResult;
    private Button btnClear;
    private Button btnClearAll;
    private final String TAG = getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitWidget();
        setEventClickView();

    }
    public void InitWidget(){
        edtNumber = (EditText) findViewById(R.id.edt_input);
        tvResult = (TextView) findViewById(R.id.tv_result);
        btnNumber1 = (Button) findViewById(R.id.btnNumber1);
        btnNumber2 = (Button) findViewById(R.id.btnNumber2);
        btnNumber3 = (Button) findViewById(R.id.btnNumber3);
        btnNumber4 = (Button) findViewById(R.id.btnNumber4);
        btnNumber5 = (Button) findViewById(R.id.btnNumber5);
        btnNumber6 = (Button) findViewById(R.id.btnNumber6);
        btnNumber7 = (Button) findViewById(R.id.btnNumber7);
        btnNumber8 = (Button) findViewById(R.id.btnNumber8);
        btnNumber9 = (Button) findViewById(R.id.btnNumber9);
        btnNumber0 = (Button) findViewById(R.id.btnNumber0);
        btnCong = (Button) findViewById(R.id.btnCong);
        btnTru = (Button) findViewById(R.id.btnTru);
        btnNhan = (Button) findViewById(R.id.btnNhan);
        btnChia = (Button) findViewById(R.id.btnChia);
        btnPoint = (Button) findViewById(R.id.btnPoint);
        btnResult = (Button) findViewById(R.id.btnResult);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnClearAll = (Button) findViewById(R.id.btnClearAll);
    }
    public void setEventClickView(){
        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);
        btnNumber0.setOnClickListener(this);
        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnResult.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnClearAll.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
     switch (v.getId()){
         case R.id.btnNumber0:
             edtNumber.append("0");
             break;
         case R.id.btnNumber1:
             edtNumber.append("1");
             break;
         case R.id.btnNumber2:
             edtNumber.append("2");
             break;
         case R.id.btnNumber3:
             edtNumber.append("3");
             break;
         case R.id.btnNumber4:
             edtNumber.append("4");
             break;
         case R.id.btnNumber5:
             edtNumber.append("5");
             break;
         case R.id.btnNumber6:
             edtNumber.append("6");
             break;
         case R.id.btnNumber7:
             edtNumber.append("7");
             break;
         case R.id.btnNumber8:
             edtNumber.append("8");
             break;
         case R.id.btnNumber9:
             edtNumber.append("9");
             break;
         case R.id.btnCong:
             edtNumber.append("+");
             break;
         case R.id.btnTru:
             edtNumber.append("-");
             break;
         case R.id.btnNhan:
             edtNumber.append("*");
             break;
         case R.id.btnChia:
             edtNumber.append("/");
             break;
         case R.id.btnPoint:
             edtNumber.append(",");
             break;
         case R.id.btnClear:
             String numberAfter=deleteAnumber(edtNumber.getText().toString());
             edtNumber.setText(numberAfter);
             break;
         case R.id.btnClearAll:
             edtNumber.setText("");
             tvResult.setText("");
             break;
         case R.id.btnResult:
             DecimalFormat df = new DecimalFormat("###.#######");
             double result = 0;
             addOperation(edtNumber.getText().toString());
             addNumber(edtNumber.getText().toString());
             // Thuật toán tính toán biểu thức
             if(arrOperation.size()>=arrNumber.size() ||arrOperation.size()<1){
                 tvResult.setText("Lỗi định dạng");
             }else {
                 for (int i = 0; i < (arrNumber.size() - 1); i++) {
                     switch (arrOperation.get(i)) {
                         case "+":
                             if (i == 0) {
                                 result = arrNumber.get(i) + arrNumber.get(i + 1);
                             } else {
                                 result = result + arrNumber.get(i + 1);
                             }
                             break;
                         case "-":
                             if (i == 0) {
                                 result = arrNumber.get(i) - arrNumber.get(i + 1);
                             } else {
                                 result = result - arrNumber.get(i + 1);
                             }
                             break;
                         case "*":
                             if (i == 0) {
                                 result = arrNumber.get(i) * arrNumber.get(i + 1);
                             } else {
                                 result = result * arrNumber.get(i + 1);
                             }
                             break;
                         case "/":
                             if (i == 0) {
                                 result = arrNumber.get(i) / arrNumber.get(i + 1);
                             } else {
                                 result = result / arrNumber.get(i + 1);
                             }
                             break;
                         default:
                             break;
                     }
                 }
                 tvResult.setText(df.format(result) + "");
             }

             // tvResult.setText(df.format(result) + "");
             //  edtNumber.setText("");
             //  result = 0;
//        }
     }

    }
    //Mảng chứa các phép tính +, - , x, /
    public ArrayList<String> arrOperation;
    //Mảng chứa các số
    public ArrayList<Double> arrNumber;

    //Lấy tất cả các phép tính lưu vào mảng arrOperation
    public int addOperation(String input) {
        arrOperation = new ArrayList<>();

        char[] cArray = input.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '-':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '*':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '/':
                    arrOperation.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }
    //Lấy tất cả các số lưu vào mảng arrNumber
    public void addNumber(String stringInput) {
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while(matcher.find()){
            arrNumber.add(Double.valueOf(matcher.group(1)));



     }
    }

  
    public String deleteAnumber(String number){
        int length = number.length();
        String tem=number.substring(0,length-1);
        return tem;
    }
}
