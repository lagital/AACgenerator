package main.kotlin.aacgenerator

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.DataKeys
import com.intellij.openapi.project.ProjectManager

class GenerateComponents : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        var generationDialog = GenerationDialog(e.getData(DataKeys.PROJECT)?: ProjectManager.getInstance().defaultProject)
        generationDialog.show()
    }
}
