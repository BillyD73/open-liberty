/*******************************************************************************
 * Copyright (c) 2021 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ws.jpa.fvt.entity.entities.versioning.xml;

import javax.persistence.Transient;

import com.ibm.ws.jpa.fvt.entity.entities.IVersionedEntity;

public class XMLVersionedIntWrapperEntity implements IVersionedEntity {
    private int id;

    private Integer version;

    private int intVal;

    private String stringVal;

    public XMLVersionedIntWrapperEntity() {
        // version = new Integer(0);
        intVal = 0;
        stringVal = "";
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getIntVal() {
        return intVal;
    }

    @Override
    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }

    @Override
    public String getStringVal() {
        return stringVal;
    }

    @Override
    public void setStringVal(String stringVal) {
        this.stringVal = stringVal;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    @Transient
    public Object getVersionObj() {
        return getVersion();
    }

    @Override
    public String toString() {
        return "XMLVersionedIntWrapperEntity [id=" + id + ", version=" + version + ", intVal=" + intVal
               + ", stringVal=" + stringVal + "]";
    }
}
