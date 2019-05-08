# mavha

Test Técnico 
Angular + JAVA Sping boot
 
Problema
Implementar una solución que permita guardar y listar una/s  Entidad/es TODOs con las siguientes características:
TODO (To do, listado de tareas por hacer)
A ) ID
B) DESCRIPCION (EL TODO a hacer)
C) Estado
D) Foto/Imagen adjunta a la DESCRIPCION

A implementar:
Listado de TODOs: METHOD GET (Respetar convenciones en la url)
Listado filtrado por A B y C: METHOD GET (Utilizar query parameters y respetar convenciones)
Alta del TODO: METHOD POST (Respetar convenciones en la url). Que reciba la foto/imagen también.
Cambio de estado, de pendiente a resuelta.


Consideraciones:
Utilizar maven 
Definir un pom y hacer uso de Dependency Management de maven 
Utilizar Spring Framework
Usar Spring boot
Usar annotations 
Las Entidades denotadas con el estándar JPA  (paquete  javax.persistence.*)
manejo de excepciones
Unit test completo con JUNIT
Implementar un SPA en Angular para poder listar, buscar, dar de alta y cambiar de estado
Utilizar DB en memoria hsqldb
