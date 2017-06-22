package main;

import cui.CloudApp;
import domein.DomeinController;



public class StartUp {
    public static void main(String[] args) {
        new CloudApp(new DomeinController()).start();
    }

}
