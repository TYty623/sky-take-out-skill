# Spring Boot Transactional Business Backend Skill

一个面向订单型业务后台的可复用 Codex Skill，覆盖 Spring Boot 多模块边界、用户/管理端隔离、订单状态与运营报表。

## 包含内容

- `SKILL.md`：业务需求拆解、模块职责和可靠性约束。
- `references/`：交易后台架构与运营统计/导出检查点。
- `examples/java/`：零依赖、可编译的闭区间日期范围值对象。

## 安装

将整个目录放入 Codex 的 skills 目录（常见位置为 `~/.codex/skills/`），然后在任务中引用 `$sky-take-out-skill`。

## 成果定位

该成果从餐饮订单项目抽象出通用后台模式，适用于预约、零售、配送等存在订单和运营统计的系统；它不是原项目源码副本。

## 验证

```powershell
python <skill-creator>/scripts/quick_validate.py .
javac --release 17 -d .tmp examples\java\ClosedDateRange.java
```

验证后可删除 `.tmp` 目录。
