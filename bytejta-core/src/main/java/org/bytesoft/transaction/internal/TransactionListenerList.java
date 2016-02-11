/**
 * Copyright 2014-2016 yangming.liu<bytefox@126.com>.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, see <http://www.gnu.org/licenses/>.
 */
package org.bytesoft.transaction.internal;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.bytesoft.transaction.supports.TransactionListener;

public class TransactionListenerList implements TransactionListener {
	static final Logger logger = Logger.getLogger(TransactionListenerList.class.getSimpleName());

	private final List<TransactionListener> listeners = new ArrayList<TransactionListener>();

	public void registerTransactionListener(TransactionListener listener) {
		this.listeners.add(listener);
	}

	public void prepareStart() {
		for (int i = 0; i < this.listeners.size(); i++) {
			try {
				TransactionListener listener = this.listeners.get(i);
				listener.prepareStart();
			} catch (RuntimeException rex) {
				logger.debug(rex.getMessage(), rex);
			}
		}
	}

	public void prepareSuccess() {
		for (int i = 0; i < this.listeners.size(); i++) {
			try {
				TransactionListener listener = this.listeners.get(i);
				listener.prepareSuccess();
			} catch (RuntimeException rex) {
				logger.debug(rex.getMessage(), rex);
			}
		}
	}

	public void prepareFailure() {
		for (int i = 0; i < this.listeners.size(); i++) {
			try {
				TransactionListener listener = this.listeners.get(i);
				listener.prepareFailure();
			} catch (RuntimeException rex) {
				logger.debug(rex.getMessage(), rex);
			}
		}
	}

	public void commitStart() {
		for (int i = 0; i < this.listeners.size(); i++) {
			try {
				TransactionListener listener = this.listeners.get(i);
				listener.commitStart();
			} catch (RuntimeException rex) {
				logger.debug(rex.getMessage(), rex);
			}
		}
	}

	public void commitSuccess() {
		for (int i = 0; i < this.listeners.size(); i++) {
			try {
				TransactionListener listener = this.listeners.get(i);
				listener.commitSuccess();
			} catch (RuntimeException rex) {
				logger.debug(rex.getMessage(), rex);
			}
		}
	}

	public void commitFailure() {
		for (int i = 0; i < this.listeners.size(); i++) {
			try {
				TransactionListener listener = this.listeners.get(i);
				listener.commitFailure();
			} catch (RuntimeException rex) {
				logger.debug(rex.getMessage(), rex);
			}
		}
	}

	public void commitHeuristicMixed() {
		for (int i = 0; i < this.listeners.size(); i++) {
			try {
				TransactionListener listener = this.listeners.get(i);
				listener.commitHeuristicMixed();
			} catch (RuntimeException rex) {
				logger.debug(rex.getMessage(), rex);
			}
		}
	}

	public void commitHeuristicRolledback() {
		for (int i = 0; i < this.listeners.size(); i++) {
			try {
				TransactionListener listener = this.listeners.get(i);
				listener.commitHeuristicRolledback();
			} catch (RuntimeException rex) {
				logger.debug(rex.getMessage(), rex);
			}
		}
	}

	public void rollbackStart() {
		for (int i = 0; i < this.listeners.size(); i++) {
			try {
				TransactionListener listener = this.listeners.get(i);
				listener.rollbackStart();
			} catch (RuntimeException rex) {
				logger.debug(rex.getMessage(), rex);
			}
		}
	}

	public void rollbackSuccess() {
		for (int i = 0; i < this.listeners.size(); i++) {
			try {
				TransactionListener listener = this.listeners.get(i);
				listener.rollbackSuccess();
			} catch (RuntimeException rex) {
				logger.debug(rex.getMessage(), rex);
			}
		}
	}

	public void rollbackFailure() {
		for (int i = 0; i < this.listeners.size(); i++) {
			try {
				TransactionListener listener = this.listeners.get(i);
				listener.rollbackFailure();
			} catch (RuntimeException rex) {
				logger.debug(rex.getMessage(), rex);
			}
		}
	}

}
