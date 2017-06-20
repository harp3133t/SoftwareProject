using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;
public class Timer : MonoBehaviour {
    public float timer;
    public Text TimerText;
	// Use this for initialization
	void Start () {
        timer = 0;
	}
	
	// Update is called once per frame
	void Update () {
        timer += Time.deltaTime;
        TimerText.text = timer.ToString();

        if(timer==(float)20.0)
        {
            SceneManager.LoadScene("Main");
        }
	}
}
