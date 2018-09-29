package controller;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

import entities.Module;

public class Interceptor extends EmptyInterceptor {
	private int updates;
	private int creates;
	private int loads;

	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		// do nothing
	}

	// This method is called when Module object gets updated.
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		if (entity instanceof Module) {
			System.out.println("Interceptor: Update Operation");
			return true;
		}
		return false;
	}

	public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		// do nothing
		return true;
	}

	// This method is called when Module object gets created.
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		if (entity instanceof Module) {
			System.out.println("Interceptor: Create Operation");
			return true;
		}
		return false;
	}

	// called before commit into database
	public void preFlush(Iterator iterator) {
		// System.out.println("Interceptor: preFlush");
	}

	// called after committed into database
	public void postFlush(Iterator iterator) {
		// System.out.println("Interceptor: postFlush");
	}
}
