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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.toedter.calendar.JDateChooser;

import Final_project_mvc.Home.MultiLineTableCellRenderer;


public class Book_now extends JFrame implements ActionListener{
    private String user_name;
    private String location;
    private String search_food_name;
    private String search_petfood_yesorno;
    String content;
    JPanel head_JPanel,panel_2,allbackimage,allmiddele,star,closeJPanel_button,datePanel,addalldates;
    JTable table;
    JLabel profile_label;
    DefaultTableModel model;
    JButton book_now;
    String user_emailString;
    String user_petypeString,center_name;
    String url = "jdbc:mysql://localhost:3306/pet_care";
	String username = "root";
	String password = "";
	String centerString="";
	JDateChooser booking_date,checkout_date;
	JLabel contains_1,contains_2,contains_3,contains_4,checkoutday_labeLabel,bookingday_lael;
	Date bookingDate,checkoutDate;
	long diff;
	int center_price;
	long total;
    Book_now(String user_name,String location,String search_food_name,String search_petfood_yesorno){
        this.user_name=user_name;
        this.location=location;
        this.search_food_name=search_food_name;
        this.search_petfood_yesorno=search_petfood_yesorno;
               
        this.setUndecorated(true);
        this.setSize(400,560);
        this.setResizable(false);
        this.setLocationRelativeTo(null);  
        getContentPane().setLayout(null);
       
        head_JPanel= new JPanel();
        head_JPanel.setLayout(null);
        head_JPanel.setBounds(0, 0, 400, 60);
        head_JPanel.setBackground(new Color(142, 196, 210));
        Border border1 = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK);
        head_JPanel.setBorder(border1);
        getContentPane().add(head_JPanel);
        
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
        
//        try {
//            File imageFile = new File("IMAGE/Logo-Ians-Pups-Grooming-All-versionscrop.png");
//            BufferedImage restBackBtnImage = ImageIO.read(imageFile);
//            JPanel allbackimage = new JPanel() {
//                @Override
//                protected void paintComponent(Graphics g) {
//                    super.paintComponent(g);
//                    if (restBackBtnImage != null) {
//                        g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
//                    }
//                }
//            };
//            allbackimage.setBounds(55, 15,65,40);
//            allbackimage.setBackground(new Color(142, 196, 210));
//            head_JPanel.add(allbackimage);
//        } catch(IOException ex){
//            ex.printStackTrace();
//     }
        
        allbackimage.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
       	      Room_book_model model = new Room_book_model();
       	      Room_book_view view = new Room_book_view(user_name);
       	      new Room_book_contoll(view, model);  
     		 Book_now.this.dispose();
			}
		});
        
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
            head_JPanel.add(closeJPanel_button);
            closeJPanel_button.setBackground(new Color(142, 196, 210));
        }catch(IOException ex){
            ex.printStackTrace();
        }
        closeJPanel_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	Book_now.this.dispose();
            }
        });
        
        profile_label= new JLabel();
        profile_label.setText("BOOKING");
        profile_label.setBounds(145, 25, 100, 20 );
        head_JPanel.add(profile_label);
        profile_label.setForeground(Color.black);
        Font profile_font= new Font("Tahoma", Font.PLAIN, 20);
        profile_label.setFont(profile_font);
        Border border = BorderFactory.createMatteBorder(0, 2, 2, 2, Color.BLACK);
        
        allmiddele= new JPanel();
        allmiddele.setLayout(null);
        allmiddele.setBounds(0, 60, 400, 500);
        allmiddele.setBackground(new Color(242, 196, 142));
        allmiddele.setBorder(border);
        getContentPane().add(allmiddele);
       
        Border border7 = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK);
		panel_2 = new JPanel();
		panel_2.setBounds(10, 0, 380, 205);
		panel_2.setBackground(new Color(242, 196, 142));
		allmiddele.add(panel_2);
		
		model = new DefaultTableModel();
		table = new JTable(model);
		table.setBackground(new Color(209, 205, 205));
		table.setOpaque(true);
		
		
		int rowHeight = 55; 
	    table.setRowHeight(rowHeight);
	    table.setBounds(0, 0, 400, 200);
	       
	    model.addColumn("CENTERS");
	    JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(panel_2.getSize());
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        panel_2.add(scrollPane, BorderLayout.CENTER);
		 
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    
                    if (selectedRow != -1) {
                         content = (String) table.getValueAt(selectedRow, 0);
                        System.out.println("Selected Username: " + content);
                    }
                }
            }
        });
        addalldates=new JPanel();
        addalldates.setBounds(10,230,380, 91);
        addalldates.setLayout(null);
        addalldates.setBackground(new Color(206, 231, 237));
        addalldates.setBorder(new LineBorder(Color.black));
        allmiddele.add(addalldates);      
        
        datePanel= new JPanel();
        datePanel.setBounds(20,310,370, 91);
        datePanel.setLayout(null);
        datePanel.setBackground(new Color(242, 196, 142));
        allmiddele.add(datePanel);  
        
        long currentTimeMillis = System.currentTimeMillis();
        Date currentDate = new Date(currentTimeMillis);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String dateString = sdf.format(currentDate);
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String timeString = timeFormat.format(currentDate);
        
        booking_date = new JDateChooser();
        booking_date.setDate(currentDate);
        booking_date.setMinSelectableDate(currentDate);
        booking_date.getDateEditor().addPropertyChangeListener(e -> {
            if ("date".equals(e.getPropertyName())) {
                Date selectedDate = (Date) e.getNewValue();
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
                String dateString3 = sdf2.format(selectedDate);
            }
        });
        booking_date.setBounds(10,39,170,30);
        addalldates.add(booking_date);
        
        checkout_date = new JDateChooser();
        checkout_date.setDate(currentDate);
        checkout_date.setMinSelectableDate(currentDate);
        checkout_date.setForeground(Color.red);

        checkout_date.getDateEditor().addPropertyChangeListener(e -> {
            if ("date".equals(e.getPropertyName())) {
                Date selectedDate = (Date) e.getNewValue();
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
                String dateString3 = sdf2.format(selectedDate);
            }
        });
        checkout_date.setBounds(200,39,170,30);
        addalldates.add(checkout_date);
        
        bookingday_lael= new JLabel();
        bookingday_lael.setText("BOOKING DAY");
        bookingday_lael.setBounds(25,7,170,25);
        bookingday_lael.setFont(new Font("Verdana", Font.ITALIC, 13));
        addalldates.add(bookingday_lael);
        
        checkoutday_labeLabel= new JLabel();
        checkoutday_labeLabel.setText("CHECKOUT DAY");
        checkoutday_labeLabel.setBounds(217,7,170,25);
        checkoutday_labeLabel.setFont(new Font("Verdana", Font.ITALIC, 13));
        addalldates.add(checkoutday_labeLabel);
        
        Font fonttetxt = new Font("Pathway Gothic One", Font.PLAIN , 13);  
        
        contains_1= new JLabel();
        contains_1.setText("All bookings are subject to confirmation. Once you submit");
        contains_1.setBounds(30, 32,370, 20);
        contains_1.setFont(fonttetxt);
        contains_1.setForeground(Color.darkGray);
        datePanel.add(contains_1);
        
        contains_3= new JLabel();
        contains_3.setText("your booking request, we will review it and confirm your");
        contains_3.setBounds(30, 52,370, 20);
        contains_3.setFont(fonttetxt);
        contains_3.setForeground(Color.darkGray);
        datePanel.add(contains_3);
        
        contains_2= new JLabel();
        contains_2.setText("reservation via email.");
        contains_2.setBounds(30, 72,370, 20);
        contains_2.setFont(fonttetxt);
        contains_2.setForeground(Color.darkGray);
        datePanel.add(contains_2);
                
        try {
            File imageFile = new File("IMAGE/pawprint_1081290.png");
            BufferedImage restBackBtnImage = ImageIO.read(imageFile);
            JPanel star = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (restBackBtnImage != null) {
                        g.drawImage(restBackBtnImage, 0, 0, getWidth(), getHeight(), this);
                    }
                }
            };
            star.setBounds(3, 33,17, 17);
            star.setBackground(new Color(242, 196, 142));
            datePanel.add(star);
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        Font font4 = new Font("Segoe UI", Font.BOLD, 18);
        book_now= new JButton("BOOK NOW");
        book_now.setBounds(70, 420,227, 40);
        book_now.addActionListener(this);
        book_now.setBackground(new Color(142, 196, 210));
        book_now.setFont(font4);
        book_now.setBorder(new LineBorder(Color.black));
        book_now.setForeground(Color.DARK_GRAY);
        book_now.setFocusable(false);
        allmiddele.add(book_now);
        
		getuserdetails();
		search_all();
        
        table.getColumnModel().getColumn(0).setCellRenderer(new MultiLineTableCellRenderer());
        this.setVisible(true);
      
    }
    
    
    public void search_all(){
    	try {
    	    Class.forName("com.mysql.cj.jdbc.Driver");
    	    Connection connection = DriverManager.getConnection(url, username, password); 
    	    String selectQuery = "SELECT * FROM petcare_centers WHERE location = ? AND food = ? AND pet_food = ? AND pet_type=?  AND available='yes'";
    	    PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
    	    selectStatement.setString(1, location);
    	    selectStatement.setString(2, search_food_name);
    	    selectStatement.setString(3, search_petfood_yesorno);
    	    selectStatement.setString(4, user_petypeString);

    	    
    	    ResultSet resultSet = selectStatement.executeQuery();
    	    while(resultSet.next()) {
    	        String content = resultSet.getString("content"); 
    	        Object[] newRow = {content};
    	        model.addRow(newRow);
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
    public void getuserdetails() {
    	try {
     	    Class.forName("com.mysql.cj.jdbc.Driver");
     	    Connection connection = DriverManager.getConnection(url, username, password);
     	    String sqlString="SELECT * FROM  register WHERE user_name=?";
     	    PreparedStatement statement=connection.prepareStatement(sqlString);
     	    statement.setString(1, user_name);
     	    ResultSet resultSet= statement.executeQuery();
     	    while (resultSet.next()) {
         	    user_emailString=resultSet.getString("email");
         	    user_petypeString=resultSet.getString("pet_type");
         	    
			}
     	    	
    	}
    	catch (ClassNotFoundException e3) {
    		e3.printStackTrace();
    		
		}
    	catch (SQLException e4) {
    		e4.printStackTrace();

		}
    }
    
	public void actionPerformed(ActionEvent e) {
		try {
			
	         bookingDate = booking_date.getDate();
	        checkoutDate = checkout_date.getDate();
            if (checkoutDate.before(bookingDate)) {
                JOptionPane.showMessageDialog(Book_now.this,"Checkout date must be after booking date","Invalid Date", JOptionPane.ERROR_MESSAGE);
            }
            else {
	            insertdata();
				
           String to = user_emailString;
           String subject = "Booking Confirmation";
           String message = "Dear " + user_name + ",\r\n\r\n"
                   + "We are delighted to confirm that your booking has been successfully processed and secured. Your reservation is now confirmed, and we are eagerly anticipating your arrival.\r\n\r\n"
                   + "**Payment Details:**\r\n"
                   + "Amount: $ "+total+".00\r\n"
                   + "Transaction Status: Successful\r\n"
                   + "Transaction ID: "+center_name+"\r\n"
                   + "Booking Date: "+bookingDate+ " | Checkout Date: " +checkoutDate+"\r\n\r\n"
                   + "Your booking has been completed, ensuring that your reservation is fully secured up to your booking date. Should you have any questions or need assistance, please don't hesitate to contact our dedicated team. We are here to assist you every step of the way.\r\n\r\n"
                   + "Warm regards,\r\n"
                   + "John Doe\r\n"
                   + "Pet Care Service Representative\r\n"
                   + "Email: petcaresystem9@gmail.com\r\n"
                   + "Phone: +71737483\r\n\r\n"
                   + "P.S. Enjoy your stay with us!"; 
           send_email_thread(to, subject, message);
            }
		}
		
		catch (Exception e7) {
            e7.printStackTrace();
		}
	  }
	  public static void send_email_thread(String to, String subject, String message) {
	    Thread email_Thread = new Thread(new Runnable() {
	        @Override
	        public void run() {
	        	sendemil(to, subject, message);
	        }
	    });
	    email_Thread.start();
	  }
	public static void sendemil(  String to, String subject, String messages) {
	       final String sending_email_username = "petcaresystem9@gmail.com";
	       final String sending_email_password = "sclp zwpg kera pcut";
	  
	       Properties properties = new Properties();
	       properties.put("mail.smtp.auth", "true");
	       properties.put("mail.smtp.starttls.enable", "true");
	       properties.put("mail.smtp.host", "smtp.gmail.com");
	       properties.put("mail.smtp.port", "587");

	       Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
	           protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(sending_email_username, sending_email_password);
	           }
	       });

	       try {
	           Message message = new MimeMessage(session);
	           message.setFrom(new InternetAddress(sending_email_username));
	           message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
	           message.setSubject(subject);
	           message.setText(messages);
//	           message.setSentDate(new Date());
	           Transport.send(message);
	           
	           System.out.println("Email sent successfully.");
	       } catch (MessagingException e) {
	           e.printStackTrace();
	       }
	   }
    

	public  void insertdata()  {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
    	    Connection connection = DriverManager.getConnection(url, username, password);
    	    String ssql="SELECT * FROM petcare_centers WHERE content=?";
    	    PreparedStatement statement1= connection.prepareStatement(ssql);
    	    statement1.setString(1, content);
    	    
    	    ResultSet resultSet= statement1.executeQuery();
     	    while (resultSet.next()) {
         	    center_name=resultSet.getString("center_name");
         	    center_price=resultSet.getInt("day_price");
         	   
         	    
     	    }
            long diffInMillies = Math.abs(checkoutDate.getTime() - bookingDate.getTime());
            diff = diffInMillies / (24 * 60 * 60 * 1000);
     	    total=center_price*(diff+1);
     	    
    	    String sqlString="INSERT INTO booking (user_name,center_name,total_price,start_date,end_date) VALUES (?,?,?,?,?)";
    	    PreparedStatement statement=connection.prepareStatement(sqlString);
    	    statement.setString(1, user_name);
    	    statement.setString(2, center_name);
    	    statement.setLong(3,total);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            statement.setString(4, sdf.format(bookingDate));
            statement.setString(5, sdf.format(checkoutDate));


    	   int rowsAffected = statement.executeUpdate();

          if (rowsAffected > 0) {
              String insert_notifi = "INSERT INTO notification(content,current,username)VALUES (?,?,? )";
              PreparedStatement statement2 = connection.prepareStatement(insert_notifi);
                  statement2.setString(1,""+user_name+" your booking has been succesfull.total Amount: $"+total+".00 Transaction ID: "+center_name+".");
                  statement2.setString(2, "new");
                  statement2.setString(3, user_name);
                  statement2.executeUpdate();
                  JOptionPane.showMessageDialog(null, "Booking suceesfully added.");
                  Home homeWindow = new Home(user_name); 
                  homeWindow.searchnotifi();
                  Book_now.this.dispose();
                  
                  
          } else {
              JOptionPane.showMessageDialog(null, "Failed to insert data.");
          }
		}
		catch (SQLException e8) {
			e8.printStackTrace();
		}
		catch (ClassNotFoundException e9) {
			e9.printStackTrace();
		}
		catch (Exception e0) {
			e0.printStackTrace();
		}
		   
	}


class MultiLineTableCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JTextArea textArea = new JTextArea(value.toString());
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        table.setSelectionBackground(new Color(247, 240, 240));
        textArea.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
        textArea.setForeground(isSelected ? table.getSelectionForeground() : table.getForeground());
        textArea.setFont(new Font("Arial", Font.PLAIN, 15));
        textArea.setMargin(new Insets(3, 5, 10, 10));
        return textArea;
    }
}
	   
	   

}
