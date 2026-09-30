package Ejercicio10;
import java.io.Serializable;

public class Mascota implements Serializable, Runnable {
  private static final long serialVersionUID = 1L;

  private int energia;
  private int hambre;

  private transient Thread hilo;
  private transient volatile boolean activa;

  public Mascota() {
    energia = 100;
    hambre = 0;
  }

  public synchronized void iniciar() {
    if (hilo != null && hilo.isAlive()) {
      return;
    }
    activa = true;
    hilo = new Thread(this, "Evolución de la mascota");
    hilo.setDaemon(true);
    hilo.start();
  }

  @Override
  public void run() {
    try {
      while (activa) {
        Thread.sleep(1000);
        synchronized (this) {
          if (activa) {
            energia = Math.max(0, energia - 1);
            hambre = Math.min(100, hambre + 1);
          }
        }
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  public synchronized void alimentar() {
    hambre = Math.max(0, hambre - 5);
  }

  public synchronized void descansar() {
    energia = Math.min(100, energia + 5);
  }

  @Override
  public synchronized String toString() {
    return "Energía: " + energia + "/100 | Hambre: " + hambre + "/100";
  }

  public void detener() throws InterruptedException {
    activa = false;
    if (hilo != null) {
      hilo.interrupt();
      hilo.join();
    }
  }
}