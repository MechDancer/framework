package org.mechdancer.encoder

enum class BasicStruct(val description: StructDescription) {
    I1(StructDescription("i1", listOf())),
    I2(StructDescription("i2", listOf())),
    I4(StructDescription("i4", listOf())),
    I8(StructDescription("i8", listOf())),
    F4(StructDescription("f4", listOf())),
    F8(StructDescription("f8", listOf())),
    STR(StructDescription("s", listOf()));
}

