package com.GoldenApple.GoldenApple.config;

public final class ServerConfig extends Config{

    public String path;

    public ServerConfig(){
        path = new String(getPath() + "ServerConfig.yml");
    }

    public ServerConfig(String path){
        this.path = path;
    }

    public ServerConfig(boolean create, String fileName){
        path = new String(getPath() + fileName);
        create();
    }

    private void create(){

    }

}
