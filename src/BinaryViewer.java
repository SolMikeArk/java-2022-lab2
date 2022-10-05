

public class BinaryViewer {
	public static void printDouble(double v) {
		StringBuilder str = new StringBuilder(Long.toBinaryString(Double.doubleToRawLongBits(v)));
		int length = str.length();
		for(int i = 64; i - length > 0; i--)
			str.insert(0, '0');
		System.out.println("""
				63      55      47      39      31      23      15      7      0
				|-------v-------v-------v-------v-------v-------v-------v------|""");
		System.out.println(str);
		System.out.println("""
				||---Exp---||                                                  |
				|10        0|----------------------Mantissa--------------------|
				|Sign""");
		
		System.out.println(
				"(-1)^" +
				Integer.parseInt(str.substring(0, 1),2) +
				" * " +
				Long.parseLong("1" + str.substring(12),2)/Math.pow(2, 52) +
				" * 2^" +
				(Integer.parseInt(str.substring(1, 12),2) - 1023)
				);
	}
	
	public static void printFloat(float v) {
		StringBuilder str = new StringBuilder(Integer.toBinaryString(Float.floatToRawIntBits(v)));
		int length = str.length();
		for(int i = 32; i - length > 0; i--)
			str.insert(0, '0');
		System.out.println("""
				31      23      15      7       0
				|-------v-------v-------v------|""");
		System.out.println(str);
		System.out.println("""
				||-Exp--||                     |
		        |7      0|-------Mantissa------|
		        |Sign""");
		
		System.out.println(
				"(-1)^" +
				Integer.parseInt(str.substring(0, 1),2) +
				" * " +
				Integer.parseInt("1" + str.substring(9),2)/Math.pow(2, 23) +
				" * 2^" +
				(Integer.parseInt(str.substring(1, 9),2) - 127)
				);
	}
	
	public static void printLong(long v) {
		StringBuilder str = new StringBuilder(Long.toBinaryString(v));
		int length = str.length();
		for(int i = 64; i - length > 0; i--)
			str.insert(0, '0');
		System.out.println("""
				63      55      47      39      31      23      15      7      0
				|-------v-------v-------v-------v-------v-------v-------v------|""");
		System.out.println(str);
		System.out.println("|Sign");
		
	}
	
	public static void printInt(int v) {
		StringBuilder str = new StringBuilder(Integer.toBinaryString(v));
		int length = str.length();
		for(int i = 32; i - length > 0; i--)
			str.insert(0, '0');
		System.out.println("31     23      15      7       0");
		System.out.println("|-------v-------v-------v------|");
		System.out.println(str);
		System.out.println("|Sign");		
	}
	
	public static void printShort(short v) {
		StringBuilder str = new StringBuilder(Integer.toBinaryString(v));
		int length = str.length();
		for(int i = 16; i - length > 0; i--)
			str.insert(0, '0');
		System.out.println("""
				15      7      0
				|-------v------|""");
		System.out.println(str);
		System.out.println("|Sign");		
	}
	
	public static void printByte(byte v) {
		StringBuilder str = new StringBuilder(Integer.toBinaryString(v));
		int length = str.length();
		for(int i = 8; i - length > 0; i--)
			str.insert(0, '0');
		System.out.println("""
				7      0
				|------|""");
		System.out.println(str);
		System.out.println("|Sign");		
	}
	
	public static void printChar(char v) {
		StringBuilder str = new StringBuilder(Integer.toBinaryString(v));
		int length = str.length();
		for(int i = 16; i - length > 0; i--)
			str.insert(0, '0');
		System.out.println("15      7      0");
		System.out.println("|-------v------|");
		System.out.println(str);
		System.out.println(v);
	}
	
	public static void printString(String v) {
		System.out.println("""
				15      7      0
				|-------v------|""");
		v.chars().forEach(e -> {
			StringBuilder str = new StringBuilder(Integer.toBinaryString(e));
			int length = str.length();
			for(int i = 16; i - length > 0; i--)
				str.insert(0, '0');
			System.out.println(str);
		});
		
	}
}
