package com.stevenprogramming.path.structure;

import java.nio.file.Path;
import java.util.Objects;

public class POMFile {

    private String pomName;
    private String parentDirectory;
    private Path pathSource;

    public POMFile(String parentDirectory, String pomName, Path pathSource){
        this.pomName = pomName;
        this.parentDirectory = parentDirectory;
        this.setPathSource(pathSource);
    }

    public String getPomName() {
        return pomName;
    }

    public void setPomName(String pomName) {
        this.pomName = pomName;
    }

    public String getParentDirectory() {
        return parentDirectory;
    }

    public void setParentDirectory(String parentDirectory) {
        this.parentDirectory = parentDirectory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        POMFile pomFile = (POMFile) o;
        return Objects.equals(pomName, pomFile.pomName) && Objects.equals(parentDirectory, pomFile.parentDirectory) && Objects.equals(pathSource, pomFile.pathSource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pomName, parentDirectory, pathSource);
    }

    @Override
    public String toString() {
        return "POMFile{" +
                "pomName='" + pomName + '\'' +
                ", parentDirectory='" + parentDirectory + '\'' +
                '}';
    }

    public Path getPathSource() {
        return pathSource;
    }

    public void setPathSource(Path pathSource) {
        this.pathSource = pathSource;
    }
}
