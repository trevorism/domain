package com.trevorism.registry

import com.trevorism.data.DatastoreRepository
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
        Repository<Service> repository = new DatastoreRepository<>(Service.class)
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
                googleApps()
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

    private static Service httpUtilsService() {
        new Service(name: "http-utils",
                gitUrl: "https://github.com/trevorism/http-utils.git",
                host: "internal")
    }

    private static Service gradleGaeDeployPluginService() {
        new Service(name: "gradle-gae-deploy-plugin",
                gitUrl: "https://github.com/trevorism/gradle-gae-deploy-plugin.git",
                host: "internal")
    }

    private static Service gradleAcceptancePluginService() {
        new Service(name: "gradle-acceptance-plugin",
                gitUrl: "https://github.com/trevorism/gradle-acceptance-plugin.git",
                host: "internal")
    }

    private static Service gcloudService() {
        new Service(name: "gcloud",
                gitUrl: "https://github.com/trevorism/gcloud.git",
                host: "internal")
    }

    private static Service eventhubClientService() {
        new Service(name: "eventhub-client",
                gitUrl: "https://github.com/trevorism/eventhub-client.git",
                host: "internal")
    }

    private static Service domainService() {
        new Service(name: "domain",
                gitUrl: "https://github.com/trevorism/domain.git",
                host: "internal")
    }

    private static Service datastoreClientService() {
        new Service(name: "datastore-client",
                gitUrl: "https://github.com/trevorism/datastore-client.git",
                host: "internal")
    }

    private static Service eventhubService() {
        new Service(name: "eventhub",
                gitUrl: "https://github.com/trevorism/eventhub.git",
                host: "https://console.cloud.google.com/appengine/versions?project=trevorism-eventhub&serviceId=default",
                url: "https://trevorism-eventhub.appspot.com",
                dns: "http://event.trevorism.com")
    }

    private static Service datastoreService() {
        new Service(name: "datastore",
                gitUrl: "https://github.com/trevorism/datastore.git",
                host: "https://console.cloud.google.com/appengine/versions?project=trevorism-gcloud&serviceId=default",
                url: "https://trevorism-gcloud.appspot.com",
                dns: "http://datastore.trevorism.com")
    }

    private static Service emailService() {
        new Service(
                name: "email",
                gitUrl: "https://github.com/trevorism/email.git",
                host: "https://console.cloud.google.com/appengine/versions?project=trevorism-gcloud&serviceId=email",
                url: "https://email-dot-trevorism-gcloud.appspot.com")
    }
}
