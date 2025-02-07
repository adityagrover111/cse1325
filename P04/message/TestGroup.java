package message;

public class TestGroup{

    public static void main(String args[]){
      Group group= new Group("microwave fan club");
      System.out.println("Running tests for:  "+ group.toString());//Test the constructor and toString together

      if(!group.isActive())
        throw new IllegalArgumentException("FAILED:GROUP NOT ACTIVE");//Verify that the newly constructed group is active by default.

      group.disable();

      if(group.isActive())
        throw new IllegalArgumentException("FAILED:GROUP DID NOT GET DISABLES"); //Verify that the disable method makes the Group inactive

      if(!group.toString().contains("[inactive]"))
         throw new IllegalArgumentException("FAILED:GROUP DOESNT PRINT inactive");//Verify that an inactive group reports " [inactive]" as part of its toString method

      group.enable();

      if(!group.isActive())
         throw new IllegalArgumentException("FAILED:GROUP DIDNT GET ENABLED");//Verify that method enable makes an inactive Group active again.

      System.out.println("All tests passed successfully for: "+ group.toString());
    }
}