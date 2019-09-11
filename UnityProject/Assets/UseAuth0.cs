using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class UseAuth0 : MonoBehaviour
{
    public InputField message;
    public Text userName;
    public Text userEmail;
    public Text userId;

    private AndroidJavaClass auth0Helper;
    private AndroidJavaClass player;

    private void Start()
    {
        auth0Helper = new AndroidJavaClass("com.limpidfox.unityplugin.UnityAuth0Helper");
        player = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
        auth0Helper.CallStatic("init",
            "YOUR_CALLBACK_SCHEME",
            player.GetStatic<AndroidJavaObject>("currentActivity")
        );

    }

    public void Login()
    {
        auth0Helper.CallStatic("login", "YOUR_AUTH0_API_AUDIENCE");
    }

    public void Logout()
    {
        auth0Helper.CallStatic("logout");
    }

    public void Call()
    {
        message.text = auth0Helper.GetStatic<string>("returnValue");
        userEmail.text = auth0Helper.GetStatic<string>("userEmail");
        userName.text = auth0Helper.GetStatic<string>("userName");
        userId.text = auth0Helper.GetStatic<string>("userId");
    }
}
