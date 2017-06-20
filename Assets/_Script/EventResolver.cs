using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class EventResolver : MonoBehaviour {
    public Text mytext;
	// Use this for initialization
	void Start () {
		if(Info.ok==true)
        {
            mytext.GetComponent<Text>().text = "일치";
        }
        else if (Info.ok==false)
        {
            mytext.GetComponent<Text>().text = "불일치";
        }
	}
	
	// Update is called once per frame
	void Update () {
		
	}
}
