package truecaller;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Phonebook implements iFile {

    
    private String filepath="D:\\MIU\\sophmore year\\spring 2019\\Algorithm\\Contacts.bin";
    private String firstname;
    private String lastname;
    private String email;
    private String phonenumber;
   int index;

    Phonebook(String text, String text0, String text1) {
        setPhonenumber(text);
        setFirstname(text0);
        setEmail(text1);
    }

  
    public String getFirstname() {
        return firstname;
    }

    @Override
   
       public boolean save() {
        try {
            ObjectOutputStream fileOutputStream = new ObjectOutputStream(new FileOutputStream(filepath, true));
            fileOutputStream.writeObject(Truecaller.ContactsList);
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
    }


    public boolean load() {
         
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filepath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            DashboardGUI.contactsArrayList = (ArrayList<Phonebook>) objectInputStream.readObject();
            objectInputStream.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        } catch (ClassNotFoundException ex) {
            return false;
        }
    }
    
   

    public Phonebook() {
    }

    public void view(){
          
          load(); 
             String j;
              for (Phonebook name : Truecaller.ContactsList) {
       System.out.println(name.getFirstname() + " " +name.getLastname()); 
               }    

    }
    public void alphabeticSort() {
        int i = 1;
        for (i = 1; i < Truecaller.ContactsList.size(); i++) {
            String key = Truecaller.ContactsList.get(i).getFirstname();
            Phonebook key2=Truecaller.ContactsList.get(i);
int j = i - 1;
        
            while (j >= 0 && key.compareTo(Truecaller.ContactsList.get(j).getFirstname()) < 0) {
                Truecaller.ContactsList.set(j + 1, Truecaller.ContactsList.get(j));

                j = j - 1;
            }
            Truecaller.ContactsList.set(j + 1, Truecaller.ContactsList.get(i));
        }
    }

    public boolean addContactpublic(String firstname, String lastname, String email, String phonenumber) {

        load();
        Phonebook contact = new Phonebook();
        contact.email=email;
        contact.firstname = firstname;
        contact.lastname = lastname;
        contact.phonenumber = phonenumber;
        if (!checkPublic(contact)) {
            Truecaller.ContactsList.add(contact);
            save();
            return true;
        }
        return false;
    }

  

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonenumber() {
        
        return phonenumber;
    }

    public boolean setFirstname(String firstname) {
        if(firstname.isEmpty())
            return false;
        this.firstname = firstname;
        return true;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean setPhonenumber(String phonenumber) {
        if(phonenumber.length()==11){
        this.phonenumber = phonenumber;return true;
        }
        return false;
    }

    public  boolean editContact(String name,User u1) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        load();
        u1.load();
        Phonebook b=new Phonebook();
        b=SearchContact(u1.getPcl(), name, 0, u1.getPcl().size());
        if( b!=null){

       
        u1.getPcl().remove(b);

        
            System.out.println(" please re enter your contact data ");
            Scanner in = new Scanner(System.in);
            System.out.println("First Name: ");
            String fn = in.nextLine();
            System.out.println("Last name:");
            String ln = in.nextLine();
            System.out.println("Email: ");
            String em = in.nextLine();
            System.out.println("Number: ");
            String no = in.nextLine();
            b.firstname = fn;
            b.lastname = ln;
            b.email = em;
            b.phonenumber = no;

            u1.getPcl().add(b);

            u1.alphabeticSort();
            u1.save();
            save();

            return true;
        }  
        return false;
         
    }

    

    private boolean checkLocal(Phonebook contact) {
        contact.load();
        for (Phonebook c : Truecaller.ContactsList) {
            if (c == contact) {
                return true;
            }

        }
        return false;

    }

    private boolean checkPublic(Phonebook c) {

        c.load();
        for (Iterator<Phonebook> it = Truecaller.ContactsList.iterator(); it.hasNext();) {
            c = it.next();
            if (c.phonenumber == c.phonenumber) {
                if (c.email.isEmpty()) {
                    c.email.equals(c.email);
                }
                if (c.phonenumber.isEmpty()) {
                    c.phonenumber.equals(c.phonenumber);
                }
                return true;
            }
        }

        return false;

    }

    public Phonebook SearchContact(ArrayList<Phonebook> pcl, String x, int left, int right) {
       

        if (right >= left) {
            int mid = left + (right - left) / 2;

            if (pcl.get(mid).getFirstname().equals(x)) {
                return pcl.get(mid);
            } else if (Phonebook.compare(x, pcl.get(mid).getFirstname()) == 1) {
                return SearchContact(pcl, x, left, mid - 1);
            } else {
                return SearchContact(pcl, x, mid + 1, right);
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
    
     public void viewP(){
     load();
      for(Phonebook p:Truecaller.ContactsList){
         
         System.out.println(p.getFirstname()+" "+p.getLastname()+"   "+p.getPhonenumber());
      }
     
     }

    
}