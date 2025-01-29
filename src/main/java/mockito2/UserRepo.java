package mockito2;

public class UserRepo {

    //DB ile ilgili işlemler
    //idsi verilen userı bulma
    public String findUsernameById(int userId){
        if (userId==1){
            return "Furkan";
        } else if (userId==2) {
            return "Tuğçe";
        } else if (userId==3) {
            return "Tayfun";
        }else {
            return null;
        }
    }



}
