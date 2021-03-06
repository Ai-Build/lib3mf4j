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

public class Attachment extends Base {

	public Attachment(Lib3MFWrapper wrapper, Pointer handle) {
		super(wrapper, handle);
	}

	/**
	 * Retrieves an attachment's package path.
	 *
	 * @return returns the attachment's package path string
	 * @throws Lib3MFException
	 */
	public String getPath() throws Lib3MFException {
		Pointer bytesNeededPath = new Memory(4);
		mWrapper.checkError(this, mWrapper.lib3mf_attachment_getpath.invokeInt(new java.lang.Object[]{mHandle, 0, bytesNeededPath, null}));
		int sizePath = bytesNeededPath.getInt(0);
		Pointer bufferPath = new Memory(sizePath);
		mWrapper.checkError(this, mWrapper.lib3mf_attachment_getpath.invokeInt(new java.lang.Object[]{mHandle, sizePath, bytesNeededPath, bufferPath}));
		return new String(bufferPath.getByteArray(0, sizePath - 1), StandardCharsets.UTF_8);
	}

	/**
	 * Sets an attachment's package path.
	 *
	 * @param path new path of the attachment.
	 * @throws Lib3MFException
	 */
	public void setPath(String path) throws Lib3MFException {
		byte[] bytesPath = path.getBytes(StandardCharsets.UTF_8);
		Memory bufferPath = new Memory(bytesPath.length + 1);
		bufferPath.write(0, bytesPath, 0, bytesPath.length);
		bufferPath.setByte(bytesPath.length, (byte)0);
		mWrapper.checkError(this, mWrapper.lib3mf_attachment_setpath.invokeInt(new java.lang.Object[]{mHandle, bufferPath}));
	}

	/**
	 * Retrieves an attachment's relationship type
	 *
	 * @return returns the attachment's package relationship type string
	 * @throws Lib3MFException
	 */
	public String getRelationShipType() throws Lib3MFException {
		Pointer bytesNeededPath = new Memory(4);
		mWrapper.checkError(this, mWrapper.lib3mf_attachment_getrelationshiptype.invokeInt(new java.lang.Object[]{mHandle, 0, bytesNeededPath, null}));
		int sizePath = bytesNeededPath.getInt(0);
		Pointer bufferPath = new Memory(sizePath);
		mWrapper.checkError(this, mWrapper.lib3mf_attachment_getrelationshiptype.invokeInt(new java.lang.Object[]{mHandle, sizePath, bytesNeededPath, bufferPath}));
		return new String(bufferPath.getByteArray(0, sizePath - 1), StandardCharsets.UTF_8);
	}

	/**
	 * Sets an attachment's relationship type.
	 *
	 * @param path new relationship type string.
	 * @throws Lib3MFException
	 */
	public void setRelationShipType(String path) throws Lib3MFException {
		byte[] bytesPath = path.getBytes(StandardCharsets.UTF_8);
		Memory bufferPath = new Memory(bytesPath.length + 1);
		bufferPath.write(0, bytesPath, 0, bytesPath.length);
		bufferPath.setByte(bytesPath.length, (byte)0);
		mWrapper.checkError(this, mWrapper.lib3mf_attachment_setrelationshiptype.invokeInt(new java.lang.Object[]{mHandle, bufferPath}));
	}

	/**
	 * Writes out the attachment as file.
	 *
	 * @param fileName file to write into.
	 * @throws Lib3MFException
	 */
	public void writeToFile(String fileName) throws Lib3MFException {
		byte[] bytesFileName = fileName.getBytes(StandardCharsets.UTF_8);
		Memory bufferFileName = new Memory(bytesFileName.length + 1);
		bufferFileName.write(0, bytesFileName, 0, bytesFileName.length);
		bufferFileName.setByte(bytesFileName.length, (byte)0);
		mWrapper.checkError(this, mWrapper.lib3mf_attachment_writetofile.invokeInt(new java.lang.Object[]{mHandle, bufferFileName}));
	}

	/**
	 * Reads an attachment from a file.
	 *
	 * @param fileName file to read from.
	 * @throws Lib3MFException
	 */
	public void readFromFile(String fileName) throws Lib3MFException {
		byte[] bytesFileName = fileName.getBytes(StandardCharsets.UTF_8);
		Memory bufferFileName = new Memory(bytesFileName.length + 1);
		bufferFileName.write(0, bytesFileName, 0, bytesFileName.length);
		bufferFileName.setByte(bytesFileName.length, (byte)0);
		mWrapper.checkError(this, mWrapper.lib3mf_attachment_readfromfile.invokeInt(new java.lang.Object[]{mHandle, bufferFileName}));
	}

	/**
	 * Retrieves the size of the attachment stream
	 *
	 * @return the stream size
	 * @throws Lib3MFException
	 */
	public long getStreamSize() throws Lib3MFException {
		Pointer bufferStreamSize = new Memory(8);
		mWrapper.checkError(this, mWrapper.lib3mf_attachment_getstreamsize.invokeInt(new java.lang.Object[]{mHandle, bufferStreamSize}));
		return bufferStreamSize.getLong(0);
	}

	/**
	 * Writes out the attachment into a buffer
	 *
	 * @return Buffer to write into
	 * @throws Lib3MFException
	 */
	public char[] writeToBuffer() throws Lib3MFException {
		Pointer countNeededBuffer = new Memory(8);
		mWrapper.checkError(this, mWrapper.lib3mf_attachment_writetobuffer.invokeInt(new java.lang.Object[]{mHandle, 0L, countNeededBuffer, Pointer.NULL}));
		long countBuffer = countNeededBuffer.getLong(0);
		Pointer bufferBuffer = new Memory(Math.max(1, 1 * countBuffer));
		mWrapper.checkError(this, mWrapper.lib3mf_attachment_writetobuffer.invokeInt(new java.lang.Object[]{mHandle, countBuffer, countNeededBuffer, bufferBuffer}));
		return bufferBuffer.getCharArray(0, (int)countBuffer);
	}

	/**
	 * Reads an attachment from a memory buffer
	 *
	 * @param buffer Buffer to read from
	 * @throws Lib3MFException
	 */
	public void readFromBuffer(char[] buffer) throws Lib3MFException {
		Pointer bufferBuffer = new Memory(Math.max(1, 1 * buffer.length));
		for (int i = 0; i < buffer.length; i++) {
		  bufferBuffer.setChar(1 * i, buffer[i]);
		}
		mWrapper.checkError(this, mWrapper.lib3mf_attachment_readfrombuffer.invokeInt(new java.lang.Object[]{mHandle, (long) buffer.length, bufferBuffer}));
	}


}

