package com.trevorism.registry

import com.trevorism.data.FastDatastoreRepository
import com.trevorism.data.Repository
import com.trevorism.domain.bootstrap.DomainModel
import com.trevorism.domain.model.Button
import com.trevorism.domain.model.Deploy
import com.trevorism.domain.model.Mail
import com.trevorism.domain.model.ScheduledTask
import com.trevorism.domain.model.Service
import com.trevorism.domain.model.Subscriber
import com.trevorism.domain.model.TestResult

/**
 * @author tbrooks
 */
class DomainRegistryData {

    static void main(String[] args) {
        createDomainRegistry()

    }

    static void createDomainRegistry() {
        Repository<DomainModel> repository = new FastDatastoreRepository<>(DomainModel.class)
        repository.ping()
        def allDomains = [
                DomainModel.fromClass(DomainModel),
                DomainModel.fromClass(Mail),
                DomainModel.fromClass(Service),
                DomainModel.fromClass(Subscriber),
                DomainModel.fromClass(ScheduledTask),
                DomainModel.fromClass(Deploy),
                DomainModel.fromClass(TestResult),
                DomainModel.fromClass(Button),


        ]

        for(int i = 0; i < allDomains.size(); i++){
            DomainModel model = allDomains[i]
            model.setId(i+1)
            repository.create(model)
        }


    }



}
