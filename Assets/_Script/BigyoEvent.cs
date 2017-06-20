using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.EventSystems;
using UnityEngine.UI;

public class BigyoEvent : MonoBehaviour {
	public static string[] bigyo=new string[2];
    public Text myText;
    public Text myText2;
	// Use this for initialization
	public void Bigyo () {
        if (Info.count==0)
        {
            Info.ok = false;
            bigyo[Info.count] = myText.GetComponent<Text>().text;
            Debug.Log(bigyo[Info.count].ToString());
            Info.count++;
        }
        else if (Info.count==1)
        {
            bigyo[Info.count] = myText.GetComponent<Text>().text;
            if (bigyo[0].ToString() == bigyo[1].ToString())
            {
                Info.ok = true;
                Debug.Log("OK");
                myText2.GetComponent<Text>().text = "일치";
                Debug.Log(bigyo[0].ToString());
                Debug.Log(bigyo[1].ToString());
                bigyo[0] = null;
                bigyo[1] = null;
                Info.count = 0;
                
            }
            else if(bigyo[0].ToString() != bigyo[1].ToString())
            {
                Info.ok = false;
                Debug.Log("No!");
                myText2.GetComponent<Text>().text = "불일치";
                Debug.Log(bigyo[0].ToString());
                Debug.Log(bigyo[1].ToString());
                bigyo[0] = null;
                bigyo[1] = null;
                Info.count = 0;
            }
        }
	}
}
