package com.trevorism.domain.bootstrap
/**
 * @author tbrooks
 */
class DomainModel {

    long id
    String className
    Map attributes = [:]

    static DomainModel fromClass(Class<?> aClass){
        DomainModel model = new DomainModel()
        model.className = aClass.getSimpleName()

        aClass.metaClass.properties.each {MetaBeanProperty k ->
            if(k.name == "class")
                return
            model.attributes.put(k.name, k.type.simpleName)
        }

        return model

    }
}
