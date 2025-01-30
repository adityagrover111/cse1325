public class Account{

private String name;
private int id;
private static int nextID;
private AccountStatus status;

public Account(String name){
   if(name.length()==0) {
    throw new IllegalArgumentException("Name cant be empty");
   }
   this.name=name;
   this.id=nextID++;
   this.status=AccountStatus.Normal;
}

public void setStatus(AccountStatus status){
    this.status=status;
}

public boolean isMuted(){
    if(status!=AccountStatus.Normal)
        return true;
    else 
      return false;
}

public boolean isBlocked(){
    if(status==AccountStatus.Blocked)
       return true;
    else 
       return false;
}

}

