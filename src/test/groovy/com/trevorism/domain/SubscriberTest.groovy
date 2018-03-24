package com.trevorism.domain

import com.trevorism.domain.model.Subscriber
import org.junit.Test

/**
 * @author tbrooks
 */
class SubscriberTest {

    @Test
    void testSubscriber(){
        Subscriber subscriber = new Subscriber()
        assert subscriber.ackdeadlineseconds == "10"
    }
}
