package Final_project_mvc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class Login_view extends JFrame {
	
	JPanel login_1,closeJPanel_button,closeJPanel_button2;
    JPanel login_2,back_button;
    JPanel login_3;
    JTextField usernameField;
    JTextField passwordField;
    JButton login_button;
    JButton creButton;
    JLabel creJLabel;
    JLabel user_alreadyreg;    
    JTextField enter_usernameField;
    JTextField enter_passwordField,enter_petnameField;
    JTextField enter_emailField;
    JComboBox<String> petlist;
    
    boolean typingStarted = false;
    
    Login_view(){
    	this.setSize(400,560);
        getContentPane().setLayout(null);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
         
        Font font = new Font("Times New Roman", Font.PLAIN, 14);
        Font erorrFont= new Font("Arial", Font.PLAIN, 13);
        Font creFont=new Font("Arial", Font.BOLD | Font.ITALIC , 11);
        Border border1 = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK);
     
        login_2= new JPanel();
        login_2.setBounds(0, 0,400, 560);
        login_2.setBackground(new Color(242, 196, 142)); 
        login_2.setLayout(null);
        login_2.setBorder(border1);
        this.add(login_2);

        try {
            File imageFile = new File("IMAGE/cross-mark_8369334.png");
            BufferedImage restBackBtnImage = ImageIO.read(imageFile);
            closeJPanel_button2 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (restBackBtnImage != null) {
                        g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                    }
                }
            };
            closeJPanel_button2.setBounds(350, 15,30, 30);
            login_2.add(closeJPanel_button2);
            closeJPanel_button2.setBackground(new Color(242, 196, 142));
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        try {
            File imageFile = new File("IMAGE/Logo-Ians-Pups-Grooming-All-versions.png");
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
            allbackimage.setBounds(80, 130,230,74);
            allbackimage.setBackground(new Color(242, 196, 142));
            login_2.add(allbackimage);
        } catch(IOException ex){
            ex.printStackTrace();
     }
            
        usernameField= new JTextField();
        usernameField.setBounds(80,240,247, 40);
        usernameField.setHorizontalAlignment(JTextField.CENTER);
        usernameField.setFont(font);
        usernameField.setText("USER NAME");
       
        login_2.add(usernameField);
        usernameField.setBorder(new LineBorder(new Color(161,158,158)));
        
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
            usernameField.add(allbackimage);
        } catch(IOException ex){
            ex.printStackTrace();
        }

          
        usernameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                typingStarted = true;

                if (usernameField.getText().equals("USER NAME")) {
                    usernameField.setText("");
                }
                Font userFont = new Font("Arial", Font.PLAIN, 14);
                usernameField.setFont(userFont);
            }
        });
          
         passwordField= new JTextField();
         passwordField.setBounds(80,300,247, 40);
         passwordField.setHorizontalAlignment(JTextField.CENTER);
         passwordField.setBorder(new LineBorder(new Color(161,158,158)));
         passwordField.setFont(font);
         passwordField.setText("PASSWORD");
         login_2.add(passwordField);
         
         try {
                File imageFile = new File("IMAGE/lock_14649886.png");
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
                allbackimage.setBounds(35, 9,20,20);
                allbackimage.setBackground(Color.white);
                passwordField.add(allbackimage);
            } catch(IOException ex){
                ex.printStackTrace();
         }
           
         passwordField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                     typingStarted = true;
                     if (passwordField.getText().equals("PASSWORD")) {
                         passwordField.setText("");
                     }
                     Font userFont = new Font("Arial", Font.PLAIN, 14);
                     passwordField.setFont(userFont);
                }
         });
         
         Font font3 = new Font("Arial", Font.BOLD, 20);
           
         login_button = new JButton("SIGN IN");
         login_button.setBounds(80,360,247, 40);
         login_2.add(login_button);
         login_button.setBackground(new Color(142, 196, 210)); 
         login_button.setBorder(new LineBorder(Color.black));
         login_button.setForeground(Color.darkGray); 
         login_button.setFont(font3);
         login_button.setFocusable(false);   
         
//         msJLabel = new  JLabel();
//         msJLabel.setText("Incorrect username or password");
//         msJLabel.setForeground(Color.red);
//         msJLabel.setBounds(82, 400, 200, 24);
//         msJLabel.setFont(erorrFont);
//         msJLabel.setVisible(true);
//         login_2.add(msJLabel);  
         login_2.setVisible(true); 
         
         Font fonttetxt = new Font("Pathway Gothic One", Font.PLAIN , 13);  

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
             restaurantBackBtnPanel.setBounds(50,450,17,17);
             login_2.add(restaurantBackBtnPanel);
            restaurantBackBtnPanel.setBackground(new Color(240, 199, 151));
         }catch(IOException ex){
             ex.printStackTrace();
         }
         
         JLabel step2teJLabel=new JLabel();
         step2teJLabel.setText("Login by enetering details.new here creat a account.");
         step2teJLabel.setBounds(75,442,290,30);
         step2teJLabel.setFont(fonttetxt);
         step2teJLabel.setForeground(Color.gray);
         login_2.add(step2teJLabel);
  	                   
         this.setVisible(true);
         
         creJLabel = new JLabel("CREATE ACCOUNT");
         creJLabel.setFont(creFont);
         creJLabel.setBounds(82, 421, 200, 30);
         creJLabel.setForeground(new Color(77, 77, 77));
         login_2.add(creJLabel);
         
         login_3= new JPanel();
         login_3.setBounds(0,0, 400, 560);
         login_3.setVisible(false);
         login_3.setBackground(new Color(242, 196, 142));
         login_3.setLayout(null);
         login_3.setBorder(border1);
         getContentPane().add(login_3);
         
         try {
             File imageFile = new File("IMAGE/left-arrow.png");
             BufferedImage restBackBtnImage = ImageIO.read(imageFile);
             back_button = new JPanel() {
                 @Override
                 protected void paintComponent(Graphics g) {
                     super.paintComponent(g);
                     if (restBackBtnImage != null) {
                         g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                     }
                 }
             };
             back_button.setBounds(25,20,20,20);
             back_button.setBackground(new Color(242, 196, 142));
             login_3.add(back_button);
         } catch(IOException ex){
             ex.printStackTrace();
         }
         
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
             closeJPanel_button.setBounds(350,15,30, 30);
             login_3.add(closeJPanel_button);
             closeJPanel_button.setBackground(new Color(242, 196, 142));
         }catch(IOException ex){
             ex.printStackTrace();
         }
         closeJPanel_button.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
             	Login_view.this.dispose();
             }
         });
         
         enter_usernameField= new JTextField();
         enter_usernameField.setBounds(80,110,247, 40);
         enter_usernameField.setHorizontalAlignment(JTextField.CENTER);
         enter_usernameField.setFont(font);
         enter_usernameField.setBorder(new LineBorder(new Color(161,158,158)));
         enter_usernameField.setText("USER NAME");
         login_3.add(enter_usernameField);
         
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
             enter_usernameField.add(allbackimage);
         } catch(IOException ex){
             ex.printStackTrace();
         }
        
        enter_usernameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                 typingStarted = true;

                 if (enter_usernameField.getText().equals("USER NAME")) {
                     enter_usernameField.setText("");
                 }
                 Font userFont = new Font("Arial", Font.PLAIN, 14);
                 enter_usernameField.setFont(userFont);
            }
        });
        
         enter_passwordField= new JTextField();
         enter_passwordField.setBounds(80,170,247, 40);
         enter_passwordField.setHorizontalAlignment(JTextField.CENTER);
         enter_passwordField.setFont(font);
         enter_passwordField.setBorder(new LineBorder(new Color(161,158,158)));
         enter_passwordField.setText("PASSWORD");
         login_3.add(enter_passwordField);
         
         try {
             File imageFile = new File("IMAGE/lock_14649886.png");
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
             allbackimage.setBounds(35, 9,20,20);
             allbackimage.setBackground(Color.white);
             enter_passwordField.add(allbackimage);
         } catch(IOException ex){
             ex.printStackTrace();
         }
         
        enter_passwordField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                     typingStarted = true;

                     if (enter_passwordField.getText().equals("PASSWORD")) {
                         enter_passwordField.setText("");
                     }
                     Font userFont = new Font("Arial", Font.PLAIN, 14);
                     enter_passwordField.setFont(userFont);
                }
         });
          
         enter_emailField= new JTextField();
         enter_emailField.setBounds(80,230,247, 40);
         enter_emailField.setHorizontalAlignment(JTextField.CENTER);
         enter_emailField.setFont(font);
         enter_emailField.setText("EMAIL");
         enter_emailField.setBorder(new LineBorder(new Color(161,158,158)));
         login_3.add(enter_emailField);
         
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
             restaurantBackBtnPanel.setBounds(35, 9,20,20);
             enter_emailField.add(restaurantBackBtnPanel);
             restaurantBackBtnPanel.setBackground(Color.WHITE);
         }catch(IOException ex){
             ex.printStackTrace();
         }
         
         enter_emailField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                     typingStarted = true;

                     if (enter_emailField.getText().equals("EMAIL")) {
                         enter_emailField.setText("");
                     }
                     Font userFont = new Font("Arial", Font.PLAIN, 14);
                     enter_emailField.setFont(userFont);
                }
         });
         
         
         String [] items= {"DOG","CAT"};
         petlist = new JComboBox<String>(items);
         petlist.setFont(font);
         petlist.setBounds(80,290,247, 40);
         login_3.add(petlist);
         
         enter_petnameField= new JTextField();
         enter_petnameField.setBounds(80,350,247, 40);
         enter_petnameField.setHorizontalAlignment(JTextField.CENTER);
         enter_petnameField.setFont(font);
         enter_petnameField.setText("PET NAME");
         enter_petnameField.setBorder(new LineBorder(new Color(161,158,158)));
         login_3.add(enter_petnameField);
         
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
             restaurantBackBtnPanel.setBounds(35, 9,20,20);
             enter_petnameField.add(restaurantBackBtnPanel);
             restaurantBackBtnPanel.setBackground(Color.WHITE);
         }catch(IOException ex){
             ex.printStackTrace();
         }
         
         enter_petnameField.addKeyListener(new KeyAdapter() {
             @Override
             public void keyPressed(KeyEvent e) {
                  typingStarted = true;

                  if (enter_petnameField.getText().equals("PET NAME")) {
                	  enter_petnameField.setText("");
                  }
                  Font userFont = new Font("Arial", Font.PLAIN, 14);
                  enter_petnameField.setFont(userFont);
             }
      });
         
         Font font4 = new Font("Arial", Font.BOLD, 19);
         
         creButton = new JButton("CREATE ACCOUNT");
         creButton.setBounds(80,430,247, 40);
         login_3.add(creButton);
         creButton.setBackground(new Color(142, 196, 210)); 
         creButton.setForeground(Color.darkGray); 
         creButton.setFont(font4);
         creButton.setBorder(new LineBorder(Color.black));
         creButton.setFocusable(false);
              
//         cretesuccesmsgJLabel=new JLabel();
//         cretesuccesmsgJLabel.setText("SUCCESSFULLT REGISTERD");
//         cretesuccesmsgJLabel.setBounds(31, 439, 220, 30);
//         login_3.add(cretesuccesmsgJLabel);
//         cretesuccesmsgJLabel.setVisible(true);
//         
//      JLabel   admin=new JLabel();
//      admin.setText("admin");
//      admin.setBounds(31, 399, 220, 30);
//      h.add(user_alreadyreg);
//      admin.setVisible(false);
        
        this.setVisible(true);
    }
    
    public String login_Username() {
        return usernameField.getText();
    }
    
    public String login_password() {
        return passwordField.getText();
    }
    
    public String create_username() {
        return enter_usernameField.getText();
    }
    
    public String create_password() {
        return enter_passwordField.getText();
    }
    
    public String create_email() {
        return enter_emailField.getText();
    }
    
    public String create_petType() {
        return (String)petlist.getSelectedItem();
    }
    
    public String create_petname() {
        return enter_petnameField.getText();
    }
    
    public void addLoginListener(ActionListener listener) {
        login_button.addActionListener(listener);
    }
    
    public void addRegisterListener(ActionListener listener) {
        creButton.addActionListener(listener);
    }
    public void closepanllistner(MouseListener listener) {
    	closeJPanel_button2.addMouseListener(listener);
    }
    
    public void loginbuttonlistner(MouseListener listener) {
    	login_button.addMouseListener(listener);
    }
    public void crejlabellistner(MouseListener listener) {
    	creJLabel.addMouseListener(listener);
    }
    public void backbuttonlistner(MouseListener listener) {
    	back_button.addMouseListener(listener);
    }
    public void crebuttonlistner(MouseListener listener) {
    	creButton.addMouseListener(listener);
    }}
