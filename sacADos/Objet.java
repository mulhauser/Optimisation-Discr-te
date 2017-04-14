package sacADos;

/**
 * represente les objets dans le sac a dos
 *
 */
public class Objet {

	public int volume;

	public int valeur;
	public double densite;

	/**
	 * constructeur par defaut
	 * 
	 * @param val
	 *            valeur de objet
	 * @param vol
	 *            volume de objet
	 */
	public Objet(int val, int vol) {
		this.valeur = val;
		this.volume = vol;
		this.densite = (1.0 * val) / (vol);
	}
}
