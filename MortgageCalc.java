import java.util.Scanner;
import java.text.NumberFormat;

public class MortgageCalc{ 

public static void main(String[] args) {
   mortgageCalc(); 


    
}

public static void mortgageCalc (){
    int MONTHS_OF_YEAR = 12;
    int PERCENT = 100;
    int loanAmount = 0;
    float interestRate = 0;
    int loanPeriod = 0;
    Scanner scanner = new Scanner(System.in);

    while(true) {
        System.out.print("How much would you like to borrow? (£10000 - £1000000) : ");
        loanAmount = scanner.nextInt();
        if(loanAmount >= 10000 && loanAmount <=1_000_000){
            break;
        }
        System.out.println("Enter a value between £10000 - £1000000");
    }

    while(true) {
        System.out.print("What is your interest rate? (0.1% - 10%) : ");
        interestRate = scanner.nextFloat();
        if(interestRate >= 0.1 && interestRate <= 10){
            break;
        }
        System.out.println("Enter a value between 0.1 and 10%" );
    }

    while(true) {
        System.out.print("How many years do you want spread the payments over? (1 - 30 years) : ");
        loanPeriod = scanner.nextInt();
        if(loanPeriod >= 1 && loanPeriod <= 30){
            break;
        }
        System.out.println("Enter a value between 1 and 30 years");
    }

    int numberOfPayments = loanPeriod * MONTHS_OF_YEAR;

    double monthlyIntRate = interestRate / PERCENT /MONTHS_OF_YEAR;

    double mortgage = loanAmount * ((monthlyIntRate * Math.pow((1+ monthlyIntRate), numberOfPayments)) / (Math.pow(1 + monthlyIntRate, numberOfPayments) -1));
    double totalAmout = mortgage * numberOfPayments;

    NumberFormat currency = NumberFormat.getCurrencyInstance();
    String resultDollars = currency.format(mortgage);
    String resultTotal = currency.format(totalAmout);
    System.out.println("Your monthly payments will be: " + resultDollars);
    System.out.println("The total amount you will pay is: " + resultTotal);

 
}

}