/*
 * Copyright (c) 2020 Vonage
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.vonage.client.incoming;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.HashMap;
import java.util.Map;

public enum CallStatus {
    STARTED,
    RINGING,
    ANSWERED,
    COMPLETED,
    MACHINE,
    HUMAN,
    INPUT,
    BUSY,
    CANCELLED,
    FAILED,
    RECORDING,
    REJECTED,
    TIMEOUT,
    UNANSWERED,
    UNKNOWN;

    private static final Map<String, CallStatus> CALL_STATUS_INDEX = new HashMap<>();

    static {
        for (CallStatus callStatus : CallStatus.values()) {
            CALL_STATUS_INDEX.put(callStatus.name(), callStatus);
        }
    }

    @JsonCreator
    public static CallStatus fromString(String status) {
        CallStatus foundCallStatus = CALL_STATUS_INDEX.get(status.toUpperCase());
        return (foundCallStatus != null) ? foundCallStatus : UNKNOWN;
    }
}