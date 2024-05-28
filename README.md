# Proyecto3ev-Kevin-Sancan
Proyecto sobre crear un juego en java para la tercera evaluación de Programación

## Objetivo

El objetivo del proyecto es simular una batalla contra un enemigo del videojuego Undertale.

## Funcionamiento

Se usa el teclado para mover el personaje, el cual tiene que evitar una serie de arañas. El juego termina o bien cuando se produce una colision
entre el personaje y la araña o bien cuando se termina el ultimo ataque del enemigo.

### Controles

- W: mover hacia arriba

- A: mover hacia la izquierda

- S: mover hacia abajo

- D: mover hacia la derecha

### Gestion de estadisticas

Al finalizar el juego de cualquiera de las dos formas, se mostrará una ventana emergente con los datos de las partidas jugadas,
estos datos constan del nombre del jugador + los puntos que ha hecho + la fecha en la que se realizo su partida 

### Diagrama de clases

[![Diagram-2024-05-28-02-00-16.png](https://i.postimg.cc/9fVhkQTS/Diagram-2024-05-28-02-00-16.png)](https://postimg.cc/pm04hxsY)

### Investigacion

> Para el funcinamiento de mi programa he tenido que realizar investigaciones sobre librerias que permitan trabajar con graficos como es el caso de AWT y para el caso de los JPanel y JFrame he utilizado SWING
> Por otra parte para la gestion de archivos, con lectura y escritura no destrucitva he tenido que implementar java.IO, este mismo paquete me ha servido para tratar las distintas excepciones que pueden generar los ficheros.
