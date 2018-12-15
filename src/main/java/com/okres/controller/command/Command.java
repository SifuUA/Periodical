package com.okres.controller.command;

import com.sun.deploy.net.HttpRequest;

public interface Command {
    String execute(HttpRequest request);
}
