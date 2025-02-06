package message;
public class Group{
    private String name;
    private boolean active;
    
    public Group(String name){
        if( name ==null || name.equals("")){
          throw new IllegalArgumentException("name cannot be empty");
        }
        this.name=name;
        this.active=true;
    }

    public boolean isActive(){
        return active;
    }

    public void disable(){
        active=false;
    }

    public void enable(){
        active=true;
    }

    @Override
    public String toString(){
        if(active== true)
          return name;
        else
          return name +" [inactive]";
    }
}