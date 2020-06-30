package com.example.amigosproject;

public class imageupload {


        public String imageName;
        public String imageURL;


        public imageupload(String name, String url) {
            this.imageName = name;
            this.imageURL = url;
        }

        public String getImageName() {
            return imageName;
        }
        public String getImageURL() {
            return imageURL;
        }

}
