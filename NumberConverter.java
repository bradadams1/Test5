package NC;

public class NumberConverter {
	public static void main(String[] args) {
		char c = 'f';
		System.out.println(hexDigitToDecimal(c));
		System.out.println(15*Math.pow(16, 3) + 15*Math.pow(16, 2) + 15*16 + 15);
		System.out.println(Math.pow(2, 0));
		String s ="2d9f";
		System.out.println(s + " is " + hexToDecimal(s));
		int d = 156;
		System.out.println(decimalToBinary(d));
		String t = "10110";
		System.out.println(binaryToHex(t));
		System.out.println(decimalToOctal(347));
		System.out.println(binaryToDecimal(10101110));

	}
	
	
	public static int hexDigitToDecimal(char hex){
		if (hex >= '0' && hex <= '9')
			return (int)(hex - '0');
		if (hex >= 'A' && hex <='F')
			return (int)(hex - 'A') + 10;
		if (hex >='a' && hex <='f')
			return (int)(hex - 'a') + 10;
		return -1;
	}
	
	public static char decimalToHexDigit(int decimal){
		if (decimal >= 0 && decimal <= 9)
			return (char)('0' + decimal);
		else{
			switch (decimal){
			case 10:
				return 'A';
			case 11:
				return 'B';
			case 12:
				return 'C';
			case 13:
				return 'D';
			case 14:
				return 'E';
			case 15:
				return 'F';
			default:
				return 'X';
			}
		}
			
		
	}
	
	public static int hexToDecimal(String hex){
		int decimal = 0, i = 0;
		while (!hex.equals("")){
			char lastChar = hex.charAt(hex.length() - 1);
			decimal += hexDigitToDecimal(lastChar) * (int)(Math.pow(16, i));
			hex = hex.substring(0, hex.length() - 1);
			i++;
		}
		return decimal;
	}
	
	public static String decimalToBinary(int decimal){
		final int RADIX = 2;
		int remainder; 
		String result = "";
		while (decimal > 0){
			remainder = decimal % RADIX;
			decimal = decimal / RADIX;
			result = remainder + result;
		}
		return result;
	}
	
	public static String decimalToOctal(int decimal){
		final int RADIX = 8;
		int remainder; 
		String result = "";
		while (decimal > 0){
			remainder = decimal % RADIX;
			decimal = decimal / RADIX;
			result = remainder + result;
		}
		return result;
	}
	
	public static String binaryToHex(String binary){
		String hex = "";
		int sum;
		while (!binary.equals("")){
			String lastFour;
			sum = 0;
			if (binary.length() > 3)
				lastFour = binary.substring(binary.length() - 4, binary.length());
			else if (binary.length() == 3)
				lastFour = "0" + binary;
			else if (binary.length() == 2)
				lastFour = "00" + binary;
			else
				lastFour = "000" + binary;
			for (int i = 0, j = 8; i < 4; i++, j /= 2){
				char bit = lastFour.charAt(i);
				int multiplier = (bit == '0') ? 0 : 1;
				sum += multiplier*j;
			}
		
			hex = decimalToHexDigit(sum) + hex;
			if (binary.length() >= 4)
			binary = binary.substring(0, binary.length() - 4);
			else 
				binary = "";
		}
		
		
		return hex;
	}
	
	public static int binaryToDecimal(int binary){
		int digit, decimal = 0, i = 0;
		while (binary > 0){
			digit = binary % 10;
			decimal += digit * Math.pow(2, i);
			i++;
			binary /= 10;			
		}
		return decimal;
	}
}
