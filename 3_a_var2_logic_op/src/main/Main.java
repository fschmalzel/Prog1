package main;

public class Main {
	
	public static void main(String[] args) {
		
		boolean op1 = false, op2 = false;
		
		System.out.printf("  %2s   ║ %-5b │ %-5b%n", "&&", op2, !op2);
		System.out.println("═══════╬═══════╪═══════");
		System.out.printf(" %-5b ║ %-5b │ %-5b%n", op1, op1 && op2, op1 && !op2);
		op1 = !op1;
		System.out.printf(" %-5b ║ %-5b │ %-5b%n%n", op1, op1 && op2, op1 && !op2);
		
		op1 = false;
		System.out.printf("  %2s   ║ %-5b │ %-5b%n", "&", op2, !op2);
		System.out.println("═══════╬═══════╪═══════");
		System.out.printf(" %-5b ║ %-5b │ %-5b%n", op1, op1 & op2, op1 & !op2);
		op1 = !op1;
		System.out.printf(" %-5b ║ %-5b │ %-5b%n%n", op1, op1 & op2, op1 & !op2);
		
		op1 = false;
		System.out.printf("  %2s   ║ %-5b │ %-5b%n", "||", op2, !op2);
		System.out.println("═══════╬═══════╪═══════");
		System.out.printf(" %-5b ║ %-5b │ %-5b%n", op1, op1 || op2, op1 || !op2);
		op1 = !op1;
		System.out.printf(" %-5b ║ %-5b │ %-5b%n%n", op1, op1 || op2, op1 || !op2);
		
		op1 = false;
		System.out.printf("  %2s   ║ %-5b │ %-5b%n", "|", op2, !op2);
		System.out.println("═══════╬═══════╪═══════");
		System.out.printf(" %-5b ║ %-5b │ %-5b%n", op1, op1 | op2, op1 | !op2);
		op1 = !op1;
		System.out.printf(" %-5b ║ %-5b │ %-5b%n%n", op1, op1 | op2, op1 | !op2);
		
		op1 = false;
		System.out.printf("  %2s   ║ %-5b │ %-5b%n", "^", op2, !op2);
		System.out.println("═══════╬═══════╪═══════");
		System.out.printf(" %-5b ║ %-5b │ %-5b%n", op1, op1 ^ op2, op1 ^ !op2);
		op1 = !op1;
		System.out.printf(" %-5b ║ %-5b │ %-5b%n%n", op1, op1 ^ op2, op1 ^ !op2);
		
	}
	
	
	
    
}
