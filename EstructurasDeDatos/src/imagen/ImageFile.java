package imagen;

import javax.imageio.ImageIO;
import estructurasnolineales.MatrizInfo2Numerica;
import utilerias.comunes.Tamanio;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageFile {

    private BufferedImage imagen;
    private BufferedImage imagen2;
    private int w;//Ancho
    private int h;//Altura
    private MatrizInfo2Numerica matrizDePixeles;
    private int alfa;
    private int rojo;
    private int verde;
    private int azul;
    private int pixel;

    public ImageFile() throws IOException{
        this.imagen = ImageIO.read(new File("src/Imagen.jpg"));
        this.w = imagen.getWidth();
        this.h = imagen.getHeight();
        imagen2 = new BufferedImage(w, h,BufferedImage.TYPE_INT_RGB);
        matrizDePixeles = new MatrizInfo2Numerica(h,w);
        for (int ancho = 0; ancho < w; ancho++) {
            for (int alto = 0; alto < h; alto++) {
                this.pixel = imagen.getRGB(ancho, alto);        
                imagen2.setRGB(ancho, alto, pixel);
                matrizDePixeles.cambiar(ancho, alto, pixel);//Aqui extraigo los valores de los pixeles
            }        
        }
        ImageIO.write(imagen2, "JPG", new File("src/espejo.jpg"));
    }
    
    public void escalaDeGrises(){
        try {
            for (int ancho = 0; ancho < this.w; ancho++) {
                for (int alto = 0; alto < this.h; alto++) {
                    this.pixel = imagen.getRGB(ancho, alto);    
                    this.alfa = (pixel >> 24) & 0xFF;
                    this.rojo = (pixel >> 16) & 0xFF;
                    this.verde = (pixel >> 8) & 0xFF;
                    this.azul = pixel & 0xFF;
                    int promedio = (rojo + verde + azul) / 3;
                    int pixelEscalaDeGrises = (alfa << 24) | (promedio << 16) | (promedio << 8) | promedio;//Combinamos los componentes
                    imagen2.setRGB(ancho, alto, pixelEscalaDeGrises);
                }        
            }
            ImageIO.write(imagen2, "JPG", new File("src/espejo.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    

    public void controlarBrillo(int unidadIncremental) {
        try {
            for (int ancho = 0; ancho < this.w; ancho++) {
                for (int alto = 0; alto < this.h; alto++) {
                    this.pixel = imagen.getRGB(ancho, alto);
                    int alfa = (pixel >> 24) & 0xFF;
                    int rojo = (pixel >> 16) & 0xFF;
                    int verde = (pixel >> 8) & 0xFF;
                    int azul = pixel & 0xFF;
                    int valorEscalaDeGrises = (rojo + verde + azul) / 3;
                    valorEscalaDeGrises = valorEscalaDeGrises + unidadIncremental;
                    valorEscalaDeGrises = Math.min(Math.max(valorEscalaDeGrises, 0), 255);//Aqui nos aseguramos de que no se pase de 255
                    int nuevoPixel = (alfa << 24) | (valorEscalaDeGrises << 16) | (valorEscalaDeGrises << 8) | valorEscalaDeGrises;
                    imagen2.setRGB(ancho, alto, nuevoPixel);
                }
            }
            ImageIO.write(imagen2, "JPG", new File("src/espejo.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void posicionHorizontal() {
        try {
            for (int alto = 0; alto < this.h; alto++) {//Iteramos en la imagen 
                int[] filaOriginal = new int[this.w];
                imagen2.getRGB(0, alto, this.w, 1, filaOriginal, 0, this.w);
                int[] filaInvertida = new int[this.w];
                for (int ancho = 0; ancho < this.w; ancho++) {
                    filaInvertida[ancho] = filaOriginal[this.w - ancho - 1];
                }
                imagen2.setRGB(0, alto, this.w, 1, filaInvertida, 0, this.w);
            }
            ImageIO.write(imagen2, "JPG", new File("src/espejo.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    

    public void posicionVertical() {
        try {//Hacemos lo mismo que ne posicion horizontal
            for (int ancho = 0; ancho < this.w; ancho++) {
                int[] columnaOriginal = new int[this.h];//Usamos la altura
                imagen2.getRGB(ancho, 0, 1, this.h, columnaOriginal, 0, 1);
                int[] columnaInvertida = new int[this.h];
                for (int alto = 0; alto < this.h; alto++) {
                    columnaInvertida[alto] = columnaOriginal[this.h - alto - 1];
                }
                imagen2.setRGB(ancho, 0, 1, this.h, columnaInvertida, 0, 1);
            }
            ImageIO.write(imagen2, "JPG", new File("src/espejo.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void rotar90Grados(){
        try {
            double centroX = this.w / 2.0;//Obtenemos el centro de la imagen 
            double centroY = this.h / 2.0;
            //Usamos affine transform para hacer una rotación a la imagen con radianes
            AffineTransform rotacion = AffineTransform.getRotateInstance(Math.toRadians(90), centroX, centroY);
            Graphics2D imagenRotada = this.imagen2.createGraphics();
            imagenRotada.drawImage(this.imagen, rotacion, null);//Este metodo se usa para dibujar la nueva imagen
            imagenRotada.dispose();//Limpiamos buffers para no perder rendimiento
            ImageIO.write(this.imagen2, "JPG", new File("src/espejo.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rotar180Grados(){
        try {
            double centroX = this.w / 2.0;//Obtenemos el centro de la imagen 
            double centroY = this.h / 2.0;
            //Usamos affine transform para hacer una rotación a la imagen con radianes
            AffineTransform rotacion = AffineTransform.getRotateInstance(Math.toRadians(180), centroX, centroY);
            Graphics2D imagenRotada = this.imagen2.createGraphics();
            imagenRotada.drawImage(this.imagen, rotacion, null);//Este metodo se usa para dibujar la nueva imagen
            imagenRotada.dispose();//Limpiamos buffers para no perder rendimiento
            ImageIO.write(this.imagen2, "JPG", new File("src/espejo.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rotar270Grados(){
        try {
            double centroX = this.w / 2.0;//Obtenemos el centro de la imagen 
            double centroY = this.h / 2.0;
            //Usamos affine transform para hacer una rotación a la imagen con radianes
            AffineTransform rotacion = AffineTransform.getRotateInstance(Math.toRadians(270), centroX, centroY);
            Graphics2D imagenRotada = this.imagen2.createGraphics();
            imagenRotada.drawImage(this.imagen, rotacion, null);//Este metodo se usa para dibujar la nueva imagen
            imagenRotada.dispose();//Limpiamos buffers para no perder rendimiento
            ImageIO.write(this.imagen2, "JPG", new File("src/espejo.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transpuesta() {
        this.matrizDePixeles.transpuesta();
    }

    public void redimensionar(Tamanio tipo) throws IOException {
        int anchoActual = this.imagen.getWidth();
        int alturaActual = this.imagen.getHeight();
        switch (tipo) {
            case DOBLE:
                anchoActual = anchoActual * 2;
                alturaActual = alturaActual * 2;
                break;
            case TRIPLE:
                anchoActual = anchoActual * 3;
                alturaActual = alturaActual * 3;
                break;
            case CUADRUPLE:
                anchoActual = anchoActual * 4;
                alturaActual = alturaActual * 4;
                break;
            case MITAD:
                anchoActual = anchoActual / 2;
                alturaActual = alturaActual / 2;
                break;
            case TERCERA_PARTE:
                anchoActual = anchoActual / 3;
                alturaActual = alturaActual / 3;
                break;
            default:
                break;
        }
    }

    public void marco(Color color, int grosor){
        try {
            BufferedImage imagenOriginal = ImageIO.read(new File("src/Imagen.jpg"));
            int anchoOriginal = imagenOriginal.getWidth();
            int altoOriginal = imagenOriginal.getHeight();
            int anchoConMarco = anchoOriginal + 2 * grosor;//Ajustamos el ancho para evitar errores
            int altoConMarco = altoOriginal + 2 * grosor;
            BufferedImage imagenConMarco = new BufferedImage(anchoConMarco, altoConMarco, BufferedImage.TYPE_INT_RGB);
            Graphics2D img = imagenConMarco.createGraphics();//Aqui vamos a manipular la imagen
            img.setColor(color);
            img.fillRect(0, 0, anchoConMarco, altoConMarco);
            img.drawImage(imagenOriginal, null, grosor, grosor);
            img.dispose();
            ImageIO.write(imagenConMarco, "jpg", new File("src/espejo.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void invertirColores(){
        try {
            for (int ancho = 0; ancho < this.w; ancho++) {
                for (int alto = 0; alto < this.h; alto++) {
                    this.pixel = imagen.getRGB(ancho, alto);
                    imagen2.setRGB(ancho, alto, pixel*-1);
                }
            }
            ImageIO.write(imagen2, "JPG", new File("src/espejo.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}