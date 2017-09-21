package com.trevorism.domain

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
