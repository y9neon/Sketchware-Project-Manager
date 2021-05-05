package `fun`.kotlingang.sketchware.objects.project.logic.blocks.expressions

import `fun`.kotlingang.sketchware.objects.project.logic.BlockModel
import `fun`.kotlingang.sketchware.objects.project.logic.arguments.Argument
import `fun`.kotlingang.sketchware.objects.project.logic.blocks.expressions.ExpressionBlock

open class GetVariableBlock(model: BlockModel, arguments: List<Argument> = listOf()) : ExpressionBlock(model, arguments)