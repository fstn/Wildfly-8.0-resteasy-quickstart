/**
 * 
 */
package com.fstn.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;


/**
 * The Class AbstractDAO.
 *
 * @author stephen
 * @param <ENTITY>
 *            the generic type
 */
public abstract class AbstractDAO<ENTITY> {

	/** The entity class. */
	private Class<ENTITY> entityClass;

	/** The entity manager. */
	private EntityManager entityManager;

	/**
	 * Instantiates a new abstract dao.
	 *
	 * @param entity
	 *            the entity
	 * @param entityManager
	 *            the entity manager
	 */
	public AbstractDAO(Class<ENTITY> entity, EntityManager entityManager) {
		super();
		this.entityClass = entity;
		this.entityManager = entityManager;
	}

	/**
	 * Creates the.
	 *
	 * @param entity
	 *            the entity
	 */
	public void create(ENTITY entity) {
		entityManager.persist(entity);
	}

	/**
	 * Edits the.
	 *
	 * @param entity
	 *            the entity
	 */
	public void edit(ENTITY entity) {
		entityManager.merge(entity);
	}

	/**
	 * Removes the.
	 *
	 * @param entity
	 *            the entity
	 */
	public void remove(ENTITY entity) {
		entityManager.remove(entityManager.merge(entity));
	}

	/**
	 * Find.
	 *
	 * @param id
	 *            the id
	 * @return the entity
	 */
	public ENTITY find(Object id) {
		return entityManager.find(entityClass, id);
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<ENTITY> findAll() {
		CriteriaQuery<ENTITY> cq = entityManager.getCriteriaBuilder()
				.createQuery(entityClass);
		cq.select(cq.from(entityClass));
		return entityManager.createQuery(cq).getResultList();
	}

	/**
	 * Find range.
	 *
	 * @param range
	 *            the range
	 * @return the list
	 */
	public List<ENTITY> findRange(int[] range) {
		CriteriaQuery<ENTITY> cq = entityManager.getCriteriaBuilder()
				.createQuery(entityClass);
		cq.select(cq.from(entityClass));
		TypedQuery<ENTITY> q = entityManager.createQuery(cq);
		q.setMaxResults(range[1] - range[0]);
		q.setFirstResult(range[0]);
		return q.getResultList();
	}

	/**
	 * Count.
	 *
	 * @return the int
	 */
	public int count() {
		CriteriaQuery<Long> cq = entityManager.getCriteriaBuilder()
				.createQuery(Long.class);
		javax.persistence.criteria.Root<ENTITY> rt = cq.from(entityClass);
		cq.select(entityManager.getCriteriaBuilder().count(rt));
		TypedQuery<Long> q = entityManager.createQuery(cq);
		return ((Long) q.getSingleResult()).intValue();
	}
}
