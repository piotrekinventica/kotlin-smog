package com.kazman.smog.rest.model

/**
 * Created by piotrkazmierczak on 07.02.2017.
 */
data class ApiResponse<T>(val _embedded: Embedded<T>) {
    class Embedded<T>(val records: List<T>)
}
