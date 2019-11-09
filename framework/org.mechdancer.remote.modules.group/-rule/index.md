---
title: Rule - framework
---

[framework](../../index.html) / [org.mechdancer.remote.modules.group](../index.html) / [Rule](./index.html)

# Rule

`data class Rule`

入站规则

### Types

| [RuleType](-rule-type/index.html) | `enum class RuleType` |

### Constructors

| [&lt;init&gt;](-init-.html) | 入站规则`Rule(type: RuleType = RuleType.NONE, regex: `[`Regex`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-regex/index.html)` = Regex(""))` |

### Properties

| [regex](regex.html) | `val regex: `[`Regex`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-regex/index.html) |
| [type](type.html) | `val type: RuleType` |

### Functions

| [decline](decline.html) | 判断是否拒绝对方的消息`infix fun decline(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

