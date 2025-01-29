package mockito1;

public class PaymentManager {

    //yapılan ödemenin statusünü gösteren bir method
    public String getPaymentStatus(int paymentId){
        if (paymentId==100){
            return "SUCCESS ";//boşluk bıraktık test gecmedi şimdi.
        } else if (paymentId==101) {
            return "FAILURE";
        }else {
            return "UNKNOWN";
        }


    }



}
