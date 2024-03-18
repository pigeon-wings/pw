package com.example.pigeon_wings.factory.scope;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

import java.util.Objects;

public class BrowserScope extends SimpleThreadScope {

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object obj= super.get(name, objectFactory);
        SessionId s_id= ((RemoteWebDriver)obj).getSessionId();
        if(Objects.isNull(s_id)){
            super.remove(name);
            obj= super.get(name, objectFactory);
        }
        return obj;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }
}
