package com.trevorism.domain.model
/**
 * @author tbrooks
 */
class ScheduledTask {

    String id
    String name

    String type
    Date startDate
    boolean enabled

    String endpoint
    String httpMethod = "post"
    String requestJson
}
