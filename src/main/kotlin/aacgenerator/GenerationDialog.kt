package main.kotlin.aacgenerator
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.ValidationInfo
import com.intellij.util.ui.JBUI
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import javax.swing.*
import com.intellij.CommonBundle
import org.jetbrains.annotations.NotNull
import java.awt.Insets

class GenerationDialog(private val myProject: Project) : DialogWrapper(myProject) {

    private var contentPane: JPanel

    init {
        contentPane = JPanel(GridBagLayout())
        buildForm()
        init()
    }

    fun buildForm(){
        title = "Generate components"
        val insets = JBUI.insets(10, 10, 10, 10)

        contentPane.add(JLabel("Output Path:"), GridBagConstraints(0, 0, 30, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                insets, 10, 10))
        contentPane.add(JTextField(), GridBagConstraints(0, 1, 30, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                insets, 10, 10))
        contentPane.add(JLabel("JSON schema:"), GridBagConstraints(0, 2, 30, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
                insets, 0, 0))
        contentPane.add(JTextArea("{}"), GridBagConstraints(0, 3, 30, 30, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                insets, 0, 0))
    }

    override fun createCenterPanel(): JComponent? {
        return contentPane
    }

    override fun doValidate(): ValidationInfo? {
        return null
    }

    @NotNull
    override fun getCancelAction(): Action {
        val action = super.getCancelAction()
        action.putValue(Action.NAME, CommonBundle.getCloseButtonText())
        return action
    }

    @NotNull
    override fun createActions(): Array<Action> {
        return arrayOf(okAction, cancelAction, helpAction)
    }

    override fun doOKAction() {
        super.doOKAction()
    }

    override fun doCancelAction() {
        super.doCancelAction()
    }

    override fun doHelpAction() {
        super.doHelpAction()
    }
}