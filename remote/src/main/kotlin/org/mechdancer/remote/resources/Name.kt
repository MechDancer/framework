package org.mechdancer.remote.resources

import org.mechdancer.dependency.UniqueComponent

class Name private constructor(val field: String) : UniqueComponent<Name>() {
    companion object {
        operator fun invoke(value: String) = Name(value.trim())
    }
}
