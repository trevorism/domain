package com.trevorism.domain

/**
 * @author tbrooks
 */
class Subscriber {
    String name
    String topic
    String url
    String ackDeadlineSeconds = "10"
}
