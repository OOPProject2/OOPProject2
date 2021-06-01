import java.io.File;
import java.util.ArrayList;

public class Manager {
    private final ArrayList<User> users;
    File userFile;

    public Manager() {
        users=new ArrayList<>();
        userFile=new File("Users.txt");
        User.readUsers(userFile,users);
    }

    public void creatAccountForUser(String userName,String password){
        User user=new User(userName,password,0,200);
        users.add(user);
        user.appendToFile(userFile);
    }
    public boolean foundUsername(String userName){
        for (User user : users) {
            if(userName.equals(user.getUsername()))
                return true;
        }
        return false;
    }
    public boolean foundPassword(String password,String userName){
        for (User user : users) {
            if(userName.equals(user.getUsername())){
                if(password.equals(user.getPassword())){
                    return true;
                }
            }
        }
        return false;
    }
}
