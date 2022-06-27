public class Launcher{
    
    static public void main(String[] args) {
		JasminParser parser;

		if(args.length == 0){
			System.out.println("Jasmin Parser:  Reading from standard input . . .");
			parser = new JasminParser(System.in);
		} else if(args.length == 1){
			System.out.println("Jasmin Parser:  Reading from file " + args[0] + " . . ." );
			try {
				parser = new JasminParser(new java.io.FileInputStream(args[0]));
			} catch(java.io.FileNotFoundException e){
				System.out.println("Jasmin Parser:  File " + args[0] + " not found.");
				return;
			}
		} else {
			System.out.println("Jasmin Parser:  Usage is one of:");
			System.out.println("         java JasminParser < inputfile");
			System.out.println("OR");
			System.out.println("         java JasminParser inputfile");
			return ;
		}

		try {
			parser.Start();
			System.out.println("Jasmin Parser:  Jasmin file parsed successfully.");
		} catch(ParseException e){
			System.out.println("Jasmin Parser:  Encountered errors during parse.");
			e.printStackTrace();
		}

		System.out.println(parser.getInstr().toString());

		System.out.println("\n\n\t Jasmin Code: \n\n\t");

		parser.jasminCode();
    }

}