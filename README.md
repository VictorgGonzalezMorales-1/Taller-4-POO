# Taller 4 - Administrador de Colección Pokémon TCG

## Descripción del proyecto

Este proyecto corresponde al **Taller 4 de Programación Orientada a Objetos**, desarrollado durante el **I Semestre de 2026** para las carreras de **ITI - ICCI - ICI**.

El proyecto consiste en la creación de una aplicación con **interfaz gráfica en Java**, orientada a la administración de una colección de cartas de **Pokémon TCG**. El sistema permite cargar cartas desde un archivo de texto, visualizar la colección, ordenar las cartas según distintos criterios, calcular el poder de cada carta y administrar la colección mediante operaciones de agregar, eliminar y modificar cartas.

La información principal del programa se carga desde el archivo `Sobres.txt`, el cual contiene los datos de las cartas obtenidas desde sobres y mazos prearmados. Cada carta posee un nombre, una rareza, un tipo y atributos adicionales que dependen del tipo de carta.

El sistema aplica principios de **Programación Orientada a Objetos**, utilizando separación entre la lógica principal, las clases de dominio, la interfaz gráfica, interfaces, herencia, polimorfismo y colecciones dinámicas. Además, implementa los patrones de diseño solicitados en el taller: **Singleton**, **Factory**, **Visitor** y **Strategy**.

---

## Integrantes

| Nombre                         | Carrera                     | RUT          | Usuario GitHub           |
| ------------------------------ | --------------------------- | ------------ | ------------------------ |
| Victor Manuel Gonzalez Morales | Ingeniería Civil Industrial | 22.061.552-9 | VictorgGonzalezMorales-1 |
| Joaquin Esteban Torres Flores  | Ingeniería Civil Industrial | 21.547.370-8 | JoaquinTFdev1            |

---

## Contexto del problema

Sutrostian y POOsandon comenzaron a coleccionar cartas de **Pokémon TCG** luego de recibir una recomendación de su amigo Mateo. Después de comprar sobres y mazos prearmados, su colección comenzó a crecer y se volvió difícil mantenerla organizada.

Para solucionar este problema, se desarrolla un software con **GUI en Java** que permite administrar la colección de cartas, modificar sus datos, listarlas, ordenarlas y calcular sus respectivas puntuaciones.

---

## Funcionalidades principales

El programa permite:

* Cargar información inicial desde `Sobres.txt`.
* Crear objetos de cartas según su tipo.
* Agregar nuevas cartas a la colección.
* Eliminar cartas existentes.
* Modificar cartas existentes.
* Modificar únicamente los atributos adicionales propios de cada tipo de carta.
* Guardar automáticamente los cambios en `Sobres.txt`.
* Mantener el formato original del archivo de datos.
* Visualizar la colección completa mediante interfaz gráfica.
* Ordenar cartas por poder.
* Ordenar cartas por nombre.
* Ordenar cartas por rareza.
* Calcular el poder de cada carta según su tipo.
* Mostrar imágenes de las cartas.
* Utilizar una imagen por defecto si no existe una imagen específica.
* Abrir una vista ampliada al hacer clic sobre una carta.
* Permitir cartas repetidas dentro de la colección.

---

## Estructura general del proyecto

El proyecto se encuentra organizado en distintos paquetes, separando la lógica, el dominio, la interfaz gráfica y los patrones de diseño.

```txt
Taller4Pokemon/
│
├── Sobres.txt
├── README.md
├── CHECKLIST_ENTREGA.md
├── DiagramaDeClases.pdf
├── ModeloDeDominio.pdf
│
├── imagenes/
│   ├── default.png
│   ├── Mega Mawile-Ex.png
│   ├── Premium Power Pro.png
│   ├── Lillie's Determination.png
│   └── Basic Energy.png
│
└── src/
    │
    ├── logica/
    │   ├── Main.java
    │   ├── Sistema.java
    │   └── SistemaImplementado.java
    │
    ├── dominio/
    │   ├── Cartas.java
    │   ├── Pokemon.java
    │   ├── Item.java
    │   ├── Supporter.java
    │   ├── Energy.java
    │   └── FactoryCartas.java
    │
    ├── visitor/
    │   ├── InterfazVisitor.java
    │   └── VisitorPoder.java
    │
    ├── strategy/
    │   ├── InterfazStrategy.java
    │   ├── FactoryStrategy.java
    │   ├── StrategyPoder.java
    │   ├── StrategyNombre.java
    │   └── StrategyRareza.java
    │
    └── gui/
        ├── VentanaPrincipal.java
        ├── PanelAdministracion.java
        ├── PanelColeccion.java
        ├── VentanaDetalleCarta.java
        └── GestorImagenes.java
```

---

## Archivos utilizados por el programa

El programa utiliza principalmente el archivo:

```txt
Sobres.txt
```

Este archivo debe estar ubicado en la raíz del proyecto, no dentro de la carpeta `src`.

---

## Sobres.txt

El archivo `Sobres.txt` contiene la información de las cartas de la colección.

### Formato general

```txt
NombreCarta;Rareza;Tipo;...
```

Dependiendo del tipo de carta, los atributos adicionales cambian.

### Formato por tipo

```txt
Pokemon:
NombreCarta;Rareza;Pokemon;Daño;CantEnergias

Item:
NombreCarta;Rareza;Item;Bonificacion

Supporter:
NombreCarta;Rareza;Supporter;EfectosPorTurno

Energy:
NombreCarta;Rareza;Energy;Elemento
```

### Ejemplo

```txt
Mega Mawile-Ex;5;Pokemon;260;3
Premium Power Pro;2;Item;30
Lillie's Determination;2;Supporter;3
Basic Energy;1;Energy;Fight
```

Cada vez que el usuario agrega, elimina o modifica una carta desde la interfaz gráfica, el archivo `Sobres.txt` se actualiza para conservar los cambios.

---

# Clases principales

## Main

La clase `Main` es el punto de entrada del programa.

### Responsabilidades principales

* Obtener la instancia del sistema mediante Singleton.
* Cargar las cartas desde `Sobres.txt`.
* Iniciar la interfaz gráfica.
* Abrir la ventana principal del programa.

### Flujo general

```txt
Main inicia el programa
Main obtiene la instancia de SistemaImplementado
SistemaImplementado carga Sobres.txt
Main abre VentanaPrincipal
El usuario interactúa con la GUI
```

---

## Sistema

`Sistema` es una interfaz que define las operaciones principales que debe cumplir el sistema.

### Responsabilidades principales

* Declarar el método para cargar cartas.
* Declarar el método para guardar cartas.
* Declarar el método para procesar líneas de archivo.
* Declarar el método para agregar cartas.
* Declarar el método para eliminar cartas.
* Declarar el método para modificar cartas.
* Declarar el método para entregar cartas ordenadas.
* Declarar el método para buscar cartas.
* Declarar el método para entregar la memoria de cartas.

### Métodos principales

```java
void CargarArchivo();
void GuardarArchivo();
void TrabajarLinea(String l);

boolean AgregarCarta(String nombre, String rareza, String tipo, String dato1, String dato2);
boolean EliminarCartaPorIndice(int indice);
boolean ModificarCartaPorIndice(int indice, String dato1, String dato2);

String EntregarOrden(String n);
String buscarCartaPorNombre(String nombre);
String BuscarCartaPorIndice(int indice);

void EliminarObjetoConNombre(String nombre);

LinkedList<Cartas> EntregarMemoria();
int CantidadCartas();
```

---

## SistemaImplementado

`SistemaImplementado` es la clase que implementa la lógica central del programa.

Además, aplica el patrón **Singleton**, permitiendo que exista una única instancia del sistema durante la ejecución.

### Responsabilidades principales

* Almacenar la colección de cartas.
* Leer cartas desde `Sobres.txt`.
* Crear cartas mediante `FactoryCartas`.
* Guardar los cambios realizados en `Sobres.txt`.
* Agregar nuevas cartas.
* Eliminar cartas existentes.
* Modificar los atributos adicionales de una carta.
* Entregar cartas ordenadas según una estrategia.
* Mantener una colección dinámica de cartas.
* Permitir cartas repetidas.

### Colección utilizada

```java
static LinkedList<Cartas> M = new LinkedList<Cartas>();
```

La lista `M` funciona como memoria principal del sistema. En ella se almacenan todos los objetos de tipo `Cartas` creados desde el archivo o ingresados desde la interfaz gráfica.

---

## Cartas

`Cartas` es una clase abstracta que representa una carta general de la colección.

### Atributos principales

```java
protected String nombreCarta;
protected double rareza;
protected String tipo;
protected String rutaImagen;
```

### Responsabilidades principales

* Guardar el nombre de la carta.
* Guardar la rareza.
* Guardar el tipo.
* Guardar la ruta base de imagen.
* Definir el método para aceptar un Visitor.
* Definir el método para generar el formato de archivo.
* Definir el método para modificar atributos adicionales.
* Definir el método para entregar datos adicionales.

### Métodos principales

```java
public double getRareza();
public String getNombreCarta();
public String getTipo();
public String getRutaImagen();

public abstract void Aceptar(InterfazVisitor V);
public abstract String FormatoArchivo();
public abstract void ModificarExtras(String dato1, String dato2);
public abstract String EntregarDatosExtra();
```

Esta clase permite aplicar herencia y polimorfismo, ya que todas las cartas comparten atributos comunes, pero cada tipo de carta posee atributos y comportamientos particulares.

---

## Pokemon

La clase `Pokemon` representa una carta de tipo Pokémon.

### Atributos específicos

```java
private double daño;
private double cantEnergias;
```

### Formato en archivo

```txt
NombreCarta;Rareza;Pokemon;Daño;CantEnergias
```

### Fórmula de poder

```txt
Poder = (Daño / CantEnergias) * 100
```

### Ejemplo

```txt
Mega Mawile-Ex;5;Pokemon;260;3
```

### Responsabilidades principales

* Guardar el daño de la carta.
* Guardar la cantidad de energías.
* Entregar los datos adicionales.
* Modificar daño y cantidad de energías.
* Entregar el formato correcto para `Sobres.txt`.
* Aceptar el Visitor para calcular poder.

---

## Item

La clase `Item` representa una carta de tipo objeto.

### Atributo específico

```java
private double bonificacion;
```

### Formato en archivo

```txt
NombreCarta;Rareza;Item;Bonificacion
```

### Fórmula de poder

```txt
Poder = Bonificacion * 20
```

### Ejemplo

```txt
Premium Power Pro;2;Item;30
```

### Responsabilidades principales

* Guardar la bonificación.
* Entregar los datos adicionales.
* Modificar la bonificación.
* Entregar el formato correcto para `Sobres.txt`.
* Aceptar el Visitor para calcular poder.

---

## Supporter

La clase `Supporter` representa una carta de tipo apoyo.

### Atributo específico

```java
private double efectosPorTurno;
```

### Formato en archivo

```txt
NombreCarta;Rareza;Supporter;EfectosPorTurno
```

### Fórmula de poder

```txt
Poder = EfectosPorTurno * 50
```

### Ejemplo

```txt
Lillie's Determination;2;Supporter;3
```

### Responsabilidades principales

* Guardar la cantidad de efectos por turno.
* Entregar los datos adicionales.
* Modificar los efectos por turno.
* Entregar el formato correcto para `Sobres.txt`.
* Aceptar el Visitor para calcular poder.

---

## Energy

La clase `Energy` representa una carta de energía.

### Atributo específico

```java
private String elemento;
```

### Formato en archivo

```txt
NombreCarta;Rareza;Energy;Elemento
```

### Fórmula de poder

```txt
Poder = 1
```

### Ejemplo

```txt
Basic Energy;1;Energy;Fight
```

### Responsabilidades principales

* Guardar el elemento.
* Entregar los datos adicionales.
* Modificar el elemento.
* Entregar el formato correcto para `Sobres.txt`.
* Aceptar el Visitor para calcular poder.

---

## FactoryCartas

`FactoryCartas` implementa el patrón **Factory**.

### Responsabilidades principales

* Crear cartas a partir de líneas de `Sobres.txt`.
* Crear cartas desde los datos ingresados en la GUI.
* Identificar el tipo de carta.
* Retornar el objeto correspondiente.

### Tipos creados

```txt
Pokemon
Item
Supporter
Energy
```

### Flujo de creación

```txt
Se recibe una línea del archivo
La línea se separa por ;
Se identifica el tipo de carta
Si el tipo es Pokemon, se crea Pokemon
Si el tipo es Item, se crea Item
Si el tipo es Supporter, se crea Supporter
Si el tipo es Energy, se crea Energy
La carta creada se almacena en la memoria del sistema
```

---

# Paquete Visitor

El paquete `visitor` contiene las clases e interfaces relacionadas con el patrón **Visitor**.

---

## InterfazVisitor

`InterfazVisitor` define los métodos que debe implementar cualquier Visitor que opere sobre las cartas.

### Métodos principales

```java
void Visit(Pokemon p);
void Visit(Item i);
void Visit(Supporter s);
void Visit(Energy e);

double EntregarResultado();
```

Esta interfaz permite que cada tipo de carta sea visitado de forma específica.

---

## VisitorPoder

`VisitorPoder` implementa el cálculo de poder de cada carta.

### Fórmulas utilizadas

```txt
Pokemon   -> (Daño / CantEnergias) * 100
Item      -> Bonificacion * 20
Supporter -> EfectosPorTurno * 50
Energy    -> 1
```

### Flujo de uso

```txt
Se crea un VisitorPoder
La carta acepta el visitante
El visitante ejecuta el método Visit correspondiente
El resultado queda almacenado en el visitor
El sistema solicita el resultado mediante EntregarResultado
```

Este patrón evita que el cálculo de poder quede concentrado en el sistema o en la interfaz gráfica mediante condicionales por tipo de carta.

---

# Paquete Strategy

El paquete `strategy` contiene las clases relacionadas con el patrón **Strategy**, utilizado para ordenar la colección de cartas.

---

## InterfazStrategy

`InterfazStrategy` define el comportamiento general de una estrategia de ordenamiento.

### Método principal

```java
LinkedList<Cartas> Ordenar(LinkedList<Cartas> C);
```

Cada estrategia recibe una lista de cartas y la retorna ordenada según un criterio específico.

---

## StrategyPoder

`StrategyPoder` ordena las cartas de mayor a menor poder.

Para calcular el poder de cada carta, utiliza `VisitorPoder`.

### Flujo

```txt
StrategyPoder recibe la lista de cartas
Para cada carta calcula el poder usando VisitorPoder
Compara los poderes
Ordena las cartas de mayor a menor
Retorna la lista ordenada
```

---

## StrategyNombre

`StrategyNombre` ordena las cartas alfabéticamente por su nombre.

El ordenamiento considera el nombre completo de la carta.

Ejemplo:

```txt
Basic Energy
Lillie's Determination
Mega Mawile-Ex
Premium Power Pro
```

---

## StrategyRareza

`StrategyRareza` ordena las cartas de mayor a menor rareza.

Esto cumple con la regla del taller:

```txt
Mientras mayor sea la rareza de una carta, mejor es.
```

---

## FactoryStrategy

`FactoryStrategy` aplica el patrón **Factory** para crear estrategias de ordenamiento.

### Opciones disponibles

```txt
1 -> StrategyPoder
2 -> StrategyNombre
3 -> StrategyRareza
```

Según la opción seleccionada en la interfaz gráfica, el sistema crea la estrategia correspondiente.

---

# Paquete GUI

El paquete `gui` contiene las clases encargadas de construir la interfaz gráfica del programa.

---

## VentanaPrincipal

`VentanaPrincipal` es la ventana principal de la aplicación.

### Responsabilidades principales

* Crear la ventana principal.
* Crear las pestañas del sistema.
* Agregar la pestaña de administración.
* Agregar la pestaña de visualización de colección.
* Actualizar la vista de colección al cambiar de pestaña.

La ventana utiliza `JTabbedPane`, cumpliendo con las dos pestañas solicitadas en el enunciado:

```txt
Administracion
Ver Coleccion
```

---

## PanelAdministracion

`PanelAdministracion` representa la pestaña de administración de cartas.

### Funcionalidades principales

* Agregar carta.
* Eliminar carta.
* Modificar carta.
* Mostrar lista de cartas existentes.
* Cargar los datos de una carta seleccionada.
* Bloquear nombre, rareza y tipo durante la modificación.
* Permitir modificar únicamente los atributos adicionales.

### Modificación por tipo

```txt
Pokemon:
Se puede modificar daño y cantidad de energías.

Item:
Se puede modificar bonificación.

Supporter:
Se puede modificar efectos por turno.

Energy:
Se puede modificar elemento.
```

Cada vez que se agrega, elimina o modifica una carta, el sistema actualiza el archivo `Sobres.txt`.

---

## PanelColeccion

`PanelColeccion` representa la pestaña donde se visualiza la colección.

### Funcionalidades principales

* Mostrar todas las cartas de la colección.
* Mostrar imagen de cada carta.
* Ordenar cartas por poder.
* Ordenar cartas por nombre.
* Ordenar cartas por rareza.
* Abrir una ventana ampliada al hacer clic sobre una carta.

Cada carta se muestra como un botón con imagen, nombre, tipo y rareza.

---

## VentanaDetalleCarta

`VentanaDetalleCarta` muestra una carta seleccionada en una vista ampliada.

### Información mostrada

* Imagen grande.
* Índice de la carta.
* Nombre.
* Tipo.
* Rareza.
* Atributos adicionales.
* Poder calculado.

El poder se calcula mediante `VisitorPoder`.

---

## GestorImagenes

`GestorImagenes` se encarga de buscar y cargar imágenes.

### Búsqueda de imagen

El sistema busca imágenes en la carpeta:

```txt
imagenes/
```

Primero intenta encontrar una imagen con el nombre de la carta y extensión `.png`, luego `.jpg` y finalmente `.jpeg`.

Ejemplo:

```txt
imagenes/Mega Mawile-Ex.png
imagenes/Mega Mawile-Ex.jpg
imagenes/Mega Mawile-Ex.jpeg
```

Si no encuentra una imagen específica, utiliza:

```txt
imagenes/default.png
```

---

# Patrones de diseño utilizados

## Singleton

Implementado en:

```txt
SistemaImplementado
```

### Justificación

Se utiliza para asegurar que exista una única instancia del sistema durante la ejecución. Esto permite que toda la aplicación trabaje sobre la misma colección de cartas y evita inconsistencias entre diferentes partes de la GUI.

---

## Factory

Implementado en:

```txt
FactoryCartas
FactoryStrategy
```

### Justificación

`FactoryCartas` permite crear cartas según el tipo leído desde el archivo o ingresado desde la GUI.

`FactoryStrategy` permite crear estrategias de ordenamiento según la opción seleccionada por el usuario.

---

## Visitor

Implementado en:

```txt
InterfazVisitor
VisitorPoder
```

### Justificación

Se utiliza para calcular el poder de las cartas. Cada tipo de carta tiene una fórmula distinta, por lo que el Visitor permite separar esta lógica del sistema y de la interfaz gráfica.

---

## Strategy

Implementado en:

```txt
InterfazStrategy
StrategyPoder
StrategyNombre
StrategyRareza
```

### Justificación

Se utiliza para cambiar dinámicamente el criterio de ordenamiento de la colección.

Criterios disponibles:

```txt
Poder
Nombre
Rareza
```

---

# Cálculo de poder

Cada tipo de carta posee una fórmula distinta para calcular su poder.

## Pokemon

```txt
Poder = (Daño / CantEnergias) * 100
```

## Item

```txt
Poder = Bonificacion * 20
```

## Supporter

```txt
Poder = EfectosPorTurno * 50
```

## Energy

```txt
Poder = 1
```

---

# Flujo general de ejecución

1. Se ejecuta `Main.java`.
2. `Main` obtiene la instancia de `SistemaImplementado`.
3. `SistemaImplementado` carga `Sobres.txt`.
4. Cada línea válida del archivo se separa por `;`.
5. `FactoryCartas` crea la carta correspondiente.
6. Las cartas se almacenan en una `LinkedList`.
7. `Main` abre `VentanaPrincipal`.
8. La ventana principal muestra dos pestañas.
9. En la pestaña Administración, el usuario puede agregar, eliminar o modificar cartas.
10. Cada cambio actualiza `Sobres.txt`.
11. En la pestaña Ver Colección, el usuario puede ordenar cartas por poder, nombre o rareza.
12. El ordenamiento se realiza mediante Strategy.
13. El cálculo de poder se realiza mediante Visitor.
14. Al hacer clic en una carta, se abre una vista ampliada.
15. La vista ampliada muestra imagen, atributos y poder calculado.

---

# Panel Administración

La pestaña Administración permite gestionar la colección.

## Agregar carta

Para agregar una carta se deben ingresar:

* Nombre.
* Rareza.
* Tipo.
* Dato adicional 1.
* Dato adicional 2, solo para cartas Pokémon.

Según el tipo seleccionado, los datos adicionales representan:

```txt
Pokemon:
Dato 1 = Daño
Dato 2 = Cantidad de energías

Item:
Dato 1 = Bonificación

Supporter:
Dato 1 = Efectos por turno

Energy:
Dato 1 = Elemento
```

---

## Eliminar carta

Para eliminar una carta:

1. El usuario selecciona una carta desde la lista.
2. Presiona el botón de eliminar.
3. El sistema pide confirmación.
4. La carta se elimina de la colección.
5. El archivo `Sobres.txt` se actualiza.

La imagen de la carta no se elimina del proyecto, tal como indica el enunciado.

---

## Modificar carta

Para modificar una carta:

1. El usuario selecciona una carta desde la lista.
2. El sistema carga sus datos en el formulario.
3. Se bloquean los campos de nombre, rareza y tipo.
4. El usuario modifica solo los atributos adicionales.
5. El sistema actualiza la carta en memoria.
6. El archivo `Sobres.txt` se actualiza.

---

# Panel Ver Colección

La pestaña Ver Colección permite visualizar y ordenar la colección.

## Ordenar por poder

Ordena las cartas desde la de mayor poder hasta la de menor poder.

## Ordenar por nombre

Ordena las cartas alfabéticamente según el nombre.

## Ordenar por rareza

Ordena las cartas desde la de mayor rareza hasta la de menor rareza.

---

# Manejo de imágenes

Las imágenes deben estar ubicadas en la carpeta:

```txt
imagenes/
```

La imagen de cada carta debe tener el mismo nombre que la carta.

Ejemplo:

```txt
Carta:
Mega Mawile-Ex;5;Pokemon;260;3

Imagen:
imagenes/Mega Mawile-Ex.png
```

Extensiones aceptadas:

```txt
.png
.jpg
.jpeg
```

Si una carta no tiene imagen específica, el sistema utiliza:

```txt
imagenes/default.png
```

---

# Persistencia de datos

La persistencia se realiza mediante lectura y escritura del archivo `Sobres.txt`.

## Lectura

Al iniciar el programa, se carga el archivo:

```txt
Sobres.txt
```

Cada línea se procesa y se transforma en un objeto de tipo carta.

## Escritura

Cuando el usuario agrega, elimina o modifica una carta, el sistema sobrescribe `Sobres.txt` manteniendo el formato original:

```txt
NombreCarta;Rareza;Tipo;...
```

Esto permite que los cambios se mantengan incluso después de cerrar la aplicación.

---

# Reglas y restricciones

* El archivo `Sobres.txt` debe estar en la raíz del proyecto.
* La carpeta `imagenes` debe estar en la raíz del proyecto.
* Debe existir una imagen por defecto llamada `default.png`.
* Las cartas pueden repetirse.
* Al eliminar una carta, no se elimina su imagen del proyecto.
* Al modificar una carta, solo se modifican atributos adicionales.
* No se modifica el nombre, la rareza ni el tipo desde la opción de modificación.
* La rareza mayor representa una carta mejor.
* El poder se calcula según la fórmula correspondiente al tipo.
* El archivo debe mantener el formato `NombreCarta;Rareza;Tipo;...`.

---

# Control de errores

El programa incorpora validaciones para evitar caídas durante la ejecución.

Se validan principalmente:

* Campos vacíos en formularios.
* Rareza no numérica.
* Daño no numérico.
* Cantidad de energías no numérica.
* Cantidad de energías menor o igual a cero.
* Bonificación no numérica.
* Efectos por turno no numéricos.
* Selección inexistente al eliminar.
* Selección inexistente al modificar.
* Líneas incompletas en `Sobres.txt`.
* Tipos de carta no reconocidos.
* Problemas al leer el archivo.
* Problemas al guardar el archivo.
* Imágenes inexistentes.

Las validaciones de campos vacíos se realizan mediante `length() == 0`.

---

# Restricción adicional del desarrollo

Durante el desarrollo se evitó el uso de los métodos:

```java
trim()
isEmpty()
```

Para validar campos vacíos se utilizó:

```java
length() == 0
```

---

# Instrucciones de ejecución

## Requisitos

* Java JDK 8 o superior.
* IDE compatible con Java:

  * Eclipse.
  * IntelliJ IDEA.
  * Visual Studio Code.
  * NetBeans.

---

## Pasos para ejecutar

1. Clonar el repositorio desde GitHub:

```bash
git clone [https://github.com/VictorgGonzalezMorales-1/Taller-4-POO.git]
```

2. Abrir el proyecto en el IDE de preferencia.

3. Verificar que existan los paquetes:

```txt
dominio
logica
visitor
strategy
gui
```

4. Verificar que el archivo `Sobres.txt` esté ubicado en la raíz del proyecto.

5. Verificar que exista la carpeta:

```txt
imagenes/
```

6. Verificar que exista la imagen por defecto:

```txt
imagenes/default.png
```

7. Verificar que los archivos PDF solicitados estén en la raíz:

```txt
DiagramaDeClases.pdf
ModeloDeDominio.pdf
```

8. Ejecutar la clase principal:

```txt
logica.Main
```

9. Utilizar la ventana gráfica para administrar o visualizar la colección.

---

# Consideraciones para ejecución en Eclipse

1. Importar el proyecto como proyecto Java existente.
2. Verificar que existan los paquetes:

```txt
dominio
logica
visitor
strategy
gui
```

3. Verificar que `Main.java` tenga el método:

```java
public static void main(String[] args)
```

4. Verificar que `Sobres.txt` esté en la raíz del proyecto, no dentro de `src`.

5. Verificar que la carpeta `imagenes` esté en la raíz del proyecto.

6. Ejecutar con clic derecho sobre `Main.java`:

```txt
Run As → Java Application
```

---

# Diagramas y entregables

El repositorio debe incluir en la raíz los siguientes archivos:

```txt
README.md
Sobres.txt
DiagramaDeClases.pdf
ModeloDeDominio.pdf
imagenes/default.png
```

---

## Diagrama de clases

El diagrama de clases debe representar la estructura técnica del sistema, incluyendo:

* Clases del dominio.
* Clases de GUI.
* Clases del sistema.
* Interfaces.
* Atributos.
* Métodos.
* Herencia.
* Implementación de interfaces.
* Relación entre `Sistema` y `SistemaImplementado`.
* Relación entre `Cartas` y sus subclases.
* Relación entre Strategy y sus implementaciones.
* Relación entre Visitor y su implementación.
* Relación entre las clases de GUI y el sistema.

---

## Modelo de dominio

El modelo de dominio debe representar la abstracción conceptual del problema, incluyendo:

* Colección.
* Carta.
* Tipo de carta.
* Rareza.
* Poder.
* Imagen.
* Pokémon.
* Item.
* Supporter.
* Energy.
* Atributos adicionales de cada tipo.

Este modelo debe diferenciarse del diagrama técnico de clases.

---

# Tecnologías y conceptos aplicados

Este proyecto utiliza:

* Java.
* Java Swing.
* Programación Orientada a Objetos.
* Clases y objetos.
* Encapsulamiento.
* Abstracción.
* Herencia.
* Polimorfismo.
* Interfaces.
* Clases abstractas.
* Sobrescritura de métodos.
* Colecciones dinámicas con `LinkedList`.
* Lectura de archivos con `Scanner`.
* Escritura de archivos con `FileWriter`.
* Escritura de archivos con `PrintWriter`.
* Persistencia de datos mediante archivos `.txt`.
* Manejo de imágenes con `ImageIcon`.
* Interfaz gráfica con `JFrame`, `JPanel`, `JButton`, `JTabbedPane` y `JScrollPane`.
* Validación de entradas.
* Manejo de errores con `try/catch`.
* Separación de responsabilidades.
* Arquitectura por paquetes.
* Patrón Singleton.
* Patrón Factory.
* Patrón Visitor.
* Patrón Strategy.
* Control de versiones con Git y GitHub.

---

# Estado del proyecto

Proyecto desarrollado como entrega académica para el **Taller 4 de Programación Orientada a Objetos**, I Semestre 2026.

El sistema permite administrar una colección de cartas Pokémon TCG mediante una interfaz gráfica, manteniendo persistencia de datos en archivos de texto y aplicando correctamente los patrones de diseño Singleton, Factory, Visitor y Strategy.
