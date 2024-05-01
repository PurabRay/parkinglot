package com.scaler.parkinglot.exceptions;

import com.scaler.parkinglot.models.Operator;

public class OperatorNotAvailableException extends Exception {
    OperatorNotAvailableException(String message) {
        super(message);
    }

}
