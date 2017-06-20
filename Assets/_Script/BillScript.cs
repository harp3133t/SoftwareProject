using System.Collections;
using System.Collections.Generic;
using System.IO;
using UnityEngine;
using UnityEngine.UI;
using Mono.Data.Sqlite;
using System.Data;


public class BillScript : MonoBehaviour {
    public int id;
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

    public void setIntData(int s)
    {
        id = s;
    }

    public void setStringData(string[] s)
    {
        // data[c] = s;
        
        Insurace_kind.GetComponent<Text>().text = s[1];
        Insurace_Num.GetComponent<Text>().text=s[2];
        Insurace_Name.GetComponent<Text>().text=s[3];
        Insurace_Number.GetComponent<Text>().text=s[4];
        Insurace_Job.GetComponent<Text>().text=s[5];
        Insurace_Company.GetComponent<Text>().text=s[6];
        Insurace_Work.GetComponent<Text>().text=s[7];
        Insurace_Accident_Date.GetComponent<Text>().text = s[8];
        Insurace_Accident_Place.GetComponent<Text>().text = s[9];
        Insurace_Accident_Why.GetComponent<Text>().text = s[10];
        Insurace_Disease_Date.GetComponent<Text>().text = s[11];
        Insurace_Disease.GetComponent<Text>().text = s[12];
        Insurace_Disease_Why.GetComponent<Text>().text = s[13];
        Insurace_Hospital.GetComponent<Text>().text = s[14];
        Insurace_Care_Kind.GetComponent<Text>().text = s[15];
        Insurace_Care_Date.GetComponent<Text>().text = s[16];
        Insurace_Date.GetComponent<Text>().text = s[17];
        Insurace_Bill_Location.GetComponent<Text>().text = s[18];
        Insurace_Bill_Name.GetComponent<Text>().text = s[19];
        Insurace_Bill_Tel.GetComponent<Text>().text = s[20];
        Insurace_Bill_Email.GetComponent<Text>().text = s[21];
        Insurace_Bill_Phone.GetComponent<Text>().text = s[22];
        Insurace_Info_Name.GetComponent<Text>().text = s[23];
        Insurace_Info_Num.GetComponent<Text>().text = s[24];
        Insurace_Account_Num.GetComponent<Text>().text = s[25];
        Insurace_Account_Name.GetComponent<Text>().text = s[26];
        Insurace_Account_Money.GetComponent<Text>().text = s[27];
        Insurace_Account_Number.GetComponent<Text>().text = s[28];
        Insurace_Account_Name2.GetComponent<Text>().text = s[29];
        Insurace_Account_Bank.GetComponent<Text>().text = s[30];
       }

    public void Start()
    {
        //if(Info.flag==true)
        int a = Random.Range(0, 99);
             //setBillData(a);
    }
    public void setBillData(int index)
    {
        
        string conn = "URI=file:" + Application.dataPath + "/Info.sqlite"; //Path to database.
        using (IDbConnection dbconn = (IDbConnection)new SqliteConnection(conn))
        {
            //     dbconn = (IDbConnection)new SqliteConnection(conn);
            dbconn.Open(); //Open connection to the database.
            using (IDbCommand dbcmd = dbconn.CreateCommand())
            {
                string[] s = new string[31];
                string sqlQuery = "SELECT * " + "FROM BillTable WHERE ID="+index.ToString();
                dbcmd.CommandText = sqlQuery;
                using (IDataReader reader = dbcmd.ExecuteReader())
                {
                    s[0] = "start";
                    while (reader.Read())
                    {
                        setIntData(reader.GetInt32(0));

                        for (int i = 1; i < 31; i++)
                        {
                           
                            s[i] = reader.GetString(i);
                            //Debug.Log(s[i]);
                        }
                        //setStringData(s);
                    }
                    Insurace_kind.GetComponent<Text>().text = s[1];
                    Insurace_Num.GetComponent<Text>().text = s[2];
                    Insurace_Name.GetComponent<Text>().text = s[3];
                    Insurace_Number.GetComponent<Text>().text = s[4];
                    Insurace_Job.GetComponent<Text>().text = s[5];
                    Insurace_Company.GetComponent<Text>().text = s[6];
                    Insurace_Work.GetComponent<Text>().text = s[7];
                    Insurace_Accident_Date.GetComponent<Text>().text = s[8];
                    Insurace_Accident_Place.GetComponent<Text>().text = s[9];
                    Insurace_Accident_Why.GetComponent<Text>().text = s[10];
                    Insurace_Disease_Date.GetComponent<Text>().text = s[11];
                    Insurace_Disease.GetComponent<Text>().text = s[12];
                    Insurace_Disease_Why.GetComponent<Text>().text = s[13];
                    /*Insurace_Hospital.GetComponent<Text>().text = s[14];
                    Insurace_Care_Kind.GetComponent<Text>().text = s[15];
                    Insurace_Care_Date.GetComponent<Text>().text = s[16];
                    Insurace_Date.GetComponent<Text>().text = s[17];
                    Insurace_Bill_Location.GetComponent<Text>().text = s[18];
                    Insurace_Bill_Name.GetComponent<Text>().text = s[19];
                    Insurace_Bill_Tel.GetComponent<Text>().text = s[20];
                    Insurace_Bill_Email.GetComponent<Text>().text = s[21];
                    Insurace_Bill_Phone.GetComponent<Text>().text = s[22];
                    Insurace_Info_Name.GetComponent<Text>().text = s[23];
                    Insurace_Info_Num.GetComponent<Text>().text = s[24];
                    Insurace_Account_Num.GetComponent<Text>().text = s[25];
                    Insurace_Account_Name.GetComponent<Text>().text = s[26];
                    Insurace_Account_Money.GetComponent<Text>().text = s[27];
                    Insurace_Account_Number.GetComponent<Text>().text = s[28];
                    Insurace_Account_Name2.GetComponent<Text>().text = s[29];
                    Insurace_Account_Bank.GetComponent<Text>().text = s[30];*/
                    reader.Close();
                 //   reader = null;
                }
                dbcmd.Dispose();
               // dbcmd = null;
            }
            dbconn.Close();
           // dbconn = null;
        }

    }
}
