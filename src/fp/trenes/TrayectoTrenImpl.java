package fp.trenes;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;

public class TrayectoTrenImpl implements TrayectoTren, Comparable<TrayectoTrenImpl> {
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
        Checkers.check("El código del tren debe estar formado por 5 dígitos.", codigoDelTren.length() == 5);
        Checkers.check("La hora de salida de la primera estación no puede ser nula.", horaSalida != null);
        Checkers.check("La hora de llegada a la última estación no puede ser nula.", horaLlegada != null);
        Checkers.check("La hora de salida de la primera estación debe ser anterior a la hora de llegada a la última estación.", horaSalida.isBefore(horaLlegada));
        this.codigoDelTren = codigoDelTren;
        this.nombreDelTrayecto = nombreDelTrayecto;
        this.tipo = tipo;
        this.estaciones = new ArrayList<>(estaciones);
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.horasSalida = new ArrayList<>();
        this.horasSalida.add(horaSalida);
        this.horasSalida.add(null);
        this.horasLlegada = new ArrayList<>();
        this.horasLlegada.add(null);
        this.horasLlegada.add(horaLlegada);
        this.duracionTrayecto = Duration.between(horaSalida, horaLlegada);
    }


	// Métodos    
	@Override
	public LocalTime getHoraSalida(String estacion) {
		return horasSalida.get(estaciones.indexOf(estacion));
	}


	@Override
	public LocalTime getHoraLlegada(String estacion) {
		return horasLlegada.get(estaciones.indexOf(estacion));
	}


	@Override
	public void anadirEstacionIntermedia(int posicion, String estacion, LocalTime horaLlegada, LocalTime horaSalida) {
		this.estaciones.add(posicion, estacion);
		this.horasLlegada.add(posicion, horaLlegada);
		this.horasSalida.add(posicion, horaSalida);
	}


	@Override
	public void eliminarEstacionIntermedia(String estacion) {
		if (estaciones.contains(estacion)) {
			estaciones.remove(estacion);
            System.out.println("Estación '" + estacion + "' borrada correctamente.");
        } else {
            throw new IllegalArgumentException("La estación " + estacion + " no estaba en la lista de estaciones, por lo que no se puede borrar.");
        }
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
	public int hashCode() {
		return Objects.hash(codigoDelTren, horaSalida, nombreDelTrayecto);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrayectoTrenImpl other = (TrayectoTrenImpl) obj;
		return Objects.equals(codigoDelTren, other.codigoDelTren) && Objects.equals(horaSalida, other.horaSalida)
				&& Objects.equals(nombreDelTrayecto, other.nombreDelTrayecto);
	}
	
	@Override
	public int compareTo(TrayectoTrenImpl o) {
		int r = nombreDelTrayecto.compareTo(o.getNombreDelTrayecto());
		
		if (r == 0) {
			r = horaSalida.compareTo(o.getHoraSalida());
			if (r == 0) {
				r = codigoDelTren.compareTo(o.getCodigoDelTren());
			}
		}
		
		return r;
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