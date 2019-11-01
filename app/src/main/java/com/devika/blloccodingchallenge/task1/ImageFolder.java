package com.devika.blloccodingchallenge.task1;

class ImageFolder {

    private  String path;
    private  String FolderName;
    private int numberOfPics = 0;
    private String firstPic;

    String getPath() {
        return path;
    }

     void setPath(String path) {
        this.path = path;
    }

     String getFolderName() {
        return FolderName;
    }

     void setFolderName(String folderName) {
        FolderName = folderName;
    }

     int getNumberOfPics() {
        return numberOfPics;
    }

     void addpics(){
        this.numberOfPics++;
    }

     String getFirstPic() {
        return firstPic;
    }

     void setFirstPic(String firstPic) {
        this.firstPic = firstPic;
    }
}
