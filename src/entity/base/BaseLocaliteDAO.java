package entity.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import entity.dao.LocaliteDAO;

/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseLocaliteDAO extends entity.dao._RootDAO {

	public static LocaliteDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static LocaliteDAO getInstance () {
		if (null == instance) instance = new LocaliteDAO();
		return instance;
	}

	/**
	 * entity.dao._RootDAO _RootDAO.getReferenceClass()
	 */
	public Class getReferenceClass () {
		return entity.Localite.class;
	}
	
	public entity.Localite load(java.lang.Integer key)
		throws org.hibernate.HibernateException {
		return (entity.Localite) load(getReferenceClass(), key);
	}

	public entity.Localite load(java.lang.Integer key, Session s)
		throws org.hibernate.HibernateException {
		return (entity.Localite) load(getReferenceClass(), key, s);
	}

	public entity.Localite loadInitialize(java.lang.Integer key, Session s) 
			throws org.hibernate.HibernateException { 
		entity.Localite obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param localite a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(entity.Localite localite)
		throws org.hibernate.HibernateException {
		return (java.lang.Integer) super.save(localite);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param localite a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(entity.Localite localite, Session s)
		throws org.hibernate.HibernateException {
		return (java.lang.Integer) super.save(localite, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param localite a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(entity.Localite localite)
		throws org.hibernate.HibernateException {
		super.saveOrUpdate(localite);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param localite a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(entity.Localite localite, Session s)
		throws org.hibernate.HibernateException {
		super.saveOrUpdate(localite, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param localite a transient instance containing updated state
	 */
	public void update(entity.Localite localite) 
		throws org.hibernate.HibernateException {
		super.update(localite);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param localite a transient instance containing updated state
	 * @param the Session
	 */
	public void update(entity.Localite localite, Session s)
		throws org.hibernate.HibernateException {
		super.update(localite, s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(java.lang.Integer id)
		throws org.hibernate.HibernateException {
		super.delete(load(id));
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param id the instance ID to be removed
	 * @param s the Session
	 */
	public void delete(java.lang.Integer id, Session s)
		throws org.hibernate.HibernateException {
		super.delete(load(id, s), s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param localite the instance to be removed
	 */
	public void delete(entity.Localite localite)
		throws org.hibernate.HibernateException {
		super.delete(localite);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param localite the instance to be removed
	 * @param s the Session
	 */
	public void delete(entity.Localite localite, Session s)
		throws org.hibernate.HibernateException {
		super.delete(localite, s);
	}
	
	/**
	 * Re-read the state of the given instance from the underlying database. It is inadvisable to use this to implement
	 * long-running sessions that span many business tasks. This method is, however, useful in certain special circumstances.
	 * For example 
	 * <ul> 
	 * <li>where a database trigger alters the object state upon insert or update</li>
	 * <li>after executing direct SQL (eg. a mass update) in the same session</li>
	 * <li>after inserting a Blob or Clob</li>
	 * </ul>
	 */
	public void refresh (entity.Localite localite, Session s)
		throws org.hibernate.HibernateException {
		super.refresh(localite, s);
	}

    public String getDefaultOrderProperty () {
		return null;
    }

}