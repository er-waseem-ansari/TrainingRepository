import java.util.ArrayList;
import com.hexaware.dao.ServiceProviderImpl;
import com.hexaware.dto.Bank;
import com.hexaware.dto.BankAccount;
import com.hexaware.myexceptions.AccountNumberInvalidException;
import com.hexaware.myexceptions.InsufficientFundsException;
import com.hexaware.myexceptions.NegativeAmountException;

public class Main {

    public static void main(String[] args) {
        try {

            BankAccount obj1 = new BankAccount("Sachin", "Current", 80000.50);
            BankAccount obj2 = new BankAccount("Nisha", "Savings", 20000.50);
            BankAccount obj3 = new BankAccount("Roshid", "Current", 35000.50);

            ArrayList<BankAccount> myList = new ArrayList<>();
            myList.add(obj1);
            myList.add(obj2);
            myList.add(obj3);

            Bank myBank = new Bank("ICICI", myList);

            System.out.println(myBank);

            ServiceProviderImpl myServiceObj = new ServiceProviderImpl(myBank);

            System.out.println("Balance of account 1111 : " + myServiceObj.checkBalance(1111));
            System.out.println("Status of deposit: " + myServiceObj.deposit(1111, 5000.50));
            System.out.println("Balance of account 1111 : " + myServiceObj.checkBalance(1111));
            System.out.println("Status of deposit: " + myServiceObj.withdraw(1112, 5000.50));
            System.out.println("Balance of account 1112: " + myServiceObj.checkBalance(1112));

            System.out.println("new account status " + myServiceObj.createAccount(new BankAccount("zaheer", "Savings", 10000.0)));

            System.out.println(myBank);

            System.out.println("remove account status " + myServiceObj.removeAccount(1111));

            System.out.println(myBank);
        } catch (AccountNumberInvalidException e) {
            e.printStackTrace();
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        } catch (NegativeAmountException e) {
            e.printStackTrace();
        }
    }
}