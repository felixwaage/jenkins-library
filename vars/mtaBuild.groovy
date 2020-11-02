import com.sap.piper.BuildTool
import groovy.transform.Field
import static com.sap.piper.Prerequisites.checkScript
import com.sap.piper.DownloadCacheUtils

@Field String STEP_NAME = getClass().getName()
@Field String METADATA_FILE = 'metadata/mtaBuild.yaml'

void call(Map parameters = [:]) {
    echo "[FW] Entering mtaBuild ..."
    
    final script = checkScript(this, parameters) ?: this
    parameters = DownloadCacheUtils.injectDownloadCacheInParameters(script, parameters, BuildTool.MTA)

    echo "[FW] Executing piperExecuteBin..."
    piperExecuteBin(parameters, STEP_NAME, METADATA_FILE, [])
}
