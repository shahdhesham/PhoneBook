package truecaller;

import java.io.*;
import java.io.Serializable;
import java.util.*;
import javax.swing.*;

public class User extends JFrame implements Serializable, iFile {

    private String filePath = "C:\\Users\\Rawan Khaled\\Desktop\\UsersArray.bin";
     private String filePath2 = "C:\\Users\\Rawan Khaled\\Desktop\\UsersHash.bin";
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private String phonenumber;
    public int index;
    ArrayList<Phonebook> pcl = new ArrayList<Phonebook>();
    
     
    public String getFirstname() {
        return firstname;
    }
    public boolean setFirstname(String firstname) {
        if(!firstname.isEmpty()){
        this.firstname = firstname;
        return true;}
        return false;
    }
     public boolean setLasttname(String lastname) {
        if(!lastname.isEmpty()){
        this.lastname = lastname;
        return true;}
        return false;
    }
          
    public String getLasttname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if(email.length()>0&&email.contains("@")){
        this.email = email;
        return true;}
        return false;
    }

    public String getUsername() {
        return username;
    }

    public boolean setUsername(String username) {
        if(username.length()>=5){
        this.username = username;return true;}
        return false;
    }

    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        if(password.length()>=4){
        this.password = password;return true;}return false;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public boolean setPhonenumber(String phonenumber) {
        if(phonenumber.length()==11){
        this.phonenumber = phonenumber;return true;}return false;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex() {
        
        this.index = Truecaller.Users.size();
    }

    public String getLastname() {
        return lastname;
    }
    
    
    
  
    
   public boolean SignUp(String username,String password,String firstname,String lastname,String email,String phonenumber){
       
    load(); 
   if(this.setEmail(email)&&this.setFirstname(firstname)&&this.setLasttname(lastname)&&this.setPassword(password)&&this.setPhonenumber(phonenumber)&&this.setUsername(username)){
    for(String name:Truecaller.UsersHashMap.keySet()){
            if (name.equals(username)){
                return false;
            }
    } 
       setIndex();
          Truecaller.UsersHashMap.put(password, username);
          Truecaller.Users.add(this);
         Phonebook p1=new Phonebook();
         p1.addContactpublic(firstname, lastname, email, phonenumber);
           alphabeticSort();
       
    return true;}
   return false;
}
    public boolean Login(String username, String password) throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream fileInputStream = new ObjectInputStream(new FileInputStream(filePath2));
        Truecaller.UsersHashMap = (HashMap<String, String>) fileInputStream.readObject();
load();
        for (Map.Entry<String, String> entry : Truecaller.UsersHashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key.equals(username) && password.equals(value)) {
              for(User u1:Truecaller.Users){
              if(u1.username.equals(username))
                  setFirstname(u1.getFirstname());
              setLastname(u1.getLastname());
              setEmail(u1.getEmail());
              setPhonenumber(u1.getPhonenumber());
              index=u1.pcl.indexOf(u1);
              for(Phonebook p:u1.pcl){
              pcl.add(p);
              }
              
              }
                return true;
            }
        }
        return false;
    }

    


    @Override
    public boolean save() {
        try {
            Truecaller.Users.set(index, this);
            ObjectOutputStream fileOutputStream = new ObjectOutputStream(new FileOutputStream(filePath, true));
            ObjectOutputStream fileOutputStream2 = new ObjectOutputStream(new FileOutputStream(filePath2, true));
            fileOutputStream2.writeObject(Truecaller.UsersHashMap);
            fileOutputStream.writeObject(Truecaller.Users);
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
    }

    @Override
    public boolean load() {

        try {
            ObjectInputStream fileInputStream = new ObjectInputStream(new FileInputStream(filePath));
            ObjectInputStream fileInputStream2 = new ObjectInputStream(new FileInputStream(filePath2));
            Truecaller.UsersHashMap = (HashMap<String, String>) fileInputStream2.readObject();
            Truecaller.Users = (ArrayList<User>) fileInputStream.readObject();
           
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        } catch (ClassNotFoundException ex) {
            return false;
        }
    }
    
    public void alphabeticSort() {
       int n=pcl.size();
        
        for (int i = 1; i < n; i++) {
            String key = pcl.get(i).getFirstname();
            Phonebook key2=pcl.get(i);
int j = i - 1;
            while (j >= 0 && key.compareTo(pcl.get(j).getFirstname()) < 0) {
                pcl.set(j + 1, pcl.get(j));

                j = j - 1;
            }
            pcl.set(j + 1, key2);
        }
    }

   public Boolean editUser ( )throws FileNotFoundException, IOException, ClassNotFoundException 
   {

                
        {
         Truecaller.Users.remove(this);

            System.out.println("Please re enter your contact data ");
            Scanner in = new Scanner(System.in);
            System.out.println("First Name: ");
            String fn = in.nextLine();
            System.out.println("Last name:");
            String ln = in.nextLine();
            System.out.println("Email: ");
            String em = in.nextLine();
            System.out.println("Number: ");
            String no = in.nextLine();
            this.firstname = fn;
            this.lastname = ln;
            this.email = em;
            this.phonenumber = no;
            
            Truecaller.Users.add(this);
            alphabeticSort();
       
        
            return true;
        }
 
 }
    

    public   ArrayList<Phonebook> getPcl() {
        return pcl;
    }

  

    private boolean checkLocal(Phonebook u1) {
        u1.load();
        for (Phonebook u : this.pcl) {
            if (u.getPhonenumber() == u1.getPhonenumber()) {
                return true;
            }

        }
        return false;

    }

    

    public User SearchUser(ArrayList<User> Users, String x, int left, int right) {
    
        right = pcl.size() - 1;
        left = 0;

        if (right >= left) {
            int mid = left + (right - left) / 2;

            if (pcl.get(mid).getFirstname().equals(x)) {
                return Users.get(mid);
            } else if (User.compare(x, Users.get(mid).getFirstname()) == 1) {
                return SearchUser(Users, x, left, mid - 1);
            } else {
                return SearchUser(Users, x, mid + 1, right);
            }
        }
        return null;

    }

    private static int compare(String x, String y) {
        for (int i = 0; i < x.length(); i++) {
            if (y.charAt(i) > x.charAt(i)) {
                return 1;
            } else if (y.charAt(i) < x.charAt(i)) {
                return 0;
            }

        }
        return -1;

    }
     public void addContactlocal(String firstname, String lastname, String email, String phonenumber) {

        Phonebook contact = new Phonebook();
        contact.load();
        contact.setEmail(email);
        contact.setFirstname(firstname);
        contact.setLastname(lastname);
        contact.setPhonenumber(phonenumber);
       
             pcl.add(contact);
             alphabeticSort();
           
           contact.save();
       
            
        }

    
     public void viewPcl(){
       
     for(Phonebook p:this.getPcl()){
         
         System.out.println(p.getFirstname()+" "+p.getLastname()+"   "+p.getPhonenumber());
     }}

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

   
     
}
     


