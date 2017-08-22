package acpoet

import com.google.gson.internal.LinkedTreeMap
import org.omg.CORBA.Object
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

class Poet(private var jsonMap: LinkedTreeMap<String, Object>,
           private var outputPath: String,
           private var language: Language) {

    fun build() {
        logger.info { "Generating code according to config and schema ..." }

    }

    fun write() {
        logger.info { "Writing artifacts into $outputPath ..." }

    }
}