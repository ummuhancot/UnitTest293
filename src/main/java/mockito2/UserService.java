package mockito2;

public class UserService {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public String getUser(int id){
        String name = userRepo.findUsernameById(id);
        if (name==null){
            throw new RuntimeException("User not found!!");
        }
        return "Dear "+name;
    }


}
