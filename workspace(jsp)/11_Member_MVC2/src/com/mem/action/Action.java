package com.mem.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	String excute(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
