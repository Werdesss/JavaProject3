package core;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class ResManApp extends JFrame {
    private JComboBox mcomboBox;
    private JButton mbutton;
    private JPanel mpanel;
    private JComboBox scomboBox;
    private JTextArea labelTextField;
    private JTextField labelTextField1;
    private JTextField labelTextField2;
    private JTextField labelTextField3;
    private JPanel apanel;
    private JButton sbutton;
    private JButton ncreateButton;
    private JTextField labelTextfield4;
    private JTextField labelTextfield5;
    private JTextField labelTextfield6;
    private JLabel endDate;
    private JTextField textField1;
    private JButton button1;
    private JPanel dpanel;
    private JPanel lspanel;
    private JTextField textField2;
    private JButton button2;
    private JTable table1;
    private JPanel cpanel;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JButton createButton;
    private JLabel label_name;
    private JTextField textField9;
    private JButton searchButton;
    private JTextField textField10;
    private JButton createButton1;
    private JPanel bpanel;
    private JLabel a;
    private JLabel label_name2;
    private JLabel sa;
    private JComboBox comboBox1;
    private JButton button3;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    private JButton button4;
    private JLabel abc;
    private JPanel aopanel;
    private JTextField textField15;
    private JButton searchButton1;
    private JEditorPane editorPane1;

    /**
     * GUI components with its functions
     */
    public ResManApp(){
        add(mpanel);
        setSize(800,500);
        setTitle("ResManApp");

        JMenu menu2 = new JMenu("File");
        JMenuBar menubar = new JMenuBar();
        menubar.add(menu2);
        menubar.add(menu2);
        JMenuItem menuitem = new JMenuItem("Load");
        menu2.add(menuitem);
        setJMenuBar(menubar);

        String[] menu = {"addStaff","deleteStaff","listStaffDetails","addCustomer","deleteCustomer","addBooking","listCustomerDetails","displayCustomerLastBooking","listCustomerOrders","listStaff","listCustomer","addOrder","listAllStaffSalary","listAllOrder","addOrderOfBooking"};
        int i = 0;
        for (i = 0; i < menu.length; i++){
            mcomboBox.addItem(menu[i]);
        }
        scomboBox.addItem("Senior");
        scomboBox.addItem("Junior");
        apanel.setVisible(false);    // to not show when program is started
        aopanel.setVisible(false);
        dpanel.setVisible(false);
        cpanel.setVisible(false);
        lspanel.setVisible(false);
        bpanel.setVisible(false);

        ArrayList<Staff> Staffs = new ArrayList<Staff>();
        ArrayList<Customer> Customers = new ArrayList<Customer>();
        Populatedata populate = new Populatedata();
        try {
            populate.populate(Customers, Staffs);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /**
         * first combobox to choose from menu
         */
        mbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = mcomboBox.getSelectedIndex();
                n+=1;

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Scanner myObj = new Scanner(System.in);
                switch (n) {
                    case 1:{
                        lspanel.setVisible(false);
                        apanel.setVisible(true);
                        dpanel.setVisible(false);
                        aopanel.setVisible(false);
                        cpanel.setVisible(false);
                        bpanel.setVisible(false);
                        /**
                         * chooses from combobox senior/junior
                         */
                        sbutton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int pos = scomboBox.getSelectedIndex();
                                if (pos == 0) {
                                    labelTextfield6.setVisible(false);
                                    endDate.setVisible(false);
                                }
                                else{
                                    labelTextfield6.setVisible(true);
                                    endDate.setVisible(true);
                                }
                                /**
                                 * create button that gets the fields
                                 */
                                ncreateButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        if (pos == 0){
                                            String name = labelTextField.getText();
                                            int ID = Integer.parseInt(labelTextField1.getText());
                                            char gender = labelTextField2.getText().charAt(0);
                                            String dateOfBirth = labelTextField3.getText();
                                            String startDate = labelTextfield4.getText();
                                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                            Date date = null;
                                            Date date2 = null;
                                            try{
                                                date = dateFormat.parse(dateOfBirth);
                                                date2 = dateFormat.parse(startDate);
                                            } catch (ParseException f){
                                                f.printStackTrace();
                                            }
                                            int salary = Integer.parseInt(labelTextfield5.getText());

                                            Senior staff = new Senior();
                                            staff.setGender(gender);
                                            staff.setName(name);
                                            staff.setID(ID);
                                            staff.setDateOfBirth(date);
                                            staff.setStartDate(date2);
                                            staff.setGrossSalaryYear(salary);
                                            Staffs.add(staff);
                                        }
                                        else{
                                            String name = labelTextField.getText();
                                            int ID = Integer.parseInt(labelTextField1.getText());
                                            char gender = labelTextField2.getText().charAt(0);
                                            String dateOfBirth = labelTextField3.getText();
                                            String startDate = labelTextfield4.getText();
                                            Date date = null;
                                            Date date3 = null;
                                            try{
                                                date = dateFormat.parse(dateOfBirth);
                                                date3 = dateFormat.parse(startDate);
                                            } catch (ParseException f){
                                                f.printStackTrace();
                                            }
                                            int salary = Integer.parseInt(labelTextfield5.getText());
                                            String enddate = labelTextfield6.getText();
                                            Date date2 = null;
                                            try {
                                                date2 = dateFormat.parse(enddate);
                                            } catch (ParseException f) {
                                                f.printStackTrace();
                                            }
                                            Junior staff = new Junior();
                                            staff.setGender(gender);
                                            staff.setName(name);
                                            staff.setID(ID);
                                            staff.setDateOfBirth(date);
                                            staff.setStartDate(date3);
                                            staff.setMonthlySalary(salary);
                                            staff.setExpectedEndDate(date2);
                                            Staffs.add(staff);
                                        }
                                    }
                                });
                            }
                        });
                        break;
                    }
                    case 2: {
                        label_name.setText("Delete Staff");
                        lspanel.setVisible(false);
                        apanel.setVisible(false);
                        aopanel.setVisible(false);
                        dpanel.setVisible(true);
                        bpanel.setVisible(false);
                        cpanel.setVisible(false);
                        /**
                         * button to take ıd and
                         */
                        button1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int ID = Integer.parseInt(textField1.getText());
                                int i, index = -1;
                                for (i = 0; i< Staffs.size(); i++) {
                                    if (Staffs.get(i).getID() == ID){
                                        index = i;
                                    }
                                }
                                if (index == -1)
                                    System.out.println("There is no staff with given ID number");
                                else{
                                    Staffs.remove(index);
                                    System.out.println("Staff successfully deleted");
                                }
                            }
                        });
                        break;
                    }

                    case 3:{
                        apanel.setVisible(false);
                        dpanel.setVisible(false);
                        aopanel.setVisible(false);
                        lspanel.setVisible(true);
                        table1.setVisible(false);
                        bpanel.setVisible(false);
                        cpanel.setVisible(false);
                        label_name2.setText("List Staff");
                        button2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String[] header = new String[] {"Type","Name", "ID", "Gender", "DateOfBirth", "StartDate","Salary"};
                                DefaultTableModel model = new DefaultTableModel(header,0);
                                table1.setModel(model);
                                table1.setVisible(true);
                                int ID = Integer.parseInt(textField2.getText());
                                int i, index = -1;
                                System.out.println(Staffs.get(0).getID());
                                for (i = 0; i< Staffs.size(); i++) {
                                    if (Staffs.get(i).getID() == ID){
                                        index = i;
                                    }
                                }
                                if (index == -1)
                                    System.out.println("There is no staff with given ID number");

                                else{
                                    if (Staffs.get(index).getClass().getSimpleName() == "Junior"){
                                        Object[] obje = {Staffs.get(index).getClass().getSimpleName(), Staffs.get(index).getName(), Staffs.get(index).getID(),Staffs.get(index).getGender(),Staffs.get(index).getDateOfBirth(),Staffs.get(index).getStartDate(),((Junior)Staffs.get(index)).getMonthlySalary()};
                                        model.addRow(obje);
                                    }
                                    else{
                                        try{
                                        Object[] obje = {Staffs.get(index).getClass().getSimpleName(), Staffs.get(index).getName(), Staffs.get(index).getID(),Staffs.get(index).getGender(),Staffs.get(index).getDateOfBirth(),Staffs.get(index).getStartDate(),((Senior)Staffs.get(index)).getGrossSalaryYear()};
                                        model.addRow(obje);}
                                        catch(IndexOutOfBoundsException y){

                                        }
                                    }
                                }
                            }
                        });
                        break;
                    }
                    case 4:{
                        apanel.setVisible(false);
                        dpanel.setVisible(false);
                        lspanel.setVisible(false);
                        table1.setVisible(false);
                        aopanel.setVisible(false);
                        cpanel.setVisible(true);
                        bpanel.setVisible(false);
                        createButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String name = textField4.getText();
                                int ID = Integer.parseInt(textField3.getText());
                                char gender = textField5.getText().charAt(0);
                                String dateOfBirth = textField6.getText();
                                String registrationDate = textField7.getText();
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                Date date = null;
                                Date date2 = null;
                                try{
                                    date = dateFormat.parse(dateOfBirth);
                                    date2 = dateFormat.parse(registrationDate);

                                } catch (ParseException h){
                                    h.printStackTrace();
                                }
                                String card = textField8.getText();

                                Customer customer = new Customer();
                                customer.setGender(gender);
                                customer.setName(name);
                                customer.setID(ID);
                                customer.setDateOfBirth(date);
                                customer.setRegistrationDate(date2);
                                customer.setCreditCardDetails(card);
                                Customers.add(customer);
                            }
                        });
                        break;
                    }

                    case 5:{
                        label_name.setText("Delete Customer");
                        lspanel.setVisible(false);
                        apanel.setVisible(false);
                        aopanel.setVisible(false);
                        dpanel.setVisible(true);
                        bpanel.setVisible(false);
                        cpanel.setVisible(false);
                        button1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int ID = Integer.parseInt(textField1.getText());
                                int i, index = -1;
                                for (i = 0; i< Customers.size(); i++) {
                                    if (Customers.get(i).getID() == ID){
                                        index = i;
                                        break;
                                    }
                                }
                                if (index == -1)
                                    System.out.println("There is no customer with given ID number");
                                else{
                                    Customers.remove(index);
                                    System.out.println("Customer successfully deleted");
                                }
                            }
                        });
                        break;
                    }

                    case 6:{
                        lspanel.setVisible(false);
                        apanel.setVisible(false);
                        dpanel.setVisible(false);
                        aopanel.setVisible(false);
                        cpanel.setVisible(false);
                        bpanel.setVisible(true);
                        textField10.setVisible(false);
                        createButton1.setVisible(false);
                        a.setVisible(false);
                        searchButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int ID = Integer.parseInt(textField9.getText());
                                int i, index = -1;
                                for (i = 0; i < Customers.size(); i++) {
                                    if (Customers.get(i).getID() == ID) {
                                        index = i;
                                        break;
                                    }
                                }
                                if (index == -1)
                                    System.out.println("There is no customer with given ID number");
                                else{
                                    textField10.setVisible(true);
                                    createButton1.setVisible(true);
                                    a.setVisible(true);
                                    int finalIndex = index;
                                    createButton1.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            String bookingDate = textField10.getText();
                                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                            Date date3 = null;
                                            try {
                                                date3 = dateFormat.parse(bookingDate);
                                            } catch (ParseException f) {
                                                f.printStackTrace();
                                            }

                                            Booking c_booking = new Booking();
                                            c_booking.setBookingDate(date3);
                                            Customers.get(finalIndex).makeBooking(c_booking);

                                        }
                                    });
                                }
                            }
                        });

                        break;
                    }

                    case 7:{
                        apanel.setVisible(false);
                        dpanel.setVisible(false);
                        lspanel.setVisible(true);
                        aopanel.setVisible(false);
                        table1.setVisible(false);
                        bpanel.setVisible(false);
                        cpanel.setVisible(false);
                        label_name2.setText("List Customer Details");
                        String[] header = new String[] {"Type","Name", "ID", "Gender", "DateOfBirth", "StartDate"};
                        DefaultTableModel model = new DefaultTableModel(header,0);
                        table1.setModel(model);
                        table1.setVisible(true);
                        int ID = Integer.parseInt(textField2.getText());
                        int i, index = -1;
                        for (i = 0; i< Customers.size(); i++) {
                            if (Customers.get(i).getID() == ID){
                                index = i;
                                break;
                            }
                        }
                        if (index == -1)
                            System.out.println("There is no staff with given ID number");
                        else{
                            Object[] obje = {Customers.get(index).getID(), Customers.get(index).getName(),Customers.get(index).getGender(),Customers.get(index).getDateOfBirth(),Customers.get(index).getRegistrationDate(),Customers.get(index).getCreditCardDetails()};
                            model.addRow(obje);
                        }
                        break;
                    }

                    case 8:{
                        apanel.setVisible(false);
                        dpanel.setVisible(false);
                        lspanel.setVisible(true);
                        table1.setVisible(false);
                        aopanel.setVisible(false);
                        bpanel.setVisible(false);
                        cpanel.setVisible(false);
                        label_name2.setText("Display Customer Last Booking");
                                String[] header = new String[] {"Type","Name"};
                                DefaultTableModel model = new DefaultTableModel(header,0);
                                table1.setModel(model);
                                table1.setVisible(true);
                                int ID = Integer.parseInt(textField2.getText());
                                int i, index = -1;
                                for (i = 0; i< Customers.size(); i++) {
                                    if (Customers.get(i).getID() == ID){
                                        index = i;
                                        break;
                                    }
                                }
                                if (index == -1)
                                    System.out.println("There is no staff with given ID number");

                                else{
                                    int count = 0;
                                    for (i = 0; i < Customers.get(index).getBookings().size(); i++){
                                        count++;
                                    }
                                    Object[] obje = {Customers.get(index).getBookings().get(count-1).getBookingDate(),Customers.get(index).getBookings().get(count-1).getBookingID()};
                                    model.addRow(obje);
                                }

                        break;
                    }


                    case 9:{
                        apanel.setVisible(false);
                        aopanel.setVisible(false);
                        dpanel.setVisible(false);
                        lspanel.setVisible(true);
                        table1.setVisible(false);
                        bpanel.setVisible(false);
                        cpanel.setVisible(false);
                        label_name2.setText("List Customer Orders");
                                String[] header = new String[] {"Type","Name","3","4","5"};
                                DefaultTableModel model = new DefaultTableModel(header,0);
                                table1.setModel(model);
                                table1.setVisible(true);
                                int ID = Integer.parseInt(textField2.getText());
                                int i, index = -1;
                                for (i = 0; i< Customers.size(); i++) {
                                    if (Customers.get(i).getID() == ID){
                                        index = i;
                                        break;
                                    }
                                }
                                if (index == -1)
                                    System.out.println("There is no staff with given ID number");

                                else{
                                    for (i = 0; i < Customers.get(index).getOrders().size(); i++) {
                                        if (Customers.get(index).getOrders().get(i).getClass().getSimpleName().equals("OnlineOrder")){
                                            Object[] obje = {((OnlineOrder)Customers.get(index).getOrders().get(i)).getOrderID(),Customers.get(index).getOrders().get(i).getOrderDate(),Customers.get(index).getOrders().get(i).getOrderDetails(),Customers.get(index).getOrders().get(i).getExtraNotes(),((OnlineOrder)Customers.get(index).getOrders().get(i)).getPaymentType()};
                                            model.addRow(obje);
                                        }
                                        else if (Customers.get(index).getOrders().get(i).getClass().getSimpleName().equals("InRestrOrder")){
                                            Object[] obje = {Customers.get(index).getOrders().get(i).getOrderID(),Customers.get(index).getOrders().get(i).getOrderDate(),Customers.get(index).getOrders().get(i).getOrderDetails(),Customers.get(index).getOrders().get(i).getExtraNotes(),((InRestrOrder)Customers.get(index).getOrders().get(i)).getTableNumber()};
                                            model.addRow(obje);
                                        }
                                    }
                                }
                        break;
                    }


                    case 10:{
                        apanel.setVisible(false);
                        dpanel.setVisible(false);
                        lspanel.setVisible(true);
                        table1.setVisible(false);
                        bpanel.setVisible(false);
                        aopanel.setVisible(false);
                        cpanel.setVisible(false);
                        sa.setVisible(false);
                        textField2.setVisible(false);
                        button2.setVisible(false);
                        label_name2.setText("List All Staff");
                                String[] header = new String[] {"Type","Name", "ID", "Gender", "DateOfBirth", "StartDate","Salary"};
                                DefaultTableModel model = new DefaultTableModel(header,0);
                                table1.setModel(model);
                                table1.setVisible(true);
                                int index;
                                if (Staffs.size() == 0)
                                    System.out.println("There is no staff with given ID number");

                                else{
                                    for (index = 0; index < Staffs.size(); index++){
                                        if (Staffs.get(index).getClass().getSimpleName() == "Junior"){
                                            Object[] obje = {Staffs.get(index).getClass().getSimpleName(), Staffs.get(index).getName(), Staffs.get(index).getID(),Staffs.get(index).getGender(),Staffs.get(index).getDateOfBirth(),Staffs.get(index).getStartDate(),((Junior)Staffs.get(index)).getMonthlySalary()};
                                            model.addRow(obje);
                                        }
                                        else{
                                            try{
                                                Object[] obje = {Staffs.get(index).getClass().getSimpleName(), Staffs.get(index).getName(), Staffs.get(index).getID(),Staffs.get(index).getGender(),Staffs.get(index).getDateOfBirth(),Staffs.get(index).getStartDate(),((Senior)Staffs.get(index)).getGrossSalaryYear()};
                                                model.addRow(obje);}
                                            catch(IndexOutOfBoundsException y){

                                            }
                                        }
                                    }
                                }
                    }

                    case 11:{
                        apanel.setVisible(false);
                        dpanel.setVisible(false);
                        lspanel.setVisible(true);
                        table1.setVisible(false);
                        bpanel.setVisible(false);
                        cpanel.setVisible(false);
                        aopanel.setVisible(false);
                        sa.setVisible(false);
                        textField2.setVisible(false);
                        button2.setVisible(false);
                        label_name2.setText("List All Customer Details");
                                String[] header = new String[] {"Type","Name", "ID", "Gender", "DateOfBirth", "StartDate"};
                                DefaultTableModel model = new DefaultTableModel(header,0);
                                table1.setModel(model);
                                table1.setVisible(true);
                                int ID = Integer.parseInt(textField2.getText());
                                int i, index = -1;
                                if (Customers.size() == 0)
                                    System.out.println("There is no registered Customer");

                                else{
                                    for (i = 0; i < Customers.size(); i++){
                                        Object[] obje = {Customers.get(index).getID(), Customers.get(index).getName(),Customers.get(index).getGender(),Customers.get(index).getDateOfBirth(),Customers.get(index).getRegistrationDate(),Customers.get(index).getCreditCardDetails()};
                                        model.addRow(obje);
                                    }
                                }
                        break;
                    }

                    case 12:{
                        apanel.setVisible(false);
                        dpanel.setVisible(false);
                        lspanel.setVisible(false);
                        table1.setVisible(false);
                        bpanel.setVisible(false);
                        cpanel.setVisible(false);
                        aopanel.setVisible(true);
                        comboBox1.addItem("Online Order");
                        comboBox1.addItem("InRest Order");
                        searchButton1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int ID = Integer.parseInt(textField15.getText());
                                int i, index = -1;
                                for (i = 0; i < Customers.size(); i++) {
                                    if (Customers.get(i).getID() == ID) {
                                        index = i;
                                        break;
                                    }
                                }
                                if (index == -1)
                                    System.out.println("There is no customer with given ID number");
                                else{
                                    int finalIndex = index;
                                    button3.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            int order = comboBox1.getSelectedIndex();
                                            button4.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    if (order == 0) {
                                                        abc.setText("Online Order");
                                                        String odate = textField11.getText();
                                                        String odetails = textField12.getText();
                                                        String extra = textField13.getText();
                                                        String payment = textField14.getText();
                                                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                                        Date date = null;
                                                        try {
                                                            date = dateFormat.parse(odate);
                                                        } catch (ParseException f) {
                                                            f.printStackTrace();
                                                        }
                                                        OnlineOrder oorder = new OnlineOrder();
                                                        oorder.setPaymentType(payment);
                                                        oorder.setExtraNotes(extra);
                                                        oorder.setOrderDate(date);
                                                        oorder.setOrderDetails(odetails);
                                                        Customers.get(finalIndex).getOrders().add(oorder);
                                                    }
                                                    else if (order == 1){
                                                        abc.setText("InRest Order");
                                                        String rdate = textField11.getText();
                                                        String rdetails = textField12.getText();
                                                        String extra = textField13.getText();
                                                        int table = Integer.parseInt(textField14.getText());
                                                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                                        Date date = null;
                                                        try {
                                                            date = dateFormat.parse(rdate);
                                                        } catch (ParseException f) {
                                                            f.printStackTrace();
                                                        }
                                                        InRestrOrder oorder = new InRestrOrder();
                                                        oorder.setTableNumber(table);
                                                        oorder.setExtraNotes(extra);
                                                        oorder.setOrderDate(date);
                                                        oorder.setOrderDetails(rdetails);
                                                        Customers.get(finalIndex).getOrders().add(oorder);
                                                    }
                                                }
                                            });
                                        }

                                    });
                                }
                            }
                        });
                        break;
                    }

                    case 13:{
                        apanel.setVisible(false);
                        dpanel.setVisible(false);
                        lspanel.setVisible(true);
                        table1.setVisible(false);
                        bpanel.setVisible(false);
                        cpanel.setVisible(false);
                        aopanel.setVisible(false);
                        sa.setVisible(false);
                        textField2.setVisible(false);
                        button2.setVisible(false);
                        label_name2.setText("List All Customer Details");
                        String[] header = new String[] {"Type"};
                        DefaultTableModel model = new DefaultTableModel(header,0);
                        table1.setModel(model);
                        table1.setVisible(true);

                        int i, index = -1;
                        if (Customers.size() == 0)
                            System.out.println("There is no registered Customer");

                        else{
                            for (i=0; i < Staffs.size(); i++){
                                Object[] obje = {Staffs.get(i).getSalary()};
                                model.addRow(obje);
                            }
                        }
                        break;
                    }


                    /*case 14:{
                        int i = 0;
                        for (i = 0; i < Customers.size(); i++) {
                            apanel.setVisible(false);
                            dpanel.setVisible(false);
                            lspanel.setVisible(true);
                            table1.setVisible(false);
                            bpanel.setVisible(false);
                            cpanel.setVisible(false);
                            aopanel.setVisible(false);
                            sa.setVisible(false);
                            textField2.setVisible(false);
                            button2.setVisible(false);
                            label_name2.setText("List All Customer Details");
                            String[] header = new String[] {"Type","Name", "ID", "Gender", "DateOfBirth", "StartDate"};
                            DefaultTableModel model = new DefaultTableModel(header,0);
                            table1.setModel(model);
                            table1.setVisible(true);
                            int ID = Integer.parseInt(textField2.getText());
                            int index = -1;
                            if (Customers.size() == 0)
                                System.out.println("There is no registered Customer");

                            else{
                                for (i = 0; i < Customers.size(); i++){
                                    Object[] obje = {Customers.get(index).getID(), Customers.get(index).getName(),Customers.get(index).getGender(),Customers.get(index).getDateOfBirth(),Customers.get(index).getRegistrationDate(),Customers.get(index).getCreditCardDetails()};
                                    model.addRow(obje);
                                }
                            }
                        }
                        break;
                    }


                    case 15:{
                        System.out.println("Enter the Customer ID and Booking ID:");
                        int ID = myObj.nextInt();
                        int ID2 = myObj.nextInt();
                        addOrderOfBooking(Customers,ID,ID2);
                        break;
                    }*/
                }
            }

    });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
}
