user-agent-utils
================

Utilities for processing user-agent strings. Can be used to handle http requests in real-time or to analyze log files.

http://haraldwalker.github.com/user-agent-utils/

For the latest release, go to
https://github.com/HaraldWalker/user-agent-utils/tree/master

Buy me a beer:
<a href="http://flattr.com/thing/1968218/HaraldWalkeruser-agent-utils-on-GitHub" target="_blank"><img src="http://api.flattr.com/button/flattr-badge-large.png" alt="Flattr this" title="Flattr this" border="0" /></a>

New in Version 1.11-snapshot (unreleased)
------------------

* ... 

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
