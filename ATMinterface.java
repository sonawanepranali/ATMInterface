package pranali;
import java.util.Scanner;
public class ATMInterface {
	
	public BankAccount bankAccount;
	float balance=100000f;
	int transaction=0;
	String transactionHistory="";
	String name;
	String username;
	String password;
	String accountNo;
	
	
	
	public void register() {
		Scanner sc= new Scanner(System.in);
		System.out.println("\nEnter your name:");
		this.name=sc.nextLine();
		System.out.println("\nEnter your username:");
		this.username=sc.nextLine();
		System.out.println("\nEnter your Password:");
		this.password=sc.nextLine();
		System.out.println("\nEnter your Account name:");
		this.accountNo=sc.nextLine();
		System.out.println("\nRegistration completed ..Kindly login:");
		
	}
	
	public boolean login() {
		boolean isLogin=false;
		Scanner sc= new Scanner(System.in);
		while(!isLogin) {
			System.out.print("Enter your username:");
			String username = sc.nextLine();
			 if(username.equals(username)) {
				 while(!isLogin) {
				 System.out.print("Enter your password:");
				 String password = sc.nextLine();
			     if(password.equals(password)) {
				 System.out.println("\nLogin Successfully!!");
				 isLogin=true;
			}
			else
			{
				System.out.println("\nIncorrect Password");
			}
		}
		
	  }
	 else
	 {
		 System.out.println("\nUsername not found");
	  }
	}
	 return isLogin;
  }
	
	
	public ATMInterface (BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	public void  withdraw() {
		System.out.println("Enter the amount you want withdraw:");
		Scanner sc= new Scanner(System.in);
		int amount=sc.nextInt();
		
		withdraw(amount);
	}
		
	public void  deposit() {
		System.out.println("Enter the amount you want deposit:");
		Scanner sc= new Scanner(System.in);
		 int amount=sc.nextInt();
		 
         try {
			 
			 if(balance <= 100000f) {
				 
					 transaction++;
					 balance +=amount;
					 System.out.println("\nsuccessfully Deposited");
					 String str = amount +"Rs transfered to \n";
					 transactionHistory = transactionHistory.concat(str);
					 
				 }
				 else
				 {
					 System.out.println("\n Sorry------- list is 100000.00");
				 }
         }
         catch(Exception e) {
        	 
         }
		deposit(amount);
	}
		
	 private void withdraw(int amount) {
    	 if(bankAccount.getBalance()<amount) {
    		System.out.println("Sufficient funds"); 
    	 }else {
    		 bankAccount.withdraw(amount);
    		 System.out.println("Amount withdraw successfully :"+amount);
    	 }
	 }

	 
	 private void deposit(int amount) {
		 bankAccount.deposit(amount);
		 System.out.println("Amount deposit successfully :"+amount);
	 }
	 
	 private void checkBalance() {
		
		System.out.println("Your Account balance is: "+bankAccount.getBalance());
	 }
	 
	 
	 public void transfer() {
		 Scanner sc= new Scanner(System.in);
		 System.out.println("Enter Receipent's name:");
		 String receipent=sc.nextLine();
		 System.out.println("Enter amount to transfer");
		 float amount=sc.nextFloat();
		 
		 
		 try {
			 
			 if(balance >=amount) {
				 if(amount <=50000f) {
					 transaction++;
					 balance -=amount;
					 System.out.println("\nsuccessfully Transfered to "+receipent);
					 String str = amount +"Rs transfered to "+ receipent +"\n";
					 transactionHistory = transactionHistory.concat(str);
					 
				 }
				 else
				 {
					 System.out.println("\n Sorry------- list is 5000.00");
				 }
				 
			  }else {
				  System.out.println("\nInsufficient Balance");
				 
			 }
		   }
		 catch(Exception e) {
			 
		 }
	 }
	 
	 public void transactionHistory() {
		 if(transaction ==0) {
			 System.out.println("\nEmpty");
		 }
		 else {
			 System.out.println("\n"+transactionHistory);
		 }
	 }
	 

 

  
	  
	public static void main(String[] args) {
       
    Scanner sc= new Scanner(System.in);	
	System.out.println("\n**********WELCOME TO SBI ATM SYSTEM*********");
	System.out.println("1.Register\n2.Exit");
	System.out.println("Enter your choice:");
	int choice = sc.nextInt();
		
		
	if(choice==1) {
		 BankAccount bankAccount=new BankAccount(1000);
		 ATMInterface atm=new ATMInterface(bankAccount);
		 atm.register();
		 
		 while(true) {
			 System.out.println("\n1.login \n2.Exit");
			 System.out.println("Enter your choice:");
			 int ch=sc.nextInt();
			 if(ch == 1) {
				 if(atm.login()) {
					 System.out.println("\n\n*******WELCOME BACK "+atm.name+"********");
					 boolean isFinished = false;
					 while(!isFinished) {
						 
						 System.out.println("ATM Menu:");
				    	 System.out.println("1.withdraw");
				    	 System.out.println("2.Deposit");
				    	 System.out.println("3.check Balance");
				    	 System.out.println("4.Transaction History");
				    	 System.out.println("5.Transfer");
				    	 System.out.println("6.Exit");
				    	 
				    	 System.out.println("Please Enter your choice:");
				    	 int c = sc.nextInt(7);
				    	 
				    	 switch(c) {
				    	 case 1:
				    		 atm.withdraw();
				    		 break;
				    		 
				    	 case 2:
				    		 atm.deposit();
				    		 break;
				    		 
				    	 case 3:
				    		 atm.checkBalance();
				    		 break;
				    		 
				    	 case 4:
				    		 atm.transactionHistory();
				    		 break;	 
				    		 
				    	 case 5:
				    		 atm.transfer();
				    		 break;
				    		 
				    	 case 6:
				    	 System.out.println("Exit");
				    		 break;
				    		 
				    	 default:
				    		 System.out.println("Invalid choice");
						 
					 }
				 }
			 }
		 }
		   else {
			   System.exit(0);
		}
	}
 }
else {
	 System.exit(0);
	}
	
	}
}	

    
     
     
	



