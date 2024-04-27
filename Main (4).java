import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.lang.Math.pow;

//  https://www.javatpoint.com/GridLayout
//  https://youtu.be/dfhmTyRTCSQ?si=UH91LxBLKWqgSOzj
// https://stackoverflow.com/questions/4172940/how-to-set-background-color-of-a-button-in-java-gui
public class Main implements ActionListener{
    int check = 0;
    String operator;
    double result; double num1 ; double num2;
    JFrame frame = new JFrame("Calculator ");
    JButton[] numbers ;
    JButton[] function ;

    JTextField output = new JTextField();
    Font myfont = new Font("Times new roman",Font.BOLD,20);



    Main(){
        Dimension frameSize = new Dimension(1920,1080);
        frame.setSize(frameSize);
        frame.setDefaultCloseOperation(3);
        frame.setLayout(null);
        output.setBounds(50,10,1250,150);
        output.setFont(myfont);
        output.setEditable(false);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");
        JButton btn9 = new JButton("9");
        JButton btn10 = new JButton("0");
        JButton btn11 = new JButton(".");
        JButton btn12 = new JButton("+/-");
        JButton btn13 = new JButton("+");
        JButton btn14 = new JButton("*");
        JButton btn15 = new JButton("/");
        JButton btn16 = new JButton("-");
        JButton btn17 = new JButton("sqrt");
        JButton btn18 = new JButton("%");
        JButton btn19 = new JButton("^");
        JButton btn20 = new JButton("=");
        JButton btn21 = new JButton("DEL");
        JButton btn22 = new JButton("CLC");
        numbers = new JButton[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10};
        function = new JButton[]{btn11,btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20,btn21,btn22};
        for(int i=0 ; i <numbers.length;i++){
            numbers[i].addActionListener(this);
            panel1.add(numbers[i]);}
            function[0].addActionListener(this);
            function[1].addActionListener(this);
            function[10].addActionListener(this);
            function[11].addActionListener(this);


        for( int i=2;i<function.length-2;i++){
            function[i].addActionListener(this);
            panel2.add(function[i]);
        }
        panel1.add(function[0]); panel1.add(function[1]);
        panel3.add(function[10]); panel3.add(function[11]);

        panel1.setBounds(50,200,600,450);
        panel1.setLayout(new GridLayout(4,3,10,10));
        panel2.setBounds(675,200,400,450);
        panel2.setLayout(new GridLayout(4,2,10,10));
        panel3.setBounds(1100,200,200,450);
        panel3.setLayout(new GridLayout(2,1,10,10));


        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(output);

        frame.setVisible(true);

    }


    public static void main(String[] args) {
        Main calc =new Main();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++){
            if(e.getSource() == numbers[i] )
                output.setText(output.getText().concat(String.valueOf((i+1)%10)));}
        if(e.getSource() == function[0] && check == 0) {
            output.setText((output.getText().concat(".")));
            check=1;}
        if(e.getSource() == function[1]) {
            double num = Double.parseDouble(output.getText());
            num =-1*num;
            output.setText(String.valueOf(num));
        }
        if(e.getSource() == function[2]){
            operator ="+";
            num1 = Double.parseDouble(output.getText());
            output.setText("");}
        if(e.getSource() == function[3]){
            operator ="*";
            num1 = Double.parseDouble(output.getText());
            output.setText("");}
        if(e.getSource() == function[4]){
            operator ="/";
            num1 = Double.parseDouble(output.getText());
            output.setText("");}
        if(e.getSource() == function[5]){
            operator ="-";
            num1 = Double.parseDouble(output.getText());
            output.setText("");}
        if(e.getSource() == function[6]){
            double num = Double.parseDouble(output.getText());
            num =pow(num,0.5);
            output.setText(String.valueOf(num));}
        if(e.getSource() == function[7]){
            operator ="%";
            num1 = Double.parseDouble(output.getText());
            output.setText("");}
        if(e.getSource() == function[8]){
            operator ="^";
            num1 = Double.parseDouble(output.getText());
            output.setText("");}
        if(e.getSource() == function[9]){
            num2 = Double.parseDouble(output.getText());
            switch (operator){
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
                case "^":
                    result = pow(num1,num2);
                    break;
                case "%":
                    result = num1 % num2;
                    break;

            }
            output.setText(String.valueOf(result));}
        if(e.getSource() == function[10]){
            String STR =output.getText();
            output.setText("");
            for (int i=0;i<STR.length()-1;i++){
                output.setText(output.getText()+STR.charAt(i));
            }}
        if(e.getSource() == function[11]){
            output.setText("");
            num1=0;}



        }}