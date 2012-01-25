# Server Sent Events

This is the supporting source code for an article in the german JavaMagazin about Server Sent Events.

## Build

mvn package

## Run

Modify your Tomcat's server.xml to disabled the HttpProtocol connector and enable the NioProtocol since we need asynchronous Servlets.

  <Connector port="8080" protocol="org.apache.coyote.http11.Http11NioProtocol"
  minProcessors="3"
  maxProcessors="8"
  maxThreads="20"
  connectionTimeout="150000"
  asyncTimeout="150000" />


You need a Servlet 3.0 capable Tomcat.

Deploy the war.

Point your Browser to : http://localhost:8080/sse/index.html

