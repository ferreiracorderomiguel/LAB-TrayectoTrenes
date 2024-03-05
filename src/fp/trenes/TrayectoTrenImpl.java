package fp.trenes;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import fp.utiles.Checkers;

public class TrayectoTrenImpl implements TrayectoTren {
    // Atributos
    private String codigoDelTren;
    private String nombreDelTrayecto;
    private TipoTren tipo;
    private List<String> estaciones;
    private List<LocalTime> horasSalida;
    private List<LocalTime> horasLlegada;
    private LocalTime horaSalida;
    private LocalTime horaLlegada;
    private Duration duracionTrayecto;
	

    // Constructores
    public TrayectoTrenImpl(String codigoDelTren, String nombreDelTrayecto, TipoTren tipo, List<String> estaciones,
			LocalTime horaSalida, LocalTime horaLlegada) {
		Checkers.check("El códugo del un tren debe estar formado por 5 dígitos.", codigoDelTren.length() == 5);
		Checkers.check("La hora de salida de la primera estación no puede ser nula.", horasSalida.get(0) != null);
		Checkers.check("La hora de llegada a la última estación no puede ser nula.", horasLlegada.get((horasLlegada.size()) - 1) != null);
		Checkers.check("La hora de salida de la primera estación debe ser anterior a la hora de llegada a la última estación.", comprobarHoras(horasSalida.get(0), horasLlegada.get((horasLlegada.size()) - 1)));
		this.codigoDelTren = codigoDelTren;
		this.nombreDelTrayecto = nombreDelTrayecto;
		this.tipo = tipo;
		this.estaciones = estaciones;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
	}


	


	// Métodos
    private Boolean comprobarHoras(LocalTime localTime, LocalTime localTime2) {
		return localTime.isBefore(localTime2);
	}
    
	@Override
	public LocalTime getHoraSalida(String estacion) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public LocalTime getHoraLlegada(String estacion) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void anadirEstacionIntermedia(int posicion, String estacion, LocalTime horaLlegada, LocalTime horaSalida) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void eliminarEstacionIntermedia(String estacion) {
		// TODO Auto-generated method stub
		
	}

	public String getCodigoDelTren() {
		return codigoDelTren;
	}

	public String getNombreDelTrayecto() {
		return nombreDelTrayecto;
	}

	public TipoTren getTipo() {
		return tipo;
	}

	public List<String> getEstaciones() {
		return estaciones;
	}

	public List<LocalTime> getHorasLlegada() {
		return horasLlegada;
	}

	public LocalTime getHoraSalida() {
		return horaSalida;
	}

	@Override
	public String toString() {
		String cadena = nombreDelTrayecto + "-" + tipo + "(" + codigoDelTren + ")";
		for (int i=0; i<estaciones.size(); i++) {
			cadena += "\n" + estaciones.get(i) + "\t" + horasLlegada.get(i) + "\t" + horasSalida.get(i);
		}
		return cadena;
	}
	
	
}
