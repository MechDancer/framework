package org.mechdancer.dependency

import org.junit.Assert
import org.junit.Test


class E(name: String) : NamedComponent<E>(name)

object F : UniqueComponent<F>()

class D : Dependent {
    override fun sync(dependency: Component): Boolean = manager.sync(dependency)

    override fun equals(other: Any?): Boolean = false
    override fun hashCode(): Int = 0

    val manager = DependencyManager()

    val error by manager.maybe<E>("error")

    val truly by manager.must<E>("E")

    val f by manager.must<F>()
}

class TestManager {
    @Test
    fun test() {
        val d = D()
        val e = E("E")
        scope {
            this += e
            this += d
        }
        Assert.assertEquals(d.error, null)
        Assert.assertEquals(d.truly, e)
        Assert.assertEquals(d.f, F)
    }
}