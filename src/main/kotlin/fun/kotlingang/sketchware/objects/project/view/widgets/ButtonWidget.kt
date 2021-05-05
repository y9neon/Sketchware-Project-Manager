package `fun`.kotlingang.sketchware.objects.project.view.widgets

import `fun`.kotlingang.sketchware.objects.project.view.properties.WidgetProperties

class ButtonWidget(view: WidgetProperties = WidgetProperties()) : BaseWidget(view) {

    private val textProps get() = view.text

    /**
     * TextViewArgument content text.
     * @see <a href="https://developer.android.com/reference/android/widget/TextViewArgument#attr_android:text">Android docs.</a>
     */
    var text by textProps::text

    /**
     * TextViewArgument text color.
     * @see <a href="https://developer.android.com/reference/android/widget/TextViewArgument#attr_android:textColor">Android docs.</a>
     */
    var textColor by textProps::textColor

    /**
     * TextViewArgument text size in DP.
     */
    var textSize by textProps::textSize

    /**
     * TextProperties Style (for example: NORMAL, BOLD, ITALIC, BOLD|ITALIC)
     * @see <a href="https://developer.android.com/reference/android/widget/TextViewArgument#attr_android:textStyle">Android docs.</a>
     */
    var textStyle by textProps::textType

}