// When there is a "//*" it stands for a code that I have written but didn't work as well as I hoped for, but I don't want to delete it as I would like to fix it.
// Using this calculator you can't calculate more than two numbers, which means that you have to press equal after every calculation between two numbers
//Since there's only two variables that are used in the calculator

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//java swings are commands that shows buttons, frame, and more that I have to use to create the calculator
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class CalculatorGUI extends JFrame 
{
    //this is the fix for the yellow line under the name of the code 'CalculatorGUI'. Which shows what version this code is 
    private static final long serialVersionUID = 1L;
    // this shows how the buttons are asambled by giving each button a number if
    // it's used as a number
    private JButton jbtNum1;
    private JButton jbtNum2;
    private JButton jbtNum3;
    private JButton jbtNum4;
    private JButton jbtNum5;
    private JButton jbtNum6;
    private JButton jbtNum7;
    private JButton jbtNum8;
    private JButton jbtNum9;
    private JButton jbtNum0;
    private JButton jbtDot;
//this shows how the buttons are asambled by giving each button a name of what it's used for and creating names/variables 
    private JButton jbtAdd;
    private JButton jbtSubtract;
    private JButton jbtMultiply;
    private JButton jbtDivide;
    private JButton jbtSquare;
    private JButton jbtSquareR;
    private JButton jbtSolve;
    private JButton jbtClear;
    private double MATH;
    private double SolveM;
    private JTextField jtfSolution;
//when the program start everything is off making it false 
    Boolean addB = false;
    Boolean subB = false;
    Boolean divB = false;
    Boolean mulB = false;
    Boolean squB = false;
    Boolean squrB = false;
//it makes the display, show numbers
//(it doesnt matter if there is numbers or anything writen within the quotation)  
    String display = "";
    
    public CalculatorGUI() 
    {
//panel 1 stands for the first panel in the calculator which shows the number pads, qith the size of the panel which is grid layout
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(6, 2));
        p1.add(jbtNum9 = new JButton("9"));
        p1.add(jbtNum8 = new JButton("8"));
        p1.add(jbtNum7 = new JButton("7"));
        p1.add(jbtNum6 = new JButton("6"));
        p1.add(jbtNum5 = new JButton("5"));
        p1.add(jbtNum4 = new JButton("4"));
        p1.add(jbtNum3 = new JButton("3"));
        p1.add(jbtNum2 = new JButton("2"));
        p1.add(jbtNum1 = new JButton("1"));
        p1.add(jbtNum0 = new JButton("0"));
        p1.add(jbtDot = new JButton("."));
        p1.add(jbtClear = new JButton("C"));
//panel 2 shows us the text messages which is where the numbers would be added, subtracted, divded, and more, meaning the callcoulation would be showen in that panel
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(jtfSolution = new JTextField(20));
        jtfSolution.setHorizontalAlignment(JTextField.RIGHT);
        jtfSolution.setEditable(false);
//panel 3 is where the mathmatical problems would be like adding and subtracting
        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(6, 1));
        p3.add(jbtAdd = new JButton("+"));
        p3.add(jbtSubtract = new JButton("-"));
        p3.add(jbtDivide = new JButton("÷"));
        p3.add(jbtMultiply = new JButton("x"));
        p3.add(jbtSolve = new JButton("="));
        p3.add(jbtSquare = new JButton("²"));
        p3.add(jbtSquareR = new JButton("√"));        
//pamel 4 is under construction (creating more advanced math symbols for the calculator)        
        //*JPanel p4 = new JPanel();
        //*p4.setLayout(new GridLayout(6,1));
        //*p4.add(jbtSquare = new JButton("²"));
        //*p4.add(jbtSquareR = new JButton("√"));

//panel 5 is just used to layout all the other panels in a clear way
        JPanel p5 = new JPanel();
        p5.setLayout(new GridLayout());
//This is the default layout manager
        p5.add(p1, BorderLayout.NORTH);
        p5.add(p2, BorderLayout.CENTER);
        p5.add(p3, BorderLayout.WEST);
        //*p5.add(p4, BorderLayout.CENTER);
        add(p5);
//action listener is a class that is responsible in handling all actions or events, like when the user clicks on a component which in this situation the buttons
//the action listener are for the number buttons. (LT = Listen To)
        jbtNum1.addActionListener(new LTOne());
        jbtNum2.addActionListener(new LTTwo());
        jbtNum3.addActionListener(new LTThree());
        jbtNum4.addActionListener(new LTFour());
        jbtNum5.addActionListener(new LTFive());
        jbtNum6.addActionListener(new LTSix());
        jbtNum7.addActionListener(new LTSeven());
        jbtNum8.addActionListener(new LTEight());
        jbtNum9.addActionListener(new LTNine());
        jbtNum0.addActionListener(new LTZero());
        jbtDot.addActionListener(new LTDot());
//the action listener are for the action buttons 
        jbtAdd.addActionListener(new LTAdd());
        jbtSubtract.addActionListener(new LTSubtract());
        jbtDivide.addActionListener(new LTDivide());
        jbtMultiply.addActionListener(new LTMultiply());
        jbtSquare.addActionListener(new LTSquare());
        jbtSquareR.addActionListener(new LTSquareR());
        jbtSolve.addActionListener(new LTSolve());
        jbtClear.addActionListener(new LTClear());
    } 
//The application for clearing the number
    class LTClear implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
//display nothing when you press clear in the calculator 
            jtfSolution.setText("");
//this makes the calculation to not impact the number that got cleared with the new number 
            addB = false;
            subB = false;
            divB = false;
            mulB = false;
            squB = false;
            squrB = false;
        }
    }
//This shows how we start the code for when we want to give a value for each product when its shown for the display
//We make a class then put the name of the product we applied to in the 80-100 lines and then give it an actionlistener so the button would continue to work
    class LTOne implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
//This shows that each time you press one of the buttons it would be showen in the text feild 
            display = jtfSolution.getText();
            jtfSolution.setText(display + "1");
        }
    }

    class LTTwo implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            display = jtfSolution.getText();
            jtfSolution.setText(display + "2");
        }
    }

    class LTThree implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            display = jtfSolution.getText();
            jtfSolution.setText(display + "3");
        }
    }

    class LTFour implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            display = jtfSolution.getText();
            jtfSolution.setText(display + "4");
        }
    }

    class LTFive implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            display = jtfSolution.getText();
            jtfSolution.setText(display + "5");
        }
    }

    class LTSix implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            display = jtfSolution.getText();
            jtfSolution.setText(display + "6");
        }
    }

    class LTSeven implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            display = jtfSolution.getText();
            jtfSolution.setText(display + "7");
        }
    }

    class LTEight implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            display = jtfSolution.getText();
            jtfSolution.setText(display + "8");
        }
    }

    class LTNine implements ActionListener 
    {
        public void actionPerformed(ActionEvent e)
        {
            display = jtfSolution.getText();
            jtfSolution.setText(display + "9");
        }
    }

    class LTZero implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            display = jtfSolution.getText();
            jtfSolution.setText(display + "0");
        }
    }

    class LTDot implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            display = jtfSolution.getText();
            jtfSolution.setText(display + ".");
        }
    }

    class LTAdd implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
    //This is used when you press the addition button the system would take it and go to the calcultaion section which is below and then the rest well be added after the two numbers are shown
            MATH = Double.parseDouble(jtfSolution.getText());
    //There is nothing that is disblaied when you click the button for each 
            jtfSolution.setText("");
    //Since the addition button is clicked then the system would change from false to true and when it's changed to true then the system would know which calculation to pick 
            addB = true;
        }
    }
    class LTSubtract implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            MATH = Double.parseDouble(jtfSolution.getText());
            jtfSolution.setText("");
            subB = true;
        }
    }

    class LTMultiply implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            MATH = Double.parseDouble(jtfSolution.getText());
            jtfSolution.setText("");
            mulB = true;
        }
    }

    class LTDivide implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            MATH = Double.parseDouble(jtfSolution.getText());
            jtfSolution.setText("");
            divB = true;
        }
    }
    
    class LTSquare implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            MATH = Double.parseDouble(jtfSolution.getText());
            jtfSolution.setText("");
            squB = true;
        }
    }

    class LTSquareR implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            MATH = Double.parseDouble(jtfSolution.getText());
            jtfSolution.setText("");
            squrB = true;
        }
    }

    class LTSolve implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
//This is what the calculation for the calculator 
            SolveM = Double.parseDouble(jtfSolution.getText());
            if (addB == true)
                SolveM = MATH + SolveM;
            else if ( subB == true)
                SolveM = MATH - SolveM;
            else if ( divB == true)
                SolveM = MATH / SolveM;
            else if ( mulB == true)
                SolveM = MATH * SolveM;
            else if (squB == true)
                SolveM = MATH * MATH;
            else if (squrB == true)
                SolveM = Math.sqrt(MATH);
//This would reset the system which would let you calculate as many numbers as you want
            jtfSolution.setText(Double.toString(SolveM));
            addB = false;
            subB = false;
            divB = false;
            mulB = false;
            //squB = false;
            //squrB = false;
        }
    }
//creating a new class to see the layout of the calculator 
    public static void main(String[] args) 
    {
//The new name is cal as its the new variable used for this class     
        CalculatorGUI calcuGUI = new CalculatorGUI();
//pack is used for everything to work as without it the code won't work since it keeps everything sized
        calcuGUI.pack();
//The location normally starts with null which stands for nothing
        calcuGUI.setLocationRelativeTo(null);
//The way to close the application is only by pressing escape 'X' on the top left
        calcuGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//You can see the application as the visiblity is true
        calcuGUI.setVisible(true);
    }
} 