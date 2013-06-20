user-agent-utils
================

Utilities for processing user-agent strings. Can be used to handle http requests in real-time or to analyze log files.

http://haraldwalker.github.com/user-agent-utils/

New in Version 1.9
------------------

* Fixed version detection of Chrome Mobile
* Added Firefox 20 detection plus beta and future versions
* Added beta and future versions of Chrome
* Detect BlackBerry10 browser

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
   <version>1.9</version>
</dependency>
```
