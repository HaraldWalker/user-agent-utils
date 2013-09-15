user-agent-utils
================

Utilities for processing user-agent strings. Can be used to handle http requests in real-time or to analyze log files.

http://haraldwalker.github.com/user-agent-utils/

New in Version 1.10
------------------

* Fixed and extended OS and browser detection when using Firefox on mobiles or tablets
* Added additional and future Firefox versions
* Added Chrome 29
* Added Opera 11, 12, 15 & 16 

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
   <version>1.10</version>
</dependency>
```
