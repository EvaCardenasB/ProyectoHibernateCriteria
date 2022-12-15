package com.nttdata.hibernate.persistence;

import java.util.List;

public interface CommonDaoI<T> {

		/**
		 * Inserta un registro en DB.
		 * 
		 * @param paramT
		 */
		public void insert(final T paramT);
		
		/**
		 * Busca todos los registros de la DB.
		 * 
		 * @return List<T>
		 */
		public List<T> searchAll();
		
		/**
		 * Localiza un registro por id en la DB.
		 * 
		 * @param paramT
		 */
		public T searchById(final Long id);

		/**
		 * Elimina un registro en la DB.
		 * 
		 * @param paramT
		 */
		public void delete(final T paramT);
		
		/**
		 * Actualiza un registro en DB.
		 * 
		 * @param paramT
		 */
		public void update(final T paramT);
}
