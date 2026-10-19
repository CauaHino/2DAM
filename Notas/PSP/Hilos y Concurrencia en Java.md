 
## 1. Definición de Hilo (Thread)

* **Unidad de computación:** Es la pequeña unidad de ejecución dentro del contexto de un proceso.

* **Dependencia:** Depende directamente del proceso padre.

* **Ligero:** Es más liviano de crear y gestionar en comparación con un proceso completo.

* **Recursos compartidos:** Comparte memoria y recursos con otros hilos dentro del mismo proceso.

  ---
  ## 2. Ejemplo de Implementación Básica

```java

class Raton extends Thread {
    @Override      
    public void run() {
        comer();
    }
}  

// Uso:
Raton r = new Raton();
r.start();

```

  

---
## 3. Ciclo de Vida de un Hilo

Un hilo en Java puede estar en uno de los siguientes **6 estados**:
1. **`NEW`**: Creado pero aún no iniciado.

2. **`RUNNABLE`**: Listo para ejecutarse o ejecutándose en la CPU.

3. **`BLOCKED`**: Esperando obtener un bloqueo de monitor (*lock*).

4. **`WAITING`**: Esperando indefinidamente la acción de otro hilo.

5. **`TIMED_WAITING`**: Esperando a otro hilo durante un tiempo determinado.

6. **`TERMINATED`**: Ha finalizado su ejecución.

  

> 💡 **Consulta de estado:** Se puede obtener el estado actual mediante el método `hilo.getState()`.

  

---
## 4. Problemas Comunes y Concurrencia

* **Acceso concurrente:** Ocurren fallos cuando varios hilos acceden y modifican el mismo recurso compartido al mismo tiempo.

* **Indeterminismo:** El orden real de ejecución depende del planificador (*scheduler*) del Sistema Operativo.

* **Bugs intermitentes:** Un error puede manifestarse solo en algunas ejecuciones y no en otras (*race conditions*).

* **Limitación de pruebas:** Las pruebas unitarias o convencionales no garantizan la corrección de un código concurrente.

* **Principio clave:** **NO TODO ALGORITMO PUEDE O DEBE EJECUTARSE EN PARALELO.**

---
## 5. Herramientas y Paquetes en Java
### `java.lang`

* **`Runnable`**: Interfaz funcional para definir la tarea a ejecutar.

* **`Thread`**: Clase que representa el hilo de ejecución.
### `java.util`

* **`Timer`**: Utilidad para programar tareas para ejecución futura.

* **`TimerTask`**: Tarea que puede ser programada por un `Timer`.
### `java.util.concurrent`

Proporciona herramientas avanzadas como ejecutores, colas, sincronizadores y estructuras de datos hilo-seguras (*thread-safe*).
#### A. Ejecución

* `Executor`

* `ExecutorService`

* `ScheduledExecutorService`
#### B. Resultados y Tiempo

* `Callable` *(retorna un valor o lanza una excepción)*

* `Future` *(representa el resultado de una computación asíncrona)*

* `TimeUnit` *(para el manejo de duraciones y tiempos de espera)*

#### C. Comunicación y Colas Safe-Thread

* `ConcurrentLinkedQueue`
* `BlockingQueue`
* `TransferQueue`
* `BlockingDeque`

## 6. Ejemplo Fichar

```java
public class Fichar extends Thread
	private String nombre;
	private String dia;
	private double hora;
	private static int personasTarde;
	private static int personasTemprano;
	
	public Fichar(String nombre, String dia, double hora){
	}
	
	@Override
	public void run(){
		try{
			Thread.sleep(100);
			if(getHora() > 8.00){
				sysout(getNombre() + " llego tarde el dia " + getDia());
				setPersonasTarde(getPersonasTarde() + 1);
			} else {
				sysout(getNombre() + " llego temprano el dia " + getDia());
				setPersonasTarde(getPersonasTemprano() + 1);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
```