using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System.Diagnostics;
using UnityEngine.UI;


public class Commu : MonoBehaviour {
    public Text text,text2;

    public bool ok;
    public string[] commu = new string[30];

    void Output(string daehwa)
    {
        text.GetComponent<Text>().text += daehwa + "\n";
    }

    public void setyes()
    {
        ok = true;
        Output(commu[2]);
        Output(commu[4]);
    }

    public void setno()
    {
        ok = false;
        Output(commu[3]);
        Output(commu[5]);
    }

    public void getWhy()
    {
        if (text2.GetComponent<Text>().text == "불일치")
        {
            Output(commu[6]);
            Output(commu[7]);
        }
    }

    public void Reset()
    {
        text.GetComponent<Text>().text = "";
        text2.GetComponent<Text>().text = "승인여부";
        Output(commu[0]);
        Output(commu[1]);
    }

    void Start()
    {
        ok = false;
        commu.SetValue("나:안녕하세요 고객님 무엇을 도와드릴까요?", 0);
        commu.SetValue("고객:네 저번에 보험금 지급 신청했는데 받을수 있을까요?", 1);
        commu.SetValue("나:예 고객님께 보험금지급 승인해드릴께요", 2);
        commu.SetValue("나:아니오 고객님께선 보험금을 지급받으실수 없습니다.", 3);
        commu.SetValue("고객:네 수고하세요",4);
        commu.SetValue("고객:왜 못받죠?", 5);
        commu.SetValue("나:제출하신 서류와 신분증의 정보가 다릅니다. 보험금지급을 승인하지않겠습니다.", 6);
        commu.SetValue("고객:어이가 없군요. 민원을 넣겠어요 그럼 이만", 7);

        Output(commu[0]);
        Output(commu[1]);/*
        if (ok == true)
        {
            Output(commu[2]);
            Output(commu[4]);
        }
        else if (ok == false)
        {
            Output(commu[3]);
            Output(commu[5]);
        }
        */

    }
}
