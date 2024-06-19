package com.stevenprogramming.path.structure;

import java.util.Objects;

public class Directory {

    private String directoryName;
    private String parentDirectory;

    public Directory(String directoryName, String parentDirectory){
        this.directoryName = directoryName;
        this.parentDirectory = parentDirectory;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
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
        Directory directory = (Directory) o;
        return Objects.equals(directoryName, directory.directoryName) && Objects.equals(parentDirectory, directory.parentDirectory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directoryName, parentDirectory);
    }

    @Override
    public String toString() {
        return "NEW Directory{" +
                "directoryName='" + directoryName + '\'' +
                ", parentDirectory='" + parentDirectory + '\'' +
                '}';
    }
}
