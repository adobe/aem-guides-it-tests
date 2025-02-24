package com.adobe.aem.guides.dto;

import java.util.List;

public class AllPublishingStatusDto {

    List<PublishingStatusDto> outputs;
    List<PublishingStatusDto> queuedOutputs;

    public List<PublishingStatusDto> getOutputs() {
        return outputs;
    }

    public AllPublishingStatusDto setOutputs(List<PublishingStatusDto> outputs) {
        this.outputs = outputs;
        return this;
    }

    public List<PublishingStatusDto> getQueuedOutputs() {
        return queuedOutputs;
    }

    public AllPublishingStatusDto setQueuedOutputs(List<PublishingStatusDto> queuedOutputs) {
        this.queuedOutputs = queuedOutputs;
        return this;
    }
}
