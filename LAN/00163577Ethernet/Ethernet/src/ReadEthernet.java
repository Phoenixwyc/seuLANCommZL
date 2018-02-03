import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadEthernet {
     public static void main(String[] args) throws IOException{
    	 FileReader fr=new FileReader("input");
    	 int c;
    	 String s;
    	 while ((c = fr.read()) != -1) {
    		  s=String.format("%x",c);
    	        //char ch = (char) fr.read();
    	        System.out.print(s);
    	        //if (++ln >= 100) { System.out.println(); ln = 0;}
    	      }
    	      fr.close();
    	 
     }
}
