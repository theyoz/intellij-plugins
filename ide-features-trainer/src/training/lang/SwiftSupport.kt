// Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package training.lang

import com.intellij.openapi.application.ApplicationNamesInfo
import com.intellij.openapi.project.Project
import com.intellij.openapi.projectRoots.Sdk
import com.intellij.openapi.wm.ToolWindowAnchor
import training.project.ProjectUtils

/**
 * @author Sergey Karashevich
 */
class SwiftSupport : AbstractLangSupport() {
  override val primaryLanguage: String
    get() = "swift"


  override fun importLearnProject(): Project? {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun applyToProjectAfterConfigure(): (Project) -> Unit = {
  }

  override fun checkSdk(sdk: Sdk?, project: Project) {}

  override fun createProject(projectName: String, projectToClose: Project?): Project? {
    return ProjectUtils.importOrOpenProject(
      "/learnProjects/" + ApplicationNamesInfo.getInstance().fullProductName.toLowerCase() + "_swift/LearnProjectSwift",
      "LearnProject",
      javaClass.classLoader
    )
  }

  override fun getToolWindowAnchor(): ToolWindowAnchor {
    return ToolWindowAnchor.RIGHT
  }
}