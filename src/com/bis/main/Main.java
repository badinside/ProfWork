package com.bis.main;

import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Main {

	public static void main(String[] args) {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		try {
			FileReader reader = new FileReader("yourFile.js");
			Object sa = engine.eval(reader);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
