/*
 * Copyright 2022 Adobe. All rights reserved.
 * This file is licensed to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You may obtain a copy
 * of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR REPRESENTATIONS
 * OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package com.adobe.aem.guides.dto;

import java.util.List;

/**
 * This class is a data transfer object for publishing status response of all the completed and queued outputs.
 * It contains a list of {@link PublishingStatusResponseDto} for both completed and queued outputs.
 */
public class AllPublishingStatusResponseDto {

    List<PublishingStatusResponseDto> outputs;
    List<PublishingStatusResponseDto> queuedOutputs;

    public List<PublishingStatusResponseDto> getOutputs() {
        return outputs;
    }

    public AllPublishingStatusResponseDto setOutputs(List<PublishingStatusResponseDto> outputs) {
        this.outputs = outputs;
        return this;
    }

    public List<PublishingStatusResponseDto> getQueuedOutputs() {
        return queuedOutputs;
    }

    public AllPublishingStatusResponseDto setQueuedOutputs(List<PublishingStatusResponseDto> queuedOutputs) {
        this.queuedOutputs = queuedOutputs;
        return this;
    }
}
