package Final_project_mvc;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Room_book_contoll {
	private Room_book_view view;
    private Room_book_model model;

    public Room_book_contoll(Room_book_view view, Room_book_model model) {
        this.view = view;
        this.model = model;
        populateComboBox();
        this.view.addsearchvalue(new serchvalue());   
        this.view.fishimagelistner(new fishimagelistner());
        this.view.meatimagelistner(new meatimagelistner());
        this.view.pokeimagelistner(new pokeimagelistner());
        this.view.pet_foodavailable_buttJButtonlistner(new pet_foodavailable_buttJButtonlistner());
        this.view.pet_foodunavailable_buttJButtonlistner( new pet_foodunavailable_buttJButtonlistner());
    }
    class serchvalue implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String user_name = view.login_Username();
            String search_food_name = view.getSelectedValue();
            String location = view.getlocation();
            String search_petfood_yesorno=view.getselecetyesno();
            
            if(search_food_name == null || search_petfood_yesorno == null) {
                JOptionPane.showMessageDialog(view, "select all the sections first", "Error", JOptionPane.ERROR_MESSAGE);
                    
            }
            else {
                new Book_now(user_name,location,search_food_name,search_petfood_yesorno);
                view.dispose();
			}
            
            } 
        }
    class pet_foodavailable_buttJButtonlistner implements ActionListener{
        public void actionPerformed(ActionEvent e) {
		view.pet_foodavailable.doClick();
		view.pet_foodavailable_buttJButton.setBackground(Color.black);
		view.pet_foodunavailable_buttJButton.setBackground(Color.white);
        }
    }
    class pet_foodunavailable_buttJButtonlistner implements ActionListener{
        public void actionPerformed(ActionEvent e) {
		view.pet_foodunavailble.doClick();
		view.pet_foodunavailable_buttJButton.setBackground(Color.black);
		view.pet_foodavailable_buttJButton.setBackground(Color.white);
        }
    }
    public void populateComboBox() {
        ResultSet resultSet = model.getUserProfileResultSet(); 

        try {
       	 ArrayList<String> uniqueLocations = new ArrayList<>();

            while (resultSet.next()) {
            	String location=resultSet.getString("location");
	        	if(!uniqueLocations.contains(location))
	        	uniqueLocations.add(location);
            }

            for (String location1 : uniqueLocations) {
                view.addComboBoxItem(location1); 

            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error occurred while populating combo box: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error occurred while closing ResultSet: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    class fishimagelistner implements MouseListener {
        public void mouseClicked(MouseEvent e) { 
           view.fish.doClick(); 
           view.fish_image.setBounds(40,40,65, 65);
           view.meat_image.setBounds(136,45,45,45); 
           view.poke_image.setBounds(240,45,45,45);        }
        public void mousePressed(MouseEvent e) {
        	
        }
        public void mouseReleased(MouseEvent e) {
        	
        }
        public void mouseEntered(MouseEvent e) {
        	
        }
        public void mouseExited(MouseEvent e) {
        	
        }
    }
    
    class meatimagelistner implements MouseListener {
        public void mouseClicked(MouseEvent e) { 
           view.meat.doClick(); 
           view.meat_image.setBounds(136,40,65,65);
           view.poke_image.setBounds(240,45,45,45);
           view.fish_image.setBounds(40,45,45, 45);        
        }
        public void mousePressed(MouseEvent e) {
        	
        }
        public void mouseReleased(MouseEvent e) {
        	
        }
        public void mouseEntered(MouseEvent e) {
        	
        }
        public void mouseExited(MouseEvent e) {
        	
        }
    }
    class pokeimagelistner implements MouseListener {
        public void mouseClicked(MouseEvent e) { 
          view.pokeButton.doClick();
          view.meat_image.setBounds(140,45,40,40);
          view.poke_image.setBounds(240,40,65,65);
          view.fish_image.setBounds(40,45,45, 45);        
        }
        public void mousePressed(MouseEvent e) {
        	
        }
        public void mouseReleased(MouseEvent e) {
        	
        }
        public void mouseEntered(MouseEvent e) {
        	
        }
        public void mouseExited(MouseEvent e) {
        	
        }
    }
    
}

