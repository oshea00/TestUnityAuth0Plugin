# Auth0 Unity Plugin

Auth0 has mobile SDKs for Android and iOS (and many other development platforms/languages). It doesn't
currently have a specific Unity SDK that could target Android and iOS - two frequently targetd
mobile platforms for Unity applications.

So, I've started work on wrapping the offical Auth0 SDks for Android and iOS in a Unity plugin that can
be easily incorporated into Unity applications that need OAuth authentication/authorization using
[Auth0.com](https://auth0.com)

# Android / Unity

The example Unity application here shows how to use the native Android plugin/wrapper for Auth0.

This will not function out-of-the-box. There are two files that need to have developer-specific 
settings filled in. These are:
* Assets/UseAuth0.cs - note the YOUR_CALLBACK_SCHEME and YOUR_AUTH0_API_AUDIENCE placeholders.
* Assets/Plugins/Android/mainTemplate.gradle - note YOUR_AUTH0_DOMAIN and YOUR_CALLBACK_SCHEME placeholders.

Note: Because the current Auth0 SDK for Android makes use of gradle placeholders, the gradle build
will not complete successfully without these. For now, this means having the values in two places in the
code (until we figure out a better way).

# Android / Unity Plugin

The UnityLib folder contains the Android Studio project for the Unity Android Plugin which wraps
the auth0 Android SDK.

This requires developer-specific changes to the following:
* UnityLib/unityplugin/build.gradle - replace values in "manifestPlaceholders" to match your Auth0 setup/profile.
(see Note above - the placeholders are required for the plugin build to succeed)

Once built, the resulting aar file can be copied into the Unity project Assets/Plugin/Android folder.

# More Info

I'm working on a more detailed HOW-TO article regarding the Unity build settings and the corresponding
Auth0 account settings for the API and application settings to match. Watch this space. I will fill in the
details soon.

## License

MIT

## Suggested Attribution
This work is by Mike O'Shea [@oshea00](https://twitter.com/oshea00)
oshea00@gmail.com
[www.th2code.com](https://www.th2code.com)






