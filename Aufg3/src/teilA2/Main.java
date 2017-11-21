package teilA2;

public class Main {
	
	public static void main(String[] args) {
		
		boolean op1 = false, op2 = false;
		// Das logische Und ist nur wahr wenn beide Operanden auch wahr sind.
		System.out.printf("  %2s   ║ %-5b │ %-5b%n", "&&", op2, !op2);
		System.out.println("═══════╬═══════╪═══════");
		System.out.printf(" %-5b ║ %-5b │ %-5b%n", op1, op1 && op2, op1 && !op2);
		op1 = !op1;
		System.out.printf(" %-5b ║ %-5b │ %-5b%n%n", op1, op1 && op2, op1 && !op2);
		
		op1 = false;
		// Das bitweise Und ist an einer Stelle 1, wenn beide Operanden an der jeweiligen Stelle 1 sind.
		// Kein Unterschied zum logischen Und bei Booleans da 1 = wahr; 0 = falsch und
        // Booleans nur 1 Stelle haben
		System.out.printf("  %2s   ║ %-5b │ %-5b%n", "&", op2, !op2);
        System.out.println("═══════╬═══════╪═══════");
		System.out.printf(" %-5b ║ %-5b │ %-5b%n", op1, op1 & op2, op1 & !op2);
		op1 = !op1;
		System.out.printf(" %-5b ║ %-5b │ %-5b%n%n", op1, op1 & op2, op1 & !op2);
		
		op1 = false;
		// Das logische Oder ist dann wahr, wenn einer der Operanden wahr ist
		System.out.printf("  %2s   ║ %-5b │ %-5b%n", "||", op2, !op2);
        System.out.println("═══════╬═══════╪═══════");
		System.out.printf(" %-5b ║ %-5b │ %-5b%n", op1, op1 || op2, op1 || !op2);
		op1 = !op1;
		System.out.printf(" %-5b ║ %-5b │ %-5b%n%n", op1, op1 || op2, op1 || !op2);
		
		op1 = false;
		// Das bitweise Oder ist an einer Stelle 1, wenn ein Operand an der jeweiligen Stelle 1 ist.
		// Kein Unterschied zum logischen Oder bei Booleans da 1 = wahr; 0 = falsch und
		// Booleans nur 1 Stelle haben
		System.out.printf("  %2s   ║ %-5b │ %-5b%n", "|", op2, !op2);
        System.out.println("═══════╬═══════╪═══════");
		System.out.printf(" %-5b ║ %-5b │ %-5b%n", op1, op1 | op2, op1 | !op2);
		op1 = !op1;
		System.out.printf(" %-5b ║ %-5b │ %-5b%n%n", op1, op1 | op2, op1 | !op2);
		
		op1 = false;
		// Das bitweise XOR ist an einer Stelle 1, wenn nur ein Operand an der jeweiligen Stelle 1 ist.
		System.out.printf("  %2s   ║ %-5b │ %-5b%n", "^", op2, !op2);
        System.out.println("═══════╬═══════╪═══════");
		System.out.printf(" %-5b ║ %-5b │ %-5b%n", op1, op1 ^ op2, op1 ^ !op2);
		op1 = !op1;
		System.out.printf(" %-5b ║ %-5b │ %-5b%n%n", op1, op1 ^ op2, op1 ^ !op2);
		
	}
	
	
	
    
}
