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

/**
 * This class contains the response DTO for a single publishing job in AEM Guides
 * The same DTO is used for both completed and queued publishing jobs.
 */
public class PublishingStatusResponseDto {
    private String outputStatus;
    private String outputName;
    private String outputSetting;
    private String initiator;
    private String outputType;
    private boolean ditaotFaliure;
    private String outputTitle;
    private String cancelledBy;
    private String ditaotLogFile;
    private long generatedIn;
    private String jobId;
    private long generatedTime;
    private String outputPath;
    private boolean errorsExist;
    private boolean isCancelQueued;
    private boolean isCancellable;
    private String nodePath;

    public String getOutputStatus() {
        return outputStatus;
    }

    public PublishingStatusResponseDto setOutputStatus(String outputStatus) {
        this.outputStatus = outputStatus;
        return this;
    }

    public String getOutputName() {
        return outputName;
    }

    public PublishingStatusResponseDto setOutputName(String outputName) {
        this.outputName = outputName;
        return this;
    }

    public String getOutputSetting() {
        return outputSetting;
    }

    public PublishingStatusResponseDto setOutputSetting(String outputSetting) {
        this.outputSetting = outputSetting;
        return this;
    }

    public String getInitiator() {
        return initiator;
    }

    public PublishingStatusResponseDto setInitiator(String initiator) {
        this.initiator = initiator;
        return this;
    }

    public String getOutputType() {
        return outputType;
    }

    public PublishingStatusResponseDto setOutputType(String outputType) {
        this.outputType = outputType;
        return this;
    }

    public boolean isDitaotFaliure() {
        return ditaotFaliure;
    }

    public PublishingStatusResponseDto setDitaotFaliure(boolean ditaotFaliure) {
        this.ditaotFaliure = ditaotFaliure;
        return this;
    }

    public String getOutputTitle() {
        return outputTitle;
    }

    public PublishingStatusResponseDto setOutputTitle(String outputTitle) {
        this.outputTitle = outputTitle;
        return this;
    }

    public String getCancelledBy() {
        return cancelledBy;
    }

    public PublishingStatusResponseDto setCancelledBy(String cancelledBy) {
        this.cancelledBy = cancelledBy;
        return this;
    }

    public String getDitaotLogFile() {
        return ditaotLogFile;
    }

    public PublishingStatusResponseDto setDitaotLogFile(String ditaotLogFile) {
        this.ditaotLogFile = ditaotLogFile;
        return this;
    }

    public long getGeneratedIn() {
        return generatedIn;
    }

    public PublishingStatusResponseDto setGeneratedIn(long generatedIn) {
        this.generatedIn = generatedIn;
        return this;
    }

    public String getJobId() {
        return jobId;
    }

    public PublishingStatusResponseDto setJobId(String jobId) {
        this.jobId = jobId;
        return this;
    }

    public long getGeneratedTime() {
        return generatedTime;
    }

    public PublishingStatusResponseDto setGeneratedTime(long generatedTime) {
        this.generatedTime = generatedTime;
        return this;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public PublishingStatusResponseDto setOutputPath(String outputPath) {
        this.outputPath = outputPath;
        return this;
    }

    public boolean isErrorsExist() {
        return errorsExist;
    }

    public PublishingStatusResponseDto setErrorsExist(boolean errorsExist) {
        this.errorsExist = errorsExist;
        return this;
    }

    public boolean isCancelQueued() {
        return isCancelQueued;
    }

    public PublishingStatusResponseDto setCancelQueued(boolean cancelQueued) {
        isCancelQueued = cancelQueued;
        return this;
    }

    public boolean isCancellable() {
        return isCancellable;
    }

    public PublishingStatusResponseDto setCancellable(boolean cancellable) {
        isCancellable = cancellable;
        return this;
    }

    public String getNodePath() {
        return nodePath;
    }

    public PublishingStatusResponseDto setNodePath(String nodePath) {
        this.nodePath = nodePath;
        return this;
    }
}
