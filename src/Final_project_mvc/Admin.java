package Final_project_mvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Admin extends JFrame implements ActionListener{
	JPanel head_JPanel,user_panel,user_panel_information,delete_users,booking_panel;
	JPanel booking_panel_information,cancel_bookings,allbackimage,delete_userfield,update_userfield;
	JPanel care_center_panelJPanel,care_centerpanel_information,edit_center_panel;
	JPanel delete_carecenter_image,insertcenterpanel;
	DefaultTableModel model,booking_model,carecenter_model;
	JTable table,booking_table,carecenter_table;
	String register_usernamme="";
	JLabel profile_emaiL,profile_petType,profile_petName,profile_petHeight,profile_petWeight;
	int booking_id;
	int center_id;
	JButton updating_users_button,delete_users_butoon,delete_carecenter_butoon,insert_carecenter_butoon;
	JLabel profile_username,kg,m,center_id_textfield;
	JTextField center_name_textfield,center_location_textfield,center_food_textfield,center_price_textfield,center_available_textfield;
    JButton enable_carecenterButton,disable_carecenterButton,creButton;
    JTextField enter_carecenternameField,enter_carecenterFiellocationfield,enter_carecenter_daypricefield,enter_carecenter_contentfield;
    JComboBox petlist;
    JButton users,bookings,care_centers;
    boolean typingStarted = false;
    JRadioButton  enter_carecenterfoodmeat_field,enter_carecenterfoodfish_field,enter_carecenterfoodpoke_field;
    String food_typeString=null;
    String url = "jdbc:mysql://localhost:3306/pet_care";
	String username = "root";
	String password = "";
	
	Admin(){
		this.setUndecorated(true);
	    this.setSize(400,560);
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);  
	    getContentPane().setLayout(null);
	    
        Font font = new Font("Pathway Gothic One", Font.PLAIN , 16);
        Border border_head = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK);
        Border allupdates_border= BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK);

        head_JPanel= new JPanel();
        head_JPanel.setLayout(null);
        head_JPanel.setBounds(0, 0, 400, 60);
        head_JPanel.setBackground(new Color(142, 196, 210));
        head_JPanel.setBorder(border_head);
        head_JPanel.setVisible(true);
        getContentPane().add(head_JPanel);
        
        Border border = BorderFactory.createMatteBorder(0, 2, 2, 2, Color.BLACK); 
        Font font3 = new Font("Arial", Font.BOLD, 20);
        users= new JButton();
        users.setText("users");
        users.setBounds(20,15,80,25);
        users.setBackground(new Color(142, 196, 210)); 
        users.setBorder(new LineBorder(Color.black));
        users.setForeground(Color.darkGray); 
        users.setFont(font3);
        users.setFocusable(false);
        head_JPanel.add(users);
        
	      users.addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		user_panel.setVisible(true);
	    		care_center_panelJPanel.setVisible(false);
	    		booking_panel.setVisible(false);
	    		carecenter_model.setRowCount(0);
	    		model.setRowCount(0);
	    		booking_model.setRowCount(0);
	      		insert_carecenter_butoon.setVisible(false);
	    		search_all();
	    	}
		 });
        bookings= new JButton();
        bookings.setText("bookings");
        bookings.setBounds(120,15,90,25);
        bookings.setBackground(new Color(142, 196, 210)); 
        bookings.setBorder(new LineBorder(Color.black));
        bookings.setForeground(Color.darkGray); 
        bookings.setFont(font3);
        bookings.setFocusable(false);
        head_JPanel.add(bookings);

      bookings.addMouseListener(new MouseAdapter() {
    	public void mouseClicked(MouseEvent e) {
    		booking_panel.setVisible(true);
    		user_panel.setVisible(false);
    		care_center_panelJPanel.setVisible(false);
    		carecenter_model.setRowCount(0);
    		model.setRowCount(0);
    		booking_model.setRowCount(0);
      		insert_carecenter_butoon.setVisible(false);
    		search_bookings();
    	}
	  });

        care_centers= new JButton();
        care_centers.setText("centers");
        care_centers.setBounds(220,15,90,25);
        care_centers.setBackground(new Color(142, 196, 210)); 
        care_centers.setBorder(new LineBorder(Color.black));
        care_centers.setForeground(Color.darkGray); 
        care_centers.setFont(font3);
        care_centers.setFocusable(false);
        head_JPanel.add(care_centers);
        
	      care_centers.addMouseListener(new MouseAdapter() {
			    public void mouseClicked(MouseEvent e) {
	      		booking_panel.setVisible(false);
	      		user_panel.setVisible(false);
	      		care_center_panelJPanel.setVisible(true);
	      		insert_carecenter_butoon.setVisible(true);
	      		carecenter_model.setRowCount(0);
	    		model.setRowCount(0);
	    		booking_model.setRowCount(0);
	      		search_carecenters();
			    	
			    }
	      });
              
        try {
            File imageFile = new File("IMAGE/left-arrow.png");
            BufferedImage restBackBtnImage = ImageIO.read(imageFile);
            allbackimage = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (restBackBtnImage != null) {
                        g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                    }
                }
            };
            allbackimage.setBounds(10, 20,20, 20);
            allbackimage.setBackground(new Color(142, 196, 210));
            head_JPanel.add(allbackimage);
        }catch(IOException ex){
            ex.printStackTrace();
        }
        allbackimage.setVisible(false);
        
        user_panel= new JPanel();
        user_panel.setLayout(null);
        user_panel.setBounds(0, 60, 400, 500);
        user_panel.setBackground(new Color(242, 196, 142));
        user_panel.setBorder(border);
        user_panel.setVisible(true);
        getContentPane().add(user_panel);
        
        user_panel_information = new JPanel();
        user_panel_information.setBounds(10, 0, 380,175);
        user_panel_information.setBackground(new Color(242, 196, 142));
        user_panel.add(user_panel_information);
        
        model = new DefaultTableModel();
		table = new JTable(model);
		table.setBackground(new Color(142, 196, 210));
		table.setForeground(Color.black);
		table.setFont(font);
		table.setOpaque(true);
		
		int rowHeight = 25; 
	    table.setRowHeight(rowHeight);
	    table.setBounds(0, 0, 400, 200);
	     
	    model.addColumn("USER ID");
	    model.addColumn("USER NAME");
	    model.addColumn("PET TYPE");
	    model.addColumn("PET NAME");
	    JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(user_panel_information.getSize());
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(3, 0));
        user_panel_information.add(scrollPane, BorderLayout.CENTER);
		 
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    
                    if (selectedRow != -1) {
                    	register_usernamme = (String) table.getValueAt(selectedRow, 1);
                    	addregiter_textfield_data();
                    	}
                }
            }
        });
        
        delete_users = new JPanel();
        delete_users.setBounds(20, 200, 370, 265);
        delete_users.setBackground(new Color(242, 196, 142));
        delete_users.setBorder(allupdates_border);
        delete_users.setLayout(null);
        user_panel.add(delete_users);
        
        profile_username=new JLabel();
        profile_username.setBounds(45,5, 160, 30);
        profile_username.setBackground(new Color(242, 196, 142));
        delete_users.add(profile_username);
        profile_username.setText("fdevfd");
        profile_username.setFont(font);
        
        Border border3 = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY);
        profile_username.setBorder(border3);
         
        try {
            File imageFile = new File("IMAGE/user_7689762.png");
            BufferedImage restBackBtnImage = ImageIO.read(imageFile);
            JPanel restaurantBackBtnPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (restBackBtnImage != null) {
                        g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                    }
                }
            };
            restaurantBackBtnPanel.setBounds(10, 8,20, 20);
            delete_users.add(restaurantBackBtnPanel);
           restaurantBackBtnPanel.setBackground(new Color(242, 196, 142));
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        profile_emaiL=new JLabel();
        profile_emaiL.setBounds(45,45, 160, 30);
        profile_emaiL.setBackground(new Color(242, 196, 142)); 
        delete_users.add(profile_emaiL);
        profile_emaiL.setFont(font);
        profile_emaiL.setBorder(border3);
        
        try {
            File imageFile = new File("IMAGE/email_4546924.png");
            BufferedImage restBackBtnImage = ImageIO.read(imageFile);
            JPanel restaurantBackBtnPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (restBackBtnImage != null) {
                        g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                    }
                }
            };
            restaurantBackBtnPanel.setBounds(10,48,20, 20);
            delete_users.add(restaurantBackBtnPanel);
            restaurantBackBtnPanel.setBackground(new Color(242, 196, 142));
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        profile_petType=new JLabel();
        profile_petType.setBounds(45, 85, 160, 30);
        profile_petType.setBackground(new Color(242, 196, 142));
        delete_users.add(profile_petType);
        profile_petType.setFont(font);
        profile_petType.setBorder(border3);
        
//        try {
//            File imageFile = new File("IMAGE/medical-report_8780282.png");
//            BufferedImage restBackBtnImage = ImageIO.read(imageFile);
//            JPanel restaurantBackBtnPanel = new JPanel() {
//                @Override
//                protected void paintComponent(Graphics g) {
//                    super.paintComponent(g);
//                    if (restBackBtnImage != null) {
//                        g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
//                    }
//                }
//            };
//            restaurantBackBtnPanel.setBounds(10, 88,23, 23);
//            delete_users.add(restaurantBackBtnPanel);
//            restaurantBackBtnPanel.setBackground(new Color(242, 196, 142));
//        }catch(IOException ex){
//            ex.printStackTrace();
//        }
		
        profile_petName=new JLabel();
        profile_petName.setBounds(45, 125, 160, 30);
        profile_petName.setFont(font);
        profile_petName.setBorder(border3);
        profile_petName.setBackground(new Color(242, 196, 142));
        delete_users.add(profile_petName);
        
//        try {
//            File imageFile = new File("IMAGE/document_10260938.png");
//            BufferedImage restBackBtnImage = ImageIO.read(imageFile);
//            JPanel restaurantBackBtnPanel = new JPanel() {
//                @Override
//                protected void paintComponent(Graphics g) {
//                    super.paintComponent(g);
//                    if (restBackBtnImage != null) {
//                        g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
//                    }
//                }
//            };
//            restaurantBackBtnPanel.setBounds(10, 128,28, 28);
//            delete_users.add(restaurantBackBtnPanel);
//            restaurantBackBtnPanel.setBackground(new Color(242, 196, 142));
//        }catch(IOException ex){
//            ex.printStackTrace();
//        }
        
        profile_petHeight=new JLabel();
        profile_petHeight.setBounds(45, 165, 160, 30);
        profile_petHeight.setFont(font);
        profile_petHeight.setBorder(border3);
        profile_petHeight.setBackground(new Color(242, 196, 142));
        delete_users.add(profile_petHeight);
        
        try {
            File imageFile = new File("IMAGE/feed_2418199.png");
            BufferedImage restBackBtnImage = ImageIO.read(imageFile);
            JPanel restaurantBackBtnPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (restBackBtnImage != null) {
                        g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                    }
                }
            };
            restaurantBackBtnPanel.setBounds(10, 168,28, 28);
            delete_users.add(restaurantBackBtnPanel);
            restaurantBackBtnPanel.setBackground(new Color(242, 196, 142));
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        profile_petWeight=new JLabel();
        profile_petWeight.setBounds(45, 205, 160, 30);
        delete_users.add(profile_petWeight);
        profile_petWeight.setBackground(new Color(242, 196, 142));
        profile_petWeight.setFont(font);
        profile_petWeight.setBorder(border3);
        
        kg= new JLabel();
        kg.setText("KG");
        kg.setFont(font);
        kg.setBounds(50, 10, 50, 20);
        profile_petWeight.add(kg);
        
        m= new JLabel();
        m.setText("M");
        m.setFont(font);
        m.setBounds(50, 10, 50, 20);
        profile_petHeight.add(m);
        
        try {
            File imageFile = new File("IMAGE/scale_5260282.png");
            BufferedImage restBackBtnImage = ImageIO.read(imageFile);
            JPanel restaurantBackBtnPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (restBackBtnImage != null) {
                        g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                    }
                }
            };
            restaurantBackBtnPanel.setBounds(10, 208,28, 28);
            delete_users.add(restaurantBackBtnPanel);
            restaurantBackBtnPanel.setBackground(new Color(242, 196, 142));
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        try {
            File imageFile = new File("IMAGE/delete_6861362.png");
            BufferedImage restBackBtnImage = ImageIO.read(imageFile);
            delete_userfield = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (restBackBtnImage != null) {
                        g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                    }
                }
            };
            delete_userfield.setBounds(270, 88,38, 38);
            delete_users.add(delete_userfield);
            delete_userfield.setBackground(new Color(242, 196, 142));
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        delete_users_butoon=new JButton();
        delete_users_butoon.setVisible(false);
        delete_users_butoon.addActionListener(this);
        delete_users_butoon.setBounds(0, 0,10,1);
        delete_users.add(delete_users_butoon);
        delete_userfield.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		delete_users_butoon.doClick();
        	}
		});
               
		booking_panel= new JPanel();
		booking_panel.setLayout(null);
		booking_panel.setBounds(0, 60, 400, 500);
		booking_panel.setBackground(new Color(242, 196, 142));
		booking_panel.setBorder(border);
		booking_panel.setVisible(false);
        getContentPane().add(booking_panel);
        
        allbackimage.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		care_centers.setVisible(true);
        		bookings.setVisible(true);
        		users.setVisible(true);
        		allbackimage.setVisible(false);
        		insertcenterpanel.setVisible(false);
        		care_center_panelJPanel.setVisible(true);
        		carecenter_model.setRowCount(0);
        		insert_carecenter_butoon.setVisible(true);
          		search_carecenters();    		
        	}
		});
        
        booking_panel_information = new JPanel();
        booking_panel_information.setBounds(10, 0, 380,375);
        booking_panel_information.setBackground(new Color(242, 196, 142));
        booking_panel.add(booking_panel_information);
        
        booking_model = new DefaultTableModel();
		booking_table = new JTable(booking_model);
		booking_table.setBackground(new Color(142, 196, 210));
		booking_table.setForeground(Color.black);
		booking_table.setFont(font);
		booking_table.setOpaque(true);
		booking_table.setRowHeight(rowHeight);
		booking_table.setBounds(0, 0, 400, 200);
	     
		booking_model.addColumn("BOOKING ID");
		booking_model.addColumn("USER NAME");
		booking_model.addColumn("CENTER NAME");
		booking_model.addColumn("PET NAME");
	    JScrollPane scrollPane2 = new JScrollPane(booking_table);
        scrollPane2.setPreferredSize(booking_panel_information.getSize());
        scrollPane2.getVerticalScrollBar().setPreferredSize(new Dimension(3, 0));
        booking_panel_information.add(scrollPane2, BorderLayout.CENTER);
		 
        booking_table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        booking_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = booking_table.getSelectedRow();
                    
                    if (selectedRow != -1) {
                    	booking_id = (int) booking_table.getValueAt(selectedRow, 0);
                    }
                }
            }
        });
        
        care_center_panelJPanel= new JPanel();
        care_center_panelJPanel.setLayout(null);
        care_center_panelJPanel.setBounds(0, 60, 400, 500);
        care_center_panelJPanel.setBackground(new Color(242, 196, 142));
        care_center_panelJPanel.setBorder(border);
        care_center_panelJPanel.setVisible(false);
        getContentPane().add(care_center_panelJPanel);
                
        care_centerpanel_information = new JPanel();
        care_centerpanel_information.setBounds(10, 0, 380,175);
        care_centerpanel_information.setBackground(new Color(242, 196, 142));
        care_center_panelJPanel.add(care_centerpanel_information);
        
        carecenter_model = new DefaultTableModel();
		carecenter_table = new JTable(carecenter_model);
		carecenter_table.setBackground(new Color(142, 196, 210));
		carecenter_table.setForeground(Color.black);
		carecenter_table.setFont(font);
		carecenter_table.setOpaque(true);
		carecenter_table.setRowHeight(rowHeight);
		carecenter_table.setBounds(0, 0, 400, 200);
	     
		carecenter_model.addColumn("CENTER ID");
		carecenter_model.addColumn("CENTER NAME");
		carecenter_model.addColumn("AVAILABLE");
		carecenter_model.addColumn("LOCATION");
	    JScrollPane scrollPane3 = new JScrollPane(carecenter_table);
        scrollPane3.setPreferredSize(care_centerpanel_information.getSize());
        scrollPane3.getVerticalScrollBar().setPreferredSize(new Dimension(3, 0));
        care_centerpanel_information.add(scrollPane3, BorderLayout.CENTER);
		 
        carecenter_table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        carecenter_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = carecenter_table.getSelectedRow();
                    
                    if (selectedRow != -1) {
                    	center_id = (int) carecenter_table.getValueAt(selectedRow, 0);
                    	addcarecenter_textfield_data();
                    }
                }
            }
        });
        
        edit_center_panel = new JPanel();
        edit_center_panel.setBounds(20, 200, 370, 265);
        edit_center_panel.setBackground(new Color(242, 196, 142));
        edit_center_panel.setBorder(allupdates_border);
        edit_center_panel.setLayout(null);
        care_center_panelJPanel .add(edit_center_panel);
        
        center_id_textfield=new JLabel();
        center_id_textfield.setBounds(45,5, 160, 30);
        center_id_textfield.setBackground(new Color(242, 196, 142));
        edit_center_panel.add(center_id_textfield);
        center_id_textfield.setText("fdevfd");
        center_id_textfield.setFont(font);
        center_id_textfield.setBorder(border3);
        
        center_name_textfield=new JTextField();
        center_name_textfield.setBounds(45,45, 160, 30);
        center_name_textfield.setBackground(new Color(242, 196, 142)); 
        edit_center_panel.add(center_name_textfield);
        center_name_textfield.setFont(font);
        center_name_textfield.setBorder(border3);
        
        center_location_textfield=new JTextField();
        center_location_textfield.setBounds(45, 85, 160, 30);
        center_location_textfield.setBackground(new Color(242, 196, 142));
        edit_center_panel.add(center_location_textfield);
        center_location_textfield.setFont(font);
        center_location_textfield.setBorder(border3);
        
        center_food_textfield=new JTextField();
        center_food_textfield.setBounds(45, 125, 160, 30);
        center_food_textfield.setFont(font);
        center_food_textfield.setBorder(border3);
        center_food_textfield.setBackground(new Color(242, 196, 142));
        edit_center_panel.add(center_food_textfield);
        
        center_price_textfield=new JTextField();
        center_price_textfield.setBounds(45, 165, 160, 30);
        center_price_textfield.setFont(font);
        center_price_textfield.setBorder(border3);
        center_price_textfield.setBackground(new Color(242, 196, 142));
        edit_center_panel.add(center_price_textfield);
        
        center_available_textfield=new JTextField();
        center_available_textfield.setBounds(45, 205, 160, 30);
        edit_center_panel.add(center_available_textfield);
        center_available_textfield.setBackground(new Color(242, 196, 142));
        center_available_textfield.setFont(font);
        center_available_textfield.setBorder(border3);
        
        delete_carecenter_butoon=new JButton();
        delete_carecenter_butoon.setVisible(false);
        delete_carecenter_butoon.addActionListener(this);
        delete_carecenter_butoon.setBounds(0, 0,10,1);
        edit_center_panel.add(delete_carecenter_butoon);
        
        
        try {
            File imageFile = new File("IMAGE/delete_6861362.png");
            BufferedImage restBackBtnImage = ImageIO.read(imageFile);
            delete_carecenter_image = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (restBackBtnImage != null) {
                        g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                    }
                }
            };
            delete_carecenter_image.setBounds(270, 88,38, 38);
            edit_center_panel.add(delete_carecenter_image);
            delete_carecenter_image.setBackground(new Color(242, 196, 142));
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        delete_carecenter_image.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		delete_carecenter_butoon.doClick();	
        	}
		});
       
        Font font5 = new Font("Arial", Font.PLAIN, 8);
       enable_carecenterButton= new JButton();
       enable_carecenterButton.setBounds(214,5, 70, 25);
       enable_carecenterButton.setText("ENABLE");
       enable_carecenterButton.addActionListener(this);
       enable_carecenterButton.setBackground(new Color(206, 231, 237));
       enable_carecenterButton.setFont(font5);
       enable_carecenterButton.setFocusable(false);  
       edit_center_panel.add(enable_carecenterButton);
       
       
       disable_carecenterButton= new JButton();
       disable_carecenterButton.setBounds(284,5, 70,25);
       disable_carecenterButton.setText("DISABLE");
       disable_carecenterButton.setFont(font5);
       disable_carecenterButton.addActionListener(this);
       disable_carecenterButton.setBackground(new Color(178, 208, 237));
       disable_carecenterButton.setFocusable(false);
       edit_center_panel.add(disable_carecenterButton);
       
       insertcenterpanel=new JPanel();
       insertcenterpanel.setLayout(null);
       insertcenterpanel.setBounds(0, 60, 400, 500);
       insertcenterpanel.setBackground(new Color(242, 196, 142));
       insertcenterpanel.setBorder(border);
       insertcenterpanel.setVisible(false);
       getContentPane().add(insertcenterpanel);
       
       insert_carecenter_butoon=new JButton("insert");
       insert_carecenter_butoon.setVisible(false);
       insert_carecenter_butoon.setBackground(Color.white); 
       insert_carecenter_butoon.setBorder(new LineBorder(Color.black));
       insert_carecenter_butoon.setForeground(Color.darkGray); 
       insert_carecenter_butoon.setFont(font3);
       insert_carecenter_butoon.setFocusable(false);
       insert_carecenter_butoon.addActionListener(this);
       insert_carecenter_butoon.setBounds(315, 15,80, 25);
       head_JPanel.add(insert_carecenter_butoon);
       
       enter_carecenternameField= new JTextField();
       enter_carecenternameField.setBounds(80,20,247, 40);
       enter_carecenternameField.setHorizontalAlignment(JTextField.CENTER);
       enter_carecenternameField.setFont(font);
       enter_carecenternameField.setBorder(new LineBorder(new Color(161,158,158)));
       enter_carecenternameField.setText("CENTER NAME");
       insertcenterpanel.add(enter_carecenternameField);
       
       enter_carecenternameField.addKeyListener(new KeyAdapter() {
           @Override
           public void keyPressed(KeyEvent e) {
                typingStarted = true;

                if (enter_carecenternameField.getText().equals("CENTER NAME")) {
                	enter_carecenternameField.setText("");
                }
                Font userFont = new Font("Arial", Font.PLAIN, 14);
                enter_carecenternameField.setFont(userFont);
           }
    });
       
       try {
           File imageFile = new File("IMAGE/user_7689762.png");
           BufferedImage restBackBtnImage = ImageIO.read(imageFile);
           JPanel allbackimage = new JPanel() {
               @Override
               protected void paintComponent(Graphics g) {
                   super.paintComponent(g);
                   if (restBackBtnImage != null) {
                       g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                   }
               }
           };
           allbackimage.setBounds(35, 10,17, 17);
           allbackimage.setBackground(Color.white);
           enter_carecenternameField.add(allbackimage);
       } catch(IOException ex){
           ex.printStackTrace();
       }
       
       String [] items= {"DOG","CAT"};
       petlist = new JComboBox<String>(items);
       petlist.setFont(font);
       petlist.setBounds(80,70,247, 40);
       insertcenterpanel.add(petlist);
       
       enter_carecenterFiellocationfield= new JTextField();
       enter_carecenterFiellocationfield.setBounds(80,120,247, 40);
       enter_carecenterFiellocationfield.setHorizontalAlignment(JTextField.CENTER);
       enter_carecenterFiellocationfield.setFont(font);
       enter_carecenterFiellocationfield.setBorder(new LineBorder(new Color(161,158,158)));
       enter_carecenterFiellocationfield.setText("LOCATION");
       insertcenterpanel.add(enter_carecenterFiellocationfield);
       
       enter_carecenterFiellocationfield.addKeyListener(new KeyAdapter() {
           @Override
           public void keyPressed(KeyEvent e) {
                typingStarted = true;

                if (enter_carecenterFiellocationfield.getText().equals("LOCATION")) {
                	enter_carecenterFiellocationfield.setText("");
                }
                Font userFont = new Font("Arial", Font.PLAIN, 14);
                enter_carecenterFiellocationfield.setFont(userFont);
           }
    });
       Border border_rectangle = BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK);
       JPanel  rectangleJPanel= new JPanel();
       rectangleJPanel.setBounds(80,180,247,70);
       rectangleJPanel.setBorder(border_rectangle);
       rectangleJPanel.setBackground(Color.white);
       rectangleJPanel.setLayout(null);
       insertcenterpanel.add(rectangleJPanel);
       
       JLabel text_laeLabel=new JLabel();
       text_laeLabel.setText("FOOD TYPE");
       text_laeLabel.setBounds(25,5,77, 20);
       rectangleJPanel.add(text_laeLabel);
       
       enter_carecenterfoodmeat_field=new JRadioButton();
       enter_carecenterfoodmeat_field.setBounds(5,25,77, 30) ;
       enter_carecenterfoodmeat_field.setText("meat");
       enter_carecenterfoodmeat_field.setFont(font);
       enter_carecenterfoodmeat_field.setBackground(Color.white);
       rectangleJPanel.add(enter_carecenterfoodmeat_field);
       
       enter_carecenterfoodfish_field=new JRadioButton();
       enter_carecenterfoodfish_field.setBounds(100,25,77, 30) ;
       enter_carecenterfoodfish_field.setText("fish");
       enter_carecenterfoodfish_field.setFont(font);
       enter_carecenterfoodfish_field.setBackground(Color.white);
       rectangleJPanel.add(enter_carecenterfoodfish_field);
       
       enter_carecenterfoodpoke_field=new JRadioButton();
       enter_carecenterfoodpoke_field.setBounds(175,25,70, 30) ;
       enter_carecenterfoodpoke_field.setText("poke");
       enter_carecenterfoodpoke_field.setFont(font);
       enter_carecenterfoodpoke_field.setBackground(Color.white);
       rectangleJPanel.add(enter_carecenterfoodpoke_field);
       
       ButtonGroup buttonGroup = new ButtonGroup();
       buttonGroup.add(enter_carecenterfoodfish_field);
       buttonGroup.add(enter_carecenterfoodmeat_field);
       buttonGroup.add(enter_carecenterfoodpoke_field);
       
       enter_carecenter_daypricefield= new JTextField();
       enter_carecenter_daypricefield.setBounds(80,270,247, 40);
       enter_carecenter_daypricefield.setHorizontalAlignment(JTextField.CENTER);
       enter_carecenter_daypricefield.setFont(font);
       enter_carecenter_daypricefield.setBorder(new LineBorder(new Color(161,158,158)));
       enter_carecenter_daypricefield.setText("PRICE (FOR ONE DAY)");
       insertcenterpanel.add(enter_carecenter_daypricefield);
       
       enter_carecenter_daypricefield.addKeyListener(new KeyAdapter() {
           @Override
           public void keyPressed(KeyEvent e) {
                typingStarted = true;

                if (enter_carecenter_daypricefield.getText().equals("PRICE (FOR ONE DAY)")) {
                	enter_carecenter_daypricefield.setText("");
                }
                Font userFont = new Font("Arial", Font.PLAIN, 14);
                enter_carecenter_daypricefield.setFont(userFont);
           }
       });     
          
       enter_carecenter_contentfield= new JTextField();
       enter_carecenter_contentfield.setBounds(80,320,247, 40);
       enter_carecenter_contentfield.setHorizontalAlignment(JTextField.CENTER);
       enter_carecenter_contentfield.setFont(font);
       enter_carecenter_contentfield.setBorder(new LineBorder(new Color(161,158,158)));
       enter_carecenter_contentfield.setText("CONTENT");
       insertcenterpanel.add(enter_carecenter_contentfield);
       
       enter_carecenter_contentfield.addKeyListener(new KeyAdapter() {
           @Override
           public void keyPressed(KeyEvent e) {
                typingStarted = true;

                if (enter_carecenter_contentfield.getText().equals("CONTENT")) {
                	enter_carecenter_contentfield.setText("");
                }
                Font userFont = new Font("Arial", Font.PLAIN, 14);
                enter_carecenter_contentfield.setFont(userFont);
           }
       });  
       
       Font font4 = new Font("Arial", Font.BOLD, 19);

       creButton = new JButton("CREATE CENTER");
       creButton.setBounds(80,430,247, 40);
       insertcenterpanel.add(creButton);
       creButton.setBackground(new Color(142, 196, 210)); 
       creButton.setForeground(Color.darkGray); 
       creButton.setFont(font4);
       creButton.setBorder(new LineBorder(Color.black));
       creButton.addActionListener(this);
       creButton.setFocusable(false);
       
       this.setVisible(true);
	   }
	public void search_all(){
    	try {
    	    Class.forName("com.mysql.cj.jdbc.Driver");
    	    Connection connection = DriverManager.getConnection(url, username, password); 
    	    String selectQuery = "SELECT * FROM register";
    	    PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
    	   
    	    ResultSet resultSet = selectStatement.executeQuery();
    	    while(resultSet.next()) {
    	    	register_usernamme = resultSet.getString("user_name"); 
    	        int user_id = resultSet.getInt("uid"); 
    	    	String email = resultSet.getString("pet_type"); 
    	    	String pet_name = resultSet.getString("pet_name"); 
    	        Object[] newRow = {user_id,register_usernamme,email,pet_name};
    	        model.addRow(newRow);
    	    }
    	    
    	    
    	    PreparedStatement selectStatement2 = connection.prepareStatement(selectQuery);
    	   
    	    ResultSet resultSet2 = selectStatement2.executeQuery();
    	    while(resultSet2.next()) {
    	    	String input_register_username = resultSet2.getString("user_name"); 
    	    	String input_register_email = resultSet2.getString("email"); 
    	    	String input_register_pettype = resultSet2.getString("pet_type"); 
    	    	String input_register_petheight= resultSet2.getString("pet_height");
    	    	String input_register_petweight= resultSet2.getString("pet_weight");
    	    	String input_register_petname= resultSet2.getString("pet_name"); 
    	    	profile_username.setText(input_register_username);
    	    	profile_emaiL.setText(input_register_email);
    	    	profile_petType.setText(input_register_pettype);
    	    	profile_petHeight.setText(input_register_petheight);
    	    	profile_petWeight.setText(input_register_petweight);
    	    	profile_petName.setText(input_register_petname);
    	    }
    	    
    	    resultSet.close();
    	    selectStatement.close();
    	    
    	    connection.close();
    	}
    	catch (ClassNotFoundException e) {
    		e.printStackTrace();
		}
    	catch (SQLException e2) {
    		e2.printStackTrace();
		}
    	
    }
	
	public void search_bookings(){
    	try {
    	    Class.forName("com.mysql.cj.jdbc.Driver");
    	    Connection connection = DriverManager.getConnection(url, username, password); 
    	    String selectQuery = "SELECT * FROM booking";
    	    PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
    	   
    	    ResultSet resultSet = selectStatement.executeQuery();
    	    while(resultSet.next()) {
    	    	String booking_username = resultSet.getString("user_name"); 
    	    	booking_id = resultSet.getInt("booking_id"); 
    	    	String center_name = resultSet.getString("center_name"); 
    	    	int total_price = resultSet.getInt("total_price"); 
    	        Object[] newRow = {booking_id,booking_username,center_name,total_price};
    	        booking_model.addRow(newRow);
    	    }
    	    resultSet.close();
    	    selectStatement.close();
    	    connection.close();
    	}
    	catch (ClassNotFoundException e) {
    		e.printStackTrace();
		}
    	catch (SQLException e2) {
    		e2.printStackTrace();
		}
    	
    }
	public void search_carecenters(){
    	try {
       	    Class.forName("com.mysql.cj.jdbc.Driver");
    	    Connection connection = DriverManager.getConnection(url, username, password); 
    	    String selectQuery = "SELECT * FROM petcare_centers";
    	    PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
    	   
    	    ResultSet resultSet = selectStatement.executeQuery();
    	    while(resultSet.next()) {
    	         center_id = resultSet.getInt("center_id"); 
    	    	String center_name = resultSet.getString("center_name"); 
    	    	String available = resultSet.getString("available"); 
    	    	String location = resultSet.getString("location"); 
    	        Object[] newRow = {center_id,center_name,available,location};
    	        carecenter_model.addRow(newRow);
    	    }
    	    
    	    
    	    PreparedStatement selectStatement2 = connection.prepareStatement(selectQuery);
    	    ResultSet resultSet2 = selectStatement2.executeQuery();
    	    while(resultSet2.next()) {
    	    	int center_idd = resultSet2.getInt("center_id"); 
    	    	String input_center_name = resultSet2.getString("center_name"); 
    	    	String input_center_available= resultSet2.getString("available"); 
    	    	String input_center_location= resultSet2.getString("location");
    	    	String input_center_food= resultSet2.getString("food");
    	    	String input_center_day_price= resultSet2.getString("day_price"); 
    	        center_id_textfield.setText(String.valueOf(center_idd)); 
    	    	center_name_textfield.setText(input_center_name);
    	    	center_available_textfield.setText(input_center_available);
    	    	center_location_textfield.setText(input_center_location);
    	    	center_food_textfield.setText(input_center_food);
    	    	center_price_textfield.setText(input_center_day_price);
    	    }
    	    
    	    resultSet.close();
    	    selectStatement.close();
    	    
    	    connection.close();
    	}
    	catch (ClassNotFoundException e) {
    		e.printStackTrace();
		}
    	catch (SQLException e2) {
    		e2.printStackTrace();
		}
    	
    }
	public void addregiter_textfield_data(){
    	try {
    	    Class.forName("com.mysql.cj.jdbc.Driver");
    	    Connection connection = DriverManager.getConnection(url, username, password); 
    	    String selectQuery = "SELECT * FROM register WHERE user_name=?";
    	    PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
    	    selectStatement.setString(1, register_usernamme);
    	   
    	    ResultSet resultSet = selectStatement.executeQuery();
    	    while(resultSet.next()) {
    	    	String input_register_username = resultSet.getString("user_name"); 
    	    	String input_register_email = resultSet.getString("email"); 
    	    	String input_register_pettype = resultSet.getString("pet_type"); 
    	    	String input_register_petheight= resultSet.getString("pet_height");
    	    	String input_register_petweight= resultSet.getString("pet_weight");
    	    	String input_register_petname= resultSet.getString("pet_name"); 
    	    	profile_username.setText(input_register_username);
    	    	profile_emaiL.setText(input_register_email);
    	    	profile_petType.setText(input_register_pettype);
    	    	profile_petHeight.setText(input_register_petheight);
    	    	profile_petWeight.setText(input_register_petweight);
    	    	profile_petName.setText(input_register_petname);
    	    }
    	    resultSet.close();
    	    selectStatement.close();
    	    connection.close();
    	}
    	catch (ClassNotFoundException e) {
    		e.printStackTrace();
		}
    	catch (SQLException e2) {
    		e2.printStackTrace();
		}
    	
    }
	public void addcarecenter_textfield_data(){
    	try {
    	    Class.forName("com.mysql.cj.jdbc.Driver");
    	    Connection connection = DriverManager.getConnection(url, username, password); 
    	    String selectQuery = "SELECT * FROM petcare_centers WHERE center_id=?";
    	    PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
    	    selectStatement.setInt(1, center_id);
    	   
    	    ResultSet resultSet2 = selectStatement.executeQuery();
    	    while(resultSet2.next()) {
    	    	int center_idd = resultSet2.getInt("center_id"); 
    	    	String input_center_name = resultSet2.getString("center_name"); 
    	    	String input_center_available= resultSet2.getString("available"); 
    	    	String input_center_location= resultSet2.getString("location");
    	    	String input_center_food= resultSet2.getString("food");
    	    	String input_center_day_price= resultSet2.getString("day_price"); 
    	        center_id_textfield.setText(String.valueOf(center_idd)); 
    	    	center_name_textfield.setText(input_center_name);
    	    	center_available_textfield.setText(input_center_available);
    	    	center_location_textfield.setText(input_center_location);
    	    	center_food_textfield.setText(input_center_food);
    	    	center_price_textfield.setText(input_center_day_price);
    	    }
    	    resultSet2.close();
    	    selectStatement.close();
    	    connection.close();
    	}
    	catch (ClassNotFoundException e) {
    		e.printStackTrace();
		}
    	catch (SQLException e2) {
    		e2.printStackTrace();
		}
    	
    }
    public void actionPerformed(ActionEvent e) {
    	try {
    	    Class.forName("com.mysql.cj.jdbc.Driver");
    	    Connection connection = DriverManager.getConnection(url, username, password);
    	    
    	    if(e.getSource()==delete_users_butoon) {
    	    	String delete_want_nameString=profile_username.getText();
    	    	String deleteSqlString = "DELETE FROM register WHERE user_name = ?";
    	    	PreparedStatement statement=connection.prepareStatement(deleteSqlString);
    	    	statement.setString(1, delete_want_nameString);
    	    	statement.executeUpdate();
    	    	model.setRowCount(0);
        		search_all();
        		
    	    }
    	    if(e.getSource()==delete_carecenter_butoon) {
    	    	String delete_want_nameString=center_id_textfield.getText();
    	    	String deleteSqlString = "DELETE FROM petcare_centers WHERE center_id = ?";
    	    	PreparedStatement statement=connection.prepareStatement(deleteSqlString);
    	    	statement.setString(1, delete_want_nameString);
    	    	statement.executeUpdate();
    	    	carecenter_model.setRowCount(0);
    	    	search_carecenters();        		
    	    }
    		if(e.getSource()==insert_carecenter_butoon) {
    			insert_carecenter_butoon.setVisible(false);
    			insertcenterpanel.setVisible(true);
    			care_centers.setVisible(false);
    			bookings.setVisible(false);
    			users.setVisible(false);
    			care_center_panelJPanel.setVisible(false);
    			allbackimage.setVisible(true);
    		}
    		if(e.getSource()==enable_carecenterButton) {
    	    	String enable_want_nameString=center_id_textfield.getText();
    	    	String updateSqlString = " UPDATE petcare_centers SET available='yes' WHERE center_id = ?";
    	    	PreparedStatement statement=connection.prepareStatement(updateSqlString);
    	    	statement.setString(1, enable_want_nameString);
    	    	statement.executeUpdate();
    	    	carecenter_model.setRowCount(0);
    	    	search_carecenters();  
    		}
    		if(e.getSource()==disable_carecenterButton) {
    	    	String enable_want_nameString=center_id_textfield.getText();
    	    	String updateSqlString = "UPDATE petcare_centers SET available='no' WHERE center_id = ?";
    	    	PreparedStatement statement=connection.prepareStatement(updateSqlString);
    	    	statement.setString(1, enable_want_nameString);
    	    	statement.executeUpdate();
    	    	carecenter_model.setRowCount(0);
    	    	search_carecenters();  
    		}
    		if(e.getSource()==creButton) {
    			String getcenternameString=enter_carecenternameField.getText();
    			String getlocationString=enter_carecenterFiellocationfield.getText();
    			String getpriceString=enter_carecenter_daypricefield.getText();
    			String getcontentString=enter_carecenter_contentfield.getText();
    	        String getpet_type = (String) petlist.getSelectedItem();
    	        if(enter_carecenterfoodfish_field.isSelected()) {
    	     	   food_typeString="fish";
    	        }
    	        else  if(enter_carecenterfoodmeat_field.isSelected()){
    	     	   food_typeString="meat";   
    	        }
    	        else {
    	 		  food_typeString="poke";
    	 	    } 
    	        
    	        String sqlString="INSERT INTO petcare_centers (center_name,pet_type,available,location,food,pet_food,day_price,content) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement statement=connection.prepareStatement(sqlString);
                statement.setString(1, getcenternameString);
                statement.setString(2, getpet_type);
                statement.setString(3, "yes");
                statement.setString(4, getlocationString);
                statement.setString(5, food_typeString);
                statement.setString(6, "yes");
                statement.setString(7, getpriceString);
                statement.setString(8, getcontentString);
                
                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                	if (rowsAffected > 0) {
                	    JOptionPane.showMessageDialog(null, "Care center inserted successfully.");
                        
                	} 
                	else {
                        JOptionPane.showMessageDialog(null, "Failed to insert data.");
					}
    	        
    	        
                }
    			
    		}
    		
    	}
    	catch (ClassNotFoundException e4) {
    		e4.printStackTrace();
		}
    	catch (SQLException e5) {
    		e5.printStackTrace();
		}
    }
	
	    
        
        
    
}
