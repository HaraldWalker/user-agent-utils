user-agent-utils
================

Utilities for processing user-agent strings. Can be used to handle http requests in real-time or to analyze log files.

http://www.bitwalker.eu/software/user-agent-utils

For the latest release, go to
https://github.com/HaraldWalker/user-agent-utils/tree/master

Support me and buy me a beer:  
<a href="http://flattr.com/thing/1968218/HaraldWalkeruser-agent-utils-on-GitHub" target="_blank"><img src="http://api.flattr.com/button/flattr-badge-large.png" alt="Flattr this" title="Flattr this" border="0" /></a>

Advice
------
A lot of user-agents lie about their identify. That makes US sniffing a guessing game. On websites it is a better approach to detect features using a javascript library like Modernizr (http://modernizr.com/).  

New in Version 1.17
-------------------
- Added Ubuntu and Ubuntu Touch (mobile) detection  
- Added Windows 10 mobile detection  
- Added Microsoft Edge browser detection (contributed by https://github.com/nmaves)  
- Added future Firefox versions up to 42.

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
   <version>1.17</version>
</dependency>
```

Add dependency for snapshot releases:
```xml
<dependency>
   <groupId>eu.bitwalker</groupId>
   <artifactId>UserAgentUtils</artifactId>
   <version>1.18-SNAPSHOT</version>
</dependency>
```

Contributors
------------
* Please use the `trunk` branch on GitHub when making a pull request
* This project is in maintenance mode. We will try to stay up to date and fix bugs but do not expect any big new features or changes. 
* If you want big changes feel free to fork this project and start your own version.
 
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


Changelog
---------

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

