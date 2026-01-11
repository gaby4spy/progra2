
# Control de Acceso – Festival 
Sistema que registra **ingresos** y **egresos** de asistentes a un festival usando solo **TDAs** (Conjunto, Diccionario y Cola).


Control de Acceso – Festival

## Justificación del diseño
- **ConjuntoLD**: mantiene los **DNIs presentes** y evita duplicados al ingresar.
- **DiccionarioSimpleA**: asocia **DNI → datos del asistente** para recuperar la ficha cuando haga falta.
- **Colas de asistentes**: registran el **orden temporal** de **ingresos** y **egresos** (FIFO).

### Flujo mínimo
- **Ingreso**: si el DNI no está marcado como presente → guardar/actualizar la ficha, marcar presente y encolar en **ingresos**.
- **Egreso**: si el DNI está marcado como presente → desmarcar y encolar en **egresos**.
- **Estadísticas**: contadores de ingresos, egresos y presentes.


## Complejidades

### ConjuntoLD 
| Operación           | Tiempo |
|---------------------|:------:|
| InicializarConjunto | O(1)   |
| Agregar(x)          | O(N)   |
| Sacar(x)            | O(N)   |
| Pertenece(x)        | O(N)   |
| Elegir()            | O(1)   |
| ConjuntoVacio()     | O(1)   |

**Justificación**
- `Agregar(x)`: necesita chequear duplicado recorriendo la lista → O(N); insertar al frente es O(1).
- `Sacar(x)`: busca el nodo (puede estar al final) → O(N).
- `Pertenece(x)`: recorrido lineal hasta encontrar o terminar → O(N).
- `Elegir()` y `ConjuntoVacio()`: lecturas directas → O(1).
> N = cantidad de elementos en el conjunto (presentes).

### DiccionarioSimpleA 
| Operación              | Tiempo |
|------------------------|:------:|
| InicializarDiccionario | O(1)   |
| Agregar(clave, valor)  | O(N)   |
| Eliminar(clave)        | O(N)   |
| Recuperar(clave)       | O(N)   |
| Claves()               | O(N)   |

**Justificación**
- `Agregar`: ubica la clave (o confirma ausencia) con búsqueda lineal → O(N); crear es O(1).
- `Eliminar`: busca la clave → O(N).
- `Recuperar`: búsqueda lineal de la clave → O(N).
- `Claves()`: recorre una vez el arreglo para colectar claves → O(N).
> N = cantidad de pares (clave, valor) en el diccionario.


### ColaAsistente (arreglo con corrimiento)
| Operación       | Tiempo |
|-----------------|:------:|
| InicializarCola | O(1)   |
| Acolar(x)       | O(1)   |
| Desacolar()     | O(N)   |
| Primero()       | O(1)   |
| ColaVacia()     | O(1)   |

**Justificación**
- `Acolar`: escribe al final vía índice → O(1).
- `Desacolar`: corrimiento de todos los elementos una posición → O(N).
- `Primero()` y `ColaVacia()`: lecturas directas → O(1).
> N = cantidad de elementos en la cola en ese momento.

### Operaciones en `ControlFestival`
| Método / Operación        | Tiempo |
|---------------------------|:------:|
| registrarIngreso(a)       | O(N)   |
| registrarEgreso(dni)      | O(N)   |
| mostrarOrdenIngreso(cola) | O(N)   |
| mostrarDiccionario(dic)   | O(N²)  |
| mostrarPresentes()        | O(N²)  |

**Justificación**
- `registrarIngreso`: combina `Pertenece` del conjunto (O(N)) + `Agregar` del diccionario (O(N)) + O(1) ⇒ dominante O(N).
- `registrarEgreso`: `Pertenece` + `Sacar` (conjunto) + `Recuperar` (diccionario) ⇒ dominante O(N).
- `mostrarOrdenIngreso`: recorre la cola completa y restaura con auxiliar → O(N).
- `mostrarDiccionario`: `Claves()` O(N) y por cada clave `Recuperar` O(N) ⇒ O(N²).
- `mostrarPresentes`: recorre el conjunto "presentes" y para cada uno `Recuperar` O(N) ⇒ O(N²) tomando N como tamaño dominante.
> Aquí N = tamaño dominante de las estructuras usadas en cada método.


