/*++

Copyright (C) 2019 3MF Consortium (Original Author)

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright notice,
this list of conditions and the following disclaimer in the documentation
and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

This file has been generated by the Automatic Component Toolkit (ACT) version 1.7.0-develop.

Abstract: This is an autogenerated Java file in order to allow an easy
 use of the 3MF Library

Interface version: 2.0.0

*/

package com.aibuild.lib3mf4j;

import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import java.lang.ref.Cleaner;


import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class MultiPropertyGroup extends Resource {

	public MultiPropertyGroup(Lib3MFWrapper wrapper, Pointer handle) {
		super(wrapper, handle);
	}

	/**
	 * Retrieves the count of MultiProperty-s in the MultiPropertyGroup.
	 *
	 * @return returns the count of MultiProperty-s
	 * @throws Lib3MFException
	 */
	public int getCount() throws Lib3MFException {
		Pointer bufferCount = new Memory(4);
		mWrapper.checkError(this, mWrapper.lib3mf_multipropertygroup_getcount.invokeInt(new java.lang.Object[]{mHandle, bufferCount}));
		return bufferCount.getInt(0);
	}

	/**
	 * returns all the PropertyIDs of all MultiProperty-s in this MultiPropertyGroup
	 *
	 * @return PropertyID of the MultiProperty-s in the MultiPropertyGroup.
	 * @throws Lib3MFException
	 */
	public int[] getAllPropertyIDs() throws Lib3MFException {
		Pointer countNeededPropertyIDs = new Memory(8);
		mWrapper.checkError(this, mWrapper.lib3mf_multipropertygroup_getallpropertyids.invokeInt(new java.lang.Object[]{mHandle, 0L, countNeededPropertyIDs, Pointer.NULL}));
		long countPropertyIDs = countNeededPropertyIDs.getLong(0);
		Pointer bufferPropertyIDs = new Memory(Math.max(1, 4 * countPropertyIDs));
		mWrapper.checkError(this, mWrapper.lib3mf_multipropertygroup_getallpropertyids.invokeInt(new java.lang.Object[]{mHandle, countPropertyIDs, countNeededPropertyIDs, bufferPropertyIDs}));
		return bufferPropertyIDs.getIntArray(0, (int)countPropertyIDs);
	}

	/**
	 * Adds a new MultiProperty to the MultiPropertyGroup.
	 *
	 * @param propertyIDs The PropertyIDs of the new MultiProperty.
	 * @return returns the PropertyID of the new MultiProperty in the MultiPropertyGroup.
	 * @throws Lib3MFException
	 */
	public int addMultiProperty(int[] propertyIDs) throws Lib3MFException {
		Pointer bufferPropertyIDs = new Memory(Math.max(1, 4 * propertyIDs.length));
		for (int i = 0; i < propertyIDs.length; i++) {
		  bufferPropertyIDs.setInt(4 * i, propertyIDs[i]);
		}
		Pointer bufferPropertyID = new Memory(4);
		mWrapper.checkError(this, mWrapper.lib3mf_multipropertygroup_addmultiproperty.invokeInt(new java.lang.Object[]{mHandle, (long) propertyIDs.length, bufferPropertyIDs, bufferPropertyID}));
		return bufferPropertyID.getInt(0);
	}

	/**
	 * Sets the PropertyIDs of a MultiProperty.
	 *
	 * @param propertyID the PropertyID of the MultiProperty to be changed.
	 * @param propertyIDs The new PropertyIDs of the MultiProperty
	 * @throws Lib3MFException
	 */
	public void setMultiProperty(int propertyID, int[] propertyIDs) throws Lib3MFException {
		Pointer bufferPropertyIDs = new Memory(Math.max(1, 4 * propertyIDs.length));
		for (int i = 0; i < propertyIDs.length; i++) {
		  bufferPropertyIDs.setInt(4 * i, propertyIDs[i]);
		}
		mWrapper.checkError(this, mWrapper.lib3mf_multipropertygroup_setmultiproperty.invokeInt(new java.lang.Object[]{mHandle, propertyID, (long) propertyIDs.length, bufferPropertyIDs}));
	}

	/**
	 * Obtains the PropertyIDs of a MultiProperty.
	 *
	 * @param propertyID the PropertyID of the MultiProperty to be queried.
	 * @return The PropertyIDs of the MultiProperty
	 * @throws Lib3MFException
	 */
	public int[] getMultiProperty(int propertyID) throws Lib3MFException {
		Pointer countNeededPropertyIDs = new Memory(8);
		mWrapper.checkError(this, mWrapper.lib3mf_multipropertygroup_getmultiproperty.invokeInt(new java.lang.Object[]{mHandle, propertyID, 0L, countNeededPropertyIDs, Pointer.NULL}));
		long countPropertyIDs = countNeededPropertyIDs.getLong(0);
		Pointer bufferPropertyIDs = new Memory(Math.max(1, 4 * countPropertyIDs));
		mWrapper.checkError(this, mWrapper.lib3mf_multipropertygroup_getmultiproperty.invokeInt(new java.lang.Object[]{mHandle, propertyID, countPropertyIDs, countNeededPropertyIDs, bufferPropertyIDs}));
		return bufferPropertyIDs.getIntArray(0, (int)countPropertyIDs);
	}

	/**
	 * Removes a MultiProperty from this MultiPropertyGroup.
	 *
	 * @param propertyID the PropertyID of the MultiProperty to be removed.
	 * @throws Lib3MFException
	 */
	public void removeMultiProperty(int propertyID) throws Lib3MFException {
		mWrapper.checkError(this, mWrapper.lib3mf_multipropertygroup_removemultiproperty.invokeInt(new java.lang.Object[]{mHandle, propertyID}));
	}

	/**
	 * Retrieves the number of layers of this MultiPropertyGroup.
	 *
	 * @return returns the number of layers
	 * @throws Lib3MFException
	 */
	public int getLayerCount() throws Lib3MFException {
		Pointer bufferCount = new Memory(4);
		mWrapper.checkError(this, mWrapper.lib3mf_multipropertygroup_getlayercount.invokeInt(new java.lang.Object[]{mHandle, bufferCount}));
		return bufferCount.getInt(0);
	}

	/**
	 * Adds a MultiPropertyLayer to this MultiPropertyGroup.
	 *
	 * @param theLayer The MultiPropertyLayer to add to this MultiPropertyGroup
	 * @return returns the index of this MultiPropertyLayer
	 * @throws Lib3MFException
	 */
	public int addLayer(MultiPropertyLayer theLayer) throws Lib3MFException {
		Pointer bufferTheLayer = new Memory(MultiPropertyLayer.SIZE);
		theLayer.writeToPointer(bufferTheLayer, 0);
		Pointer bufferLayerIndex = new Memory(4);
		mWrapper.checkError(this, mWrapper.lib3mf_multipropertygroup_addlayer.invokeInt(new java.lang.Object[]{mHandle, bufferTheLayer, bufferLayerIndex}));
		return bufferLayerIndex.getInt(0);
	}

	/**
	 * Obtains a MultiPropertyLayer of this MultiPropertyGroup.
	 *
	 * @param layerIndex The Index of the MultiPropertyLayer queried
	 * @return The MultiPropertyLayer with index LayerIndex within MultiPropertyGroup
	 * @throws Lib3MFException
	 */
	public MultiPropertyLayer getLayer(int layerIndex) throws Lib3MFException {
		Pointer bufferTheLayer = new Memory(MultiPropertyLayer.SIZE);
		mWrapper.checkError(this, mWrapper.lib3mf_multipropertygroup_getlayer.invokeInt(new java.lang.Object[]{mHandle, layerIndex, bufferTheLayer}));
		MultiPropertyLayer theLayer = new MultiPropertyLayer();
		theLayer.readFromPointer(bufferTheLayer, 0);
		return theLayer;
	}

	/**
	 * Removes a MultiPropertyLayer from this MultiPropertyGroup.
	 *
	 * @param layerIndex The Index of the MultiPropertyLayer to be removed
	 * @throws Lib3MFException
	 */
	public void removeLayer(int layerIndex) throws Lib3MFException {
		mWrapper.checkError(this, mWrapper.lib3mf_multipropertygroup_removelayer.invokeInt(new java.lang.Object[]{mHandle, layerIndex}));
	}


}

