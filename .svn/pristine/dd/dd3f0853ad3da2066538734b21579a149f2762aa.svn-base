package com.infostretch.referral.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

/**
 * The Class GenericDaoImpl.
 *
 * @param <T>
 *          the generic type
 */
public class GenericDaoImpl<T> implements GenericDao<T> {

  /** The type. */
  private final Class<T> type;

  /** The entity manager. */
  @PersistenceContext
  private EntityManager entityManager;

  /**
   * Instantiates a new generic dao impl.
   *
   * @param type
   *          the type
   */
  public GenericDaoImpl(final Class<T> type) {
    super();
    this.type = type;

  }

  /**
   * Find by id.
   *
   * @param id
   *          the id
   * @return the t
   * @see com.infostretch.referral.dao.GenericDao#findById(java.lang.Integer)
   */
  @Transactional(readOnly = true)
  @Override
  public T findById(final Integer id) {
    if (id == null) {
      return null;
    } else {
      return this.entityManager.find(this.type, id);
    }
  }

  /**
   * Save.
   *
   * @param entity
   *          the entity
   * @see com.infostretch.referral.dao.GenericDao#save(java.lang.Object)
   */
  @Transactional(readOnly = false)
  @Override
  public void save(final T entity) {
    this.entityManager.persist(entity);

  }

  /**
   * Update.
   *
   * @param entity
   *          the entity
   * @see com.infostretch.referral.dao.GenericDao#update(java.lang.Object)
   */
  @Transactional(readOnly = false)
  @Override
  public void update(final T entity) {
    this.entityManager.merge(entity);

  }
}
