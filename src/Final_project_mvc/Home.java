package Final_project_mvc;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.mail.internet.NewsAddress;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.xml.crypto.Data;

import Final_project_mvc.Book_now.MultiLineTableCellRenderer;

public class Home extends JFrame implements ActionListener {
    
    private String user_name;
    String sname;
    JLabel welcome_laJLabel;
    JPanel footer,notificationPanel,notificationPanel2,update_weight,updating_panel;
    JPanel head_JPanel,update_email,update_height,head_JPanel2,bag;
    JPanel profile_panel ,logo,allbackimage,closeJPanel_button,updateback_button,update_informations;
    JPanel home_panel,log_out,update_addingall_panel,notification_on,notifi_found,homepanel_step2;
    JLabel profile_label, profile_username, profile_emaiL,profile_petType,profile_petHeight; 
    JLabel profile_petWeight, addheightJLabel, addweightJLabel,profile_petName, update_label;
    JLabel petsitting,nigtht_sitting,kg,m;
    JButton book_room,apply_greencard,search_update_current_value;
    JButton b1,button,updating_button;
    JButton b2,button_cart;
    JTable table,cart_table;
    DefaultTableModel model,cart_model;
    GlassPane glassPane;
    JTextField allupdate_text;
    String update_database_value,update_database_string;
    JPanel cart_panel,home_dogorcat_dogone,homepanel_informartion;
    JLabel home_petnameJLabel,texttyyy,contains_1,contains_2,contains_3;

	String url = "jdbc:mysql://localhost:3306/pet_care";
	String username = "root";
	String password = "";
    public Home(String user_name){
        searchnotifi();
        this.user_name=user_name;
        this.setUndecorated(true);
        this.setSize(400,560);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        Border upda = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        Font font = new Font("Pathway Gothic One", Font.PLAIN , 16);
        Border border_head = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK);
        Font font_mypet = new Font("Pathway Gothic One", Font.ITALIC , 15);
        Font font_brands= new Font("Pathway Gothic One", Font.ITALIC , 12);
        Font font_booknowlabel = new Font("Pathway Gothic One", Font.BOLD , 14);
        Border border_homeBorder = BorderFactory.createMatteBorder(0, 2, 2, 2, Color.BLACK);
        Border myprofileJPanel_Border = BorderFactory.createMatteBorder(1,1,1,1, new Color(174,170,170));
        Font fonttetxt = new Font("Pathway Gothic One", Font.PLAIN , 13);  
        Border border88 = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY);
        Font font3 = new Font("Arial", Font.BOLD, 20);
        Font font_checknow = new Font("Arial", Font.BOLD, 14);
        Border border_profile = BorderFactory.createMatteBorder(0, 2, 2, 2, Color.BLACK);
        
        head_JPanel= new JPanel();
        head_JPanel.setLayout(null);
        head_JPanel.setBounds(0, 0, 400, 60);
        head_JPanel.setBackground(new Color(142, 196, 210));
        head_JPanel.setBorder(border_head);
        head_JPanel.setVisible(true);
        getContentPane().add(head_JPanel);
        
        head_JPanel2= new JPanel();
        head_JPanel2.setLayout(null);
        head_JPanel2.setBounds(0, 0, 400, 60);
        head_JPanel2.setBackground(new Color(142, 196, 210));
        head_JPanel2.setBorder(border_head);
        head_JPanel2.setVisible(false);
        getContentPane().add(head_JPanel2);
        
        try {
            File imageFile = new File("IMAGE/user_12392953.png");
            BufferedImage restBackBtnImage = ImageIO.read(imageFile);
            logo = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (restBackBtnImage != null) {
                        g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                    }
                }
            };
            logo.setBounds(235, 14,34,34);
            logo.setBackground(new Color(142, 196, 210));
            head_JPanel.add(logo);
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        
       try {
            File imageFile = new File("IMAGE/notification_3239952.png");
            BufferedImage restBackBtnImage = ImageIO.read(imageFile);
             notification_on = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (restBackBtnImage != null) {
                        g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                    }
                }
            };
            notification_on.setBounds(340, 16,28,28);
            notification_on.setBackground(new Color(142, 196, 210));
           head_JPanel.add(notification_on);
        }
        catch(IOException ex){
            ex.printStackTrace();
        } 
        
        try {
            File imageFile = new File("IMAGE/record-button_12153408.png");
            BufferedImage restBackBtnImage = ImageIO.read(imageFile);
             notifi_found = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (restBackBtnImage != null) {
                        g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                    }
                }
            };
            notifi_found.setBounds(352, 10,20,20);
            notifi_found.setBackground(new Color(142, 196, 210));
           head_JPanel.add(notifi_found);
           head_JPanel.setComponentZOrder(notifi_found, 0); 
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        notifi_found.setVisible(false);
        
        try {
            File imageFile = new File("IMAGE/shopping-bag_1656850.png");
            BufferedImage restBackBtnImage = ImageIO.read(imageFile);
            bag = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (restBackBtnImage != null) {
                        g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                    }
                }
            };
            bag.setBounds(290, 14,29,29);
            bag.setBackground(new Color(142, 196, 210));
            head_JPanel.add(bag);
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        
        button_cart = new JButton("Click");
        head_JPanel.add(button_cart);
        button_cart.setBounds(300, 30, 100, 40);
        button_cart.addActionListener(this);
        button_cart.setVisible(false);
        
        bag.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        	     	button_cart.doClick();
        	}
		});

        button = new JButton("Click");
        head_JPanel.add(button);
        button.setBounds(300, 30, 100, 40);
        button.addActionListener(this);
        button.setVisible(false);
        
        notification_on.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	button.doClick();
            }
		});
        
        b1= new JButton();
        b1.setBounds(335, 30, 1, 1 );
        head_JPanel2.add(b1);
        b1.addActionListener(this);
        b1.setVisible(false);
        
        logo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	profile_panel.setVisible(true);
				  head_JPanel2.setVisible(true);
				  head_JPanel.setVisible(false);
				  home_panel.setVisible(false);
                  b1.doClick();
                  notificationPanel.setVisible(false);
                  notificationPanel2.setVisible(false);
                  cart_panel.setVisible(false);
            }
        });

        home_panel= new JPanel();
        home_panel.setBounds(0, 60, 400,500);
        home_panel.setLayout(null);
        home_panel.setBackground(new Color(242, 196, 142)); 
        home_panel.setBorder(border_homeBorder);
        home_panel.setVisible(true);
        getContentPane().add(home_panel); 
        
        JPanel slideshowpanel = new JPanel();
        slideshowpanel.setBounds(10, 5, 380, 90);
        slideshowpanel.setLayout(null); 
        slideshowpanel.setBackground(new Color(242, 196, 142));
        slideshowpanel.setBorder(new LineBorder(Color.gray));
        home_panel.add(slideshowpanel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        slideshowpanel.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(null); 
        slideshowpanel.add(panel2);

        CardLayout cardLayout = new CardLayout();
        slideshowpanel.setLayout(cardLayout);
        slideshowpanel.add(panel1, "panel1");
        slideshowpanel.add(panel2, "panel2");

        Timer timer = new Timer(3000, new ActionListener() {
            private int currentPanelIndex = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPanelIndex == 0) {
                    cardLayout.show(slideshowpanel, "panel2");
                    currentPanelIndex = 1;
                } else {
                    cardLayout.show(slideshowpanel, "panel1");
                    currentPanelIndex = 0;
                }
            }
        });
        timer.start();
  
        try {
            File imageFile = new File("IMAGE/FF_tile.png");
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
            restaurantBackBtnPanel.setBounds(0,0,380,90);
            panel1.add(restaurantBackBtnPanel);
            restaurantBackBtnPanel.setBackground(new Color(242, 196, 142));
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        try {
            File imageFile = new File("IMAGE/Screenshot 2024-05-15 070613.png");
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
            restaurantBackBtnPanel.setBounds(0,0,380,140);
            panel2.add(restaurantBackBtnPanel);
            restaurantBackBtnPanel.setBackground(new Color(242, 196, 142));
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        
        JPanel petcarecenter_booking=new JPanel();
        petcarecenter_booking.setBounds(10,110,385,130);
        petcarecenter_booking.setLayout(null);
        petcarecenter_booking.setBackground(new Color(240, 199, 151));
        home_panel.add(petcarecenter_booking);
        
        JLabel booking_label1=new JLabel();
        booking_label1.setText("BOOK YOUR CARE CENTER NOW");
        booking_label1.setBounds(9,10,300,20);
        booking_label1.setFont(font_booknowlabel);
        booking_label1.setForeground(Color.black);
        petcarecenter_booking.add(booking_label1);
        
        JLabel booking_label_intro1 =new JLabel();
        booking_label_intro1.setText("we specialize in providing top-notch care for your furry friends");
        booking_label_intro1.setBounds(10,26,330,30);
        booking_label_intro1.setFont(fonttetxt);
        booking_label_intro1.setForeground(new Color(74,71,71));
        petcarecenter_booking.add(booking_label_intro1);  
        
        JLabel booking_label_intro2 =new JLabel();
        booking_label_intro2.setBounds(10,41,350,30);
        booking_label_intro2.setText("when you can't be with them.From short-term stays to daily check-ins,");
        booking_label_intro2.setFont(fonttetxt);
        booking_label_intro2.setForeground(new Color(74,71,71));
        petcarecenter_booking.add(booking_label_intro2);
                
        JLabel booking_label_intro4 =new JLabel();
        booking_label_intro4.setBounds(10,56,350,30);
        booking_label_intro4.setText("their safety, comfort, and happiness.");
        booking_label_intro4.setFont(fonttetxt);
        booking_label_intro4.setForeground(new Color(74,71,71));
        petcarecenter_booking.add(booking_label_intro4);
        
      book_room = new JButton("CHECK NOW");
      book_room.setBounds(230, 90, 120, 30);
      book_room.setOpaque(true);
      book_room.addActionListener(this);
      book_room.setBackground(new Color(230, 179, 122)); 
      book_room.setBorder(new LineBorder(Color.gray));
      book_room.setForeground(Color.darkGray); 
      book_room.setFont(font_checknow);
      book_room.setFocusable(false);
      petcarecenter_booking.add(book_room);
      
       JPanel brandsJPanel=new JPanel();
       brandsJPanel.setBounds(10,255,385,75);
       brandsJPanel.setLayout(null);
       brandsJPanel.setBackground(new Color(242, 196, 142));
       home_panel.add(brandsJPanel);

       try {
           File imageFile = new File("IMAGE/home-n1-cat-1.png");
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
           restaurantBackBtnPanel.setBounds(10, 10,45,45);
           brandsJPanel.add(restaurantBackBtnPanel);
          restaurantBackBtnPanel.setBackground(new Color(242, 196, 142));
       }catch(IOException ex){
           ex.printStackTrace();
       }
       
       try {
           File imageFile = new File("IMAGE/home-n1-cat-3.png");
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
           restaurantBackBtnPanel.setBounds(90, 10,45,45);
           brandsJPanel.add(restaurantBackBtnPanel);
          restaurantBackBtnPanel.setBackground(new Color(242, 196, 142));
       }catch(IOException ex){
           ex.printStackTrace();
       }
       
       try {
           File imageFile = new File("IMAGE/home-n1-cat-4.png");
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
           restaurantBackBtnPanel.setBounds(170, 10,47,47);
           brandsJPanel.add(restaurantBackBtnPanel);
          restaurantBackBtnPanel.setBackground(new Color(242, 196, 142));
       }catch(IOException ex){
           ex.printStackTrace();
       }
       
       
       try {
           File imageFile = new File("IMAGE/home-n1-cat-5.png");
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
           restaurantBackBtnPanel.setBounds(250, 10,47,47);
           brandsJPanel.add(restaurantBackBtnPanel);
          restaurantBackBtnPanel.setBackground(new Color(242, 196, 142));
       }catch(IOException ex){
           ex.printStackTrace();
       }
       
       try {
           File imageFile = new File("IMAGE/home-n1-cat-2.png");
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
           restaurantBackBtnPanel.setBounds(330, 10,45,45);
           brandsJPanel.add(restaurantBackBtnPanel);
          restaurantBackBtnPanel.setBackground(new Color(240, 199, 151));
       }catch(IOException ex){
           ex.printStackTrace();
       }
       
       JLabel brns1=new JLabel();
       brns1.setText("Food");
       brns1.setBounds(20,60,50,10);
       brns1.setFont(fonttetxt);
       brandsJPanel.add(brns1);
       
       JLabel brns2=new JLabel();
       brns2.setText("Clothes");
       brns2.setBounds(90,60,50,10);
       brns2.setFont(fonttetxt);
       brandsJPanel.add(brns2);
       
       JLabel brns3=new JLabel();
       brns3.setText("Access");
       brns3.setBounds(170,60,80,10);
       brns3.setFont(fonttetxt);
       brandsJPanel.add(brns3);
       
       JLabel brns4=new JLabel();
       brns4.setText("Bed");
       brns4.setBounds(260,60,80,10);
       brns4.setFont(fonttetxt);
       brandsJPanel.add(brns4);
       
       JLabel brns5=new JLabel();
       brns5.setText("Toys");
       brns5.setBounds(340,60,80,10);
       brns5.setFont(fonttetxt);
       brandsJPanel.add(brns5);
       
        JPanel myprofileJPanel=new JPanel();
        myprofileJPanel.setBounds(9,355,380,130);
        myprofileJPanel.setLayout(null);
        myprofileJPanel.setBorder(myprofileJPanel_Border);
        myprofileJPanel.setBackground(new Color(240, 199, 151));
        home_panel.add(myprofileJPanel);
          
        JLabel mypetJLabel=new JLabel();
        mypetJLabel.setBounds(20,10,100,20);
        mypetJLabel.setForeground(new  Color(82,78,78));
        mypetJLabel.setFont(font_mypet);
        mypetJLabel.setText("MY PET");
        myprofileJPanel.add(mypetJLabel);
        
        try {
            File imageFile = new File("IMAGE/core+values.png");
            BufferedImage restBackBtnImage = ImageIO.read(imageFile);
           home_dogorcat_dogone = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (restBackBtnImage != null) {
                        g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                    }
                }
            };
            home_dogorcat_dogone.setBounds(10, 29,70,70);
            myprofileJPanel.add(home_dogorcat_dogone);
            home_dogorcat_dogone.setBackground(new Color(240, 199, 151));
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
         home_petnameJLabel=new JLabel();
         home_petnameJLabel.setBounds(30, 97,105,25);
         home_petnameJLabel.setFont(font);
         myprofileJPanel.add(home_petnameJLabel);
         
         try {
             File imageFile = new File("IMAGE/pawprint_1081290.png");
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
             restaurantBackBtnPanel.setBounds(110, 23,17,17);
             myprofileJPanel.add(restaurantBackBtnPanel);
            restaurantBackBtnPanel.setBackground(new Color(240, 199, 151));
         }catch(IOException ex){
             ex.printStackTrace();
         }
       texttyyy= new JLabel();
       texttyyy.setBounds(130, 22,200, 20);
       texttyyy.setFont(fonttetxt);
       texttyyy.setForeground(Color.darkGray);
       myprofileJPanel.add(texttyyy); 
       
       homepanel_step2= new  JPanel();
       homepanel_step2.setBounds(110,45,240,75);
       homepanel_step2.setLayout(null);
       homepanel_step2.setVisible(false);
       homepanel_step2.setBackground(new Color(240, 199, 151));
       myprofileJPanel.add(homepanel_step2);
       
        JLabel step2teJLabel=new JLabel();
        step2teJLabel.setText("please update the informations");
        step2teJLabel.setBounds(10,15,200,30);
        step2teJLabel.setFont(fonttetxt);
        step2teJLabel.setForeground(Color.gray);
        
        homepanel_step2.add(step2teJLabel);
        homepanel_informartion= new  JPanel();
        homepanel_informartion.setBounds(110,45,240,75);
        homepanel_informartion.setLayout(null);
        homepanel_informartion.setVisible(true);
        homepanel_informartion.setBackground(new Color(240, 199, 151));
        myprofileJPanel.add(homepanel_informartion);
             
      contains_1= new JLabel();
      contains_1.setBounds(10,5,200,20);
      contains_1.setFont(fonttetxt);
      contains_1.setForeground(Color.darkGray);
      homepanel_informartion.add(contains_1);
      
      contains_3= new JLabel();
      contains_3.setText("tall at the shoulder and approximately");
      contains_3.setBounds(10,20,200,20);
      contains_3.setFont(fonttetxt);
      contains_3.setForeground(Color.darkGray);
      homepanel_informartion.add(contains_3);
   
      contains_2= new JLabel();
      contains_2.setBounds(10,35,200,20);
      contains_2.setFont(fonttetxt);
      contains_2.setForeground(Color.darkGray);
      homepanel_informartion.add(contains_2);
      
        notificationPanel = new JPanel();
        notificationPanel.setLayout(new BorderLayout());
        notificationPanel.setBounds(100, 60, 300, 500);
        notificationPanel.setBackground(Color.white);
        notificationPanel.setVisible(false);
        notificationPanel.setBorder(border_head);
        this.add(notificationPanel);
        
        Border border_homeBorder_notifi = BorderFactory.createMatteBorder(0, 2, 2, 0, Color.BLACK);
        notificationPanel2 = new JPanel();
        notificationPanel2.setLayout(null);
        notificationPanel2.setBounds(0, 60, 100, 500);
        notificationPanel2.setBorder(border_homeBorder_notifi);
        notificationPanel2.setBackground(new Color(242, 196, 142));
        notificationPanel2.setVisible(false);        
        this.add(notificationPanel2);
        
        
        try {
            File imageFile = new File("IMAGE/Screenshot 2024-05-15 184625.png");
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
            restaurantBackBtnPanel.setBounds(2, 0,100, 496);
            notificationPanel2.add(restaurantBackBtnPanel);
           restaurantBackBtnPanel.setBackground(new Color(240, 199, 151));
        }catch(IOException ex){
            ex.printStackTrace();
        }       
        
        glassPane = new GlassPane();
        this.setGlassPane(glassPane);

        model = new DefaultTableModel();
        table = new JTable(model);
        table.setOpaque(true);
        
        int rowHeight = 65; 
        table.setRowHeight(rowHeight);
        table.setBounds(0, 0, 300, 450);

        model.addColumn("NOTIFICATIONS");
        JScrollPane scrollPane = new JScrollPane(table);
        table.setBackground(new Color(255, 255, 255));
		scrollPane.setBackground(Color.black);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		
		 for (int i = 0; i < table.getColumnCount(); i++) {
	            table.getColumnModel().getColumn(i).setCellRenderer(new MultiLineTableCellRenderer());
	      }

        notificationPanel.add(scrollPane, BorderLayout.CENTER);
        
        head_JPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                notificationPanel.setVisible(false);
                notificationPanel2.setVisible(false);
                glassPane.setVisible(false); 
                notification_on.setVisible(true);
                home_panel.setVisible(true);
                model.setRowCount(0);
                cart_model.setRowCount(0);
                cart_panel.setVisible(false); 
                bag.setVisible(true);   
                button.setEnabled(true);
                button_cart.setEnabled(true);
                b1.setEnabled(true);
                }

        });
        
      cart_panel = new JPanel();
      cart_panel.setLayout(new BorderLayout());
      cart_panel.setBounds(100, 60, 300, 500);
      cart_panel.setBackground(Color.red);
      cart_panel.setVisible(true);
      cart_panel.setBorder(border_head);
      this.add(cart_panel);
       
      cart_model = new DefaultTableModel();
      cart_table = new JTable(cart_model);
	  cart_table.setBackground(new Color(142, 196, 210));
	  cart_table.setForeground(Color.black);
	  cart_table.setOpaque(true);
		
		int rowHeight_cart = 100; 
	    cart_table.setRowHeight(rowHeight_cart);
	    cart_table.setBounds(0, 0,150, 200);
	       
	    cart_model.addColumn("");
	    JScrollPane scrollPane_cart = new JScrollPane(cart_table);
        scrollPane_cart.setPreferredSize(cart_panel.getSize());
        scrollPane_cart.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        cart_panel.add(scrollPane_cart, BorderLayout.CENTER);
		 
        cart_table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        cart_table.getColumnModel().getColumn(0).setCellRenderer(new MultiLineTableCellRenderer2());
        
//        welcome_laJLabel= new JLabel();
//        welcome_laJLabel.setText("username"+user_name);
//        head_JPanel.add(welcome_laJLabel);
//        welcome_laJLabel.setBounds(5, 30, 100, 20 );
//        welcome_laJLabel.setVisible(true);
                
        profile_label= new JLabel();
        profile_label.setText("PROFILE");
        profile_label.setBounds(145, 25, 100, 20 );
        head_JPanel2.add(profile_label);
        profile_label.setForeground(Color.black);
        Font profile_font= new Font("Tahoma", Font.PLAIN, 20);
        profile_label.setFont(profile_font);
  
        profile_panel= new JPanel();
        profile_panel.setBounds(0, 60, 400, 500);
        profile_panel.setLayout(null);
        profile_panel.setVisible(false);
        profile_panel.setBorder(border_profile);
        profile_panel.setBackground(new Color(242, 196, 142));
        this.add(profile_panel);
        
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
            head_JPanel2.add(allbackimage);
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        allbackimage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	head_JPanel.setVisible(true);
            	head_JPanel2.setVisible(false);
            	notification_on.setVisible(true);
				  home_panel.setVisible(true);
				  profile_panel.setVisible(false);
			       searchnotifi();
            }
        });
        
        try {
            File imageFile = new File("IMAGE/power-off_10628838.png");
            BufferedImage restBackBtnImage = ImageIO.read(imageFile);
            log_out = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (restBackBtnImage != null) {
                        g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                    }
                }
            };
            log_out.setBounds(300, 22,27, 27);
            log_out.setBackground(new Color(142, 196, 210));
            head_JPanel2.add(log_out);
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        log_out.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
              Login_model model = new Login_model();
              Login_view view = new Login_view();
              new Login_controll(view, model);
        		Home.this.dispose();
        	}
		});        
        
        JLabel username_label= new JLabel("FIRST NAME");
        username_label.setBounds(70, 20, 130, 15);
        username_label.setForeground(Color.GRAY);
        profile_panel.add(username_label);
        
        profile_username=new JLabel ();
        profile_username.setBounds(70,35, 280, 30);
        profile_username.setBackground(Color.white);
        profile_panel.add(profile_username);
        profile_username.setFont(font);
        
        Border border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY);
        profile_username.setBorder(border);
         
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
            restaurantBackBtnPanel.setBounds(30, 23,25, 25);
            profile_panel.add(restaurantBackBtnPanel);
           restaurantBackBtnPanel.setBackground(new Color(242, 196, 142));
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        JLabel email_label= new JLabel("EMAIL");
        email_label.setBounds(70, 100, 130, 15);
        email_label.setForeground(Color.GRAY);
        profile_panel.add(email_label);
        
        profile_emaiL=new JLabel();
        profile_emaiL.setBounds(70,115, 280, 30);
        profile_emaiL.setBackground(Color.YELLOW); 
        profile_panel.add(profile_emaiL);
        profile_emaiL.setFont(font);
        profile_emaiL.setBorder(border);
        
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
            restaurantBackBtnPanel.setBounds(30,103,25, 25);
            profile_panel.add(restaurantBackBtnPanel);
            restaurantBackBtnPanel.setBackground(new Color(242, 196, 142));
        }catch(IOException ex){
            ex.printStackTrace();
        }
      
        JLabel pettype_label= new JLabel("PET TYPE");
        pettype_label.setBounds(70, 175, 130, 15);
        pettype_label.setForeground(Color.GRAY);
        profile_panel.add(pettype_label);
        
        profile_petType=new JLabel();
        profile_petType.setBounds(70, 190, 280, 30);
        profile_panel.add(profile_petType);
        profile_petType.setFont(font);
        profile_petType.setBorder(border);
        
        try {
            File imageFile = new File("IMAGE/feed_8156232.png");
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
            restaurantBackBtnPanel.setBounds(25, 180,29, 29);
            profile_panel.add(restaurantBackBtnPanel);
            restaurantBackBtnPanel.setBackground(new Color(242, 196, 142));
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        JLabel petName_label= new JLabel("PET NAME");
        petName_label.setBounds(70, 255, 130, 15);
        petName_label.setForeground(Color.GRAY);
        profile_panel.add(petName_label);
        
        profile_petName=new JLabel();
        profile_petName.setBounds(70, 270, 280, 30);
        profile_petName.setFont(font);
        profile_petName.setBorder(border);
        profile_panel.add(profile_petName);
        
        try {
            File imageFile = new File("IMAGE/pet-food_2965394.png");
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
            restaurantBackBtnPanel.setBounds(26, 263,32, 32);
            profile_panel.add(restaurantBackBtnPanel);
            restaurantBackBtnPanel.setBackground(new Color(242, 196, 142));
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        JLabel petheight_label= new JLabel("PET HEIGHT");
        petheight_label.setBounds(70, 420, 130, 15);
        petheight_label.setForeground(Color.GRAY);
        profile_panel.add(petheight_label);
         
        profile_petHeight=new JLabel();
        profile_petHeight.setBounds(70, 435, 280, 30);
        profile_petHeight.setFont(font);
        profile_petHeight.setBorder(border);
        profile_panel.add(profile_petHeight);
        
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
            restaurantBackBtnPanel.setBounds(25, 420,29, 29);
            profile_panel.add(restaurantBackBtnPanel);
            restaurantBackBtnPanel.setBackground(new Color(242, 196, 142));
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        JLabel petweight_label= new JLabel("PET WEIGHT");
        petweight_label.setBounds(70, 330, 130, 15);
        petweight_label.setForeground(Color.GRAY);
        profile_panel.add(petweight_label);
        
        profile_petWeight=new JLabel();
        profile_petWeight.setBounds(70, 347, 280, 30);
        profile_panel.add(profile_petWeight);
        profile_petWeight.setFont(font);
        profile_petWeight.setBorder(border);
        
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
            restaurantBackBtnPanel.setBounds(25, 340,29,29);
            profile_panel.add(restaurantBackBtnPanel);
            restaurantBackBtnPanel.setBackground(new Color(242, 196, 142));
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        addheightJLabel = new JLabel("ADD HEIGHT");
        addheightJLabel.setBounds(100, 435, 130, 24);
        addheightJLabel.setOpaque(true);
        addheightJLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        addheightJLabel.setBackground(new Color(142, 196, 210));
        addheightJLabel.setFont(font);
        addheightJLabel.setVisible(false);
        addheightJLabel.setForeground(Color.black);
        addheightJLabel.setBorder(upda);
        profile_panel.add(addheightJLabel);
        
        addweightJLabel=new JLabel("ADD WEIGHT");
        addweightJLabel.setBounds(100, 347, 130, 24);
        addweightJLabel.setOpaque(true);
        addweightJLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        addweightJLabel.setBackground(new Color(142, 196, 210));
        addweightJLabel.setFont(font);
        addweightJLabel.setVisible(false);
        addweightJLabel.setForeground(Color.black);
        addweightJLabel.setBorder(upda);
        profile_panel.add(addweightJLabel);
        
        try {
            File imageFile = new File("IMAGE/cross-mark_8369334.png");
            BufferedImage restBackBtnImage = ImageIO.read(imageFile);
            closeJPanel_button = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (restBackBtnImage != null) {
                        g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                    }
                }
            };
            closeJPanel_button.setBounds(350, 20,30, 30);
            head_JPanel2.add(closeJPanel_button);
            closeJPanel_button.setBackground(new Color(142, 196, 210));
        }catch(IOException ex){
            ex.printStackTrace();
        }
        closeJPanel_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	Home.this.dispose();
            }
        });
        
        try {
            File imageFile = new File("IMAGE/right-arrow_271228.png");
            BufferedImage restBackBtnImage = ImageIO.read(imageFile);
            update_email= new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (restBackBtnImage != null) {
                        g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                    }
                }
            };
            update_email.setBounds(250, 1,20, 20);
            profile_emaiL.add(update_email);
            update_email.setBackground(new Color(242, 196, 142));
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        update_email.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
          	  profile_panel.setVisible(false);
          	  updating_panel.setVisible(true);
            	  update_database_value="email";
            	  log_out.setVisible(false); 
            	  allbackimage.setVisible(false);
            	  updateback_button.setVisible(true);
              	  search_update_current_value.doClick();
              	update_database_string="EMAIL";
                update_label.setText("UPDATE "+update_database_string);
           }
  	});
        
        
      try {
      File imageFile = new File("IMAGE/right-arrow_271228.png");
      BufferedImage restBackBtnImage = ImageIO.read(imageFile);
      update_height= new JPanel() {
          @Override
          protected void paintComponent(Graphics g) {
              super.paintComponent(g);
              if (restBackBtnImage != null) {
                  g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
              }
          }
      };
      update_height.setBounds(250, 1,20, 20);
      profile_petHeight.add(update_height);
      update_height.setBackground(new Color(242, 196, 142));
     }catch(IOException ex){
      ex.printStackTrace();
     }
      
      update_height.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
        	  profile_panel.setVisible(false);
        	  updating_panel.setVisible(true);
          	  update_database_value="pet_height";
          	  log_out.setVisible(false); 
          	  allbackimage.setVisible(false);
          	  updateback_button.setVisible(true);
          	  search_update_current_value.doClick();
              update_database_string="PET HEIGHT";
              update_label.setText("UPDATE "+update_database_string);
         }
	});
      
        
      try {
      File imageFile = new File("IMAGE/right-arrow_271228.png");
      BufferedImage restBackBtnImage = ImageIO.read(imageFile);
      update_weight= new JPanel() {
          @Override
          protected void paintComponent(Graphics g) {
              super.paintComponent(g);
              if (restBackBtnImage != null) {
                  g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
              }
          }
      };
      update_weight.setBounds(250, 1,20, 20);
      profile_petWeight.add(update_weight);
      update_weight.setBackground(new Color(242, 196, 142));
     }catch(IOException ex){
      ex.printStackTrace();
     }
    
    update_weight.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
        	  profile_panel.setVisible(false);
        	  updating_panel.setVisible(true);
          	  update_database_value="pet_weight";
          	  log_out.setVisible(false); 
          	  allbackimage.setVisible(false);
          	  updateback_button.setVisible(true);
          	  search_update_current_value.doClick();
          	update_database_string="PET WEIGHT";
              update_label.setText("UPDATE "+update_database_string);
         }
	});
      
     updating_panel= new JPanel();  
     updating_panel.setBounds(0, 60, 400, 500);
     updating_panel.setLayout(null);
     updating_panel.setVisible(false);
     updating_panel.setBorder(border_profile);
     updating_panel.setBackground(new Color(242, 196, 142));
     this.add(updating_panel);
     Border updating_panell_border = BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(142, 196, 210));
      
     update_addingall_panel=new JPanel();
     update_addingall_panel.setBounds(50, 90, 300, 320);
     update_addingall_panel.setLayout(null);
     update_addingall_panel.setVisible(true);
     update_addingall_panel.setBorder(updating_panell_border);
     update_addingall_panel.setBackground(new Color(232, 191, 144));
     updating_panel.add(update_addingall_panel);
      try {
          File imageFile = new File("IMAGE/left-arrow.png");
          BufferedImage restBackBtnImage = ImageIO.read(imageFile);
          updateback_button = new JPanel() {
              @Override
              protected void paintComponent(Graphics g) {
                  super.paintComponent(g);
                  if (restBackBtnImage != null) {
                      g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                  }
              }
          };
          updateback_button.setBounds(10, 20,20, 20);
          updateback_button.setBackground(new Color(142, 196, 210));
          head_JPanel2.add(updateback_button);
      }catch(IOException ex){
          ex.printStackTrace();
      }
      
      updateback_button.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
        	  updateback_button.setVisible(false);
        	  allbackimage.setVisible(true);
        	  log_out.setVisible(true);
        	  updating_panel.setVisible(false);
          	  profile_panel.setVisible(true);
          	  b1.doClick();
          }      
      });
      
      search_update_current_value= new JButton();
      profile_panel.add(search_update_current_value);
      search_update_current_value.setBounds(1, 1, 10, 10);
      search_update_current_value.setVisible(false);
      search_update_current_value.addActionListener(this);
      
      allupdate_text= new JTextField();
      allupdate_text.setBounds(20,90,250,40);
      allupdate_text.setHorizontalAlignment(SwingConstants.CENTER); 
      allupdate_text.setBorder(border88);
      allupdate_text.setBackground(new Color(232, 191, 144));
      allupdate_text.setFont(font);
      update_addingall_panel.add(allupdate_text);
      
      kg= new JLabel();
      kg.setText("KG");
      kg.setFont(font);
      kg.setBounds(150, 10, 50, 20);
      kg.setVisible(false);
      allupdate_text.add(kg);
      
      m= new JLabel();
      m.setText("M");
      m.setFont(font);
      m.setBounds(150, 10, 50, 20);
      m.setVisible(false);
      allupdate_text.add(m);
      
      Font update_font= new Font("Tahoma", Font.PLAIN, 20);
      update_label= new JLabel();
      update_label.setBounds(70,30,200,50);
      update_label.setFont(update_font);
      update_addingall_panel.add(update_label);
       
      updating_button= new JButton("UPDATE");
      updating_button.setBounds(70,199,150, 34);
      updating_button.addActionListener(this);
      updating_button.setBackground(new Color(142, 196, 210)); 
      updating_button.setBorder(new LineBorder(Color.black));
      updating_button.setForeground(Color.darkGray); 
      updating_button.setFont(font3);
      updating_button.setFocusable(false);
      update_addingall_panel.add(updating_button);
      
       this.setVisible(true);
     }
    
      
    class GlassPane extends JPanel {
        public GlassPane() {
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (Home.this.notificationPanel.isVisible()) {
            	
                Rectangle headPanelBounds = Home.this.head_JPanel.getBounds();
                Point topLeft = SwingUtilities.convertPoint(Home.this.head_JPanel, 0, 0, this);
                
                g.setColor(new Color(255, 255, 255, 100));     
                g.fillRect(topLeft.x, topLeft.y, headPanelBounds.width, headPanelBounds.height);

                Rectangle notificationPanel2Bounds = Home.this.notificationPanel2.getBounds();
                topLeft = SwingUtilities.convertPoint(Home.this.notificationPanel2, 0, 0, this);
                g.fillRect(topLeft.x, topLeft.y, notificationPanel2Bounds.width, notificationPanel2Bounds.height);
            } else if (Home.this.cart_panel.isVisible()) {
                	
            	Rectangle headPanelBounds = Home.this.head_JPanel.getBounds();
                Point topLeft = SwingUtilities.convertPoint(Home.this.head_JPanel, 0, 0, this);
                
                g.setColor(new Color(255, 255, 255, 100));     
                g.fillRect(topLeft.x, topLeft.y, headPanelBounds.width, headPanelBounds.height);

                Rectangle notificationPanel2Bounds = Home.this.notificationPanel2.getBounds();
                topLeft = SwingUtilities.convertPoint(Home.this.notificationPanel2, 0, 0, this);
                g.fillRect(topLeft.x, topLeft.y, notificationPanel2Bounds.width, notificationPanel2Bounds.height);
            }
            else {
            	
            }
        }
    }
    
    public void searchnotifi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            
            String selectQuery = "SELECT * FROM notification WHERE username=? AND current=? ";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setString(1, user_name);
            selectStatement.setString(2, "NEW");

            ResultSet resultSet = selectStatement.executeQuery();

            int count = 0;
            while (resultSet.next()) {
                count++;
            }

            if (count > 0 ) {
            	
                notifi_found.setVisible(true);
            } else {
            	
            }
            
            String selectQuary2 = "SELECT * FROM register WHERE user_name = ?";
            PreparedStatement selectStatement2 = connection.prepareStatement(selectQuary2);
            selectStatement2.setString(1, user_name);

            ResultSet resultSet2 = selectStatement2.executeQuery();
            while(resultSet2.next()) {
                String spetType = resultSet2.getString("pet_type");
                String spetName = resultSet2.getString("pet_name");
                int home_height = resultSet2.getInt("pet_height");
                int home_weight = resultSet2.getInt("pet_weight");
                
                home_petnameJLabel.setText(spetName);
                 texttyyy.setText("meet "+spetName+" your loyal companion."); 
                 contains_1.setText("triexy stands at around "+home_height+"m inches ,");
                 contains_2.setText("weighs "+home_weight+" kg pounds.");

                if(home_height==0 || home_weight==0) {
                	homepanel_step2.setVisible(true);
                	homepanel_informartion.setVisible(false);
                }
                else {
                	homepanel_informartion.setVisible(true);
                	homepanel_step2.setVisible(false);
                	
                }

            } 
            
            resultSet.close();
            selectStatement.close();
            
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void actionPerformed(ActionEvent e) {
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);  

            if (e.getSource() == b1) {
            	
                String selectQuary = "SELECT * FROM register WHERE user_name = ?";
                PreparedStatement selectStatement = connection.prepareStatement(selectQuary);
                selectStatement.setString(1, user_name);

                ResultSet resultSet = selectStatement.executeQuery();
                while(resultSet.next()) {
                    String sname = resultSet.getString("user_name");
                    String semail = resultSet.getString("email");
                    String spetType = resultSet.getString("pet_type");
                    String spetName = resultSet.getString("pet_name");
                    int spetheight = resultSet.getInt("pet_height");
                    int spetWeight = resultSet.getInt("pet_weight");
                 
                    profile_username.setText(sname);
                    profile_emaiL.setText(semail);
                    profile_petType.setText(spetType);
                    profile_petName.setText(spetName);
                    if(spetheight==0) {
                    	addheightJLabel.setVisible(true);
                    }
                    else {
                        profile_petHeight.setText(spetheight+" M");
                    	addheightJLabel.setVisible(false);

					}
                    if(spetWeight==0) {
                    	addweightJLabel.setVisible(true);
                    }
                    else {
                        profile_petWeight.setText(spetWeight+" KG");
                    	addweightJLabel.setVisible(false);
					}
                } 
                resultSet.close();
                selectStatement.close();
            }
        
                if (e.getSource() == search_update_current_value) {
                    String selectQuery = "SELECT * FROM register WHERE user_name = ?";
                    PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
                    selectStatement.setString(1, user_name);

                    ResultSet resultSet = selectStatement.executeQuery();
                    while (resultSet.next()) {
                         sname = resultSet.getString(update_database_value);
                         allupdate_text.setText(sname);
                         if(update_database_value=="pet_weight") {
                        	 kg.setVisible(true);
                             m.setVisible(false);	 
                         }
                        else  if(update_database_value=="pet_height") {
                        	 m.setVisible(true);
                             kg.setVisible(false);  	 
                         } 
                         else {
                        	 m.setVisible(false);
                             kg.setVisible(false);  	
						}
                            
                    }
                }
  
            if(e.getSource() == updating_button) {
                String updateString =allupdate_text.getText();
                String sql_update = "UPDATE register SET "+update_database_value+"=? WHERE user_name=?";
                PreparedStatement statement = connection.prepareStatement(sql_update);
                statement.setString(1,updateString );
                statement.setString(2, user_name);

                int rowsUpdated = statement.executeUpdate(); 
                if (rowsUpdated > 0) {
                	
                 	 
                 	 String insert_notifi = "INSERT INTO notification(content,current,username)VALUES (?,?,? )";
                     PreparedStatement statement2 = connection.prepareStatement(insert_notifi);
                     statement2.setString(1,""+user_name+" your profile has been successfully updated.new  "+update_database_value+" is updated." );
                     statement2.setString(2, "new");
                     statement2.setString(3, user_name);

                     int rowsAffected = statement2.executeUpdate();
                     
                    if(rowsAffected>0) {
                    	  updateback_button.setVisible(false);
                    	     allbackimage.setVisible(true);
                    	     log_out.setVisible(true);
                    	     updating_panel.setVisible(false);
                      	 profile_panel.setVisible(true);
                      	 b1.doClick(); 
                    }                 	  
                } else {
                 }

                 statement.close();
            
            	
            }
            	
            if(e.getSource() == book_room) {
            	      this.dispose();
            	      Room_book_model model = new Room_book_model();
            	      Room_book_view view = new Room_book_view(user_name);
            	      new Room_book_contoll(view, model);         				
         	
            }
            if(e.getSource() == apply_greencard) {
//      	          this.dispose();
   			    //  new Green_card();
   				
   	
            }
            if (e.getSource() == button) {
                notificationPanel.setVisible(true);
                notificationPanel2.setVisible(true);
                glassPane.setVisible(true); 
                home_panel.setVisible(false);
                notifi_found.setVisible(false);
                button_cart.setEnabled(false);
                button.setEnabled(false);
                b1.setEnabled(false);

                String selectQuery = "SELECT * FROM notification WHERE username=? ";
                PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
                selectStatement.setString(1, user_name);
   
                ResultSet resultSet = selectStatement.executeQuery();
                  while (resultSet.next()) {
                  String centerName = resultSet.getString("content");

                  Object[] newRow = {centerName};
                  model.addRow(newRow);
                  
              }
               selectStatement.close();
               
               String sql = "UPDATE notification SET current='old' WHERE username=?";
               PreparedStatement statement = connection.prepareStatement(sql);
               statement.setString(1,user_name);

               int rowsUpdated = statement.executeUpdate(); 
               if (rowsUpdated > 0) {
            	   
                } 
               else {
            	   
                }

                statement.close();
            }
            if(e.getSource()==button_cart) {
                cart_panel.setVisible(true);
                notificationPanel2.setVisible(true);
                glassPane.setVisible(true); 
                home_panel.setVisible(false);
                button_cart.setEnabled(false);
                button.setEnabled(false);
                b1.setEnabled(false);
                
                String selectQuery = "SELECT * FROM booking WHERE user_name=? ";
                PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
                selectStatement.setString(1, user_name);
   
                ResultSet resultSet = selectStatement.executeQuery();
                while (resultSet.next()) {
                    String center = resultSet.getString("center_name");
                    int price = resultSet.getInt("total_price");
                    int booking_id = resultSet.getInt("booking_id");
                    String start_date=resultSet.getString("start_date");
                    String end_date=resultSet.getString("end_date");
                    String content = "BOOKED CENTER: " + center + "\n" 
                                   + "TOTAL PRICE     : $"+price+""
                    		  + "\n"+"BOOKING ID      : PETS" +booking_id +"\n"
                                   + "BOOKING DATE : "+start_date +"\n"
                    		       + "CHECKOUT DATE: "+end_date; 
                    Object[] newRow = {content};
                    cart_model.addRow(newRow);
                }

                  
              
               selectStatement.close();
                
                
            }

            connection.close();
        
        }
        catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace(); 
            JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    class MultiLineTableCellRenderer extends JTextArea implements TableCellRenderer {
        MultiLineTableCellRenderer() {
            setLineWrap(true);
            setWrapStyleWord(true);
            setOpaque(true);
            setFont(new Font("Arial", Font.PLAIN, 15));
            setBackground(Color.white);
            setMargin(new Insets(5, 10, 10, 10)); 
            
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText("- "+ value);
            return this;
        }
    }
    class MultiLineTableCellRenderer2 extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JTextArea textArea = new JTextArea(value.toString());
            textArea.setWrapStyleWord(true);
            textArea.setLineWrap(true);
            textArea.setEditable(false);
            textArea.setOpaque(true);
            textArea.setMargin(new Insets(5, 10, 10, 10));
            cart_table.setSelectionBackground(Color.white);
            textArea.setBackground(isSelected ? cart_table.getSelectionBackground() : cart_table.getBackground());
            textArea.setForeground(isSelected ? cart_table.getSelectionForeground() : cart_table.getForeground());
            textArea.setFont(new Font("Arial", Font.PLAIN, 14));
            return textArea;
        }
    }

}
   

