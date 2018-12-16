package org.mechdancer.remote.modules.group

/**
 * 入站规则
 */
data class Rule(
    val type: RuleType = RuleType.NONE,
    val regex: Regex = Regex("")
) {
    enum class RuleType { ACCEPT, DROP, NONE }

    /** 判断是否拒绝对方的消息 */
    infix fun decline(name: String) =
        when (type) {
            RuleType.NONE   -> false
            RuleType.ACCEPT -> !regex.matches(name)
            RuleType.DROP   -> regex.matches(name)
        }
}
