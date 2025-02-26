package account;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * depicts an account with a name, unique ID, and status.
 * @author Aditya Grover
 * @version 1.0
 * @since 1.0
 */

public class Account{

private String name;
private int id;
private static int nextID=1;
private AccountStatus status;

/**
     * constructs a new Account with a name
     *
     * @param name the name of the account 
     * @throws IllegalArgumentException if the name is empty
     * @since 1.0
     */

public Account(String name){
   if(name.length()==0) {
    throw new IllegalArgumentException("Name cant be empty");
   }
   this.name=name;
   this.id=nextID++;
   this.status=AccountStatus.Normal;
}

public Account(BufferedReader br) throws IOException {
        this.name = br.readLine();
        this.id = Integer.parseInt(br.readLine());
        nextID = id + 1; 
        this.status = AccountStatus.valueOf(br.readLine());
    }

public void save(BufferedWriter bw) throws IOException {
        bw.write(name + "\n");
        bw.write(id + "\n");
        bw.write(status.name() + "\n");
    }
 /**
     * sets the status of the account
     *
     * @param status the new status of the account
     * @since 1.0
     */
public void setStatus(AccountStatus status){
    this.status=status;
}

/**
     * checks if the account is muted
     *
     * @return true if the account is muted otherwise returns false
     * @since 1.0
     */

public boolean isMuted(){
    if(status!=AccountStatus.Normal)
        return true;
    else 
      return false;
}

/**
     * checks if the account is blocked.
     *
     * @return true if the account is blocked otherwise returns false
     * @since 1.0
     */
public boolean isBlocked(){
    if(status==AccountStatus.Blocked)
       return true;
    else 
       return false;
}

/**
     * returns the string representation of the account
     *
     * @return the account name with ID and status if not normal
     * @since 1.0
     */

public String toString(){
    if(status==AccountStatus.Normal)
      return name + " (" + id + ")";
    else
      return name + " (" + id + ") [" + status + "]";
}

}

