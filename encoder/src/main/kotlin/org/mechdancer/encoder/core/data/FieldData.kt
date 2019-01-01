package org.mechdancer.encoder.core.data

data class FieldData(val name: String, val data: Data) {
    constructor(name: String, type: String, value: Any)
        : this(name, Data(type, value))
}