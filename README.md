user-agent-utils
================

Utilities for processing user-agent strings. Can be used to handle http requests in real-time or to analyze log files.

http://haraldwalker.github.com/user-agent-utils/

For the latest release, go to
https://github.com/HaraldWalker/user-agent-utils/tree/master

Support me and buy me a beer:  
<a href="http://flattr.com/thing/1968218/HaraldWalkeruser-agent-utils-on-GitHub" target="_blank"><img src="http://api.flattr.com/button/flattr-badge-large.png" alt="Flattr this" title="Flattr this" border="0" /></a>

New in Version 1.13 (unreleased)
-------------------

* TBD

Javadoc
-------
http://haraldwalker.github.com/user-agent-utils/javadoc/

Maven
-----

Include our github repository in your pom.xml:
```xml
<repository>
  <id>bitwalker.user-agent-utils.mvn.repo</id>
  <url>https://raw.github.com/HaraldWalker/user-agent-utils/mvn-repo/</url>
  <!-- use snapshot version -->
  <snapshots>
     <enabled>true</enabled>
      <updatePolicy>always</updatePolicy>
   </snapshots>
</repository>
```
Add dependency:
```xml
<dependency>
   <groupId>bitwalker</groupId>
   <artifactId>UserAgentUtils</artifactId>
   <version>1.12</version>
</dependency>
```

Contributors
------------
* Please use the `trunk` branch on GitHub when making a pull request

Changelog
---------

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

