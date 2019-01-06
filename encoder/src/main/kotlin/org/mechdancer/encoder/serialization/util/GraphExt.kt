package org.mechdancer.encoder.serialization.util

import org.mechdancer.encoder.core.type.TypeGraph
import org.mechdancer.encoder.core.view
import kotlin.reflect.KClass

fun TypeGraph<*>.view(node: KClass<*>) = view(node.qualifiedName!!)