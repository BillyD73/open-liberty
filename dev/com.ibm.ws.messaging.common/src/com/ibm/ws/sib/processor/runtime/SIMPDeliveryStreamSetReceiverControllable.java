/*******************************************************************************
 * Copyright (c) 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.sib.processor.runtime;

import com.ibm.ws.sib.processor.exceptions.SIMPControllableNotFoundException;
import com.ibm.ws.sib.processor.exceptions.SIMPRuntimeOperationFailedException;

/**
 * Interface to manipulate the set of streams of incoming (remote put) 
 * messages originating from a remote messaging engine
 */
public interface SIMPDeliveryStreamSetReceiverControllable extends SIMPDeliveryStreamSetControllable
{
  /**
   * Returns the tick of the last message received and acknowleged
   * 
   * @return long  The tick of the last message we received, and acknowleged
   */
  public long getLastTickReceived()
    throws SIMPRuntimeOperationFailedException, SIMPControllableNotFoundException;

  /**
   * If the source has been deleted there is no opportunity to complete the flush  
   *  or fill any gaps. This method will discard the target stream without completing 
   *  and ignoring any gaps. If the source still exists no messages will be lost because
   *  they can be retransmitted by the source. However there is a risk that messages 
   *  will be duplicated because an ack generated by the target may not have been received
   *  by the source, causing the source to send the same message again to a new instance 
   *  of the same stream which the target recreates.
   *  
   *  On completion no stream state exists, just as if flush had completed.
   *
   */
  public void forceFlushAtTarget()
    throws SIMPRuntimeOperationFailedException, SIMPControllableNotFoundException;
  
  /**
   * @return a long for the number of messages that have been received
   * since reboot.
   * @author tpm
   */
  public long getNumberOfMessagesReceived();  
    
  /**
   * @return a long for the number of messages received on these streams
   * that have not yet been consumed (current inbound messages)
   * @author tpm
   */
  public long getDepth();
  
  /**
   * @return a SIMPIterator containing each of the SIMPDeliveryStreamReceiverControllable 
   * objects in this stream set.
   * Use this to get each stream in the stream set for inbound messages from this remote ME.
   * @author tpm
   */
  public SIMPIterator getStreams();
  
}
