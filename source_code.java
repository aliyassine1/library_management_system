
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ali yassine
 */
public class home2 extends javax.swing.JFrame {

    /**
     * Creates new form home2
     */
    Socket socket = null;
    ObjectOutputStream out = null;
    // Print p = null;
    BufferedReader in = null;
    int count;
    int countSearch;
    int found;
    private Object SearchTable;

    public home2() {
        initComponents();
        jScrollPane6.setOpaque(false);
        jScrollPane6.getViewport().setOpaque(false);
        jScrollPane6.setBorder(null);
        jScrollPane6.setViewportBorder(null);
        aboutus.setBorder(null);
        aboutus.setBackground(new Color(0, 0, 0, 0));

    }

    private static ArrayList<String> userPass = new ArrayList<String>();
    private static ArrayList<String> userCat = new ArrayList<String>();
    private static ArrayList<String> SearchAA = new ArrayList<String>();
    private static ArrayList<String> Sear = new ArrayList<String>();
    private static ArrayList<String> userres = new ArrayList<String>();
    private static ArrayList<String> vreserve = new ArrayList<String>();
    private static ArrayList<String> vHistory = new ArrayList<String>();
    private static ArrayList<String> lib2 = new ArrayList<String>();
    private static ArrayList<String> req = new ArrayList<String>();
    String Selected1;

    String login(String Username, String Password) {
        String ans = "";

        try {
            SimpleDateFormat dat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String strDateandTime = dat.format(date);
            userPass.removeAll(userPass);

            userPass.add("ValidLogin");
            userPass.add(Username);
            userPass.add(Password);
            userPass.add(strDateandTime);
            // userPass.add("rizp");
            //userPass.add("12-12-2031");s
            //userPass.add("rizppp");
            out.writeObject(userPass);
            ans = in.readLine();
        } catch (IOException e) {
            System.out.println(e);
        }
        return ans;
    }

    String Request(String BookTitle) {
        String ans = "";

        try {
            SimpleDateFormat dat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String strDateandTime = dat.format(date);

            req.add("request");
            req.add(BookTitle);

            req.add(strDateandTime);

            out.writeObject(req);
            ans = in.readLine();
        } catch (IOException e) {
            System.out.println(e);
        }
        return ans;
    }

    String Signup(String firstname, String lastname, String UserName, String DOB, String Password) {
        String ans = "";

        try {
            SimpleDateFormat dat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String strDateandTime = dat.format(date);

            userPass.add("Signup");
            userPass.add(firstname);
            userPass.add(lastname);
            userPass.add(UserName);
            userPass.add(DOB);
            userPass.add(Password);
            userPass.add(strDateandTime);
            out.writeObject(userPass);
            ans = in.readLine();
        } catch (IOException e) {
            System.out.println(e);
        }
        return ans;
    }

    String Viewreserves() {
        String ans = "";

        try {
            SimpleDateFormat dat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String strDateandTime = dat.format(date);

            vreserve.add("ViewReserves");
            vreserve.add(strDateandTime);
            out.writeObject(vreserve);
            ans = in.readLine();
        } catch (IOException e) {
            System.out.println(e);
        }
        return ans;
    }

    String ViewHistory() {
        String ans = "";

        try {
            System.out.println('k');
            vHistory.add("ViewHistory");
            System.out.println(vHistory.toString());

            out.writeObject(vHistory);
            ans = in.readLine();
            System.out.println(ans);
        } catch (IOException e) {
            System.out.println(e);
        }
        return ans;
    }

    String Displaybooks2() {
        String ans = "";

        try {

            lib2.add("ViewBook2");

            out.writeObject(lib2);
            ans = in.readLine();
            System.out.println(ans);
            //for debugging purposes
        } catch (IOException e) {
            System.out.println(e);

        }
        return ans;
    }

    String Displaycategory(String category) {
        String ans = "";

        try {

            SimpleDateFormat dat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String strDateandTime = dat.format(date);

            userCat.add("GetCategory");
            userCat.add(category);
            userCat.add(strDateandTime);
            System.out.println(userCat.toString());
            out.writeObject(userCat);
           
            ans = in.readLine();
             userCat.removeAll(userCat);
            System.out.println(ans);
            //for debugging purposes
        } catch (IOException e) {
            System.out.println(e);

        }
        return ans;
    }

    String Reserve(String Book, String Issue_Date, String Return_date) {

        String ans = "";

        try {

            userres.add("Reserve");
            userres.add(Book);
            userres.add(Issue_Date);
            userres.add(Return_date);

            out.writeObject(userres);
            ans = in.readLine();
            System.out.println(ans);
        //for debugging purposes

        } catch (IOException e) {
            System.out.println(e);

        }
        return ans;

    }

    String SearchbyAuthor(String Searches) {
        String an = "";

        try {
            SimpleDateFormat dat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String strDateandTime = dat.format(date);

            SearchAA.add("SearchbyAuthor");
            SearchAA.add(Searches);
            SearchAA.add(strDateandTime);
            out.writeObject(SearchAA);
            an = in.readLine();
            System.out.println(ans);
            //for debugging purposes
        } catch (IOException e) {
            System.out.println(e);

        }
        return an;
    }

    String SearchbyTitle(String Searches) {
        String anw = "";

        try {
            SimpleDateFormat dat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String strDateandTime = dat.format(date);
            Sear.add("SearchbyTitle");
            Sear.add(Searches);
            Sear.add(strDateandTime);
            out.writeObject(Sear);
            anw = in.readLine();
            System.out.println(ans);
            //for debugging purposes
        } catch (IOException e) {
            System.out.println(e);

        }
        return anw;
    }

    public void addentryCategory(String server2client) {

        DefaultTableModel mod = (DefaultTableModel) this.jTable5.getModel();
        String Split[] = server2client.split("#");
        Object rows[] = new Object[5];
        int count = 0;
        while (!Split[count].equals("FINISH_Answer")) {
            String Split1[] = Split[count].split(",");
            rows[0] = Split1[0];
            System.out.println("!" + Split1[0]);

            rows[1] = Split1[1];
            System.out.println("!" + Split1[1]);
            rows[2] = Split1[2];
            System.out.println("!" + Split1[2]);
            rows[3] = Split1[3];
            System.out.println("!" + Split1[3]);
            rows[4] = Split1[4];
            System.out.println("!" + Split1[4]);
            mod.addRow(rows);
            System.out.println("!!!!!!" + Split[count]);
            count++;

        }

        System.out.println("!!!!!!" + Split[count]);
    }

    public void addentryReserves(String server2client) {

        DefaultTableModel mod = (DefaultTableModel) this.jTable4.getModel();
        String Split[] = server2client.split("#");
        Object rows[] = new Object[5];
        int count = 0; // soo awwal kabse is the problem lanshuf lesh ma32ul shi khasso b pressed event or whatever?
        while (!Split[count].equals("FINISH_Answer")) {
            String Split1[] = Split[count].split(",");
            rows[0] = Split1[0];
            System.out.println("!" + Split1[0]);

            rows[1] = Split1[1];
            System.out.println("!" + Split1[1]);
            rows[2] = Split1[2];
            System.out.println("!" + Split1[2]);
            rows[3] = Split1[3];
            System.out.println("!" + Split1[3]);
            rows[4] = Split1[4];
            System.out.println("!" + Split1[4]);

            mod.addRow(rows);
            System.out.println("!!!!!!" + Split[count]);
            count++;

        }

        System.out.println("!!!!!!" + Split[count]);
    }

    public void addentryHist(String server2client) {

        DefaultTableModel mod = (DefaultTableModel) this.jTable3.getModel();
        String Split[] = server2client.split("#");
        Object rows[] = new Object[2];
        int count = 0; // 
        while (!Split[count].equals("FINISH_Answer")) {
            String Split1[] = Split[count].split(",");
            rows[0] = Split1[0];
            System.out.println("!" + Split1[0]);

            rows[1] = Split1[1];
            System.out.println("!" + Split1[1]);

            mod.addRow(rows);
            System.out.println("!!!!!!" + Split[count]);
            count++;

        }

        System.out.println("!!!!!!" + Split[count]);
    }

    public void addentryBooks2(String server2client) {

        DefaultTableModel mod = (DefaultTableModel) this.jTable6.getModel();
        String Split[] = server2client.split("#");
        Object rows[] = new Object[3];
        int count = 0; // 
        while (!Split[count].equals("FINISH_Answer")) {
            String Split1[] = Split[count].split(",");
            rows[0] = Split1[0];
            System.out.println("!" + Split1[0]);

            rows[1] = Split1[1];
            System.out.println("!" + Split1[1]);

            rows[2] = Split1[2];
            System.out.println("!" + Split1[2]);

            mod.addRow(rows);
            System.out.println("!!!!!!" + Split[count]);
            count++;

        }

        System.out.println("!!!!!!" + Split[count]);
    }

    public void addentrytoSearchByAuthor(String server2client) {

        DefaultTableModel mod = (DefaultTableModel) this.jTable1.getModel();
        String Split[] = server2client.split("#");
        Object rows[] = new Object[6];
        int count = 0; // soo awwal kabse is the problem lanshuf lesh ma32ul shi khasso b pressed event or whatever?
        while (!Split[count].equals("FINISH_Answer")) {
            String Split1[] = Split[count].split(",");
            rows[0] = Split1[0];
            System.out.println("!" + Split1[0]);

            rows[1] = Split1[1];
            System.out.println("!" + Split1[1]);
            rows[2] = Split1[2];
            System.out.println("!" + Split1[2]);
            rows[3] = Split1[3];
            System.out.println("!" + Split1[3]);
            rows[4] = Split1[4];
            System.out.println("!" + Split1[4]);
            rows[5] = Split1[5];
            System.out.println("!" + Split1[5]);
            mod.addRow(rows);
            System.out.println("!!!!!!" + Split[count]);
            count++;

        }

        System.out.println("!!!!!!" + Split[count]);
    }

    public void addentrytoSearchByTitle(String server2client) {

        DefaultTableModel mod = (DefaultTableModel) this.jTable2.getModel();
        String Split[] = server2client.split("#");
        Object rows[] = new Object[6];
        int count = 0; // soo awwal kabse is the problem lanshuf lesh ma32ul shi khasso b pressed event or whatever?
        while (!Split[count].equals("FINISH_Answer")) {
            String Split1[] = Split[count].split(",");
            rows[0] = Split1[0];
            System.out.println("!" + Split1[0]);

            rows[1] = Split1[1];
            System.out.println("!" + Split1[1]);
            rows[2] = Split1[2];
            System.out.println("!" + Split1[2]);
            rows[3] = Split1[3];
            System.out.println("!" + Split1[3]);
            rows[4] = Split1[4];
            System.out.println("!" + Split1[4]);
            rows[5] = Split1[5];
            System.out.println("!" + Split1[5]);
            mod.addRow(rows);
            System.out.println("!!!!!!" + Split[count]);
            count++;

        }

        System.out.println("!!!!!!" + Split[count]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jMonthChooser2 = new com.toedter.calendar.JMonthChooser();
        jDayChooser2 = new com.toedter.calendar.JDayChooser();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jYearChooser2 = new com.toedter.calendar.JYearChooser();
        jLabel24 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jDialog2 = new javax.swing.JDialog();
        jPanel13 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jDialog3 = new javax.swing.JDialog();
        jPanel24 = new javax.swing.JPanel();
        loginbutton = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        jLabel55 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jDialog4 = new javax.swing.JDialog();
        jLabel65 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        lastnam = new javax.swing.JTextField();
        ans = new javax.swing.JTextField();
        firstnam = new javax.swing.JTextField();
        seqq = new javax.swing.JComboBox();
        jButton10 = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        Passwor = new javax.swing.JPasswordField();
        jLabel94 = new javax.swing.JLabel();
        male = new javax.swing.JCheckBox();
        female = new javax.swing.JCheckBox();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        usernam = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        Confirmpasswor = new javax.swing.JPasswordField();
        jLabel112 = new javax.swing.JLabel();
        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jLabel66 = new javax.swing.JLabel();
        jDialog5 = new javax.swing.JDialog();
        jPanel26 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        ans1 = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        em1 = new javax.swing.JTextField();
        us1 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        N2 = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jDialog7 = new javax.swing.JDialog();
        SearchBar = new javax.swing.JLabel();
        SearchAT = new javax.swing.JTextField();
        jPanel29 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jDialog8 = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jLabel115 = new javax.swing.JLabel();
        jDialog9 = new javax.swing.JDialog();
        jLabel85 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel86 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jLabel116 = new javax.swing.JLabel();
        jDialog10 = new javax.swing.JDialog();
        jLabel95 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton15 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jDialog11 = new javax.swing.JDialog();
        jLabel99 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        jLabel117 = new javax.swing.JLabel();
        jDialog12 = new javax.swing.JDialog();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jLabel101 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        aboutus = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jDialog13 = new javax.swing.JDialog();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton20 = new javax.swing.JButton();
        jLabel105 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jDialog14 = new javax.swing.JDialog();
        jLabel118 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jButton21 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel119 = new javax.swing.JLabel();
        jDialog15 = new javax.swing.JDialog();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        loadingnumber = new javax.swing.JLabel();
        loadingbar = new javax.swing.JProgressBar();
        jLabel122 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jDialog1.setMinimumSize(new java.awt.Dimension(795, 660));
        jDialog1.getContentPane().setLayout(null);

        jPanel7.setLayout(null);

        jPanel10.setOpaque(false);

        jLabel19.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 153, 255));
        jLabel19.setText("Book Name");

        jLabel107.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(0, 153, 255));
        jLabel107.setText("Return Date ");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-reserve-26.png"))); // NOI18N
        jButton3.setText("Reserve");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-back-arrow-26.png"))); // NOI18N
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(32, 32, 32)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel107)
                        .addGap(18, 18, 18)
                        .addComponent(jDayChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jMonthChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jYearChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel107)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jMonthChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jYearChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDayChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        jPanel7.add(jPanel10);
        jPanel10.setBounds(50, 110, 720, 520);

        jLabel24.setFont(new java.awt.Font("SimSun", 1, 46)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 153, 255));
        jLabel24.setText("Reserve a Book?");
        jPanel7.add(jLabel24);
        jLabel24.setBounds(39, 30, 400, 67);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 153, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/good one back.jpg"))); // NOI18N
        jLabel26.setText("Search a Book?");
        jLabel26.setPreferredSize(new java.awt.Dimension(1000, 800));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 814, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel11);
        jPanel11.setBounds(0, 0, 814, 808);

        jDialog1.getContentPane().add(jPanel7);
        jPanel7.setBounds(-10, 0, 790, 650);

        jDialog2.setMinimumSize(new java.awt.Dimension(1215, 660));
        jDialog2.getContentPane().setLayout(null);

        jPanel13.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel13.setForeground(new java.awt.Color(255, 255, 255));
        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel13MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel13MousePressed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 153, 255));
        jLabel27.setText("Comics");

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-ninja-turtle-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel28)
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addGap(68, 68, 68))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27)
                .addGap(29, 29, 29))
        );

        jDialog2.getContentPane().add(jPanel13);
        jPanel13.setBounds(389, 357, 209, 203);

        jLabel29.setFont(new java.awt.Font("SimSun", 1, 58)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 153, 255));
        jLabel29.setText("Categories");
        jDialog2.getContentPane().add(jLabel29);
        jLabel29.setBounds(130, 0, 340, 140);

        jPanel12.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel12.setForeground(new java.awt.Color(255, 255, 255));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel12MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel12MousePressed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 153, 255));
        jLabel30.setText("Travel");

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-trekking-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel30))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel31)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel30)
                .addGap(29, 29, 29))
        );

        jDialog2.getContentPane().add(jPanel12);
        jPanel12.setBounds(610, 357, 176, 203);

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-books-100_1.png"))); // NOI18N
        jDialog2.getContentPane().add(jLabel32);
        jLabel32.setBounds(32, 23, 135, 100);

        jPanel14.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel14.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel14MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel14MousePressed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 153, 255));
        jLabel33.setText("Romance ");

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-romance-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel34)
                .addGap(29, 29, 29)
                .addComponent(jLabel33)
                .addContainerGap())
        );

        jDialog2.getContentPane().add(jPanel14);
        jPanel14.setBounds(610, 147, 181, 203);

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-books-100.png"))); // NOI18N
        jDialog2.getContentPane().add(jLabel35);
        jLabel35.setBounds(460, 20, 100, 100);

        jPanel15.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel15.setForeground(new java.awt.Color(255, 255, 255));
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel15MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel15MousePressed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 153, 255));
        jLabel36.setText("Science  ");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 153, 255));
        jLabel37.setText("& Technology");

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-biotech-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addGap(35, 35, 35))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel36))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel36)
                .addGap(1, 1, 1)
                .addComponent(jLabel37)
                .addContainerGap())
        );

        jDialog2.getContentPane().add(jPanel15);
        jPanel15.setBounds(389, 147, 209, 203);

        jPanel16.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel16.setForeground(new java.awt.Color(255, 255, 255));
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel16MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel16MousePressed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 153, 255));
        jLabel39.setText("Cooking ");

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-chef-hat-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40)
                    .addComponent(jLabel39))
                .addGap(32, 32, 32))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel40)
                .addGap(29, 29, 29)
                .addComponent(jLabel39)
                .addContainerGap())
        );

        jDialog2.getContentPane().add(jPanel16);
        jPanel16.setBounds(971, 147, 152, 199);

        jPanel17.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel17.setForeground(new java.awt.Color(255, 255, 255));
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel17MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel17MousePressed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 153, 255));
        jLabel41.setText("Kids ");

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-brick-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel41))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel42)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel42)
                .addGap(27, 27, 27)
                .addComponent(jLabel41)
                .addContainerGap())
        );

        jDialog2.getContentPane().add(jPanel17);
        jPanel17.setBounds(32, 147, 173, 202);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-back-arrow-26.png"))); // NOI18N
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jDialog2.getContentPane().add(jButton5);
        jButton5.setBounds(1019, 578, 90, 35);

        jPanel18.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel18.setForeground(new java.awt.Color(255, 255, 255));
        jPanel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel18MousePressed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 153, 255));
        jLabel43.setText("Arts ");

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-rock-music-100_1.png"))); // NOI18N

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(0, 153, 255));
        jLabel106.setText("& Music");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel44))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel43))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel106)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel106)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jDialog2.getContentPane().add(jPanel18);
        jPanel18.setBounds(32, 357, 167, 203);

        jPanel19.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel19.setForeground(new java.awt.Color(255, 255, 255));
        jPanel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel19MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel19MousePressed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 153, 255));
        jLabel45.setText("Lifestyle ");

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-dumbbell-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addGap(9, 9, 9)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel46)
                .addGap(18, 18, 18)
                .addComponent(jLabel45)
                .addContainerGap())
        );

        jDialog2.getContentPane().add(jPanel19);
        jPanel19.setBounds(798, 147, 155, 203);

        jPanel20.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel20.setForeground(new java.awt.Color(255, 255, 255));
        jPanel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel20MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel20MousePressed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 153, 255));
        jLabel47.setText("Novels ");

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-literature-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel48))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel47)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel47)
                .addGap(28, 28, 28))
        );

        jDialog2.getContentPane().add(jPanel20);
        jPanel20.setBounds(217, 357, 154, 203);

        jPanel21.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel21.setForeground(new java.awt.Color(255, 255, 255));
        jPanel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel21MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel21MousePressed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 153, 255));
        jLabel49.setText("Biographies");

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-resume-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50)
                    .addComponent(jLabel49))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel50)
                .addGap(18, 18, 18)
                .addComponent(jLabel49)
                .addGap(24, 24, 24))
        );

        jDialog2.getContentPane().add(jPanel21);
        jPanel21.setBounds(223, 147, 153, 203);

        jPanel22.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel22.setForeground(new java.awt.Color(255, 255, 255));
        jPanel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel22MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel22MousePressed(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 153, 255));
        jLabel51.setText("Medical");

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-clinic-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addGap(13, 13, 13)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel52)
                .addGap(18, 18, 18)
                .addComponent(jLabel51)
                .addGap(26, 26, 26))
        );

        jDialog2.getContentPane().add(jPanel22);
        jPanel22.setBounds(971, 357, 153, 203);

        jPanel23.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel23.setForeground(new java.awt.Color(255, 255, 255));
        jPanel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel23MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel23MousePressed(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 153, 255));
        jLabel53.setText("Fiction");

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-alien-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel54))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel53)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel54)
                .addGap(18, 18, 18)
                .addComponent(jLabel53)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jDialog2.getContentPane().add(jPanel23);
        jPanel23.setBounds(798, 357, 155, 203);

        jDialog3.setMinimumSize(new java.awt.Dimension(841, 520));
        jDialog3.getContentPane().setLayout(null);

        jPanel24.setForeground(new java.awt.Color(0, 204, 255));
        jPanel24.setOpaque(false);

        loginbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-login-20.png"))); // NOI18N
        loginbutton.setText("Login");
        loginbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbuttonActionPerformed(evt);
            }
        });

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 153, 255));
        jLabel55.setText("Password");

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 153, 255));
        jLabel56.setText("Username");

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-add-user-male-20.png"))); // NOI18N
        jButton7.setText("Signup");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 153, 255));
        jLabel57.setText("Trouble login?");

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-forgot-password-19.png"))); // NOI18N
        jButton8.setText("Forgot password");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel24Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(loginbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel24Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel57)
                        .addGap(28, 28, 28)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jDialog3.getContentPane().add(jPanel24);
        jPanel24.setBounds(410, 20, 380, 340);

        jLabel58.setFont(new java.awt.Font("Trebuchet MS", 0, 58)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 153, 255));
        jLabel58.setText("Login");
        jDialog3.getContentPane().add(jLabel58);
        jLabel58.setBounds(10, 10, 230, 78);

        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-user-male-35_1.png"))); // NOI18N
        jDialog3.getContentPane().add(jLabel109);
        jLabel109.setBounds(780, 130, 50, 40);

        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-lock-36.png"))); // NOI18N
        jDialog3.getContentPane().add(jLabel108);
        jLabel108.setBounds(780, 175, 36, 36);

        jLabel59.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ali yassine\\Documents\\NetBeansProjects\\Library management system project\\src\\good backround.png")); // NOI18N
        jDialog3.getContentPane().add(jLabel59);
        jLabel59.setBounds(0, -40, 860, 550);

        jDialog4.setMinimumSize(new java.awt.Dimension(1210, 850));
        jDialog4.getContentPane().setLayout(null);

        jLabel65.setFont(new java.awt.Font("Trebuchet MS", 0, 58)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(0, 153, 255));
        jLabel65.setText("New Account");
        jDialog4.getContentPane().add(jLabel65);
        jLabel65.setBounds(10, 0, 470, 140);

        jPanel25.setOpaque(false);
        jPanel25.setLayout(null);

        jLabel60.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 153, 255));
        jLabel60.setText("Last Name");
        jPanel25.add(jLabel60);
        jLabel60.setBounds(10, 90, 120, 24);

        jLabel61.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 153, 255));
        jLabel61.setText("Security Question");
        jPanel25.add(jLabel61);
        jLabel61.setBounds(10, 510, 168, 24);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-add-file-20.png"))); // NOI18N
        jButton9.setText("Create");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel25.add(jButton9);
        jButton9.setBounds(100, 610, 150, 40);

        jLabel62.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 153, 255));
        jLabel62.setText("Password");
        jPanel25.add(jLabel62);
        jLabel62.setBounds(10, 140, 89, 24);

        jLabel63.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 153, 255));
        jLabel63.setText("Answer");
        jPanel25.add(jLabel63);
        jLabel63.setBounds(20, 550, 71, 24);
        jPanel25.add(lastnam);
        lastnam.setBounds(210, 90, 230, 30);

        ans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ansActionPerformed(evt);
            }
        });
        ans.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ansKeyPressed(evt);
            }
        });
        jPanel25.add(ans);
        ans.setBounds(200, 550, 232, 30);
        jPanel25.add(firstnam);
        firstnam.setBounds(210, 50, 232, 30);

        seqq.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "What is your nickname?", "What is your mother maiden name?", "What is your favorite animal?", "What is your favorite book?" }));
        jPanel25.add(seqq);
        seqq.setBounds(200, 510, 230, 30);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-back-arrow-26.png"))); // NOI18N
        jButton10.setText("Back");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel25.add(jButton10);
        jButton10.setBounds(380, 610, 150, 40);

        jLabel64.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(0, 153, 255));
        jLabel64.setText("Fist Name");
        jPanel25.add(jLabel64);
        jLabel64.setBounds(10, 50, 110, 24);

        Passwor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PassworActionPerformed(evt);
            }
        });
        jPanel25.add(Passwor);
        Passwor.setBounds(210, 130, 230, 30);

        jLabel94.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(0, 153, 255));
        jLabel94.setText("Gender");
        jPanel25.add(jLabel94);
        jLabel94.setBounds(10, 230, 89, 24);

        male.setText("Male");
        jPanel25.add(male);
        male.setBounds(250, 220, 60, 25);

        female.setText("Female");
        jPanel25.add(female);
        female.setBounds(350, 220, 70, 25);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-male-28 (2).png"))); // NOI18N
        jPanel25.add(jLabel20);
        jLabel20.setBounds(210, 220, 30, 30);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-female-28.png"))); // NOI18N
        jPanel25.add(jLabel21);
        jLabel21.setBounds(320, 220, 30, 30);

        jLabel110.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(0, 153, 255));
        jLabel110.setText("Username");
        jPanel25.add(jLabel110);
        jLabel110.setBounds(10, 10, 110, 24);
        jPanel25.add(usernam);
        usernam.setBounds(210, 10, 232, 30);

        jLabel111.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(0, 153, 255));
        jLabel111.setText("Confirm Password");
        jPanel25.add(jLabel111);
        jLabel111.setBounds(10, 190, 180, 24);
        jPanel25.add(Confirmpasswor);
        Confirmpasswor.setBounds(210, 180, 230, 30);

        jLabel112.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(0, 153, 255));
        jLabel112.setText("Date of birth");
        jPanel25.add(jLabel112);
        jLabel112.setBounds(10, 270, 121, 30);
        jPanel25.add(jDayChooser1);
        jDayChooser1.setBounds(140, 270, 360, 200);
        jPanel25.add(jMonthChooser1);
        jMonthChooser1.setBounds(550, 360, 210, 40);
        jPanel25.add(jYearChooser1);
        jYearChooser1.setBounds(550, 300, 110, 40);

        jDialog4.getContentPane().add(jPanel25);
        jPanel25.setBounds(380, 130, 660, 710);

        jLabel66.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ali yassine\\Desktop\\backround3.jpeg")); // NOI18N
        jLabel66.setText("jLabel6");
        jDialog4.getContentPane().add(jLabel66);
        jLabel66.setBounds(0, 0, 1190, 840);

        jDialog5.setMinimumSize(new java.awt.Dimension(1000, 620));
        jDialog5.setPreferredSize(new java.awt.Dimension(1000, 588));
        jDialog5.setResizable(false);
        jDialog5.getContentPane().setLayout(null);

        jPanel26.setOpaque(false);

        jLabel67.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(0, 153, 255));
        jLabel67.setText("Username");

        jLabel68.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(0, 153, 255));
        jLabel68.setText("Email");

        jLabel69.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(0, 153, 255));
        jLabel69.setText("Name");

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-restart-27.png"))); // NOI18N
        jButton12.setText("Retrive");
        jButton12.setOpaque(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(0, 153, 255));
        jLabel70.setText("Answer");

        em1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                em1ActionPerformed(evt);
            }
        });
        em1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                em1KeyPressed(evt);
            }
        });

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-back-arrow-26.png"))); // NOI18N
        jButton13.setText("Back");
        jButton13.setOpaque(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(0, 153, 255));
        jLabel71.setText("Your security question");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "What is your nickname?", "What is your mother maiden name?", "What is your favorite animal?", "What is your favorite book?" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        N2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                N2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel71)
                            .addComponent(jLabel70)
                            .addComponent(jButton12)
                            .addComponent(jLabel68))
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(us1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                    .addComponent(jComboBox2, 0, 0, Short.MAX_VALUE)
                                    .addComponent(N2)
                                    .addComponent(ans1)
                                    .addComponent(em1)))))
                    .addComponent(jLabel67)
                    .addComponent(jLabel69))
                .addGap(0, 108, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel67)
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(us1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(N2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel71)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel70)
                    .addComponent(ans1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel68)
                    .addComponent(em1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(jButton13))
                .addGap(15, 15, 15))
        );

        jDialog5.getContentPane().add(jPanel26);
        jPanel26.setBounds(0, 130, 570, 280);

        jLabel72.setFont(new java.awt.Font("Trebuchet MS", 1, 52)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(0, 153, 255));
        jLabel72.setText("Forgot Password");
        jDialog5.getContentPane().add(jLabel72);
        jLabel72.setBounds(10, 10, 440, 78);

        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GDGD.jpg"))); // NOI18N
        jLabel73.setMinimumSize(new java.awt.Dimension(1000, 750));
        jDialog5.getContentPane().add(jLabel73);
        jLabel73.setBounds(0, 0, 1000, 590);

        jDialog7.setMinimumSize(new java.awt.Dimension(734, 700));
        jDialog7.getContentPane().setLayout(null);

        SearchBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-search-48_1.png"))); // NOI18N
        jDialog7.getContentPane().add(SearchBar);
        SearchBar.setBounds(20, 20, 50, 50);

        SearchAT.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        SearchAT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SearchAT.setBorder(null);
        SearchAT.setEnabled(false);
        SearchAT.setOpaque(false);
        SearchAT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchATMouseClicked(evt);
            }
        });
        SearchAT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchATActionPerformed(evt);
            }
        });
        jDialog7.getContentPane().add(SearchAT);
        SearchAT.setBounds(70, 20, 580, 40);

        jPanel29.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel29.setForeground(new java.awt.Color(255, 255, 255));
        jPanel29.setOpaque(false);
        jPanel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel29MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel29MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel29MousePressed(evt);
            }
        });

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 153, 255));
        jLabel79.setText("Search By Author ");

        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-edgar-allan-poe-filled-100_1.png"))); // NOI18N
        jLabel81.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel81MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel79)
                .addGap(52, 52, 52))
        );

        jDialog7.getContentPane().add(jPanel29);
        jPanel29.setBounds(50, 170, 240, 244);

        jPanel30.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel30.setForeground(new java.awt.Color(255, 255, 255));
        jPanel30.setOpaque(false);
        jPanel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel30MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel30MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel30MousePressed(evt);
            }
        });

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 153, 255));
        jLabel80.setText("Search By Title");

        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-title-filled-100.png"))); // NOI18N
        jLabel82.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel82MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel82)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel80)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jDialog7.getContentPane().add(jPanel30);
        jPanel30.setBounds(440, 190, 240, 202);

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-back-arrow-26.png"))); // NOI18N
        jButton16.setText("Back");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jDialog7.getContentPane().add(jButton16);
        jButton16.setBounds(600, 600, 100, 40);

        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BSERCHBETTERONE.jpg"))); // NOI18N
        jLabel77.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel77MouseMoved(evt);
            }
        });
        jLabel77.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jLabel77MouseWheelMoved(evt);
            }
        });
        jLabel77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel77MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel77MouseExited(evt);
            }
        });
        jDialog7.getContentPane().add(jLabel77);
        jLabel77.setBounds(0, 0, 730, 670);

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(0, 153, 255));
        jLabel78.setText("Search By Author ");

        jDialog8.setMinimumSize(new java.awt.Dimension(1034, 645));
        jDialog8.getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Title", "Authors Name ", "Publisher ", "Status", "Book Price", "Category"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jDialog8.getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 110, 900, 300);

        jLabel83.setFont(new java.awt.Font("Trebuchet MS", 1, 58)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(0, 153, 255));
        jLabel83.setText("By Author");
        jDialog8.getContentPane().add(jLabel83);
        jLabel83.setBounds(10, 20, 320, 68);

        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-william-shakespeare-100.png"))); // NOI18N
        jDialog8.getContentPane().add(jLabel84);
        jLabel84.setBounds(520, 10, 100, 100);

        jPanel33.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel33.setForeground(new java.awt.Color(255, 255, 255));
        jPanel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel33MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel33MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel33MousePressed(evt);
            }
        });

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 0, 51));
        jLabel96.setText("Request Here");

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(255, 0, 0));
        jLabel97.setText("Book Not Found?");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel96)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel96)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jDialog8.getContentPane().add(jPanel33);
        jPanel33.setBounds(140, 480, 130, 77);

        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-nothing-found-65.png"))); // NOI18N
        jDialog8.getContentPane().add(jLabel98);
        jLabel98.setBounds(50, 460, 65, 105);

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-back-arrow-26.png"))); // NOI18N
        jButton17.setText("Back");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jDialog8.getContentPane().add(jButton17);
        jButton17.setBounds(630, 40, 89, 45);

        jLabel115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/KINDANINGA.jpg"))); // NOI18N
        jLabel115.setText("jLabel115");
        jDialog8.getContentPane().add(jLabel115);
        jLabel115.setBounds(0, -50, 1060, 690);

        jDialog9.setMinimumSize(new java.awt.Dimension(1200, 710));
        jDialog9.getContentPane().setLayout(null);

        jLabel85.setFont(new java.awt.Font("Trebuchet MS", 0, 58)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(0, 153, 255));
        jLabel85.setText("By Title");
        jDialog9.getContentPane().add(jLabel85);
        jLabel85.setBounds(12, 13, 202, 68);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Title", "Authors Name ", "Publisher ", "Status", "Book Price", "Category"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jDialog9.getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 100, 840, 320);

        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-copybook-100.png"))); // NOI18N
        jDialog9.getContentPane().add(jLabel86);
        jLabel86.setBounds(232, 0, 100, 100);

        jPanel31.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel31.setForeground(new java.awt.Color(255, 255, 255));
        jPanel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel31MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel31MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel31MousePressed(evt);
            }
        });
        jPanel31.setLayout(null);

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 0, 51));
        jLabel90.setText("Request Here");
        jPanel31.add(jLabel90);
        jLabel90.setBounds(30, 30, 94, 17);

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 0, 0));
        jLabel91.setText("Book Not Found?");
        jPanel31.add(jLabel91);
        jLabel91.setBounds(30, 10, 106, 15);

        jDialog9.getContentPane().add(jPanel31);
        jPanel31.setBounds(1010, 40, 170, 50);

        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-nothing-found-65.png"))); // NOI18N
        jDialog9.getContentPane().add(jLabel92);
        jLabel92.setBounds(920, 10, 65, 105);

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-back-arrow-26.png"))); // NOI18N
        jButton18.setText("Back");
        jButton18.setOpaque(false);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jDialog9.getContentPane().add(jButton18);
        jButton18.setBounds(541, 30, 110, 44);

        jLabel116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/YOUPI.jpg"))); // NOI18N
        jLabel116.setText("jLabel116");
        jDialog9.getContentPane().add(jLabel116);
        jLabel116.setBounds(0, -180, 1240, 1050);

        jDialog10.setMinimumSize(new java.awt.Dimension(1158, 799));
        jDialog10.getContentPane().setLayout(null);

        jLabel95.setFont(new java.awt.Font("Trebuchet MS", 0, 56)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(0, 153, 255));
        jLabel95.setText("History");
        jDialog10.getContentPane().add(jLabel95);
        jLabel95.setBounds(37, 13, 178, 66);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Act", "Date & Time"
            }
        ));
        jTable3.setCellSelectionEnabled(true);
        jScrollPane3.setViewportView(jTable3);

        jDialog10.getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(28, 118, 972, 160);

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-back-arrow-26.png"))); // NOI18N
        jButton15.setText("Back");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jDialog10.getContentPane().add(jButton15);
        jButton15.setBounds(841, 35, 89, 35);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-time-machine-100 (1)_1.png"))); // NOI18N
        jDialog10.getContentPane().add(jLabel23);
        jLabel23.setBounds(222, 0, 100, 100);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ggood one.jpg"))); // NOI18N
        jDialog10.getContentPane().add(jLabel22);
        jLabel22.setBounds(-80, -50, 1240, 890);

        jDialog11.setMinimumSize(new java.awt.Dimension(1158, 800));
        jDialog11.getContentPane().setLayout(null);

        jLabel99.setFont(new java.awt.Font("Trebuchet MS", 0, 56)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(0, 153, 255));
        jLabel99.setText("Your reservations ");
        jDialog11.getContentPane().add(jLabel99);
        jLabel99.setBounds(20, 0, 456, 66);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Title", "Author", "Publisher ", "Price", "Category"
            }
        ));
        jTable4.setOpaque(false);
        jScrollPane4.setViewportView(jTable4);

        jDialog11.getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(10, 100, 700, 460);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-back-arrow-26.png"))); // NOI18N
        jButton14.setText("Back");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jDialog11.getContentPane().add(jButton14);
        jButton14.setBounds(620, 570, 89, 36);

        jLabel117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MOODILSIM.jpg"))); // NOI18N
        jLabel117.setText("jLabel117");
        jDialog11.getContentPane().add(jLabel117);
        jLabel117.setBounds(0, 0, 1090, 670);

        jDialog12.setMinimumSize(new java.awt.Dimension(913, 620));
        jDialog12.setPreferredSize(new java.awt.Dimension(800, 500));
        jDialog12.getContentPane().setLayout(null);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BLUE TO CROP.jpg"))); // NOI18N
        jDialog12.getContentPane().add(jLabel15);
        jLabel15.setBounds(400, 310, 130, 10);

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 0, 45)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("OUR TEAM");
        jDialog12.getContentPane().add(jLabel14);
        jLabel14.setBounds(350, 30, 230, 53);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BLUE TO CROP.jpg"))); // NOI18N
        jDialog12.getContentPane().add(jLabel18);
        jLabel18.setBounds(390, 110, 140, 10);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ALIYASSINEEEEEEEEEEEEEEEEEEEE.png"))); // NOI18N
        jLabel16.setText("jLabel16");
        jDialog12.getContentPane().add(jLabel16);
        jLabel16.setBounds(180, 130, 120, 150);

        jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JIJIHADID.png"))); // NOI18N
        jLabel100.setText("jLabel100");
        jDialog12.getContentPane().add(jLabel100);
        jLabel100.setBounds(400, 140, 140, 130);

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MARIAM HADID.png"))); // NOI18N
        jDialog12.getContentPane().add(jLabel25);
        jLabel25.setBounds(620, 130, 140, 150);

        jLabel102.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(255, 255, 255));
        jLabel102.setText("Ali Yassine");
        jDialog12.getContentPane().add(jLabel102);
        jLabel102.setBounds(200, 280, 100, 21);

        jLabel103.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(255, 255, 255));
        jLabel103.setText("Rayan Zein");
        jDialog12.getContentPane().add(jLabel103);
        jLabel103.setBounds(420, 280, 100, 21);

        jLabel104.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(255, 255, 255));
        jLabel104.setText("Mariam Hoteit ");
        jDialog12.getContentPane().add(jLabel104);
        jLabel104.setBounds(630, 280, 130, 20);

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-back-arrow-26.png"))); // NOI18N
        jButton19.setText("Back");
        jButton19.setOpaque(false);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jDialog12.getContentPane().add(jButton19);
        jButton19.setBounds(760, 540, 89, 35);

        jLabel101.setText("jLabel101");
        jDialog12.getContentPane().add(jLabel101);
        jLabel101.setBounds(420, 190, 55, 16);

        aboutus.setColumns(20);
        aboutus.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        aboutus.setForeground(new java.awt.Color(255, 255, 255));
        aboutus.setRows(5);
        aboutus.setText("MaktabaTech started in Spring 2019. Three friends had a Vision to spread hapiness by  spreading books \nover the World.Knowledge is universal and shouldn't be restricted by geographical and financial barriers. \nReading has also significant benefits. It reduces stress, enforce knowledge and memory. So,our main objective\nis to encourage people and especially the new generation to read books by developping an easy to use and\naccessible everywhere Library Management System.\n");
        aboutus.setWrapStyleWord(true);
        aboutus.setOpaque(false);
        jScrollPane6.setViewportView(aboutus);

        jDialog12.getContentPane().add(jScrollPane6);
        jScrollPane6.setBounds(10, 350, 890, 160);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VERY NICE NAVY BLUE.jpg"))); // NOI18N
        jLabel17.setText("jijifmkmk");
        jDialog12.getContentPane().add(jLabel17);
        jLabel17.setBounds(0, 0, 910, 590);

        jDialog13.setMinimumSize(new java.awt.Dimension(1124, 650));
        jDialog13.getContentPane().setLayout(null);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Title", "Author", "Pulisher", "Status", "Price"
            }
        ));
        jScrollPane5.setViewportView(jTable5);

        jDialog13.getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(24, 83, 779, 420);

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-back-arrow-26.png"))); // NOI18N
        jButton20.setText("Back");
        jButton20.setOpaque(false);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jDialog13.getContentPane().add(jButton20);
        jButton20.setBounds(700, 530, 103, 35);

        jLabel105.setFont(new java.awt.Font("Trebuchet MS", 0, 55)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(255, 0, 102));
        jLabel105.setText("Search By Category");
        jDialog13.getContentPane().add(jLabel105);
        jLabel105.setBounds(30, 0, 880, 65);

        jLabel114.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ali yassine\\Desktop\\BACKROUN13dial.jpg")); // NOI18N
        jLabel114.setText("jLabel114");
        jDialog13.getContentPane().add(jLabel114);
        jLabel114.setBounds(-45, 0, 1170, 610);

        jDialog14.setMinimumSize(new java.awt.Dimension(1182, 735));
        jDialog14.setPreferredSize(new java.awt.Dimension(1000, 600));
        jDialog14.getContentPane().setLayout(null);

        jLabel118.setFont(new java.awt.Font("Sitka Text", 2, 58)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(0, 153, 255));
        jLabel118.setText("Citadel Library");
        jDialog14.getContentPane().add(jLabel118);
        jLabel118.setBounds(30, 30, 460, 68);

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ", "Author ", "Publisher "
            }
        ));
        jTable6.setColumnSelectionAllowed(true);
        jTable6.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable6MousePressed(evt);
            }
        });
        jScrollPane7.setViewportView(jTable6);
        jTable6.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jDialog14.getContentPane().add(jScrollPane7);
        jScrollPane7.setBounds(10, 180, 800, 360);

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-back-arrow-26.png"))); // NOI18N
        jButton21.setText("Back");
        jButton21.setOpaque(false);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jDialog14.getContentPane().add(jButton21);
        jButton21.setBounds(530, 600, 170, 80);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-note-25.png"))); // NOI18N
        jButton1.setText("Request");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jDialog14.getContentPane().add(jButton1);
        jButton1.setBounds(150, 600, 190, 80);

        jLabel119.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ali yassine\\Documents\\NetBeansProjects\\Library management system project\\src\\veryimportant.jpg")); // NOI18N
        jLabel119.setText("jLabel119");
        jDialog14.getContentPane().add(jLabel119);
        jLabel119.setBounds(-10, -40, 1190, 770);

        jLabel120.setFont(new java.awt.Font("Trebuchet MS", 0, 58)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(0, 153, 255));
        jLabel120.setText("WELCOME TO");

        jLabel121.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ali yassine\\Desktop\\book gif.gif")); // NOI18N

        loadingnumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loadingnumber.setText("99");

        jLabel122.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(0, 153, 255));
        jLabel122.setText("    Please wait...");

        javax.swing.GroupLayout jDialog15Layout = new javax.swing.GroupLayout(jDialog15.getContentPane());
        jDialog15.getContentPane().setLayout(jDialog15Layout);
        jDialog15Layout.setHorizontalGroup(
            jDialog15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog15Layout.createSequentialGroup()
                .addGroup(jDialog15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog15Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jDialog15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel121, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(loadingbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jDialog15Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel122, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialog15Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialog15Layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(loadingnumber)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jDialog15Layout.setVerticalGroup(
            jDialog15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog15Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel120)
                .addGap(29, 29, 29)
                .addComponent(jLabel121)
                .addGap(50, 50, 50)
                .addComponent(loadingnumber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loadingbar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel122, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(854, 300));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        exit.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("X");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitMousePressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe Print", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("The Home Of Books");

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 58)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("MaktabaTech");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-home-64.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(jLabel11)
                .addGap(0, 725, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(173, 173, 173)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(448, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(exit)))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(jLabel12)
                    .addContainerGap(163, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 1130, 260));

        jPanel3.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Your History");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-time-machine-100_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9))
                .addGap(35, 35, 35))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 300, 200, 170));

        jPanel4.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel4MousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("About us ");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-about-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(49, 49, 49))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(24, 24, 24))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 530, 200, 170));

        jPanel5.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel5MousePressed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ali yassine\\Desktop\\Programs-1.png")); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setText("      Reserve Book");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel7))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 520, 210, 180));

        jPanel6.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel6MousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setText("Book that you reserved ");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-reservation-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 530, -1, 170));

        jPanel28.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel28.setForeground(new java.awt.Color(255, 255, 255));
        jPanel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel28MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel28MousePressed(evt);
            }
        });

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(0, 153, 255));
        jLabel87.setText("Book Categories");

        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-diversity-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel87))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel87)
                .addGap(24, 24, 24))
        );

        jPanel1.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 210, 170));

        jPanel32.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel32.setForeground(new java.awt.Color(255, 255, 255));
        jPanel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel32MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel32MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel32MousePressed(evt);
            }
        });

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(0, 153, 255));
        jLabel89.setText("Search Book");

        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-search-more-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel89)
                    .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel89)
                .addGap(24, 24, 24))
        );

        jPanel1.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 210, 170));

        jMenu1.setText("File");

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Logout");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem3.setText("About");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1127, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitMousePressed


    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        // TODO add your handling code here:
        setColor(jPanel4);
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        // TODO add your handling code here:
        resetColor(jPanel4);
    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
        // TODO add your handling code here:
        setColor(jPanel5);

    }//GEN-LAST:event_jPanel5MouseEntered

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
        // TODO add your handling code here:
        resetColor(jPanel5);
    }//GEN-LAST:event_jPanel5MouseExited

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        // TODO add your handling code here:
        setColor(jPanel3);
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        // TODO add your handling code here:
        resetColor(jPanel3);
    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        // TODO add your handling code here:
        setColor(jPanel6);
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        // TODO add your handling code here:
        resetColor(jPanel6);
    }//GEN-LAST:event_jPanel6MouseExited

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        // TODO add your handling code here:

        this.jDialog1.setVisible(true);
    }//GEN-LAST:event_jPanel5MousePressed

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed

        // TODO add your handling code here:
        this.jDialog12.setVisible(true);
    }//GEN-LAST:event_jPanel4MousePressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String SEARCH = jTextField6.getText();
        System.out.println(SEARCH);

        int day1 = jDayChooser2.getDay();
        int month1 = jMonthChooser2.getMonth();
        int year1 = jYearChooser2.getYear();
        String Day1 = Integer.toString(day1);
        String Year1 = Integer.toString(year1);
        String Month1 = Integer.toString(month1);
        String RetDate = Year1 + "-" + Month1 + "-" + Day1 + " 00:00:00";

        SimpleDateFormat dat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String strDateandTime = dat.format(date);

        System.out.println(strDateandTime);
        String response = Reserve(SEARCH, strDateandTime, RetDate);
        if (response.equals("Success")) {
            JOptionPane.showMessageDialog(null, SEARCH + "  has been succesfully reserved for you till  " + RetDate);
            jTextField6.setText("");
            this.jDialog1.setVisible(false);
            this.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, " Sorry, Book is already reserved ");
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.jDialog1.setVisible(false);
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jPanel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseEntered
        // TODO add your handling code here:
        setColor(jPanel13);
    }//GEN-LAST:event_jPanel13MouseEntered

    private void jPanel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseExited
        // TODO add your handling code here:
        resetColor(jPanel13);
    }//GEN-LAST:event_jPanel13MouseExited

    private void jPanel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseEntered
        // TODO add your handling code here:
        setColor(jPanel12);
    }//GEN-LAST:event_jPanel12MouseEntered

    private void jPanel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseExited
        // TODO add your handling code here:
        resetColor(jPanel12);
    }//GEN-LAST:event_jPanel12MouseExited

    private void jPanel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseEntered
        // TODO add your handling code here:
        setColor(jPanel14);
    }//GEN-LAST:event_jPanel14MouseEntered

    private void jPanel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseExited
        // TODO add your handling code here:
        resetColor(jPanel14);
    }//GEN-LAST:event_jPanel14MouseExited

    private void jPanel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseEntered
        // TODO add your handling code here:
        setColor(jPanel15);
    }//GEN-LAST:event_jPanel15MouseEntered

    private void jPanel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseExited
        // TODO add your handling code here:
        resetColor(jPanel15);
    }//GEN-LAST:event_jPanel15MouseExited

    private void jPanel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseEntered
        // TODO add your handling code here:
        setColor(jPanel16);
    }//GEN-LAST:event_jPanel16MouseEntered

    private void jPanel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseExited
        // TODO add your handling code here:
        resetColor(jPanel16);
    }//GEN-LAST:event_jPanel16MouseExited

    private void jPanel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseEntered
        // TODO add your handling code here:
        setColor(jPanel17);
    }//GEN-LAST:event_jPanel17MouseEntered

    private void jPanel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseExited
        // TODO add your handling code here:
        resetColor(jPanel17);
    }//GEN-LAST:event_jPanel17MouseExited

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.setVisible(true);
        this.jDialog2.setVisible(false);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jPanel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseEntered
        // TODO add your handling code here:
        setColor(jPanel18);
    }//GEN-LAST:event_jPanel18MouseEntered

    private void jPanel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseExited
        // TODO add your handling code here:
        resetColor(jPanel18);
    }//GEN-LAST:event_jPanel18MouseExited

    private void jPanel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseEntered
        // TODO add your handling code here:
        setColor(jPanel19);
    }//GEN-LAST:event_jPanel19MouseEntered

    private void jPanel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseExited
        // TODO add your handling code here:
        resetColor(jPanel19);
    }//GEN-LAST:event_jPanel19MouseExited

    private void jPanel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseEntered
        // TODO add your handling code here:
        setColor(jPanel20);
    }//GEN-LAST:event_jPanel20MouseEntered

    private void jPanel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseExited
        // TODO add your handling code here:
        resetColor(jPanel20);
    }//GEN-LAST:event_jPanel20MouseExited

    private void jPanel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseEntered
        // TODO add your handling code here:
        setColor(jPanel21);
    }//GEN-LAST:event_jPanel21MouseEntered

    private void jPanel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseExited
        // TODO add your handling code here:
        resetColor(jPanel21);
    }//GEN-LAST:event_jPanel21MouseExited

    private void jPanel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MouseEntered
        // TODO add your handling code here:
        setColor(jPanel22);
    }//GEN-LAST:event_jPanel22MouseEntered

    private void jPanel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MouseExited
        // TODO add your handling code here:
        resetColor(jPanel22);
    }//GEN-LAST:event_jPanel22MouseExited

    private void jPanel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23MouseEntered
        // TODO add your handling code here:
        setColor(jPanel23);
    }//GEN-LAST:event_jPanel23MouseEntered

    private void jPanel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23MouseExited
        // TODO add your handling code here:
        resetColor(jPanel23);
    }//GEN-LAST:event_jPanel23MouseExited
    public void setColor(JPanel panel) {

        panel.setBackground(new java.awt.Color(197, 197, 197));
    }

    public void resetColor(JPanel panel) {

        panel.setBackground(new java.awt.Color(240, 240, 240));
    }
    private void loginbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbuttonActionPerformed

        try {

            // TODO add your handling code here:
            socket = new Socket("172.20.10.7", 12345); //

            out = new ObjectOutputStream(socket.getOutputStream());

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException ex) {

            Logger.getLogger(home2.class.getName()).log(Level.SEVERE, null, ex);

        }
        String Username = username.getText();
        String Password = password.getText();

        String response = login(Username, Password);
        if (response.equals("Succesfull login")) {
            JOptionPane.showMessageDialog(null, "Login Successful");
            setVisible(true);
            this.jDialog3.setVisible(false);
        } else if (response.equals("not a user")) {
            JOptionPane.showMessageDialog(null, "Username is not valid, Please Create an Account or try again! ");
            username.setText("");
            password.setText("");
            username.requestFocus();
        } //Set cursor on username field
        else {
            JOptionPane.showMessageDialog(null, "Incorrect Password ");

            password.setText("");
            password.requestFocus();   //Set cursor on password field
        }


    }//GEN-LAST:event_loginbuttonActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_usernameActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        this.jDialog4.setVisible(true);
        this.jDialog3.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        this.jDialog5.setVisible(true);
        this.jDialog3.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
         // TODO add your handling code here:

        try {

            // TODO add your handling code here:
            socket = new Socket("172.20.10.7", 12345);

            out = new ObjectOutputStream(socket.getOutputStream());

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException ex) {

            Logger.getLogger(home2.class.getName()).log(Level.SEVERE, null, ex);

        }
        String Username = usernam.getText();
        String Password = Passwor.getText();
        String Firstname = firstnam.getText();
        String LastName = lastnam.getText();
        String ConfirmPassword = Confirmpasswor.getText();

        int day = jDayChooser1.getDay();
        int month = jMonthChooser1.getMonth();
        int year = jYearChooser1.getYear();
        String Day = Integer.toString(day);
        String Year = Integer.toString(year);
        String Month = Integer.toString(month);
        String DOB = Year + "-" + Month + "-" + Day;

        String response = Signup(Firstname, LastName, Username, DOB, Password);
        if (usernam.getText().equals("") || Passwor.getText().equals("") || firstnam.getText().equals("") || lastnam.getText().equals("") || Confirmpasswor.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Fill in all the Fields");
        } else {
            if (!Password.equals(ConfirmPassword)) {
                JOptionPane.showMessageDialog(null, "Passwords Do not Match");
                Passwor.setText("");
                Confirmpasswor.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Welcome " + Firstname + "!");
                jDialog4.setVisible(false);
                setVisible(true);
            }
        }

    }//GEN-LAST:event_jButton9ActionPerformed


    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        this.jDialog3.setVisible(true);
        this.jDialog4.setVisible(false);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void PassworActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PassworActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PassworActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:

        if (us1.getText().equals("") || N2.getText().equals("") || ans1.getText().equals("") || em1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Fill in all the boxes!");

        } else {
            JOptionPane.showMessageDialog(null, "An email has been sent to your mailbox");
            this.jDialog3.setVisible(true);
            this.jDialog5.setVisible(false);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        this.jDialog3.setVisible(true);
        this.jDialog5.setVisible(false);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void N2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_N2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_N2ActionPerformed

    private void SearchATActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchATActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchATActionPerformed

    private void SearchATMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchATMouseClicked
        // TODO add your handling code here:

        SearchAT.setEnabled(true);
        SearchAT.setText("");


    }//GEN-LAST:event_SearchATMouseClicked

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed

        this.jDialog10.setVisible(true);

        String answer = ViewHistory();

        System.out.println(answer);
        addentryHist(answer);


    }//GEN-LAST:event_jPanel3MousePressed

    private void jLabel77MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel77MouseClicked
        // TODO add your handling code here:

        {
            SearchAT.setEnabled(false);
            SearchAT.setText("Search Your Book Here");

        }
    }//GEN-LAST:event_jLabel77MouseClicked

    private void jPanel29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel29MouseEntered
// TODO add your handling code here:

    }//GEN-LAST:event_jPanel29MouseEntered

    private void jPanel29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel29MouseExited


    }//GEN-LAST:event_jPanel29MouseExited

    private void jPanel30MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel30MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel30MouseEntered

    private void jPanel30MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel30MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel30MouseExited

    private void jPanel29MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel29MousePressed
// TODO add your handling code here:
        this.jDialog8.setVisible(true);
        this.jDialog7.setVisible(false);
    }//GEN-LAST:event_jPanel29MousePressed

    private void jPanel30MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel30MousePressed
        // TODO add your handling code here:
        this.jDialog9.setVisible(true);
        this.jDialog7.setVisible(false);
    }//GEN-LAST:event_jPanel30MousePressed

    private void jLabel81MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel81MousePressed
        String Searching = SearchAT.getText();
        System.out.println(Searching);// correct test
        this.jDialog8.setVisible(true);

        String answer = SearchbyAuthor(Searching);
        System.out.println(answer);
        addentrytoSearchByAuthor(answer);
        this.jDialog7.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel81MousePressed

    private void jPanel31MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel31MouseEntered
        // TODO add your handling code here:
        setColor(jPanel31);
    }//GEN-LAST:event_jPanel31MouseEntered

    private void jPanel31MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel31MouseExited
        // TODO add your handling code here:
        resetColor(jPanel31);
    }//GEN-LAST:event_jPanel31MouseExited

    private void jPanel31MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel31MousePressed
        // TODO add your handling code here:
        this.jDialog14.setVisible(true);

        String answer = Displaybooks2();
        System.out.println(answer);
        addentryBooks2(answer);

        this.jDialog9.setVisible(false);
    }//GEN-LAST:event_jPanel31MousePressed

    private void jPanel33MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel33MouseEntered
        // TODO add your handling code here:
        setColor(jPanel33);
    }//GEN-LAST:event_jPanel33MouseEntered

    private void jPanel33MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel33MouseExited
        // TODO add your handling code here:
        resetColor(jPanel33);
    }//GEN-LAST:event_jPanel33MouseExited

    private void jPanel33MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel33MousePressed

        // TODO add your handling code here:
        this.jDialog14.setVisible(true);

        String answer = Displaybooks2();
        System.out.println(answer);
        addentryBooks2(answer);

        this.jDialog8.setVisible(false);
    }//GEN-LAST:event_jPanel33MousePressed

    private void jPanel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel28MouseEntered

        // TODO add your handling code here:
        setColor(jPanel28);
    }//GEN-LAST:event_jPanel28MouseEntered

    private void jPanel28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel28MouseExited
        // TODO add your handling code here:
        resetColor(jPanel28);
    }//GEN-LAST:event_jPanel28MouseExited

    private void jPanel28MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel28MousePressed
        // TODO add your handling code here:
        this.jDialog2.setVisible(true);

    }//GEN-LAST:event_jPanel28MousePressed

    private void jPanel32MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel32MouseEntered
        // TODO add your handling code here:
        setColor(jPanel32);
    }//GEN-LAST:event_jPanel32MouseEntered

    private void jPanel32MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel32MouseExited
        // TODO add your handling code here:
        resetColor(jPanel32);
    }//GEN-LAST:event_jPanel32MouseExited

    private void jPanel32MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel32MousePressed
        // TODO add your handling code here:
        this.jDialog7.setVisible(true);

    }//GEN-LAST:event_jPanel32MousePressed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed

        // TODO add your handling code here:
        this.setVisible(true);
        this.jDialog11.setVisible(false);

    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed

        // TODO add your handling code here:
        this.setVisible(true);
        this.jDialog10.setVisible(false);


    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        this.setVisible(true);
        this.jDialog7.setVisible(false);

    }//GEN-LAST:event_jButton16ActionPerformed

    private void jPanel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MousePressed
        // TODO add your handling code here:
        this.jDialog11.setVisible(true);

        String answer = Viewreserves();

        System.out.println(answer);

        addentryReserves(answer);
        //  this.jDialog11.setVisible(false);

    }//GEN-LAST:event_jPanel6MousePressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.jDialog3.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
// TODO add your handling code here:
        this.jDialog12.setVisible(true);

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        this.jDialog7.setVisible(true);
        this.jDialog8.setVisible(false);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        this.jDialog7.setVisible(true);
        this.jDialog9.setVisible(false);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jLabel77MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel77MouseMoved
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel77MouseMoved

    private void jLabel77MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jLabel77MouseWheelMoved
        // TODO add your handling code here:


    }//GEN-LAST:event_jLabel77MouseWheelMoved

    private void jLabel77MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel77MouseExited

        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel77MouseExited

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {        //Let enter button take action 
            loginbutton.doClick();
    }//GEN-LAST:event_passwordKeyPressed
    }
    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void ansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ansActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ansActionPerformed

    private void ansKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ansKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {          //Let enter button take action 
            jButton9.doClick();
        }
    }//GEN-LAST:event_ansKeyPressed

    private void em1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_em1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_em1ActionPerformed

    private void em1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_em1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {              //Let enter button take action 
            jButton12.doClick();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_em1KeyPressed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        this.setVisible(true);
        this.jDialog12.setVisible(false);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jPanel17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MousePressed
        // TODO add your handling code here:

        jDialog13.setVisible(true);
        System.out.println(".......................................................................VISIBLE");
        String answer = Displaycategory("Kids");
        System.out.println("......................................................................ANSWER: " + answer);
        jLabel105.setText("Kids");
        //System.out.println("ANSWER: " + answer);
        addentryCategory(answer);
        System.out.println(".....................................................................TABLE: " + answer);


    }//GEN-LAST:event_jPanel17MousePressed

    private void jPanel21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MousePressed
        // TODO add your handling code here:
        this.jDialog13.setVisible(true);
        jDialog13.setVisible(true);
        String answer = Displaycategory("Biographies");
        jLabel105.setText("Bioraphies");
        System.out.println("ANSWER: " + answer);
        addentryCategory(answer);

        this.jDialog2.setVisible(false);
    }//GEN-LAST:event_jPanel21MousePressed

    private void jPanel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MousePressed
        // TODO add your handling code here:
        this.jDialog13.setVisible(true);

        jDialog13.setVisible(true);
        String answer = Displaycategory("Science & technology");
        jLabel105.setText("Science & Technology");
        System.out.println("ANSWER: " + answer);
        addentryCategory(answer);
        this.jDialog2.setVisible(false);
    }//GEN-LAST:event_jPanel15MousePressed

    private void jPanel14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MousePressed
        // TODO add your handling code here:
        this.jDialog13.setVisible(true);
        jDialog13.setVisible(true);
        String answer = Displaycategory("Romance");
        jLabel105.setText("Romance");
        System.out.println("ANSWER: " + answer);
        addentryCategory(answer);
        this.jDialog2.setVisible(false);
    }//GEN-LAST:event_jPanel14MousePressed

    private void jPanel19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MousePressed
        // TODO add your handling code here:
        this.jDialog13.setVisible(true);
        jDialog13.setVisible(true);
        String answer = Displaycategory("lifestyle");
        jLabel105.setText("Lifestyle");
        System.out.println("ANSWER: " + answer);
        addentryCategory(answer);
        this.jDialog2.setVisible(false);
    }//GEN-LAST:event_jPanel19MousePressed

    private void jPanel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MousePressed
        // TODO add your handling code here:
        this.jDialog13.setVisible(true);
        jDialog13.setVisible(true);
        String answer = Displaycategory("Cooking");
        jLabel105.setText("Cooking");
        System.out.println("ANSWER: " + answer);
        addentryCategory(answer);
        this.jDialog2.setVisible(false);
    }//GEN-LAST:event_jPanel16MousePressed

    private void jPanel18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MousePressed
        // TODO add your handling code here:
        this.jDialog13.setVisible(true);
        jDialog13.setVisible(true);
        String answer = Displaycategory("Arts & Music");
        jLabel105.setText("Arts & Music");
        System.out.println("ANSWER: " + answer);
        addentryCategory(answer);
        this.jDialog2.setVisible(false);
    }//GEN-LAST:event_jPanel18MousePressed

    private void jPanel20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MousePressed
        // TODO add your handling code here:
        this.jDialog13.setVisible(true);
        jDialog13.setVisible(true);
        String answer = Displaycategory("Novels");
        jLabel105.setText("Novels");
        System.out.println("ANSWER: " + answer);
        addentryCategory(answer);
        this.jDialog2.setVisible(false);
    }//GEN-LAST:event_jPanel20MousePressed

    private void jPanel13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MousePressed
        // TODO add your handling code here:
        this.jDialog13.setVisible(true);
        jDialog13.setVisible(true);
        String answer = Displaycategory("Comics");
        System.out.println("ANSWER: " + answer);
        jLabel105.setText("Comics");
        addentryCategory(answer);
        this.jDialog2.setVisible(false);
    }//GEN-LAST:event_jPanel13MousePressed

    private void jPanel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MousePressed
        // TODO add your handling code here:
        this.jDialog13.setVisible(true);
        jDialog13.setVisible(true);
        String answer = Displaycategory("Travel");
        System.out.println("ANSWER: " + answer);
        jLabel105.setText("Travel");
        addentryCategory(answer);
        this.jDialog2.setVisible(false);
    }//GEN-LAST:event_jPanel12MousePressed

    private void jPanel23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23MousePressed
        // TODO add your handling code here:
        this.jDialog13.setVisible(true);
        jDialog13.setVisible(true);
        String answer = Displaycategory("Fiction");
        jLabel105.setText("Fiction");
        System.out.println("ANSWER: " + answer);
        addentryCategory(answer);
        this.jDialog2.setVisible(false);
    }//GEN-LAST:event_jPanel23MousePressed

    private void jPanel22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MousePressed
        // TODO add your handling code here:
        this.jDialog13.setVisible(true);
        jDialog13.setVisible(true);
        String answer = Displaycategory("Medical");
        jLabel105.setText("Medical");
        System.out.println("ANSWER: " + answer);
        addentryCategory(answer);
        this.jDialog2.setVisible(false);
    }//GEN-LAST:event_jPanel22MousePressed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        this.jDialog2.setVisible(true);
        this.jDialog13.setVisible(false);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jLabel82MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel82MousePressed
        String Searching1 = SearchAT.getText();
        System.out.println(Searching1);// correct
        this.jDialog9.setVisible(true);

        String answer1 = SearchbyTitle(Searching1);
        System.out.println(answer1);
        addentrytoSearchByTitle(answer1);
        this.jDialog7.setVisible(false);
    }//GEN-LAST:event_jLabel82MousePressed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        this.setVisible(true);
        this.jDialog14.setVisible(false);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jTable6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable6MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(null, "You request for '" + Selected1 + "'  has  officialy been submitted !");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        try {
            int row = jTable6.getSelectedRow();
            Selected1 = (jTable6.getModel().getValueAt(row, 0).toString());
            String answer1 = Request(Selected1);

            System.out.println(answer1);

        } catch (Exception e) {

        }


    }//GEN-LAST:event_jTable6MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(home2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new home2().jDialog3.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Confirmpasswor;
    private javax.swing.JTextField N2;
    private javax.swing.JPasswordField Passwor;
    private javax.swing.JTextField SearchAT;
    private javax.swing.JLabel SearchBar;
    private javax.swing.JTextArea aboutus;
    private javax.swing.JTextField ans;
    private javax.swing.JTextField ans1;
    private javax.swing.JTextField em1;
    private javax.swing.JLabel exit;
    private javax.swing.JCheckBox female;
    private javax.swing.JTextField firstnam;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox2;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private com.toedter.calendar.JDayChooser jDayChooser2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog10;
    private javax.swing.JDialog jDialog11;
    private javax.swing.JDialog jDialog12;
    private javax.swing.JDialog jDialog13;
    private javax.swing.JDialog jDialog14;
    private javax.swing.JDialog jDialog15;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JDialog jDialog5;
    private javax.swing.JDialog jDialog7;
    private javax.swing.JDialog jDialog8;
    private javax.swing.JDialog jDialog9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private com.toedter.calendar.JMonthChooser jMonthChooser2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField jTextField6;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private com.toedter.calendar.JYearChooser jYearChooser2;
    private javax.swing.JTextField lastnam;
    private javax.swing.JProgressBar loadingbar;
    private javax.swing.JLabel loadingnumber;
    private javax.swing.JButton loginbutton;
    private javax.swing.JCheckBox male;
    private javax.swing.JPasswordField password;
    private javax.swing.JComboBox seqq;
    private javax.swing.JTextField us1;
    private javax.swing.JTextField usernam;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
