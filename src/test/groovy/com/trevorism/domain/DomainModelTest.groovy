package com.trevorism.domain

import com.trevorism.domain.bootstrap.DomainModel
import org.junit.Test

/**
 * @author tbrooks
 */
class DomainModelTest {

    @Test
    void testFromClass() {
        DomainModel model = DomainModel.fromClass(DomainModel)

        assert model.className == "DomainModel"
        assert model.attributes
        assert model.attributes.size() == 3

    }
}
