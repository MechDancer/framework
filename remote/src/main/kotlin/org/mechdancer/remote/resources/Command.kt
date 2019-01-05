package org.mechdancer.remote.resources

/**
 * 命令接口
 */
interface Command {
    /**
     * 命令识别码
     */
    val id: Byte

    /**
     * 命令缓存，使第二次查找具有 O(1) 复杂度
     *
     * @param list 命令列表
     */
    class CommandMemory<C : Command>(private val list: Array<C>) {
        // 内核，使非固定指令也能进行缓存
        private val core = hashMapOf<Byte, C?>()

        /**
         * 查询成员，成功则加入缓存
         */
        operator fun get(id: Byte): C? =
            core[id] ?: list.find { it.id == id }.also { core[id] = it }
    }

    /**
     * 基于指令构造包
     */
    fun lead(payload: ByteArray) =
        ByteArray(payload.size + 1)
            .apply {
                set(0, id)
                payload.copyInto(this, 1)
            }

    companion object {
        /**
         * 自动构造缓存
         *
         * @param C 指令类型
         */
        inline fun <reified C> memoryOf() where C : Command, C : Enum<C> =
            CommandMemory(enumValues<C>())
    }
}
