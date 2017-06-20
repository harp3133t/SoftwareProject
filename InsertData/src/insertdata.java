
import java.io.ByteArrayInputStream;
import java.io.BufferedReader;
import java.io.IOException; 
import java.io.FileReader; 
import java.io.File;
import java.io.InputStream;
import java.sql.*;
import java.util.Random;
import java.util.Date;
import java.util.Calendar;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.sqlite.SQLiteConfig;

public class insertdata {

	private static final String[] Location={
        	"����Ư���� ���α�"
        	,"����Ư���� �߱�"
        	,"����Ư���� ��걸"
        	,"����Ư���� ������"
        	,"����Ư���� ������"
        	,"����Ư���� ���빮��"
        	,"����Ư���� �߶���"
        	,"����Ư���� ���ϱ�"
        	,"����Ư���� ���ϱ�"
        	,"����Ư���� ������"
        	,"����Ư���� �����"
        	,"����Ư���� ����"
        	,"����Ư���� ���빮��"
        	,"����Ư���� ������"
        	,"����Ư���� ��õ��"
        	,"����Ư���� ������"
        	,"����Ư���� ���α�"
        	,"����Ư���� ��õ��"
        	,"����Ư���� ��������"
        	,"����Ư���� ���۱�"
        	,"����Ư���� ���Ǳ�"
        	,"����Ư���� ���ʱ�"
        	,"����Ư���� ������"
        	,"����Ư���� ���ı�"
        	,"����Ư���� ������"
        	,"�λ걤���� �߱�"
        	,"�λ걤���� ����"
        	,"�λ걤���� ����"
        	,"�λ걤���� ������"
        	,"�λ걤���� �λ�����"
        	,"�λ걤���� ������"
        	,"�λ걤���� ����"
        	,"�λ걤���� �ϱ�"
        	,"�λ걤���� �ؿ�뱸"
        	,"�λ걤���� ���ϱ�"
        	,"�λ걤���� ������"
        	,"�λ걤���� ������"
        	,"�λ걤���� ������"
        	,"�λ걤���� ������"
        	,"�λ걤���� ���"
        	,"�λ걤���� ���屺"
        	,"��걤���� �߱�"
        	,"��걤���� ����"
        	,"��걤���� ����"
        	,"��걤���� �ϱ�"
        	,"��걤���� ���ֱ�"
        	,"�뱸������ �߱�"
        	,"�뱸������ ����"
        	,"�뱸������ ����"
        	,"�뱸������ ����"
        	,"�뱸������ �ϱ�"
        	,"�뱸������ ������"
        	,"�뱸������ �޼���"
        	,"�뱸������ �޼���"
        	,"���ֱ����� ����"
        	,"���ֱ����� ����"
        	,"���ֱ����� ����"
        	,"���ֱ����� �ϱ�"
        	,"���ֱ����� ���걸"
        	,"��õ������ �߱�"
        	,"��õ������ ����"
        	,"��õ������ ����"
        	,"��õ������ ������"
        	,"��õ������ ������"
        	,"��õ������ ����"
        	,"��õ������ ��籸"
        	,"��õ������ ����"
        	,"��õ������ ��ȭ��"
        	,"��õ������ ������"
        	,"���������� ����"
        	,"���������� �߱�"
        	,"���������� ����"
        	,"���������� ������"
        	,"���������� �����"
        	,"����Ư����ġ�� �ݰ"
        	,"����Ư����ġ�� �Ҵ㵿"
        	,"����Ư����ġ�� ������"
        	,"����Ư����ġ�� ����"
        	,"����Ư����ġ�� ������"
        	,"����Ư����ġ�� �Ѽֵ�"
        	,"����Ư����ġ�� ������"
        	,"����Ư����ġ�� ���ҵ�"
        	,"����Ư����ġ�� ������"
        	,"����Ư����ġ�� ������"
        	,"����Ư����ġ�� ���̵�"
        	,"����Ư����ġ�� ��"
        	,"����Ư����ġ�� �Ƹ���"
        	,"����Ư����ġ�� ���㵿"
        	,"����Ư����ġ�� ��ġ����"
        	,"����Ư����ġ�� �����"
        	,"����Ư����ġ�� ������"
        	,"����Ư����ġ�� �ΰ���"
        	,"����Ư����ġ�� �ݳ���"
        	,"����Ư����ġ�� �屺��"
        	,"����Ư����ġ�� ������"
        	,"����Ư����ġ�� ���Ǹ�"
        	,"����Ư����ġ�� ������"
        	,"����Ư����ġ�� ������"
        	,"����Ư����ġ�� ���ֽ�"
        	,"����Ư����ġ�� ��������"
        	,"��⵵ ������ ��ȱ�"
        	,"��⵵ ������ �Ǽ���"
        	,"��⵵ ������ �ȴޱ�"
        	,"��⵵ ������ ���뱸"
        	,"��⵵ ������ ������"
        	,"��⵵ ������ �߿���"
        	,"��⵵ ������ �д籸"
        	,"��⵵ �����ν�"
        	,"��⵵ �Ⱦ�� ���ȱ�"
        	,"��⵵ �Ⱦ�� ���ȱ�"
        	,"��⵵ ��õ��"
        	,"��⵵ �����"
        	,"��⵵ ���ý�"
        	,"��⵵ ����õ��"
        	,"��⵵ �Ȼ�� ��ϱ�"
        	,"��⵵ �Ȼ�� �ܿ���"
        	,"��⵵ ���� ���籸"
        	,"��⵵ ���� �ϻ굿��"
        	,"��⵵ ���� �ϻ꼭��"
        	,"��⵵ ��õ��"
        	,"��⵵ ������"
        	,"��⵵ �����ֽ�"
        	,"��⵵ �����"
        	,"��⵵ �����"
        	,"��⵵ ������"
        	,"��⵵ �ǿս�"
        	,"��⵵ �ϳ���"
        	,"��⵵ ���ν� ó�α�"
        	,"��⵵ ���ν� ���ﱸ"
        	,"��⵵ ���ν� ������"
        	,"��⵵ ���ֽ�"
        	,"��⵵ ��õ��"
        	,"��⵵ �ȼ���"
        	,"��⵵ ������"
        	,"��⵵ ȭ����"
        	,"��⵵ ���ֽ�"
        	,"��⵵ ���ֽ�"
        	,"��⵵ ��õ��"
        	,"��⵵ ���ֽ�"
        	,"��⵵ ��õ��"
        	,"��⵵ ����"
        	,"��⵵ ����"
        	,"������ ��õ��"
        	,"������ ���ֽ�"
        	,"������ ������"
        	,"������ ���ؽ�"
        	,"������ �¹��"
        	,"������ ���ʽ�"
        	,"������ ��ô��"
        	,"������ ȫõ��"
        	,"������ Ⱦ����"
        	,"������ ������"
        	,"������ ��â��"
        	,"������ ������"
        	,"������ ö����"
        	,"������ ȭõ��"
        	,"������ �籸��"
        	,"������ ������"
        	,"������ ����"
        	,"������ ��籺"
        	,"��û�ϵ� û�ֽ� ��籸"
        	,"��û�ϵ� û�ֽ� ������"
        	,"��û�ϵ� û�ֽ� �����"
        	,"��û�ϵ� û�ֽ� û����"
        	,"��û�ϵ� ���ֽ�"
        	,"��û�ϵ� ��õ��"
        	,"��û�ϵ� ������"
        	,"��û�ϵ� ��õ��"
        	,"��û�ϵ� ������"
        	,"��û�ϵ� ����"
        	,"��û�ϵ� ��õ��"
        	,"��û�ϵ� ���걺"
        	,"��û�ϵ� ������"
        	,"��û�ϵ� �ܾ籺"
        	,"��û���� õ�Ƚ� ������"
        	,"��û���� õ�Ƚ� ���ϱ�"
        	,"��û���� ���ֽ�"
        	,"��û���� ���ɽ�"
        	,"��û���� �ƻ��"
        	,"��û���� �����"
        	,"��û���� ����"
        	,"��û���� ����"
        	,"��û���� ������"
        	,"��û���� �ݻ걺"
        	,"��û���� �ο���"
        	,"��û���� ��õ��"
        	,"��û���� û�籺"
        	,"��û���� ȫ����"
        	,"��û���� ���걺"
        	,"��û���� �¾ȱ�"
        	,"����ϵ� ���ֽ� �ϻ걸"
        	,"����ϵ� ���ֽ� ������"
        	,"����ϵ� �����"
        	,"����ϵ� �ͻ��"
        	,"����ϵ� ������"
        	,"����ϵ� ������"
        	,"����ϵ� ������"
        	,"����ϵ� ���ֱ�"
        	,"����ϵ� ���ȱ�"
        	,"����ϵ� ���ֱ�"
        	,"����ϵ� �����"
        	,"����ϵ� �ӽǱ�"
        	,"����ϵ� ��â��"
        	,"����ϵ� ��â��"
        	,"����ϵ� �ξȱ�"
        	,"���󳲵� ������"
        	,"���󳲵� ������"
        	,"���󳲵� ��õ��"
        	,"���󳲵� ���ֽ�"
        	,"���󳲵� �����"
        	,"���󳲵� ��籺"
        	,"���󳲵� ���"
        	,"���󳲵� ���ʱ�"
        	,"���󳲵� ���ﱺ"
        	,"���󳲵� ������"
        	,"���󳲵� ȭ����"
        	,"���󳲵� ���ﱺ"
        	,"���󳲵� ������"
        	,"���󳲵� �س���"
        	,"���󳲵� ���ϱ�"
        	,"���󳲵� ���ȱ�"
        	,"���󳲵� ����"
        	,"���󳲵� ������"
        	,"���󳲵� �强��"
        	,"���󳲵� �ϵ���"
        	,"���󳲵� ������"
        	,"���󳲵� �žȱ�"
        	,"���ϵ� ���׽� ����"
        	,"���ϵ� ���׽� �ϱ�"
        	,"���ϵ� ���ֽ�"
        	,"���ϵ� ��õ��"
        	,"���ϵ� �ȵ���"
        	,"���ϵ� ���̽�"
        	,"���ϵ� ���ֽ�"
        	,"���ϵ� ��õ��"
        	,"���ϵ� ���ֽ�"
        	,"���ϵ� �����"
        	,"���ϵ� ����"
        	,"���ϵ� ������"
        	,"���ϵ� �Ǽ���"
        	,"���ϵ� û�۱�"
        	,"���ϵ� ���籺"
        	,"���ϵ� ������"
        	,"���ϵ� û����"
        	,"���ϵ� ��ɱ�"
        	,"���ϵ� ���ֱ�"
        	,"���ϵ� ĥ�"
        	,"���ϵ� ��õ��"
        	,"���ϵ� ��ȭ��"
        	,"���ϵ� ������"
        	,"���ϵ� �︪��"
        	,"��󳲵� â���� ��â��"
        	,"��󳲵� â���� ���걸"
        	,"��󳲵� â���� ����������"
        	,"��󳲵� â���� ����ȸ����"
        	,"��󳲵� â���� ���ر�"
        	,"��󳲵� ���ֽ�"
        	,"��󳲵� �뿵��"
        	,"��󳲵� ��õ��"
        	,"��󳲵� ���ؽ�"
        	,"��󳲵� �о��"
        	,"��󳲵� ������"
        	,"��󳲵� ����"
        	,"��󳲵� �Ƿɱ�"
        	,"��󳲵� �Ծȱ�"
        	,"��󳲵� â�籺"
        	,"��󳲵� ����"
        	,"��󳲵� ���ر�"
        	,"��󳲵� �ϵ���"
        	,"��󳲵� ��û��"
        	,"��󳲵� �Ծ籺"
        	,"��󳲵� ��â��"
        	,"��󳲵� ��õ��"
        };
	private static final String FILE_NAME = "�̸�.txt"; 
	
	private static final String[] Disease1=
		{
				"���� ����",
				"���� ����",
				"�� ����",
				"�� ����",
				"�߸� ����",
				"�߸� ����",
				"�� ����",
				"�� ����",
				"�ո� ����",
				"�ո� ����",
				"���� ����",
				"���� ����"
		};
	private static final String[] Disease2=
		{
			"��ũ",
			"������",
			"����",
			"��",
			"�缺����"
		};
	
	private static final String[] Hospital=
		{
			"1������",
			"2������",
			"�Ｚâ������",
			"â�������б�����",
			"ĥ���ϴ��б�����",
			"�������б�����",
			"�Ǿ���б�����",
			"�������𺴿�",
			"���麴��",
			"����麴��",
			"�ϻ�麴��",
			"�ؿ��麴��",
			"���ǵ����𺴿�",
			"����������",
			"�д�������",
			"����������",
			"�Ѿ���б� ��������",
			"����������б�����",
			"�Ǳ����б� ���ֺ���",
			"��õ����б� ���ﺴ��",
			"�����ϼ���",
			"��õ����б� ���̺���",
			"�������б� �ϻ꺴��",
			"�������б� ���ֺ���",
			"�����ƻ꺴��",
			"�Ѹ����б� �������ɺ���",
			"�Ѹ����б� ��õ���ɺ���",
			"����ź���",
			"��������",
			"�������б�����",
			"���ִ��б�����",
			"���縯�������б� �������𺴿�",
			"���λ���б�����",
			"�����б�����"};
	
	private static final String[] FirstPhone={
			
	};
	private static final String[] Kind=
		{
				"����",
				"����"
		};
	String getPhone()
	{
		Random random=new Random();
		String s=""+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+"-"+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+random.nextInt(10);
		return s;
	}
	
	/*
	void setLastName() throws IOException
	{
		String inFileLine;
        BufferedReader fileIn = new BufferedReader(new FileReader(FILE_NAME));
        int j=0;
	    //String Birth=""+random.nextInt(100)+(random.nextInt(12)+1)+(random.nextInt(30)+1);
        while ((inFileLine = fileIn.readLine()) != null) {
        	if(j>800)
        		break;
        	else
        		LastName[j]=inFileLine;
        	
        }
		
	}
	*/
	void CreateDB(String name)
	{
		Connection c = null;
	    try {
	      Class.forName("org.sqlite.JDBC") ;
	      c = DriverManager.getConnection("jdbc:sqlite:"+name) ;
	    } catch ( Exception e ) {
	      System.err.println( e.getClass() .getName() + ": " + e.getMessage() );
	      System.exit(0) ;
	    }
	    System.out.println("Opened database successfully") ;
	}
	
	void CreateTable(String name)
	{
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC") ;
	      c = DriverManager.getConnection("jdbc:sqlite:"+name) ;
	      System.out.println("Opened database successfully") ;

	      stmt = c.createStatement() ;
	      String sql = "CREATE TABLE INFOTABLE " +
	                   "(ID INT PRIMARY KEY     NOT NULL," +
	                   " NAME           TEXT    NOT NULL, " + 
	                   " NUM            TEXT    NOT NULL, " + 
	                   " LOCATION       TEXT	NOT NULL , " + 
	                   " DATE 	        TEXT	NOT NULL,"+
	                   " ISSUE			TEXT	NOT NULL)"; 
	      stmt.executeUpdate(sql) ;
	      stmt.close() ;
	      c.close() ;
	    } catch ( Exception e ) {
	      System.err.println( e.getClass() .getName() + ": " + e.getMessage() );
	      System.exit(0) ;
	    }
	    System.out.println("Table created successfully") ;
	}
	void CreateTable2(String name)
	{
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC") ;
	      c = DriverManager.getConnection("jdbc:sqlite:"+name) ;
	      System.out.println("Opened database successfully") ;

	      stmt = c.createStatement() ;
	      String sql = "CREATE TABLE BILLTABLE " +
	                   "(ID INT PRIMARY KEY     NOT NULL," +
	                   " JOB           TEXT     NOT NULL, " + 
	                   " COMPANY       TEXT     NOT NULL, " + 
	                   " EMAIL     	   TEXT		NOT NULL , " + 
	                   " PHONE	       TEXT		NOT NULL,"+
	                   " HP			   TEXT		NOT NULL,"+
	                   " BANK		   TEXT		NOT NULL,"+
	                   " ACCOUNT	   TEXT		NOT NULL)"; 
	      stmt.executeUpdate(sql) ;
	      stmt.close() ;
	      c.close() ;
	    } catch ( Exception e ) {
	      System.err.println( e.getClass() .getName() + ": " + e.getMessage() );
	      System.exit(0) ;
	    }
	    System.out.println("Table created successfully") ;
	}
	@SuppressWarnings("null")
	void CreateTable3(String name)
	{
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC") ;
	      c = DriverManager.getConnection("jdbc:sqlite:"+name) ;
	      System.out.println("Opened database successfully") ;

	      stmt = c.createStatement() ;
	      String sql = "CREATE TABLE CERTIFICATETABLE " +
	                   "(ID INT PRIMARY KEY     NOT NULL," +
	                   " KIND          TEXT     NOT NULL, " +  //����,���� 
	                   " NUMBER        TEXT     NOT NULL, " +   //����ȣ 12-XXXXXXX
	                   " DISEASE       TEXT		NOT NULL , " + 
	                   " DISEASEDATE   TEXT		NOT NULL,"+
	                   " DIGNOSISDATE  TEXT		NOT NULL,"+
	                   " MEDICDATE	   TEXT		NOT NULL,"+
	                   " DATE		   TEXT		NOT NULL,"+
	                   " HOSPITAL	   TEXT 	NOT NULL,"+
	                   " LOCATION	   TEXT		NOT NULL,"+
	                   " PHONE		   TEXT		NOT NULL,"+
	                   " LICENSENUM	   TEXT		NOT NULL,"+
	                   " NAME		   TEXT		NOT NULL)"; 
	      stmt.executeUpdate(sql) ;
	      stmt.close() ;
	      c.close() ;
	    } catch ( Exception e ) {
	      System.err.println( e.getClass() .getName() + ": " + e.getMessage() );
	      System.exit(0) ;
	    }
	    System.out.println("Table created successfully") ;
	}
	String Birth()
	{
		Random random=new Random();
		String s="";
		int year;
		int month;
		int day;
		int gender=0;
		year=random.nextInt(100);
		month=random.nextInt(12)+1;
		day=random.nextInt(30)+1;
		if(10>year)s+="0"+year;
		else s+=year;
		if(10>month)s+="0"+month;
		else if(month==0)
		{
			month=1;
			s+="0"+month;
		}
		else s+=month;
		if(10>day)s+="0"+day;
		else if(day==0)
		{
			day=1;
			s+="0"+day;
		}
		else s+=day;
		
		s+="-";
		if (year<=17)
			gender=random.nextInt(2)+3;
		else if(year>17)
			gender=random.nextInt(2)+1;
		s+=gender;
		for(int i=0; i<6; i++)
			s+=random.nextInt(10);
		return s;
	}
	String DoctorNumber()
	{
		Random random=new Random();
		String s="1"+random.nextInt(10)+"-"+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+random.nextInt(10);
		return s;
	}
	
	void insert(String name,int i) throws IOException
	{
		int j = 0; 
		Random random=new Random();
        String inFileLine;
        String birth=Birth();
        BufferedReader fileIn = new BufferedReader(new FileReader(FILE_NAME));
        String[] LastName = new String[835];
	    String[] FirstName={"��","��","��","��","��",
	    		"��","��","��","��","��","��","��","��","��","��","��","��",
	    		"��","��","��","Ȳ","��","��","��","��","��","ȫ","��","��","��","��","��","ǥ"};
	    String l=Location[random.nextInt(Location.length)];
	    //String Birth=""+random.nextInt(100)+(random.nextInt(12)+1)+(random.nextInt(30)+1);
        while ((inFileLine = fileIn.readLine()) != null) {
        	if(j>835)
        		break;
        	else
        		LastName[j]=inFileLine;
        		j++;
        }
        
		Connection c = null;
	    Statement stmt = null;
	    int LastBirth=Integer.valueOf(""+birth.charAt(0)+birth.charAt(1));
	    int th=0;
	    if(LastBirth>17) th = 19;
	    else th=20;
	    try {
	      Class.forName("org.sqlite.JDBC") ;
	      c = DriverManager.getConnection("jdbc:sqlite:"+name) ;
	      c.setAutoCommit(false) ;
	      System.out.println("Opened database successfully") ;
	      
	      stmt = c.createStatement() ;
	      String sql = "INSERT INTO INFOTABLE (ID,NAME,NUM,LOCATION,DATE,ISSUE) " +
          "VALUES ("+i+",'"
	    		  +FirstName[random.nextInt(33)]+LastName[random.nextInt(835)]+ "','"//�̸�
	                   		//+random.nextInt(100)+(random.nextInt(12)+1)+(random.nextInt(30)+1)
	                   		+birth+"',"
	                   		+ " '"+l+"',"
	                   		+ " '"+th+birth.charAt(0)+birth.charAt(1)+"��"+birth.charAt(2)+birth.charAt(3)+"��"+birth.charAt(4)+birth.charAt(5)+"��"+ "',"
	                   		+ "'"+l+"û' ) ;"; 
	      stmt.executeUpdate(sql) ;
	      stmt.close() ;
	      c.commit() ;
	      c.close() ;
	    } catch ( Exception e ) {
	      System.err.println( e.getClass() .getName() + ": " + e.getMessage() );
	      System.exit(0) ;
	    }
	    System.out.println("Records created successfully") ;
	}
	
	String set_email()
	{
		String s;
		Random random=new Random();
		String[] firstemail={"asdf","zxve","qwerz","sgew","fefef","ggrgr","rrrg","ngngng"};
	    String middleemail=""+random.nextInt(10)+random.nextInt(10)+"@";
	    String[] lastemail={"naver.com","gmail.com","daum.net"};
		s=firstemail[random.nextInt(firstemail.length)]+middleemail+lastemail[random.nextInt(lastemail.length)];
		return s;
	}
	
	String set_phone()
	{
		String s;
		Random random=new Random();
		s=""+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+"-"+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+random.nextInt(10);
		return s;
	}
	String set_hp()
	{
		String s;
		Random random=new Random();
		s="010-"+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+"-"+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+random.nextInt(10);
		return s;
	}
	String set_account()
	{
		String s;
		Random random=new Random();
		s=""+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+"-"+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+"-"+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+random.nextInt(10);
		return s;
	}
	void insert2(String name,int i) throws IOException
	{
		int j = 0; 
		Random random=new Random();
        String inFileLine;
        BufferedReader fileIn = new BufferedReader(new FileReader(FILE_NAME));
		Connection c = null;
	    Statement stmt = null;
	    String[] job={"�л�","������","���","���","����","�ڿ���","����"};
	    String[] company={"ȸ��","�б�","����","����","������"};
	    
	    
	    
	    String[] bank={"����","����","����","����","�츮","���","��ü��","�ϳ�","��ȯ","�뱸"};
	    
	    try {
	      Class.forName("org.sqlite.JDBC") ;
	      c = DriverManager.getConnection("jdbc:sqlite:"+name) ;
	      c.setAutoCommit(false) ;
	      System.out.println("Opened database successfully") ;
	      
	      stmt = c.createStatement() ;
	      String sql = "INSERT INTO BILLTABLE (ID,JOB,COMPANY,EMAIL,PHONE,HP,BANK,ACCOUNT) " +
          "VALUES ("+i+",'"
          			+job[random.nextInt(job.length)]+"','"
          			+company[random.nextInt(company.length)]+"','"
          			+set_email()+"','"
          			+set_phone()+"','"
          			+set_hp()+"','"
          			+bank[random.nextInt(bank.length)]+"','"
          			+set_account()
          			+"' ) ;"; 
	      stmt.executeUpdate(sql) ;
	      stmt.close() ;
	      c.commit() ;
	      c.close() ;
	    } catch ( Exception e ) {
	      System.err.println( e.getClass() .getName() + ": " + e.getMessage() );
	      System.exit(0) ;
	    }
	    System.out.println("Records created successfully") ;
	}
	
	void insert3(String name,int i) throws IOException
	{
		int j = 0; 
		Random random=new Random();
        String inFileLine;
        BufferedReader fileIn = new BufferedReader(new FileReader(FILE_NAME));
        String[] LastName = new String[835];
	    String[] FirstName={"��","��","��","��","��",
	    		"��","��","��","��","��","��","��","��","��","��","��","��",
	    		"��","��","��","Ȳ","��","��","��","��","��","ȫ","��","��","��","��","��","ǥ"};
	    String l=Location[random.nextInt(Location.length)];
	    //String Birth=""+random.nextInt(100)+(random.nextInt(12)+1)+(random.nextInt(30)+1);
        while ((inFileLine = fileIn.readLine()) != null) {
        	if(j>835)
        		break;
        	else
        		LastName[j]=inFileLine;
        		j++;
        }
        String kind=Kind[random.nextInt(2)];
        
        String[] Disease={};
        if(kind=="����")Disease=Disease1;
        else if(kind=="����") Disease=Disease2;
        String hospital = Hospital[random.nextInt(Hospital.length)];
        
        
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, random.nextInt(7)+2010);
        cal.set(Calendar.MONTH,random.nextInt(12)+1);
        cal.set(Calendar.DATE,random.nextInt(31)+1);
        String diseasedate=""+cal.get(Calendar.YEAR)+"�� "+cal.get(Calendar.MONTH)+"�� "+cal.get(Calendar.DATE)+"��";
        cal.add(Calendar.DATE,Calendar.DATE+random.nextInt(21));
        String dignosisdate=""+cal.get(Calendar.YEAR)+"�� "+cal.get(Calendar.MONTH)+"�� "+cal.get(Calendar.DATE)+"��";
        cal.add(Calendar.DATE,Calendar.DATE+random.nextInt(30));
        String medicate=""+cal.get(Calendar.YEAR)+"�� "+cal.get(Calendar.MONTH)+"�� "+cal.get(Calendar.DATE)+"��";
		Connection c = null;
	    Statement stmt = null;
	   
	    try {
	      Class.forName("org.sqlite.JDBC") ;
	      c = DriverManager.getConnection("jdbc:sqlite:"+name) ;
	      c.setAutoCommit(false) ;
	      System.out.println("Opened database successfully") ;
	      
	      stmt = c.createStatement() ;
	      String sql = "INSERT INTO CERTIFICATETABLE (ID,KIND,NUMBER,DISEASE,DISEASEDATE,DIGNOSISDATE,MEDICDATE,DATE,HOSPITAL,LOCATION,PHONE,LICENSENUM,NAME) " +
          "VALUES ("+i+",'"
	    		  +kind+"','"
	    		  +DoctorNumber()+"','"
	    		  +Disease[random.nextInt(Disease.length)]+"','"
	    		  +diseasedate+"','"
	    		  +dignosisdate+"','"
	    		  +dignosisdate+"~"+medicate+"','"
	    		  +medicate+"','"
	    		  +hospital+"','"
	    		  +l+"','"
	    		  +getPhone()+"','"
	    		  +random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+"','"
	    		  +FirstName[random.nextInt(33)]+LastName[random.nextInt(835)]
          +"' ) ;"; 
	    		
	      stmt.executeUpdate(sql) ;
	      stmt.close() ;
	      c.commit() ;
	      c.close() ;
	    } catch ( Exception e ) {
	      System.err.println( e.getClass() .getName() + ": " + e.getMessage() );
	      System.exit(0) ;
	    }
	    System.out.println("Records created successfully") ;
	}

	void select(String naming)
	{
		 Connection c = null;
		    Statement stmt = null;
		    try {
		      Class.forName("org.sqlite.JDBC") ;
		      c = DriverManager.getConnection("jdbc:sqlite:"+naming) ;
		      c.setAutoCommit(false) ;
		      System.out.println("Opened database successfully") ;

		      stmt = c.createStatement() ;
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM INFOTABLE;" ) ;
		      while ( rs.next() ) {
		         int id = rs.getInt("id") ;
		         String name = rs.getString("name") ;
		         //int age  = rs.getInt("age") ;
		         //String  address = rs.getString("address") ;
		         //float salary = rs.getFloat("salary") ;
		         System.out.println( "ID = " + id ) ;
		         System.out.println( "NAME = " + name ) ;
		         //System.out.println( "AGE = " + age ) ;
		         //System.out.println( "ADDRESS = " + address ) ;
		         //System.out.println( "SALARY = " + salary ) ;
		         System.out.println() ;
		      }
		      rs.close() ;
		      stmt.close() ;
		      c.close() ;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass() .getName() + ": " + e.getMessage() );
		      System.exit(0) ;
		    }
		    System.out.println("Operation done successfully") ;
	}
	
	public static void main(String[] args) throws IOException {
		String s = "Info.sqlite";
		int i=1000;
		
		insertdata d = new insertdata();
		//d.CreateTable3(s);
		//d.CreateTable2(s);
		//d.CreateDB(s);
		//d.CreateTable(s);
		for(int a=0; a<i; a++)
		{
			d.insert(s, a);
			d.insert2(s, a);
			d.insert3(s,a);  
		}
		//d.select(s);
		//System.out.println(Disease2.length);
		
	}
		  
}
