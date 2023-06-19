import javax.swing.*;
import java.awt.event.*;
public class TemperatureConvertor extends JFrame {
    private JLabel lblCelsius, lblFahrenheit;
    private JTextField txtCelsius, txtFahrenheit;
    private JButton btnConvert, btnClear;
    
    public TemperatureConvertor(){
        super("Temperature Convertor");
        lblCelsius = new JLabel("Celsius");
        lblFahrenheit = new JLabel("Farenheit");
        txtCelsius = new JTextField (20);
        txtFahrenheit = new JTextField (20);
        btnConvert = new JButton("Convert");
        btnClear = new JButton("Clear");
        
        setVisible(true);
        setSize(400,200);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        lblCelsius.setBounds(20, 20, 100, 20);
        add(lblCelsius);
        txtCelsius.setBounds(20, 70, 150, 20);
        add(txtCelsius);
        lblFahrenheit.setBounds(200, 20, 100, 20);
        add(lblFahrenheit);
        txtFahrenheit.setBounds(200, 70, 150, 20);
        add(txtFahrenheit);
        btnConvert.setBounds(80, 120, 100, 20);
        add(btnConvert);
        btnClear.setBounds(240, 120, 100, 20);
        add(btnClear);
        
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCelsius.setText("");
                txtFahrenheit.setText("");
            }
        });
        
        btnConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Get the values entered
                String celsiusText = txtCelsius.getText();
                String fahrenheitText = txtFahrenheit.getText();
                
                //Check if one field is empty ehile the other isn't
                if(celsiusText.isEmpty() && !fahrenheitText.isEmpty()){
                   //Convert Fahrenheit to Celsius
                   double fahrenheit = Double.parseDouble(fahrenheitText);
                   double celsius = (fahrenheit - 32) / 1.8;
                   
                   //Set the value in the Celsius field
                   txtCelsius.setText(String.valueOf(celsius));
                }
                else if (!celsiusText.isEmpty() && fahrenheitText.isEmpty()) {
                    //Convert Celsius to Fahrenheit
                    double celsius = Double.parseDouble(celsiusText);
                    double fahrenheit = (celsius * 1.8) + 32;
                    
                    //Set the value in the Fahrenheit field
                    txtFahrenheit.setText(String.valueOf(fahrenheit));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please fill only one field!");
                }
            }
        });
    }
    
    public static void main(String[] args) {
        new TemperatureConvertor();
    }
}
