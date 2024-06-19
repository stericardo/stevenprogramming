package com.stevenprogramming.spring.rest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "podkubernetes")
public class StevenEnvironmentProperties {

    private String containerName;
    private String containerDescription;
    private String myNodeName;
    private String myPodNamespace;


    public String getContainerName() {
        return containerName;
    }

    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    public String getContainerDescription() {
        return containerDescription;
    }

    public void setContainerDescription(String containerDescription) {
        this.containerDescription = containerDescription;
    }

    public String getMyPodNamespace() {
        return myPodNamespace;
    }

    public void setMyPodNamespace(String myPodNamespace) {
        this.myPodNamespace = myPodNamespace;
    }

    public String getMyNodeName() {
        return myNodeName;
    }

    public void setMyNodeName(String myNodeName) {
        this.myNodeName = myNodeName;
    }
}
