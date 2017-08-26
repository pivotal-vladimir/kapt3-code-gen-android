package ca.mccat.annotationprocessor

import ca.mccat.annotations.TestAnnotation
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement
import javax.tools.Diagnostic

class MyProccessor : AbstractProcessor() {
    override fun getSupportedSourceVersion(): SourceVersion = SourceVersion.latestSupported()

    override fun getSupportedAnnotationTypes(): MutableSet<String> =
            mutableSetOf(TestAnnotation::class.qualifiedName!!)

    override fun process(p0: MutableSet<out TypeElement>?, roundEnvironment: RoundEnvironment): Boolean {
        processingEnv.messager.printMessage(Diagnostic.Kind.WARNING, roundEnvironment.getElementsAnnotatedWith(TestAnnotation::class.java).toString())
        return true
    }
}

