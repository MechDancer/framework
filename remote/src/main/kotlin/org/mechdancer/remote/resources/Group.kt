package org.mechdancer.remote.resources

import org.mechdancer.dependency.UniqueComponent
import org.mechdancer.dependency.buildView
import java.util.concurrent.ConcurrentHashMap

/** 成员存在性资源 */
class Group : UniqueComponent<Group>() {
    private val core = ConcurrentHashMap<String, Long>()
    val view = buildView(core)

    /** 更新出现时间 */
    fun detect(name: String): Long? =
        core.put(name, System.currentTimeMillis())

    /** 读取出现时间 */
    operator fun get(parameter: String) =
        core[parameter]

    /** 获取最后出现时间短于超时时间 [timeout] 的成员 */
    operator fun get(timeout: Int): List<String> {
        val now = System.currentTimeMillis()
        return core.mapNotNull { (name, time) -> name.takeIf { now - time < timeout } }
    }
}
