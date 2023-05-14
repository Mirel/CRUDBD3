package control;

/**
 * @author mirelle
 *creo clase con los atributos y sus constructores , getters, setters ,y toString.
 */
public class Libros {

	private int idlibro;
	private String titulo;
	private String autor;
	private String tipologia;

	public Libros(String titulo, String autor, String tipologia) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.tipologia = tipologia;
	}

	public Libros(int idlibro, String titulo, String autor, String tipologia) {
		super();
		this.idlibro = idlibro;
		this.titulo = titulo;
		this.autor = autor;
		this.tipologia = tipologia;
	}

	public int getIdlibro() {
		return idlibro;
	}

	public void setIdlibro(int idlibro) {
		this.idlibro = idlibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	@Override
	public String toString() {
		return "Libros [idlibro=" + idlibro + ", titulo=" + titulo + ", autor=" + autor + ", tipologia=" + tipologia
				+ "]";
	}

}
