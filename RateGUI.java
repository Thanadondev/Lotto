import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RateGUI extends JFrame {

    // Instance variables, components, and other class members
    private JLabel rate3, ratetods, rate3d, rate3f, rate2f, rate2d;
    private JTextField r3Field, rtodsField, r3dField, r3fField, r2fField, r2dField;
    private JButton rateconBtn, rateclearBtn;

    public RateGUI() {
        // Constructor code
        setTitle("Rate GUI");
        setSize(425, 250);
        new GridLayout(6, 2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        // Initialize components and add them to the layout
        rate3 = new JLabel("thong rate :");
        add(rate3);
        r3Field = new JTextField(10);
        add(r3Field);

        ratetods = new JLabel("tods rate :");
        add(ratetods);
        rtodsField = new JTextField(10);
        add(rtodsField);

        rate3d = new JLabel("3 down rate :");
        add(rate3d);
        r3dField = new JTextField(10);
        add(r3dField);

        rate3f = new JLabel("3 font rate :");
        add(rate3f);
        r3fField = new JTextField(10);
        add(r3fField);

        rate2f = new JLabel("2 top rate :");
        add(rate2f);
        r2fField = new JTextField(10);
        add(r2fField);

        rate2d = new JLabel("2 down rate :");
        add(rate2d);
        r2dField = new JTextField(10);
        add(r2dField);

        rateconBtn = new JButton("Confirm Rate");
        add(rateconBtn);

        rateclearBtn = new JButton("Clear Rate");
        add(rateclearBtn);

        // Add action listeners for rateconBtn and rateclearBtn
        rateconBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to handle rateconBtn action
                String rate3Value = r3Field.getText();
                String ratetodsValue = rtodsField.getText();
                String rate3dValue = r3dField.getText();
                String rate3fValue = r3fField.getText();
                String rate2fValue = r2fField.getText();
                String rate2dValue = r2dField.getText();
        
                // Process and store the values, or display an error message if the input is invalid
                if (validateInput(rate3Value) && validateInput(ratetodsValue) && validateInput(rate3dValue) &&
                        validateInput(rate3fValue) && validateInput(rate2fValue) && validateInput(rate2dValue)) {
                    // Store the values, for example, in an array, a file, or a database
                } else {
                    // Display an error message
                    JOptionPane.showMessageDialog(RateGUI.this, "Invalid input. Please enter only numbers.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        rateclearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to handle rateclearBtn action
                r3Field.setText("");
                rtodsField.setText("");
                r3dField.setText("");
                r3fField.setText("");
                r2fField.setText("");
                r2dField.setText("");
            }
        });

        setVisible(false);
 
    }
    private boolean validateInput(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
