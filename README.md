# Auth0 Unity Plugin

Auth0 has mobile SDKs for Android and iOS (and many other development platforms/languages). It doesn't
currently have a specific Unity SDK that could target Android and iOS - two frequently targetd
mobile platforms for Unity applications.

So, I've started work on wrapping the offical Auth0 SDks for Android and iOS in a Unity plugin that can
be easily incorporated into Unity applications that need OAuth authentication/authorization using
(Auth0.com)[https://auth0.com]

# Android / Unity

The example Unity application here shows how to use the native Android plugin/wrapper for Auth0.
(Note: link to sources for the plugin will be added here).

This will not function out-of-the-box. There are two files that need to have developer-spcific 
settings filled in. These are:
* Assets/UseAuth0.cs - note the YOUR_CALLBACK_SCHEME and YOUR_AUTH0_API_AUDIENCE placeholders.
* Assets/Plugins/Android/mainTemplate.gradle - note YOUR_AUTH0_DOMAIN and YOUR_CALLBACK_SCHEME placeholders.

Note: Yes, because the current Auth0 SDK for Android makes use of gradle placeholders, the gradle build
will not complete successfully without these. For now, this means having the values in two places in the
code (until we figure out a better way).

# More Info

I'm working on a more detailed HOW-TO article regarding the Unity build settings and the correspnding
Auth0 account settings for the API and application settings to match. Watch this space. I will fill in the
details soon.


