package org.mechdancer.encoder

import org.mechdancer.encoder.core.data.Basic
import org.mechdancer.encoder.core.type.Field
import org.mechdancer.encoder.core.type.Property
import org.mechdancer.encoder.core.type.TypeGraph

internal val types = TypeGraph(
    mapOf(
        "vector" to listOf(
            Field("data", Basic.F8.name, Property.Array)),
        "vector2D" to listOf(
            Field("x", Basic.F8.name, Property.Unit),
            Field("y", Basic.F8.name, Property.Unit)),
        "pose" to listOf(
            Field("location", "vector2D", Property.Unit),
            Field("direction", Basic.F8.name, Property.Unit))
    ))
