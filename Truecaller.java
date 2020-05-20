package truecaller;

/**
 *
 * @author Dell
 */
    

import truecaller.Phonebook;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Truecaller {
    static HashMap<String, String> UsersHashMap = new HashMap<>();
static ArrayList<Phonebook> ContactsList= new ArrayList<Phonebook>();
static ArrayList<User> Users = new ArrayList<User>();
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
   Phonebook student = new Phonebook();
        student.load();
       // DashboardGUI dashboardGUI = new DashboardGUI();
    SearchGUI gUI= new SearchGUI();

    }

    }
      

