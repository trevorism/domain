package com.trevorism.registry

import com.trevorism.data.FastDatastoreRepository
import com.trevorism.data.Repository
import com.trevorism.domain.Service

/**
 * @author tbrooks
 */
class ServiceRegistryData {

    static void main(String[] args) {
        createServiceRegistry()

    }

    static void createServiceRegistry() {
        Repository<Service> repository = new FastDatastoreRepository<>(Service.class)
        repository.ping()
        def allServices = [
                datastoreService(),
                eventhubService(),
                emailService(),
                datastoreClientService(),
                domainService(),
                eventhubClientService(),
                gcloudService(),
                gradleAcceptancePluginService(),
                gradleGaeDeployPluginService(),
                httpUtilsService(),
                googleApps(),
                registryService(),
                kanbanBoard(),
                secureUtilsService(),
                listenService(),
                jenkinsService(),
                nexusService()

        ]

        for(int i = 0; i < allServices.size(); i++){
            Service service = allServices[i]
            service.setId(i+1)
            repository.create(service)
        }


    }

    private static Service googleApps() {
        new Service(name: "googleApps", host: "google", url: "https://admin.google.com")
    }

    private static Service kanbanBoard() {
        new Service(name: "kanbanBoard", host: "kanbanflow", url: "`+-  Q-+*+" +
                "")
    }

    private static Service httpUtilsService() {
        new Service(name: "http-utils",
                giturl: "https://github.com/trevorism/http-utils.git",
                host: "internal")
    }

    private static Service secureUtilsService() {
        new Service(name: "secure-utils",
                giturl: "https://github.com/trevorism/secure-utils.git",
                host: "internal")
    }

    private static Service gradleGaeDeployPluginService() {
        new Service(name: "gradle-gae-deploy-plugin",
                giturl: "https://github.com/trevorism/gradle-gae-deploy-plugin.git",
                host: "internal")
    }

    private static Service gradleAcceptancePluginService() {
        new Service(name: "gradle-acceptance-plugin",
                giturl: "https://github.com/trevorism/gradle-acceptance-plugin.git",
                host: "internal")
    }

    private static Service gcloudService() {
        new Service(name: "gcloud",
                giturl: "https://github.com/trevorism/gcloud.git",
                host: "internal")
    }

    private static Service eventhubClientService() {
        new Service(name: "eventhub-client",
                giturl: "https://github.com/trevorism/eventhub-client.git",
                host: "internal")
    }

    private static Service domainService() {
        new Service(name: "domain",
                giturl: "https://github.com/trevorism/domain.git",
                host: "internal")
    }

    private static Service datastoreClientService() {
        new Service(name: "datastore-client",
                giturl: "https://github.com/trevorism/datastore-client.git",
                host: "internal")
    }

    private static Service eventhubService() {
        new Service(name: "eventhub",
                giturl: "https://github.com/trevorism/eventhub.git",
                host: "https://console.cloud.google.com/appengine/versions?project=trevorism-eventhub&serviceId=default",
                url: "https://trevorism-eventhub.appspot.com",
                dns: "http://event.trevorism.com")
    }

    private static Service listenService() {
        new Service(name: "listen",
                giturl: "https://github.com/trevorism/listen.git",
                host: "https://console.cloud.google.com/appengine/versions?project=trevorism-eventhub&serviceId=listen",
                url: "https://listen-dot-trevorism-eventhub.appspot.com")
    }

    private static Service datastoreService() {
        new Service(name: "datastore",
                giturl: "https://github.com/trevorism/datastore.git",
                host: "https://console.cloud.google.com/appengine/versions?project=trevorism-gcloud&serviceId=default",
                url: "https://trevorism-gcloud.appspot.com",
                dns: "http://datastore.trevorism.com")
    }

    private static Service emailService() {
        new Service(
                name: "email",
                giturl: "https://github.com/trevorism/email.git",
                host: "https://console.cloud.google.com/appengine/versions?project=trevorism-gcloud&serviceId=email",
                url: "https://email-dot-trevorism-gcloud.appspot.com",
                dns: "http://email.datastore.trevorism.com")
    }

    private static Service registryService() {
        new Service(
                name: "registry",
                giturl: "https://github.com/trevorism/registry.git",
                host: "https://console.cloud.google.com/appengine/versions?project=trevorism-gcloud&serviceId=registry",
                url: "https://registry-dot-trevorism-gcloud.appspot.com",
                dns: "http://registry.datastore.trevorism.com")
    }

    private static Service jenkinsService() {
        new Service(
                name: "jenkins",
                host: "http://trevor.eastus.cloudapp.azure.com/jenkins",
                url: "http://trevor.eastus.cloudapp.azure.com/jenkins")
    }

    private static Service nexusService() {
        new Service(
                name: "nexus",
                host: "http://trevor.eastus.cloudapp.azure.com/nexus",
                url: "http://trevor.eastus.cloudapp.azure.com/nexus")
    }
}
