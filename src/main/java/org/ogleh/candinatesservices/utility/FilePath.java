package org.ogleh.candinatesservices.utility;

public enum FilePath {
    CANDIDATE_FILE_PATH("/Users/mohamedogleh/Desktop/candidate"),
    PARTY_FILE_PATH("src/main/resources/static/assets/party");


    private final String filePath;

    FilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
