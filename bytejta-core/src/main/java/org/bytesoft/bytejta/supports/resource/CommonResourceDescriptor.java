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
package org.bytesoft.bytejta.supports.resource;

import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;

import org.bytesoft.transaction.supports.resource.XAResourceDescriptor;

public class CommonResourceDescriptor implements XAResourceDescriptor {

	private XAResource delegate;
	private String identifier;

	public String toString() {
		return String.format("common-resource[id= %s]", this.identifier);
		// return String.format("common-resource[id= %s, delegate= %s]", this.identifier, this.delegate);
	}

	public void setTransactionTimeoutQuietly(int timeout) {
		try {
			this.delegate.setTransactionTimeout(timeout);
		} catch (Exception ex) {
			// ignore
		}
	}

	public void commit(Xid arg0, boolean arg1) throws XAException {
		delegate.commit(arg0, arg1);
	}

	public void end(Xid arg0, int arg1) throws XAException {
		delegate.end(arg0, arg1);
	}

	public void forget(Xid arg0) throws XAException {
		delegate.forget(arg0);
	}

	public int getTransactionTimeout() throws XAException {
		return delegate.getTransactionTimeout();
	}

	public boolean isSameRM(XAResource arg0) throws XAException {
		return delegate.isSameRM(arg0);
	}

	public int prepare(Xid arg0) throws XAException {
		return delegate.prepare(arg0);
	}

	public Xid[] recover(int arg0) throws XAException {
		return delegate.recover(arg0);
	}

	public void rollback(Xid arg0) throws XAException {
		delegate.rollback(arg0);
	}

	public boolean setTransactionTimeout(int arg0) throws XAException {
		return delegate.setTransactionTimeout(arg0);
	}

	public void start(Xid arg0, int arg1) throws XAException {
		delegate.start(arg0, arg1);
	}

	public XAResource getDelegate() {
		return delegate;
	}

	public void setDelegate(XAResource delegate) {
		this.delegate = delegate;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

}
