package fp.trenes;

import java.time.LocalTime;

public interface TrayectoTren {
	// Atributos	
	public LocalTime getHoraSalida(String estacion);
	public LocalTime getHoraLlegada(String estacion);
	public void anadirEstacionIntermedia(int posicion, String estacion, LocalTime horaLlegada, LocalTime horaSalida);
	public void eliminarEstacionIntermedia(String estacion);
}
