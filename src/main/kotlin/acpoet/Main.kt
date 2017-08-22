package acpoet

import com.google.gson.GsonBuilder
import com.google.gson.internal.LinkedTreeMap
import com.google.gson.reflect.TypeToken
import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.MissingValueException
import mu.KotlinLogging
import org.omg.CORBA.Object
import java.io.File

private val logger = KotlinLogging.logger {}

fun main(args: Array<String>) {

    val parser = OptionParser(ArgParser(args))

    val map: LinkedTreeMap<String, Object>
    val type = object : TypeToken<Map<String, Object>>() {}.type
    try {
        map = GsonBuilder().create().fromJson(File(parser.json).readText(), type)
    } catch (e : MissingValueException) {
        return
    }

    logger.info { "Initializing poet with parameters" +
            "\n ${parser.json}"   +
            "\n ${parser.output}" +
            "\n ${parser.language}" }

    Poet(map, parser.output, parser.language).build()
}

class OptionParser(parser: ArgParser) {

    val json by parser.storing("-j", "--json",
            help = "JSON source file location - /path/to/file.json")

    val output by parser.storing("-o", "--output",
            help = "output path for generated files")

    val language by parser.mapping(
            "--kotlin" to Language.kotlin,
            "--java" to Language.java,
            help = "target language - kotlin/java")
}

enum class Language {
    kotlin,
    java
}