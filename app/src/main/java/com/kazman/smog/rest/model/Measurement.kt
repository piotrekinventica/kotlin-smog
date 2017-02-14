package com.kazman.smog.rest.model

/**
 * Created by piotrkazmierczak on 07.02.2017.
 */
data class Measurement(val measuredAt: String, val pm10: Float, val pm25: Float, val o3: Float, val no2: Float, val so2: Float, val c6h6: Float, val co: Float, val source: Source) {
    class Source(val name: String, val contact: String)
}
