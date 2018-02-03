import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class EthernetTest {
      public static void main(String[] args) throws IOException{
    	  Scanner sc=new Scanner(System.in);
    	  
    	  while(true){
    	  System.out.println("please begin your Ethernet Frame");
    	  System.out.println("the 0 is Begin");
    	  System.out.println("the 1 is exit ");
    	  int k=sc.nextInt();
    	  if(k==0){ new EthernetC().Begin();}
    	  else System.exit(0);
    		 
    	  }
    	  
    	  
      }
}
class EthernetC{
   int  maxlen=1000;
   public void crc8(char c,char input){
	   short crcgen=0x80;
	   for(int i=0;i<8;i++){
		   if((c&0x80)!=0){
			   c<<=1;
			   if((input&crcgen)!=0){
				   c|=1;
			   }
			   c^=7;
		   }
		   else{
			   c<<=1;
			   if((input&crcgen)!=0){
				   c|=1;
			   }
			   c^=0;
		   }
		   crcgen>>=1;
		   
	   }
   }
   public char convert(char c){
	   if(c-'0'<=9&&c-'0'>=0)
		   return (char) (c-'0');
	   else 
		   return (char) (c-'A'+10);
   }
   public boolean isFramec(char[] str){
	   for(int i=0;i<str.length;i++){
		   if(!((str[i]>='a'&&str[i]<='f')||(str[i]>='A'&&str[i]<='F')||(str[i]>='0'&&str[i]<='9'))){ 
			     System.out.println("error,input the Hex please");
				return false; 
	 	     }
	   }
	   return true;
   }
	public void Begin()throws IOException{
		String s_FilePath="bin2"; 
		DataOutputStream dos=null;
		if(!new File(s_FilePath).exists()){  
            new File(s_FilePath).createNewFile();  
        }
		dos=new DataOutputStream(new FileOutputStream(new File(s_FilePath)));
	Scanner sc=new Scanner(System.in);
		//File f1=new File("input2.dat");
        //FileWriter in=new FileWriter(f1);
        char ch=0xaa;
        String string;
        
        char check = 0;
        for(int i=0;i<7;i++){
        	dos.writeChar(ch);
        }
        ch=0xab;
        dos.writeChar(ch);
        while (true){
        	boolean isFrame=true,isLength=true;
        	System.out.println("the source IP Address is: ");
        	string=sc.next();
        	char[] str=string.toCharArray();
        	   	if(str.length!=12){
        		System.out.println("the input is wrong");
        		isLength=false;
        	}
        	isLength=isFramec(str);
        	if(isFrame&&isLength){
        		break;
        	}
        	
        }
        char[] str=string.toCharArray();
        for(int i=0;i<string.length();i+=2){
        	ch=convert(str[i]);
        	ch<<=4;
        	ch^=convert(str[i+1]);
        	if(i==0){
        		check=ch;
        	}
        	else
        		crc8(check,ch);
        	dos.writeChar(ch);
        }
        while(true){
        	boolean isFrame=true,isLength=true;
        	System.out.println("the Destination IP is:");
        	string=sc.next();
        	char[] str2=string.toCharArray();
        	if(str2.length!=12){
        		System.out.println("the input is wrong");
        		isLength=false;
        	}
        	isLength=isFramec(str2);
        	if(isFrame&&isLength){
        		break;
        	}
        	
        }
        char[] str2=string.toCharArray();
        for(int i=0;i<string.length();i+=2){
            	ch=convert(str2[i]);
            	ch<<=4;
            	ch^=convert(str2[i+1]);
               	crc8(check,ch);
            	dos.writeChar(ch);
            }
        while(true){
        	boolean isFrame=true,isLength=true;
        	System.out.println("the Type is: ");
        	string=sc.next();
        	char[] str3=string.toCharArray();
        	if(str3.length!=4){
        		System.out.println("the input is wrong");
        		isLength=false;
        	}
        	isLength=isFramec(str3);
        	if(isFrame&&isLength){
        		break;
        	}
        }
        char str3[]=string.toCharArray();
        for(int i=0;i<str3.length;i+=2){
        	ch=convert(str3[i]);
        	ch<<=4;
        	ch^=convert(str3[i+1]);
        	crc8(check,ch);
        	dos.writeChar(ch);
        }
        System.out.println("data is ");
        string=sc.next();
        dos.writeChars(string);
        char[] str4=string.toCharArray();
        for(int i =0;i<str4.length;i++){
        	crc8(check,str4[i]);
        }
        char temp=0;
        crc8(check,temp);
        dos.writeChar(check);
        dos.writeChar(temp);
        dos.writeChar(temp);
        dos.writeChar(temp);
        dos.close();
	}
	
	
}
