import java.io.*;
import java.util.*;
public class EhernetEncap  {
	public static void main(String[] args)throws Exception{
	FrameEncap fe=new FrameEncap();
	fe.Encap();
	fe.operate();
	
	}
}
class FrameEncap {
	Scanner sc=new Scanner(System.in);
	char[] Preamble=new char[7];
	char[] Delimiter=new char[1];
	char[]  Destination=new char[6];
	char[] Source=new char[6];
	int Length;
	String Data;
	char[] Checksum=new char[1];
	char[] CheckBuf=new char[65535];
	public void Encap()throws Exception{
		boolean FrameAnother=true;
		int FrameNum=0;
		String DataBuf;
		System.out.println("please input the data domain");
		DataBuf=sc.next();
		if(DataBuf==""){
			System.out.println("please input the information you want");
			System.exit(0);
		}
		int DataLen=DataBuf.length();
		while(FrameAnother==true){
			
			FrameNum++;
			//String str;
			for(int i=0;i<7;i++) Preamble[i]=(char)0xaa;
			Delimiter[0]=0xab;
			Destination[0]=0x80;
			Destination[1]=0x80;
			Destination[2]=0x80;
			Destination[3]=0x80;
			Destination[4]=0x80;
			Destination[5]=0x80;
			
			Source[0]=(char)0x3a;
			Source[1]=(char)0x3a;
			Source[2]=(char)0x3a;
			Source[3]=(char)0x3a;
			Source[4]=(char)0x3a;
			Source[5]=(char)0x3a;
			String TemData;
			if(DataLen<46){
				FrameAnother=false;
				for(int i=0;i<46-DataLen;i++){
					DataBuf=DataBuf+(char)0x00;
					
				}
				TemData=DataBuf;
				
			}
			else{
				if(DataLen>1500){
					FrameAnother=true;
					TemData=DataBuf.substring(0,1500);
					DataBuf=DataBuf.substring(1500,DataLen-1500);
					
				}
				else
	            {
	                FrameAnother=false;
	                TemData=DataBuf;
	            }
				
			}
			
			Length=TemData.length()+18;
			
			Data=TemData;
			//Checksum[0]=0;
		    	
		}
		
		
		
	}
	public char CRCcheck(char[] buffer,int size){
		char crc=0;
		for(int i=0;i<size;i++){
			char temp=buffer[i];
			char j;
			for(j=(char)0x80;j>0;j>>=1){
				if((crc&0x80)==0x80){
					{
						crc<<=1;
						if((temp&j)==0x80){
							crc^=0x01;
							crc^=0x07;
						}
						else{
							crc<<=1;
							if((temp&j)>0){
								crc^=0x01;
							}
						}
					}
				}
			}
		}
		return crc;
		
		
	}
	public String  XtoB(String s){
		int i=Integer.parseInt(s,16);
		String str2=Integer.toBinaryString(i);
		return str2;
	} 
	public void operate() throws IOException{
		String Len=""+Length;
		String Del=String.valueOf(Delimiter);
		String Pre=String.valueOf(Preamble);
		String Des=String.valueOf(Destination);
		String Sou=String.valueOf(Source);
		Del=XtoB(Del);
		Pre=XtoB(Pre);
		Des=XtoB(Des);
		Sou=XtoB(Sou);
		Len=XtoB(Len);
		//Data=XtoB(Data);
		Delimiter=Del.toCharArray();
		Preamble=Pre.toCharArray();
		Destination=Des.toCharArray();
		Source=Sou.toCharArray();
		char[] L=Len.toCharArray();
		char[] D=Data.toCharArray();
		File f1=new File("input");
		FileWriter in=new FileWriter(f1);
		System.arraycopy(Preamble,0,CheckBuf,0,7);
		System.arraycopy(Delimiter,0,CheckBuf,6,Delimiter.length);
		System.arraycopy(Destination, 0, CheckBuf, 7+Delimiter.length, 6);
		System.arraycopy(Source,0,CheckBuf,7+Delimiter.length+6,6);
		System.arraycopy(L, 0, CheckBuf,7+Delimiter.length+6,L.length);
		System.arraycopy(D, 0, CheckBuf, 7+Delimiter.length+6+L.length,D.length);
		Checksum[0]=CRCcheck(CheckBuf,Length);
		System.arraycopy(Checksum, 0, CheckBuf, 7+Delimiter.length+6+L.length+D.length, 1);
		for(int i=0;i<1+7+Delimiter.length+6+L.length+D.length;i++){
			in.write(CheckBuf[i]);
		}
		in.close();
	   
		
		
		
		
		
		
	}
	
	
	
	
}