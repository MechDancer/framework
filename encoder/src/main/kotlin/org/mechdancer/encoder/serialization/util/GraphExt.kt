package org.mechdancer.encoder.serialization.util

import org.mechdancer.encoder.core.getOrEmpty
import org.mechdancer.encoder.core.type.TypeGraph
import kotlin.reflect.KClass

fun TypeGraph<*>.view(node: KClass<*>) = getOrEmpty(node.simpleName!!)