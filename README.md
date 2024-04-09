# Prueba Técnica IBM 2023
* **Nombre completo**: Matías Corvetto
* **Email**: maticor93@gmail.com

<br>

## Introducción
Fue creada una organización personal para poder crear un repositorio con más opciones para brindar acceso. Posteriormente se le fue dado acceso de *Maintainer* al usuario evaluador.

Se agrega un README donde se documentará todo el proceso de construcción de programas junto con su método de ejecución.

<br>

## Ejercicio 1


### Especificaciones

Para este proyecto se utilizaron las siguientes herramientas y tecnologías:

* *Visual Studio Code*, junto con extensiones correspondientes ("Pack for Java", "Spring Initializr", entre otras)
* *Spring Boot* - 3.1.5 (Maven)
* *Java* - 17.0
* *npm* - 10.2.3
* *NodeJs* - 18.17.0
* *Angular* - 16.2.9
* *TypeScript* - 4.9.3
* *MySQL* - 8.0


### Inicialización de Spring Boot

* **Group ID**: com.pruebatecnica
* **Artifact ID**: ejercicio1

### Base de Datos

El sistema de gestión de base de datos elegido fue MySql. Para el manejo de datos se cuenta con un usuario "pruebatecnica" con contraseña de igual nombre, en el cual se crea una base de datos, llamada de la misma forma, "pruebatecnica". Mediante desarrollo en Java, las tablas Empleado y DetalleEmpleado son creadas, ambas con el campo "id de empleado" como clave primaria (primary key) y clave foránea (foreign key) al mismo tiempo.

<br>

### Estructura de ConsultingAPI

**Java**

<hr>

**Tool**: En esta carpeta se desarrolló específicamente una clase llama *ExcelReader*, la cual se encarga de leer los datos del archivo y almacenarlo en su tabla correspondiente en la base de datos mediante un "INSERT". Su funcionamiento es simplemente iterar en cada una de las columnas para cada una de las filas, categorizar cada tipo de dato y guardarlo en una declaración para que al final se guarden los datos. Para crear la función se tuvieron en cuenta algunos detalles específicos de los archivos, como en que columna se encontraba el ID (Utilizado simplemente como método de verificación de completitud).

**Entity**: Esta carpeta cuenta con 4 clases: Empleado y DetalleEmpleado, mediante las cuales se hace la conexión entre SQL y Java (clave primaria, nombres, tipos de dato, largo, etc). Y además, Chart y Gerenciado, clases usadas para obtener los datos específicos para las consultas necesarias en la WEB, ya que al mismo tiempo ayuda a mantener el orden de los datos.

**Repository**: En esta carpeta se encuentran los repositorios o DAO (Data of Access) de las tablas Empleado y DetalleEmpleado. En estas clases se declaran las consultas SQL necesarias según las instrucciones.

**Service**: Aquí se instancian las funciones necesarias para obtener lo requerido según cada función. Consta de 4 clases: una de interface y otra de implementación, para ambas tablas existentes.

**Web**: Esta carpeta contiene la clase del controlador REST, el cual se encarga de enviar la información sustraída de la base de datos mediante el protocolo HTTP, de donde se leerán los datos para manejarlos en la WEB.

**Aplicación**: También se encuentra la clase principal (main), encargada de habilitar que toda la aplicación en su parte Backend funcione.

<br>

**Recursos**

<hr>

**Data**: En esta carpeta se encuentran ambos archivos Excel de los cuales se leen los datos existentes.

<br>

### Estructura de ConsultingWEB

**Model**: Aquí se encuentran las clases existentes, las cuales se instancian para obtener la información necesaria. Corresponden a las mismas clases mencionadas en el Backend, y a partir de sus atributos se expone la información de manera gráfica.

**Service**: En esta carpeta se encuentran los scripts para poder consultar la base de datos, para empleados, detalles de empleado y gráficas. Su funcionalidad es listar todo lo obtenido luego del envío de datos HTTP, y hacer público el uso de estas listas para manejos específicos.

**Interface**: En esta carpeta se encuentran las interfaces de las 2 clases de tabla, estas son utilizadas para poder mostrar toda la información de la tabla de manera automatizada.

**Views**: Por último, aquí se encuentran las vistas gráficas de la WEB. Se subdividen según componente, los cuales son: 
1. **Inicio** - pantalla inicial, donde se elige el usuario a consultar.
2. **Gerente** - pantalla del gerente, la cual muestra datos de sus gerenciados.
3. **Director** - pantalla del director, que muestra datos de todos los empleados.
4. **Planilla** - pantalla donde se muestran absolutamente todos los datos existentes las 2 tablas de un empleado específico. 
5. **Grafico** - componente que muestra ciertos datos especificados en forma de gráfico de barras, para la vista del director.

<br>

### Decisiones Realizadas y Observaciones

* Muchos campos de la tablas de Excel estaban vacíos, entre ellos el salario mensual (uno de los indicados para usar en la consulta WEB). Este dato por ejemplo, muestra su campo aunque este vacío, pero si alguien ingresara un dato, consecuentemente se vería en la tabla luego de actualizar.

* Muchas columnas no estaban especificadas en su tipo, estas fueron simplemente registradas como String.

* Una de las tablas tiene lo que parece ser una celda vacía final, lo cual hacía que el lector de archivo fallara. Para solucionar esto, simplemente se creo un if que verifica si ya están todas las columnas en esa tabla registradas (simplemente leyendo el numero de columnas e comparando forzosamente a ese numero en cierta etapa), y si están, el programa no sigue leyendo.

* Se decidió que los datos se carguen una única vez al principio del todo, cuando las tablas están vacías. En el lector de Excel se evalúa si ya existen datos en la tabla, si existen, no va ingresar nuevos porque omitirá el proceso. Esto se decidió así debido a que según lo indicado en la letra, no hay necesidad de actualización, y al mismo tiempo ayuda a prevenir errores. Si quisiera cambiarse para que los datos se muestre en tiempo actual, simplemente debería cambarse ese detalle y hacer que la tabla se borre y cargue cada vez que se inicia la aplicación.

* Ya que el gerente tiene una manera de ingresar, me pareció acorde hacer un tipo de verificación también para el director. Teniendo en cuenta lo que ese puesto significa, se pide un usuario y contraseña, los cuales son simplemente evaluados al campo para verificar. Hay 2 formas de acceder:
	* usuario: director
	* contraseña: director

	la otra:
	
	* usuario: 694651
	* contraseña: 694651

	Este último como curiosidad, debido a que ese es el identificador de gerente de todos los gerentes.

* El conflicto más importante a tener en cuenta, es que la información en ambas tablas (empleado y detalles de empleado) no son coherente y no son compatibles. La  información de un identificador de empleado es distinta a la misma en su otra tabla, esto hace que los valores en un "JOIN" no sean ciertos en totalidad. Sin embargo, ante ese error de compatibilidad, se decidió ignorar este detalle y trabajar como si el empleado fuera el mismo. Esto hará que, por ejemplo, al momento de ver una planilla de un empleado en la WEB, los datos en ambas tablas se vean notoriamente distintos. Por esto mismo es importante hacer esta aclaración.

<br>

### Ejecución del Proyecto
Para una ejecución óptima se recomienda contar con las mismas especificaciones mencionadas al inicio para no encontrarse con ningún inconveniente.

* **Gestor de Base de Datos**: Deberá instalarse un gestor para manejar las consultas y tablas. La opción recomendada es MySQL, en su versión 8 (ante  cualquier diferencia en la opción de gestor o ingreso, deberá especificarse en application.properties y en la clase ExcelReader). Luego de contar con la instalación, deberá crearse un usuario cliente para conectarse, este deberá ser idéntico al usado:
	* usuario: **pruebatecnica**
	* contraseña: **pruebatecnica**

	Posteriormente, deberemos crear una base de datos también llamada **pruebatecnica**.

* **Ejecución de Backend**: Para ejecutar el Backend, deberá simplemente ejecutarse la clase main, llamada *Ejercicio1Application*, encontrada en la ConsultingAPI.

	**ruta**: *ejercicio1/ConsultingAPI/src/main/java/com/pruebatecnica*

* **Ejecución de Frontend**: Para ejecutar el Frontend, se deberá ejecutar el comando *ng s -o* en la directiva correspondiente a la carpeta *gestion-empleado-frontend*, encontrada en la ConsultingWEB.

	**ruta**: *ejercicio1/ConsultingWEB/gestion-empleados-frontend*

Deberá chequearse que ninguna de las 2 finalice mientras la página este utilizándose, o quedará fuera de servicio.

Finalmente, el URL para visitar la página, será local en el puerto 4200 para Frontend. En el puerto 8080 del servidor local, se encontrarán las consultas HTTP.

### **URL**: http://localhost:4200/inicio

<br>

## Ejercicio 2
La respuesta a este ejercicio es una tabla donde se muestran los casos de prueba funcionales y no funcionales (Se encuentra en la carpeta ejercicio2).

Para plantear las prioridades y los casos de prueba no funcionales, se adoptó el rol real de lo que sería una empresa. Es decir, importa el funcionamiento a grande escalabilidad, importa lo que los usuarios experimenten al usar la página, la privacidad es importante (sobre todo para los cargos más significativos como el director), etc.

<br>

## Ejercicio 3
Para responder este ejercicio, se creó una clase de Java, teniendo en cuenta el uso este mismo junto a JPA en el desarrollo del proyecto. En esta clase se encuentra tanto la consulta SQL mediante Springboot, como la consigna SQL en su lenguaje nativo (se encuentra comentado al final).


	SELECT * FROM Ciudadanos WHERE (Nombre LIKE 'Ped%' OR Nombre LIKE 'San%') AND LENGTH(Apellido) < 15;

Si se quisiera que al momento de obtener los datos, la evaluación sea sensible a mayúsculas y minúsculas, la consulta sería la siguiente:

	SELECT * FROM Ciudadanos WHERE (BINARY Nombre LIKE 'Ped%' OR BINARY Nombre LIKE 'San%') AND LENGTH(Apellido) < 15;

<br>

## Ejercicio 4
De manera similar al ejercicio anterior, este ejercicio también está representada en una clase de Java por las mismas razones. Este ejercicio puede tener más de una iterpretación, siendo así que la interpretación que parece ser más lógica es la siguiente:

	SELECT c.nombre FROM Ciudadanos c WHERE NOT EXISTS (
		SELECT 1
   	FROM Ciudadanos c2
   	WHERE c.nombre = c2.nombre AND c.id != c2.id
	)
	ORDER BY c.nombre ASC;

*"Seleccionar todos los nombres que sean únicos (que no se repitan)"*

Para hacerlo sensible a mayúsculas y minúsculas:

	SELECT c.nombre FROM Ciudadanos c WHERE NOT EXISTS (
	SELECT 1
   	FROM Ciudadanos c2
   	WHERE BINARY c.nombre = BINARY c2.nombre AND c.id != c2.id
	)
	ORDER BY c.nombre ASC;

<br>

Otras interpretaciones posibles:

	1. SELECT Distinct nombre FROM Ciudadanos

*"Seleccionar todos los nombres de manera que se muestre cada uno existente una única vez"*

	2. SELECT nombre FROM Ciudadanos

*"Seleccionar todos los nombres únicos (interpretando nombre único como la descripción para la columna. Ej: Mi nombre único es matías)"*

Si bien se brindan opciones alternas, cabe aclarar que la respuesta final es la primera opción.

<br>

## Ejercicio 5
Sobre este ejercicio, las imágenes en Docker fueron construidas, sin embargo, no se logró hacer funcionar completamente a la hora de ejecutar los contenedores. 

A pesar de eso, se deja en la carpeta "*ejercicio5*" los Dockerfile y el Compose para visualizar lo realizado.

<br>

## Ejercicio 6
La web fue reconstruida satisfactoriamente, contando con apenas algunos pequeños detalles de diferencia.

Se decidió, por su aparente aspecto, representar como botones a las opciones que aparecían a la derecha de la pantalla.

Para ejecutar esta interfaz de la manera más óptima, se recomienda seguir las especificaciones mencionadas para el ejercicio 1.
