package hibernateEntity.base;

import java.io.Serializable;


/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is an object that contains data related to the ligne table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ligne"
 */
public abstract class BaseLigne  implements Serializable {

	public static String PROP_FRAIS = "Frais";
	public static String PROP_ETAT = "Etat";
	public static String PROP_ID = "Id";
	public static String PROP_NUMERO_LIGNE = "NumeroLigne";


	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer _id;

	// fields
	private java.lang.String _numeroLigne;
	private java.lang.String _etat;
	private java.lang.Float _frais;

	// collections
	private java.util.Set _factureSet;
	private java.util.Set _porteurSet;


	// constructors
	public BaseLigne () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLigne (java.lang.Integer _id) {
		this.setId(_id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseLigne (
		java.lang.Integer _id,
		java.lang.String _numeroLigne) {

		this.setId(_id);
		this.setNumeroLigne(_numeroLigne);
		initialize();
	}

	protected void initialize () {}



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="ID"
     */
	public java.lang.Integer getId () {
		return _id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _id the new ID
	 */
	public void setId (java.lang.Integer _id) {
		this._id = _id;
		this.hashCode = Integer.MIN_VALUE;
	}


	/**
	 * Return the value associated with the column: numeroLigne
	 */
	public java.lang.String getNumeroLigne () {
		return _numeroLigne;
	}

	/**
	 * Set the value related to the column: numeroLigne
	 * @param _numeroLigne the numeroLigne value
	 */
	public void setNumeroLigne (java.lang.String _numeroLigne) {
		this._numeroLigne = _numeroLigne;
	}


	/**
	 * Return the value associated with the column: etat
	 */
	public java.lang.String getEtat () {
		return _etat;
	}

	/**
	 * Set the value related to the column: etat
	 * @param _etat the etat value
	 */
	public void setEtat (java.lang.String _etat) {
		this._etat = _etat;
	}


	/**
	 * Return the value associated with the column: frais
	 */
	public java.lang.Float getFrais () {
		return _frais;
	}

	/**
	 * Set the value related to the column: frais
	 * @param _frais the frais value
	 */
	public void setFrais (java.lang.Float _frais) {
		this._frais = _frais;
	}


	/**
	 * Return the value associated with the column: FactureSet
	 */
	public java.util.Set getFactureSet () {
		return this._factureSet;
	}

	/**
	 * Set the value related to the column: FactureSet
	 * @param _factureSet the FactureSet value
	 */
	public void setFactureSet (java.util.Set _factureSet) {
		this._factureSet = _factureSet;
	}
	
	public void addToFactureSet (Object obj) {
		if (null == this._factureSet) this._factureSet = new java.util.HashSet();
		this._factureSet.add(obj);
	}



	/**
	 * Return the value associated with the column: PorteurSet
	 */
	public java.util.Set getPorteurSet () {
		return this._porteurSet;
	}

	/**
	 * Set the value related to the column: PorteurSet
	 * @param _porteurSet the PorteurSet value
	 */
	public void setPorteurSet (java.util.Set _porteurSet) {
		this._porteurSet = _porteurSet;
	}
	
	public void addToPorteurSet (Object obj) {
		if (null == this._porteurSet) this._porteurSet = new java.util.HashSet();
		this._porteurSet.add(obj);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof hibernateEntity.base.BaseLigne)) return false;
		else {
			hibernateEntity.base.BaseLigne mObj = (hibernateEntity.base.BaseLigne) obj;
			if (null == this.getId() || null == mObj.getId()) return false;
			else return (this.getId().equals(mObj.getId()));
		}
	}


	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}

}