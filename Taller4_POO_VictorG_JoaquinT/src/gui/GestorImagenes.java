package gui;

import java.io.File;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Clase usada para cargar imagenes de cartas.
 */
public class GestorImagenes {

	private static final String CARPETA_IMAGENES = "imagenes/";
	private static final String IMAGEN_DEFECTO = "imagenes/default.png";

	/**
	 * Busca la imagen de una carta.
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
	 * Crea un icono escalado.
	 */
	public static ImageIcon CrearIconoCarta(String nombreCarta, int ancho, int alto) {

		String ruta = ObtenerRutaImagen(nombreCarta);

		ImageIcon iconoOriginal = new ImageIcon(ruta);
		Image imagenOriginal = iconoOriginal.getImage();
		Image imagenEscalada = imagenOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

		return new ImageIcon(imagenEscalada);
	}
}