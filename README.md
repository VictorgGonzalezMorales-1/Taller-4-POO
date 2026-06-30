# Taller 4 - Administrador de Colección Pokémon TCG

## Descripción

Proyecto desarrollado para el Taller 4 de Programación Orientada a Objetos, I Semestre 2026, correspondiente a las carreras ITI, ICCI e ICI.

El programa consiste en una aplicación de escritorio hecha en Java con Swing. Su objetivo es administrar una colección de cartas de Pokémon TCG, permitiendo cargar cartas desde un archivo, visualizarlas en una interfaz gráfica, ordenarlas, calcular su poder y realizar operaciones de administración sobre la colección.

La información de las cartas se guarda en el archivo `Sobres.txt`. Cada línea del archivo representa una carta y mantiene el formato indicado en el enunciado del taller.

El proyecto utiliza Programación Orientada a Objetos, separación por paquetes, herencia, interfaces, clases abstractas, colecciones dinámicas y los patrones de diseño Singleton, Factory, Visitor y Strategy.

---

## Integrantes

| Nombre                         | Carrera                     | RUT          | GitHub                   |
| ------------------------------ | --------------------------- | ------------ | ------------------------ |
| Victor Manuel Gonzalez Morales | Ingeniería Civil Industrial | 22.061.552-9 | VictorgGonzalezMorales-1 |
| Joaquin Esteban Torres Flores  | Ingeniería Civil Industrial | 21.547.370-8 | JoaquinTFdev1            |

---

## Funcionalidades

El sistema permite:

* Cargar cartas desde `Sobres.txt`.
* Agregar nuevas cartas a la colección.
* Eliminar cartas existentes.
* Modificar cartas existentes.
* Modificar solo los atributos adicionales de cada tipo de carta.
* Guardar los cambios realizados en el archivo.
* Mantener el formato original de `Sobres.txt`.
* Visualizar la colección completa en una interfaz gráfica.
* Ordenar la colección por poder, nombre o rareza.
* Calcular el poder de cada carta según su tipo.
* Mostrar imágenes asociadas a las cartas.
* Usar una imagen por defecto cuando no exista una imagen específica.
* Abrir una vista ampliada al hacer clic sobre una carta.
* Trabajar con cartas repetidas dentro de la colección.

---

## Estructura del proyecto

```txt
Taller4Pokemon/
│
├── README.md
├── Sobres.txt
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
    ├── dominio/
    │   ├── Cartas.java
    │   ├── Pokemon.java
    │   ├── Item.java
    │   ├── Supporter.java
    │   ├── Energy.java
    │   └── FactoryCartas.java
    │
    ├── logica/
    │   ├── Main.java
    │   ├── Sistema.java
    │   └── SistemaImplementado.java
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

## Archivo Sobres.txt

El archivo `Sobres.txt` debe estar ubicado en la raíz del proyecto.

Cada línea del archivo representa una carta con el siguiente formato general:

```txt
NombreCarta;Rareza;Tipo;...
```

Los atributos adicionales dependen del tipo de carta.

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

Cuando se agrega, elimina o modifica una carta, el archivo se actualiza manteniendo este mismo formato.

---

## Tipos de cartas

El sistema trabaja con cuatro tipos de cartas.

### Pokemon

Atributos adicionales:

```txt
Daño
Cantidad de energías
```

Fórmula de poder:

```txt
Poder = (Daño / CantEnergias) * 100
```

---

### Item

Atributo adicional:

```txt
Bonificación
```

Fórmula de poder:

```txt
Poder = Bonificacion * 20
```

---

### Supporter

Atributo adicional:

```txt
Efectos por turno
```

Fórmula de poder:

```txt
Poder = EfectosPorTurno * 50
```

---

### Energy

Atributo adicional:

```txt
Elemento
```

Fórmula de poder:

```txt
Poder = 1
```

---

## Interfaz gráfica

La aplicación utiliza Java Swing.

La ventana principal contiene dos pestañas:

```txt
Administracion
Ver Coleccion
```

---

## Pestaña Administración

En esta pestaña se puede administrar la colección de cartas.

Permite:

* Agregar cartas.
* Eliminar cartas.
* Modificar cartas.
* Ver la lista de cartas cargadas.
* Seleccionar una carta para editarla.
* Guardar los cambios en `Sobres.txt`.

Al modificar una carta, solo se pueden cambiar los atributos adicionales según su tipo.

```txt
Pokemon:
Daño y cantidad de energías.

Item:
Bonificación.

Supporter:
Efectos por turno.

Energy:
Elemento.
```

El nombre, la rareza y el tipo no se modifican desde la opción de modificación.

---

## Pestaña Ver Colección

En esta pestaña se muestra la colección completa.

Cada carta se visualiza como un botón con:

* Imagen.
* Nombre.
* Tipo.
* Rareza.

La colección puede ordenarse por:

```txt
Poder
Nombre
Rareza
```

Al hacer clic sobre una carta, se abre una ventana ampliada con:

* Imagen grande.
* Índice.
* Nombre.
* Tipo.
* Rareza.
* Atributos adicionales.
* Poder calculado.

---

## Manejo de imágenes

Las imágenes deben estar dentro de la carpeta:

```txt
imagenes/
```

El sistema busca la imagen usando el nombre de la carta.

Ejemplo:

```txt
Carta:
Mega Mawile-Ex

Imagen:
imagenes/Mega Mawile-Ex.png
```

Extensiones consideradas:

```txt
.png
.jpg
.jpeg
```

Si no se encuentra una imagen con el nombre de la carta, se utiliza:

```txt
imagenes/default.png
```

La imagen por defecto debe existir para evitar problemas al mostrar cartas sin imagen propia.

---

## Paquetes del proyecto

### dominio

Contiene las clases que representan las cartas.

```txt
Cartas
Pokemon
Item
Supporter
Energy
FactoryCartas
```

`Cartas` es la clase abstracta principal.
`Pokemon`, `Item`, `Supporter` y `Energy` heredan de ella.
`FactoryCartas` se encarga de crear objetos según el tipo de carta.

---

### logica

Contiene la lógica principal del sistema.

```txt
Main
Sistema
SistemaImplementado
```

`Main` inicia el programa.
`Sistema` define las operaciones principales.
`SistemaImplementado` administra la colección, carga y guarda el archivo, y aplica los patrones necesarios.

---

### visitor

Contiene el cálculo de poder de las cartas.

```txt
InterfazVisitor
VisitorPoder
```

`VisitorPoder` calcula el poder de cada carta según su tipo.

---

### strategy

Contiene las estrategias de ordenamiento.

```txt
InterfazStrategy
FactoryStrategy
StrategyPoder
StrategyNombre
StrategyRareza
```

Cada estrategia ordena la colección usando un criterio distinto.

---

### gui

Contiene las clases de la interfaz gráfica.

```txt
VentanaPrincipal
PanelAdministracion
PanelColeccion
VentanaDetalleCarta
GestorImagenes
```

Estas clases construyen la ventana, las pestañas, la vista de colección, el formulario de administración y la visualización ampliada de cartas.

---

## Patrones de diseño

### Singleton

Implementado en:

```txt
SistemaImplementado
```

Se utiliza para mantener una única instancia del sistema durante la ejecución. De esta forma, la colección de cartas se administra desde un solo lugar.

---

### Factory

Implementado en:

```txt
FactoryCartas
FactoryStrategy
```

`FactoryCartas` crea cartas según el tipo recibido.
`FactoryStrategy` crea la estrategia de ordenamiento seleccionada.

---

### Visitor

Implementado en:

```txt
InterfazVisitor
VisitorPoder
```

Se utiliza para calcular el poder de las cartas sin concentrar esa lógica en la GUI ni en el sistema principal.

---

### Strategy

Implementado en:

```txt
InterfazStrategy
StrategyPoder
StrategyNombre
StrategyRareza
```

Se utiliza para ordenar la colección con distintos criterios.

---

## Persistencia

La persistencia se realiza mediante el archivo:

```txt
Sobres.txt
```

Al iniciar el programa, el sistema lee el archivo y crea los objetos correspondientes.

Durante la ejecución, si el usuario agrega, elimina o modifica una carta, el archivo se sobrescribe con la colección actual.

El formato se mantiene como:

```txt
NombreCarta;Rareza;Tipo;...
```

---

## Ejecución del programa

### Requisitos

* Java JDK 8 o superior.
* Un IDE compatible con Java, por ejemplo Eclipse, IntelliJ IDEA, NetBeans o Visual Studio Code.

---

### Pasos

1. Clonar o descargar el repositorio.

2. Abrir el proyecto en el IDE.

3. Verificar que el archivo `Sobres.txt` esté en la raíz del proyecto.

4. Verificar que exista la carpeta `imagenes`.

5. Verificar que exista la imagen por defecto:

```txt
imagenes/default.png
```

6. Ejecutar la clase principal:

```txt
logica.Main
```

---

## Ejecución en Eclipse

1. Importar el proyecto como proyecto Java existente.

2. Revisar que los paquetes estén dentro de `src`.

3. Verificar que `Sobres.txt` no esté dentro de `src`, sino en la raíz del proyecto.

4. Verificar que la carpeta `imagenes` esté en la raíz del proyecto.

5. Abrir `Main.java`.

6. Ejecutar con:

```txt
Run As -> Java Application
```

---

## Archivos de entrega

El repositorio debe incluir:

```txt
README.md
Sobres.txt
DiagramaDeClases.pdf
ModeloDeDominio.pdf
imagenes/default.png
src/
```

---

## Diagramas

### Diagrama de clases

El archivo `DiagramaDeClases.pdf` representa la estructura técnica del programa, incluyendo clases, interfaces, atributos, métodos, herencia, implementación de interfaces y relaciones entre paquetes.

### Modelo de dominio

El archivo `ModeloDeDominio.pdf` representa el problema de forma conceptual, mostrando la colección, las cartas, los tipos de cartas, la imagen, la puntuación y el archivo de registros.

---

## Consideraciones

* Pueden existir cartas repetidas.
* Al eliminar una carta, no se elimina su imagen del proyecto.
* Al modificar una carta, solo cambian sus atributos adicionales.
* La rareza mayor representa una mejor carta.
* El poder se calcula según el tipo de carta.
* El archivo `Sobres.txt` conserva el formato original.
* Las imágenes de las cartas deben agregarse manualmente a la carpeta `imagenes`.
* Si una carta no tiene imagen, se muestra `default.png`.

---

## Tecnologías utilizadas

* Java.
* Java Swing.
* Programación Orientada a Objetos.
* Herencia.
* Interfaces.
* Clases abstractas.
* Polimorfismo.
* Colecciones dinámicas con `LinkedList`.
* Lectura de archivos con `Scanner`.
* Escritura de archivos con `FileWriter` y `PrintWriter`.
* Manejo de imágenes con `ImageIcon`.
* Patrones Singleton, Factory, Visitor y Strategy.
* Git y GitHub.

---

## Estado del proyecto

El proyecto permite administrar una colección de cartas Pokémon TCG mediante una interfaz gráfica. La aplicación carga datos desde archivo, permite modificar la colección, mantiene persistencia en `Sobres.txt`, muestra imágenes de las cartas y aplica los patrones de diseño solicitados en el taller.
