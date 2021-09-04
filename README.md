# springboot-mongo-demo

## Input/Data Validation.
1. Annotations: https://reflectoring.io/bean-validation-with-spring-boot/
2. Programmatically: https://reflectoring.io/bean-validation-with-spring-boot/#validating-programmatically

## Fast paging with MongoDB
1. https://scalegrid.io


## API Design References
1. https://developers.hubspot.com

```
"paging": {
    "next": {
      "link": "?after=NTI1Cg%3D%3D",
      "after": "NTI1Cg%3D%3D"
    }
  }
```

## References
1. https://www.mongodb.com/basics/best-practices
2. https://strapi.io/

## Tomcat
1. https://www.eginnovations.com/blog/tomcat-performance-tuning/
2. https://blogs.sap.com/2019/05/06/how-to-optimize-tomcat-server-utilization./

## SSH Tunnel
1. https://www.studytonight.com/post/how-to-setup-ssh-tunneling-in-mac-os-or-ubuntu

```
ssh -L 8888:127.0.0.1:8080 root@your_remote_server_address -p1234
```
## Build JAR and Run it on Server
```
mvn clean package spring-boot:repackage
```
Run:
```
java -jar your.jar
```
Run in background mode:

~ The & symbol, switches the program to run in the background.
~ The nohup utility makes the command passed as an argument run in the background even after you log out.
```
nohup java -jar /web/server.jar &
```
