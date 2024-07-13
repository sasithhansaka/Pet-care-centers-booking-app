package Final_project_mvc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Room_book_view extends JFrame{
	private String user_name;
	 JButton all_rommsButton,pet_foodavailable_buttJButton,pet_foodunavailable_buttJButton;
	 JButton check_availabailityButton;
	 JPanel head_JPanel,middle_panel,allbackimage,fish_image,meat_image,petfood,food_catagory,petfood_catagory,closeJPanel_button2,poke_image;
	 JLabel profile_label,food_catagary_label,petfood_catagary_label,location,label1,label2,msJLabel;
	 JComboBox<String> searh_locationField;
	 ButtonGroup buttonGroup,buttonGroup2;
	 JRadioButton fish,meat,pokeButton;
	 JRadioButton pet_foodavailable,pet_foodunavailble;
	 ArrayList<String> uniqueLocations = new ArrayList<>();
     JButton search_buttonButton;
   
        String url = "jdbc:mysql://localhost:3306/pet_care";
		String username = "root";
		String password = "";
		
		String search_food_name="fish";
		String search_petfood_yesorno="yes";
		
	    public Room_book_view(String user_name) {
	    this.user_name=user_name;
	        	        
		this.setUndecorated(true);
        this.setSize(400,560);
        getContentPane().setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
       
        head_JPanel= new JPanel();
        head_JPanel.setLayout(null);
        head_JPanel.setBounds(0, 0, 400, 60);
        head_JPanel.setBackground(new Color(142, 196, 210));
        Border border1 = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK);
        head_JPanel.setBorder(border1);
        getContentPane().add(head_JPanel);
 
        profile_label= new JLabel();
        profile_label.setText("BOOK PET");
        profile_label.setBounds(145, 25, 190, 20 );
        profile_label.setVisible(true);
        head_JPanel.add(profile_label);
        profile_label.setForeground(Color.black);
        Font profile_font= new Font("Tahoma", Font.PLAIN, 20);
        profile_label.setFont(profile_font);
       
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
       allbackimage.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
        	   Home homeWindow = new Home(Room_book_view.this.user_name); 
               homeWindow.searchnotifi();
              
               Room_book_view.this.dispose();
           }
       });
       
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
           closeJPanel_button2.setBackground(new Color(142, 196, 210));
           head_JPanel.add(closeJPanel_button2);
       }catch(IOException ex){
           ex.printStackTrace();
       }
       closeJPanel_button2.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
           	Room_book_view.this.dispose();
           }
       });
       
       middle_panel= new JPanel();
       middle_panel.setLayout(null);
       middle_panel.setBounds(0, 60, 400, 500);
       middle_panel.setBackground(new Color(242, 196, 142));
       getContentPane().add(middle_panel);
       Border border = BorderFactory.createMatteBorder(0, 2, 2, 2, Color.BLACK);
       middle_panel.setBorder(border);
       
       location = new JLabel();
       location.setText("LOCATIONS");
       middle_panel.add(location);
       location.setBounds(40, 10, 250, 20);
       location.setFont(new Font("Tahoma", Font.PLAIN, 18));

       searh_locationField= new JComboBox<String>();
       searh_locationField.setBorder(BorderFactory.createEmptyBorder());
       searh_locationField.setBorder(new LineBorder(Color.BLACK));
       searh_locationField.setBackground(Color.white);
       searh_locationField.setBounds(40,40, 320, 30);  
       
       getContentPane().add(searh_locationField);
       middle_panel.add(searh_locationField);
       
       food_catagory= new JPanel();
       food_catagory.setBounds(40, 90, 320, 129);
       food_catagory.setLayout(null);
       food_catagory.setBorder(new LineBorder(new Color(133, 133, 133)));
       food_catagory.setBackground(Color.white);
       
       middle_panel.add(food_catagory);
       
       food_catagary_label= new JLabel("FOOD CATAGORY");
       food_catagary_label.setBounds(10,5, 200, 30);
       food_catagory.add(food_catagary_label);
       food_catagary_label.setFont(new Font("Tahoma", Font.PLAIN, 18));

       Border border2 = BorderFactory.createMatteBorder(1, 1, 1, 1,Color.gray);
      
       fish= new JRadioButton("Fish");
       fish.setBounds(0, 0, 10,10 );
       fish.setVisible(false);
       food_catagory.add(fish);
       
       try {
           File imageFile = new File("IMAGE/cooking_13506037.png");
           BufferedImage restBackBtnImage = ImageIO.read(imageFile);
           fish_image = new JPanel() {
               @Override
               protected void paintComponent(Graphics g) {
                   super.paintComponent(g);
                   if (restBackBtnImage != null) {
                       g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                   }
               }
           };
           fish_image.setBounds(40,45,55, 55);
           fish_image.setBackground(Color.white);
           food_catagory.add(fish_image);
       }catch(IOException ex){
           ex.printStackTrace();
       }
       
       JLabel text_fish=new JLabel("FISH");
       text_fish.setBounds(50,90,50, 50);
       food_catagory.add(text_fish);
       text_fish.setFont(new Font("Verdana", Font.ITALIC, 12));
       
       meat= new JRadioButton("Meat");
       meat.setBounds(0, 0, 6,3 );
       meat.setVisible(false);
       food_catagory.add(meat);
       
       try {
           File imageFile = new File("IMAGE/peking-duck_6136043.png");
           BufferedImage restBackBtnImage = ImageIO.read(imageFile);
           meat_image = new JPanel() {
               @Override
               protected void paintComponent(Graphics g) {
                   super.paintComponent(g);
                   if (restBackBtnImage != null) {
                       g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                   }
               }
           };
           meat_image.setBounds(136,45,55,55);
           meat_image.setBackground(Color.white);
           food_catagory.add(meat_image);
       }catch(IOException ex){
           ex.printStackTrace();
       }
       
       JLabel text_meat=new JLabel("MEAT");
       text_meat.setBounds(145,90,50, 50);
       food_catagory.add(text_meat);
       text_meat.setFont(new Font("Verdana", Font.ITALIC, 12));
       
       pokeButton= new JRadioButton("Poke");
       pokeButton.setBounds(160, 80, 60,30 );
       pokeButton.setVisible(false);
       middle_panel.add(pokeButton);
       
       
       try {
           File imageFile = new File("IMAGE/bibimbap_8740490.png");
           BufferedImage restBackBtnImage = ImageIO.read(imageFile);
           poke_image = new JPanel() {
               @Override
               protected void paintComponent(Graphics g) {
                   super.paintComponent(g);
                   if (restBackBtnImage != null) {
                       g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                   }
               }
           };
           poke_image.setBounds(240,45,55, 55);
           poke_image.setBackground(Color.white);
           food_catagory.add(poke_image);
       }catch(IOException ex){
           ex.printStackTrace();
       }
       
       JLabel text_poke=new JLabel("POKE");
       text_poke.setBounds(250,90,50, 50);
       food_catagory.add(text_poke);
       text_poke.setFont(new Font("Verdana", Font.ITALIC, 12));
       
       buttonGroup = new ButtonGroup();
       buttonGroup.add(fish);
       buttonGroup.add(meat);
       buttonGroup.add(pokeButton);
        
       petfood_catagory=new JPanel();
       petfood_catagory.setBounds(40, 239, 320, 120);
       petfood_catagory.setLayout(null);
       petfood_catagory.setBorder(new LineBorder(new Color(133, 133, 133)));
       petfood_catagory.setBackground(Color.white);
       middle_panel.add(petfood_catagory);
       
       petfood_catagary_label= new JLabel("PET FOOD");
       petfood_catagary_label.setBounds(10,5, 200, 30);
       petfood_catagory.add(petfood_catagary_label);
       petfood_catagary_label.setFont(new Font("Tahoma", Font.PLAIN, 18));
       
       pet_foodavailable_buttJButton= new JButton();
       pet_foodavailable_buttJButton.setBounds(104, 59, 12, 12);
       petfood_catagory.add(pet_foodavailable_buttJButton);
       pet_foodavailable_buttJButton.setBackground(Color.white);  
       
       pet_foodavailable= new JRadioButton("YES");
       pet_foodavailable.setBounds(109, 60, 60, 30);
       pet_foodavailable.setVisible(false);
       petfood_catagory.add(pet_foodavailable);

       pet_foodunavailable_buttJButton= new JButton();
       pet_foodunavailable_buttJButton.setBounds(190,59,12,12);
       pet_foodunavailable_buttJButton.setBackground(Color.white);       
       petfood_catagory.add(pet_foodunavailable_buttJButton);
      
       pet_foodunavailble= new JRadioButton("NO");
       pet_foodunavailble.setBounds(190, 60, 60,30 );
       pet_foodunavailble.setVisible(false);
       petfood_catagory.add(pet_foodunavailble);
       
       label1= new JLabel("YES");
       label1.setBounds(124, 50, 60, 30);
       label1.setFont(new Font("Georgia", Font.PLAIN, 17));
       petfood_catagory.add(label1);
     
       
       label2= new JLabel("NO");
       label2.setBounds(210,50,60,30);
       label2.setFont(new Font("Georgia", Font.PLAIN, 17));
       petfood_catagory.add(label2);
       
       buttonGroup2 = new ButtonGroup();
       buttonGroup2.add(pet_foodavailable);
       buttonGroup2.add(pet_foodunavailble);
      
       try {
           File imageFile = new File("IMAGE/food_12704687.png");
           BufferedImage restBackBtnImage = ImageIO.read(imageFile);
           JPanel allbackimage1 = new JPanel() {
               @Override
               protected void paintComponent(Graphics g) {
                   super.paintComponent(g);
                   if (restBackBtnImage != null) {
                       g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                   }
               }
           };
           allbackimage1.setBounds(10,40,65, 65);
           allbackimage1.setBackground(Color.white);
           petfood_catagory.add(allbackimage1);
       }catch(IOException ex){
           ex.printStackTrace();
       }
       
       Font font4 = new Font("Segoe UI", Font.BOLD, 18);
	    
       search_buttonButton= new JButton("SEARCH");
       search_buttonButton.setBounds(80,390,247, 40);
       search_buttonButton.setBackground(new Color(142, 196, 210));
       search_buttonButton.setFont(font4);
       search_buttonButton.setBorder(new LineBorder(Color.black));
       search_buttonButton.setForeground(Color.darkGray); 
	   search_buttonButton.setFocusable(false);
       middle_panel.add(search_buttonButton);
       
//       Font errorFont = new Font("Courier New", Font.PLAIN, 16);
//       msJLabel = new  JLabel();
//       msJLabel.setText("Please make a selection for each option");
//       msJLabel.setForeground(Color.red);
//       msJLabel.setBounds(10, 440, 400, 19);
//       msJLabel.setFont(errorFont);
//       msJLabel.setVisible(false);
//       middle_panel.add(msJLabel); 
       
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
           middle_panel.add(restaurantBackBtnPanel);
          restaurantBackBtnPanel.setBackground(new Color(240, 199, 151));
       }catch(IOException ex){
           ex.printStackTrace();
       }
       
       JLabel step2teJLabel=new JLabel();
       step2teJLabel.setText("select the types as your wish.");
       step2teJLabel.setBounds(75,442,200,30);
       step2teJLabel.setFont(fonttetxt);
       step2teJLabel.setForeground(Color.gray);
       middle_panel.add(step2teJLabel);
	                   
       this.setVisible(true);
         
	   }
	    
	   public void addsearchvalue(ActionListener listener) 
	   {
	         search_buttonButton.addActionListener(listener);
	   }
	     
	   public String login_Username() {
	         return user_name;
	   }

	   public String getSelectedValue() {
	         if (fish.isSelected())
	             return fish.getText();
	         else if (meat.isSelected())
	             return meat.getText();
	         else if (pokeButton.isSelected())
	             return pokeButton.getText();
	         else
	             return null;
	  }
	     
	     public String getselecetyesno() {
	    	 if(pet_foodavailable.isSelected()) 
	    		 return pet_foodavailable.getText();
	         else  if(pet_foodunavailble.isSelected())
	 	         return pet_foodunavailble.getText();	
	    	 else
				 return null;
	     }
	     
	     public String getlocation() {
	         return (String)searh_locationField.getSelectedItem();
	     }
	     
	     public void addComboBoxItem(String item) {
	    	 searh_locationField .addItem(item);
	     } 
	     public void fishimagelistner(MouseListener listener) {
	     	fish_image.addMouseListener(listener);
	     }
	     public void meatimagelistner(MouseListener listener) {
		    meat_image.addMouseListener(listener);
		 }
	     public void pokeimagelistner(MouseListener listener) {
			    poke_image.addMouseListener(listener);
	     }
	     public void pet_foodavailable_buttJButtonlistner(ActionListener listener) 
		   {
		         pet_foodavailable_buttJButton.addActionListener(listener);
		   }
	     
	     public void pet_foodunavailable_buttJButtonlistner(ActionListener listener) 
		   {
		         pet_foodunavailable_buttJButton.addActionListener(listener);
		   }


	     
	     
}
