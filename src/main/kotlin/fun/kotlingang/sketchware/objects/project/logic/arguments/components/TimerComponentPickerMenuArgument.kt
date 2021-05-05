package `fun`.kotlingang.sketchware.objects.project.logic.arguments.components

import `fun`.kotlingang.sketchware.internal.extensions.nullIfBlank
import `fun`.kotlingang.sketchware.objects.project.logic.blocks.expressions.components.TimerExpressionBlock

class TimerComponentPickerMenuArgument(
    componentName: String? = null,
    expressionSource: TimerExpressionBlock?
) : ComponentPickerMenuArgument<TimerExpressionBlock>(componentName.nullIfBlank(), expressionSource)