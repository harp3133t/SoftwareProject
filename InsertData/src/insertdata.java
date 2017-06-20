
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
        	"서울특별시 종로구"
        	,"서울특별시 중구"
        	,"서울특별시 용산구"
        	,"서울특별시 성동구"
        	,"서울특별시 광진구"
        	,"서울특별시 동대문구"
        	,"서울특별시 중랑구"
        	,"서울특별시 성북구"
        	,"서울특별시 강북구"
        	,"서울특별시 도봉구"
        	,"서울특별시 노원구"
        	,"서울특별시 은평구"
        	,"서울특별시 서대문구"
        	,"서울특별시 마포구"
        	,"서울특별시 양천구"
        	,"서울특별시 강서구"
        	,"서울특별시 구로구"
        	,"서울특별시 금천구"
        	,"서울특별시 영등포구"
        	,"서울특별시 동작구"
        	,"서울특별시 관악구"
        	,"서울특별시 서초구"
        	,"서울특별시 강남구"
        	,"서울특별시 송파구"
        	,"서울특별시 강동구"
        	,"부산광역시 중구"
        	,"부산광역시 서구"
        	,"부산광역시 동구"
        	,"부산광역시 영도구"
        	,"부산광역시 부산진구"
        	,"부산광역시 동래구"
        	,"부산광역시 남구"
        	,"부산광역시 북구"
        	,"부산광역시 해운대구"
        	,"부산광역시 사하구"
        	,"부산광역시 금정구"
        	,"부산광역시 강서구"
        	,"부산광역시 연제구"
        	,"부산광역시 수영구"
        	,"부산광역시 사상구"
        	,"부산광역시 기장군"
        	,"울산광역시 중구"
        	,"울산광역시 남구"
        	,"울산광역시 동구"
        	,"울산광역시 북구"
        	,"울산광역시 울주군"
        	,"대구광역시 중구"
        	,"대구광역시 동구"
        	,"대구광역시 서구"
        	,"대구광역시 남구"
        	,"대구광역시 북구"
        	,"대구광역시 수성구"
        	,"대구광역시 달서구"
        	,"대구광역시 달성군"
        	,"광주광역시 동구"
        	,"광주광역시 서구"
        	,"광주광역시 남구"
        	,"광주광역시 북구"
        	,"광주광역시 광산구"
        	,"인천광역시 중구"
        	,"인천광역시 동구"
        	,"인천광역시 남구"
        	,"인천광역시 연수구"
        	,"인천광역시 남동구"
        	,"인천광역시 부평구"
        	,"인천광역시 계양구"
        	,"인천광역시 서구"
        	,"인천광역시 강화군"
        	,"인천광역시 옹진군"
        	,"대전광역시 동구"
        	,"대전광역시 중구"
        	,"대전광역시 서구"
        	,"대전광역시 유성구"
        	,"대전광역시 대덕구"
        	,"세종특별자치시 반곡동"
        	,"세종특별자치시 소담동"
        	,"세종특별자치시 보람동"
        	,"세종특별자치시 대평동"
        	,"세종특별자치시 가람동"
        	,"세종특별자치시 한솔동"
        	,"세종특별자치시 나성동"
        	,"세종특별자치시 새롬동"
        	,"세종특별자치시 다정동"
        	,"세종특별자치시 어진동"
        	,"세종특별자치시 종촌동"
        	,"세종특별자치시 고운동"
        	,"세종특별자치시 아름동"
        	,"세종특별자치시 도담동"
        	,"세종특별자치시 조치원읍"
        	,"세종특별자치시 연기면"
        	,"세종특별자치시 연동면"
        	,"세종특별자치시 부강면"
        	,"세종특별자치시 금남면"
        	,"세종특별자치시 장군면"
        	,"세종특별자치시 연서면"
        	,"세종특별자치시 전의면"
        	,"세종특별자치시 전동면"
        	,"세종특별자치시 소정면"
        	,"제주특별자치도 제주시"
        	,"제주특별자치도 서귀포시"
        	,"경기도 수원시 장안구"
        	,"경기도 수원시 권선구"
        	,"경기도 수원시 팔달구"
        	,"경기도 수원시 영통구"
        	,"경기도 성남시 수정구"
        	,"경기도 성남시 중원구"
        	,"경기도 성남시 분당구"
        	,"경기도 의정부시"
        	,"경기도 안양시 만안구"
        	,"경기도 안양시 동안구"
        	,"경기도 부천시"
        	,"경기도 광명시"
        	,"경기도 평택시"
        	,"경기도 동두천시"
        	,"경기도 안산시 상록구"
        	,"경기도 안산시 단원구"
        	,"경기도 고양시 덕양구"
        	,"경기도 고양시 일산동구"
        	,"경기도 고양시 일산서구"
        	,"경기도 과천시"
        	,"경기도 구리시"
        	,"경기도 남양주시"
        	,"경기도 오산시"
        	,"경기도 시흥시"
        	,"경기도 군포시"
        	,"경기도 의왕시"
        	,"경기도 하남시"
        	,"경기도 용인시 처인구"
        	,"경기도 용인시 기흥구"
        	,"경기도 용인시 수지구"
        	,"경기도 파주시"
        	,"경기도 이천시"
        	,"경기도 안성시"
        	,"경기도 김포시"
        	,"경기도 화성시"
        	,"경기도 광주시"
        	,"경기도 양주시"
        	,"경기도 포천시"
        	,"경기도 여주시"
        	,"경기도 연천군"
        	,"경기도 가평군"
        	,"경기도 양평군"
        	,"강원도 춘천시"
        	,"강원도 원주시"
        	,"강원도 강릉시"
        	,"강원도 동해시"
        	,"강원도 태백시"
        	,"강원도 속초시"
        	,"강원도 삼척시"
        	,"강원도 홍천군"
        	,"강원도 횡성군"
        	,"강원도 영월군"
        	,"강원도 평창군"
        	,"강원도 정선군"
        	,"강원도 철원군"
        	,"강원도 화천군"
        	,"강원도 양구군"
        	,"강원도 인제군"
        	,"강원도 고성군"
        	,"강원도 양양군"
        	,"충청북도 청주시 상당구"
        	,"충청북도 청주시 서원구"
        	,"충청북도 청주시 흥덕구"
        	,"충청북도 청주시 청원구"
        	,"충청북도 충주시"
        	,"충청북도 제천시"
        	,"충청북도 보은군"
        	,"충청북도 옥천군"
        	,"충청북도 영동군"
        	,"충청북도 증평군"
        	,"충청북도 진천군"
        	,"충청북도 괴산군"
        	,"충청북도 음성군"
        	,"충청북도 단양군"
        	,"충청남도 천안시 동남구"
        	,"충청남도 천안시 서북구"
        	,"충청남도 공주시"
        	,"충청남도 보령시"
        	,"충청남도 아산시"
        	,"충청남도 서산시"
        	,"충청남도 논산시"
        	,"충청남도 계룡시"
        	,"충청남도 당진시"
        	,"충청남도 금산군"
        	,"충청남도 부여군"
        	,"충청남도 서천군"
        	,"충청남도 청양군"
        	,"충청남도 홍성군"
        	,"충청남도 예산군"
        	,"충청남도 태안군"
        	,"전라북도 전주시 완산구"
        	,"전라북도 전주시 덕진구"
        	,"전라북도 군산시"
        	,"전라북도 익산시"
        	,"전라북도 정읍시"
        	,"전라북도 남원시"
        	,"전라북도 김제시"
        	,"전라북도 완주군"
        	,"전라북도 진안군"
        	,"전라북도 무주군"
        	,"전라북도 장수군"
        	,"전라북도 임실군"
        	,"전라북도 순창군"
        	,"전라북도 고창군"
        	,"전라북도 부안군"
        	,"전라남도 목포시"
        	,"전라남도 여수시"
        	,"전라남도 순천시"
        	,"전라남도 나주시"
        	,"전라남도 광양시"
        	,"전라남도 담양군"
        	,"전라남도 곡성군"
        	,"전라남도 구례군"
        	,"전라남도 고흥군"
        	,"전라남도 보성군"
        	,"전라남도 화순군"
        	,"전라남도 장흥군"
        	,"전라남도 강진군"
        	,"전라남도 해남군"
        	,"전라남도 영암군"
        	,"전라남도 무안군"
        	,"전라남도 함평군"
        	,"전라남도 영광군"
        	,"전라남도 장성군"
        	,"전라남도 완도군"
        	,"전라남도 진도군"
        	,"전라남도 신안군"
        	,"경상북도 포항시 남구"
        	,"경상북도 포항시 북구"
        	,"경상북도 경주시"
        	,"경상북도 김천시"
        	,"경상북도 안동시"
        	,"경상북도 구미시"
        	,"경상북도 영주시"
        	,"경상북도 영천시"
        	,"경상북도 상주시"
        	,"경상북도 문경시"
        	,"경상북도 경산시"
        	,"경상북도 군위군"
        	,"경상북도 의성군"
        	,"경상북도 청송군"
        	,"경상북도 영양군"
        	,"경상북도 영덕군"
        	,"경상북도 청도군"
        	,"경상북도 고령군"
        	,"경상북도 성주군"
        	,"경상북도 칠곡군"
        	,"경상북도 예천군"
        	,"경상북도 봉화군"
        	,"경상북도 울진군"
        	,"경상북도 울릉군"
        	,"경상남도 창원시 의창구"
        	,"경상남도 창원시 성산구"
        	,"경상남도 창원시 마산합포구"
        	,"경상남도 창원시 마산회원구"
        	,"경상남도 창원시 진해구"
        	,"경상남도 진주시"
        	,"경상남도 통영시"
        	,"경상남도 사천시"
        	,"경상남도 김해시"
        	,"경상남도 밀양시"
        	,"경상남도 거제시"
        	,"경상남도 양산시"
        	,"경상남도 의령군"
        	,"경상남도 함안군"
        	,"경상남도 창녕군"
        	,"경상남도 고성군"
        	,"경상남도 남해군"
        	,"경상남도 하동군"
        	,"경상남도 산청군"
        	,"경상남도 함양군"
        	,"경상남도 거창군"
        	,"경상남도 합천군"
        };
	private static final String FILE_NAME = "이름.txt"; 
	
	private static final String[] Disease1=
		{
				"요추 염좌",
				"요추 골절",
				"발 염좌",
				"발 골절",
				"발목 염좌",
				"발목 골절",
				"손 염좌",
				"손 골절",
				"손목 염좌",
				"손목 골절",
				"경추 염좌",
				"경추 골절"
		};
	private static final String[] Disease2=
		{
			"디스크",
			"관절염",
			"감기",
			"암",
			"양성종양"
		};
	
	private static final String[] Hospital=
		{
			"1차병원",
			"2차병원",
			"삼성창원병원",
			"창원경상대학교병원",
			"칠곡경북대학교병원",
			"을지대학교병원",
			"건양대학교병원",
			"대전성모병원",
			"상계백병원",
			"서울백병원",
			"일산백병원",
			"해운대백병원",
			"여의도성모병원",
			"강남차병원",
			"분당차병원",
			"구미차병원",
			"한양대학교 구리병원",
			"강동경희대학교병원",
			"건국대학교 충주병원",
			"순천향대학교 서울병원",
			"국립암센터",
			"순천향대학교 구미병원",
			"동국대학교 일산병원",
			"동국대학교 경주병원",
			"강릉아산병원",
			"한림대학교 강남성심병원",
			"한림대학교 춘천성심병원",
			"보라매병원",
			"을지병원",
			"강원대학교병원",
			"제주대학교병원",
			"가톨릭관동대학교 국제성모병원",
			"양산부산대학교병원",
			"울산대학교병원"};
	
	private static final String[] FirstPhone={
			
	};
	private static final String[] Kind=
		{
				"상해",
				"질병"
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
	                   " KIND          TEXT     NOT NULL, " +  //상해,질병 
	                   " NUMBER        TEXT     NOT NULL, " +   //연번호 12-XXXXXXX
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
	    String[] FirstName={"김","이","최","박","송",
	    		"안","임","정","강","서","신","조","차","윤","류","유","장",
	    		"권","양","문","황","고","오","한","진","심","홍","왕","도","백","민","허","표"};
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
	    		  +FirstName[random.nextInt(33)]+LastName[random.nextInt(835)]+ "','"//이름
	                   		//+random.nextInt(100)+(random.nextInt(12)+1)+(random.nextInt(30)+1)
	                   		+birth+"',"
	                   		+ " '"+l+"',"
	                   		+ " '"+th+birth.charAt(0)+birth.charAt(1)+"년"+birth.charAt(2)+birth.charAt(3)+"월"+birth.charAt(4)+birth.charAt(5)+"일"+ "',"
	                   		+ "'"+l+"청' ) ;"; 
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
	    String[] job={"학생","직장인","어부","농부","없음","자영업","선장"};
	    String[] company={"회사","학교","병원","가게","관공서"};
	    
	    
	    
	    String[] bank={"농협","신협","신한","국민","우리","기업","우체국","하나","외환","대구"};
	    
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
	    String[] FirstName={"김","이","최","박","송",
	    		"안","임","정","강","서","신","조","차","윤","류","유","장",
	    		"권","양","문","황","고","오","한","진","심","홍","왕","도","백","민","허","표"};
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
        if(kind=="상해")Disease=Disease1;
        else if(kind=="질병") Disease=Disease2;
        String hospital = Hospital[random.nextInt(Hospital.length)];
        
        
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, random.nextInt(7)+2010);
        cal.set(Calendar.MONTH,random.nextInt(12)+1);
        cal.set(Calendar.DATE,random.nextInt(31)+1);
        String diseasedate=""+cal.get(Calendar.YEAR)+"년 "+cal.get(Calendar.MONTH)+"월 "+cal.get(Calendar.DATE)+"일";
        cal.add(Calendar.DATE,Calendar.DATE+random.nextInt(21));
        String dignosisdate=""+cal.get(Calendar.YEAR)+"년 "+cal.get(Calendar.MONTH)+"월 "+cal.get(Calendar.DATE)+"일";
        cal.add(Calendar.DATE,Calendar.DATE+random.nextInt(30));
        String medicate=""+cal.get(Calendar.YEAR)+"년 "+cal.get(Calendar.MONTH)+"월 "+cal.get(Calendar.DATE)+"일";
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
