# BackEndPPJava
Resolución del primer examen parcial de BackEnd

### Pasos a tener en cuenta.

+ clonar el repositorio.
+ editar el archivo standalone.xml (dentro de la carpeta del wildfly está en standalone\configuration\standalone.xml)
  1. Dirigirse a la linea 162 dentro 
  2. En la etiqueta <conection-url> especificar el nombre y el puerto de sus bases de datos locales (PostgreSQL versión 12).
  3. Esta es la forma <connection-url>jdbc:postgresql://localhost:5434/bdpwb</connection-url> (puerto:5434, Nom_BD:bdpwb).
  4. En la linea 168 y 169 especificar el username y el password para acceder a su base de datos. 
  
  
