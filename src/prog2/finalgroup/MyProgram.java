/**
 * @author Jasmin, Ramon Emmiel
 * @author Domingo, Diamond Darrel
 * @author Rabang, Gebreyl Isaac
 * @author Baltazar, Rudyard Lans
 * @author Urbiztondo, Karl Jasper
 * @author Bumanglag, AU
 *
 * This project scans and analyzes a particular database of citizens and shows 5 functional and informative outputs.
 */
package prog2.finalgroup;

import java.io.File;
import java.lang.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.*;
import java.awt.*;
import java.util.*;


public class MyProgram extends JFrame{

    public final MyProgramUtility util = new MyProgramUtility();

    public final File dataFile = new File("JasminBaltazarBumanglagDomingoRabangUrbiztondo9301FinalGroupProject/res/data.txt");

    public final ArrayList<Citizen> citizens = util.readData(dataFile);

    public static void main(String[] args) {
        MyProgram gui = new MyProgram();
    }

    public MyProgram(){
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints con = new GridBagConstraints();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(grid);

        JLabel headLabel = new JLabel("<html><div style='color: #4863A0;'>Citizens' Database Analysis");
        headLabel.setFont(new Font("Dublin", Font.BOLD, 35));
        headLabel.setHorizontalAlignment(SwingConstants.CENTER);
        con.gridx = 0;
        con.gridy = 0;
        con.gridwidth = GridBagConstraints.REMAINDER;
        con.gridheight = 1;
        con.weightx = 1;
        con.insets = new Insets(0, 0, 10, 0);
        con.anchor = GridBagConstraints.PAGE_START;
        con.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(headLabel, con);

        JLabel description = new JLabel("<html> <div style='text-align: center;'>This program analyzes a citizens' database and generates <br> five functional and informative outputs based on the data provided.");
        description.setFont(new Font("Dublin", Font.PLAIN, 16));
        description.setHorizontalAlignment(SwingConstants.CENTER);
        con.gridx = 0;
        con.gridy = 1;
        con.gridwidth = GridBagConstraints.REMAINDER;
        con.gridheight = 1;
        con.weightx = 1;
        con.insets = new Insets(5, 0, 70, 0);
        con.anchor = GridBagConstraints.CENTER;
        con.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(description, con);


        JButton findCitizenBtn = new JButton("<html> <div style='text-align: center;'>Find a Citizen");
        findCitizenBtn.setPreferredSize(new Dimension(150, 50));
        findCitizenBtn.setBorder(BorderFactory.createEmptyBorder());
        findCitizenBtn.setBackground(Color.decode("#728FCE"));
        findCitizenBtn.setForeground(Color.decode("#F5F5F5"));
        con.gridx = 0;
        con.gridy = 3;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.weightx = 1;
        con.fill = GridBagConstraints.NONE;
        con.anchor = GridBagConstraints.PAGE_END;
        mainPanel.add(findCitizenBtn, con);

        JButton showCitizensBtn = new JButton("<html> <div style='text-align: center;'>Show Citizens");
        showCitizensBtn.setPreferredSize(new Dimension(150, 50));
        showCitizensBtn.setBorder(BorderFactory.createEmptyBorder());
        showCitizensBtn.setBackground(Color.decode("#728FCE"));
        showCitizensBtn.setForeground(Color.decode("#F5F5F5"));
        con.gridx = 1;
        con.gridy = 3;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.weightx = 1;
        con.fill = GridBagConstraints.NONE;
        con.anchor = GridBagConstraints.PAGE_END;
        mainPanel.add(showCitizensBtn, con);

        JButton showOldestYoungestBtn = new JButton("<html> <div style='text-align: center;'>Oldest and Youngest Citizens </div>");
        showOldestYoungestBtn.setPreferredSize(new Dimension(150, 50));
        showOldestYoungestBtn.setBorder(BorderFactory.createEmptyBorder());
        showOldestYoungestBtn.setBackground(Color.decode("#728FCE"));
        showOldestYoungestBtn.setForeground(Color.decode("#F5F5F5"));
        con.gridx = 2;
        con.gridy = 3;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.weightx = 1;
        con.fill = GridBagConstraints.NONE;
        con.anchor = GridBagConstraints.PAGE_END;
        mainPanel.add(showOldestYoungestBtn, con);

        JButton ageRangeBtn = new JButton("<html> <div style='text-align: center;'>Age Range");
        ageRangeBtn.setPreferredSize(new Dimension(150, 50));
        ageRangeBtn.setBorder(BorderFactory.createEmptyBorder());
        ageRangeBtn.setBackground(Color.decode("#728FCE"));
        ageRangeBtn.setForeground(Color.decode("#F5F5F5"));
        con.gridx = 3;
        con.gridy = 3;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.weightx = 1;
        con.fill = GridBagConstraints.NONE;
        con.anchor = GridBagConstraints.PAGE_END;
        mainPanel.add(ageRangeBtn, con);

        JButton demographicsBtn = new JButton("<html> <div style='text-align: center;'>Population Demographics");
        demographicsBtn.setPreferredSize(new Dimension(150, 50));
        demographicsBtn.setBorder(BorderFactory.createEmptyBorder());
        demographicsBtn.setBackground(Color.decode("#728FCE"));
        demographicsBtn.setForeground(Color.decode("#F5F5F5"));
        con.gridx = 4;
        con.gridy = 3;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.weightx = 1;
        con.fill = GridBagConstraints.NONE;
        con.anchor = GridBagConstraints.PAGE_END;
        mainPanel.add(demographicsBtn, con);

        findCitizenBtn.addActionListener(e -> {
            try{
                findCitizen();
            }catch (Exception x){
                System.out.println("An error occurred while executing Find Citizen program");
                x.printStackTrace();
            }
        });

        showCitizensBtn.addActionListener(e -> {
            try {
                showCitizens();
            }catch (Exception x){
                System.out.println("An error occurred while executing Show Citizen program");
                x.printStackTrace();
            }
        });

        showOldestYoungestBtn.addActionListener(e -> {
            try {
                showOldestYoungest();
            }catch (Exception x){
                System.out.println("An error occurred while executing Show Youngest and Oldest program");
                x.printStackTrace();
            }
        });

        ageRangeBtn.addActionListener(e -> {
            try{
                showAgeRange();
            }catch (Exception x){
                System.out.println("An error occurred while executing Show Citizens by Age Range program");
                x.printStackTrace();
            }
        });

        demographicsBtn.addActionListener(e -> {
            try{
                showAgeDemographics();
            }catch(Exception x){
                System.out.println("An error occurred while executing Show Age Demographics program");
                x.printStackTrace();
            }
        });



        add(mainPanel);

        setSize(850,350);
        setVisible(true);
        setTitle("Population Data Analysis");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void findCitizen() throws Exception{
        JFrame findCitizenFrame = new JFrame("Find a Citizen");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JLabel title = new JLabel("FIND A CITIZEN");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setOpaque(true);
        title.setBackground(Color.decode("#728FCE"));
        title.setForeground(Color.decode("#F5F5F5"));
        title.setFont(new Font("Dublin", Font.BOLD, 20));
        mainPanel.add(title, BorderLayout.PAGE_START);

        JLabel footer = new JLabel("CITIZENS' DATABASE ANALYSIS");
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        footer.setOpaque(true);
        footer.setBackground(Color.decode("#728FCE"));
        footer.setForeground(Color.decode("#F5F5F5"));
        footer.setFont(new Font("Dublin", Font.BOLD, 20));
        mainPanel.add(footer,BorderLayout.PAGE_END);


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel row1Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        row1Panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel nameLabel = new JLabel("Enter Surname:");
        nameLabel.setFont(new Font("Courier", Font.PLAIN, 18));
        row1Panel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(100, nameField.getPreferredSize().height));
        nameField.setBorder(BorderFactory.createEmptyBorder());
        row1Panel.add(nameField);

        JLabel ageLabel = new JLabel("Enter Age:");
        ageLabel.setFont(new Font("Courier", Font.PLAIN, 18));
        ageLabel.setBorder(BorderFactory.createEmptyBorder(0,30,0,0));
        row1Panel.add(ageLabel);

        JTextField ageField = new JTextField();
        ageField.setPreferredSize(new Dimension(30, ageField.getPreferredSize().height));
        ageField.setBorder(BorderFactory.createEmptyBorder());
        ((AbstractDocument) ageField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String text,
                                     AttributeSet attr) throws BadLocationException {
                if (text.matches("\\d{0,3}") && (fb.getDocument().getLength() + text.length() <= 3)) {
                    // allow only digits and maximum 3 characters
                    super.insertString(fb, offset, text, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text,
                                AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d{0,3}") && (fb.getDocument().getLength() - length + text.length() <= 3)) {
                    // allow only digits and maximum 3 characters
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        row1Panel.add(ageField);

        centerPanel.add(row1Panel);


        JPanel row2Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        row2Panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton findBtn = new JButton("Search Citizen");
        findBtn.setBackground(Color.decode("#728FCE"));
        findBtn.setForeground(Color.decode("#F5F5F5"));
        findBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        row2Panel.add(findBtn);

        centerPanel.add(row2Panel);
        centerPanel.add(Box.createVerticalStrut(50));

        JPanel row3Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        row3Panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel cNameLabel = new JLabel("NAME: ");
        cNameLabel.setFont(new Font("Courier", Font.PLAIN, 14));
        row3Panel.add(cNameLabel);

        JTextField cNameField = new JTextField();
        cNameField.setEditable(false);
        cNameField.setPreferredSize(new Dimension(150, nameField.getPreferredSize().height));
        row3Panel.add(cNameField);

        JLabel cAgeLabel = new JLabel("AGE: ");
        cAgeLabel.setFont(new Font("Courier", Font.PLAIN, 14));
        cAgeLabel.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        row3Panel.add(cAgeLabel);

        JTextField cAgeField = new JTextField();
        cAgeField.setEditable(false);
        cAgeField.setPreferredSize(new Dimension(30, ageField.getPreferredSize().height));
        row3Panel.add(cAgeField);

        JLabel cSexLabel = new JLabel("SEX: ");
        cSexLabel.setFont(new Font("Courier", Font.PLAIN, 14));
        cSexLabel.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        row3Panel.add(cSexLabel);

        JTextField cSexField = new JTextField();
        cSexField.setEditable(false);
        cSexField.setPreferredSize(new Dimension(30, cSexField.getPreferredSize().height));
        row3Panel.add(cSexField);

        centerPanel.add(row3Panel);

        JPanel row4Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row4Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        row4Panel.add(Box.createHorizontalStrut(93));


        JLabel cEmailLabel = new JLabel("EMAIL: ");
        cEmailLabel.setFont(new Font("Courier", Font.PLAIN, 14));
        row4Panel.add(cEmailLabel);

        JTextField cEmailField = new JTextField();
        cEmailField.setEditable(false);
        cEmailField.setPreferredSize(new Dimension(300, cEmailField.getPreferredSize().height));
        row4Panel.add(cEmailField);

        centerPanel.add(row4Panel);

        JPanel row5Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row5Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        row5Panel.add(Box.createHorizontalStrut(83));

        JLabel cResidencyLabel = new JLabel("RESIDENCY: ");
        cResidencyLabel.setFont(new Font("Courier", Font.PLAIN, 14));
        cResidencyLabel.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        row5Panel.add(cResidencyLabel);

        JTextField cResidencyField = new JTextField();
        cResidencyField.setEditable(false);
        cResidencyField.setPreferredSize(new Dimension(90, cResidencyField.getPreferredSize().height));
        row5Panel.add(cResidencyField);

        JLabel cDistrictLabel = new JLabel("DISTRICT: ");
        cDistrictLabel.setFont(new Font("Courier", Font.PLAIN, 14));
        cDistrictLabel.setBorder(BorderFactory.createEmptyBorder(0,28,0,0));
        row5Panel.add(cDistrictLabel);

        JTextField cDistrictField = new JTextField();
        cDistrictField.setEditable(false);
        cDistrictField.setPreferredSize(new Dimension(30, cDistrictField.getPreferredSize().height));
        row5Panel.add(cDistrictField);

        centerPanel.add(row5Panel);

        JPanel row6Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row6Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        row6Panel.add(Box.createHorizontalStrut(93));

        JLabel cAddyLabel = new JLabel("ADDRESS: ");
        cAddyLabel.setFont(new Font("Courier", Font.PLAIN, 14));
        row6Panel.add(cAddyLabel);

        JTextField cAddyField = new JTextField();
        cAddyField.setEditable(false);
        cAddyField.setPreferredSize(new Dimension(300, cAddyField.getPreferredSize().height));
        row6Panel.add(cAddyField);

        centerPanel.add(row6Panel);
        centerPanel.add(Box.createVerticalStrut(30));


        mainPanel.add(centerPanel, BorderLayout.CENTER);

        findBtn.addActionListener(e -> {
            String surname = nameField.getText();
            int age = Integer.parseInt(ageField.getText());

            Citizen matchedCitizen = util.getCitizenBySurnameAndAge(citizens, surname, age);

            if (matchedCitizen == null){
                footer.setBackground(Color.red);
                footer.setForeground(Color.WHITE);
                footer.setText("NOT FOUND!");
            }else {
                cNameField.setText(matchedCitizen.getFullName());
                cAgeField.setText(Integer.toString(matchedCitizen.getAge()));
                cSexField.setText(Character.toString(matchedCitizen.getGender()));
                cEmailField.setText(matchedCitizen.getEmail());
                cResidencyField.setText((matchedCitizen.getResident() == true) ? "Resident" : "Non-Resident");
                cDistrictField.setText(Integer.toString(matchedCitizen.getDistrict()));
                cAddyField.setText(matchedCitizen.getAddress());
                footer.setBackground(Color.GREEN);
                footer.setForeground(Color.WHITE);
                footer.setText("MATCHED!");
            }
        });


        findCitizenFrame.getContentPane().add(mainPanel);
        findCitizenFrame.setVisible(true);
        findCitizenFrame.setResizable(false);
        findCitizenFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        findCitizenFrame.pack();
        findCitizenFrame.setLocationRelativeTo(null);
        findCitizenFrame.setSize(600,350);
    }

    private void showCitizens() throws Exception{
        JFrame mainFrame = new JFrame("Show Citizens");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JLabel header = new JLabel("SHOW CITIZENS BASED ON FILTERS");
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setOpaque(true);
        header.setBackground(Color.decode("#728FCE"));
        header.setForeground(Color.decode("#F5F5F5"));
        header.setFont(new Font("Dublin", Font.BOLD, 20));
        mainPanel.add(header, BorderLayout.PAGE_START);

        JLabel footer = new JLabel("CITIZENS' DATABASE ANALYSIS");
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        footer.setOpaque(true);
        footer.setBackground(Color.decode("#728FCE"));
        footer.setForeground(Color.decode("#F5F5F5"));
        footer.setFont(new Font("Dublin", Font.BOLD, 20));
        mainPanel.add(footer, BorderLayout.SOUTH);

        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        JLabel filterLabel = new JLabel("FILTERS");
        filterLabel.setHorizontalAlignment(SwingConstants.CENTER);
        filterLabel.setFont(new Font("Dublin", Font.BOLD, 20));
        filterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        center.add(filterLabel);

        center.add(Box.createVerticalStrut(15));

        JPanel filterLabelsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,100,0));
        filterLabelsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);


        JLabel districtLabel = new JLabel("DISTRICTS");
        districtLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        districtLabel.setHorizontalAlignment(SwingConstants.CENTER);
        districtLabel.setFont(new Font("Dublin", Font.PLAIN, 14));
        districtLabel.setPreferredSize(new Dimension(100,15));
        filterLabelsPanel.add(districtLabel);

        JLabel residentLabel = new JLabel("RESIDENCY");
        residentLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        residentLabel.setHorizontalAlignment(SwingConstants.CENTER);
        residentLabel.setFont(new Font("Dublin", Font.PLAIN, 14));
        residentLabel.setPreferredSize(new Dimension(100,15));
        filterLabelsPanel.add(residentLabel);

        JLabel sexLabel = new JLabel("SEX");
        sexLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sexLabel.setHorizontalAlignment(SwingConstants.CENTER);
        sexLabel.setFont(new Font("Dublin", Font.PLAIN, 14));
        sexLabel.setPreferredSize(new Dimension(100,15));
        filterLabelsPanel.add(sexLabel);

        JPanel filterChoicePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100,0));
        filterChoicePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        Integer[] districtList = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        JComboBox district = new JComboBox(districtList);
        district.setPreferredSize(new Dimension(100,20));
        filterChoicePanel.add(district);

        String[] residencyList = {"Resident", "Non-Resident"};
        JComboBox residency = new JComboBox(residencyList);
        residency.setPreferredSize(new Dimension(100,20));
        filterChoicePanel.add(residency);

        String[] sexList = {"Male", "Female"};
        JComboBox sex = new JComboBox(sexList);
        sex.setPreferredSize(new Dimension(100,20));
        filterChoicePanel.add(sex);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,100,0));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);


        JButton displayCitizens = new JButton("Display Citizens");
        displayCitizens.setBackground(Color.decode("#728FCE"));
        displayCitizens.setForeground(Color.decode("#F5F5F5"));
        displayCitizens.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(displayCitizens);

        JPanel tablePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        tablePanel.setAlignmentX(Component.CENTER_ALIGNMENT);


        JTable table = new JTable(new DefaultTableModel(new Object[]{"NAME", "AGE", "SEX", "DISTRICT", "ADDRESS", "EMAIL", "RESIDENCY"}, 0));
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(30);
        table.getColumnModel().getColumn(2).setPreferredWidth(30);
        table.getColumnModel().getColumn(3).setPreferredWidth(30);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
        table.getColumnModel().getColumn(5).setPreferredWidth(200);
        table.getColumnModel().getColumn(6).setPreferredWidth(50);
        table.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()) {
            @Override
            public boolean isCellEditable(EventObject e) {
                return false;
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(950,scrollPane.getPreferredSize().height));
        tablePanel.add(scrollPane);

        displayCitizens.addActionListener(e -> {
            ArrayList<Citizen> filteredCitizens = util.getCitizensPerFilter(citizens, Integer.parseInt(district.getSelectedItem().toString()),
                    residency.getSelectedItem().toString().equalsIgnoreCase("Resident") ? true : false,
                    sex.getSelectedItem().toString().charAt(0));

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            for (Citizen citizen : filteredCitizens) {
                Object[] citizenData = {citizen.getFullName(), citizen.getAge(), citizen.getGender(), citizen.getDistrict(), citizen.getAddress(), citizen.getEmail(), (citizen.getResident() == true) ? "Resident" : "Non-Resident"};
                model.addRow(citizenData);
            }


        });


        center.add(filterLabelsPanel);
        center.add(filterChoicePanel);
        center.add(buttonPanel);
        center.add(tablePanel);


        mainPanel.add(center);

        mainFrame.getContentPane().add(mainPanel);
        mainFrame.setSize(1000,700);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
    }

    private void showOldestYoungest() throws Exception{
        JFrame mainFrame = new JFrame();
        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel header = new JLabel("YOUNGEST AND OLDEST");
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setOpaque(true);
        header.setBackground(Color.decode("#728FCE"));
        header.setForeground(Color.decode("#F5F5F5"));
        header.setFont(new Font("Dublin", Font.BOLD, 20));
        mainPanel.add(header, BorderLayout.PAGE_START);

        JLabel footer = new JLabel("CITIZENS' DATABASE ANALYSIS");
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        footer.setOpaque(true);
        footer.setBackground(Color.decode("#728FCE"));
        footer.setForeground(Color.decode("#F5F5F5"));
        footer.setFont(new Font("Dublin", Font.BOLD, 20));
        mainPanel.add(footer, BorderLayout.SOUTH);

        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,100, 0));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton showYoungest = new JButton("YOUNGEST CITIZENS");
        showYoungest.setPreferredSize(new Dimension(200, 50));
        showYoungest.setBackground(Color.decode("#728FCE"));
        showYoungest.setForeground(Color.decode("#F5F5F5"));
        showYoungest.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(showYoungest);

        JButton showOldest = new JButton("OLDEST CITIZENS");
        showOldest.setPreferredSize(new Dimension(200, 50));
        showOldest.setBackground(Color.decode("#728FCE"));
        showOldest.setForeground(Color.decode("#F5F5F5"));
        showOldest.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(showOldest);

        JPanel tablePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        tablePanel.setAlignmentX(Component.CENTER_ALIGNMENT);


        JTable table = new JTable(new DefaultTableModel(new Object[]{"NAME", "AGE", "SEX", "DISTRICT", "ADDRESS", "EMAIL", "RESIDENCY"}, 0));
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(30);
        table.getColumnModel().getColumn(2).setPreferredWidth(30);
        table.getColumnModel().getColumn(3).setPreferredWidth(30);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
        table.getColumnModel().getColumn(5).setPreferredWidth(200);
        table.getColumnModel().getColumn(6).setPreferredWidth(50);
        table.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()) {
            @Override
            public boolean isCellEditable(EventObject e) {
                return false;
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(950,300));
        tablePanel.add(scrollPane);

        showYoungest.addActionListener(e -> {
            ArrayList<Citizen> youngest = util.getYoungestCitizens(citizens);


            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            for (Citizen citizen : youngest) {
                Object[] citizenData = {citizen.getFullName(), citizen.getAge(), citizen.getGender(), citizen.getDistrict(), citizen.getAddress(), citizen.getEmail(), (citizen.getResident() == true) ? "Resident" : "Non-Resident"};
                model.addRow(citizenData);
            }
        });

        showOldest.addActionListener(e -> {
            ArrayList<Citizen> oldest = util.getOldestCitizens(citizens);

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            for (Citizen citizen : oldest) {
                Object[] citizenData = {citizen.getFullName(), citizen.getAge(), citizen.getGender(), citizen.getDistrict(), citizen.getAddress(), citizen.getEmail(), (citizen.getResident() == true) ? "Resident" : "Non-Resident"};
                model.addRow(citizenData);
            }
        });


        center.add(Box.createVerticalStrut(10));
        center.add(buttonPanel);
        center.add(Box.createVerticalStrut(10));
        center.add(tablePanel);

        mainPanel.add(center);

        mainFrame.getContentPane().add(mainPanel);
        mainFrame.setSize(1000,500);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
    }

    private void showAgeRange() throws Exception{
        JFrame mainFrame = new JFrame();
        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel header = new JLabel("CITIZENS WITHIN AGE RANGE");
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setOpaque(true);
        header.setBackground(Color.decode("#728FCE"));
        header.setForeground(Color.decode("#F5F5F5"));
        header.setFont(new Font("Dublin", Font.BOLD, 20));
        mainPanel.add(header, BorderLayout.PAGE_START);

        JLabel footer = new JLabel("CITIZENS' DATABASE ANALYSIS");
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        footer.setOpaque(true);
        footer.setBackground(Color.decode("#728FCE"));
        footer.setForeground(Color.decode("#F5F5F5"));
        footer.setFont(new Font("Dublin", Font.BOLD, 20));
        mainPanel.add(footer, BorderLayout.SOUTH);

        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        JPanel rangeInputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0,0));
        rangeInputPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lowerLabel = new JLabel("Lower Limit: ");
        lowerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lowerLabel.setFont(new Font("Dublin", Font.BOLD, 20));
        lowerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rangeInputPanel.add(lowerLabel);

        JTextField lowerField = new JTextField();
        lowerField.setPreferredSize(new Dimension(50,30));
        lowerField.setHorizontalAlignment(SwingConstants.LEFT);
        lowerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ((AbstractDocument) lowerField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String text,
                                     AttributeSet attr) throws BadLocationException {
                if (text.matches("\\d{0,3}") && (fb.getDocument().getLength() + text.length() <= 3)) {
                    // allow only digits and maximum 3 characters
                    super.insertString(fb, offset, text, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text,
                                AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d{0,3}") && (fb.getDocument().getLength() - length + text.length() <= 3)) {
                    // allow only digits and maximum 3 characters
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        rangeInputPanel.add(lowerField);



        JLabel upperLabel = new JLabel("Upper Limit: ");
        upperLabel.setHorizontalAlignment(SwingConstants.CENTER);
        upperLabel.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
        upperLabel.setFont(new Font("Dublin", Font.BOLD, 20));
        upperLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rangeInputPanel.add(upperLabel);

        JTextField upperField = new JTextField();
        upperField.setPreferredSize(new Dimension(50,30));
        upperField.setHorizontalAlignment(SwingConstants.LEFT);
        upperField.setAlignmentX(Component.CENTER_ALIGNMENT);
        ((AbstractDocument) upperField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String text,
                                     AttributeSet attr) throws BadLocationException {
                if (text.matches("\\d{0,3}") && (fb.getDocument().getLength() + text.length() <= 3)) {
                    super.insertString(fb, offset, text, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text,
                                AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d{0,3}") && (fb.getDocument().getLength() - length + text.length() <= 3)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        rangeInputPanel.add(upperField);


        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton ageRangeBtn = new JButton("<html><center>SHOW CITIZENS <br>WITHIN AGE RANGE");
        ageRangeBtn.setPreferredSize(new Dimension(200, 50));
        ageRangeBtn.setBackground(Color.decode("#728FCE"));
        ageRangeBtn.setForeground(Color.decode("#F5F5F5"));
        ageRangeBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(ageRangeBtn);

        JPanel populationCountPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        populationCountPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel populationCountLabel = new JLabel("CITIZENS' POPULATION WITHIN AGE RANGE: ");
        populationCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        populationCountLabel.setFont(new Font("Dublin", Font.BOLD, 16));
        populationCountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        populationCountPanel.add(populationCountLabel);

        JTextField populationCountField = new JTextField();
        populationCountField.setEditable(false);
        populationCountField.setPreferredSize(new Dimension(50,25));
        populationCountField.setHorizontalAlignment(SwingConstants.LEFT);
        populationCountField.setAlignmentX(Component.CENTER_ALIGNMENT);
        populationCountPanel.add(populationCountField);

        JPanel tablePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        tablePanel.setAlignmentX(Component.CENTER_ALIGNMENT);


        JTable table = new JTable(new DefaultTableModel(new Object[]{"NAME", "AGE", "SEX", "DISTRICT", "ADDRESS", "EMAIL", "RESIDENCY"}, 0));
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(30);
        table.getColumnModel().getColumn(2).setPreferredWidth(30);
        table.getColumnModel().getColumn(3).setPreferredWidth(30);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
        table.getColumnModel().getColumn(5).setPreferredWidth(200);
        table.getColumnModel().getColumn(6).setPreferredWidth(50);
        table.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()) {
            @Override
            public boolean isCellEditable(EventObject e) {
                return false;
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(950,230));
        tablePanel.add(scrollPane);

        ageRangeBtn.addActionListener(e -> {
            ArrayList<Citizen> ageRangeCitizens = util.citizensPerAgeRange(citizens, Integer.parseInt(lowerField.getText()), Integer.parseInt(upperField.getText()));

            populationCountField.setText(Integer.toString(ageRangeCitizens.size()));
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            for (Citizen citizen : ageRangeCitizens) {
                Object[] citizenData = {citizen.getFullName(), citizen.getAge(), citizen.getGender(), citizen.getDistrict(), citizen.getAddress(), citizen.getEmail(), (citizen.getResident() == true) ? "Resident" : "Non-Resident"};
                model.addRow(citizenData);
            }
        });


        center.add(Box.createVerticalStrut(10));
        center.add(rangeInputPanel);
        center.add(Box.createVerticalStrut(10));
        center.add(buttonPanel);
        center.add(Box.createVerticalStrut(10));
        center.add(populationCountPanel);
        center.add(tablePanel);

        mainPanel.add(center);

        mainFrame.getContentPane().add(mainPanel);
        mainFrame.setSize(1000,500);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
    }

    private void showAgeDemographics() throws Exception{
        JFrame mainFrame = new JFrame();
        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel header = new JLabel("AGE DEMOGRAPHICS");
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setOpaque(true);
        header.setBackground(Color.decode("#728FCE"));
        header.setForeground(Color.decode("#F5F5F5"));
        header.setFont(new Font("Dublin", Font.BOLD, 20));
        mainPanel.add(header, BorderLayout.PAGE_START);

        JLabel footer = new JLabel("CITIZENS' DATABASE ANALYSIS");
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        footer.setOpaque(true);
        footer.setBackground(Color.decode("#728FCE"));
        footer.setForeground(Color.decode("#F5F5F5"));
        footer.setFont(new Font("Dublin", Font.BOLD, 20));
        mainPanel.add(footer, BorderLayout.SOUTH);

        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        JPanel meanMedianMode = new JPanel(new FlowLayout(FlowLayout.CENTER));
        meanMedianMode.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel meanLabel = new JLabel("AGE MEAN: ");
        meanLabel.setHorizontalAlignment(SwingConstants.CENTER);
        meanLabel.setFont(new Font("Dublin", Font.BOLD, 14));
        meanLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        meanMedianMode.add(meanLabel);

        JTextField meanField = new JTextField();
        meanField.setText(Double.toString(util.calculateMeanAge(citizens)));
        meanField.setEditable(false);
        meanField.setPreferredSize(new Dimension(50,25));
        meanField.setHorizontalAlignment(SwingConstants.LEFT);
        meanField.setAlignmentX(Component.CENTER_ALIGNMENT);
        meanMedianMode.add(meanField);

        JLabel medianLabel = new JLabel("AGE MEDIAN: ");
        medianLabel.setHorizontalAlignment(SwingConstants.CENTER);
        medianLabel.setFont(new Font("Dublin", Font.BOLD, 14));
        medianLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        meanMedianMode.add(medianLabel);

        JTextField medianField = new JTextField();
        medianField.setText(Integer.toString((int)(util.calculateMedianAge(citizens))));
        medianField.setEditable(false);
        medianField.setPreferredSize(new Dimension(50,25));
        medianField.setHorizontalAlignment(SwingConstants.LEFT);
        medianField.setAlignmentX(Component.CENTER_ALIGNMENT);
        meanMedianMode.add(medianField);

        JLabel modeLabel = new JLabel("AGE MODE: ");
        modeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        modeLabel.setFont(new Font("Dublin", Font.BOLD, 14));
        modeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        meanMedianMode.add(modeLabel);

        JTextField modeField = new JTextField();
        modeField.setText(Integer.toString((int)(util.calculateModeAge(citizens))));
        modeField.setEditable(false);
        modeField.setPreferredSize(new Dimension(50,25));
        modeField.setHorizontalAlignment(SwingConstants.LEFT);
        modeField.setAlignmentX(Component.CENTER_ALIGNMENT);
        meanMedianMode.add(modeField);

        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        imagePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        ImageIcon imageIcon = new ImageIcon("JasminBaltazarBumanglagDomingoRabangUrbiztondo9301FinalGroupProject/res/populationDemographics.png");
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(800, 500, Image.SCALE_SMOOTH);

        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(scaledImageIcon);

        imagePanel.add(imageLabel);

        JPanel lastPanel = new JPanel( new FlowLayout(FlowLayout.CENTER));
        lastPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel ageRangeLabel = new JLabel("AGE RANGE");
        ageRangeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ageRangeLabel.setFont(new Font("Dublin", Font.BOLD, 14));
        ageRangeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        lastPanel.add(ageRangeLabel);


        center.add(Box.createVerticalStrut(10));
        center.add(meanMedianMode);
        center.add(Box.createVerticalStrut(10));
        center.add(imagePanel);
        center.add(lastPanel);


        mainPanel.add(center);

        mainFrame.getContentPane().add(mainPanel);
        mainFrame.setSize(1000,700);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
    }
}
