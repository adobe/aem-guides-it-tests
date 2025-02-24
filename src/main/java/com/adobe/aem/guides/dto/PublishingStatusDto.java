package com.adobe.aem.guides.dto;

public class PublishingStatusDto {
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

    public PublishingStatusDto setOutputStatus(String outputStatus) {
        this.outputStatus = outputStatus;
        return this;
    }

    public String getOutputName() {
        return outputName;
    }

    public PublishingStatusDto setOutputName(String outputName) {
        this.outputName = outputName;
        return this;
    }

    public String getOutputSetting() {
        return outputSetting;
    }

    public PublishingStatusDto setOutputSetting(String outputSetting) {
        this.outputSetting = outputSetting;
        return this;
    }

    public String getInitiator() {
        return initiator;
    }

    public PublishingStatusDto setInitiator(String initiator) {
        this.initiator = initiator;
        return this;
    }

    public String getOutputType() {
        return outputType;
    }

    public PublishingStatusDto setOutputType(String outputType) {
        this.outputType = outputType;
        return this;
    }

    public boolean isDitaotFaliure() {
        return ditaotFaliure;
    }

    public PublishingStatusDto setDitaotFaliure(boolean ditaotFaliure) {
        this.ditaotFaliure = ditaotFaliure;
        return this;
    }

    public String getOutputTitle() {
        return outputTitle;
    }

    public PublishingStatusDto setOutputTitle(String outputTitle) {
        this.outputTitle = outputTitle;
        return this;
    }

    public String getCancelledBy() {
        return cancelledBy;
    }

    public PublishingStatusDto setCancelledBy(String cancelledBy) {
        this.cancelledBy = cancelledBy;
        return this;
    }

    public String getDitaotLogFile() {
        return ditaotLogFile;
    }

    public PublishingStatusDto setDitaotLogFile(String ditaotLogFile) {
        this.ditaotLogFile = ditaotLogFile;
        return this;
    }

    public long getGeneratedIn() {
        return generatedIn;
    }

    public PublishingStatusDto setGeneratedIn(long generatedIn) {
        this.generatedIn = generatedIn;
        return this;
    }

    public String getJobId() {
        return jobId;
    }

    public PublishingStatusDto setJobId(String jobId) {
        this.jobId = jobId;
        return this;
    }

    public long getGeneratedTime() {
        return generatedTime;
    }

    public PublishingStatusDto setGeneratedTime(long generatedTime) {
        this.generatedTime = generatedTime;
        return this;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public PublishingStatusDto setOutputPath(String outputPath) {
        this.outputPath = outputPath;
        return this;
    }

    public boolean isErrorsExist() {
        return errorsExist;
    }

    public PublishingStatusDto setErrorsExist(boolean errorsExist) {
        this.errorsExist = errorsExist;
        return this;
    }

    public boolean isCancelQueued() {
        return isCancelQueued;
    }

    public PublishingStatusDto setCancelQueued(boolean cancelQueued) {
        isCancelQueued = cancelQueued;
        return this;
    }

    public boolean isCancellable() {
        return isCancellable;
    }

    public PublishingStatusDto setCancellable(boolean cancellable) {
        isCancellable = cancellable;
        return this;
    }

    public String getNodePath() {
        return nodePath;
    }

    public PublishingStatusDto setNodePath(String nodePath) {
        this.nodePath = nodePath;
        return this;
    }
}
