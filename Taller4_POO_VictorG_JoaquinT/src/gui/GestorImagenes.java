package gui;

import java.io.File;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Clase encargada de buscar, cargar y escalar imagenes de cartas.
 * Si no encuentra una imagen especifica, usa una imagen por defecto.
 */
public class GestorImagenes {

	private static final String CARPETA_IMAGENES = "imagenes/";
	private static final String IMAGEN_DEFECTO = "imagenes/default.png";

	/**
	 * Busca la ruta de imagen de una carta segun su nombre.
	 * Primero intenta con png, luego jpg y finalmente jpeg.
	 *
	 * @param nombreCarta nombre de la carta
	 * @return ruta encontrada o ruta de imagen por defecto
	 */
	public static String ObtenerRutaImagen(String nombreCarta) {

		String rutaPng = CARPETA_IMAGENES + nombreCarta + ".png";
		String rutaJpg = CARPETA_IMAGENES + nombreCarta + ".jpg";
		String rutaJpeg = CARPETA_IMAGENES + nombreCarta + ".jpeg";

		File archivoPng = new File(rutaPng);
		File archivoJpg = new File(rutaJpg);
		File archivoJpeg = new File(rutaJpeg);

		if (archivoPng.exists()) {
			return rutaPng;
		}

		if (archivoJpg.exists()) {
			return rutaJpg;
		}

		if (archivoJpeg.exists()) {
			return rutaJpeg;
		}

		return IMAGEN_DEFECTO;
	}

	/**
	 * Crea un ImageIcon escalado a partir del nombre de una carta.
	 *
	 * @param nombreCarta nombre de la carta
	 * @param ancho ancho deseado
	 * @param alto alto deseado
	 * @return icono escalado
	 */
	public static ImageIcon CrearIconoCarta(String nombreCarta, int ancho, int alto) {

		String ruta = ObtenerRutaImagen(nombreCarta);

		ImageIcon iconoOriginal = new ImageIcon(ruta);
		Image imagenOriginal = iconoOriginal.getImage();
		Image imagenEscalada = imagenOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

		return new ImageIcon(imagenEscalada);
	}
}