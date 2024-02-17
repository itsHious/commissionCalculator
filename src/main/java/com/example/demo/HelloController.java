package com.example.demo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class HelloController {
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentage = NumberFormat.getPercentInstance();
    private BigDecimal tipPercentage = new BigDecimal(0.10);
private DecimalFormat df=new DecimalFormat("#,###.00");
    @FXML
    private TextField salesvalue ;

    @FXML
    private TextField commissionvalue;
    @FXML
    private Label welcomeText;

    public Slider commissionPercentage;
    public Label sliderText;


    @FXML
    public  void onSliderChange(){

        commissionPercentage.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldnumber, Number newnumber) {
                tipPercentage = BigDecimal.valueOf(newnumber.intValue()/100.0);
            sliderText.setText(String.valueOf(percentage.format(tipPercentage)));
            }



        });


//                    tipPercentage = BigDecimal.valueOf(commissionPercentage.getValue()/100.0);
//            sliderText.setText(String.valueOf(percentage.format(tipPercentage)));


    }


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    @FXML

    public void onCalculateClick(){
BigDecimal amount = new BigDecimal(salesvalue.getText());
BigDecimal commission = amount.multiply(tipPercentage);
BigDecimal total = commission.add(amount);

        commissionvalue.setText(String.valueOf(
                df.format(commission)
        ));
    }


    public void resetFields(){
        salesvalue.setText("");
        commissionvalue.setText("");
        sliderText.setText("10%");
        commissionPercentage.adjustValue(0.10);
    }
}