package com.trevorism.domain.model

/**
 * @author tbrooks
 */
class Subscriber {
    String name
    String topic
    String url
    String ackdeadlineseconds = "10"
}
