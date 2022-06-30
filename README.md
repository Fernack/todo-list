# Angular + JAVA Spring boot
 
### Implement a solution that allows to store and list a TODO Entity/entities with the following characteristics: 

```
TODO (To do, list of tasks to do). 
A) ID 
B) DESCRIPTION (THE TODO to be done) 
C) Status 
D) Picture/Image attached to the DESCRIPTION
```

To be implemented: 

```
List of TODOs: METHOD GET (Respect conventions in the url).
List filtered by A B and C: METHOD GET (Use query parameters and respect conventions).
Registration of the TODO: METHOD POST (Respect conventions in the url). Receive the photo/image as well. Change of status, from pending to resolved.
```

Considerations: 
- Use maven.
- Define a pom and make use of maven Dependency Management. 
- Use Spring Framework. 
- Use Spring boot. 
- Use annotations. 
- Entities denoted with the JPA standard (javax.persistence.* package). 
- Exception handling. 
- Unit test complete with JUNIT. 
- Using hsqldb in-memory DB.

Implement a SPA in Angular to be able to list, search, register and change state. 

![](https://github.com/Fernack/mavha/blob/master/demo.gif)
