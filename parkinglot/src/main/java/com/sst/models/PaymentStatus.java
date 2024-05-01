package com.scaler.parkinglot.models;

public enum PaymentStatus {
    SUCCESS,
    FAILURE,
    IN_PROCESSING,
}


/*
payment_status -> enum 1:1

    payment_status_id | payment_status
            1         |   SUCCESS
            2         |   FAILURE
 */

//Fridge -> DB
//Helper -> Reposiitory, who is taking the items from the fridge.
