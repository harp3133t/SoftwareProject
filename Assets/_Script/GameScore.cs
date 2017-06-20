using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class GameScore : MonoBehaviour {
    public Text scoreText;
    public GameObject DataController;
    public GameObject Communication;
    //public Object DataController;
    public void addScore()
    {
        if(Info.ok==true)
        {
            Info.score += 100;
            scoreText.GetComponent<Text>().text = Info.score.ToString();
            //GameObject.Find("DataController").SendMessage("Start");
            DataController.GetComponent<Data>().Start();
            Communication.GetComponent<Commu>().Reset();
        }
        else if (Info.ok==false)
        {
            Info.score -= 100;
            scoreText.GetComponent<Text>().text = Info.score.ToString();
            //GameObject.Find("DataController").SendMessage("Start");
            DataController.GetComponent<Data>().Start();
            Communication.GetComponent<Commu>().Reset();
        }
    }

    public void subScore()
    {
        if (Info.ok == false)
        {
            Info.score += 100;
            scoreText.GetComponent<Text>().text = Info.score.ToString();
            DataController.GetComponent<Data>().Start();
            Communication.GetComponent<Commu>().Reset();
        }
        else if (Info.ok == true)
        {
            Info.score -= 100;
            scoreText.GetComponent<Text>().text = Info.score.ToString();
            DataController.GetComponent<Data>().Start();
            Communication.GetComponent<Commu>().Reset();
        }
    }
}
