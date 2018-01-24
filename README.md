user-agent-utils
================

Utilities for processing user-agent strings. Can be used to handle http requests in real-time or to analyze log files.

http://www.bitwalker.eu/software/user-agent-utils

For the latest release, go to
https://github.com/HaraldWalker/user-agent-utils/tree/master

EOL WARNING
-----------
This library has reached end-of-life and will not see regular updates any longer.

Version 1.21 was the last official release in 2018.
  
Pull request with significant feature changes will not get processed.  

If you want to improve this library, fork it and release it yourself.  

As alternative have a look at the Browscap project and its implementations.  
https://github.com/HaraldWalker/user-agent-utils  

User-agent-utils needed your support
------------------------------------
If you used this library for a commercial product, a donation would have been great during the past years.   
 
<a href="http://flattr.com/thing/1968218/HaraldWalkeruser-agent-utils-on-GitHub" target="_blank"><img src="http://api.flattr.com/button/flattr-badge-large.png" alt="Flattr this" title="Flattr this" border="0" /></a>

Advice
------
A lot of user-agents lie about their identity. That makes UA sniffing a guessing game. On websites it is a better approach to detect features using a javascript library like Modernizr (http://modernizr.com/).  

Instead of using browser switches, build sites and services that are cross-platform/cross-device compatible.       

New in Version 1.21 
-------------------
- Added current and future Chrome, Firefox, Safari, Edge versions
- Updated Android and iOS detection
- Added Tizen as operating system including detection of smart TVs
- Added detection of linux based smart TVs
- Added additional bot detection 

Javadoc
-------
http://bitwalker.eu/user-agent-utils-snapshot/javadoc/index.html

Maven
-----

Add dependency:
```xml
<dependency>
   <groupId>eu.bitwalker</groupId>
   <artifactId>UserAgentUtils</artifactId>
   <version>1.21</version>
</dependency>
```

Add dependency for snapshot releases:
```xml
<dependency>
   <groupId>eu.bitwalker</groupId>
   <artifactId>UserAgentUtils</artifactId>
   <version>1.22-SNAPSHOT</version>
</dependency>
```

Contributors
------------
* This project is NOT accepting any new contributions.  
* If you want changes, feel free to fork this project and start your own version. Send me a link and I'll be happy to promote it.  
* Code has been contributed by: Nathan Maves, Francisco Collao (https://github.com/pcollaog), Madgency (https://github.com/guignol), Pavel Sher (https://github.com/pavelsher), Pierre Etchemaite, Alexander Radzin (https://github.com/alexradzin), SeabassNg (https://github.com/SeabassNg), Sudeep Sinha (https://github.com/sudeep-sinha), John Dydo, frankdev (https://github.com/frankdev), Lew Dawson, Joachim Mueller (https://github.com/joachimmueller), Jason Calabrese (https://github.com/jasoncalabrese), Thorsten Schaefer, Parker Seidel (https://github.com/parker), Joris Aerts (https://github.com/JorisAerts), Stephan Heffner, Filipe Névola (https://github.com/filipenevola), John Patrick (https://github.com/nhojpatrick), Konrad Kubacki (https://github.com/konradkg), Vipul Delwadia (https://github.com/vipuldelwadia) and more. A BIG thank you to all of them!


FAQ
---

_Can I add new browsers or operating systems?_  
Unfortunately not directly. This library uses enums to represent browsers and operating systems to make using it easy and readable. Unfortunately the use of enums also has some disadvantages. You can make a pull request on trunk for a new browser or operating system if all tests are still passing. The purpose of this library is not to detect every possible version, so you’ll have to provide the business value for a change.

_Where can I report bugs or make feature requests_  
Go to https://github.com/HaraldWalker/user-agent-utils/issues

_How can I improve the performance of the user-agent parsing?_  
When handling requests on a web-server, consider if you need both the browser and operating system or if one of the two gives you enough information. As the parsing uses an ordered tree structure, performance depends a lot on the type of clients making the requests. The most common browsers and operating systems will be parsed faster than exotic ones. Consider caching the results temporarily.

_Are there other libraries like this?_  
When I started this project in 2010 there were no other libraries offering the features I was looking for. Currently there are both open source as well as commercial solutions.

Contact
-------
http://www.bitwalker.eu/contact  

Changelog
---------
1.20 
----
- #142 Fix iPhone detection in case of Opera Mini agent-string 
- #154 Prevent bots with bot in UA-String from pretending to be Safari
- Added latest Edge versions
- Added current and future Chrome and Firefox versions 
- #152 improved version discovery specifically for Safari
- #146 Fixed IE mobile 11 version detection

1.19
----
- #138 Improved future Microsoft Edge detection and added  Edge 13
- Added current and future Firefox and Chrome versions
- Improved detection of unsuported new Firefox versions
- Added detection of Firefox mobile for iOS devices
- Improved Phantom.js detection as BOT
- Added support for Android 6 and Android 6 tablets 

1.18
----
- #118 Updated Opera support
- #115 Improved Ubuntu detection
- #114 Fixed Microsoft Edge version detection
- #125 Improved Opera version detection
- Safari 9 support

1.17
----
- Added Ubuntu and Ubuntu Touch (mobile) detection  
- Added Windows 10 mobile detection  
- Added Microsoft Edge browser detection (contributed by https://github.com/nmaves)  
- Added future Firefox versions up to 42.

1.16
----
- iOS 8.2, 8.3, 8.4 and 9 added
- Chrome updated with latest versions
- Firefox updated with latest versions 
- Updated Opera browser detection
- Xbox OS and Internet Explorer for Xbox added  
- Improved CFNETWORK browser detection 
- Added Vivaldi browser
- Improved Windows 10 detection
- Improved bot detection
- Added Android 5 tablet detection
- Performance improvements

1.15
----
- Safari 7 and 8 added
- iOS 8.1 added
- Wearable device category added with detection of Google Glass
- Chrome OS added
- Windows 10 added
- Android 5 added

1.14
----
- IOS8 support added  
- added Opera Coast as new mobile browser  
- more Chrome and Firefox versions added, including future releases (up to Firefox 40 and Chrome 40)
- added 3 Opera versions  
- performance improvements

1.13  
----  
* Added additional Chrome and Opera browser versions
* Added current and future Firefox versons
* Added agent string handling for Microsoft RSS platform user-agents
* Added detection of Windows Phone 8.1 and IE Mobile 11.
* Fixed null pointer exception when user-agent-string was null
* Adjusted IE11 regex to match IE11 on Win8 


1.12
----
* Fix for version detection of Internet Explorer 11, contributed by https://github.com/parker
* Browser versions are now comparable (#33), contributed by https://github.com/reindyr
* Detect image proxy used by Google for Gmail
* Detect Google's mobile bot (#8)
* Internet Explorer 10 mobile version added (#28)
* Improved Chrome mobile detection (#30)

1.11
----

* Fixed none unique manufacturer id (issue #22)
* added IOS 7 detection and improved IOS detection for iPads (issue #21)
* added Chrome 30 and 31

1.10
----

* Fixed and extended OS and browser detection when using Firefox on mobiles or tablets
* Added additional and future Firefox versions
* Added Chrome 29
* Added Opera 11, 12, 15 & 16 
 
1.9
---

* Fixed version detection of Chrome Mobile
* Added Firefox 20 detection plus beta and future versions
* Added beta and future versions of Chrome

1.8
---

* Option just to check just for a given collection of browsers or operating systems
* Updated Chrome, Firefox and Safari detection to include the latest versions
* Minor code optimizations
* The package name has changed. Update import statements if you've been using the library before! 

