package io.sketchware.manager.projects

import io.sketchware.interfaces.ProjectsManager
import io.sketchware.manager.customs.SketchwareStudioCustomManager
import io.sketchware.manager.projects.entities.SketchwareProject
import io.sketchware.manager.projects.entities.SketchwareStudioProject
import io.sketchware.manager.projects.entities.toSketchwareStudioProject
import io.sketchware.models.export.ExportConfig
import io.sketchware.models.export.ExportedCustomFilesConfig
import io.sketchware.models.projects.ProjectFilesLocations
import io.sketchware.utils.CustomProjectImportManager
import io.sketchware.utils.ProjectImportManager
import io.sketchware.utils.internal.SketchwareProjectsUtil
import io.sketchware.utils.internal.byteArrayToString
import io.sketchware.utils.internal.readOrNull
import io.sketchware.utils.internal.serialize
import java.io.File

class SketchwareStudioProjectsManager(
    private val sketchwareFolder: File
) : ProjectsManager<SketchwareStudioProject> {
    /**
     * @param folderPath - path to sketchware folder.
     */
    constructor(folderPath: String) : this(File(folderPath))

    /**
     * Gets projects.
     * @return List of [SketchwareProject].
     */
    override suspend fun getProjects() = SketchwareProjectsUtil.getProjectsList(sketchwareFolder).map {
        it.toSketchwareStudioProject(
            File(sketchwareFolder, "data/SourceEdited/${it.locations.projectMainDirectory!!.name}")
        )
    }

    /**
     * Checks next free id and returns it.
     * @param startId - Specific id from which function
     * will check next free id. By default it is 601.
     * @return next free for new project id.
     */
    override suspend fun nextFreeId(startId: Int) =
        SketchwareProjectsUtil.nextFreeProjectId(File(sketchwareFolder, "mysc/list"))

    /**
     * @return instance of [ProjectImportManager] to import project.
     */
    suspend fun getImporter(exportedFolder: File, newId: Int, customManager: SketchwareStudioCustomManager) =
        CustomProjectImportManager(
            ProjectFilesLocations.getDefaultExport(exportedFolder),
            ProjectFilesLocations.getSWDefault(sketchwareFolder, newId),
            newId, customManager,
            File(exportedFolder, "config").readOrNull()?.byteArrayToString()?.serialize<ExportConfig>()
                ?.customFilesConfig?.toExportedCustomFiles(exportedFolder)
                ?: ExportedCustomFilesConfig().toExportedCustomFiles(exportedFolder),
            File(sketchwareFolder, "data/SourceEdited")
        )

}
