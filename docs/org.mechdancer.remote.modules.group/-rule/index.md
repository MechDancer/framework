---
title: Rule - 
---

[org.mechdancer.remote.modules.group](../index.html) / [Rule](./index.html)

# Rule

`data class Rule`

入站规则

### Types

| [RuleType](-rule-type/index.html) | `enum class RuleType` |

### Constructors

| [&lt;init&gt;](-init-.html) | `Rule(type: `[`RuleType`](-rule-type/index.html)` = RuleType.NONE, regex: `[`Regex`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-regex/index.html)` = Regex(""))`<br>入站规则 |

### Properties

| [regex](regex.html) | `val regex: `[`Regex`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-regex/index.html) |
| [type](type.html) | `val type: `[`RuleType`](-rule-type/index.html) |

### Functions

| [decline](decline.html) | `infix fun decline(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>判断是否拒绝对方的消息 |

