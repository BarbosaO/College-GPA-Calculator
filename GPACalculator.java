package gpacalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Oscar Barbosa
 */
public class GPACalculator implements ActionListener 
{
    
    // Map to store the grades and it's equivalent points based on FIU's scale
    HashMap<String, Double> gradeScale = new HashMap<>();
    
    // The grades that inputted will be stored here
    ArrayList<String> grades = new ArrayList<>();
    
    // The texts will be stored here for easy reference 
    ArrayList<JTextField> textFields = new ArrayList<>();
    
    // The label will be stored here for easy reference
    ArrayList<JLabel> labels =  new ArrayList<>();
    

    // 
    private final JFrame frame;
    private final JPanel panel;
    private final JLabel credits, grade, gpa,cummulative, one, two, three, four, five, six,
            seven, eight, nine, ten;
    private final JButton calcButton, addRow, reset;
    private final JTextField txt, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, 
            txt10,txt11, txt12, txt13, txt14, txt15, txt16, txt17, txt18, txt19,
            txt20, totalCredits, cumGPA;
    private int count = 1;
    double pointCount = 0;
    double GPA = 0;
    int creditCount = 0;
    JComboBox box;
    
    
    public GPACalculator()
    {
        
        // Set look and field 
        try 
        {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
            {
                if ("Nimbus".equals(info.getName())) 
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException e) 
        {
        // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        
        gradeScale.put("A", 4.00);
        gradeScale.put("A-", 3.67);
        gradeScale.put("B+", 3.33);
        gradeScale.put("B", 3.00);
        gradeScale.put("B-", 2.67);
        gradeScale.put("C+", 2.33);
        gradeScale.put("C", 2.00);
        gradeScale.put("C-", 1.67);
        gradeScale.put("D+", 1.33);
        gradeScale.put("D", 1.00);
        gradeScale.put("D-", 0.67);
        gradeScale.put("F", 0.00);
        

        gradeScale.keySet().stream().forEach((key) -> {
            grades.add(key);
        });
 
        frame =  new JFrame("GPA Calculator");
        frame.setSize(600,500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panel = new JPanel(new GridBagLayout());
         
        GridBagConstraints c = new GridBagConstraints();

        credits = new JLabel("Credits");
        grade =  new JLabel("Grade");
        cummulative = new JLabel("Cummulative");
        gpa = new JLabel();
        one = new JLabel("1.");
        two = new JLabel("2.");
        three = new JLabel("3.");
        four = new JLabel("4.");
        five = new JLabel("5.");
        
        six = new JLabel("6.");
        six.setVisible(false);
        seven = new JLabel("7.");
        seven.setVisible(false); 
        
        eight = new JLabel("8.");
        eight.setVisible(false); 
        
        nine = new JLabel("9.");
        nine.setVisible(false); 
        
        ten = new JLabel("10.");
        ten.setVisible(false);
        
        labels.add(credits);
        labels.add(grade);
        labels.add(cummulative);
        labels.add(one);
        labels.add(two );
        labels.add(three);
        labels.add(four);
        labels.add(five);
        labels.add(six);
        labels.add(seven);
        labels.add(eight);
        labels.add(nine);
        labels.add(ten);
        
        
        for(int i = 0; i < labels.size(); i++)
        {
            labels.get(i).setFont(new Font("Helvetica", Font.BOLD, 20));
            labels.get(i).setForeground(Color.white); 
            
        }
       

        txt =  new JTextField(15);
        txt2 =  new JTextField(15);
        txt3 =  new JTextField(15);
        txt4 =  new JTextField(15);
        txt5 =  new JTextField(15);
        txt6 =  new JTextField(15);
        txt7 =  new JTextField(15);
        txt8 =  new JTextField(15);
        txt9 =  new JTextField(15);
        txt10 = new JTextField(15);
        
        totalCredits = new JTextField("Total Credits",15);
        cumGPA = new JTextField("Cumulative GPA", 15);
       
        totalCredits.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                totalCredits.setText("");
            }
        });
       

        cumGPA.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                cumGPA.setText("");
            }
        });
        
        
        txt11 =  new JTextField(15);
        txt11.setVisible(false);
        
        txt12 =  new JTextField(15);
        txt12.setVisible(false);
        
        txt13 =  new JTextField(15);
        txt13.setVisible(false);
        
        txt14 =  new JTextField(15);
        txt14.setVisible(false);
        
        txt15 =  new JTextField(15);
        txt15.setVisible(false);
        
        txt16 =  new JTextField(15);
        txt16.setVisible(false);
        
        txt17 =  new JTextField(15);
        txt17.setVisible(false);
        
        txt18 =  new JTextField(15);
        txt18.setVisible(false);
        
        txt19 =  new JTextField(15);
        txt19.setVisible(false);
        
        txt20 =  new JTextField(15);
        txt20.setVisible(false);
        
        textFields.add(txt);
        textFields.add(txt2);
        textFields.add(txt3);
        textFields.add(txt4);
        textFields.add(txt5);
        textFields.add(txt6);
        textFields.add(txt7);
        textFields.add(txt8);
        textFields.add(txt9);
        textFields.add(txt10);
        textFields.add(txt11);
        textFields.add(txt12);
        textFields.add(txt13);
        textFields.add(txt14);
        textFields.add(txt15);
        textFields.add(txt16);
        textFields.add(txt17);
        textFields.add(txt18);
        textFields.add(txt19);
        textFields.add(txt20);

        calcButton = new JButton("Calculate");
        calcButton.addActionListener(this);
        calcButton.setFont(new Font("Helvetica", Font.BOLD, 15));
        calcButton.setBackground(Color.WHITE);
        calcButton.setForeground(Color.BLACK);
         
        addRow = new JButton("Add Row");
        addRow.addActionListener(this);
        addRow.setFont(new Font("Helvetica", Font.BOLD, 15));
        addRow.setBackground(Color.WHITE);
        addRow.setForeground(Color.BLACK);
        
        
        reset = new JButton("Reset");
        reset.addActionListener(this);
        reset.setFont(new Font("Helvetica", Font.BOLD, 15));
        reset.setBackground(Color.WHITE);
        reset.setForeground(Color.BLACK);

        c.insets = new Insets(10,10,10,10);
        
        
        
        c.gridx = 1;
        c.gridy = 0;
        panel.add(credits, c);
        
 
        c.gridx = 3;
        c.gridy = 0;
        panel.add(grade, c);
        
        c.gridx = 4;
        c.gridy = 0;
        panel.add(cummulative, c);
         
        c.gridx = 1;
        c.gridy = 2;
        panel.add(txt, c);
         
        c.gridx = 3;
        c.gridy = 2;
        panel.add(txt2, c);
         
        c.gridx = 1;
        c.gridy = 4;
        panel.add(txt3, c);
         
        c.gridx = 3;
        c.gridy = 4;
        panel.add(txt4, c);
        
        c.gridx = 1;
        c.gridy = 6;
        panel.add(txt5, c);
        
        c.gridx = 3;
        c.gridy = 6;
        panel.add(txt6, c);
        
        c.gridx = 1;
        c.gridy = 8;
        panel.add(txt7, c);
        
        c.gridx = 3;
        c.gridy = 8;
        panel.add(txt8, c);
        
        c.gridx = 1;
        c.gridy = 10;
        panel.add(txt9, c);
        
        c.gridx = 3;
        c.gridy = 10;
        panel.add(txt10, c);
        
        c.gridx = 1;
        c.gridy = 12;
        panel.add(txt11, c);
        
        c.gridx = 3;
        c.gridy = 12;
        panel.add(txt12, c);
        
        c.gridx = 1;
        c.gridy = 14;
        panel.add(txt13, c);
        
        c.gridx = 3;
        c.gridy = 14;
        panel.add(txt14, c);
        
        c.gridx = 1;
        c.gridy = 16;
        panel.add(txt15, c);
        
        
        c.gridx = 3;
        c.gridy = 16;
        panel.add(txt16, c);
        
        c.gridx = 1;
        c.gridy = 18;
        panel.add(txt17, c);
        
        c.gridx = 3;
        c.gridy = 18;
        panel.add(txt18, c);
        
        c.gridx = 1;
        c.gridy = 20;
        panel.add(txt19, c);
        
        c.gridx = 3;
        c.gridy = 20;
        panel.add(txt20, c);
        
        c.gridx = 5;
        c.gridy = 2;
        panel.add(calcButton, c);
        
        c.gridx = 5;
        c.gridy = 4;
        panel.add(reset, c);
        
        c.gridx = 5;
        c.gridy = 6;
        panel.add(addRow, c);
        
        c.gridx = 4;
        c.gridy = 2;
        panel.add(totalCredits, c);
        
        c.gridx = 4;
        c.gridy = 4;
        panel.add(cumGPA, c);
        
        c.gridx = 4;
        c.gridy = 6;
        panel.add(gpa, c);
        
        c.gridx = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.gridy = 2;
        panel.add(one, c);
        
        c.gridx = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.gridy += 2;
        panel.add(two, c);
        
        c.gridx = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.gridy += 2;
        panel.add(three, c);
        
        c.gridx = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.gridy += 2;
        panel.add(four, c);
        
        c.gridx = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.gridy += 2;
        panel.add(five, c);
        
        c.gridx = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.gridy += 2; 
        panel.add(six, c);
        
        c.gridx = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.gridy += 2;
        panel.add(seven, c);
        
        c.gridx = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.gridy += 2;
        panel.add(eight, c);
           
        c.gridx = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.gridy += 2;
        panel.add(nine, c);
        
        c.gridx = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.gridy += 2;
        panel.add(ten, c);
        
        
         panel.setBackground(new Color(0,0,70));
         frame.add(panel, BorderLayout.NORTH);
         frame.setVisible(true);
         frame.pack();
         frame.getRootPane().setDefaultButton(calcButton);
    }
    
    public void actionPerformed(ActionEvent e) 
    {   
       if(e.getSource() instanceof JButton)
       {
           JButton button = (JButton)e.getSource();
            if(button.equals(calcButton))
            {
              
                for (String g : grades) 
                {
                   try
                   {
                     
                        if(gradeScale.containsKey(g) && txt2.getText().equalsIgnoreCase(g))
                        {
                          pointCount += gradeScale.get(g) * Double.parseDouble(txt.getText());
                          creditCount += Integer.parseInt(txt.getText());
                        }

                        if(gradeScale.containsKey(g) && txt4.getText().equalsIgnoreCase(g))
                        {
                            pointCount += gradeScale.get(g) * Double.parseDouble(txt3.getText());
                            creditCount += Integer.parseInt(txt3.getText());
                        }

                        if(gradeScale.containsKey(g) && txt6.getText().equalsIgnoreCase(g))
                        {
                            pointCount += gradeScale.get(g) * Double.parseDouble(txt5.getText());
                            creditCount += Integer.parseInt(txt5.getText());
                        }


                        if(gradeScale.containsKey(g) && txt8.getText().equalsIgnoreCase(g))
                        {
                            pointCount += gradeScale.get(g) * Double.parseDouble(txt7.getText());
                            creditCount += Integer.parseInt(txt7.getText());
                        }

                        if(gradeScale.containsKey(g) && txt10.getText().equalsIgnoreCase(g))
                        {
                            pointCount += gradeScale.get(g) * Double.parseDouble(txt9.getText());
                            creditCount += Integer.parseInt(txt9.getText());
                        }      

                        if(gradeScale.containsKey(g) && txt12.getText().equalsIgnoreCase(g))
                        {
                            pointCount += gradeScale.get(g) * Double.parseDouble(txt11.getText());
                            creditCount += Integer.parseInt(txt11.getText());
                        }

                        if(gradeScale.containsKey(g) && txt14.getText().equalsIgnoreCase(g))
                        {
                            pointCount += gradeScale.get(g) * Double.parseDouble(txt13.getText());
                            creditCount += Integer.parseInt(txt13.getText());
                        }

                        if(gradeScale.containsKey(g) && txt16.getText().equalsIgnoreCase(g))
                        {
                            pointCount += gradeScale.get(g) * Double.parseDouble(txt15.getText());
                            creditCount += Integer.parseInt(txt15.getText());
                        }

                        if(gradeScale.containsKey(g) && txt18.getText().equalsIgnoreCase(g))
                        {
                            pointCount += gradeScale.get(g) * Double.parseDouble(txt17.getText());
                            creditCount += Integer.parseInt(txt17.getText());
                        }

                        if(gradeScale.containsKey(g) && txt20.getText().equalsIgnoreCase(g))
                        {
                            pointCount += gradeScale.get(g) * Double.parseDouble(txt19.getText());
                            creditCount += Integer.parseInt(txt19.getText());
                        }
                   }
                   catch (NumberFormatException a){}
                }
                
                try
                {
                    Integer.parseInt(totalCredits.getText());
                    Double.parseDouble(cumGPA.getText());
                    
                    if(!"Total Credits".equals(totalCredits.getText()) 
                    && !"Cummulative GPA".equals(cumGPA.getText()))
                    {
                        
                        pointCount  += Integer.parseInt(totalCredits.getText())*
                        Double.parseDouble(cumGPA.getText());
                        creditCount += Integer.parseInt(totalCredits.getText());
 
                    }
                }
                catch (NumberFormatException a){}
                
                GPA = (double)Math.round((pointCount / creditCount) * 100) / 100;
                
                gpa.setFont(new Font("Helvetica", Font.BOLD, 24));
                
                if(GPA >= 3.5)
                {
                   gpa.setForeground(new Color(0, 102, 0));
                   
                }
                
                if(GPA < 3.5)
                {
                    gpa.setForeground(new Color(255,133,0));
                }
                
                if(GPA < 3.0)
                {
                    gpa.setForeground(new Color(204, 0, 0));
                }
                
                gpa.setText("GPA: " + GPA);
                pointCount = 0;
                creditCount = 0;
                GPA = 0;
                
            }
           
            else if(button.equals(addRow))
            {
                switch (count) 
                {
                    case 1:
                        txt11.setVisible(true);
                        txt11.requestFocusInWindow();
                        txt12.setVisible(true);
                        six.setVisible(true);
                        break;
                    case 2:
                        txt13.setVisible(true);
                        txt13.requestFocusInWindow();
                        txt14.setVisible(true);
                        seven.setVisible(true);
                        break;
                    case 3:
                        txt15.setVisible(true);
                        txt15.requestFocusInWindow();
                        txt16.setVisible(true);
                        eight.setVisible(true);
                        break;
                    case 4:
                        txt17.setVisible(true);
                        txt17.requestFocusInWindow();
                        txt18.setVisible(true);
                        nine.setVisible(true);
                        break;
                    case 5:
                        txt19.setVisible(true);
                        txt19.requestFocusInWindow();
                        txt20.setVisible(true);
                        ten.setVisible(true);
                        break;
                    default:
                        txt.requestFocusInWindow();
                    break;  
               }
                
            if(count >= 5)
            {
               
                count  = 0;
                addRow.setEnabled(false);
            }
       
            count++;
            frame.setVisible(true);
            frame.pack();
                 
            }

            else if(button.equals(reset))
            {
               
                for(int i = 0; i < textFields.size(); i++)
                {
                    textFields.get(i).setText("");
  
                }
                txt.requestFocusInWindow();
                txt11.setVisible(false);
                txt12.setVisible(false);
                txt13.setVisible(false);
                txt14.setVisible(false);
                txt15.setVisible(false);
                txt16.setVisible(false);
                txt17.setVisible(false);
                txt18.setVisible(false);
                txt19.setVisible(false);
                txt20.setVisible(false);
                six.setVisible(false);
                seven.setVisible(false);
                eight.setVisible(false);
                nine.setVisible(false);
                ten.setVisible(false);
                
                gpa.setText("");
                totalCredits.setText("Total Credits");
                cumGPA.setText("Cumulative GPA");
                pointCount = 0;
                creditCount = 0;
                GPA = 0;
                count = 1;
                
                addRow.setEnabled(true);
                frame.pack();
            }
       }
    }
    
    public static void main(String[] args) 
    {
        
        GPACalculator gpaCalculator = new GPACalculator();
  
    }   
    
}
