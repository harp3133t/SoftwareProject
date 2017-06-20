using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System.IO;
using UnityEngine.UI;
using Mono.Data.Sqlite;
using System.Data;


public class Info : MonoBehaviour{
    public static int count;
    public static bool ok;
    public static int score;
    public static bool flag=false;
}

public class Bill
{
    public Text Insurace_kind;
    public Text Insurace_Num;
    public Text Insurace_Name;
    public Text Insurace_Number;
    public Text Insurace_Job;
    public Text Insurace_Company;
    public Text Insurace_Work;
    public Text Insurace_Accident_Date;
    public Text Insurace_Accident_Place;
    public Text Insurace_Accident_Why;
    public Text Insurace_Disease_Date;
    public Text Insurace_Disease;
    public Text Insurace_Disease_Why;
    public Text Insurace_Hospital;
    public Text Insurace_Care_Kind;
    public Text Insurace_Care_Date;
    public Text Insurace_Date;
    public Text Insurace_Bill_Location;
    public Text Insurace_Bill_Name;
    public Text Insurace_Bill_Tel;
    public Text Insurace_Bill_Email;
    public Text Insurace_Bill_Phone;
    public Text Insurace_Info_Name;
    public Text Insurace_Info_Num;
    public Text Insurace_Account_Num;
    public Text Insurace_Account_Name;
    public Text Insurace_Account_Money;
    public Text Insurace_Account_Number;
    public Text Insurace_Account_Name2;
    public Text Insurace_Account_Bank;
    public Text Insurace_Account_Player;
    public Text Insurace_Account_Date;
}


public class Data : MonoBehaviour {

    public Text InformationCard_Name;  //환자 이름
    public Text InformationCard_Num;   //환자 주번
    public Text InformationCard_Location; //환자 주소
    public Text InformationCard_Date; //환자 신분증 발급일
    public Text InformationCard_Issue; //환자 신분증 발급처
    //신분증
    public Text Insurace_kind; //환자 청구 종류
    public Text Insurace_Num; //증권번호
    public Text Insurace_Name; //환자 이름
    public Text Insurace_Number; //환자 주번
    public Text Insurace_Job; //환자 직업
    public Text Insurace_Company; //환자 회사
    public Text Insurace_Work; //환자 일
    public Text Insurace_Accident_Date; //환자 사고일
    public Text Insurace_Accident_Place; //환자 사고 장소
    public Text Insurace_Accident_Why; //환자 사고 경위
    public Text Insurace_Disease_Date; //환자 질병일
    public Text Insurace_Disease; //환자 질병
    public Text Insurace_Disease_Why; //환자 질병 경위
    public Text Insurace_Hospital; //환자 과거 병원
    public Text Insurace_Care_Kind; //환자 과거 질병
    public Text Insurace_Care_Date; //환자 과거 질병일
    public Text Insurace_Date;//청구서 발급일
    public Text Insurace_Bill_Location; //환자 주소
    public Text Insurace_Bill_Name;//보호자 이름
    public Text Insurace_Bill_Tel;//보호자 전화번호
    public Text Insurace_Bill_Email;//보호자 이메일
    public Text Insurace_Bill_Phone;//보호자 전화번호
    public Text Insurace_Info_Name;//보호자 이름
    public Text Insurace_Info_Num;//보호자 주민등록번호
    public Text Insurace_Account_Num;//계좌번호
    public Text Insurace_Account_Name;//예금주 이름
    public Text Insurace_Account_Money;//송긍요청액
    public Text Insurace_Account_Number;//예금주 주번
    public Text Insurace_Account_Name2;//예금주 이름
    public Text Insurace_Account_Bank;//예금 은행
    public Text Insurace_Account_Player;//Player 이름
    public Text Insurace_Account_Date;//청구서 발급일
    //청구서
    public Text Certificate_DiseaseNum;
    public Text Certificate_YearNum;
    public Text Certificate_Num;
    public Text Certificate_Location;
    public Text Certificate_Name;
    public Text Certificate_Gender;
    public Text Certificate_Birth;
    public Text Certificate_AGE;
    public Text Certificate_Disease;
    public Text Certificate_DiseaseDate;
    public Text Certificate_MedicDate1;
    public Text Certificate_MedicDate2;
    public Text Certificate_Date;
    public Text Certificate_Hospital;
    public Text Certificate_HospitalLocation;
    public Text Certificate_Phone;
    public Text Certificate_DoctorName;
    public Text Certificate_DoctorNum;
    public Text Certificate_DignosisDate;

    public void Set_InformationCard_Data()
    {
        string conn = "URI=file:" + Application.dataPath + "/Info.sqlite"; //Path to database.
        using (IDbConnection dbconn = (IDbConnection)new SqliteConnection(conn))
        {
            //dbconn = (IDbConnection)new SqliteConnection(conn);
            dbconn.Open(); //Open connection to the database.
            using (IDbCommand dbcmd = dbconn.CreateCommand())
            {
                string sqlQuery = "SELECT ID,NAME,NUM,LOCATION,DATE,ISSUE " + "FROM INFOTABLE Where ID=" + Random.Range(0, 99).ToString();
                dbcmd.CommandText = sqlQuery;
                using (IDataReader reader = dbcmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        //int value = reader.GetInt32(0);
                        //string name = reader.GetString(1);
                        //int rand = reader.GetInt32(2);
                        int id = reader.GetInt32(0);
                        string name = reader.GetString(1);
                        string num = reader.GetString(2);
                        string location = reader.GetString(3);
                        string date = reader.GetString(4);
                        string Issue = reader.GetString(5);


                        InformationCard_Name.GetComponent<Text>().text = name;
                        InformationCard_Num.GetComponent<Text>().text = num;
                        InformationCard_Location.GetComponent<Text>().text = location;
                        InformationCard_Date.GetComponent<Text>().text = date;
                        InformationCard_Issue.GetComponent<Text>().text = Issue;

                        Insurace_Name.GetComponent<Text>().text = name;
                        Insurace_Number.GetComponent<Text>().text = num;
                        Insurace_Bill_Name.GetComponent<Text>().text = name;
                        Insurace_Info_Name.GetComponent<Text>().text = name;
                        Insurace_Info_Num.GetComponent<Text>().text = num;
                        //Insurace_Number.GetComponent<Text>().text = num;
                        Insurace_Account_Name.GetComponent<Text>().text = name;
                        Insurace_Account_Name2.GetComponent<Text>().text = name;
                        //Insurace_Account_Num.GetComponent<Text>().text = num; 계좌
                        Insurace_Account_Number.GetComponent<Text>().text = num;
                        Certificate_Name.GetComponent<Text>().text = name;
                        Certificate_Num.GetComponent<Text>().text = num;
                        Certificate_Location.GetComponent<Text>().text = location;
                        Certificate_Birth.GetComponent<Text>().text = num.Substring(0, 6);
                        if(num.Substring(8,1)=="1" || num.Substring(8,1)=="3")
                        {
                            Certificate_Gender.GetComponent<Text>().text = "남자";
                        }
                        else if (num.Substring(8, 1) == "2" || num.Substring(8, 1) == "4")
                        {
                            Certificate_Gender.GetComponent<Text>().text = "여자";
                        }
                        string a = num.Substring(0, 2);
                        int age=17-System.Int32.Parse(a);
                        if (age < 0) age=100 - Mathf.Abs(age);
                        Certificate_AGE.GetComponent<Text>().text = age.ToString();
                    }

                    reader.Close();
                }
                //reader = null;

                dbcmd.Dispose();
                // dbcmd = null;
            }
            dbconn.Close();
            //dbconn = null;
        }
        Info.flag = true;
    }

    public void Set_CERTIFICATE_Data()
    {
        string conn = "URI=file:" + Application.dataPath + "/Info.sqlite"; //Path to database.
        using (IDbConnection dbconn = (IDbConnection)new SqliteConnection(conn))
        {
            //dbconn = (IDbConnection)new SqliteConnection(conn);
            dbconn.Open(); //Open connection to the database.
            using (IDbCommand dbcmd = dbconn.CreateCommand())
            {
                string sqlQuery = "SELECT ID,KIND,NUMBER,DISEASE,DISEASEDATE,DIGNOSISDATE,MEDICDATE,DATE,HOSPITAL,LOCATION,PHONE,LICENSENUM,NAME " + "FROM CERTIFICATETABLE Where ID=" + Random.Range(0, 99).ToString();
                dbcmd.CommandText = sqlQuery;
                using (IDataReader reader = dbcmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        //int value = reader.GetInt32(0);
                        //string name = reader.GetString(1);
                        //int rand = reader.GetInt32(2);
                        int id = reader.GetInt32(0);
                        string kind = reader.GetString(1);
                        string number = reader.GetString(2);
                        string disease = reader.GetString(3);
                        string diseasedate = reader.GetString(4);
                        string dignosisdate = reader.GetString(5);
                        string medicdate = reader.GetString(6);
                        string date = reader.GetString(7);
                        string hospital = reader.GetString(8);
                        string location = reader.GetString(9);
                        string phone = reader.GetString(10);
                        string licensenum = reader.GetString(11);
                        string name = reader.GetString(12);
                        Insurace_kind.GetComponent<Text>().text = kind;
                        Insurace_Account_Date.GetComponent<Text>().text = date;
                        Certificate_DoctorNum.GetComponent<Text>().text = number;
                        if(kind=="상해")
                        {
                            Insurace_Accident_Why.GetComponent<Text>().text = disease;
                            Insurace_Account_Date.GetComponent<Text>().text = diseasedate;
                        }
                        else if(kind=="질병")
                        {
                            Insurace_Disease.GetComponent<Text>().text = disease;
                            Insurace_Disease_Why.GetComponent<Text>().text = disease;
                            Insurace_Disease_Date.GetComponent<Text>().text = diseasedate;
                        }
                        Certificate_YearNum.GetComponent<Text>().text = number;
                        Certificate_Disease.GetComponent<Text>().text = disease;
                        Certificate_DiseaseDate.GetComponent<Text>().text = diseasedate;
                        Certificate_DignosisDate.GetComponent<Text>().text = dignosisdate;
                        Certificate_MedicDate1.GetComponent<Text>().text = medicdate;
                        Certificate_MedicDate2.GetComponent<Text>().text = medicdate;
                        Certificate_Date.GetComponent<Text>().text = date;
                        Certificate_Hospital.GetComponent<Text>().text = hospital;
                        Certificate_HospitalLocation.GetComponent<Text>().text = location;
                        Certificate_Phone.GetComponent<Text>().text = phone;
                        Certificate_DiseaseNum.GetComponent<Text>().text = licensenum;
                        Certificate_DoctorName.GetComponent<Text>().text = name;
                    }

                    reader.Close();
                }
                //reader = null;

                dbcmd.Dispose();
                // dbcmd = null;
            }
            dbconn.Close();
            //dbconn = null;
        }
    }

    public void Set_BILL_Data()
    {
        string conn = "URI=file:" + Application.dataPath + "/Info.sqlite"; //Path to database.
        using (IDbConnection dbconn = (IDbConnection)new SqliteConnection(conn))
        {
            //dbconn = (IDbConnection)new SqliteConnection(conn);
            dbconn.Open(); //Open connection to the database.
            using (IDbCommand dbcmd = dbconn.CreateCommand())
            {
                string sqlQuery = "SELECT ID,JOB,COMPANY,EMAIL,PHONE,HP,BANK,ACCOUNT " + "FROM BILLTABLE Where ID=" + Random.Range(0, 99).ToString();
                dbcmd.CommandText = sqlQuery;
                using (IDataReader reader = dbcmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        //int value = reader.GetInt32(0);
                        //string name = reader.GetString(1);
                        //int rand = reader.GetInt32(2);
                        int id = reader.GetInt32(0);
                        string job=reader.GetString(1);
                        string company = reader.GetString(2);
                        string email = reader.GetString(3);
                        string phone = reader.GetString(4);
                        string hp = reader.GetString(5);
                        string bank = reader.GetString(6);
                        string account = reader.GetString(7);
                        Insurace_Job.text=job; //환자 직업
                        Insurace_Company.text=company; //환자 회사
                        Insurace_Work.text=job; //환자 일
                        Insurace_Bill_Email.text = email;
                        Insurace_Bill_Phone.text = phone;
                        Insurace_Bill_Tel.text = hp;
                        Insurace_Account_Bank.text = bank;
                        Insurace_Account_Num.text = account;
                        
                    }

                    reader.Close();
                }
                //reader = null;

                dbcmd.Dispose();
                // dbcmd = null;
            }
            dbconn.Close();
            //dbconn = null;
        }
    }
    public void Start()
    {
        Set_InformationCard_Data();
        Set_CERTIFICATE_Data();
        Set_BILL_Data();
    }
    
    
}
