import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class LottoGUItrue extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JTextField lottotField, d3lottotField1, d3lottotField2, f3lottotField1, f3lottotField2,r3Field,rtodsField,r3dField,r3fField,r2fField,r2dField,d2lottotField,todayField;
    private JTextArea outputArea;
    private JButton addBtn, showAllBtn, checkBtn,rateBtn,rateconBtn,rateclearBtn,ran6Btn,ran3fBtn1,ran3dBtn1,ran2dBtn,ran3fBtn2,ran3dBtn2,ranallBtn,auntBtn,showauntBtn,banBtn,showbanBtn;
    private JLabel lotto6, lotto3b,h1,h2,h3,h4,h5,h6,h7,h8, lotto3f,rate3,ratetods,rate3d,rate3f,rate2f,rate2d,lotto2b,date;
    private String[] user = new String[999];
    private String[] aunt = new String[999];
    private String[] ban = new String[999];
    private String[][] nuser = new String[999][999];
    private String[][][] nmuser = new String[999][999][4];
    int xrate3 = 900,xratetods=150,xrate2d=90,xrate2f=90,xrate3d=450,xrate3f=450,year = 1,round = 1,a=0;
    private Random random = new Random();
    RateGUI rateGUI = new RateGUI();
    public LottoGUItrue() {

        super("Lotto Under Ground");

        // Set the layout of the main frame
        setLayout(new BorderLayout());

        // Create the input panel with a grid layout and add the necessary components to it
        JPanel inputPanel = new JPanel(new GridLayout(12, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lotto6 = new JLabel("Enter lotto of 6 numbers Top:");
        lottotField = new JTextField();
        h1 = new JLabel();
        h2 = new JLabel();
        h1.setVisible(false);
        h3 = new JLabel();
        h3.setVisible(false);
        h2.setVisible(false);
        h4 = new JLabel();
        h4.setVisible(false);
        h5 = new JLabel();
        h5.setVisible(false);
        h6 = new JLabel();
        h6.setVisible(false);
        h7 = new JLabel();
        h7.setVisible(false);
        h8 = new JLabel();
        h8.setVisible(false);
        lotto3f = new JLabel("Enter lotto of 3 numbers Font:");
        date = new JLabel("Year 1 lotto 1");
        f3lottotField1 = new JTextField();
        f3lottotField2 = new JTextField();

        todayField = new JTextField();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        todayField.setText(formattedDate);
        todayField.setBorder(BorderFactory.createEmptyBorder());
        todayField.setBackground(UIManager.getColor("Panel.background"));

        lotto3b = new JLabel("Enter lotto of 3 numbers Down:");
        lotto2b = new JLabel("Enter lotto of 2 numbers Down:");
        d3lottotField1 = new JTextField();
        d3lottotField2 = new JTextField();
        d2lottotField = new JTextField();

        ran6Btn = new JButton("Random lotto");
        ran6Btn.addActionListener(this);
        ran3fBtn1 = new JButton("Random 3 Font lotto ");
        ran3fBtn1.addActionListener(this);
        ran3fBtn2 = new JButton("Random 3 Font lotto ");
        ran3fBtn2.addActionListener(this);
        ran3dBtn1 = new JButton("Random 3 Down lotto ");
        ran3dBtn1.addActionListener(this);
        ran3dBtn2 = new JButton("Random 3 Down lotto ");
        ran3dBtn2.addActionListener(this);
        ran2dBtn = new JButton("Random 2 Down lotto ");
        ran2dBtn.addActionListener(this);
        ranallBtn = new JButton("Random all lotto");
        ranallBtn.addActionListener(this);

        banBtn = new JButton("Ban Number");
        banBtn.addActionListener(this);
        showbanBtn = new JButton("Show Ban Number");
        showbanBtn.addActionListener(this);

        inputPanel.add(h7);
        inputPanel.add(date);
        inputPanel.add(todayField);

        inputPanel.add(lotto6);
        inputPanel.add(lottotField);
        inputPanel.add(ran6Btn);

        inputPanel.add(lotto3f); 
        inputPanel.add(f3lottotField1);
        inputPanel.add(ran3fBtn1);
           inputPanel.add(h1);
        inputPanel.add(f3lottotField2);
        inputPanel.add(ran3fBtn2);
      
        inputPanel.add(lotto3b);
        inputPanel.add(d3lottotField1); 
        inputPanel.add(ran3dBtn1);
        inputPanel.add(h2);
        inputPanel.add(d3lottotField2);
        inputPanel.add(ran3dBtn2);
       
        inputPanel.add(lotto2b);
        inputPanel.add(d2lottotField);
        inputPanel.add(ran2dBtn);
        inputPanel.add(h3);
        inputPanel.add(h5);
        inputPanel.add(h6);
        
        

        // Create the "Add User" and "Show All Data" buttons and add them to the input panel

        auntBtn = new JButton("Aunt number");
        auntBtn.addActionListener(this);

        showauntBtn = new JButton("Show Aunt Number");
        showauntBtn.addActionListener(this);

        addBtn = new JButton("Add User");
        addBtn.addActionListener(this);
       
        showAllBtn = new JButton("Show All Data");
        showAllBtn.addActionListener(this);
        inputPanel.add(auntBtn);
        inputPanel.add(addBtn);
        inputPanel.add(banBtn);
        inputPanel.add(showauntBtn);
        inputPanel.add(showAllBtn);
        inputPanel.add(showbanBtn);

        rateBtn = new JButton("Lotto rate");
        rateBtn.addActionListener(this);
        inputPanel.add(rateBtn);

        inputPanel.add(ranallBtn);
        
        
        // Create the check panel with a border layout and add the necessary components to it
        JPanel checkPanel = new JPanel(new BorderLayout());
        checkPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        checkBtn = new JButton("Check Lotto");
        checkBtn.setPreferredSize(new Dimension(500, 200));
        checkBtn.addActionListener(this);
        

        outputArea = new JTextArea(5, 10);
        outputArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(outputArea);

        checkPanel.add(checkBtn , BorderLayout.SOUTH);
        checkPanel.add(scrollPane, BorderLayout.CENTER);

        // Add the input panel and check panel to the main frame
        add(inputPanel, BorderLayout.NORTH);
        add(checkPanel, BorderLayout.CENTER);

        // Set the size and visibility of the main frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 1000);
        setVisible(true);}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            String name = JOptionPane.showInputDialog(this, "Enter User name:");
            if (name != null) {
                String inputn;
                inputn = JOptionPane.showInputDialog(this, "Enter Number of lotto:");
                boolean inputcheck = false;
                while(isNumeric(inputn) == false|| is0(inputn)==false){
                   
                    JOptionPane.showMessageDialog(this, "Invalid input! Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
                     inputn = JOptionPane.showInputDialog(this, "Enter Number of lotto:");

                }
                
                boolean typecheck = false;
                String thongpricet = ".";
                String todspricet ="0";
                int n = Integer.parseInt(inputn);
                for (int nc = 0; nc < n; nc++) {
                    String type = "";
                    
                   
                    String c = JOptionPane.showInputDialog(this, (nc + 1) + " Please Enter 2 or 3 numbers to buy:");
                    for(int banc = 0;banc<ban.length;banc++){
                        if(c.equals(ban[banc])){
                            JOptionPane.showMessageDialog(this, "Invalid input! Please enter other number because it a ban number.", "Error", JOptionPane.ERROR_MESSAGE);
                            c = JOptionPane.showInputDialog(this, (nc + 1) + " Please Enter 2 or 3 numbers to buy:");
                        }
                    }
                    while(typecheck == false){
                        type = JOptionPane.showInputDialog(this, "choice the lotto format \n1. Thong \n2. Font \n3.Down");
                        if( type.equals("1")  == true || type.equals("2") == true || type.equals("3") == true){
                           typecheck = true;
                        }
                       }
                       typecheck = false;
                    while(isNumeric(c) == false){
                        JOptionPane.showMessageDialog(this, "Invalid input! Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
                        c = JOptionPane.showInputDialog(this, (nc + 1) + " Please Enter 2 or 3 numbers to buy:");
                    }
                    while(is0(c) == false){
                        JOptionPane.showMessageDialog(this, "Invalid input! Please enter a number more than 0.", "Error", JOptionPane.ERROR_MESSAGE);
                        c = JOptionPane.showInputDialog(this, (nc + 1) + " Please Enter 2 or 3 numbers to buy:");
                    }

                    boolean clength = false;
                    while (clength == false ) {
                        if(c.length() == 3 || c.length()== 2){
                            
                            clength = true;
                        }else{
                             JOptionPane.showMessageDialog(this, "Invalid input! Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
                        c = JOptionPane.showInputDialog(this, (nc + 1) + " Please Enter 2 or 3 numbers to buy:");
                        
                        }
                        
                    }
                    
                    boolean monneycheck = false;
                    while(monneycheck == false){
                        if(!type.equals("1")){
                        do{
                        String asktods = JOptionPane.showInputDialog(this, " how many bath do you want to play  :");
                       
                                thongpricet = asktods;
                                todspricet = "0";
                           
                           }while((isNumeric(thongpricet) == false && isNumeric(todspricet)==false) || (is0(thongpricet)==false && (is0(todspricet)==false || todspricet.equals("0")==true)));
                           monneycheck = true;
                    }else  {
                        String asktods = JOptionPane.showInputDialog(this, " how many bath do you want to play (if you want to play tods xxx*xxx):");
                        boolean fstar = false;
                        while(fstar == false){
                        if(isNumeric(asktods.substring(0,1)) == false){
                            JOptionPane.showMessageDialog(this, "Invalid input! If you want to play only tods.Please input like this 0*xxxx.", "Error", JOptionPane.ERROR_MESSAGE);

                             asktods = JOptionPane.showInputDialog(this, " how many bath do you want to play (if you want to play tods xxx*xxx):");

                        }else{
                            fstar = true;
                        }
                    }
                        
                        boolean starcheck = false;
                            int cpt = 0;
                            while(starcheck == false){
                            if((asktods.substring(cpt,(cpt+1))).equals("*")==true){
                             thongpricet = asktods.substring(0, (cpt));
                             todspricet = asktods.substring((cpt+1),asktods.length() );
                            starcheck = true;
                            }else{
                                thongpricet = asktods;
                                todspricet = "0";
                            }
                            if((cpt + 1) == asktods.length()){
                                starcheck = true;
                            }
                            cpt = cpt+1;
                           
                        }
      
                           }while((isNumeric(thongpricet) == false && isNumeric(todspricet)==false) || (is0(thongpricet)==false && (is0(todspricet)==false || todspricet.equals("0")==true)));
                           monneycheck = true; 
                    }
                    
                    if(type.equals("1")){
                        nmuser[getEmptyIndex()][nc][2] = "Thong";
                    }else if(type.equals("2")){
                        nmuser[getEmptyIndex()][nc][2] = "Font";
                    }else if(type.equals("3")){
                        nmuser[getEmptyIndex()][nc][2] = "Down";
                    }
                    nmuser[getEmptyIndex()][nc][0] = thongpricet;
                    nmuser[getEmptyIndex()][nc][1] = todspricet;
                    todspricet ="0";
                    nuser[getEmptyIndex()][nc] = c;
                }
                user[getEmptyIndex()] = name;
            }
        } else if (e.getSource() == ran6Btn){
            int lotto6n = random.nextInt(999999);
            String lotto6  = String.format("%06d", lotto6n);
            lottotField.setText( lotto6 );
        
        }else if (e.getSource() == ran3fBtn1){
            int lotto3fn1 = random.nextInt(999);
            String lotto3f1  = String.format("%03d", lotto3fn1);
            f3lottotField1.setText(lotto3f1);
        
        }else if (e.getSource() == ran3fBtn2){
            int lotto3fn2 = random.nextInt(999);
            String lotto3f2  = String.format("%03d", lotto3fn2);
            f3lottotField2.setText(lotto3f2);
        
        }else if (e.getSource() == ran3dBtn1){
            int lotto3dn1 = random.nextInt(999);
            String lotto3d1  = String.format("%03d", lotto3dn1);
            d3lottotField1.setText(lotto3d1);
        
        }else if (e.getSource() == ran3dBtn2){
            int lotto3dn2 = random.nextInt(999);
            String lotto3d2  = String.format("%03d", lotto3dn2);
            d3lottotField2.setText(lotto3d2);
        
        }else if (e.getSource() == ran2dBtn){
            int lotto2dn = random.nextInt(99);
            String lotto2d  = String.format("%02d", lotto2dn);
            d2lottotField.setText(lotto2d);
        
        }else if (e.getSource() == ranallBtn){
             int lotto6n = random.nextInt(999999);
            String lotto6  = String.format("%06d", lotto6n);
            lottotField.setText( lotto6 );
 int lotto3fn1 = random.nextInt(999);
            String lotto3f1  = String.format("%03d", lotto3fn1);
            f3lottotField1.setText(lotto3f1);
 int lotto3fn2 = random.nextInt(999);
            String lotto3f2  = String.format("%03d", lotto3fn2);
            f3lottotField2.setText(lotto3f2);
int lotto3dn1 = random.nextInt(999);
            String lotto3d1  = String.format("%03d", lotto3dn1);
            d3lottotField1.setText(lotto3d1);
int lotto3dn2 = random.nextInt(999);
            String lotto3d2  = String.format("%03d", lotto3dn2);
            d3lottotField2.setText(lotto3d2);
int lotto2dn = random.nextInt(99);
            String lotto2d  = String.format("%02d", lotto2dn);
            d2lottotField.setText(lotto2d);
        
        }else if (e.getSource() == showAllBtn) {
            outputArea.setText("");
            for (int i = 0; i < user.length; i++) {
                if (user[i] == null) continue;
                outputArea.append(user[i] + ":\n");
                for (int n = 0; n < nuser.length; n++) {
                    if (nuser[i][n] != null) {
                        outputArea.append((n + 1) + ". " + nuser[i][n] +" thong is "+ nmuser[i][n][0]+" tods is "+ nmuser[i][n][1]+ "  type of lotto is "+ nmuser[i][n][2]+"\n");
                    }
                }
            }

        } else if (e.getSource() == checkBtn) {
            
    String showresult = "";
    int summ =0; 
    int income=0;
    String lottot = lottotField.getText();
    String[] lottot3d = new String [2];
    lottot3d[0] =(d3lottotField1.getText());
    lottot3d[1] =(d3lottotField2.getText());
    String[] lottot3f = new String [2];
    lottot3f[0] =(f3lottotField1.getText());
    lottot3f[1] =(f3lottotField2.getText());
    String lottot2d =(d2lottotField.getText());
    String today = todayField.getText();
    
    if(!today.substring(0,2).equals("01") && !today.substring(0,2).equals("16")){
        JOptionPane.showMessageDialog(this, "Date of today is not  1 or 16  ", "Error", JOptionPane.ERROR_MESSAGE);

        return;
    }else{

   
    showresult += today+"\n\n";
    

    if (lottot.length() != 6) {
        JOptionPane.showMessageDialog(this, "Please Enter all lotto before click this Botton", "Error", JOptionPane.ERROR_MESSAGE);

        return;
    }

       outputArea.setText("");

    lottot = String.format("%06d", Integer.parseInt(lottot));
    String n2f = lottot.substring(4);
    String n3f = lottot.substring(3);
    String[] tods = new String[5];
    String tods1 = n3f.substring(0, 1);
    String tods2 = n3f.substring(1,2);
    String tods3 = n3f.substring(2,3);
    tods[0] = tods3+tods1+tods2;
    tods[1] = tods2+tods3+tods1;
    tods[2] = tods3+tods2+tods1;
    tods[3] = tods1+tods3+tods2;
    tods[4] = tods2+tods1+tods3;
    //int n2d = random.nextInt(98) + 1;
    
    
    int wincount = 0;
    int sumall = 0;
    for (int i = 0; i < user.length; i++) {
        
        if (user[i] == null) continue;
        showresult += user[i] + ":\n";
        user[i] = "";
        for (int n = 0; n < nuser.length; n++) {
            if (nuser[i][n] != null) {
                String lotto = nuser[i][n];
                nuser[i][n] ="";
                    String UNumber = lotto; 
                    int thongprice = Integer.parseInt(nmuser[i][n][0]);
                    int todsprice = Integer.parseInt(nmuser[i][n][1]);
                    nmuser[i][n][0] = "";
                    nmuser[i][n][1] = "";
                    income +=thongprice+todsprice;
                    for(int auntc = 0;auntc<aunt.length;auntc++){
                        if(UNumber == aunt[auntc]){
                            thongprice = thongprice/2;
                            todsprice = todsprice/2;
                        }
                    }

                   
                    if (UNumber.equals(n3f)) {
                        showresult += (n + 1) + ". " + lotto + " hit 3 Top thong "+( thongprice * xrate3)+"\n";
                        summ += (thongprice * xrate3);
                        wincount++;
                    }else {
                        for(int j = 0; j < tods.length; j++){ 
                            if (tods[j].equals(UNumber)) {
                                showresult += (n + 1) + ". " + lotto + " hit tods "+( todsprice * xratetods)+"\n";
                                summ += (todsprice * xratetods);
                                wincount++;
                                break;
                            }
                        } 
                        
                    } if (UNumber.equals(n2f)){
                        showresult += (n + 1) + ". " + lotto + " hit 2 Top thong "+( thongprice * xrate2f)+"\n";
                        summ += (thongprice * xrate2f);
                        wincount++;
                    }else if (UNumber.equals(lottot2d)){
                        showresult += (n + 1) + ". " + lotto + " hit 2 Down thong "+( thongprice * xrate2d)+"\n";
                        summ += (thongprice * xrate2d);
                        wincount++;
                    }else if (UNumber.equals(lottot3f[0])||UNumber.equals(lottot3f[1])){
                        showresult += (n + 1) + ". " + lotto + " hit 3 Font thong "+( thongprice * xrate3f)+"\n";
                        summ += (thongprice * xrate3f);
                        wincount++;
                    }else if (UNumber.equals(lottot3d[0])||UNumber.equals(lottot3d[1])){
                        showresult += (n + 1) + ". " + lotto + " hit 3 Down thong "+( thongprice * xrate3d)+"\n";
                        summ += (thongprice * xrate3d);
                        wincount++;
                    }  
                }
            }
            showresult += "\ntotal of money of this user is " + summ + "\n";
            sumall += summ;
        }
        showresult += "sum of outcome is " + sumall + "\n\n"; 
        sumall += summ;
        
        showresult += "sum of income is " + income + "\n\n\n"; 
        sumall += summ;

        if((sumall - income) > 0){
            showresult += "you have loss some profit this time "+(sumall -  income);
        }else if((sumall - income) < 0){
            showresult += "you have gain some profit this time "+(sumall -  income);
        }else{showresult += "you get as much as the cost";

        }
       
        if(wincount == 0){
            showresult += "Better luck next time\n";
        }
        
        JOptionPane.showMessageDialog(this, showresult, "Check lotto", JOptionPane.WARNING_MESSAGE);
       
        for(int aclear = 0;aclear<a;aclear++){
            aunt[aclear] = "";
        }
        for(int userclear = 0;userclear<user.length;userclear++){
            aunt[userclear] = "";
        }

        String fileName = "Year_" + year + "_lotto_" + round + ".txt";
       
        
        try {
            File file = new File(fileName);
            if (file.exists()) {
                file.delete();
            }
            
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(showresult);
            bufferedWriter.close();
            showresult = "";
            
        } catch (IOException o) {
            JOptionPane.showMessageDialog(this, "Error writing to file: " + o.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        String fileNameLotto = "Year_" + year + "_lotto_" + round + "_number_"+".txt";

        round++;
        if(round > 24){
            round = 1;
            year++;
        }
        date.setText("Year "+year+" lotto "+round);
        try {
            File file = new File(fileNameLotto);
            if (file.exists()) {
                file.delete();
            }
            
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("lotto6--lottot3--lottot2--tod.1--tod.2--tod.3--tod.4--tod.5--1lottod3--2lottod3--lottod2--1lottof3--2lottof3\n");//////////////
            bufferedWriter.write(lottot+"----"+n3f+"------"+n2f+"------"+tods[0]+"----"+tods[1]+"----"+tods[2]+"----"+tods[3]+"----"+tods[4]+"------"+lottot3d[0]+"-------"+lottot3d[1]+"-------"+lottot2d+"-------"+lottot3f[0]+"------"+lottot3f[1]);
            bufferedWriter.close();
            showresult = "";
            
        } catch (IOException o) {
            JOptionPane.showMessageDialog(this, "Error writing to file: " + o.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
    else if (e.getSource() == rateBtn){

            rateGUI.setVisible(true);
    } else if (e.getSource() == auntBtn) {

    aunt[a] = JOptionPane.showInputDialog(this, "Please enter aunt number", "Aunt Number",
            JOptionPane.QUESTION_MESSAGE);
    boolean auntcheck = false;
    while (auntcheck == false) {
         while (aunt[a].length() > 3 && aunt[a].length() < 2) { 
            JOptionPane.showMessageDialog(this, "Invalid input! Please enter a 2 or 3 digit number.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            aunt[a] = JOptionPane.showInputDialog(this, "Please enter aunt number", "Aunt Number",
                    JOptionPane.QUESTION_MESSAGE);

        }  if (isNumeric(aunt[a]) == false) {

            JOptionPane.showMessageDialog(this, "Invalid input! Please enter a number.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            aunt[a] = JOptionPane.showInputDialog(this, "Please enter aunt number", "Aunt Number",
                    JOptionPane.QUESTION_MESSAGE);

        } else {
            if (a == 0) {
                auntcheck = true;
            } else {
                int sameaunt = 0;
                boolean samecheck = false;
                while (sameaunt < a) {
                    if (aunt[sameaunt].equals(aunt[a])) {

                        JOptionPane.showMessageDialog(this, "Invalid input! Duplicate data in aunt number. ", "Error", JOptionPane.ERROR_MESSAGE);
                        aunt[a] = JOptionPane.showInputDialog(this, "Please enter aunt number", "Aunt Number",
                                JOptionPane.QUESTION_MESSAGE);

                    } else {
                        samecheck = true;
                    }
                    sameaunt++;
                }
            }
            auntcheck = true;
        }
    }
    a++;
    }else if (e.getSource() == showauntBtn){
        String Showaunt ="";
        for(int saunt = 0;saunt<aunt.length;saunt++){
            if(aunt[saunt] != null){
                Showaunt += (saunt+1)+". "+aunt[saunt]+"\n";
            }
        }
        JOptionPane.showMessageDialog(this, Showaunt, "Show aunt number", JOptionPane.INFORMATION_MESSAGE);

    }else if (e.getSource() == banBtn) {

    ban[a] = JOptionPane.showInputDialog(this, "Please enter ban number", "ban Number",
            JOptionPane.QUESTION_MESSAGE);
           
    boolean bancheck = false;
    while (bancheck == false) {
        while (ban[a].length()>3||ban[a].length() <2 ) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please enter a 2 or 3 digit number.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            ban[a] = JOptionPane.showInputDialog(this, "Please enter ban number", "ban Number",
                    JOptionPane.QUESTION_MESSAGE);

        }  if (isNumeric(ban[a]) == false) {

            JOptionPane.showMessageDialog(this, "Invalid input! Please enter a number.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            ban[a] = JOptionPane.showInputDialog(this, "Please enter ban number", "ban Number",
                    JOptionPane.QUESTION_MESSAGE);

        } else {
            if (a == 0) {
                bancheck = true;
            } else {
                int sameban = 0;
                boolean samecheck = false;
                while (sameban < a) {
                    if (ban[sameban].equals(ban[a])) {

                        JOptionPane.showMessageDialog(this, "Invalid input! Duplicate data in ban number. ", "Error", JOptionPane.ERROR_MESSAGE);
                        ban[a] = JOptionPane.showInputDialog(this, "Please enter ban number", "ban Number",
                                JOptionPane.QUESTION_MESSAGE);

                    } else {
                        samecheck = true;
                    }
                    sameban++;
                }
            }
            bancheck = true;
        }
    }
    a++;
    }else if (e.getSource() == showbanBtn){
        String Showban ="";
        for(int sban = 0;sban<ban.length;sban++){
            if(ban[sban] != null){
                Showban += (sban+1)+". "+ban[sban]+"\n";
            }
        }
        JOptionPane.showMessageDialog(this, Showban, "Show ban number", JOptionPane.INFORMATION_MESSAGE);

    }
}
    private int getEmptyIndex() {
        for (int i = 0; i < user.length; i++) {
            if (user[i] == null) {
                return i;
            }
        }
        return -1;
    }
   
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean is0(String str) {
        
            if(Double.parseDouble(str) > 0){
                return true;
            }else{
                return false;
            }
            
    }
    class RateGUI extends JFrame {
    
        public RateGUI() {
            setTitle("Rate GUI");
            setSize(425, 250);
            new GridLayout(6, 2);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLayout(new FlowLayout());
           
            rate3 = new JLabel("thong rate :");
            add(rate3);
            r3Field = new JTextField(10);
            r3Field.setText(String.valueOf(xrate3));
            add(r3Field);
    
            ratetods = new JLabel("tods rate :");
            add(ratetods);
            rtodsField = new JTextField(10);
            rtodsField.setText(String.valueOf(xratetods));
            add(rtodsField);
    
            rate3d = new JLabel("3 down rate :");
            add(rate3d);
            r3dField = new JTextField(10);
            r3dField.setText(String.valueOf(xrate3d));
            add(r3dField);
    
            rate3f = new JLabel("3 font rate :");
            add(rate3f);
            r3fField = new JTextField(10);
            r3fField.setText(String.valueOf(xrate3f));
            add(r3fField);
    
            rate2f = new JLabel("2 top rate :");
            add(rate2f);
            r2fField = new JTextField(10);
            r2fField.setText(String.valueOf(xrate2f));
            add(r2fField);
    
            rate2d = new JLabel("2 down rate :");
            add(rate2d);
            r2dField = new JTextField(10);
            r2dField.setText(String.valueOf(xrate2d));
            add(r2dField);
    
            rateconBtn = new JButton("Confirm Rate");
            rateconBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    String rate3t = r3Field.getText();
                    String ratetodst = rtodsField.getText();
                    String rate3dt = r3dField.getText();
                    String rate3ft = r3fField.getText();
                    String rate2ft = r2fField.getText();
                    String rate2dt = r2dField.getText();
                    if(isNumeric(rate3t)== true && isNumeric(ratetodst)== true && isNumeric(rate3dt)== true && isNumeric(rate3ft)== true && isNumeric(rate2ft)== true && isNumeric(rate2dt)== true ){
                    xrate3 = Integer.parseInt(rate3t); 
                    xratetods = Integer.parseInt(ratetodst);
                    xrate3d = Integer.parseInt(rate3dt);
                    xrate3f = Integer.parseInt(rate3ft);
                    xrate2f = Integer.parseInt(rate2ft);
                    xrate2d = Integer.parseInt(rate2dt);
                    }else{
                        r3Field.setText(rate3t .valueOf(xrate3));
                        rtodsField.setText(ratetodst .valueOf(xratetods));
                        r3dField.setText(rate3dt .valueOf(xrate3d));
                        r3fField.setText(rate3ft .valueOf(xrate3f));
                        r2dField.setText(rate2dt .valueOf(xrate2d));
                        r2fField.setText(rate2ft .valueOf(xrate2f));
                    }
                    
                    rateGUI.setVisible(false);
                }
            });
            add(rateconBtn);
            rateclearBtn = new JButton("Clear Rate");
            rateclearBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                      r3Field.setText("");
                      rtodsField.setText("");
                      r3dField.setText("");
                      r3fField.setText("");
                      r2fField.setText("");
                      r2dField.setText("");
                  
                }
            });
            add(rateclearBtn);
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new LottoGUItrue();
    }
}
