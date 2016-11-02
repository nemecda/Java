package hra;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Hrac {

	//sirka hrace
	public static final int SIRKA =40;
	//vyska hrace
	public static final int VYSKA =40;
	//velikost skoku hrace
	private static final int KOEF_ZRYCHLENI = 1;
	//rychlost padu hrace
	private static final int KOEF_RYCHLOST = 2;
	//bufferovany obrazek (pamatuje si obrazek, i kdyz se minimalizuje a maximalizuje okno)
	private BufferedImage img = null;
	//pocatecni x-ova souradnice hrace, nemeni se(hrac skace jen nahoru dolu)
	private int x;
	//pocatecni y-ova pozice hrace, meni se(hrac skace nahoru dolu)
	private int y;
	private int rychlost;
	
	public Hrac(BufferedImage img) {
		this.img=img;
		x = (HraciPlocha.SIRKA/2) - (img.getWidth()/2); //aby byl obrazek na stredu
		y = HraciPlocha.VYSKA/2;
		rychlost = KOEF_RYCHLOST;
		
	}
	
	//Vola se po narazu do zdi , ci kraje okna (vraceni postavicky zopatky na stred)
	public void reset(){
		y = HraciPlocha.VYSKA/2;
		rychlost = KOEF_RYCHLOST;
	}
	//zjistime ,kde se nachazi hrac na X
	public int getX() {
		return x;
	}
	//zjistime , kde se nachazi hrac na Y
	public int getY() {
		return y;
	}
	
	//kdyz kliknu na tlacitko, co ma provest - skok postavicky
	public void skok(){
		rychlost = -17; //prednastavena hodnota 17
		
	}
	//zajistuje pohyb hrace
	public void posun(){
		rychlost = rychlost + KOEF_ZRYCHLENI; //urceni rychlosti
		y = y + rychlost; //pripocteni k souradnicim
	}
	//vykresleni hrace
	public void paint(Graphics g){
		g.drawImage(img, x, y, null);
		
	}
	//kvuli narazum vraci vysku hrace
	public int getVyskaHrace(){
		return img.getHeight();
	}
	
	//vraci pomyslny ctverec/obdelnik (dle nastavenych hodnot - sirka ,vyska,) ktery opisuje hrace
	public Rectangle getMez(){
		return new Rectangle(x,y,img.getWidth(),img.getHeight());
	}
	
}
